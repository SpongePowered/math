package com.flowpowered.math.imaginary;

/**
 * Represents an imaginary number.
 */
public interface Imaginaryf {
    /**
     * Multiplies the imaginary number by the given scalar.
     *
     * @param a The scalar to multiply by
     * @return The multiplied imaginary number
     */
    Imaginaryf mul(float a);

    /**
     * Divides the imaginary number by the given scalar.
     *
     * @param a The scalar to divide by
     * @return The multiplied imaginary number
     */
    Imaginaryf div(float a);

    /**
     * Returns the conjugated imaginary number.
     *
     * @return The conjugate
     */
    Imaginaryf conjugate();

    /**
     * Returns the inverts imaginary number.
     *
     * @return The inverse
     */
    Imaginaryf invert();

    /**
     * Returns the length of the imaginary number.
     *
     * @return The length
     */
    float length();

    /**
     * Returns the square of the length of the imaginary number.
     *
     * @return The square of the length
     */
    float lengthSquared();

    /**
     * Normalizes the imaginary number.
     *
     * @return The imaginary number, but of unit length
     */
    Imaginaryf normalize();

    Imaginaryf toFloat();

    Imaginaryd toDouble();
}
