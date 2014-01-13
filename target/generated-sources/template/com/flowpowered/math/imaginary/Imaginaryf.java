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
    public Imaginaryf mul(float a);

    /**
     * Divides the imaginary number by the given scalar.
     *
     * @param a The scalar to divide by
     * @return The multiplied imaginary number
     */
    public Imaginaryf div(float a);

    /**
     * Returns the conjugated imaginary number.
     *
     * @return The conjugate
     */
    public Imaginaryf conjugate();

    /**
     * Returns the inverts imaginary number.
     *
     * @return The inverse
     */
    public Imaginaryf invert();

    /**
     * Returns the length of the imaginary number.
     *
     * @return The length
     */
    public float length();

    /**
     * Returns the square of the length of the imaginary number.
     *
     * @return The square of the length
     */
    public float lengthSquared();

    /**
     * Normalizes the imaginary number.
     *
     * @return The imaginary number, but of unit length
     */
    public Imaginaryf normalize();

    public Imaginaryf toFloat();

    public Imaginaryd toDouble();
}
