package com.flowpowered.math.imaginary;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.TrigMath;
import com.flowpowered.math.matrix.Matrix3f;
import com.flowpowered.math.vector.Vector3f;

/**
 * Represent a quaternion of the form <code>xi + yj + zk + w</code>. The x, y, z and w components are stored as floats. This class is immutable.
 */
public class Quaternionf implements Imaginaryf, Comparable<Quaternionf>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    /**
     * An immutable identity (0, 0, 0, 0) quaternion.
     */
    public static final Quaternionf ZERO = new Quaternionf(0, 0, 0, 0);
    /**
     * An immutable identity (0, 0, 0, 1) quaternion.
     */
    public static final Quaternionf IDENTITY = new Quaternionf(0, 0, 0, 1);
    private final float x;
    private final float y;
    private final float z;
    private final float w;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    /**
     * Constructs a new quaternion. The components are set to the identity (0, 0, 0, 1).
     */
    public Quaternionf() {
        this(0, 0, 0, 1);
    }

    /**
     * Constructs a new quaternion from the double components.
     *
     * @param x The x (imaginary) component
     * @param y The y (imaginary) component
     * @param z The z (imaginary) component
     * @param w The w (real) component
     */
    public Quaternionf(double x, double y, double z, double w) {
        this((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Constructs a new quaternion from the float components.
     *
     * @param x The x (imaginary) component
     * @param y The y (imaginary) component
     * @param z The z (imaginary) component
     * @param w The w (real) component
     */
    public Quaternionf(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor.
     *
     * @param q The quaternion to copy
     */
    public Quaternionf(Quaternionf q) {
        this(q.x, q.y, q.z, q.w);
    }

    /**
     * Gets the x (imaginary) component of this quaternion.
     *
     * @return The x (imaginary) component
     */
    public float getX() {
        return x;
    }

    /**
     * Gets the y (imaginary) component of this quaternion.
     *
     * @return The y (imaginary) component
     */
    public float getY() {
        return y;
    }

    /**
     * Gets the z (imaginary) component of this quaternion.
     *
     * @return The z (imaginary) component
     */
    public float getZ() {
        return z;
    }

    /**
     * Gets the w (real) component of this quaternion.
     *
     * @return The w (real) component
     */
    public float getW() {
        return w;
    }

    /**
     * Adds another quaternion to this one.
     *
     * @param q The quaternion to add
     * @return A new quaternion, which is the sum of both
     */
    public Quaternionf add(Quaternionf q) {
        return add(q.x, q.y, q.z, q.w);
    }

    /**
     * Adds the double components of another quaternion to this one.
     *
     * @param x The x (imaginary) component of the quaternion to add
     * @param y The y (imaginary) component of the quaternion to add
     * @param z The z (imaginary) component of the quaternion to add
     * @param w The w (real) component of the quaternion to add
     * @return A new quaternion, which is the sum of both
     */
    public Quaternionf add(double x, double y, double z, double w) {
        return add((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Adds the float components of another quaternion to this one.
     *
     * @param x The x (imaginary) component of the quaternion to add
     * @param y The y (imaginary) component of the quaternion to add
     * @param z The z (imaginary) component of the quaternion to add
     * @param w The w (real) component of the quaternion to add
     * @return A new quaternion, which is the sum of both
     */
    public Quaternionf add(float x, float y, float z, float w) {
        return new Quaternionf(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    /**
     * Subtracts another quaternion from this one.
     *
     * @param q The quaternion to subtract
     * @return A new quaternion, which is the difference of both
     */
    public Quaternionf sub(Quaternionf q) {
        return sub(q.x, q.y, q.z, q.w);
    }

    /**
     * Subtracts the double components of another quaternion from this one.
     *
     * @param x The x (imaginary) component of the quaternion to subtract
     * @param y The y (imaginary) component of the quaternion to subtract
     * @param z The z (imaginary) component of the quaternion to subtract
     * @param w The w (real) component of the quaternion to subtract
     * @return A new quaternion, which is the difference of both
     */
    public Quaternionf sub(double x, double y, double z, double w) {
        return sub((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Subtracts the float components of another quaternion from this one.
     *
     * @param x The x (imaginary) component of the quaternion to subtract
     * @param y The y (imaginary) component of the quaternion to subtract
     * @param z The z (imaginary) component of the quaternion to subtract
     * @param w The w (real) component of the quaternion to subtract
     * @return A new quaternion, which is the difference of both
     */
    public Quaternionf sub(float x, float y, float z, float w) {
        return new Quaternionf(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    /**
     * Multiplies the components of this quaternion by a double scalar.
     *
     * @param a The multiplication scalar
     * @return A new quaternion, which has each component multiplied by the scalar
     */
    public Quaternionf mul(double a) {
        return mul((float) a);
    }

    /**
     * Multiplies the components of this quaternion by a float scalar.
     *
     * @param a The multiplication scalar
     * @return A new quaternion, which has each component multiplied by the scalar
     */
    @Override
    public Quaternionf mul(float a) {
        return new Quaternionf(x * a, y * a, z * a, w * a);
    }

    /**
     * Multiplies another quaternion with this one.
     *
     * @param q The quaternion to multiply with
     * @return A new quaternion, which is the product of both
     */
    public Quaternionf mul(Quaternionf q) {
        return mul(q.x, q.y, q.z, q.w);
    }

    /**
     * Multiplies the double components of another quaternion with this one.
     *
     * @param x The x (imaginary) component of the quaternion to multiply with
     * @param y The y (imaginary) component of the quaternion to multiply with
     * @param z The z (imaginary) component of the quaternion to multiply with
     * @param w The w (real) component of the quaternion to multiply with
     * @return A new quaternion, which is the product of both
     */
    public Quaternionf mul(double x, double y, double z, double w) {
        return mul((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Multiplies the float components of another quaternion with this one.
     *
     * @param x The x (imaginary) component of the quaternion to multiply with
     * @param y The y (imaginary) component of the quaternion to multiply with
     * @param z The z (imaginary) component of the quaternion to multiply with
     * @param w The w (real) component of the quaternion to multiply with
     * @return A new quaternion, which is the product of both
     */
    public Quaternionf mul(float x, float y, float z, float w) {
        return new Quaternionf(
                this.w * x + this.x * w + this.y * z - this.z * y,
                this.w * y + this.y * w + this.z * x - this.x * z,
                this.w * z + this.z * w + this.x * y - this.y * x,
                this.w * w - this.x * x - this.y * y - this.z * z);
    }

    /**
     * Divides the components of this quaternion by a double scalar.
     *
     * @param a The division scalar
     * @return A new quaternion, which has each component divided by the scalar
     */
    public Quaternionf div(double a) {
        return div((float) a);
    }

    /**
     * Divides the components of this quaternion by a float scalar.
     *
     * @param a The division scalar
     * @return A new quaternion, which has each component divided by the scalar
     */
    @Override
    public Quaternionf div(float a) {
        return new Quaternionf(x / a, y / a, z / a, w / a);
    }

    /**
     * Divides this quaternions by another one.
     *
     * @param q The quaternion to divide with
     * @return The quotient of the two quaternions
     */
    public Quaternionf div(Quaternionf q) {
        return div(q.x, q.y, q.z, q.w);
    }

    /**
     * Divides this quaternions by the double components of another one.
     *
     * @param x The x (imaginary) component of the quaternion to divide with
     * @param y The y (imaginary) component of the quaternion to divide with
     * @param z The z (imaginary) component of the quaternion to divide with
     * @param w The w (real) component of the quaternion to divide with
     * @return The quotient of the two quaternions
     */
    public Quaternionf div(double x, double y, double z, double w) {
        return div((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Divides this quaternions by the float components of another one.
     *
     * @param x The x (imaginary) component of the quaternion to divide with
     * @param y The y (imaginary) component of the quaternion to divide with
     * @param z The z (imaginary) component of the quaternion to divide with
     * @param w The w (real) component of the quaternion to divide with
     * @return The quotient of the two quaternions
     */
    public Quaternionf div(float x, float y, float z, float w) {
        final float d = x * x + y * y + z * z + w * w;
        return new Quaternionf(
                (this.x * w - this.w * x - this.z * y + this.y * z) / d,
                (this.y * w + this.z * x - this.w * y - this.x * z) / d,
                (this.z * w - this.y * x + this.x * y - this.w * z) / d,
                (this.w * w + this.x * x + this.y * y + this.z * z) / d);
    }

    /**
     * Returns the dot product of this quaternion with another one.
     *
     * @param q The quaternion to calculate the dot product with
     * @return The dot product of the two quaternions
     */
    public float dot(Quaternionf q) {
        return dot(q.x, q.y, q.z, q.w);
    }

    /**
     * Returns the dot product of this quaternion with the double components of another one.
     *
     * @param x The x (imaginary) component of the quaternion to calculate the dot product with
     * @param y The y (imaginary) component of the quaternion to calculate the dot product with
     * @param z The z (imaginary) component of the quaternion to calculate the dot product with
     * @param w The w (real) component of the quaternion to calculate the dot product with
     * @return The dot product of the two quaternions
     */
    public float dot(double x, double y, double z, double w) {
        return dot((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Returns the dot product of this quaternion with the float components of another one.
     *
     * @param x The x (imaginary) component of the quaternion to calculate the dot product with
     * @param y The y (imaginary) component of the quaternion to calculate the dot product with
     * @param z The z (imaginary) component of the quaternion to calculate the dot product with
     * @param w The w (real) component of the quaternion to calculate the dot product with
     * @return The dot product of the two quaternions
     */
    public float dot(float x, float y, float z, float w) {
        return this.x * x + this.y * y + this.z * z + this.w * w;
    }

    /**
     * Rotates a vector by this quaternion.
     *
     * @param v The vector to rotate
     * @return The rotated vector
     */
    public Vector3f rotate(Vector3f v) {
        return rotate(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Rotates the double components of a vector by this quaternion.
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @param z The z component of the vector
     * @return The rotated vector
     */
    public Vector3f rotate(double x, double y, double z) {
        return rotate((float) x, (float) y, (float) z);
    }

    /**
     * Rotates the float components of a vector by this quaternion.
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @param z The z component of the vector
     * @return The rotated vector
     */
    public Vector3f rotate(float x, float y, float z) {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot rotate by the zero quaternion");
        }
        final float nx = this.x / length;
        final float ny = this.y / length;
        final float nz = this.z / length;
        final float nw = this.w / length;
        final float px = nw * x + ny * z - nz * y;
        final float py = nw * y + nz * x - nx * z;
        final float pz = nw * z + nx * y - ny * x;
        final float pw = -nx * x - ny * y - nz * z;
        return new Vector3f(
                pw * -nx + px * nw - py * nz + pz * ny,
                pw * -ny + py * nw - pz * nx + px * nz,
                pw * -nz + pz * nw - px * ny + py * nx);
    }

    /**
     * Returns a unit vector representing the direction of this quaternion, which is {@link Vector3f#FORWARD} rotated by this quaternion.
     *
     * @return The vector representing the direction this quaternion is pointing to
     */
    public Vector3f getDirection() {
        return rotate(Vector3f.FORWARD);
    }

    /**
     * Returns the axis of rotation for this quaternion.
     *
     * @return The axis of rotation
     */
    public Vector3f getAxis() {
        final float q = (float) Math.sqrt(1 - w * w);
        return new Vector3f(x / q, y / q, z / q);
    }

    /**
     * Returns the angles in degrees around the x, y and z axes that correspond to the rotation represented by this quaternion.
     *
     * @return The angle in degrees for each axis, stored in a vector, in the corresponding component
     */
    public Vector3f getAxesAnglesDeg() {
        return getAxesAnglesRad().mul(TrigMath.RAD_TO_DEG);
    }

    /**
     * Returns the angles in radians around the x, y and z axes that correspond to the rotation represented by this quaternion.
     *
     * @return The angle in radians for each axis, stored in a vector, in the corresponding component
     */
    public Vector3f getAxesAnglesRad() {
        final double roll;
        final double pitch;
        double yaw;
        final double test = w * x - y * z;
        if (Math.abs(test) < 0.4999) {
            roll = TrigMath.atan2(2 * (w * z + x * y), 1 - 2 * (x * x + z * z));
            pitch = TrigMath.asin(2 * test);
            yaw = TrigMath.atan2(2 * (w * y + z * x), 1 - 2 * (x * x + y * y));
        } else {
            final int sign = (test < 0) ? -1 : 1;
            roll = 0;
            pitch = sign * Math.PI / 2;
            yaw = -sign * 2 * TrigMath.atan2(z, w);
        }
        return new Vector3f(pitch, yaw, roll);
    }

    /**
     * Conjugates the quaternion. <br> Conjugation of a quaternion <code>a</code> is an operation returning quaternion <code>a'</code> such that <code>a' * a = a * a' = |a|<sup>2</sup></code> where
     * <code>|a|<sup>2<sup/></code> is squared length of <code>a</code>.
     *
     * @return the conjugated quaternion
     */
    @Override
    public Quaternionf conjugate() {
        return new Quaternionf(-x, -y, -z, w);
    }

    /**
     * Inverts the quaternion. <br> Inversion of a quaternion <code>a</code> returns quaternion <code>a<sup>-1</sup> = a' / |a|<sup>2</sup></code> where <code>a'</code> is {@link #conjugate()
     * conjugation} of <code>a</code>, and <code>|a|<sup>2</sup></code> is squared length of <code>a</code>. <br> For any quaternions <code>a, b, c</code>, such that <code>a * b = c</code> equations
     * <code>a<sup>-1</sup> * c = b</code> and <code>c * b<sup>-1</sup> = a</code> are true.
     *
     * @return the inverted quaternion
     */
    @Override
    public Quaternionf invert() {
        final float lengthSquared = lengthSquared();
        if (Math.abs(lengthSquared) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot invert a quaternion of length zero");
        }
        return conjugate().div(lengthSquared);
    }

    /**
     * Returns the square of the length of this quaternion.
     *
     * @return The square of the length
     */
    @Override
    public float lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    /**
     * Returns the length of this quaternion.
     *
     * @return The length
     */
    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * Normalizes this quaternion.
     *
     * @return A new quaternion of unit length
     */
    @Override
    public Quaternionf normalize() {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero quaternion");
        }
        return new Quaternionf(x / length, y / length, z / length, w / length);
    }

    /**
     * Converts this quaternion to a complex by extracting the rotation around
     * the axis and returning it as a rotation in the plane perpendicular to the
     * rotation axis.
     *
     * @return The rotation without the axis as a complex
     */
    public Complexf toComplex() {
        final float w2 = w * w;
        return new Complexf(2 * w2 - 1, 2 * w * (float) Math.sqrt(1 - w2));
    }

    @Override
    public Quaternionf toFloat() {
        return new Quaternionf(x, y, z, w);
    }

    @Override
    public Quaterniond toDouble() {
        return new Quaterniond(x, y, z, w);
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quaternionf)) {
            return false;
        }
        final Quaternionf quaternion = (Quaternionf) o;
        if (Float.compare(quaternion.w, w) != 0) {
            return false;
        }
        if (Float.compare(quaternion.x, x) != 0) {
            return false;
        }
        if (Float.compare(quaternion.y, y) != 0) {
            return false;
        }
        if (Float.compare(quaternion.z, z) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            int result = (x != +0.0f ? HashFunctions.hash(x) : 0);
            result = 31 * result + (y != +0.0f ? HashFunctions.hash(y) : 0);
            result = 31 * result + (z != +0.0f ? HashFunctions.hash(z) : 0);
            hashCode = 31 * result + (w != +0.0f ? HashFunctions.hash(w) : 0);
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public int compareTo(Quaternionf q) {
        return (int) Math.signum(lengthSquared() - q.lengthSquared());
    }

    @Override
    public Quaternionf clone() {
        return new Quaternionf(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }

    /**
     * Creates a new quaternion from the double angles in degrees around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaternionf fromAxesAnglesDeg(double pitch, double yaw, double roll) {
        return fromAxesAnglesDeg((float) pitch, (float) yaw, (float) roll);
    }

    /**
     * Creates a new quaternion from the double angles in radians around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaternionf fromAxesAnglesRad(double pitch, double yaw, double roll) {
        return fromAxesAnglesRad((float) pitch, (float) yaw, (float) roll);
    }

    /**
     * Creates a new quaternion from the float angles in degrees around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaternionf fromAxesAnglesDeg(float pitch, float yaw, float roll) {
        return Quaternionf.fromAngleDegAxis(yaw, Vector3f.UNIT_Y).
                mul(Quaternionf.fromAngleDegAxis(pitch, Vector3f.UNIT_X)).
                mul(Quaternionf.fromAngleDegAxis(roll, Vector3f.UNIT_Z));
    }

    /**
     * Creates a new quaternion from the float angles in radians around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaternionf fromAxesAnglesRad(float pitch, float yaw, float roll) {
        return Quaternionf.fromAngleRadAxis(yaw, Vector3f.UNIT_Y).
                mul(Quaternionf.fromAngleRadAxis(pitch, Vector3f.UNIT_X)).
                mul(Quaternionf.fromAngleRadAxis(roll, Vector3f.UNIT_Z));
    }

    /**
     * Creates a new quaternion from the angle-axis rotation defined from the first to the second vector.
     *
     * @param from The first vector
     * @param to The second vector
     * @return The quaternion defined by the angle-axis rotation between the vectors
     */
    public static Quaternionf fromRotationTo(Vector3f from, Vector3f to) {
        return Quaternionf.fromAngleRadAxis(TrigMath.acos(from.dot(to) / (from.length() * to.length())), from.cross(to));
    }

    /**
     * Creates a new quaternion from the rotation double angle in degrees around the axis vector.
     *
     * @param angle The rotation angle in degrees
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleDegAxis(double angle, Vector3f axis) {
        return fromAngleRadAxis(Math.toRadians(angle), axis);
    }

    /**
     * Creates a new quaternion from the rotation double angle in radians around the axis vector.
     *
     * @param angle The rotation angle in radians
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleRadAxis(double angle, Vector3f axis) {
        return fromAngleRadAxis((float) angle, axis);
    }

    /**
     * Creates a new quaternion from the rotation float angle in degrees around the axis vector.
     *
     * @param angle The rotation angle in degrees
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleDegAxis(float angle, Vector3f axis) {
        return fromAngleRadAxis((float) Math.toRadians(angle), axis);
    }

    /**
     * Creates a new quaternion from the rotation float angle in radians around the axis vector.
     *
     * @param angle The rotation angle in radians
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleRadAxis(float angle, Vector3f axis) {
        return fromAngleRadAxis(angle, axis.getX(), axis.getY(), axis.getZ());
    }

    /**
     * Creates a new quaternion from the rotation double angle in degrees around the axis vector double components.
     *
     * @param angle The rotation angle in degrees
     * @param x The x component of the axis vector
     * @param y The y component of the axis vector
     * @param z The z component of the axis vector
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleDegAxis(double angle, double x, double y, double z) {
        return fromAngleRadAxis(Math.toRadians(angle), x, y, z);
    }

    /**
     * Creates a new quaternion from the rotation double angle in radians around the axis vector double components.
     *
     * @param angle The rotation angle in radians
     * @param x The x component of the axis vector
     * @param y The y component of the axis vector
     * @param z The z component of the axis vector
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleRadAxis(double angle, double x, double y, double z) {
        return fromAngleRadAxis((float) angle, (float) x, (float) y, (float) z);
    }

    /**
     * Creates a new quaternion from the rotation float angle in degrees around the axis vector float components.
     *
     * @param angle The rotation angle in degrees
     * @param x The x component of the axis vector
     * @param y The y component of the axis vector
     * @param z The z component of the axis vector
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleDegAxis(float angle, float x, float y, float z) {
        return fromAngleRadAxis((float) Math.toRadians(angle), x, y, z);
    }

    /**
     * Creates a new quaternion from the rotation float angle in radians around the axis vector float components.
     *
     * @param angle The rotation angle in radians
     * @param x The x component of the axis vector
     * @param y The y component of the axis vector
     * @param z The z component of the axis vector
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaternionf fromAngleRadAxis(float angle, float x, float y, float z) {
        final float halfAngle = angle / 2;
        final float q = TrigMath.sin(halfAngle) / (float) Math.sqrt(x * x + y * y + z * z);
        return new Quaternionf(x * q, y * q, z * q, TrigMath.cos(halfAngle));
    }

    /**
     * Creates a new quaternion from the rotation matrix. The matrix will be interpreted as a rotation matrix even if it is not.
     *
     * @param matrix The rotation matrix
     * @return The quaternion defined by the rotation matrix
     */
    public static Quaternionf fromRotationMatrix(Matrix3f matrix) {
        final float trace = matrix.trace();
        if (trace < 0) {
            if (matrix.get(1, 1) > matrix.get(0, 0)) {
                if (matrix.get(2, 2) > matrix.get(1, 1)) {
                    final float r = (float) Math.sqrt(matrix.get(2, 2) - matrix.get(0, 0) - matrix.get(1, 1) + 1);
                    final float s = 0.5f / r;
                    return new Quaternionf(
                            (matrix.get(2, 0) + matrix.get(0, 2)) * s,
                            (matrix.get(1, 2) + matrix.get(2, 1)) * s,
                            0.5f * r,
                            (matrix.get(1, 0) - matrix.get(0, 1)) * s);
                } else {
                    final float r = (float) Math.sqrt(matrix.get(1, 1) - matrix.get(2, 2) - matrix.get(0, 0) + 1);
                    final float s = 0.5f / r;
                    return new Quaternionf(
                            (matrix.get(0, 1) + matrix.get(1, 0)) * s,
                            0.5f * r,
                            (matrix.get(1, 2) + matrix.get(2, 1)) * s,
                            (matrix.get(0, 2) - matrix.get(2, 0)) * s);
                }
            } else if (matrix.get(2, 2) > matrix.get(0, 0)) {
                final float r = (float) Math.sqrt(matrix.get(2, 2) - matrix.get(0, 0) - matrix.get(1, 1) + 1);
                final float s = 0.5f / r;
                return new Quaternionf(
                        (matrix.get(2, 0) + matrix.get(0, 2)) * s,
                        (matrix.get(1, 2) + matrix.get(2, 1)) * s,
                        0.5f * r,
                        (matrix.get(1, 0) - matrix.get(0, 1)) * s);
            } else {
                final float r = (float) Math.sqrt(matrix.get(0, 0) - matrix.get(1, 1) - matrix.get(2, 2) + 1);
                final float s = 0.5f / r;
                return new Quaternionf(
                        0.5f * r,
                        (matrix.get(0, 1) + matrix.get(1, 0)) * s,
                        (matrix.get(2, 0) - matrix.get(0, 2)) * s,
                        (matrix.get(2, 1) - matrix.get(1, 2)) * s);
            }
        } else {
            final float r = (float) Math.sqrt(trace + 1);
            final float s = 0.5f / r;
            return new Quaternionf(
                    (matrix.get(2, 1) - matrix.get(1, 2)) * s,
                    (matrix.get(0, 2) - matrix.get(2, 0)) * s,
                    (matrix.get(1, 0) - matrix.get(0, 1)) * s,
                    0.5f * r);
        }
    }
}
