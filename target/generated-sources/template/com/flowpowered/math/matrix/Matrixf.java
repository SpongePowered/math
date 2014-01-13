package com.flowpowered.math.matrix;

import com.flowpowered.math.vector.Vectorf;

public interface Matrixf {
    public float get(int row, int col);

    public Vectorf getRow(int row);

    public Vectorf getColumn(int col);

    public Matrixf mul(float a);

    public Matrixf div(float a);

    public Matrixf pow(float pow);

    public Matrixf ceil();

    public Matrixf floor();

    public Matrixf round();

    public Matrixf abs();

    public Matrixf negate();

    public Matrixf transpose();

    public float trace();

    public float determinant();

    public Matrixf invert();

    public float[] toArray(boolean columnMajor);

    public Matrixf toFloat();

    public Matrixd toDouble();
}
