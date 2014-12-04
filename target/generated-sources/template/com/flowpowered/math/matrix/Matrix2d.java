package com.flowpowered.math.matrix;

import java.io.Serializable;
import java.lang.Override;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.vector.Vector2d;

public class Matrix2d implements Matrixd, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Matrix2d ZERO = new Matrix2d(
            0, 0,
            0, 0);
    public static final Matrix2d IDENTITY = new Matrix2d();
    private final double m00, m01;
    private final double m10, m11;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Matrix2d() {
        this(
                1, 0,
                0, 1);
    }

    public Matrix2d(Matrix2d m) {
        this(
                m.m00, m.m01,
                m.m10, m.m11);
    }

    public Matrix2d(Matrix3d m) {
        this(
                m.get(0, 0), m.get(0, 1),
                m.get(1, 0), m.get(1, 1));
    }

    public Matrix2d(Matrix4d m) {
        this(
                m.get(0, 0), m.get(0, 1),
                m.get(1, 0), m.get(1, 1));
    }

    public Matrix2d(MatrixNd m) {
        this(
                m.get(0, 0), m.get(0, 1),
                m.get(1, 0), m.get(1, 1));
    }

    public Matrix2d(
            float m00, float m01,
            float m10, float m11) {
        this(
                (double) m00, (double) m01,
                (double) m10, (double) m11);
    }

    public Matrix2d(
            double m00, double m01,
            double m10, double m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
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
    public Vector2d getRow(int row) {
        return new Vector2d(get(row, 0), get(row, 1));
    }

    @Override
    public Vector2d getColumn(int col) {
        return new Vector2d(get(0, col), get(1, col));
    }

    public Matrix2d add(Matrix2d m) {
        return new Matrix2d(
                m00 + m.m00, m01 + m.m01,
                m10 + m.m10, m11 + m.m11);
    }

    public Matrix2d sub(Matrix2d m) {
        return new Matrix2d(
                m00 - m.m00, m01 - m.m01,
                m10 - m.m10, m11 - m.m11);
    }

    public Matrix2d mul(float a) {
        return mul((double) a);
    }

    @Override
    public Matrix2d mul(double a) {
        return new Matrix2d(
                m00 * a, m01 * a,
                m10 * a, m11 * a);
    }

    public Matrix2d mul(Matrix2d m) {
        return new Matrix2d(
                m00 * m.m00 + m01 * m.m10, m00 * m.m01 + m01 * m.m11,
                m10 * m.m00 + m11 * m.m10, m10 * m.m01 + m11 * m.m11);
    }

    public Matrix2d div(float a) {
        return div((double) a);
    }

    @Override
    public Matrix2d div(double a) {
        return new Matrix2d(
                m00 / a, m01 / a,
                m10 / a, m11 / a);
    }

    public Matrix2d div(Matrix2d m) {
        return mul(m.invert());
    }

    public Matrix2d pow(float pow) {
        return pow((double) pow);
    }

    @Override
    public Matrix2d pow(double pow) {
        return new Matrix2d(
                Math.pow(m00, pow), Math.pow(m01, pow),
                Math.pow(m10, pow), Math.pow(m11, pow));
    }

    public Matrix2d translate(float x) {
        return translate((double) x);
    }

    public Matrix2d translate(double x) {
        return createTranslation(x).mul(this);
    }

    public Matrix2d scale(float scale) {
        return scale((double) scale);
    }

    public Matrix2d scale(double scale) {
        return scale(scale, scale);
    }

    public Matrix2d scale(Vector2d v) {
        return scale(v.getX(), v.getY());
    }

    public Matrix2d scale(float x, float y) {
        return scale((double) x, (double) y);
    }

    public Matrix2d scale(double x, double y) {
        return createScaling(x, y).mul(this);
    }

    public Matrix2d rotate(Complexd rot) {
        return createRotation(rot).mul(this);
    }

    public Vector2d transform(Vector2d v) {
        return transform(v.getX(), v.getY());
    }

    public Vector2d transform(float x, float y) {
        return transform((double) x, (double) y);
    }

    public Vector2d transform(double x, double y) {
        return new Vector2d(
                m00 * x + m01 * y,
                m10 * x + m11 * y);
    }

    @Override
    public Matrix2d floor() {
        return new Matrix2d(
                GenericMath.floor(m00), GenericMath.floor(m01),
                GenericMath.floor(m10), GenericMath.floor(m11));
    }

    @Override
    public Matrix2d ceil() {
        return new Matrix2d(
                Math.ceil(m00), Math.ceil(m01),
                Math.ceil(m10), Math.ceil(m11));
    }

    @Override
    public Matrix2d round() {
        return new Matrix2d(
                Math.round(m00), Math.round(m01),
                Math.round(m10), Math.round(m11));
    }

    @Override
    public Matrix2d abs() {
        return new Matrix2d(
                Math.abs(m00), Math.abs(m01),
                Math.abs(m10), Math.abs(m11));
    }

    @Override
    public Matrix2d negate() {
        return new Matrix2d(
                -m00, -m01,
                -m10, -m11);
    }

    @Override
    public Matrix2d transpose() {
        return new Matrix2d(
                m00, m10,
                m01, m11);
    }

    @Override
    public double trace() {
        return m00 + m11;
    }

    @Override
    public double determinant() {
        return m00 * m11 - m01 * m10;
    }

    @Override
    public Matrix2d invert() {
        final double det = determinant();
        if (Math.abs(det) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot inverse a matrix with a zero determinant");
        }
        return new Matrix2d(
                m11 / det, -m01 / det,
                -m10 / det, m00 / det);
    }

    public Matrix3d toMatrix3() {
        return new Matrix3d(this);
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
                    m00, m10,
                    m01, m11
            };
        } else {
            return new double[]{
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
        if (!(o instanceof Matrix2d)) {
            return false;
        }
        final Matrix2d matrix2 = (Matrix2d) o;
        if (Double.compare(matrix2.m00, m00) != 0) {
            return false;
        }
        if (Double.compare(matrix2.m01, m01) != 0) {
            return false;
        }
        if (Double.compare(matrix2.m10, m10) != 0) {
            return false;
        }
        if (Double.compare(matrix2.m11, m11) != 0) {
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
    public Matrix2d clone() {
        return new Matrix2d(this);
    }

    public static Matrix2d createScaling(float scale) {
        return createScaling((double) scale);
    }

    public static Matrix2d createScaling(double scale) {
        return createScaling(scale, scale);
    }

    public static Matrix2d createScaling(Vector2d v) {
        return createScaling(v.getX(), v.getY());
    }

    public static Matrix2d createScaling(float x, float y) {
        return createScaling((double) x, (double) y);
    }

    public static Matrix2d createScaling(double x, double y) {
        return new Matrix2d(
                x, 0,
                0, y);
    }

    public static Matrix2d createTranslation(float x) {
        return createTranslation((double) x);
    }

    public static Matrix2d createTranslation(double x) {
        return new Matrix2d(
                1, x,
                0, 1);
    }

    public static Matrix2d createRotation(Complexd rot) {
        rot = rot.normalize();
        return new Matrix2d(
                rot.getX(), -rot.getY(),
                rot.getY(), rot.getX());
    }
}
