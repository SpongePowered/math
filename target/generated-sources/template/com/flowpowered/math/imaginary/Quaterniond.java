package com.flowpowered.math.imaginary;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.TrigMath;
import com.flowpowered.math.matrix.Matrix3d;
import com.flowpowered.math.vector.Vector3d;

/**
 * Represent a quaternion of the form <code>xi + yj + zk + w</code>. The x, y, z and w components are stored as doubles. This class is immutable.
 */
public class Quaterniond implements Imaginaryd, Comparable<Quaterniond>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    /**
     * An immutable identity (0, 0, 0, 0) quaternion.
     */
    public static final Quaterniond ZERO = new Quaterniond(0, 0, 0, 0);
    /**
     * An immutable identity (0, 0, 0, 1) quaternion.
     */
    public static final Quaterniond IDENTITY = new Quaterniond(0, 0, 0, 1);
    private final double x;
    private final double y;
    private final double z;
    private final double w;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    /**
     * Constructs a new quaternion. The components are set to the identity (0, 0, 0, 1).
     */
    public Quaterniond() {
        this(0, 0, 0, 1);
    }

    /**
     * Constructs a new quaternion from the float components.
     *
     * @param x The x (imaginary) component
     * @param y The y (imaginary) component
     * @param z The z (imaginary) component
     * @param w The w (real) component
     */
    public Quaterniond(float x, float y, float z, float w) {
        this((double) x, (double) y, (double) z, (double) w);
    }

    /**
     * Constructs a new quaternion from the double components.
     *
     * @param x The x (imaginary) component
     * @param y The y (imaginary) component
     * @param z The z (imaginary) component
     * @param w The w (real) component
     */
    public Quaterniond(double x, double y, double z, double w) {
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
    public Quaterniond(Quaterniond q) {
        this(q.x, q.y, q.z, q.w);
    }

    /**
     * Gets the x (imaginary) component of this quaternion.
     *
     * @return The x (imaginary) component
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y (imaginary) component of this quaternion.
     *
     * @return The y (imaginary) component
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the z (imaginary) component of this quaternion.
     *
     * @return The z (imaginary) component
     */
    public double getZ() {
        return z;
    }

    /**
     * Gets the w (real) component of this quaternion.
     *
     * @return The w (real) component
     */
    public double getW() {
        return w;
    }

    /**
     * Adds another quaternion to this one.
     *
     * @param q The quaternion to add
     * @return A new quaternion, which is the sum of both
     */
    public Quaterniond add(Quaterniond q) {
        return add(q.x, q.y, q.z, q.w);
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
    public Quaterniond add(float x, float y, float z, float w) {
        return add((double) x, (double) y, (double) z, (double) w);
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
    public Quaterniond add(double x, double y, double z, double w) {
        return new Quaterniond(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    /**
     * Subtracts another quaternion from this one.
     *
     * @param q The quaternion to subtract
     * @return A new quaternion, which is the difference of both
     */
    public Quaterniond sub(Quaterniond q) {
        return sub(q.x, q.y, q.z, q.w);
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
    public Quaterniond sub(float x, float y, float z, float w) {
        return sub((double) x, (double) y, (double) z, (double) w);
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
    public Quaterniond sub(double x, double y, double z, double w) {
        return new Quaterniond(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    /**
     * Multiplies the components of this quaternion by a float scalar.
     *
     * @param a The multiplication scalar
     * @return A new quaternion, which has each component multiplied by the scalar
     */
    public Quaterniond mul(float a) {
        return mul((double) a);
    }

    /**
     * Multiplies the components of this quaternion by a double scalar.
     *
     * @param a The multiplication scalar
     * @return A new quaternion, which has each component multiplied by the scalar
     */
    @Override
    public Quaterniond mul(double a) {
        return new Quaterniond(x * a, y * a, z * a, w * a);
    }

    /**
     * Multiplies another quaternion with this one.
     *
     * @param q The quaternion to multiply with
     * @return A new quaternion, which is the product of both
     */
    public Quaterniond mul(Quaterniond q) {
        return mul(q.x, q.y, q.z, q.w);
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
    public Quaterniond mul(float x, float y, float z, float w) {
        return mul((double) x, (double) y, (double) z, (double) w);
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
    public Quaterniond mul(double x, double y, double z, double w) {
        return new Quaterniond(
                this.w * x + this.x * w + this.y * z - this.z * y,
                this.w * y + this.y * w + this.z * x - this.x * z,
                this.w * z + this.z * w + this.x * y - this.y * x,
                this.w * w - this.x * x - this.y * y - this.z * z);
    }

    /**
     * Divides the components of this quaternion by a float scalar.
     *
     * @param a The division scalar
     * @return A new quaternion, which has each component divided by the scalar
     */
    public Quaterniond div(float a) {
        return div((double) a);
    }

    /**
     * Divides the components of this quaternion by a double scalar.
     *
     * @param a The division scalar
     * @return A new quaternion, which has each component divided by the scalar
     */
    @Override
    public Quaterniond div(double a) {
        return new Quaterniond(x / a, y / a, z / a, w / a);
    }

    /**
     * Divides this quaternions by another one.
     *
     * @param q The quaternion to divide with
     * @return The quotient of the two quaternions
     */
    public Quaterniond div(Quaterniond q) {
        return div(q.x, q.y, q.z, q.w);
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
    public Quaterniond div(float x, float y, float z, float w) {
        return div((double) x, (double) y, (double) z, (double) w);
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
    public Quaterniond div(double x, double y, double z, double w) {
        final double d = x * x + y * y + z * z + w * w;
        return new Quaterniond(
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
    public double dot(Quaterniond q) {
        return dot(q.x, q.y, q.z, q.w);
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
    public double dot(float x, float y, float z, float w) {
        return dot((double) x, (double) y, (double) z, (double) w);
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
    public double dot(double x, double y, double z, double w) {
        return this.x * x + this.y * y + this.z * z + this.w * w;
    }

    /**
     * Rotates a vector by this quaternion.
     *
     * @param v The vector to rotate
     * @return The rotated vector
     */
    public Vector3d rotate(Vector3d v) {
        return rotate(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Rotates the float components of a vector by this quaternion.
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @param z The z component of the vector
     * @return The rotated vector
     */
    public Vector3d rotate(float x, float y, float z) {
        return rotate((double) x, (double) y, (double) z);
    }

    /**
     * Rotates the double components of a vector by this quaternion.
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @param z The z component of the vector
     * @return The rotated vector
     */
    public Vector3d rotate(double x, double y, double z) {
        final double length = length();
        if (Math.abs(length) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot rotate by the zero quaternion");
        }
        final double nx = this.x / length;
        final double ny = this.y / length;
        final double nz = this.z / length;
        final double nw = this.w / length;
        final double px = nw * x + ny * z - nz * y;
        final double py = nw * y + nz * x - nx * z;
        final double pz = nw * z + nx * y - ny * x;
        final double pw = -nx * x - ny * y - nz * z;
        return new Vector3d(
                pw * -nx + px * nw - py * nz + pz * ny,
                pw * -ny + py * nw - pz * nx + px * nz,
                pw * -nz + pz * nw - px * ny + py * nx);
    }

    /**
     * Returns a unit vector representing the direction of this quaternion, which is {@link Vector3d#FORWARD} rotated by this quaternion.
     *
     * @return The vector representing the direction this quaternion is pointing to
     */
    public Vector3d getDirection() {
        return rotate(Vector3d.FORWARD);
    }

    /**
     * Returns the axis of rotation for this quaternion.
     *
     * @return The axis of rotation
     */
    public Vector3d getAxis() {
        final double q = (double) Math.sqrt(1 - w * w);
        return new Vector3d(x / q, y / q, z / q);
    }

    /**
     * Returns the angles in degrees around the x, y and z axes that correspond to the rotation represented by this quaternion.
     *
     * @return The angle in degrees for each axis, stored in a vector, in the corresponding component
     */
    public Vector3d getAxesAnglesDeg() {
        return getAxesAnglesRad().mul(TrigMath.RAD_TO_DEG);
    }

    /**
     * Returns the angles in radians around the x, y and z axes that correspond to the rotation represented by this quaternion.
     *
     * @return The angle in radians for each axis, stored in a vector, in the corresponding component
     */
    public Vector3d getAxesAnglesRad() {
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
        return new Vector3d(pitch, yaw, roll);
    }

    /**
     * Conjugates the quaternion. <br> Conjugation of a quaternion <code>a</code> is an operation returning quaternion <code>a'</code> such that <code>a' * a = a * a' = |a|<sup>2</sup></code> where
     * <code>|a|<sup>2<sup/></code> is squared length of <code>a</code>.
     *
     * @return the conjugated quaternion
     */
    @Override
    public Quaterniond conjugate() {
        return new Quaterniond(-x, -y, -z, w);
    }

    /**
     * Inverts the quaternion. <br> Inversion of a quaternion <code>a</code> returns quaternion <code>a<sup>-1</sup> = a' / |a|<sup>2</sup></code> where <code>a'</code> is {@link #conjugate()
     * conjugation} of <code>a</code>, and <code>|a|<sup>2</sup></code> is squared length of <code>a</code>. <br> For any quaternions <code>a, b, c</code>, such that <code>a * b = c</code> equations
     * <code>a<sup>-1</sup> * c = b</code> and <code>c * b<sup>-1</sup> = a</code> are true.
     *
     * @return the inverted quaternion
     */
    @Override
    public Quaterniond invert() {
        final double lengthSquared = lengthSquared();
        if (Math.abs(lengthSquared) < GenericMath.DBL_EPSILON) {
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
    public double lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    /**
     * Returns the length of this quaternion.
     *
     * @return The length
     */
    @Override
    public double length() {
        return (double) Math.sqrt(lengthSquared());
    }

    /**
     * Normalizes this quaternion.
     *
     * @return A new quaternion of unit length
     */
    @Override
    public Quaterniond normalize() {
        final double length = length();
        if (Math.abs(length) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero quaternion");
        }
        return new Quaterniond(x / length, y / length, z / length, w / length);
    }

    /**
     * Converts this quaternion to a complex by extracting the rotation around
     * the axis and returning it as a rotation in the plane perpendicular to the
     * rotation axis.
     *
     * @return The rotation without the axis as a complex
     */
    public Complexd toComplex() {
        final double w2 = w * w;
        return new Complexd(2 * w2 - 1, 2 * w * (double) Math.sqrt(1 - w2));
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
        if (!(o instanceof Quaterniond)) {
            return false;
        }
        final Quaterniond quaternion = (Quaterniond) o;
        if (Double.compare(quaternion.w, w) != 0) {
            return false;
        }
        if (Double.compare(quaternion.x, x) != 0) {
            return false;
        }
        if (Double.compare(quaternion.y, y) != 0) {
            return false;
        }
        if (Double.compare(quaternion.z, z) != 0) {
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
    public int compareTo(Quaterniond q) {
        return (int) Math.signum(lengthSquared() - q.lengthSquared());
    }

    @Override
    public Quaterniond clone() {
        return new Quaterniond(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }

    /**
     * Creates a new quaternion from the float angles in degrees around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaterniond fromAxesAnglesDeg(float pitch, float yaw, float roll) {
        return fromAxesAnglesDeg((double) pitch, (double) yaw, (double) roll);
    }

    /**
     * Creates a new quaternion from the float angles in radians around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaterniond fromAxesAnglesRad(float pitch, float yaw, float roll) {
        return fromAxesAnglesRad((double) pitch, (double) yaw, (double) roll);
    }

    /**
     * Creates a new quaternion from the double angles in degrees around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaterniond fromAxesAnglesDeg(double pitch, double yaw, double roll) {
        return Quaterniond.fromAngleDegAxis(yaw, Vector3d.UNIT_Y).
                mul(Quaterniond.fromAngleDegAxis(pitch, Vector3d.UNIT_X)).
                mul(Quaterniond.fromAngleDegAxis(roll, Vector3d.UNIT_Z));
    }

    /**
     * Creates a new quaternion from the double angles in radians around the x, y and z axes.
     *
     * @param pitch The rotation around x
     * @param yaw The rotation around y
     * @param roll The rotation around z
     * @return The quaternion defined by the rotations around the axes
     */
    public static Quaterniond fromAxesAnglesRad(double pitch, double yaw, double roll) {
        return Quaterniond.fromAngleRadAxis(yaw, Vector3d.UNIT_Y).
                mul(Quaterniond.fromAngleRadAxis(pitch, Vector3d.UNIT_X)).
                mul(Quaterniond.fromAngleRadAxis(roll, Vector3d.UNIT_Z));
    }

    /**
     * Creates a new quaternion from the angle-axis rotation defined from the first to the second vector.
     *
     * @param from The first vector
     * @param to The second vector
     * @return The quaternion defined by the angle-axis rotation between the vectors
     */
    public static Quaterniond fromRotationTo(Vector3d from, Vector3d to) {
        return Quaterniond.fromAngleRadAxis(TrigMath.acos(from.dot(to) / (from.length() * to.length())), from.cross(to));
    }

    /**
     * Creates a new quaternion from the rotation float angle in degrees around the axis vector.
     *
     * @param angle The rotation angle in degrees
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaterniond fromAngleDegAxis(float angle, Vector3d axis) {
        return fromAngleRadAxis(Math.toRadians(angle), axis);
    }

    /**
     * Creates a new quaternion from the rotation float angle in radians around the axis vector.
     *
     * @param angle The rotation angle in radians
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaterniond fromAngleRadAxis(float angle, Vector3d axis) {
        return fromAngleRadAxis((double) angle, axis);
    }

    /**
     * Creates a new quaternion from the rotation double angle in degrees around the axis vector.
     *
     * @param angle The rotation angle in degrees
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaterniond fromAngleDegAxis(double angle, Vector3d axis) {
        return fromAngleRadAxis((double) Math.toRadians(angle), axis);
    }

    /**
     * Creates a new quaternion from the rotation double angle in radians around the axis vector.
     *
     * @param angle The rotation angle in radians
     * @param axis The axis of rotation
     * @return The quaternion defined by the rotation around the axis
     */
    public static Quaterniond fromAngleRadAxis(double angle, Vector3d axis) {
        return fromAngleRadAxis(angle, axis.getX(), axis.getY(), axis.getZ());
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
    public static Quaterniond fromAngleDegAxis(float angle, float x, float y, float z) {
        return fromAngleRadAxis(Math.toRadians(angle), x, y, z);
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
    public static Quaterniond fromAngleRadAxis(float angle, float x, float y, float z) {
        return fromAngleRadAxis((double) angle, (double) x, (double) y, (double) z);
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
    public static Quaterniond fromAngleDegAxis(double angle, double x, double y, double z) {
        return fromAngleRadAxis((double) Math.toRadians(angle), x, y, z);
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
    public static Quaterniond fromAngleRadAxis(double angle, double x, double y, double z) {
        final double halfAngle = angle / 2;
        final double q = TrigMath.sin(halfAngle) / (double) Math.sqrt(x * x + y * y + z * z);
        return new Quaterniond(x * q, y * q, z * q, TrigMath.cos(halfAngle));
    }

    /**
     * Creates a new quaternion from the rotation matrix. The matrix will be interpreted as a rotation matrix even if it is not.
     *
     * @param matrix The rotation matrix
     * @return The quaternion defined by the rotation matrix
     */
    public static Quaterniond fromRotationMatrix(Matrix3d matrix) {
        final double trace = matrix.trace();
        if (trace < 0) {
            if (matrix.get(1, 1) > matrix.get(0, 0)) {
                if (matrix.get(2, 2) > matrix.get(1, 1)) {
                    final double r = (double) Math.sqrt(matrix.get(2, 2) - matrix.get(0, 0) - matrix.get(1, 1) + 1);
                    final double s = 0.5f / r;
                    return new Quaterniond(
                            (matrix.get(2, 0) + matrix.get(0, 2)) * s,
                            (matrix.get(1, 2) + matrix.get(2, 1)) * s,
                            0.5f * r,
                            (matrix.get(1, 0) - matrix.get(0, 1)) * s);
                } else {
                    final double r = (double) Math.sqrt(matrix.get(1, 1) - matrix.get(2, 2) - matrix.get(0, 0) + 1);
                    final double s = 0.5f / r;
                    return new Quaterniond(
                            (matrix.get(0, 1) + matrix.get(1, 0)) * s,
                            0.5f * r,
                            (matrix.get(1, 2) + matrix.get(2, 1)) * s,
                            (matrix.get(0, 2) - matrix.get(2, 0)) * s);
                }
            } else if (matrix.get(2, 2) > matrix.get(0, 0)) {
                final double r = (double) Math.sqrt(matrix.get(2, 2) - matrix.get(0, 0) - matrix.get(1, 1) + 1);
                final double s = 0.5f / r;
                return new Quaterniond(
                        (matrix.get(2, 0) + matrix.get(0, 2)) * s,
                        (matrix.get(1, 2) + matrix.get(2, 1)) * s,
                        0.5f * r,
                        (matrix.get(1, 0) - matrix.get(0, 1)) * s);
            } else {
                final double r = (double) Math.sqrt(matrix.get(0, 0) - matrix.get(1, 1) - matrix.get(2, 2) + 1);
                final double s = 0.5f / r;
                return new Quaterniond(
                        0.5f * r,
                        (matrix.get(0, 1) + matrix.get(1, 0)) * s,
                        (matrix.get(2, 0) - matrix.get(0, 2)) * s,
                        (matrix.get(2, 1) - matrix.get(1, 2)) * s);
            }
        } else {
            final double r = (double) Math.sqrt(trace + 1);
            final double s = 0.5f / r;
            return new Quaterniond(
                    (matrix.get(2, 1) - matrix.get(1, 2)) * s,
                    (matrix.get(0, 2) - matrix.get(2, 0)) * s,
                    (matrix.get(1, 0) - matrix.get(0, 1)) * s,
                    0.5f * r);
        }
    }
}
