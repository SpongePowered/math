package com.flowpowered.math.imaginary;

import java.io.Serializable;
import java.lang.Override;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.TrigMath;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;

/**
 * Represent a complex number of the form <code>x + yi</code>. The x and y components are stored as floats. This class is immutable.
 */
public class Complexf implements Imaginaryf, Comparable<Complexf>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    /**
     * An immutable identity (0, 0) complex.
     */
    public static final Complexf ZERO = new Complexf(0, 0);
    /**
     * An immutable identity (1, 0) complex.
     */
    public static final Complexf IDENTITY = new Complexf(1, 0);
    private final float x;
    private final float y;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    /**
     * Constructs a new complex. The components are set to the identity (1, 0).
     */
    public Complexf() {
        this(1, 0);
    }

    /**
     * Constructs a new complex from the double components.
     *
     * @param x The x (real) component
     * @param y The y (imaginary) component
     */
    public Complexf(double x, double y) {
        this((float) x, (float) y);
    }

    /**
     * Constructs a new complex from the float components.
     *
     * @param x The x (real) component
     * @param y The y (imaginary) component
     */
    public Complexf(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param c The complex to copy
     */
    public Complexf(Complexf c) {
        this.x = c.x;
        this.y = c.y;
    }

    /**
     * Gets the x (real) component of this complex.
     *
     * @return The x (real) component
     */
    public float getX() {
        return x;
    }

    /**
     * Gets the y (imaginary) component of this complex.
     *
     * @return The y (imaginary) component
     */
    public float getY() {
        return y;
    }

    /**
     * Adds another complex to this one.
     *
     * @param c The complex to add
     * @return A new complex, which is the sum of both
     */
    public Complexf add(Complexf c) {
        return add(c.x, c.y);
    }

    /**
     * Adds the double components of another complex to this one.
     *
     * @param x The x (real) component of the complex to add
     * @param y The y (imaginary) component of the complex to add
     * @return A new complex, which is the sum of both
     */
    public Complexf add(double x, double y) {
        return add((float) x, (float) y);
    }

    /**
     * Adds the float components of another complex to this one.
     *
     * @param x The x (real) component of the complex to add
     * @param y The y (imaginary) component of the complex to add
     * @return A new complex, which is the sum of both
     */
    public Complexf add(float x, float y) {
        return new Complexf(this.x + x, this.y + y);
    }

    /**
     * Subtracts another complex from this one.
     *
     * @param c The complex to subtract
     * @return A new complex, which is the difference of both
     */
    public Complexf sub(Complexf c) {
        return sub(c.x, c.y);
    }

    /**
     * Subtracts the double components of another complex from this one.
     *
     * @param x The x (real) component of the complex to subtract
     * @param y The y (imaginary) component of the complex to subtract
     * @return A new complex, which is the difference of both
     */
    public Complexf sub(double x, double y) {
        return sub((float) x, (float) y);
    }

    /**
     * Subtracts the float components of another complex from this one.
     *
     * @param x The x (real) component of the complex to subtract
     * @param y The y (imaginary) component of the complex to subtract
     * @return A new complex, which is the difference of both
     */
    public Complexf sub(float x, float y) {
        return new Complexf(this.x - x, this.y - y);
    }

    /**
     * Multiplies the components of this complex by a double scalar.
     *
     * @param a The multiplication scalar
     * @return A new complex, which has each component multiplied by the scalar
     */
    public Complexf mul(double a) {
        return mul((float) a);
    }

    /**
     * Multiplies the components of this complex by a float scalar.
     *
     * @param a The multiplication scalar
     * @return A new complex, which has each component multiplied by the scalar
     */
    @Override
    public Complexf mul(float a) {
        return new Complexf(x * a, y * a);
    }

    /**
     * Multiplies another complex with this one.
     *
     * @param c The complex to multiply with
     * @return A new complex, which is the product of both
     */
    public Complexf mul(Complexf c) {
        return mul(c.x, c.y);
    }

    /**
     * Multiplies the double components of another complex with this one.
     *
     * @param x The x (real) component of the complex to multiply with
     * @param y The y (imaginary) component of the complex to multiply with
     * @return A new complex, which is the product of both
     */
    public Complexf mul(double x, double y) {
        return mul((float) x, (float) y);
    }

    /**
     * Multiplies the float components of another complex with this one.
     *
     * @param x The x (real) component of the complex to multiply with
     * @param y The y (imaginary) component of the complex to multiply with
     * @return A new complex, which is the product of both
     */
    public Complexf mul(float x, float y) {
        return new Complexf(
                this.x * x - this.y * y,
                this.x * y + this.y * x);
    }

    /**
     * Divides the components of this complex by a double scalar.
     *
     * @param a The division scalar
     * @return A new complex, which has each component divided by the scalar
     */
    public Complexf div(double a) {
        return div((float) a);
    }

    /**
     * Divides the components of this complex by a float scalar.
     *
     * @param a The division scalar
     * @return A new complex, which has each component divided by the scalar
     */
    @Override
    public Complexf div(float a) {
        return new Complexf(x / a, y / a);
    }

    /**
     * Divides this complex by another one.
     *
     * @param c The complex to divide with
     * @return The quotient of the two complexes
     */
    public Complexf div(Complexf c) {
        return div(c.x, c.y);
    }

    /**
     * Divides this complex by the double components of another one.
     *
     * @param x The x (real) component of the complex to divide with
     * @param y The y (imaginary) component of the complex to divide with
     * @return The quotient of the two complexes
     */
    public Complexf div(double x, double y) {
        return div((float) x, (float) y);
    }

    /**
     * Divides this complex by the float components of another one.
     *
     * @param x The x (real) component of the complex to divide with
     * @param y The y (imaginary) component of the complex to divide with
     * @return The quotient of the two complexes
     */
    public Complexf div(float x, float y) {
        final float d = x * x + y * y;
        return new Complexf(
                (this.x * x + this.y * y) / d,
                (this.y * x - this.x * y) / d);
    }

    /**
     * Returns the dot product of this complex with another one.
     *
     * @param c The complex to calculate the dot product with
     * @return The dot product of the two complexes
     */
    public float dot(Complexf c) {
        return dot(c.x, c.y);
    }

    /**
     * Returns the dot product of this complex with the double components of another one.
     *
     * @param x The x (real) component of the complex to calculate the dot product with
     * @param y The y (imaginary) component of the complex to calculate the dot product with
     * @return The dot product of the two complexes
     */
    public float dot(double x, double y) {
        return dot((float) x, (float) y);
    }

    /**
     * Returns the dot product of this complex with the float components of another one.
     *
     * @param x The x (real) component of the complex to calculate the dot product with
     * @param y The y (imaginary) component of the complex to calculate the dot product with
     * @return The dot product of the two complexes
     */
    public float dot(float x, float y) {
        return this.x * x + this.y * y;
    }

    /**
     * Rotates a vector by this complex.
     *
     * @param v The vector to rotate
     * @return The rotated vector
     */
    public Vector2f rotate(Vector2f v) {
        return rotate(v.getX(), v.getY());
    }

    /**
     * Rotates the double components of a vector by this complex.
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The rotated vector
     */
    public Vector2f rotate(double x, double y) {
        return rotate((float) x, (float) y);
    }

    /**
     * Rotates the float components of a vector by this complex.
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The rotated vector
     */
    public Vector2f rotate(float x, float y) {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot rotate by the zero complex");
        }
        final float nx = this.x / length;
        final float ny = this.y / length;
        return new Vector2f(x * nx - y * ny, y * nx + x * ny);
    }

    /**
     * Returns a unit vector pointing in the same direction as this complex on the complex plane.
     *
     * @return The vector representing the direction this complex is pointing to
     */
    public Vector2f getDirection() {
        return new Vector2f(x, y).normalize();
    }

    /**
     * Returns the angle in radians formed by the direction vector of this complex on the complex plane.
     *
     * @return The angle in radians of the direction vector of this complex
     */
    public float getAngleRad() {
        return (float) TrigMath.atan2(y, x);
    }

    /**
     * Returns the angle in degrees formed by the direction vector of this complex on the complex plane.
     *
     * @return The angle in degrees of the direction vector of this complex
     */
    public float getAngleDeg() {
        return (float) Math.toDegrees(getAngleRad());
    }

    /**
     * Returns the conjugate of this complex. <br> Conjugation of a complex <code>a</code> is an operation returning complex <code>a'</code> such that <code>a' * a = a * a' = |a|<sup>2</sup></code> where
     * <code>|a|<sup>2</sup></code> is squared length of <code>a</code>.
     *
     * @return A new complex, which is the conjugate of this one
     */
    @Override
    public Complexf conjugate() {
        return new Complexf(x, -y);
    }

    /**
     * Returns the inverse of this complex. <br> Inversion of a complex <code>a</code> returns complex <code>a<sup>-1</sup> = a' / |a|<sup>2</sup></code> where <code>a'</code> is {@link #conjugate()
     * conjugation} of <code>a</code>, and <code>|a|<sup>2</sup></code> is squared length of <code>a</code>. <br> For any complexes <code>a, b, c</code>, such that <code>a * b = c</code> equations
     * <code>a<sup>-1</sup> * c = b</code> and <code>c * b<sup>-1</sup> = a</code> are true.
     *
     * @return A new complex, which is the inverse of this one
     */
    @Override
    public Complexf invert() {
        final float lengthSquared = lengthSquared();
        if (Math.abs(lengthSquared) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot invert a complex of length zero");
        }
        return conjugate().div(lengthSquared);
    }

    /**
     * Returns the square of the length of this complex.
     *
     * @return The square of the length
     */
    @Override
    public float lengthSquared() {
        return x * x + y * y;
    }

    /**
     * Returns the length of this complex.
     *
     * @return The length
     */
    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * Normalizes this complex.
     *
     * @return A new complex of unit length
     */
    @Override
    public Complexf normalize() {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero complex");
        }
        return new Complexf(x / length, y / length);
    }

    /**
     * Converts this complex to a quaternion by
     * using (0, 0, 1) as a rotation axis.
     *
     * @return A quaternion of this rotation around the unit z
     */
    public Quaternionf toQuaternion() {
        return toQuaternion(Vector3f.UNIT_Z);
    }

    /**
     * Converts this complex to a quaternion by
     * using the provided vector as a rotation axis.
     *
     * @param axis The rotation axis
     * @return A quaternion of this rotation around the given axis
     */
    public Quaternionf toQuaternion(Vector3f axis) {
        return toQuaternion(axis.getX(), axis.getY(), axis.getZ());
    }

    /**
     * Converts this complex to a quaternion by
     * using the provided double components vector
     * as a rotation axis.
     *
     * @param x The x component of the axis vector
     * @param y The y component of the axis vector
     * @param z The z component of the axis vector
     * @return A quaternion of this rotation around the given axis
     */
    public Quaternionf toQuaternion(double x, double y, double z) {
        return toQuaternion((float) x, (float) y, (float) z);
    }

    /**
     * Converts this complex to a quaternion by
     * using the provided float components vector
     * as a rotation axis.
     *
     * @param x The x component of the axis vector
     * @param y The y component of the axis vector
     * @param z The z component of the axis vector
     * @return A quaternion of this rotation around the given axis
     */
    public Quaternionf toQuaternion(float x, float y, float z) {
        return Quaternionf.fromAngleRadAxis(getAngleRad(), x, y, z);
    }

    @Override
    public Complexf toFloat() {
        return new Complexf(x, y);
    }

    @Override
    public Complexd toDouble() {
        return new Complexd(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Complexf)) {
            return false;
        }
        final Complexf complex = (Complexf) o;
        if (Float.compare(complex.x, x) != 0) {
            return false;
        }
        if (Float.compare(complex.y, y) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            final int result = (x != +0.0f ? HashFunctions.hash(x) : 0);
            hashCode = 31 * result + (y != +0.0f ? HashFunctions.hash(y) : 0);
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public int compareTo(Complexf c) {
        return (int) Math.signum(lengthSquared() - c.lengthSquared());
    }

    @Override
    public Complexf clone() {
        return new Complexf(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Creates a new complex from the angle defined from the first to the second vector.
     *
     * @param from The first vector
     * @param to The second vector
     * @return The complex defined by the angle between the vectors
     */
    public static Complexf fromRotationTo(Vector2f from, Vector2f to) {
        return fromAngleRad(TrigMath.acos(from.dot(to) / (from.length() * to.length())));
    }

    /**
     * Creates a new complex from the angle defined from the first to the second vector.
     *
     * @param from The first vector
     * @param to The second vector
     * @return The complex defined by the angle between the vectors
     */
    public static Complexf fromRotationTo(Vector3f from, Vector3f to) {
        return fromAngleRad(TrigMath.acos(from.dot(to) / (from.length() * to.length())));
    }

    /**
     * Creates a new complex from the double angle in degrees.
     *
     * @param angle The angle in degrees
     * @return The complex defined by the angle
     */
    public static Complexf fromAngleDeg(double angle) {
        return fromAngleRad(Math.toRadians(angle));
    }

    /**
     * Creates a new complex from the double angle in radians.
     *
     * @param angle The angle in radians
     * @return The complex defined by the angle
     */
    public static Complexf fromAngleRad(double angle) {
        return fromAngleRad((float) angle);
    }

    /**
     * Creates a new complex from the float angle in radians.
     *
     * @param angle The angle in radians
     * @return The complex defined by the angle
     */
    public static Complexf fromAngleDeg(float angle) {
        return fromAngleRad((float) Math.toRadians(angle));
    }

    /**
     * Creates a new complex from the float angle in radians.
     *
     * @param angle The angle in radians
     * @return The complex defined by the angle
     */
    public static Complexf fromAngleRad(float angle) {
        return new Complexf(TrigMath.cos(angle), TrigMath.sin(angle));
    }
}
