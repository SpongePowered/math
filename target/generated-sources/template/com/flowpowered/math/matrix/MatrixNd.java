package com.flowpowered.math.matrix;

import java.io.Serializable;
import java.util.Arrays;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.TrigMath;
import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.VectorNd;

public class MatrixNd implements Matrixd, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final MatrixNd IDENTITY_2 = new ImmutableIdentityMatrixN(2);
    public static final MatrixNd IDENTITY_3 = new ImmutableIdentityMatrixN(3);
    public static final MatrixNd IDENTITY_4 = new ImmutableIdentityMatrixN(4);
    private final double[][] mat;

    public MatrixNd(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Minimum matrix size is 2");
        }
        mat = new double[size][size];
        setIdentity();
    }

    public MatrixNd(Matrix2d m) {
        mat = new double[][]{
                {m.get(0, 0), m.get(0, 1)},
                {m.get(1, 0), m.get(1, 1)}
        };
    }

    public MatrixNd(Matrix3d m) {
        mat = new double[][]{
                {m.get(0, 0), m.get(0, 1), m.get(0, 2)},
                {m.get(1, 0), m.get(1, 1), m.get(1, 2)},
                {m.get(2, 0), m.get(2, 1), m.get(2, 2)}
        };
    }

    public MatrixNd(Matrix4d m) {
        mat = new double[][]{
                {m.get(0, 0), m.get(0, 1), m.get(0, 2), m.get(0, 3)},
                {m.get(1, 0), m.get(1, 1), m.get(1, 2), m.get(1, 3)},
                {m.get(2, 0), m.get(2, 1), m.get(2, 2), m.get(2, 3)},
                {m.get(3, 0), m.get(3, 1), m.get(3, 2), m.get(3, 3)}
        };
    }

    public MatrixNd(double... m) {
        if (m.length < 4) {
            throw new IllegalArgumentException("Minimum matrix size is 2");
        }
        final int size = (int) Math.ceil(Math.sqrt(m.length));
        mat = new double[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                final int index = col + row * size;
                if (index < m.length) {
                    mat[row][col] = m[index];
                } else {
                    mat[row][col] = 0;
                }
            }
        }
    }

    public MatrixNd(MatrixNd m) {
        mat = deepClone(m.mat);
    }

    public int size() {
        return mat.length;
    }

    @Override
    public double get(int row, int col) {
        return mat[row][col];
    }

    @Override
    public VectorNd getRow(int row) {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int col = 0; col < size; col++) {
            d.set(col, get(row, col));
        }
        return d;
    }

    @Override
    public VectorNd getColumn(int col) {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int row = 0; row < size; row++) {
            d.set(row, get(row, col));
        }
        return d;
    }

    public void set(int row, int col, float val) {
        set(row, col, (double) val);
    }

    public void set(int row, int col, double val) {
        mat[row][col] = val;
    }

    public final void setIdentity() {
        final int size = size();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    mat[row][col] = 1;
                } else {
                    mat[row][col] = 0;
                }
            }
        }
    }

    public void setZero() {
        final int size = size();
        for (int row = 0; row < size; row++) {
            Arrays.fill(mat[row], 0);
        }
    }

    public MatrixNd resize(int size) {
        final MatrixNd d = new MatrixNd(size);
        for (int rowCol = size(); rowCol < size; rowCol++) {
            d.set(rowCol, rowCol, 0);
        }
        size = Math.min(size, size());
        for (int row = 0; row < size; row++) {
            System.arraycopy(mat[row], 0, d.mat[row], 0, size);
        }
        return d;
    }

    public MatrixNd add(MatrixNd m) {
        final int size = size();
        if (size != m.size()) {
            throw new IllegalArgumentException("Matrix sizes must be the same");
        }
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = mat[row][col] + m.mat[row][col];
            }
        }
        return d;
    }

    public MatrixNd sub(MatrixNd m) {
        final int size = size();
        if (size != m.size()) {
            throw new IllegalArgumentException("Matrix sizes must be the same");
        }
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = mat[row][col] - m.mat[row][col];
            }
        }
        return d;
    }

    public MatrixNd mul(float a) {
        return mul((double) a);
    }

    @Override
    public MatrixNd mul(double a) {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = mat[row][col] * a;
            }
        }
        return d;
    }

    public MatrixNd mul(MatrixNd m) {
        final int size = size();
        if (size != m.size()) {
            throw new IllegalArgumentException("Matrix sizes must be the same");
        }
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                double dot = 0;
                for (int i = 0; i < size; i++) {
                    dot += mat[row][i] * m.mat[i][col];
                }
                d.mat[row][col] = dot;
            }
        }
        return d;
    }

    public MatrixNd div(float a) {
        return div((double) a);
    }

    @Override
    public MatrixNd div(double a) {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = mat[row][col] / a;
            }
        }
        return d;
    }

    public MatrixNd div(MatrixNd m) {
        return mul(m.invert());
    }

    public MatrixNd pow(float pow) {
        return pow((double) pow);
    }

    @Override
    public MatrixNd pow(double pow) {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = (double) Math.pow(mat[row][col], pow);
            }
        }
        return d;
    }

    public MatrixNd translate(VectorNd v) {
        return translate(v.toArray());
    }

    public MatrixNd translate(double... v) {
        return createTranslation(v).mul(this);
    }

    public MatrixNd scale(VectorNd v) {
        return scale(v.toArray());
    }

    public MatrixNd scale(double... v) {
        return createScaling(v).mul(this);
    }

    public MatrixNd rotate(Complexd rot) {
        return createRotation(size(), rot).mul(this);
    }

    public MatrixNd rotate(Quaterniond rot) {
        return createRotation(size(), rot).mul(this);
    }

    public VectorNd transform(VectorNd v) {
        return transform(v.toArray());
    }

    public VectorNd transform(double... vec) {
        final int size = size();
        if (size != vec.length) {
            throw new IllegalArgumentException("Matrix and vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int row = 0; row < size; row++) {
            double dot = 0;
            for (int col = 0; col < size; col++) {
                dot += mat[row][col] * vec[col];
            }
            d.set(row, dot);
        }
        return d;
    }

    @Override
    public MatrixNd floor() {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = GenericMath.floor(mat[row][col]);
            }
        }
        return d;
    }

    @Override
    public MatrixNd ceil() {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = (double) Math.ceil(mat[row][col]);
            }
        }
        return d;
    }

    @Override
    public MatrixNd round() {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = Math.round(mat[row][col]);
            }
        }
        return d;
    }

    @Override
    public MatrixNd abs() {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = Math.abs(mat[row][col]);
            }
        }
        return d;
    }

    @Override
    public MatrixNd negate() {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = -mat[row][col];
            }
        }
        return d;
    }

    @Override
    public MatrixNd transpose() {
        final int size = size();
        final MatrixNd d = new MatrixNd(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                d.mat[row][col] = mat[col][row];
            }
        }
        return d;
    }

    @Override
    public double trace() {
        final int size = size();
        double trace = 0;
        for (int rowCol = 0; rowCol < size; rowCol++) {
            trace += mat[rowCol][rowCol];
        }
        return trace;
    }

    @Override
    public double determinant() {
        final int size = size();
        final double[][] m = deepClone(mat);
        double det;
        for (int i = 0; i < size - 1; i++) {
            for (int col = i + 1; col < size; col++) {
                det = m[i][i] < GenericMath.DBL_EPSILON ? 0 : m[i][col] / m[i][i];
                for (int row = i; row < size; row++) {
                    m[row][col] -= det * m[row][i];
                }
            }
        }
        det = 1;
        for (int i = 0; i < size; i++) {
            det *= m[i][i];
        }
        return det;
    }

    @Override
    public MatrixNd invert() {
        if (Math.abs(determinant()) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot inverse a matrix with a zero determinant");
        }
        final int size = size();
        final AugmentedMatrixN augMat = new AugmentedMatrixN(this);
        final int augmentedSize = augMat.getAugmentedSize();
        for (int i = 0; i < size; i++) {
            for (int row = 0; row < size; row++) {
                if (i != row) {
                    final double ratio = augMat.get(row, i) / augMat.get(i, i);
                    for (int col = 0; col < augmentedSize; col++) {
                        augMat.set(row, col, augMat.get(row, col) - ratio * augMat.get(i, col));
                    }
                }
            }
        }
        for (int row = 0; row < size; row++) {
            final double div = augMat.get(row, row);
            for (int col = 0; col < augmentedSize; col++) {
                augMat.set(row, col, augMat.get(row, col) / div);
            }
        }
        return augMat.getAugmentation();
    }

    public Matrix2d toMatrix2() {
        return new Matrix2d(this);
    }

    public Matrix3d toMatrix3() {
        return new Matrix3d(this);
    }

    public Matrix4d toMatrix4() {
        return new Matrix4d(this);
    }

    public double[] toArray() {
        return toArray(false);
    }

    @Override
    public MatrixNf toFloat() {
        final int size = size();
        final float[] m = new float[size * size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                m[col + row * size] = (float) get(row, col);
            }
        }
        return new MatrixNf(m);
    }

    @Override
    public MatrixNd toDouble() {
        final int size = size();
        final double[] m = new double[size * size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                m[col + row * size] = (double) get(row, col);
            }
        }
        return new MatrixNd(m);
    }

    @Override
    public double[] toArray(boolean columnMajor) {
        final int size = size();
        final double[] array = new double[size * size];
        if (columnMajor) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    array[row + col * size] = mat[row][col];
                }
            }
        } else {
            for (int row = 0; row < size; row++) {
                System.arraycopy(mat[row], 0, array, row * size, size);
            }
        }
        return array;
    }

    @Override
    public String toString() {
        final int size = size();
        final StringBuilder builder = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                builder.append(mat[row][col]);
                if (col < size - 1) {
                    builder.append(' ');
                }
            }
            if (row < size - 1) {
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatrixNd)) {
            return false;
        }
        return Arrays.deepEquals(mat, ((MatrixNd) obj).mat);
    }

    @Override
    public int hashCode() {
        return 79 * 5 + Arrays.deepHashCode(mat);
    }

    @Override
    public MatrixNd clone() {
        return new MatrixNd(this);
    }

    public static MatrixNd createScaling(VectorNd v) {
        return createScaling(v.toArray());
    }

    public static MatrixNd createScaling(double... vec) {
        final int size = vec.length;
        final MatrixNd m = new MatrixNd(size);
        for (int rowCol = 0; rowCol < size; rowCol++) {
            m.set(rowCol, rowCol, vec[rowCol]);
        }
        return m;
    }

    public static MatrixNd createTranslation(VectorNd v) {
        return createTranslation(v.toArray());
    }

    public static MatrixNd createTranslation(double... vec) {
        final int size = vec.length;
        final MatrixNd m = new MatrixNd(size + 1);
        for (int row = 0; row < size; row++) {
            m.set(row, size, vec[row]);
        }
        return m;
    }

    public static MatrixNd createRotation(int size, Complexd rot) {
        if (size < 2) {
            throw new IllegalArgumentException("Minimum matrix size is 2");
        }
        final MatrixNd m = new MatrixNd(size);
        rot = rot.normalize();
        m.set(0, 0, rot.getX());
        m.set(0, 1, -rot.getY());
        m.set(1, 0, rot.getY());
        m.set(1, 1, rot.getX());
        return m;
    }

    public static MatrixNd createRotation(int size, Quaterniond rot) {
        if (size < 3) {
            throw new IllegalArgumentException("Minimum matrix size is 3");
        }
        final MatrixNd m = new MatrixNd(size);
        rot = rot.normalize();
        m.set(0, 0, 1 - 2 * rot.getY() * rot.getY() - 2 * rot.getZ() * rot.getZ());
        m.set(0, 1, 2 * rot.getX() * rot.getY() - 2 * rot.getW() * rot.getZ());
        m.set(0, 2, 2 * rot.getX() * rot.getZ() + 2 * rot.getW() * rot.getY());
        m.set(1, 0, 2 * rot.getX() * rot.getY() + 2 * rot.getW() * rot.getZ());
        m.set(1, 1, 1 - 2 * rot.getX() * rot.getX() - 2 * rot.getZ() * rot.getZ());
        m.set(1, 2, 2 * rot.getY() * rot.getZ() - 2 * rot.getW() * rot.getX());
        m.set(2, 0, 2 * rot.getX() * rot.getZ() - 2 * rot.getW() * rot.getY());
        m.set(2, 1, 2 * rot.getY() * rot.getZ() + 2 * rot.getX() * rot.getW());
        m.set(2, 2, 1 - 2 * rot.getX() * rot.getX() - 2 * rot.getY() * rot.getY());
        return m;
    }

    /**
     * Creates a "look at" matrix for the given eye point.
     *
     * @param size The size of the matrix, minimum of 4
     * @param eye The position of the camera
     * @param at The point that the camera is looking at
     * @param up The "up" vector
     * @return A rotational transform that corresponds to a camera looking at the given point
     */
    public static MatrixNd createLookAt(int size, Vector3d eye, Vector3d at, Vector3d up) {
        if (size < 4) {
            throw new IllegalArgumentException("Minimum matrix size is 4");
        }
        final Vector3d f = at.sub(eye).normalize();
        up = up.normalize();
        final Vector3d s = f.cross(up).normalize();
        final Vector3d u = s.cross(f).normalize();
        final MatrixNd mat = new MatrixNd(size);
        mat.set(0, 0, s.getX());
        mat.set(0, 1, s.getY());
        mat.set(0, 2, s.getZ());
        mat.set(1, 0, u.getX());
        mat.set(1, 1, u.getY());
        mat.set(1, 2, u.getZ());
        mat.set(2, 0, -f.getX());
        mat.set(2, 1, -f.getY());
        mat.set(2, 2, -f.getZ());
        return mat.translate(eye.mul(-1).toVectorN());
    }

    /**
     * Creates a perspective projection matrix with the given (x) FOV, aspect, near and far planes
     *
     * @param size The size of the matrix, minimum of 4
     * @param fov The field of view in the x direction
     * @param aspect The aspect ratio, usually width/height
     * @param near The near plane, cannot be 0
     * @param far the far plane, zFar cannot equal zNear
     * @return A perspective projection matrix built from the given values
     */
    public static MatrixNd createPerspective(int size, float fov, float aspect, float near, float far) {
        return createPerspective(size, (double) fov, (double) aspect, (double) near, (double) far);
    }

    /**
     * Creates a perspective projection matrix with the given (x) FOV, aspect, near and far planes
     *
     * @param size The size of the matrix, minimum of 4
     * @param fov The field of view in the x direction
     * @param aspect The aspect ratio, usually width/height
     * @param near The near plane, cannot be 0
     * @param far the far plane, zFar cannot equal zNear
     * @return A perspective projection matrix built from the given values
     */
    public static MatrixNd createPerspective(int size, double fov, double aspect, double near, double far) {
        if (size < 4) {
            throw new IllegalArgumentException("Minimum matrix size is 4");
        }
        final MatrixNd perspective = new MatrixNd(size);
        final double scale = 1 / TrigMath.tan(fov * (double) TrigMath.HALF_DEG_TO_RAD);
        perspective.set(0, 0, scale / aspect);
        perspective.set(1, 1, scale);
        perspective.set(2, 2, (far + near) / (near - far));
        perspective.set(2, 3, 2 * far * near / (near - far));
        perspective.set(3, 2, -1);
        perspective.set(3, 3, 0);
        return perspective;
    }

    /**
     * Creates an orthographic viewing frustum built from the provided values
     *
     * @param size The size of the matrix, minimum of 4
     * @param right the right most plane of the viewing frustum
     * @param left the left most plane of the viewing frustum
     * @param top the top plane of the viewing frustum
     * @param bottom the bottom plane of the viewing frustum
     * @param near the near plane of the viewing frustum
     * @param far the far plane of the viewing frustum
     * @return A viewing frustum built from the provided values
     */
    public static MatrixNd createOrthographic(int size, float right, float left, float top, float bottom,
                                             float near, float far) {
        return createOrthographic(size, (double) right, (double) left, (double) top, (double) bottom, (double) near, (double) far);
    }

    /**
     * Creates an orthographic viewing frustum built from the provided values
     *
     * @param size The size of the matrix, minimum of 4
     * @param right the right most plane of the viewing frustum
     * @param left the left most plane of the viewing frustum
     * @param top the top plane of the viewing frustum
     * @param bottom the bottom plane of the viewing frustum
     * @param near the near plane of the viewing frustum
     * @param far the far plane of the viewing frustum
     * @return A viewing frustum built from the provided values
     */
    public static MatrixNd createOrthographic(int size, double right, double left, double top, double bottom,
                                             double near, double far) {
        if (size < 4) {
            throw new IllegalArgumentException("Minimum matrix size is 4");
        }
        final MatrixNd orthographic = new MatrixNd(size);
        orthographic.set(0, 0, 2 / (right - left));
        orthographic.set(1, 1, 2 / (top - bottom));
        orthographic.set(2, 2, -2 / (far - near));
        orthographic.set(0, 3, -(right + left) / (right - left));
        orthographic.set(1, 3, -(top + bottom) / (top - bottom));
        orthographic.set(2, 3, -(far + near) / (far - near));
        return orthographic;
    }

    private static double[][] deepClone(double[][] array) {
        final int size = array.length;
        final double[][] clone = array.clone();
        for (int i = 0; i < size; i++) {
            clone[i] = array[i].clone();
        }
        return clone;
    }

    private static class ImmutableIdentityMatrixN extends MatrixNd {
        public ImmutableIdentityMatrixN(int size) {
            super(size);
        }

        @Override
        public void set(int row, int col, double val) {
            throw new UnsupportedOperationException("You may not alter this matrix");
        }

        @Override
        public void setZero() {
            throw new UnsupportedOperationException("You may not alter this matrix");
        }
    }

    private static class AugmentedMatrixN {
        private final MatrixNd mat;
        private final MatrixNd aug;
        private final int size;

        private AugmentedMatrixN(MatrixNd mat) {
            this.mat = mat.clone();
            this.size = mat.size();
            aug = new MatrixNd(size);
        }

        private MatrixNd getAugmentation() {
            return aug;
        }

        private int getAugmentedSize() {
            return size * 2;
        }

        private double get(int row, int col) {
            if (col < size) {
                return mat.get(row, col);
            } else {
                return aug.get(row, col - size);
            }
        }

        private void set(int row, int col, double val) {
            if (col < size) {
                mat.set(row, col, val);
            } else {
                aug.set(row, col - size, val);
            }
        }
    }
}
