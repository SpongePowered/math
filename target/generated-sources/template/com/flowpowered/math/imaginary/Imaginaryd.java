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
    public Imaginaryd mul(double a);

    /**
     * Divides the imaginary number by the given scalar.
     *
     * @param a The scalar to divide by
     * @return The multiplied imaginary number
     */
    public Imaginaryd div(double a);

    /**
     * Returns the conjugated imaginary number.
     *
     * @return The conjugate
     */
    public Imaginaryd conjugate();

    /**
     * Returns the inverts imaginary number.
     *
     * @return The inverse
     */
    public Imaginaryd invert();

    /**
     * Returns the length of the imaginary number.
     *
     * @return The length
     */
    public double length();

    /**
     * Returns the square of the length of the imaginary number.
     *
     * @return The square of the length
     */
    public double lengthSquared();

    /**
     * Normalizes the imaginary number.
     *
     * @return The imaginary number, but of unit length
     */
    public Imaginaryd normalize();

    public Imaginaryf toFloat();

    public Imaginaryd toDouble();
}
