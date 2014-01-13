package com.flowpowered.math.vector;

import java.io.Serializable;
import java.lang.Override;
import java.util.Random;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector3i implements Vectori, Comparable<Vector3i>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector3i ZERO = new Vector3i(0, 0, 0);
    public static final Vector3i UNIT_X = new Vector3i(1, 0, 0);
    public static final Vector3i UNIT_Y = new Vector3i(0, 1, 0);
    public static final Vector3i UNIT_Z = new Vector3i(0, 0, 1);
    public static final Vector3i ONE = new Vector3i(1, 1, 1);
    public static final Vector3i RIGHT = UNIT_X;
    public static final Vector3i UP = UNIT_Y;
    public static final Vector3i FORWARD = UNIT_Z;
    private final int x;
    private final int y;
    private final int z;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector3i() {
        this(0, 0, 0);
    }

    public Vector3i(Vector2i v) {
        this(v, (int) 0);
    }

    // TODO: int overload

    public Vector3i(Vector2i v, int z) {
        this(v.getX(), v.getY(), z);
    }

    public Vector3i(Vector3i v) {
        this(v.x, v.y, v.z);
    }

    public Vector3i(Vector4i v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vector3i(VectorNi v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0);
    }

    public Vector3i(double x, double y, double z) {
        this((int) x, (int) y, (int) z);
    }

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public Vector3i add(Vector3i v) {
        return add(v.x, v.y, v.z);
    }

    public Vector3i add(double x, double y, double z) {
        return add((int) x, (int) y, (int) z);
    }

    public Vector3i add(int x, int y, int z) {
        return new Vector3i(this.x + x, this.y + y, this.z + z);
    }

    public Vector3i sub(Vector3i v) {
        return sub(v.x, v.y, v.z);
    }

    public Vector3i sub(double x, double y, double z) {
        return sub((int) x, (int) y, (int) z);
    }

    public Vector3i sub(int x, int y, int z) {
        return new Vector3i(this.x - x, this.y - y, this.z - z);
    }

    public Vector3i mul(double a) {
        return mul((int) a);
    }

    @Override
    public Vector3i mul(int a) {
        return mul(a, a, a);
    }

    public Vector3i mul(Vector3i v) {
        return mul(v.x, v.y, v.z);
    }

    public Vector3i mul(double x, double y, double z) {
        return mul((int) x, (int) y, (int) z);
    }

    public Vector3i mul(int x, int y, int z) {
        return new Vector3i(this.x * x, this.y * y, this.z * z);
    }

    public Vector3i div(double a) {
        return div((int) a);
    }

    @Override
    public Vector3i div(int a) {
        return div(a, a, a);
    }

    public Vector3i div(Vector3i v) {
        return div(v.x, v.y, v.z);
    }

    public Vector3i div(double x, double y, double z) {
        return div((int) x, (int) y, (int) z);
    }

    public Vector3i div(int x, int y, int z) {
        return new Vector3i(this.x / x, this.y / y, this.z / z);
    }

    public int dot(Vector3i v) {
        return dot(v.x, v.y, v.z);
    }

    public int dot(double x, double y, double z) {
        return dot((int) x, (int) y, (int) z);
    }

    public int dot(int x, int y, int z) {
        return (int) (this.x * x + this.y * y + this.z * z);
    }

    public Vector3i cross(Vector3i v) {
        return cross(v.x, v.y, v.z);
    }

    public Vector3i cross(double x, double y, double z) {
        return cross((int) x, (int) y, (int) z);
    }

    public Vector3i cross(int x, int y, int z) {
        return new Vector3i(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    public Vector3i pow(double pow) {
        return pow((int) pow);
    }

    @Override
    public Vector3i pow(int power) {
        return new Vector3i(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power));
    }

    @Override
    public Vector3i abs() {
        return new Vector3i(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3i negate() {
        return new Vector3i(-x, -y, -z);
    }

    public Vector3i min(Vector3i v) {
        return min(v.x, v.y, v.z);
    }

    public Vector3i min(double x, double y, double z) {
        return min((int) x, (int) y, (int) z);
    }

    public Vector3i min(int x, int y, int z) {
        return new Vector3i(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    public Vector3i max(Vector3i v) {
        return max(v.x, v.y, v.z);
    }

    public Vector3i max(double x, double y, double z) {
        return max((int) x, (int) y, (int) z);
    }

    public Vector3i max(int x, int y, int z) {
        return new Vector3i(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    public int distanceSquared(Vector3i v) {
        return distanceSquared(v.x, v.y, v.z);
    }

    public int distanceSquared(double x, double y, double z) {
        return distanceSquared((int) x, (int) y, (int) z);
    }

    public int distanceSquared(int x, int y, int z) {
        return (int) GenericMath.lengthSquared(this.x - x, this.y - y, this.z - z);
    }

    public int distance(Vector3i v) {
        return distance(v.x, v.y, v.z);
    }

    public int distance(double x, double y, double z) {
        return distance((int) x, (int) y, (int) z);
    }

    public int distance(int x, int y, int z) {
        return (int) GenericMath.length(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public int lengthSquared() {
        return (int) GenericMath.lengthSquared(x, y, z);
    }

    @Override
    public int length() {
        return (int) GenericMath.length(x, y, z);
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

    public Vector2i toVector2() {
        return new Vector2i(this);
    }

    public Vector2i toVector2(boolean useZ) {
        return new Vector2i(x, useZ ? z : y);
    }

    public Vector4i toVector4() {
        return toVector4(0);
    }

    public Vector4i toVector4(double w) {
        return toVector4((int) w);
    }

    public Vector4i toVector4(int w) {
        return new Vector4i(this, w);
    }

    public VectorNi toVectorN() {
        return new VectorNi(this);
    }

    @Override
    public int[] toArray() {
        return new int[]{x, y, z};
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
    public int compareTo(Vector3i v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector3i)) {
            return false;
        }
        final Vector3i vector3 = (Vector3i) o;
        if (Integer.compare(vector3.x, x) != 0) {
            return false;
        }
        if (Integer.compare(vector3.y, y) != 0) {
            return false;
        }
        if (Integer.compare(vector3.z, z) != 0) {
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
    public Vector3i clone() {
        return new Vector3i(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
