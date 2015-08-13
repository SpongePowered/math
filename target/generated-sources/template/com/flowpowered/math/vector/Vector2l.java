package com.flowpowered.math.vector;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector2l implements Vectorl, Comparable<Vector2l>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector2l ZERO = new Vector2l(0, 0);
    public static final Vector2l UNIT_X = new Vector2l(1, 0);
    public static final Vector2l UNIT_Y = new Vector2l(0, 1);
    public static final Vector2l ONE = new Vector2l(1, 1);
    private final long x;
    private final long y;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector2l() {
        this(0, 0);
    }

    public Vector2l(Vector2l v) {
        this(v.x, v.y);
    }

    public Vector2l(Vector3l v) {
        this(v.getX(), v.getY());
    }

    public Vector2l(Vector4l v) {
        this(v.getX(), v.getY());
    }

    public Vector2l(VectorNl v) {
        this(v.get(0), v.get(1));
    }

    public Vector2l(double x, double y) {
        this(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Vector2l add(Vector2l v) {
        return add(v.x, v.y);
    }

    public Vector2l add(double x, double y) {
        return add(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l add(long x, long y) {
        return new Vector2l(this.x + x, this.y + y);
    }

    public Vector2l sub(Vector2l v) {
        return sub(v.x, v.y);
    }

    public Vector2l sub(double x, double y) {
        return sub(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l sub(long x, long y) {
        return new Vector2l(this.x - x, this.y - y);
    }

    public Vector2l mul(double a) {
        return mul(GenericMath.floorl(a));
    }

    @Override
    public Vector2l mul(long a) {
        return mul(a, a);
    }

    public Vector2l mul(Vector2l v) {
        return mul(v.x, v.y);
    }

    public Vector2l mul(double x, double y) {
        return mul(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l mul(long x, long y) {
        return new Vector2l(this.x * x, this.y * y);
    }

    public Vector2l div(double a) {
        return div(GenericMath.floorl(a));
    }

    @Override
    public Vector2l div(long a) {
        return div(a, a);
    }

    public Vector2l div(Vector2l v) {
        return div(v.x, v.y);
    }

    public Vector2l div(double x, double y) {
        return div(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l div(long x, long y) {
        return new Vector2l(this.x / x, this.y / y);
    }

    public long dot(Vector2l v) {
        return dot(v.x, v.y);
    }

    public long dot(double x, double y) {
        return dot(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public long dot(long x, long y) {
        return this.x * x + this.y * y;
    }

    public Vector2l project(Vector2l v) {
        return project(v.x, v.y);
    }

    public Vector2l project(double x, double y) {
        return project(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l project(long x, long y) {
        final long lengthSquared = x * x + y * y;
        if (lengthSquared == 0) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = (double) dot(x, y) / lengthSquared;
        return new Vector2l(a * x, a * y);
    }

    public Vector2l pow(double pow) {
        return pow(GenericMath.floorl(pow));
    }

    @Override
    public Vector2l pow(long power) {
        return new Vector2l(Math.pow(x, power), Math.pow(y, power));
    }

    @Override
    public Vector2l abs() {
        return new Vector2l(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2l negate() {
        return new Vector2l(-x, -y);
    }

    public Vector2l min(Vector2l v) {
        return min(v.x, v.y);
    }

    public Vector2l min(double x, double y) {
        return min(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l min(long x, long y) {
        return new Vector2l(Math.min(this.x, x), Math.min(this.y, y));
    }

    public Vector2l max(Vector2l v) {
        return max(v.x, v.y);
    }

    public Vector2l max(double x, double y) {
        return max(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public Vector2l max(long x, long y) {
        return new Vector2l(Math.max(this.x, x), Math.max(this.y, y));
    }

    public long distanceSquared(Vector2l v) {
        return distanceSquared(v.x, v.y);
    }

    public long distanceSquared(double x, double y) {
        return distanceSquared(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public long distanceSquared(long x, long y) {
        final long dx = this.x - x;
        final long dy = this.y - y;
        return dx * dx + dy * dy;
    }

    public double distance(Vector2l v) {
        return distance(v.x, v.y);
    }

    public double distance(double x, double y) {
        return distance(GenericMath.floorl(x), GenericMath.floorl(y));
    }

    public double distance(long x, long y) {
        return (double) Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public long lengthSquared() {
        return x * x + y * y;
    }

    @Override
    public double length() {
        return (double) Math.sqrt(lengthSquared());
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

    public Vector3l toVector3() {
        return toVector3(0);
    }

    public Vector3l toVector3(double z) {
        return toVector3(GenericMath.floorl(z));
    }

    public Vector3l toVector3(long z) {
        return new Vector3l(this, z);
    }

    public Vector4l toVector4() {
        return toVector4(0, 0);
    }

    public Vector4l toVector4(double z, double w) {
        return toVector4(GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l toVector4(long z, long w) {
        return new Vector4l(this, z, w);
    }

    public VectorNl toVectorN() {
        return new VectorNl(this);
    }

    @Override
    public long[] toArray() {
        return new long[]{x, y};
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
    public int compareTo(Vector2l v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector2l)) {
            return false;
        }
        final Vector2l vector2 = (Vector2l) o;
        if (vector2.x != x) {
            return false;
        }
        if (vector2.y != y) {
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
    public Vector2l clone() {
        return new Vector2l(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
