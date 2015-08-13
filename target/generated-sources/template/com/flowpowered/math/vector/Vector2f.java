package com.flowpowered.math.vector;

import java.io.Serializable;
import java.lang.Override;
import java.util.Random;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;
import com.flowpowered.math.TrigMath;

public class Vector2f implements Vectorf, Comparable<Vector2f>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector2f ZERO = new Vector2f(0, 0);
    public static final Vector2f UNIT_X = new Vector2f(1, 0);
    public static final Vector2f UNIT_Y = new Vector2f(0, 1);
    public static final Vector2f ONE = new Vector2f(1, 1);
    private final float x;
    private final float y;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector2f() {
        this(0, 0);
    }

    public Vector2f(Vector2f v) {
        this(v.x, v.y);
    }

    public Vector2f(Vector3f v) {
        this(v.getX(), v.getY());
    }

    public Vector2f(Vector4f v) {
        this(v.getX(), v.getY());
    }

    public Vector2f(VectorNf v) {
        this(v.get(0), v.get(1));
    }

    public Vector2f(double x, double y) {
        this((float) x, (float) y);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getFloorX() {
        return GenericMath.floor(x);
    }

    public int getFloorY() {
        return GenericMath.floor(y);
    }

    public Vector2f add(Vector2f v) {
        return add(v.x, v.y);
    }

    public Vector2f add(double x, double y) {
        return add((float) x, (float) y);
    }

    public Vector2f add(float x, float y) {
        return new Vector2f(this.x + x, this.y + y);
    }

    public Vector2f sub(Vector2f v) {
        return sub(v.x, v.y);
    }

    public Vector2f sub(double x, double y) {
        return sub((float) x, (float) y);
    }

    public Vector2f sub(float x, float y) {
        return new Vector2f(this.x - x, this.y - y);
    }

    public Vector2f mul(double a) {
        return mul((float) a);
    }

    @Override
    public Vector2f mul(float a) {
        return mul(a, a);
    }

    public Vector2f mul(Vector2f v) {
        return mul(v.x, v.y);
    }

    public Vector2f mul(double x, double y) {
        return mul((float) x, (float) y);
    }

    public Vector2f mul(float x, float y) {
        return new Vector2f(this.x * x, this.y * y);
    }

    public Vector2f div(double a) {
        return div((float) a);
    }

    @Override
    public Vector2f div(float a) {
        return div(a, a);
    }

    public Vector2f div(Vector2f v) {
        return div(v.x, v.y);
    }

    public Vector2f div(double x, double y) {
        return div((float) x, (float) y);
    }

    public Vector2f div(float x, float y) {
        return new Vector2f(this.x / x, this.y / y);
    }

    public float dot(Vector2f v) {
        return dot(v.x, v.y);
    }

    public float dot(double x, double y) {
        return dot((float) x, (float) y);
    }

    public float dot(float x, float y) {
        return this.x * x + this.y * y;
    }

    public Vector2f project(Vector2f v) {
        return project(v.x, v.y);
    }

    public Vector2f project(double x, double y) {
        return project((float) x, (float) y);
    }

    public Vector2f project(float x, float y) {
        final float lengthSquared = x * x + y * y;
        if (Math.abs(lengthSquared) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final float a = dot(x, y) / lengthSquared;
        return new Vector2f(a * x, a * y);
    }

    public Vector2f pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public Vector2f pow(float power) {
        return new Vector2f(Math.pow(x, power), Math.pow(y, power));
    }

    @Override
    public Vector2f ceil() {
        return new Vector2f(Math.ceil(x), Math.ceil(y));
    }

    @Override
    public Vector2f floor() {
        return new Vector2f(GenericMath.floor(x), GenericMath.floor(y));
    }

    @Override
    public Vector2f round() {
        return new Vector2f(Math.round(x), Math.round(y));
    }

    @Override
    public Vector2f abs() {
        return new Vector2f(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2f negate() {
        return new Vector2f(-x, -y);
    }

    public Vector2f min(Vector2f v) {
        return min(v.x, v.y);
    }

    public Vector2f min(double x, double y) {
        return min((float) x, (float) y);
    }

    public Vector2f min(float x, float y) {
        return new Vector2f(Math.min(this.x, x), Math.min(this.y, y));
    }

    public Vector2f max(Vector2f v) {
        return max(v.x, v.y);
    }

    public Vector2f max(double x, double y) {
        return max((float) x, (float) y);
    }

    public Vector2f max(float x, float y) {
        return new Vector2f(Math.max(this.x, x), Math.max(this.y, y));
    }

    public float distanceSquared(Vector2f v) {
        return distanceSquared(v.x, v.y);
    }

    public float distanceSquared(double x, double y) {
        return distanceSquared((float) x, (float) y);
    }

    public float distanceSquared(float x, float y) {
        final float dx = this.x - x;
        final float dy = this.y - y;
        return dx * dx + dy * dy;
    }

    public float distance(Vector2f v) {
        return distance(v.x, v.y);
    }

    public float distance(double x, double y) {
        return distance((float) x, (float) y);
    }

    public float distance(float x, float y) {
        return (float) Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public float lengthSquared() {
        return x * x + y * y;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector2f normalize() {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        return new Vector2f(x / length, y / length);
    }

    /**
     * Return the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    @Override
    public int getMinAxis() {
        return x < y ? 0 : 1;
    }

    /**
     * Return the axis with the maximum value.
     *
     * @return {@link int} axis with maximum value
     */
    @Override
    public int getMaxAxis() {
        return x > y ? 0 : 1;
    }

    public Vector3f toVector3() {
        return toVector3(0);
    }

    public Vector3f toVector3(double z) {
        return toVector3((float) z);
    }

    public Vector3f toVector3(float z) {
        return new Vector3f(this, z);
    }

    public Vector4f toVector4() {
        return toVector4(0, 0);
    }

    public Vector4f toVector4(double z, double w) {
        return toVector4((float) z, (float) w);
    }

    public Vector4f toVector4(float z, float w) {
        return new Vector4f(this, z, w);
    }

    public VectorNf toVectorN() {
        return new VectorNf(this);
    }

    @Override
    public float[] toArray() {
        return new float[]{x, y};
    }

    @Override
    public Vector2i toInt() {
        return new Vector2i(x, y);
    }

    @Override
    public Vector2l toLong() {
        return new Vector2l(x, y);
    }

    @Override
    public Vector2f toFloat() {
        return new Vector2f(x, y);
    }

    @Override
    public Vector2d toDouble() {
        return new Vector2d(x, y);
    }

    @Override
    public int compareTo(Vector2f v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector2f)) {
            return false;
        }
        final Vector2f vector2 = (Vector2f) o;
        if (Float.compare(vector2.x, x) != 0) {
            return false;
        }
        if (Float.compare(vector2.y, y) != 0) {
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
    public Vector2f clone() {
        return new Vector2f(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Gets the direction vector of a random angle using the random specified.
     *
     * @param random to use
     * @return the random direction vector
     */
    public static Vector2f createRandomDirection(Random random) {
        return createDirectionRad(random.nextFloat() * (float) TrigMath.TWO_PI);
    }

    /**
     * Gets the direction vector of a certain angle in degrees.
     *
     * @param angle in degrees
     * @return the direction vector
     */
    public static Vector2f createDirectionDeg(double angle) {
        return createDirectionDeg((float) angle);
    }

    /**
     * Gets the direction vector of a certain angle in degrees.
     *
     * @param angle in degrees
     * @return the direction vector
     */
    public static Vector2f createDirectionDeg(float angle) {
        return createDirectionRad((float) Math.toRadians(angle));
    }

    /**
     * Gets the direction vector of a certain angle in radians.
     *
     * @param angle in radians
     * @return the direction vector
     */
    public static Vector2f createDirectionRad(double angle) {
        return createDirectionRad((float) angle);
    }

    /**
     * Gets the direction vector of a certain angle in radians.
     *
     * @param angle in radians
     * @return the direction vector
     */
    public static Vector2f createDirectionRad(float angle) {
        return new Vector2f(TrigMath.cos(angle), TrigMath.sin(angle));
    }
}
