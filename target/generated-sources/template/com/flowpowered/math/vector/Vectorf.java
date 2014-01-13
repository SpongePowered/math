package com.flowpowered.math.vector;

public interface Vectorf {
    public Vectorf mul(float a);

    public Vectorf div(float a);

    public Vectorf pow(float pow);

    public Vectorf ceil();

    public Vectorf floor();

    public Vectorf round();

    public Vectorf abs();

    public Vectorf negate();

    public float length();

    public float lengthSquared();

    public Vectorf normalize();

    public int getMinAxis();

    public int getMaxAxis();

    public float[] toArray();

    public Vectori toInt();

    public Vectorl toLong();

    public Vectorf toFloat();

    public Vectord toDouble();
}
