package com.flowpowered.math.matrix;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;

public class Matrix3d implements Matrixd, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Matrix3d ZERO = new Matrix3d(
            0, 0, 0,
            0, 0, 0,
            0, 0, 0);
    public static final Matrix3d IDENTITY = new Matrix3d();
    private final double m00, m01, m02;
    private final double m10, m11, m12;
    private final double m20, m21, m22;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Matrix3d() {
        this(
                1, 0, 0,
                0, 1, 0,
                0, 0, 1);
    }

    public Matrix3d(Matrix2d m) {
        this(
                m.get(0, 0), m.get(0, 1), 0,
                m.get(1, 0), m.get(1, 1), 0,
                0, 0, 0);
    }

    public Matrix3d(Matrix3d m) {
        this(
                m.m00, m.m01, m.m02,
                m.m10, m.m11, m.m12,
                m.m20, m.m21, m.m22);
    }

    public Matrix3d(Matrix4d m) {
        this(
                m.get(0, 0), m.get(0, 1), m.get(0, 2),
                m.get(1, 0), m.get(1, 1), m.get(1, 2),
                m.get(2, 0), m.get(2, 1), m.get(2, 2));
    }

    public Matrix3d(MatrixNd m) {
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

    public Matrix3d(
            float m00, float m01, float m02,
            float m10, float m11, float m12,
            float m20, float m21, float m22) {
        this(
                (double) m00, (double) m01, (double) m02,
                (double) m10, (double) m11, (double) m12,
                (double) m20, (double) m21, (double) m22);
    }

    public Matrix3d(
            double m00, double m01, double m02,
            double m10, double m11, double m12,
            double m20, double m21, double m22) {
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
    public double get(int row, int col) {
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
    public Vector3d getRow(int row) {
        return new Vector3d(get(row, 0), get(row, 1), get(row, 2));
    }

    @Override
    public Vector3d getColumn(int col) {
        return new Vector3d(get(0, col), get(1, col), get(2, col));
    }

    public Matrix3d add(Matrix3d m) {
        return new Matrix3d(
                m00 + m.m00, m01 + m.m01, m02 + m.m02,
                m10 + m.m10, m11 + m.m11, m12 + m.m12,
                m20 + m.m20, m21 + m.m21, m22 + m.m22);
    }

    public Matrix3d sub(Matrix3d m) {
        return new Matrix3d(
                m00 - m.m00, m01 - m.m01, m02 - m.m02,
                m10 - m.m10, m11 - m.m11, m12 - m.m12,
                m20 - m.m20, m21 - m.m21, m22 - m.m22);
    }

    public Matrix3d mul(float a) {
        return mul((double) a);
    }

    @Override
    public Matrix3d mul(double a) {
        return new Matrix3d(
                m00 * a, m01 * a, m02 * a,
                m10 * a, m11 * a, m12 * a,
                m20 * a, m21 * a, m22 * a);
    }

    public Matrix3d mul(Matrix3d m) {
        return new Matrix3d(
                m00 * m.m00 + m01 * m.m10 + m02 * m.m20, m00 * m.m01 + m01 * m.m11 + m02 * m.m21,
                m00 * m.m02 + m01 * m.m12 + m02 * m.m22, m10 * m.m00 + m11 * m.m10 + m12 * m.m20,
                m10 * m.m01 + m11 * m.m11 + m12 * m.m21, m10 * m.m02 + m11 * m.m12 + m12 * m.m22,
                m20 * m.m00 + m21 * m.m10 + m22 * m.m20, m20 * m.m01 + m21 * m.m11 + m22 * m.m21,
                m20 * m.m02 + m21 * m.m12 + m22 * m.m22);
    }

    public Matrix3d div(float a) {
        return div((double) a);
    }

    @Override
    public Matrix3d div(double a) {
        return new Matrix3d(
                m00 / a, m01 / a, m02 / a,
                m10 / a, m11 / a, m12 / a,
                m20 / a, m21 / a, m22 / a);
    }

    public Matrix3d div(Matrix3d m) {
        return mul(m.invert());
    }

    public Matrix3d pow(float pow) {
        return pow((double) pow);
    }

    @Override
    public Matrix3d pow(double pow) {
        return new Matrix3d(
                Math.pow(m00, pow), Math.pow(m01, pow), Math.pow(m02, pow),
                Math.pow(m10, pow), Math.pow(m11, pow), Math.pow(m12, pow),
                Math.pow(m20, pow), Math.pow(m21, pow), Math.pow(m22, pow));
    }

    public Matrix3d translate(Vector2d v) {
        return translate(v.getX(), v.getY());
    }

    public Matrix3d translate(float x, float y) {
        return translate((double) x, (double) y);
    }

    public Matrix3d translate(double x, double y) {
        return createTranslation(x, y).mul(this);
    }

    public Matrix3d scale(float scale) {
        return scale((double) scale);
    }

    public Matrix3d scale(double scale) {
        return scale(scale, scale, scale);
    }

    public Matrix3d scale(Vector3d v) {
        return scale(v.getX(), v.getY(), v.getZ());
    }

    public Matrix3d scale(float x, float y, float z) {
        return scale((double) x, (double) y, (double) z);
    }

    public Matrix3d scale(double x, double y, double z) {
        return createScaling(x, y, z).mul(this);
    }

    public Matrix3d rotate(Complexd rot) {
        return createRotation(rot).mul(this);
    }

    public Matrix3d rotate(Quaterniond rot) {
        return createRotation(rot).mul(this);
    }

    public Vector3d transform(Vector3d v) {
        return transform(v.getX(), v.getY(), v.getZ());
    }

    public Vector3d transform(float x, float y, float z) {
        return transform((double) x, (double) y, (double) z);
    }

    public Vector3d transform(double x, double y, double z) {
        return new Vector3d(
                m00 * x + m01 * y + m02 * z,
                m10 * x + m11 * y + m12 * z,
                m20 * x + m21 * y + m22 * z);
    }

    @Override
    public Matrix3d floor() {
        return new Matrix3d(
                GenericMath.floor(m00), GenericMath.floor(m01), GenericMath.floor(m02),
                GenericMath.floor(m10), GenericMath.floor(m11), GenericMath.floor(m12),
                GenericMath.floor(m20), GenericMath.floor(m21), GenericMath.floor(m22));
    }

    @Override
    public Matrix3d ceil() {
        return new Matrix3d(
                Math.ceil(m00), Math.ceil(m01), Math.ceil(m02),
                Math.ceil(m10), Math.ceil(m11), Math.ceil(m12),
                Math.ceil(m20), Math.ceil(m21), Math.ceil(m22));
    }

    @Override
    public Matrix3d round() {
        return new Matrix3d(
                Math.round(m00), Math.round(m01), Math.round(m02),
                Math.round(m10), Math.round(m11), Math.round(m12),
                Math.round(m20), Math.round(m21), Math.round(m22));
    }

    @Override
    public Matrix3d abs() {
        return new Matrix3d(
                Math.abs(m00), Math.abs(m01), Math.abs(m02),
                Math.abs(m10), Math.abs(m11), Math.abs(m12),
                Math.abs(m20), Math.abs(m21), Math.abs(m22));
    }

    @Override
    public Matrix3d negate() {
        return new Matrix3d(
                -m00, -m01, -m02,
                -m10, -m11, -m12,
                -m20, -m21, -m22);
    }

    @Override
    public Matrix3d transpose() {
        return new Matrix3d(
                m00, m10, m20,
                m01, m11, m21,
                m02, m12, m22);
    }

    @Override
    public double trace() {
        return m00 + m11 + m22;
    }

    @Override
    public double determinant() {
        return m00 * (m11 * m22 - m12 * m21) - m01 * (m10 * m22 - m12 * m20) + m02 * (m10 * m21 - m11 * m20);
    }

    @Override
    public Matrix3d invert() {
        final double det = determinant();
        if (Math.abs(det) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot inverse a matrix with a zero determinant");
        }
        return new Matrix3d(
                (m11 * m22 - m21 * m12) / det, -(m01 * m22 - m21 * m02) / det, (m01 * m12 - m02 * m11) / det,
                -(m10 * m22 - m20 * m12) / det, (m00 * m22 - m20 * m02) / det, -(m00 * m12 - m10 * m02) / det,
                (m10 * m21 - m20 * m11) / det, -(m00 * m21 - m20 * m01) / det, (m00 * m11 - m01 * m10) / det);
    }

    public Matrix2d toMatrix2() {
        return new Matrix2d(this);
    }

    public Matrix4d toMatrix4() {
        return new Matrix4d(this);
    }

    public MatrixNd toMatrixN() {
        return new MatrixNd(this);
    }

    public double[] toArray() {
        return toArray(false);
    }

    @Override
    public double[] toArray(boolean columnMajor) {
        if (columnMajor) {
            return new double[]{
                    m00, m10, m20,
                    m01, m11, m21,
                    m02, m12, m22
            };
        } else {
            return new double[]{
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
        if (!(o instanceof Matrix3d)) {
            return false;
        }
        final Matrix3d matrix3 = (Matrix3d) o;
        if (Double.compare(matrix3.m00, m00) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m01, m01) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m02, m02) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m10, m10) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m11, m11) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m12, m12) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m20, m20) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m21, m21) != 0) {
            return false;
        }
        if (Double.compare(matrix3.m22, m22) != 0) {
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
    public Matrix3d clone() {
        return new Matrix3d(this);
    }

    public static Matrix3d createScaling(float scale) {
        return createScaling((double) scale);
    }

    public static Matrix3d createScaling(double scale) {
        return createScaling(scale, scale, scale);
    }

    public static Matrix3d createScaling(Vector3d v) {
        return createScaling(v.getX(), v.getY(), v.getZ());
    }

    public static Matrix3d createScaling(float x, float y, float z) {
        return createScaling((double) x, (double) y, (double) z);
    }

    public static Matrix3d createScaling(double x, double y, double z) {
        return new Matrix3d(
                x, 0, 0,
                0, y, 0,
                0, 0, z);
    }

    public static Matrix3d createTranslation(Vector2d v) {
        return createTranslation(v.getX(), v.getY());
    }

    public static Matrix3d createTranslation(float x, float y) {
        return createTranslation((double) x, (double) y);
    }

    public static Matrix3d createTranslation(double x, double y) {
        return new Matrix3d(
                1, 0, x,
                0, 1, y,
                0, 0, 1);
    }

    public static Matrix3d createRotation(Complexd rot) {
        rot = rot.normalize();
        return new Matrix3d(
                rot.getX(), -rot.getY(), 0,
                rot.getY(), rot.getX(), 0,
                0, 0, 1);
    }

    public static Matrix3d createRotation(Quaterniond rot) {
        rot = rot.normalize();
        return new Matrix3d(
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
