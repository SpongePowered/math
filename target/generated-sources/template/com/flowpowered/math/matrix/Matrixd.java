package com.flowpowered.math.matrix;

import com.flowpowered.math.vector.Vectord;

public interface Matrixd {
    public double get(int row, int col);

    public Vectord getRow(int row);

    public Vectord getColumn(int col);

    public Matrixd mul(double a);

    public Matrixd div(double a);

    public Matrixd pow(double pow);

    public Matrixd ceil();

    public Matrixd floor();

    public Matrixd round();

    public Matrixd abs();

    public Matrixd negate();

    public Matrixd transpose();

    public double trace();

    public double determinant();

    public Matrixd invert();

    public double[] toArray(boolean columnMajor);

    public Matrixf toFloat();

    public Matrixd toDouble();
}
