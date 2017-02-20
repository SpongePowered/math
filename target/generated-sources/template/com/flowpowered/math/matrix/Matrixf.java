package com.flowpowered.math.matrix;

import com.flowpowered.math.vector.Vectorf;

public interface Matrixf {
    float get(int row, int col);

    Vectorf getRow(int row);

    Vectorf getColumn(int col);

    Matrixf mul(float a);

    Matrixf div(float a);

    Matrixf pow(float pow);

    Matrixf ceil();

    Matrixf floor();

    Matrixf round();

    Matrixf abs();

    Matrixf negate();

    Matrixf transpose();

    float trace();

    float determinant();

    Matrixf invert();

    float[] toArray(boolean columnMajor);

    Matrixf toFloat();

    Matrixd toDouble();
}
