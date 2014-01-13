package com.flowpowered.math.vector;

public interface Vectord {
    public Vectord mul(double a);

    public Vectord div(double a);

    public Vectord pow(double pow);

    public Vectord ceil();

    public Vectord floor();

    public Vectord round();

    public Vectord abs();

    public Vectord negate();

    public double length();

    public double lengthSquared();

    public Vectord normalize();

    public int getMinAxis();

    public int getMaxAxis();

    public double[] toArray();

    public Vectori toInt();

    public Vectorl toLong();

    public Vectorf toFloat();

    public Vectord toDouble();
}
