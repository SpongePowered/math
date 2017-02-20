package com.flowpowered.math.matrix;

import com.flowpowered.math.vector.Vectord;

public interface Matrixd {
    double get(int row, int col);

    Vectord getRow(int row);

    Vectord getColumn(int col);

    Matrixd mul(double a);

    Matrixd div(double a);

    Matrixd pow(double pow);

    Matrixd ceil();

    Matrixd floor();

    Matrixd round();

    Matrixd abs();

    Matrixd negate();

    Matrixd transpose();

    double trace();

    double determinant();

    Matrixd invert();

    double[] toArray(boolean columnMajor);

    Matrixf toFloat();

    Matrixd toDouble();
}
