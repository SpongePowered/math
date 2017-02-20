package com.flowpowered.math.vector;

public interface Vectorl {
    Vectorl mul(long a);

    Vectorl div(long a);

    Vectorl pow(long pow);

    Vectorl abs();

    Vectorl negate();

    double length();

    long lengthSquared();

    int getMinAxis();

    int getMaxAxis();

    long[] toArray();

    Vectori toInt();

    Vectorl toLong();

    Vectorf toFloat();

    Vectord toDouble();
}
