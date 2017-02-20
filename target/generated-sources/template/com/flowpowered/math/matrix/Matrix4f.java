package com.flowpowered.math.matrix;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.TrigMath;
import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;

public class Matrix4f implements Matrixf, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Matrix4f ZERO = new Matrix4f(
            0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0);
    public static final Matrix4f IDENTITY = new Matrix4f();
    private final float m00, m01, m02, m03;
    private final float m10, m11, m12, m13;
    private final float m20, m21, m22, m23;
    private final float m30, m31, m32, m33;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Matrix4f() {
        this(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    public Matrix4f(Matrix2f m) {
        this(
                m.get(0, 0), m.get(0, 1), 0, 0,
                m.get(1, 0), m.get(1, 1), 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
    }

    public Matrix4f(Matrix3f m) {
        this(
                m.get(0, 0), m.get(0, 1), m.get(0, 2), 0,
                m.get(1, 0), m.get(1, 1), m.get(1, 2), 0,
                m.get(2, 0), m.get(2, 1), m.get(2, 2), 0,
                0, 0, 0, 0);
    }

    public Matrix4f(Matrix4f m) {
        this(
                m.m00, m.m01, m.m02, m.m03,
                m.m10, m.m11, m.m12, m.m13,
                m.m20, m.m21, m.m22, m.m23,
                m.m30, m.m31, m.m32, m.m33);
    }

    public Matrix4f(MatrixNf m) {
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
            if (m.size() > 3) {
                m03 = m.get(0, 3);
                m13 = m.get(1, 3);
                m23 = m.get(2, 3);
                m30 = m.get(3, 0);
                m31 = m.get(3, 1);
                m32 = m.get(3, 2);
                m33 = m.get(3, 3);
            } else {
                m03 = 0;
                m13 = 0;
                m23 = 0;
                m30 = 0;
                m31 = 0;
                m32 = 0;
                m33 = 0;
            }
        } else {
            m02 = 0;
            m12 = 0;
            m20 = 0;
            m21 = 0;
            m22 = 0;
            m03 = 0;
            m13 = 0;
            m23 = 0;
            m30 = 0;
            m31 = 0;
            m32 = 0;
            m33 = 0;
        }
    }

    public Matrix4f(
            double m00, double m01, double m02, double m03,
            double m10, double m11, double m12, double m13,
            double m20, double m21, double m22, double m23,
            double m30, double m31, double m32, double m33) {
        this(
                (float) m00, (float) m01, (float) m02, (float) m03,
                (float) m10, (float) m11, (float) m12, (float) m13,
                (float) m20, (float) m21, (float) m22, (float) m23,
                (float) m30, (float) m31, (float) m32, (float) m33);
    }

    public Matrix4f(
            float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
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
            case 3:
                return m03;
            }
        case 1:
            switch (col) {
            case 0:
                return m10;
            case 1:
                return m11;
            case 2:
                return m12;
            case 3:
                return m13;
            }
        case 2:
            switch (col) {
            case 0:
                return m20;
            case 1:
                return m21;
            case 2:
                return m22;
            case 3:
                return m23;
            }
        case 3:
            switch (col) {
            case 0:
                return m30;
            case 1:
                return m31;
            case 2:
                return m32;
            case 3:
                return m33;
            }
        }
        throw new IllegalArgumentException(
                (row < 0 || row > 2 ? "row must be greater than zero and smaller than 3. " : "") +
                (col < 0 || col > 2 ? "col must be greater than zero and smaller than 3." : ""));
    }

    @Override
    public Vector4f getRow(int row) {
        return new Vector4f(get(row, 0), get(row, 1), get(row, 2), get(row, 3));
    }

    @Override
    public Vector4f getColumn(int col) {
        return new Vector4f(get(0, col), get(1, col), get(2, col), get(3, col));
    }

    public Matrix4f add(Matrix4f m) {
        return new Matrix4f(
                m00 + m.m00, m01 + m.m01, m02 + m.m02, m03 + m.m03,
                m10 + m.m10, m11 + m.m11, m12 + m.m12, m13 + m.m13,
                m20 + m.m20, m21 + m.m21, m22 + m.m22, m23 + m.m23,
                m30 + m.m30, m31 + m.m31, m32 + m.m32, m33 + m.m33);
    }

    public Matrix4f sub(Matrix4f m) {
        return new Matrix4f(
                m00 - m.m00, m01 - m.m01, m02 - m.m02, m03 - m.m03,
                m10 - m.m10, m11 - m.m11, m12 - m.m12, m13 - m.m13,
                m20 - m.m20, m21 - m.m21, m22 - m.m22, m23 - m.m23,
                m30 - m.m30, m31 - m.m31, m32 - m.m32, m33 - m.m33);
    }

    public Matrix4f mul(double a) {
        return mul((float) a);
    }

    @Override
    public Matrix4f mul(float a) {
        return new Matrix4f(
                m00 * a, m01 * a, m02 * a, m03 * a,
                m10 * a, m11 * a, m12 * a, m13 * a,
                m20 * a, m21 * a, m22 * a, m23 * a,
                m30 * a, m31 * a, m32 * a, m33 * a);
    }

    public Matrix4f mul(Matrix4f m) {
        return new Matrix4f(
                m00 * m.m00 + m01 * m.m10 + m02 * m.m20 + m03 * m.m30,
                m00 * m.m01 + m01 * m.m11 + m02 * m.m21 + m03 * m.m31,
                m00 * m.m02 + m01 * m.m12 + m02 * m.m22 + m03 * m.m32,
                m00 * m.m03 + m01 * m.m13 + m02 * m.m23 + m03 * m.m33,
                m10 * m.m00 + m11 * m.m10 + m12 * m.m20 + m13 * m.m30,
                m10 * m.m01 + m11 * m.m11 + m12 * m.m21 + m13 * m.m31,
                m10 * m.m02 + m11 * m.m12 + m12 * m.m22 + m13 * m.m32,
                m10 * m.m03 + m11 * m.m13 + m12 * m.m23 + m13 * m.m33,
                m20 * m.m00 + m21 * m.m10 + m22 * m.m20 + m23 * m.m30,
                m20 * m.m01 + m21 * m.m11 + m22 * m.m21 + m23 * m.m31,
                m20 * m.m02 + m21 * m.m12 + m22 * m.m22 + m23 * m.m32,
                m20 * m.m03 + m21 * m.m13 + m22 * m.m23 + m23 * m.m33,
                m30 * m.m00 + m31 * m.m10 + m32 * m.m20 + m33 * m.m30,
                m30 * m.m01 + m31 * m.m11 + m32 * m.m21 + m33 * m.m31,
                m30 * m.m02 + m31 * m.m12 + m32 * m.m22 + m33 * m.m32,
                m30 * m.m03 + m31 * m.m13 + m32 * m.m23 + m33 * m.m33);
    }

    public Matrix4f div(double a) {
        return div((float) a);
    }

    @Override
    public Matrix4f div(float a) {
        return new Matrix4f(
                m00 / a, m01 / a, m02 / a, m03 / a,
                m10 / a, m11 / a, m12 / a, m13 / a,
                m20 / a, m21 / a, m22 / a, m23 / a,
                m30 / a, m31 / a, m32 / a, m33 / a);
    }

    public Matrix4f div(Matrix4f m) {
        return mul(m.invert());
    }

    public Matrix4f pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public Matrix4f pow(float pow) {
        return new Matrix4f(
                Math.pow(m00, pow), Math.pow(m01, pow), Math.pow(m02, pow), Math.pow(m03, pow),
                Math.pow(m10, pow), Math.pow(m11, pow), Math.pow(m12, pow), Math.pow(m13, pow),
                Math.pow(m20, pow), Math.pow(m21, pow), Math.pow(m22, pow), Math.pow(m23, pow),
                Math.pow(m30, pow), Math.pow(m31, pow), Math.pow(m32, pow), Math.pow(m33, pow));
    }

    public Matrix4f translate(Vector3f v) {
        return translate(v.getX(), v.getY(), v.getZ());
    }

    public Matrix4f translate(double x, double y, double z) {
        return translate((float) x, (float) y, (float) z);
    }

    public Matrix4f translate(float x, float y, float z) {
        return createTranslation(x, y, z).mul(this);
    }

    public Matrix4f scale(double scale) {
        return scale((float) scale);
    }

    public Matrix4f scale(float scale) {
        return scale(scale, scale, scale, scale);
    }

    public Matrix4f scale(Vector4f v) {
        return scale(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public Matrix4f scale(double x, double y, double z, double w) {
        return scale((float) x, (float) y, (float) z, (float) w);
    }

    public Matrix4f scale(float x, float y, float z, float w) {
        return createScaling(x, y, z, w).mul(this);
    }

    public Matrix4f rotate(Complexf rot) {
        return createRotation(rot).mul(this);
    }

    public Matrix4f rotate(Quaternionf rot) {
        return createRotation(rot).mul(this);
    }

    public Vector4f transform(Vector4f v) {
        return transform(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public Vector4f transform(double x, double y, double z, double w) {
        return transform((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f transform(float x, float y, float z, float w) {
        return new Vector4f(
                m00 * x + m01 * y + m02 * z + m03 * w,
                m10 * x + m11 * y + m12 * z + m13 * w,
                m20 * x + m21 * y + m22 * z + m23 * w,
                m30 * x + m31 * y + m32 * z + m33 * w);
    }

    @Override
    public Matrix4f floor() {
        return new Matrix4f(
                GenericMath.floor(m00), GenericMath.floor(m01), GenericMath.floor(m02), GenericMath.floor(m03),
                GenericMath.floor(m10), GenericMath.floor(m11), GenericMath.floor(m12), GenericMath.floor(m13),
                GenericMath.floor(m20), GenericMath.floor(m21), GenericMath.floor(m22), GenericMath.floor(m23),
                GenericMath.floor(m30), GenericMath.floor(m31), GenericMath.floor(m32), GenericMath.floor(m33));
    }

    @Override
    public Matrix4f ceil() {
        return new Matrix4f(
                Math.ceil(m00), Math.ceil(m01), Math.ceil(m02), Math.ceil(m03),
                Math.ceil(m10), Math.ceil(m11), Math.ceil(m12), Math.ceil(m13),
                Math.ceil(m20), Math.ceil(m21), Math.ceil(m22), Math.ceil(m23),
                Math.ceil(m30), Math.ceil(m31), Math.ceil(m32), Math.ceil(m33));
    }

    @Override
    public Matrix4f round() {
        return new Matrix4f(
                Math.round(m00), Math.round(m01), Math.round(m02), Math.round(m03),
                Math.round(m10), Math.round(m11), Math.round(m12), Math.round(m13),
                Math.round(m20), Math.round(m21), Math.round(m22), Math.round(m23),
                Math.round(m30), Math.round(m31), Math.round(m32), Math.round(m33));
    }

    @Override
    public Matrix4f abs() {
        return new Matrix4f(
                Math.abs(m00), Math.abs(m01), Math.abs(m02), Math.abs(m03),
                Math.abs(m10), Math.abs(m11), Math.abs(m12), Math.abs(m13),
                Math.abs(m20), Math.abs(m21), Math.abs(m22), Math.abs(m23),
                Math.abs(m30), Math.abs(m31), Math.abs(m32), Math.abs(m33));
    }

    @Override
    public Matrix4f negate() {
        return new Matrix4f(
                -m00, -m01, -m02, -m03,
                -m10, -m11, -m12, -m13,
                -m20, -m21, -m22, -m23,
                -m30, -m31, -m32, -m33);
    }

    @Override
    public Matrix4f transpose() {
        return new Matrix4f(
                m00, m10, m20, m30,
                m01, m11, m21, m31,
                m02, m12, m22, m32,
                m03, m13, m23, m33);
    }

    @Override
    public float trace() {
        return m00 + m11 + m22 + m33;
    }

    @Override
    public float determinant() {
        return m00 * (m11 * m22 * m33 + m21 * m32 * m13 + m31 * m12 * m23 - m31 * m22 * m13 - m11 * m32 * m23 - m21 * m12 * m33)
                - m10 * (m01 * m22 * m33 + m21 * m32 * m03 + m31 * m02 * m23 - m31 * m22 * m03 - m01 * m32 * m23 - m21 * m02 * m33)
                + m20 * (m01 * m12 * m33 + m11 * m32 * m03 + m31 * m02 * m13 - m31 * m12 * m03 - m01 * m32 * m13 - m11 * m02 * m33)
                - m30 * (m01 * m12 * m23 + m11 * m22 * m03 + m21 * m02 * m13 - m21 * m12 * m03 - m01 * m22 * m13 - m11 * m02 * m23);
    }

    @Override
    public Matrix4f invert() {
        final float det = determinant();
        if (Math.abs(det) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot inverse a matrix with a zero determinant");
        }
        return new Matrix4f(
                det3(m11, m21, m31, m12, m22, m32, m13, m23, m33) / det, -det3(m01, m21, m31, m02, m22, m32, m03, m23, m33) / det,
                det3(m01, m11, m31, m02, m12, m32, m03, m13, m33) / det, -det3(m01, m11, m21, m02, m12, m22, m03, m13, m23) / det,
                -det3(m10, m20, m30, m12, m22, m32, m13, m23, m33) / det, det3(m00, m20, m30, m02, m22, m32, m03, m23, m33) / det,
                -det3(m00, m10, m30, m02, m12, m32, m03, m13, m33) / det, det3(m00, m10, m20, m02, m12, m22, m03, m13, m23) / det,
                det3(m10, m20, m30, m11, m21, m31, m13, m23, m33) / det, -det3(m00, m20, m30, m01, m21, m31, m03, m23, m33) / det,
                det3(m00, m10, m30, m01, m11, m31, m03, m13, m33) / det, -det3(m00, m10, m20, m01, m11, m21, m03, m13, m23) / det,
                -det3(m10, m20, m30, m11, m21, m31, m12, m22, m32) / det, det3(m00, m20, m30, m01, m21, m31, m02, m22, m32) / det,
                -det3(m00, m10, m30, m01, m11, m31, m02, m12, m32) / det, det3(m00, m10, m20, m01, m11, m21, m02, m12, m22) / det);
    }

    public Matrix2f toMatrix2() {
        return new Matrix2f(this);
    }

    public Matrix3f toMatrix3() {
        return new Matrix3f(this);
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
                    m00, m10, m20, m30,
                    m01, m11, m21, m31,
                    m02, m12, m22, m32,
                    m03, m13, m23, m33
            };
        } else {
            return new float[]{
                    m00, m01, m02, m03,
                    m10, m11, m12, m13,
                    m20, m21, m22, m23,
                    m30, m31, m32, m33
            };
        }
    }

    @Override
    public Matrix4f toFloat() {
        return new Matrix4f(
                m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33
        );
    }

    @Override
    public Matrix4d toDouble() {
        return new Matrix4d(
                m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33
        );
    }

    @Override
    public String toString() {
        return m00 + " " + m01 + " " + m02 + " " + m03 + "\n"
                + m10 + " " + m11 + " " + m12 + " " + m13 + "\n"
                + m20 + " " + m21 + " " + m22 + " " + m23 + "\n"
                + m30 + " " + m31 + " " + m32 + " " + m33 + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Matrix4f)) {
            return false;
        }
        final Matrix4f matrix4 = (Matrix4f) o;
        if (Float.compare(matrix4.m00, m00) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m01, m01) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m02, m02) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m03, m03) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m10, m10) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m11, m11) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m12, m12) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m13, m13) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m20, m20) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m21, m21) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m22, m22) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m23, m23) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m30, m30) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m31, m31) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m32, m32) != 0) {
            return false;
        }
        if (Float.compare(matrix4.m33, m33) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            int result = (m00 != +0.0f ? Float.hashCode(m00) : 0);
            result = 31 * result + (m01 != +0.0f ? Float.hashCode(m01) : 0);
            result = 31 * result + (m02 != +0.0f ? Float.hashCode(m02) : 0);
            result = 31 * result + (m03 != +0.0f ? Float.hashCode(m03) : 0);
            result = 31 * result + (m10 != +0.0f ? Float.hashCode(m10) : 0);
            result = 31 * result + (m11 != +0.0f ? Float.hashCode(m11) : 0);
            result = 31 * result + (m12 != +0.0f ? Float.hashCode(m12) : 0);
            result = 31 * result + (m13 != +0.0f ? Float.hashCode(m13) : 0);
            result = 31 * result + (m20 != +0.0f ? Float.hashCode(m20) : 0);
            result = 31 * result + (m21 != +0.0f ? Float.hashCode(m21) : 0);
            result = 31 * result + (m22 != +0.0f ? Float.hashCode(m22) : 0);
            result = 31 * result + (m23 != +0.0f ? Float.hashCode(m23) : 0);
            result = 31 * result + (m30 != +0.0f ? Float.hashCode(m30) : 0);
            result = 31 * result + (m31 != +0.0f ? Float.hashCode(m31) : 0);
            result = 31 * result + (m32 != +0.0f ? Float.hashCode(m32) : 0);
            hashCode = 31 * result + (m33 != +0.0f ? Float.hashCode(m33) : 0);
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public Matrix4f clone() {
        return new Matrix4f(this);
    }

    public static Matrix4f from(float n) {
         return n == 0 ? ZERO : new Matrix4f(n, n, n, n, n, n, n, n, n, n, n, n, n, n, n, n);
    }

    public static Matrix4f from(float m00, float m01, float m02, float m03,
                                float m10, float m11, float m12, float m13,
                                float m20, float m21, float m22, float m23,
                                float m30, float m31, float m32, float m33) {
         return m00 == 0 && m01 == 0 && m02 == 0 && m03 == 0
             && m10 == 0 && m11 == 0 && m12 == 0 && m13 == 0
             && m20 == 0 && m21 == 0 && m22 == 0 && m23 == 0
             && m30 == 0 && m31 == 0 && m32 == 0 && m33 == 0
         ? ZERO : new Matrix4f(m00, m01, m02, m03,
                                 m10, m11, m12, m13,
                                 m20, m21, m22, m23,
                                 m30, m31, m32, m33);
    }

    public static Matrix4f fromDiagonal(float m00, float m11, float m22, float m33) {
         return m00 == 0 && m11 == 0 && m22 == 0 && m33 == 0 ? ZERO : new Matrix4f(m00, 0, 0, 0,
                                                                                     0, m11, 0, 0,
                                                                                     0, 0, m22, 0,
                                                                                     0, 0, 0, m33);
    }

    public static Matrix4f createScaling(double scale) {
        return createScaling((float) scale);
    }

    public static Matrix4f createScaling(float scale) {
        return createScaling(scale, scale, scale, scale);
    }

    public static Matrix4f createScaling(Vector4f v) {
        return createScaling(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public static Matrix4f createScaling(double x, double y, double z, double w) {
        return createScaling((float) x, (float) y, (float) z, (float) w);
    }

    public static Matrix4f createScaling(float x, float y, float z, float w) {
        return new Matrix4f(
                x, 0, 0, 0,
                0, y, 0, 0,
                0, 0, z, 0,
                0, 0, 0, w);
    }

    public static Matrix4f createTranslation(Vector3f v) {
        return createTranslation(v.getX(), v.getY(), v.getZ());
    }

    public static Matrix4f createTranslation(double x, double y, double z) {
        return createTranslation((float) x, (float) y, (float) z);
    }

    public static Matrix4f createTranslation(float x, float y, float z) {
        return new Matrix4f(
                1, 0, 0, x,
                0, 1, 0, y,
                0, 0, 1, z,
                0, 0, 0, 1);
    }

    public static Matrix4f createRotation(Complexf rot) {
        rot = rot.normalize();
        return new Matrix4f(
                rot.getX(), -rot.getY(), 0, 0,
                rot.getY(), rot.getX(), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    public static Matrix4f createRotation(Quaternionf rot) {
        rot = rot.normalize();
        return new Matrix4f(
                1 - 2 * rot.getY() * rot.getY() - 2 * rot.getZ() * rot.getZ(),
                2 * rot.getX() * rot.getY() - 2 * rot.getW() * rot.getZ(),
                2 * rot.getX() * rot.getZ() + 2 * rot.getW() * rot.getY(), 0,
                2 * rot.getX() * rot.getY() + 2 * rot.getW() * rot.getZ(),
                1 - 2 * rot.getX() * rot.getX() - 2 * rot.getZ() * rot.getZ(),
                2 * rot.getY() * rot.getZ() - 2 * rot.getW() * rot.getX(), 0,
                2 * rot.getX() * rot.getZ() - 2 * rot.getW() * rot.getY(),
                2 * rot.getY() * rot.getZ() + 2 * rot.getX() * rot.getW(),
                1 - 2 * rot.getX() * rot.getX() - 2 * rot.getY() * rot.getY(), 0,
                0, 0, 0, 1);
    }

    /**
     * Creates a "look at" matrix for the given eye point.
     *
     * @param eye The position of the camera
     * @param at The point that the camera is looking at
     * @param up The "up" vector
     * @return A rotational transform that corresponds to a camera looking at the given point
     */
    public static Matrix4f createLookAt(Vector3f eye, Vector3f at, Vector3f up) {
        final Vector3f f = at.sub(eye).normalize();
        final Vector3f s = f.cross(up).normalize();
        final Vector3f u = s.cross(f);
        final Matrix4f mat = new Matrix4f(
                s.getX(), s.getY(), s.getZ(), 0,
                u.getX(), u.getY(), u.getZ(), 0,
                -f.getX(), -f.getY(), -f.getZ(), 0,
                0, 0, 0, 1);
        return mat.translate(eye.negate());
    }

    /**
     * Creates a perspective projection matrix with the given (x) FOV, aspect, near and far planes
     *
     * @param fov The field of view in the x direction
     * @param aspect The aspect ratio, usually width/height
     * @param near The near plane, cannot be 0
     * @param far the far plane, far cannot equal near
     * @return A perspective projection matrix built from the given values
     */
    public static Matrix4f createPerspective(double fov, double aspect, double near, double far) {
        return createPerspective((float) fov, (float) aspect, (float) near, (float) far);
    }

    /**
     * Creates a perspective projection matrix with the given (x) FOV, aspect, near and far planes
     *
     * @param fov The field of view in the x direction
     * @param aspect The aspect ratio, usually width/height
     * @param near The near plane, cannot be 0
     * @param far the far plane, far cannot equal near
     * @return A perspective projection matrix built from the given values
     */
    public static Matrix4f createPerspective(float fov, float aspect, float near, float far) {
        final float scale = 1 / TrigMath.tan(fov * (float) TrigMath.HALF_DEG_TO_RAD);
        return new Matrix4f(
                scale / aspect, 0, 0, 0,
                0, scale, 0, 0,
                0, 0, (far + near) / (near - far), 2 * far * near / (near - far),
                0, 0, -1, 0);
    }

    /**
     * Creates an orthographic viewing frustum built from the provided values
     *
     * @param right the right most plane of the viewing frustum
     * @param left the left most plane of the viewing frustum
     * @param top the top plane of the viewing frustum
     * @param bottom the bottom plane of the viewing frustum
     * @param near the near plane of the viewing frustum
     * @param far the far plane of the viewing frustum
     * @return A viewing frustum built from the provided values
     */
    public static Matrix4f createOrthographic(double right, double left, double top, double bottom,
            double near, double far) {
        return createOrthographic((float) right, (float) left, (float) top, (float) bottom, (float) near, (float) far);
    }

    /**
     * Creates an orthographic viewing frustum built from the provided values
     *
     * @param right the right most plane of the viewing frustum
     * @param left the left most plane of the viewing frustum
     * @param top the top plane of the viewing frustum
     * @param bottom the bottom plane of the viewing frustum
     * @param near the near plane of the viewing frustum
     * @param far the far plane of the viewing frustum
     * @return A viewing frustum built from the provided values
     */
    public static Matrix4f createOrthographic(float right, float left, float top, float bottom,
            float near, float far) {
        return new Matrix4f(
                2 / (right - left), 0, 0, -(right + left) / (right - left),
                0, 2 / (top - bottom), 0, -(top + bottom) / (top - bottom),
                0, 0, -2 / (far - near), -(far + near) / (far - near),
                0, 0, 0, 1);
    }

    private static float det3(float m00, float m01, float m02,
            float m10, float m11, float m12,
            float m20, float m21, float m22) {
        return m00 * (m11 * m22 - m12 * m21) - m01 * (m10 * m22 - m12 * m20) + m02 * (m10 * m21 - m11 * m20);
    }
}
