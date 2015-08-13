package com.flowpowered.math.vector;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector4i implements Vectori, Comparable<Vector4i>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector4i ZERO = new Vector4i(0, 0, 0, 0);
    public static final Vector4i UNIT_X = new Vector4i(1, 0, 0, 0);
    public static final Vector4i UNIT_Y = new Vector4i(0, 1, 0, 0);
    public static final Vector4i UNIT_Z = new Vector4i(0, 0, 1, 0);
    public static final Vector4i UNIT_W = new Vector4i(0, 0, 0, 1);
    public static final Vector4i ONE = new Vector4i(1, 1, 1, 1);
    private final int x;
    private final int y;
    private final int z;
    private final int w;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector4i() {
        this(0, 0, 0, 0);
    }

    public Vector4i(Vector2i v) {
        this(v, 0, 0);
    }

    public Vector4i(Vector2i v, double z, double w) {
        this(v, GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i(Vector2i v, int z, int w) {
        this(v.getX(), v.getY(), z, w);
    }

    public Vector4i(Vector3i v) {
        this(v, 0);
    }

    public Vector4i(Vector3i v, double w) {
        this(v, GenericMath.floor(w));
    }

    public Vector4i(Vector3i v, int w) {
        this(v.getX(), v.getY(), v.getZ(), w);
    }

    public Vector4i(Vector4i v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4i(VectorNi v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0, v.size() > 3 ? v.get(3) : 0);
    }

    public Vector4i(double x, double y, double z, double w) {
        this(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getW() {
        return w;
    }

    public Vector4i add(Vector4i v) {
        return add(v.x, v.y, v.z, v.w);
    }

    public Vector4i add(double x, double y, double z, double w) {
        return add(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i add(int x, int y, int z, int w) {
        return new Vector4i(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public Vector4i sub(Vector4i v) {
        return sub(v.x, v.y, v.z, v.w);
    }

    public Vector4i sub(double x, double y, double z, double w) {
        return sub(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i sub(int x, int y, int z, int w) {
        return new Vector4i(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    public Vector4i mul(double a) {
        return mul(GenericMath.floor(a));
    }

    @Override
    public Vector4i mul(int a) {
        return mul(a, a, a, a);
    }

    public Vector4i mul(Vector4i v) {
        return mul(v.x, v.y, v.z, v.w);
    }

    public Vector4i mul(double x, double y, double z, double w) {
        return mul(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i mul(int x, int y, int z, int w) {
        return new Vector4i(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    public Vector4i div(double a) {
        return div(GenericMath.floor(a));
    }

    @Override
    public Vector4i div(int a) {
        return div(a, a, a, a);
    }

    public Vector4i div(Vector4i v) {
        return div(v.x, v.y, v.z, v.w);
    }

    public Vector4i div(double x, double y, double z, double w) {
        return div(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i div(int x, int y, int z, int w) {
        return new Vector4i(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    public int dot(Vector4i v) {
        return dot(v.x, v.y, v.z, v.w);
    }

    public int dot(double x, double y, double z, double w) {
        return dot(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public int dot(int x, int y, int z, int w) {
        return this.x * x + this.y * y + this.z * z + this.w * w;
    }

    public Vector4i project(Vector4i v) {
        return project(v.x, v.y, v.z, v.w);
    }

    public Vector4i project(double x, double y, double z, double w) {
        return project(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i project(int x, int y, int z, int w) {
        final int lengthSquared = x * x + y * y + z * z + w * w;
        if (lengthSquared == 0) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final float a = (float) dot(x, y, z, w) / lengthSquared;
        return new Vector4i(a * x, a * y, a * z, a * w);
    }

    public Vector4i pow(double pow) {
        return pow(GenericMath.floor(pow));
    }

    @Override
    public Vector4i pow(int power) {
        return new Vector4i(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power), Math.pow(w, power));
    }

    @Override
    public Vector4i abs() {
        return new Vector4i(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public Vector4i negate() {
        return new Vector4i(-x, -y, -z, -w);
    }

    public Vector4i min(Vector4i v) {
        return min(v.x, v.y, v.z, v.w);
    }

    public Vector4i min(double x, double y, double z, double w) {
        return min(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i min(int x, int y, int z, int w) {
        return new Vector4i(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z), Math.min(this.w, w));
    }

    public Vector4i max(Vector4i v) {
        return max(v.x, v.y, v.z, v.w);
    }

    public Vector4i max(double x, double y, double z, double w) {
        return max(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public Vector4i max(int x, int y, int z, int w) {
        return new Vector4i(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z), Math.max(this.w, w));
    }

    public int distanceSquared(Vector4i v) {
        return distanceSquared(v.x, v.y, v.z, v.w);
    }

    public int distanceSquared(double x, double y, double z, double w) {
        return distanceSquared(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public int distanceSquared(int x, int y, int z, int w) {
        final int dx = this.x - x;
        final int dy = this.y - y;
        final int dz = this.z - z;
        final int dw = this.w - w;
        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    public float distance(Vector4i v) {
        return distance(v.x, v.y, v.z, v.w);
    }

    public float distance(double x, double y, double z, double w) {
        return distance(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    public float distance(int x, int y, int z, int w) {
        return (float) Math.sqrt(distanceSquared(x, y, z, w));
    }

    @Override
    public int lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * Return the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    @Override
    public int getMinAxis() {
        int value = x;
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
        int value = x;
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

    public Vector2i toVector2() {
        return new Vector2i(this);
    }

    public Vector3i toVector3() {
        return new Vector3i(this);
    }

    public VectorNi toVectorN() {
        return new VectorNi(this);
    }

    @Override
    public int[] toArray() {
        return new int[]{x, y, z, w};
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
    public int compareTo(Vector4i v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector4i)) {
            return false;
        }
        final Vector4i vector4 = (Vector4i) o;
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
    public Vector4i clone() {
        return new Vector4i(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
