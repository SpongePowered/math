package com.flowpowered.math.vector;

public interface Vectorl {
    public Vectorl mul(long a);

    public Vectorl div(long a);

    public Vectorl pow(long pow);

    public Vectorl abs();

    public Vectorl negate();

    public double length();

    public long lengthSquared();

    public int getMinAxis();

    public int getMaxAxis();

    public long[] toArray();

    public Vectori toInt();

    public Vectorl toLong();

    public Vectorf toFloat();

    public Vectord toDouble();
}
