package com.flowpowered.math.vector;

public interface Vectori {
    public Vectori mul(int a);

    public Vectori div(int a);

    public Vectori pow(int pow);

    public Vectori abs();

    public Vectori negate();

    public float length();

    public int lengthSquared();

    public int getMinAxis();

    public int getMaxAxis();

    public int[] toArray();

    public Vectori toInt();

    public Vectorl toLong();

    public Vectorf toFloat();

    public Vectord toDouble();
}
