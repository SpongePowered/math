package com.flowpowered.math.vector;

import java.io.Serializable;
import java.lang.Override;
import java.util.Random;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector3l implements Vectorl, Comparable<Vector3l>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector3l ZERO = new Vector3l(0, 0, 0);
    public static final Vector3l UNIT_X = new Vector3l(1, 0, 0);
    public static final Vector3l UNIT_Y = new Vector3l(0, 1, 0);
    public static final Vector3l UNIT_Z = new Vector3l(0, 0, 1);
    public static final Vector3l ONE = new Vector3l(1, 1, 1);
    public static final Vector3l RIGHT = UNIT_X;
    public static final Vector3l UP = UNIT_Y;
    public static final Vector3l FORWARD = UNIT_Z;
    private final long x;
    private final long y;
    private final long z;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector3l() {
        this(0, 0, 0);
    }

    public Vector3l(Vector2l v) {
        this(v, 0);
    }

    public Vector3l(Vector2l v, double z) {
        this(v, GenericMath.floorl(z));
    }

    public Vector3l(Vector2l v, long z) {
        this(v.getX(), v.getY(), z);
    }

    public Vector3l(Vector3l v) {
        this(v.x, v.y, v.z);
    }

    public Vector3l(Vector4l v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vector3l(VectorNl v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0);
    }

    public Vector3l(double x, double y, double z) {
        this(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public Vector3l add(Vector3l v) {
        return add(v.x, v.y, v.z);
    }

    public Vector3l add(double x, double y, double z) {
        return add(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l add(long x, long y, long z) {
        return new Vector3l(this.x + x, this.y + y, this.z + z);
    }

    public Vector3l sub(Vector3l v) {
        return sub(v.x, v.y, v.z);
    }

    public Vector3l sub(double x, double y, double z) {
        return sub(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l sub(long x, long y, long z) {
        return new Vector3l(this.x - x, this.y - y, this.z - z);
    }

    public Vector3l mul(double a) {
        return mul(GenericMath.floorl(a));
    }

    @Override
    public Vector3l mul(long a) {
        return mul(a, a, a);
    }

    public Vector3l mul(Vector3l v) {
        return mul(v.x, v.y, v.z);
    }

    public Vector3l mul(double x, double y, double z) {
        return mul(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l mul(long x, long y, long z) {
        return new Vector3l(this.x * x, this.y * y, this.z * z);
    }

    public Vector3l div(double a) {
        return div(GenericMath.floorl(a));
    }

    @Override
    public Vector3l div(long a) {
        return div(a, a, a);
    }

    public Vector3l div(Vector3l v) {
        return div(v.x, v.y, v.z);
    }

    public Vector3l div(double x, double y, double z) {
        return div(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l div(long x, long y, long z) {
        return new Vector3l(this.x / x, this.y / y, this.z / z);
    }

    public long dot(Vector3l v) {
        return dot(v.x, v.y, v.z);
    }

    public long dot(double x, double y, double z) {
        return dot(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public long dot(long x, long y, long z) {
        return this.x * x + this.y * y + this.z * z;
    }

    public Vector3l project(Vector3l v) {
        return project(v.x, v.y, v.z);
    }

    public Vector3l project(double x, double y, double z) {
        return project(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l project(long x, long y, long z) {
        final long lengthSquared = x * x + y * y + z * z;
        if (lengthSquared == 0) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = (double) dot(x, y, z) / lengthSquared;
        return new Vector3l(a * x, a * y, a * z);
    }

    public Vector3l cross(Vector3l v) {
        return cross(v.x, v.y, v.z);
    }

    public Vector3l cross(double x, double y, double z) {
        return cross(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l cross(long x, long y, long z) {
        return new Vector3l(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    public Vector3l pow(double pow) {
        return pow(GenericMath.floorl(pow));
    }

    @Override
    public Vector3l pow(long power) {
        return new Vector3l(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power));
    }

    @Override
    public Vector3l abs() {
        return new Vector3l(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3l negate() {
        return new Vector3l(-x, -y, -z);
    }

    public Vector3l min(Vector3l v) {
        return min(v.x, v.y, v.z);
    }

    public Vector3l min(double x, double y, double z) {
        return min(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l min(long x, long y, long z) {
        return new Vector3l(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    public Vector3l max(Vector3l v) {
        return max(v.x, v.y, v.z);
    }

    public Vector3l max(double x, double y, double z) {
        return max(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public Vector3l max(long x, long y, long z) {
        return new Vector3l(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    public long distanceSquared(Vector3l v) {
        return distanceSquared(v.x, v.y, v.z);
    }

    public long distanceSquared(double x, double y, double z) {
        return distanceSquared(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public long distanceSquared(long x, long y, long z) {
        final long dx = this.x - x;
        final long dy = this.y - y;
        final long dz = this.z - z;
        return dx * dx + dy * dy + dz * dz;
    }

    public double distance(Vector3l v) {
        return distance(v.x, v.y, v.z);
    }

    public double distance(double x, double y, double z) {
        return distance(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z));
    }

    public double distance(long x, long y, long z) {
        return (double) Math.sqrt(distanceSquared(x, y, z));
    }

    @Override
    public long lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public double length() {
        return (double) Math.sqrt(lengthSquared());
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

    public Vector2l toVector2() {
        return new Vector2l(this);
    }

    public Vector2l toVector2(boolean useZ) {
        return new Vector2l(x, useZ ? z : y);
    }

    public Vector4l toVector4() {
        return toVector4(0);
    }

    public Vector4l toVector4(double w) {
        return toVector4(GenericMath.floorl(w));
    }

    public Vector4l toVector4(long w) {
        return new Vector4l(this, w);
    }

    public VectorNl toVectorN() {
        return new VectorNl(this);
    }

    @Override
    public long[] toArray() {
        return new long[]{x, y, z};
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
    public int compareTo(Vector3l v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector3l)) {
            return false;
        }
        final Vector3l vector3 = (Vector3l) o;
        if (vector3.x != x) {
            return false;
        }
        if (vector3.y != y) {
            return false;
        }
        if (vector3.z != z) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (!hashed) {
            hashCode = ((HashFunctions.hash(x) * 211 + HashFunctions.hash(y)) * 97 + HashFunctions.hash(z));
            hashed = true;
        }
        return hashCode;
    }

    @Override
    public Vector3l clone() {
        return new Vector3l(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
