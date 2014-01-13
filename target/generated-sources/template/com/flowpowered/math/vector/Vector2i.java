package com.flowpowered.math.vector;

import java.io.Serializable;
import java.lang.Override;
import java.util.Random;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector2i implements Vectori, Comparable<Vector2i>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector2i ZERO = new Vector2i(0, 0);
    public static final Vector2i UNIT_X = new Vector2i(1, 0);
    public static final Vector2i UNIT_Y = new Vector2i(0, 1);
    public static final Vector2i ONE = new Vector2i(1, 1);
    private final int x;
    private final int y;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector2i() {
        this(0, 0);
    }

    public Vector2i(Vector2i v) {
        this(v.x, v.y);
    }

    public Vector2i(Vector3i v) {
        this(v.getX(), v.getY());
    }

    public Vector2i(Vector4i v) {
        this(v.getX(), v.getY());
    }

    public Vector2i(VectorNi v) {
        this(v.get(0), v.get(1));
    }

    public Vector2i(double x, double y) {
        this((int) x, (int) y);
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2i add(Vector2i v) {
        return add(v.x, v.y);
    }

    public Vector2i add(double x, double y) {
        return add((int) x, (int) y);
    }

    public Vector2i add(int x, int y) {
        return new Vector2i(this.x + x, this.y + y);
    }

    public Vector2i sub(Vector2i v) {
        return sub(v.x, v.y);
    }

    public Vector2i sub(double x, double y) {
        return sub((int) x, (int) y);
    }

    public Vector2i sub(int x, int y) {
        return new Vector2i(this.x - x, this.y - y);
    }

    public Vector2i mul(double a) {
        return mul((int) a);
    }

    @Override
    public Vector2i mul(int a) {
        return mul(a, a);
    }

    public Vector2i mul(Vector2i v) {
        return mul(v.x, v.y);
    }

    public Vector2i mul(double x, double y) {
        return mul((int) x, (int) y);
    }

    public Vector2i mul(int x, int y) {
        return new Vector2i(this.x * x, this.y * y);
    }

    public Vector2i div(double a) {
        return div((int) a);
    }

    @Override
    public Vector2i div(int a) {
        return div(a, a);
    }

    public Vector2i div(Vector2i v) {
        return div(v.x, v.y);
    }

    public Vector2i div(double x, double y) {
        return div((int) x, (int) y);
    }

    public Vector2i div(int x, int y) {
        return new Vector2i(this.x / x, this.y / y);
    }

    public int dot(Vector2i v) {
        return dot(v.x, v.y);
    }

    public int dot(double x, double y) {
        return dot((int) x, (int) y);
    }

    public int dot(int x, int y) {
        return (int) (this.x * x + this.y * y);
    }

    public Vector2i pow(double pow) {
        return pow((int) pow);
    }

    @Override
    public Vector2i pow(int power) {
        return new Vector2i(Math.pow(x, power), Math.pow(y, power));
    }

    @Override
    public Vector2i abs() {
        return new Vector2i(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2i negate() {
        return new Vector2i(-x, -y);
    }

    public Vector2i min(Vector2i v) {
        return min(v.x, v.y);
    }

    public Vector2i min(double x, double y) {
        return min((int) x, (int) y);
    }

    public Vector2i min(int x, int y) {
        return new Vector2i(Math.min(this.x, x), Math.min(this.y, y));
    }

    public Vector2i max(Vector2i v) {
        return max(v.x, v.y);
    }

    public Vector2i max(double x, double y) {
        return max((int) x, (int) y);
    }

    public Vector2i max(int x, int y) {
        return new Vector2i(Math.max(this.x, x), Math.max(this.y, y));
    }

    public int distanceSquared(Vector2i v) {
        return distanceSquared(v.x, v.y);
    }

    public int distanceSquared(double x, double y) {
        return distanceSquared((int) x, (int) y);
    }

    public int distanceSquared(int x, int y) {
        return (int) GenericMath.lengthSquared(this.x - x, this.y - y);
    }

    public int distance(Vector2i v) {
        return distance(v.x, v.y);
    }

    public int distance(double x, double y) {
        return distance((int) x, (int) y);
    }

    public int distance(int x, int y) {
        return (int) GenericMath.length(this.x - x, this.y - y);
    }

    @Override
    public int lengthSquared() {
        return (int) GenericMath.lengthSquared(x, y);
    }

    @Override
    public int length() {
        return (int) GenericMath.length(x, y);
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

    public Vector3i toVector3() {
        return toVector3(0);
    }

    public Vector3i toVector3(double z) {
        return toVector3((int) z);
    }

    public Vector3i toVector3(int z) {
        return new Vector3i(this, z);
    }

    public Vector4i toVector4() {
        return toVector4(0, 0);
    }

    public Vector4i toVector4(double z, double w) {
        return toVector4((int) z, (int) w);
    }

    public Vector4i toVector4(int z, int w) {
        return new Vector4i(this, z, w);
    }

    public VectorNi toVectorN() {
        return new VectorNi(this);
    }

    @Override
    public int[] toArray() {
        return new int[]{x, y};
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
    public int compareTo(Vector2i v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector2i)) {
            return false;
        }
        final Vector2i vector2 = (Vector2i) o;
        if (Integer.compare(vector2.x, x) != 0) {
            return false;
        }
        if (Integer.compare(vector2.y, y) != 0) {
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
    public Vector2i clone() {
        return new Vector2i(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
