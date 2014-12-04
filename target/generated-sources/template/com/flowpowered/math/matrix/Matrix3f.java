package com.flowpowered.math.matrix;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;

public class Matrix3f implements Matrixf, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Matrix3f ZERO = new Matrix3f(
            0, 0, 0,
            0, 0, 0,
            0, 0, 0);
    public static final Matrix3f IDENTITY = new Matrix3f();
    private final float m00, m01, m02;
    private final float m10, m11, m12;
    private final float m20, m21, m22;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Matrix3f() {
        this(
                1, 0, 0,
                0, 1, 0,
                0, 0, 1);
    }

    public Matrix3f(Matrix2f m) {
        this(
                m.get(0, 0), m.get(0, 1), 0,
                m.get(1, 0), m.get(1, 1), 0,
                0, 0, 0);
    }

    public Matrix3f(Matrix3f m) {
        this(
                m.m00, m.m01, m.m02,
                m.m10, m.m11, m.m12,
                m.m20, m.m21, m.m22);
    }

    public Matrix3f(Matrix4f m) {
        this(
                m.get(0, 0), m.get(0, 1), m.get(0, 2),
                m.get(1, 0), m.get(1, 1), m.get(1, 2),
                m.get(2, 0), m.get(2, 1), m.get(2, 2));
    }

    public Matrix3f(MatrixNf m) {
        m00 = m.get(0, 0);
        m01 = m.get(0, 1);
        m10 = m.get(1, 0);
        m11 = m.get(1, 1);
        if (m.size() > 2) {
            m02 = m.get(0, 2);
            m12 = m.get(1, 2);
            m20 = m.get(2, 0);
            m21 = m.get(2, 1);
            m22 = m.get(2, 2);
        } else {
            m02 = 0;
            m12 = 0;
            m20 = 0;
            m21 = 0;
            m22 = 0;
        }
    }

    public Matrix3f(
            double m00, double m01, double m02,
            double m10, double m11, double m12,
            double m20, double m21, double m22) {
        this(
                (float) m00, (float) m01, (float) m02,
                (float) m10, (float) m11, (float) m12,
                (float) m20, (float) m21, (float) m22);
    }

    public Matrix3f(
            float m00, float m01, float m02,
            float m10, float m11, float m12,
            float m20, float m21, float m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }

    @Override
    public float get(int row, int col) {
        switch (row) {
        case 0:
            switch (col) {
            case 0:
                return m00;
            case 1:
                return m01;
            case 2:
                return m02;
            }
        case 1:
            switch (col) {
            case 0:
                return m10;
            case 1:
                return m11;
            case 2:
                return m12;
            }
        case 2:
            switch (col) {
            case 0:
                return m20;
            case 1:
                return m21;
            case 2:
                return m22;
            }
        }
        throw new IllegalArgumentException(
                (row < 0 || row > 2 ? "row must be greater than zero and smaller than 3. " : "") +
                (col < 0 || col > 2 ? "col must be greater than zero and smaller than 3." : ""));
    }

    @Override
    public Vector3f getRow(int row) {
        return new Vector3f(get(row, 0), get(row, 1), get(row, 2));
    }

    @Override
    public Vector3f getColumn(int col) {
        return new Vector3f(get(0, col), get(1, col), get(2, col));
    }

    public Matrix3f add(Matrix3f m) {
        return new Matrix3f(
                m00 + m.m00, m01 + m.m01, m02 + m.m02,
                m10 + m.m10, m11 + m.m11, m12 + m.m12,
                m20 + m.m20, m21 + m.m21, m22 + m.m22);
    }

    public Matrix3f sub(Matrix3f m) {
        return new Matrix3f(
                m00 - m.m00, m01 - m.m01, m02 - m.m02,
                m10 - m.m10, m11 - m.m11, m12 - m.m12,
                m20 - m.m20, m21 - m.m21, m22 - m.m22);
    }

    public Matrix3f mul(double a) {
        return mul((float) a);
    }

    @Override
    public Matrix3f mul(float a) {
        return new Matrix3f(
                m00 * a, m01 * a, m02 * a,
                m10 * a, m11 * a, m12 * a,
                m20 * a, m21 * a, m22 * a);
    }

    public Matrix3f mul(Matrix3f m) {
        return new Matrix3f(
                m00 * m.m00 + m01 * m.m10 + m02 * m.m20, m00 * m.m01 + m01 * m.m11 + m02 * m.m21,
                m00 * m.m02 + m01 * m.m12 + m02 * m.m22, m10 * m.m00 + m11 * m.m10 + m12 * m.m20,
                m10 * m.m01 + m11 * m.m11 + m12 * m.m21, m10 * m.m02 + m11 * m.m12 + m12 * m.m22,
                m20 * m.m00 + m21 * m.m10 + m22 * m.m20, m20 * m.m01 + m21 * m.m11 + m22 * m.m21,
                m20 * m.m02 + m21 * m.m12 + m22 * m.m22);
    }

    public Matrix3f div(double a) {
        return div((float) a);
    }

    @Override
    public Matrix3f div(float a) {
        return new Matrix3f(
                m00 / a, m01 / a, m02 / a,
                m10 / a, m11 / a, m12 / a,
                m20 / a, m21 / a, m22 / a);
    }

    public Matrix3f div(Matrix3f m) {
        return mul(m.invert());
    }

    public Matrix3f pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public Matrix3f pow(float pow) {
        return new Matrix3f(
                Math.pow(m00, pow), Math.pow(m01, pow), Math.pow(m02, pow),
                Math.pow(m10, pow), Math.pow(m11, pow), Math.pow(m12, pow),
                Math.pow(m20, pow), Math.pow(m21, pow), Math.pow(m22, pow));
    }

    public Matrix3f translate(Vector2f v) {
        return translate(v.getX(), v.getY());
    }

    public Matrix3f translate(double x, double y) {
        return translate((float) x, (float) y);
    }

    public Matrix3f translate(float x, float y) {
        return createTranslation(x, y).mul(this);
    }

    public Matrix3f scale(double scale) {
        return scale((float) scale);
    }

    public Matrix3f scale(float scale) {
        return scale(scale, scale, scale);
    }

    public Matrix3f scale(Vector3f v) {
        return scale(v.getX(), v.getY(), v.getZ());
    }

    public Matrix3f scale(double x, double y, double z) {
        return scale((float) x, (float) y, (float) z);
    }

    public Matrix3f scale(float x, float y, float z) {
        return createScaling(x, y, z).mul(this);
    }

    public Matrix3f rotate(Complexf rot) {
        return createRotation(rot).mul(this);
    }

    public Matrix3f rotate(Quaternionf rot) {
        return createRotation(rot).mul(this);
    }

    public Vector3f transform(Vector3f v) {
        return transform(v.getX(), v.getY(), v.getZ());
    }

    public Vector3f transform(double x, double y, double z) {
        return transform((float) x, (float) y, (float) z);
    }

    public Vector3f transform(float x, float y, float z) {
        return new Vector3f(
                m00 * x + m01 * y + m02 * z,
                m10 * x + m11 * y + m12 * z,
                m20 * x + m21 * y + m22 * z);
    }

    @Override
    public Matrix3f floor() {
        return new Matrix3f(
                GenericMath.floor(m00), GenericMath.floor(m01), GenericMath.floor(m02),
                GenericMath.floor(m10), GenericMath.floor(m11), GenericMath.floor(m12),
                GenericMath.floor(m20), GenericMath.floor(m21), GenericMath.floor(m22));
    }

    @Override
    public Matrix3f ceil() {
        return new Matrix3f(
                Math.ceil(m00), Math.ceil(m01), Math.ceil(m02),
                Math.ceil(m10), Math.ceil(m11), Math.ceil(m12),
                Math.ceil(m20), Math.ceil(m21), Math.ceil(m22));
    }

    @Override
    public Matrix3f round() {
        return new Matrix3f(
                Math.round(m00), Math.round(m01), Math.round(m02),
                Math.round(m10), Math.round(m11), Math.round(m12),
                Math.round(m20), Math.round(m21), Math.round(m22));
    }

    @Override
    public Matrix3f abs() {
        return new Matrix3f(
                Math.abs(m00), Math.abs(m01), Math.abs(m02),
                Math.abs(m10), Math.abs(m11), Math.abs(m12),
                Math.abs(m20), Math.abs(m21), Math.abs(m22));
    }

    @Override
    public Matrix3f negate() {
        return new Matrix3f(
                -m00, -m01, -m02,
                -m10, -m11, -m12,
                -m20, -m21, -m22);
    }

    @Override
    public Matrix3f transpose() {
        return new Matrix3f(
                m00, m10, m20,
                m01, m11, m21,
                m02, m12, m22);
    }

    @Override
    public float trace() {
        return m00 + m11 + m22;
    }

    @Override
    public float determinant() {
        return m00 * (m11 * m22 - m12 * m21) - m01 * (m10 * m22 - m12 * m20) + m02 * (m10 * m21 - m11 * m20);
    }

    @Override
    public Matrix3f invert() {
        final float det = determinant();
        if (Math.abs(det) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot inverse a matrix with a zero determinant");
        }
        return new Matrix3f(
                (m11 * m22 - m21 * m12) / det, -(m01 * m22 - m21 * m02) / det, (m01 * m12 - m02 * m11) / det,
                -(m10 * m22 - m20 * m12) / det, (m00 * m22 - m20 * m02) / det, -(m00 * m12 - m10 * m02) / det,
                (m10 * m21 - m20 * m11) / det, -(m00 * m21 - m20 * m01) / det, (m00 * m11 - m01 * m10) / det);
    }

    public Matrix2f toMatrix2() {
        return new Matrix2f(this);
    }

    public Matrix4f toMatrix4() {
        return new Matrix4f(this);
    }

    public MatrixNf toMatrixN() {
        return new MatrixNf(this);
    }

    public float[] toArray() {
        return toArray(false);
    }

    @Override
    public float[] toArray(boolean columnMajor) {
        if (columnMajor) {
            return new float[]{
                    m00, m10, m20,
                    m01, m11, m21,
                    m02, m12, m22
            };
        } else {
            return new float[]{
                    m00, m01, m02,
                    m10, m11, m12,
                    m20, m21, m22
            };
        }
    }

    @Override
    public Matrix3f toFloat() {
        return new Matrix3f(
                m00, m01, m02,
                m10, m11, m12,
                m20, m21, m22
        );
    }

    @Override
    public Matrix3d toDouble() {
        return new Matrix3d(
                m00, m01, m02,
                m10, m11, m12,
                m20, m21, m22
        );
    }

    @Override
    public String toString() {
        return m00 + " " + m01 + " " + m02 + "\n"
                + m10 + " " + m11 + " " + m12 + "\n"
                + m20 + " " + m21 + " " + m22 + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Matrix3f)) {
            return false;
        }
        final Matrix3f matrix3 = (Matrix3f) o;
        if (Float.compare(matrix3.m00, m00) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m01, m01) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m02, m02) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m10, m10) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m11, m11) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m12, m12) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m20, m20) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m21, m21) != 0) {
            return false;
        }
        if (Float.compare(matrix3.m22, m22) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            int result = (m00 != +0.0f ? HashFunctions.hash(m00) : 0);
            result = 31 * result + (m01 != +0.0f ? HashFunctions.hash(m01) : 0);
            result = 31 * result + (m02 != +0.0f ? HashFunctions.hash(m02) : 0);
            result = 31 * result + (m10 != +0.0f ? HashFunctions.hash(m10) : 0);
            result = 31 * result + (m11 != +0.0f ? HashFunctions.hash(m11) : 0);
            result = 31 * result + (m12 != +0.0f ? HashFunctions.hash(m12) : 0);
            result = 31 * result + (m20 != +0.0f ? HashFunctions.hash(m20) : 0);
            result = 31 * result + (m21 != +0.0f ? HashFunctions.hash(m21) : 0);
            hashCode = 31 * result + (m22 != +0.0f ? HashFunctions.hash(m22) : 0);
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public Matrix3f clone() {
        return new Matrix3f(this);
    }

    public static Matrix3f createScaling(double scale) {
        return createScaling((float) scale);
    }

    public static Matrix3f createScaling(float scale) {
        return createScaling(scale, scale, scale);
    }

    public static Matrix3f createScaling(Vector3f v) {
        return createScaling(v.getX(), v.getY(), v.getZ());
    }

    public static Matrix3f createScaling(double x, double y, double z) {
        return createScaling((float) x, (float) y, (float) z);
    }

    public static Matrix3f createScaling(float x, float y, float z) {
        return new Matrix3f(
                x, 0, 0,
                0, y, 0,
                0, 0, z);
    }

    public static Matrix3f createTranslation(Vector2f v) {
        return createTranslation(v.getX(), v.getY());
    }

    public static Matrix3f createTranslation(double x, double y) {
        return createTranslation((float) x, (float) y);
    }

    public static Matrix3f createTranslation(float x, float y) {
        return new Matrix3f(
                1, 0, x,
                0, 1, y,
                0, 0, 1);
    }

    public static Matrix3f createRotation(Complexf rot) {
        rot = rot.normalize();
        return new Matrix3f(
                rot.getX(), -rot.getY(), 0,
                rot.getY(), rot.getX(), 0,
                0, 0, 1);
    }

    public static Matrix3f createRotation(Quaternionf rot) {
        rot = rot.normalize();
        return new Matrix3f(
                1 - 2 * rot.getY() * rot.getY() - 2 * rot.getZ() * rot.getZ(),
                2 * rot.getX() * rot.getY() - 2 * rot.getW() * rot.getZ(),
                2 * rot.getX() * rot.getZ() + 2 * rot.getW() * rot.getY(),
                2 * rot.getX() * rot.getY() + 2 * rot.getW() * rot.getZ(),
                1 - 2 * rot.getX() * rot.getX() - 2 * rot.getZ() * rot.getZ(),
                2 * rot.getY() * rot.getZ() - 2 * rot.getW() * rot.getX(),
                2 * rot.getX() * rot.getZ() - 2 * rot.getW() * rot.getY(),
                2 * rot.getY() * rot.getZ() + 2 * rot.getX() * rot.getW(),
                1 - 2 * rot.getX() * rot.getX() - 2 * rot.getY() * rot.getY());
    }
}
