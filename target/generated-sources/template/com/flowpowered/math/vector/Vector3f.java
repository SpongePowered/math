package com.flowpowered.math.vector;

import java.io.Serializable;
import java.util.Random;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.TrigMath;

public class Vector3f implements Vectorf, Comparable<Vector3f>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector3f ZERO = new Vector3f(0, 0, 0);
    public static final Vector3f UNIT_X = new Vector3f(1, 0, 0);
    public static final Vector3f UNIT_Y = new Vector3f(0, 1, 0);
    public static final Vector3f UNIT_Z = new Vector3f(0, 0, 1);
    public static final Vector3f ONE = new Vector3f(1, 1, 1);
    public static final Vector3f RIGHT = UNIT_X;
    public static final Vector3f UP = UNIT_Y;
    public static final Vector3f FORWARD = UNIT_Z;
    private final float x;
    private final float y;
    private final float z;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector3f() {
        this(0, 0, 0);
    }

    public Vector3f(Vector2f v) {
        this(v, 0);
    }

    public Vector3f(Vector2f v, double z) {
        this(v, (float) z);
    }

    public Vector3f(Vector2f v, float z) {
        this(v.getX(), v.getY(), z);
    }

    public Vector3f(Vector3f v) {
        this(v.x, v.y, v.z);
    }

    public Vector3f(Vector4f v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vector3f(VectorNf v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0);
    }

    public Vector3f(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
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

    public Vector3f add(Vector3f v) {
        return add(v.x, v.y, v.z);
    }

    public Vector3f add(double x, double y, double z) {
        return add((float) x, (float) y, (float) z);
    }

    public Vector3f add(float x, float y, float z) {
        return new Vector3f(this.x + x, this.y + y, this.z + z);
    }

    public Vector3f sub(Vector3f v) {
        return sub(v.x, v.y, v.z);
    }

    public Vector3f sub(double x, double y, double z) {
        return sub((float) x, (float) y, (float) z);
    }

    public Vector3f sub(float x, float y, float z) {
        return new Vector3f(this.x - x, this.y - y, this.z - z);
    }

    public Vector3f mul(double a) {
        return mul((float) a);
    }

    @Override
    public Vector3f mul(float a) {
        return mul(a, a, a);
    }

    public Vector3f mul(Vector3f v) {
        return mul(v.x, v.y, v.z);
    }

    public Vector3f mul(double x, double y, double z) {
        return mul((float) x, (float) y, (float) z);
    }

    public Vector3f mul(float x, float y, float z) {
        return new Vector3f(this.x * x, this.y * y, this.z * z);
    }

    public Vector3f div(double a) {
        return div((float) a);
    }

    @Override
    public Vector3f div(float a) {
        return div(a, a, a);
    }

    public Vector3f div(Vector3f v) {
        return div(v.x, v.y, v.z);
    }

    public Vector3f div(double x, double y, double z) {
        return div((float) x, (float) y, (float) z);
    }

    public Vector3f div(float x, float y, float z) {
        return new Vector3f(this.x / x, this.y / y, this.z / z);
    }

    public float dot(Vector3f v) {
        return dot(v.x, v.y, v.z);
    }

    public float dot(double x, double y, double z) {
        return dot((float) x, (float) y, (float) z);
    }

    public float dot(float x, float y, float z) {
        return this.x * x + this.y * y + this.z * z;
    }

    public Vector3f project(Vector3f v) {
        return project(v.x, v.y, v.z);
    }

    public Vector3f project(double x, double y, double z) {
        return project((float) x, (float) y, (float) z);
    }

    public Vector3f project(float x, float y, float z) {
        final float lengthSquared = x * x + y * y + z * z;
        if (Math.abs(lengthSquared) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final float a = dot(x, y, z) / lengthSquared;
        return new Vector3f(a * x, a * y, a * z);
    }

    public Vector3f cross(Vector3f v) {
        return cross(v.x, v.y, v.z);
    }

    public Vector3f cross(double x, double y, double z) {
        return cross((float) x, (float) y, (float) z);
    }

    public Vector3f cross(float x, float y, float z) {
        return new Vector3f(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    public Vector3f pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public Vector3f pow(float power) {
        return new Vector3f(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power));
    }

    @Override
    public Vector3f ceil() {
        return new Vector3f(Math.ceil(x), Math.ceil(y), Math.ceil(z));
    }

    @Override
    public Vector3f floor() {
        return new Vector3f(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z));
    }

    @Override
    public Vector3f round() {
        return new Vector3f(Math.round(x), Math.round(y), Math.round(z));
    }

    @Override
    public Vector3f abs() {
        return new Vector3f(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3f negate() {
        return new Vector3f(-x, -y, -z);
    }

    public Vector3f min(Vector3f v) {
        return min(v.x, v.y, v.z);
    }

    public Vector3f min(double x, double y, double z) {
        return min((float) x, (float) y, (float) z);
    }

    public Vector3f min(float x, float y, float z) {
        return new Vector3f(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    public Vector3f max(Vector3f v) {
        return max(v.x, v.y, v.z);
    }

    public Vector3f max(double x, double y, double z) {
        return max((float) x, (float) y, (float) z);
    }

    public Vector3f max(float x, float y, float z) {
        return new Vector3f(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    public float distanceSquared(Vector3f v) {
        return distanceSquared(v.x, v.y, v.z);
    }

    public float distanceSquared(double x, double y, double z) {
        return distanceSquared((float) x, (float) y, (float) z);
    }

    public float distanceSquared(float x, float y, float z) {
        final float dx = this.x - x;
        final float dy = this.y - y;
        final float dz = this.z - z;
        return dx * dx + dy * dy + dz * dz;
    }

    public float distance(Vector3f v) {
        return distance(v.x, v.y, v.z);
    }

    public float distance(double x, double y, double z) {
        return distance((float) x, (float) y, (float) z);
    }

    public float distance(float x, float y, float z) {
        return (float) Math.sqrt(distanceSquared(x, y, z));
    }

    @Override
    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector3f normalize() {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        return new Vector3f(x / length, y / length, z / length);
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

    public Vector2f toVector2() {
        return new Vector2f(this);
    }

    public Vector2f toVector2(boolean useZ) {
        return new Vector2f(x, useZ ? z : y);
    }

    public Vector4f toVector4() {
        return toVector4(0);
    }

    public Vector4f toVector4(double w) {
        return toVector4((float) w);
    }

    public Vector4f toVector4(float w) {
        return new Vector4f(this, w);
    }

    public VectorNf toVectorN() {
        return new VectorNf(this);
    }

    @Override
    public float[] toArray() {
        return new float[]{x, y, z};
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
    public int compareTo(Vector3f v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector3f)) {
            return false;
        }
        final Vector3f vector3 = (Vector3f) o;
        if (Float.compare(vector3.x, x) != 0) {
            return false;
        }
        if (Float.compare(vector3.y, y) != 0) {
            return false;
        }
        if (Float.compare(vector3.z, z) != 0) {
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
    public Vector3f clone() {
        return new Vector3f(this);
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
    public static Vector3f createRandomDirection(Random random) {
        return createDirectionRad(random.nextFloat() * (float) TrigMath.TWO_PI,
                random.nextFloat() * (float) TrigMath.TWO_PI);
    }

    /**
     * Gets the direction vector of a certain theta and phi in degrees. This uses the standard math spherical coordinate system.
     *
     * @param theta in degrees
     * @param phi in degrees
     * @return the direction vector
     */
    public static Vector3f createDirectionDeg(double theta, double phi) {
        return createDirectionDeg((float) theta, (float) phi);
    }

    /**
     * Gets the direction vector of a certain theta and phi in degrees. This uses the standard math spherical coordinate system.
     *
     * @param theta in degrees
     * @param phi in degrees
     * @return the direction vector
     */
    public static Vector3f createDirectionDeg(float theta, float phi) {
        return createDirectionRad((float) Math.toRadians(theta), (float) Math.toRadians(phi));
    }

    /**
     * Gets the direction vector of a certain theta and phi in radians. This uses the standard math spherical coordinate system.
     *
     * @param theta in radians
     * @param phi in radians
     * @return the direction vector
     */
    public static Vector3f createDirectionRad(double theta, double phi) {
        return createDirectionRad((float) theta, (float) phi);
    }

    /**
     * Gets the direction vector of a certain theta and phi in radians. This uses the standard math spherical coordinate system.
     *
     * @param theta in radians
     * @param phi in radians
     * @return the direction vector
     */
    public static Vector3f createDirectionRad(float theta, float phi) {
        final float f = TrigMath.sin(phi);
        return new Vector3f(f * TrigMath.cos(theta), f * TrigMath.sin(theta), TrigMath.cos(phi));
    }
}
