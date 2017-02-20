package com.flowpowered.math.vector;

public interface Vectorf {
    Vectorf mul(float a);

    Vectorf div(float a);

    Vectorf pow(float pow);

    Vectorf ceil();

    Vectorf floor();

    Vectorf round();

    Vectorf abs();

    Vectorf negate();

    float length();

    float lengthSquared();

    Vectorf normalize();

    int getMinAxis();

    int getMaxAxis();

    float[] toArray();

    Vectori toInt();

    Vectorl toLong();

    Vectorf toFloat();

    Vectord toDouble();
}
