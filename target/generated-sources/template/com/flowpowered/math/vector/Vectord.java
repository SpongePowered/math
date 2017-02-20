package com.flowpowered.math.vector;

import java.util.stream.DoubleStream;

public interface Vectord {
    Vectord mul(double a);

    Vectord div(double a);

    Vectord pow(double pow);

    Vectord ceil();

    Vectord floor();

    Vectord round();

    Vectord abs();

    Vectord negate();

    double length();

    double lengthSquared();

    Vectord normalize();

    int getMinAxis();

    int getMaxAxis();

    double[] toArray();

    Vectori toInt();

    Vectorl toLong();

    Vectorf toFloat();

    Vectord toDouble();

    DoubleStream stream();
}
