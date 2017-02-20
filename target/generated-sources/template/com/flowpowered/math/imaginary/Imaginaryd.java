package com.flowpowered.math.imaginary;

/**
 * Represents an imaginary number.
 */
public interface Imaginaryd {
    /**
     * Multiplies the imaginary number by the given scalar.
     *
     * @param a The scalar to multiply by
     * @return The multiplied imaginary number
     */
    Imaginaryd mul(double a);

    /**
     * Divides the imaginary number by the given scalar.
     *
     * @param a The scalar to divide by
     * @return The multiplied imaginary number
     */
    Imaginaryd div(double a);

    /**
     * Returns the conjugated imaginary number.
     *
     * @return The conjugate
     */
    Imaginaryd conjugate();

    /**
     * Returns the inverts imaginary number.
     *
     * @return The inverse
     */
    Imaginaryd invert();

    /**
     * Returns the length of the imaginary number.
     *
     * @return The length
     */
    double length();

    /**
     * Returns the square of the length of the imaginary number.
     *
     * @return The square of the length
     */
    double lengthSquared();

    /**
     * Normalizes the imaginary number.
     *
     * @return The imaginary number, but of unit length
     */
    Imaginaryd normalize();

    Imaginaryf toFloat();

    Imaginaryd toDouble();
}
