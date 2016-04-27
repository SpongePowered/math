package com.flowpowered.math.matrix;

import java.io.Serializable;
import java.lang.Override;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.vector.Vector2f;

public class Matrix2f implements Matrixf, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Matrix2f ZERO = new Matrix2f(
            0, 0,
            0, 0);
    public static final Matrix2f IDENTITY = new Matrix2f();
    private final float m00, m01;
    private final float m10, m11;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Matrix2f() {
        this(
                1, 0,
                0, 1);
    }

    public Matrix2f(Matrix2f m) {
        this(
                m.m00, m.m01,
                m.m10, m.m11);
    }

    public Matrix2f(Matrix3f m) {
        this(
                m.get(0, 0), m.get(0, 1),
                m.get(1, 0), m.get(1, 1));
    }

    public Matrix2f(Matrix4f m) {
        this(
                m.get(0, 0), m.get(0, 1),
                m.get(1, 0), m.get(1, 1));
    }

    public Matrix2f(MatrixNf m) {
        this(
                m.get(0, 0), m.get(0, 1),
                m.get(1, 0), m.get(1, 1));
    }

    public Matrix2f(
            double m00, double m01,
            double m10, double m11) {
        this(
                (float) m00, (float) m01,
                (float) m10, (float) m11);
    }

    public Matrix2f(
            float m00, float m01,
            float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
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
            }
        case 1:
            switch (col) {
            case 0:
                return m10;
            case 1:
                return m11;
            }
        }
        throw new IllegalArgumentException(
                (row < 0 || row > 1 ? "row must be greater than zero and smaller than 2. " : "") +
                (col < 0 || col > 1 ? "col must be greater than zero and smaller than 2." : ""));
    }

    @Override
    public Vector2f getRow(int row) {
        return new Vector2f(get(row, 0), get(row, 1));
    }

    @Override
    public Vector2f getColumn(int col) {
        return new Vector2f(get(0, col), get(1, col));
    }

    public Matrix2f add(Matrix2f m) {
        return new Matrix2f(
                m00 + m.m00, m01 + m.m01,
                m10 + m.m10, m11 + m.m11);
    }

    public Matrix2f sub(Matrix2f m) {
        return new Matrix2f(
                m00 - m.m00, m01 - m.m01,
                m10 - m.m10, m11 - m.m11);
    }

    public Matrix2f mul(double a) {
        return mul((float) a);
    }

    @Override
    public Matrix2f mul(float a) {
        return new Matrix2f(
                m00 * a, m01 * a,
                m10 * a, m11 * a);
    }

    public Matrix2f mul(Matrix2f m) {
        return new Matrix2f(
                m00 * m.m00 + m01 * m.m10, m00 * m.m01 + m01 * m.m11,
                m10 * m.m00 + m11 * m.m10, m10 * m.m01 + m11 * m.m11);
    }

    public Matrix2f div(double a) {
        return div((float) a);
    }

    @Override
    public Matrix2f div(float a) {
        return new Matrix2f(
                m00 / a, m01 / a,
                m10 / a, m11 / a);
    }

    public Matrix2f div(Matrix2f m) {
        return mul(m.invert());
    }

    public Matrix2f pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public Matrix2f pow(float pow) {
        return new Matrix2f(
                Math.pow(m00, pow), Math.pow(m01, pow),
                Math.pow(m10, pow), Math.pow(m11, pow));
    }

    public Matrix2f translate(double x) {
        return translate((float) x);
    }

    public Matrix2f translate(float x) {
        return createTranslation(x).mul(this);
    }

    public Matrix2f scale(double scale) {
        return scale((float) scale);
    }

    public Matrix2f scale(float scale) {
        return scale(scale, scale);
    }

    public Matrix2f scale(Vector2f v) {
        return scale(v.getX(), v.getY());
    }

    public Matrix2f scale(double x, double y) {
        return scale((float) x, (float) y);
    }

    public Matrix2f scale(float x, float y) {
        return createScaling(x, y).mul(this);
    }

    public Matrix2f rotate(Complexf rot) {
        return createRotation(rot).mul(this);
    }

    public Vector2f transform(Vector2f v) {
        return transform(v.getX(), v.getY());
    }

    public Vector2f transform(double x, double y) {
        return transform((float) x, (float) y);
    }

    public Vector2f transform(float x, float y) {
        return new Vector2f(
                m00 * x + m01 * y,
                m10 * x + m11 * y);
    }

    @Override
    public Matrix2f floor() {
        return new Matrix2f(
                GenericMath.floor(m00), GenericMath.floor(m01),
                GenericMath.floor(m10), GenericMath.floor(m11));
    }

    @Override
    public Matrix2f ceil() {
        return new Matrix2f(
                Math.ceil(m00), Math.ceil(m01),
                Math.ceil(m10), Math.ceil(m11));
    }

    @Override
    public Matrix2f round() {
        return new Matrix2f(
                Math.round(m00), Math.round(m01),
                Math.round(m10), Math.round(m11));
    }

    @Override
    public Matrix2f abs() {
        return new Matrix2f(
                Math.abs(m00), Math.abs(m01),
                Math.abs(m10), Math.abs(m11));
    }

    @Override
    public Matrix2f negate() {
        return new Matrix2f(
                -m00, -m01,
                -m10, -m11);
    }

    @Override
    public Matrix2f transpose() {
        return new Matrix2f(
                m00, m10,
                m01, m11);
    }

    @Override
    public float trace() {
        return m00 + m11;
    }

    @Override
    public float determinant() {
        return m00 * m11 - m01 * m10;
    }

    @Override
    public Matrix2f invert() {
        final float det = determinant();
        if (Math.abs(det) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot inverse a matrix with a zero determinant");
        }
        return new Matrix2f(
                m11 / det, -m01 / det,
                -m10 / det, m00 / det);
    }

    public Matrix3f toMatrix3() {
        return new Matrix3f(this);
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
                    m00, m10,
                    m01, m11
            };
        } else {
            return new float[]{
                    m00, m01,
                    m10, m11
            };
        }
    }

    @Override
    public Matrix2f toFloat() {
        return new Matrix2f(m00, m01, m10, m11);
    }

    @Override
    public Matrix2d toDouble() {
        return new Matrix2d(m00, m01, m10, m11);
    }

    @Override
    public String toString() {
        return m00 + " " + m01 + "\n" + m10 + " " + m11;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Matrix2f)) {
            return false;
        }
        final Matrix2f matrix2 = (Matrix2f) o;
        if (Float.compare(matrix2.m00, m00) != 0) {
            return false;
        }
        if (Float.compare(matrix2.m01, m01) != 0) {
            return false;
        }
        if (Float.compare(matrix2.m10, m10) != 0) {
            return false;
        }
        if (Float.compare(matrix2.m11, m11) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            int result = (m00 != +0.0f ? HashFunctions.hash(m00) : 0);
            result = 31 * result + (m01 != +0.0f ? HashFunctions.hash(m01) : 0);
            result = 31 * result + (m10 != +0.0f ? HashFunctions.hash(m10) : 0);
            hashCode = 31 * result + (m11 != +0.0f ? HashFunctions.hash(m11) : 0);
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public Matrix2f clone() {
        return new Matrix2f(this);
    }

    public static Matrix2f from(float n) {
         return n == 0 ? ZERO : new Matrix2f(n, n, n, n);
    }

    public static Matrix2f from(float m00, float m01, float m10, float m11) {
         return m00 == 0 && m01 == 0 && m10 == 0 && m11 == 0 ? ZERO : new Matrix2f(m00, m01, m10, m11);
    }

    public static Matrix2f fromDiagonal(float m00, float m11) {
         return m00 == 0 && m11 == 0 ? ZERO : new Matrix2f(m00, 0, 0, m11);
    }

    public static Matrix2f createScaling(double scale) {
        return createScaling((float) scale);
    }

    public static Matrix2f createScaling(float scale) {
        return createScaling(scale, scale);
    }

    public static Matrix2f createScaling(Vector2f v) {
        return createScaling(v.getX(), v.getY());
    }

    public static Matrix2f createScaling(double x, double y) {
        return createScaling((float) x, (float) y);
    }

    public static Matrix2f createScaling(float x, float y) {
        return new Matrix2f(
                x, 0,
                0, y);
    }

    public static Matrix2f createTranslation(double x) {
        return createTranslation((float) x);
    }

    public static Matrix2f createTranslation(float x) {
        return new Matrix2f(
                1, x,
                0, 1);
    }

    public static Matrix2f createRotation(Complexf rot) {
        rot = rot.normalize();
        return new Matrix2f(
                rot.getX(), -rot.getY(),
                rot.getY(), rot.getX());
    }
}
