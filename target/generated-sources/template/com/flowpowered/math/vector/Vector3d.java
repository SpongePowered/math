package com.flowpowered.math.vector;

import java.io.Serializable;
import java.util.Random;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.TrigMath;

public class Vector3d implements Vectord, Comparable<Vector3d>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector3d ZERO = new Vector3d(0, 0, 0);
    public static final Vector3d UNIT_X = new Vector3d(1, 0, 0);
    public static final Vector3d UNIT_Y = new Vector3d(0, 1, 0);
    public static final Vector3d UNIT_Z = new Vector3d(0, 0, 1);
    public static final Vector3d ONE = new Vector3d(1, 1, 1);
    public static final Vector3d RIGHT = UNIT_X;
    public static final Vector3d UP = UNIT_Y;
    public static final Vector3d FORWARD = UNIT_Z;
    private final double x;
    private final double y;
    private final double z;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector3d() {
        this(0, 0, 0);
    }

    public Vector3d(Vector2d v) {
        this(v, 0);
    }

    public Vector3d(Vector2d v, float z) {
        this(v, (double) z);
    }

    public Vector3d(Vector2d v, double z) {
        this(v.getX(), v.getY(), z);
    }

    public Vector3d(Vector3d v) {
        this(v.x, v.y, v.z);
    }

    public Vector3d(Vector4d v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vector3d(VectorNd v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0);
    }

    public Vector3d(float x, float y, float z) {
        this((double) x, (double) y, (double) z);
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public int getFloorX() {
        return GenericMath.floor(x);
    }

    public int getFloorY() {
        return GenericMath.floor(y);
    }

    public int getFloorZ() {
        return GenericMath.floor(z);
    }

    public Vector3d add(Vector3d v) {
        return add(v.x, v.y, v.z);
    }

    public Vector3d add(float x, float y, float z) {
        return add((double) x, (double) y, (double) z);
    }

    public Vector3d add(double x, double y, double z) {
        return new Vector3d(this.x + x, this.y + y, this.z + z);
    }

    public Vector3d sub(Vector3d v) {
        return sub(v.x, v.y, v.z);
    }

    public Vector3d sub(float x, float y, float z) {
        return sub((double) x, (double) y, (double) z);
    }

    public Vector3d sub(double x, double y, double z) {
        return new Vector3d(this.x - x, this.y - y, this.z - z);
    }

    public Vector3d mul(float a) {
        return mul((double) a);
    }

    @Override
    public Vector3d mul(double a) {
        return mul(a, a, a);
    }

    public Vector3d mul(Vector3d v) {
        return mul(v.x, v.y, v.z);
    }

    public Vector3d mul(float x, float y, float z) {
        return mul((double) x, (double) y, (double) z);
    }

    public Vector3d mul(double x, double y, double z) {
        return new Vector3d(this.x * x, this.y * y, this.z * z);
    }

    public Vector3d div(float a) {
        return div((double) a);
    }

    @Override
    public Vector3d div(double a) {
        return div(a, a, a);
    }

    public Vector3d div(Vector3d v) {
        return div(v.x, v.y, v.z);
    }

    public Vector3d div(float x, float y, float z) {
        return div((double) x, (double) y, (double) z);
    }

    public Vector3d div(double x, double y, double z) {
        return new Vector3d(this.x / x, this.y / y, this.z / z);
    }

    public double dot(Vector3d v) {
        return dot(v.x, v.y, v.z);
    }

    public double dot(float x, float y, float z) {
        return dot((double) x, (double) y, (double) z);
    }

    public double dot(double x, double y, double z) {
        return this.x * x + this.y * y + this.z * z;
    }

    public Vector3d project(Vector3d v) {
        return project(v.x, v.y, v.z);
    }

    public Vector3d project(float x, float y, float z) {
        return project((double) x, (double) y, (double) z);
    }

    public Vector3d project(double x, double y, double z) {
        final double lengthSquared = x * x + y * y + z * z;
        if (Math.abs(lengthSquared) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = dot(x, y, z) / lengthSquared;
        return new Vector3d(a * x, a * y, a * z);
    }

    public Vector3d cross(Vector3d v) {
        return cross(v.x, v.y, v.z);
    }

    public Vector3d cross(float x, float y, float z) {
        return cross((double) x, (double) y, (double) z);
    }

    public Vector3d cross(double x, double y, double z) {
        return new Vector3d(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    public Vector3d pow(float pow) {
        return pow((double) pow);
    }

    @Override
    public Vector3d pow(double power) {
        return new Vector3d(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power));
    }

    @Override
    public Vector3d ceil() {
        return new Vector3d(Math.ceil(x), Math.ceil(y), Math.ceil(z));
    }

    @Override
    public Vector3d floor() {
        return new Vector3d(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z));
    }

    @Override
    public Vector3d round() {
        return new Vector3d(Math.round(x), Math.round(y), Math.round(z));
    }

    @Override
    public Vector3d abs() {
        return new Vector3d(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3d negate() {
        return new Vector3d(-x, -y, -z);
    }

    public Vector3d min(Vector3d v) {
        return min(v.x, v.y, v.z);
    }

    public Vector3d min(float x, float y, float z) {
        return min((double) x, (double) y, (double) z);
    }

    public Vector3d min(double x, double y, double z) {
        return new Vector3d(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    public Vector3d max(Vector3d v) {
        return max(v.x, v.y, v.z);
    }

    public Vector3d max(float x, float y, float z) {
        return max((double) x, (double) y, (double) z);
    }

    public Vector3d max(double x, double y, double z) {
        return new Vector3d(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    public double distanceSquared(Vector3d v) {
        return distanceSquared(v.x, v.y, v.z);
    }

    public double distanceSquared(float x, float y, float z) {
        return distanceSquared((double) x, (double) y, (double) z);
    }

    public double distanceSquared(double x, double y, double z) {
        final double dx = this.x - x;
        final double dy = this.y - y;
        final double dz = this.z - z;
        return dx * dx + dy * dy + dz * dz;
    }

    public double distance(Vector3d v) {
        return distance(v.x, v.y, v.z);
    }

    public double distance(float x, float y, float z) {
        return distance((double) x, (double) y, (double) z);
    }

    public double distance(double x, double y, double z) {
        return (double) Math.sqrt(distanceSquared(x, y, z));
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public double length() {
        return (double) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector3d normalize() {
        final double length = length();
        if (Math.abs(length) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        return new Vector3d(x / length, y / length, z / length);
    }

    /**
     * Returns the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    @Override
    public int getMinAxis() {
        return x < y ? (x < z ? 0 : 2) : (y < z ? 1 : 2);
    }

    /**
     * Returns the axis with the maximum value.
     *
     * @return {@link int} axis with maximum value
     */
    @Override
    public int getMaxAxis() {
        return x < y ? (y < z ? 2 : 1) : (x < z ? 2 : 0);
    }

    public Vector2d toVector2() {
        return new Vector2d(this);
    }

    public Vector2d toVector2(boolean useZ) {
        return new Vector2d(x, useZ ? z : y);
    }

    public Vector4d toVector4() {
        return toVector4(0);
    }

    public Vector4d toVector4(float w) {
        return toVector4((double) w);
    }

    public Vector4d toVector4(double w) {
        return new Vector4d(this, w);
    }

    public VectorNd toVectorN() {
        return new VectorNd(this);
    }

    @Override
    public double[] toArray() {
        return new double[]{x, y, z};
    }

    @Override
    public Vector3i toInt() {
        return new Vector3i(x, y, z);
    }

    @Override
    public Vector3l toLong() {
        return new Vector3l(x, y, z);
    }

    @Override
    public Vector3f toFloat() {
        return new Vector3f(x, y, z);
    }

    @Override
    public Vector3d toDouble() {
        return new Vector3d(x, y, z);
    }

    @Override
    public int compareTo(Vector3d v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector3d)) {
            return false;
        }
        final Vector3d vector3 = (Vector3d) o;
        if (Double.compare(vector3.x, x) != 0) {
            return false;
        }
        if (Double.compare(vector3.y, y) != 0) {
            return false;
        }
        if (Double.compare(vector3.z, z) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            int result = (x != +0.0f ? HashFunctions.hash(x) : 0);
            result = 31 * result + (y != +0.0f ? HashFunctions.hash(y) : 0);
            hashCode = 31 * result + (z != +0.0f ? HashFunctions.hash(z) : 0);
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public Vector3d clone() {
        return new Vector3d(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    /**
     * Gets the direction vector of a random pitch and yaw using the random specified.
     *
     * @param random to use
     * @return the random direction vector
     */
    public static Vector3d createRandomDirection(Random random) {
        return createDirectionRad(random.nextDouble() * (double) TrigMath.TWO_PI,
                random.nextDouble() * (double) TrigMath.TWO_PI);
    }

    /**
     * Gets the direction vector of a certain theta and phi in degrees. This uses the standard math spherical coordinate system.
     *
     * @param theta in degrees
     * @param phi in degrees
     * @return the direction vector
     */
    public static Vector3d createDirectionDeg(float theta, float phi) {
        return createDirectionDeg((double) theta, (double) phi);
    }

    /**
     * Gets the direction vector of a certain theta and phi in degrees. This uses the standard math spherical coordinate system.
     *
     * @param theta in degrees
     * @param phi in degrees
     * @return the direction vector
     */
    public static Vector3d createDirectionDeg(double theta, double phi) {
        return createDirectionRad((double) Math.toRadians(theta), (double) Math.toRadians(phi));
    }

    /**
     * Gets the direction vector of a certain theta and phi in radians. This uses the standard math spherical coordinate system.
     *
     * @param theta in radians
     * @param phi in radians
     * @return the direction vector
     */
    public static Vector3d createDirectionRad(float theta, float phi) {
        return createDirectionRad((double) theta, (double) phi);
    }

    /**
     * Gets the direction vector of a certain theta and phi in radians. This uses the standard math spherical coordinate system.
     *
     * @param theta in radians
     * @param phi in radians
     * @return the direction vector
     */
    public static Vector3d createDirectionRad(double theta, double phi) {
        final double f = TrigMath.sin(phi);
        return new Vector3d(f * TrigMath.cos(theta), f * TrigMath.sin(theta), TrigMath.cos(phi));
    }
}
