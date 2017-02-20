package com.flowpowered.math.vector;

import java.util.stream.IntStream;

public interface Vectori {
    Vectori mul(int a);

    Vectori div(int a);

    Vectori pow(int pow);

    Vectori abs();

    Vectori negate();

    float length();

    int lengthSquared();

    int getMinAxis();

    int getMaxAxis();

    int[] toArray();

    Vectori toInt();

    Vectorl toLong();

    Vectorf toFloat();

    Vectord toDouble();

    IntStream stream();
}
