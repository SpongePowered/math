package com.flowpowered.math.vector;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector4l implements Vectorl, Comparable<Vector4l>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector4l ZERO = new Vector4l(0, 0, 0, 0);
    public static final Vector4l UNIT_X = new Vector4l(1, 0, 0, 0);
    public static final Vector4l UNIT_Y = new Vector4l(0, 1, 0, 0);
    public static final Vector4l UNIT_Z = new Vector4l(0, 0, 1, 0);
    public static final Vector4l UNIT_W = new Vector4l(0, 0, 0, 1);
    public static final Vector4l ONE = new Vector4l(1, 1, 1, 1);
    private final long x;
    private final long y;
    private final long z;
    private final long w;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector4l() {
        this(0, 0, 0, 0);
    }

    public Vector4l(Vector2l v) {
        this(v, 0, 0);
    }

    public Vector4l(Vector2l v, double z, double w) {
        this(v, GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l(Vector2l v, long z, long w) {
        this(v.getX(), v.getY(), z, w);
    }

    public Vector4l(Vector3l v) {
        this(v, 0);
    }

    public Vector4l(Vector3l v, double w) {
        this(v, GenericMath.floorl(w));
    }

    public Vector4l(Vector3l v, long w) {
        this(v.getX(), v.getY(), v.getZ(), w);
    }

    public Vector4l(Vector4l v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4l(VectorNl v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0, v.size() > 3 ? v.get(3) : 0);
    }

    public Vector4l(double x, double y, double z, double w) {
        this(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l(long x, long y, long z, long w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public long getW() {
        return w;
    }

    public Vector4l add(Vector4l v) {
        return add(v.x, v.y, v.z, v.w);
    }

    public Vector4l add(double x, double y, double z, double w) {
        return add(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l add(long x, long y, long z, long w) {
        return new Vector4l(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public Vector4l sub(Vector4l v) {
        return sub(v.x, v.y, v.z, v.w);
    }

    public Vector4l sub(double x, double y, double z, double w) {
        return sub(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l sub(long x, long y, long z, long w) {
        return new Vector4l(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    public Vector4l mul(double a) {
        return mul(GenericMath.floorl(a));
    }

    @Override
    public Vector4l mul(long a) {
        return mul(a, a, a, a);
    }

    public Vector4l mul(Vector4l v) {
        return mul(v.x, v.y, v.z, v.w);
    }

    public Vector4l mul(double x, double y, double z, double w) {
        return mul(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l mul(long x, long y, long z, long w) {
        return new Vector4l(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    public Vector4l div(double a) {
        return div(GenericMath.floorl(a));
    }

    @Override
    public Vector4l div(long a) {
        return div(a, a, a, a);
    }

    public Vector4l div(Vector4l v) {
        return div(v.x, v.y, v.z, v.w);
    }

    public Vector4l div(double x, double y, double z, double w) {
        return div(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l div(long x, long y, long z, long w) {
        return new Vector4l(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    public long dot(Vector4l v) {
        return dot(v.x, v.y, v.z, v.w);
    }

    public long dot(double x, double y, double z, double w) {
        return dot(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public long dot(long x, long y, long z, long w) {
        return this.x * x + this.y * y + this.z * z + this.w * w;
    }

    public Vector4l project(Vector4l v) {
        return project(v.x, v.y, v.z, v.w);
    }

    public Vector4l project(double x, double y, double z, double w) {
        return project(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l project(long x, long y, long z, long w) {
        final long lengthSquared = x * x + y * y + z * z + w * w;
        if (lengthSquared == 0) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = (double) dot(x, y, z, w) / lengthSquared;
        return new Vector4l(a * x, a * y, a * z, a * w);
    }

    public Vector4l pow(double pow) {
        return pow(GenericMath.floorl(pow));
    }

    @Override
    public Vector4l pow(long power) {
        return new Vector4l(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power), Math.pow(w, power));
    }

    @Override
    public Vector4l abs() {
        return new Vector4l(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public Vector4l negate() {
        return new Vector4l(-x, -y, -z, -w);
    }

    public Vector4l min(Vector4l v) {
        return min(v.x, v.y, v.z, v.w);
    }

    public Vector4l min(double x, double y, double z, double w) {
        return min(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l min(long x, long y, long z, long w) {
        return new Vector4l(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z), Math.min(this.w, w));
    }

    public Vector4l max(Vector4l v) {
        return max(v.x, v.y, v.z, v.w);
    }

    public Vector4l max(double x, double y, double z, double w) {
        return max(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public Vector4l max(long x, long y, long z, long w) {
        return new Vector4l(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z), Math.max(this.w, w));
    }

    public long distanceSquared(Vector4l v) {
        return distanceSquared(v.x, v.y, v.z, v.w);
    }

    public long distanceSquared(double x, double y, double z, double w) {
        return distanceSquared(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public long distanceSquared(long x, long y, long z, long w) {
        final long dx = this.x - x;
        final long dy = this.y - y;
        final long dz = this.z - z;
        final long dw = this.w - w;
        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    public double distance(Vector4l v) {
        return distance(v.x, v.y, v.z, v.w);
    }

    public double distance(double x, double y, double z, double w) {
        return distance(GenericMath.floorl(x), GenericMath.floorl(y), GenericMath.floorl(z), GenericMath.floorl(w));
    }

    public double distance(long x, long y, long z, long w) {
        return (double) Math.sqrt(distanceSquared(x, y, z, w));
    }

    @Override
    public long lengthSquared() {
        return x * x + y * y + z * z + w * w;
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
        long value = x;
        int axis = 0;
        if (y < value) {
            value = y;
            axis = 1;
        }
        if (z < value) {
            value = z;
            axis = 2;
        }
        if (w < value) {
            axis = 3;
        }
        return axis;
    }

    /**
     * Return the axis with the maximum value.
     *
     * @return {@link int} axis with maximum value
     */
    @Override
    public int getMaxAxis() {
        long value = x;
        int axis = 0;
        if (y > value) {
            value = y;
            axis = 1;
        }
        if (z > value) {
            value = z;
            axis = 2;
        }
        if (w > value) {
            axis = 3;
        }
        return axis;
    }

    public Vector2l toVector2() {
        return new Vector2l(this);
    }

    public Vector3l toVector3() {
        return new Vector3l(this);
    }

    public VectorNl toVectorN() {
        return new VectorNl(this);
    }

    @Override
    public long[] toArray() {
        return new long[]{x, y, z, w};
    }

    @Override
    public Vector4i toInt() {
        return new Vector4i(x, y, z, w);
    }

    @Override
    public Vector4l toLong() {
        return new Vector4l(x, y, z, w);
    }

    @Override
    public Vector4f toFloat() {
        return new Vector4f(x, y, z, w);
    }

    @Override
    public Vector4d toDouble() {
        return new Vector4d(x, y, z, w);
    }


    @Override
    public int compareTo(Vector4l v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector4l)) {
            return false;
        }
        final Vector4l vector4 = (Vector4l) o;
        if (vector4.x != x) {
            return false;
        }
        if (vector4.y != y) {
            return false;
        }
        if (vector4.z != z) {
            return false;
        }
        if (vector4.w != w) {
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
    public Vector4l clone() {
        return new Vector4l(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
