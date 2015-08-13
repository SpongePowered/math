package com.flowpowered.math.vector;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector4d implements Vectord, Comparable<Vector4d>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector4d ZERO = new Vector4d(0, 0, 0, 0);
    public static final Vector4d UNIT_X = new Vector4d(1, 0, 0, 0);
    public static final Vector4d UNIT_Y = new Vector4d(0, 1, 0, 0);
    public static final Vector4d UNIT_Z = new Vector4d(0, 0, 1, 0);
    public static final Vector4d UNIT_W = new Vector4d(0, 0, 0, 1);
    public static final Vector4d ONE = new Vector4d(1, 1, 1, 1);
    private final double x;
    private final double y;
    private final double z;
    private final double w;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector4d() {
        this(0, 0, 0, 0);
    }

    public Vector4d(Vector2d v) {
        this(v, 0, 0);
    }

    public Vector4d(Vector2d v, float z, float w) {
        this(v, (double) z, (double) w);
    }

    public Vector4d(Vector2d v, double z, double w) {
        this(v.getX(), v.getY(), z, w);
    }

    public Vector4d(Vector3d v) {
        this(v, 0);
    }

    public Vector4d(Vector3d v, float w) {
        this(v, (double) w);
    }

    public Vector4d(Vector3d v, double w) {
        this(v.getX(), v.getY(), v.getZ(), w);
    }

    public Vector4d(Vector4d v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4d(VectorNd v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0, v.size() > 3 ? v.get(3) : 0);
    }

    public Vector4d(float x, float y, float z, float w) {
        this((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public double getW() {
        return w;
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

    public int getFloorW() {
        return GenericMath.floor(w);
    }

    public Vector4d add(Vector4d v) {
        return add(v.x, v.y, v.z, v.w);
    }

    public Vector4d add(float x, float y, float z, float w) {
        return add((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d add(double x, double y, double z, double w) {
        return new Vector4d(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public Vector4d sub(Vector4d v) {
        return sub(v.x, v.y, v.z, v.w);
    }

    public Vector4d sub(float x, float y, float z, float w) {
        return sub((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d sub(double x, double y, double z, double w) {
        return new Vector4d(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    public Vector4d mul(float a) {
        return mul((double) a);
    }

    @Override
    public Vector4d mul(double a) {
        return mul(a, a, a, a);
    }

    public Vector4d mul(Vector4d v) {
        return mul(v.x, v.y, v.z, v.w);
    }

    public Vector4d mul(float x, float y, float z, float w) {
        return mul((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d mul(double x, double y, double z, double w) {
        return new Vector4d(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    public Vector4d div(float a) {
        return div((double) a);
    }

    @Override
    public Vector4d div(double a) {
        return div(a, a, a, a);
    }

    public Vector4d div(Vector4d v) {
        return div(v.x, v.y, v.z, v.w);
    }

    public Vector4d div(float x, float y, float z, float w) {
        return div((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d div(double x, double y, double z, double w) {
        return new Vector4d(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    public double dot(Vector4d v) {
        return dot(v.x, v.y, v.z, v.w);
    }

    public double dot(float x, float y, float z, float w) {
        return dot((double) x, (double) y, (double) z, (double) w);
    }

    public double dot(double x, double y, double z, double w) {
        return this.x * x + this.y * y + this.z * z + this.w * w;
    }

    public Vector4d project(Vector4d v) {
        return project(v.x, v.y, v.z, v.w);
    }

    public Vector4d project(float x, float y, float z, float w) {
        return project((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d project(double x, double y, double z, double w) {
        final double lengthSquared = x * x + y * y + z * z + w * w;
        if (Math.abs(lengthSquared) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = dot(x, y, z, w) / lengthSquared;
        return new Vector4d(a * x, a * y, a * z, a * w);
    }

    public Vector4d pow(float pow) {
        return pow((double) pow);
    }

    @Override
    public Vector4d pow(double power) {
        return new Vector4d(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power), Math.pow(w, power));
    }

    @Override
    public Vector4d ceil() {
        return new Vector4d(Math.ceil(x), Math.ceil(y), Math.ceil(z), Math.ceil(w));
    }

    @Override
    public Vector4d floor() {
        return new Vector4d(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    @Override
    public Vector4d round() {
        return new Vector4d(Math.round(x), Math.round(y), Math.round(z), Math.round(w));
    }

    @Override
    public Vector4d abs() {
        return new Vector4d(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public Vector4d negate() {
        return new Vector4d(-x, -y, -z, -w);
    }

    public Vector4d min(Vector4d v) {
        return min(v.x, v.y, v.z, v.w);
    }

    public Vector4d min(float x, float y, float z, float w) {
        return min((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d min(double x, double y, double z, double w) {
        return new Vector4d(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z), Math.min(this.w, w));
    }

    public Vector4d max(Vector4d v) {
        return max(v.x, v.y, v.z, v.w);
    }

    public Vector4d max(float x, float y, float z, float w) {
        return max((double) x, (double) y, (double) z, (double) w);
    }

    public Vector4d max(double x, double y, double z, double w) {
        return new Vector4d(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z), Math.max(this.w, w));
    }

    public double distanceSquared(Vector4d v) {
        return distanceSquared(v.x, v.y, v.z, v.w);
    }

    public double distanceSquared(float x, float y, float z, float w) {
        return distanceSquared((double) x, (double) y, (double) z, (double) w);
    }

    public double distanceSquared(double x, double y, double z, double w) {
        final double dx = this.x - x;
        final double dy = this.y - y;
        final double dz = this.z - z;
        final double dw = this.w - w;
        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    public double distance(Vector4d v) {
        return distance(v.x, v.y, v.z, v.w);
    }

    public double distance(float x, float y, float z, float w) {
        return distance((double) x, (double) y, (double) z, (double) w);
    }

    public double distance(double x, double y, double z, double w) {
        return (double) Math.sqrt(distanceSquared(x, y, z, w));
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public double length() {
        return (double) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector4d normalize() {
        final double length = length();
        if (Math.abs(length) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        return new Vector4d(x / length, y / length, z / length, w / length);
    }

    /**
     * Return the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    @Override
    public int getMinAxis() {
        double value = x;
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
        double value = x;
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

    public Vector2d toVector2() {
        return new Vector2d(this);
    }

    public Vector3d toVector3() {
        return new Vector3d(this);
    }

    public VectorNd toVectorN() {
        return new VectorNd(this);
    }

    @Override
    public double[] toArray() {
        return new double[]{x, y, z, w};
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
    public int compareTo(Vector4d v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector4d)) {
            return false;
        }
        final Vector4d vector4 = (Vector4d) o;
        if (Double.compare(vector4.w, w) != 0) {
            return false;
        }
        if (Double.compare(vector4.x, x) != 0) {
            return false;
        }
        if (Double.compare(vector4.y, y) != 0) {
            return false;
        }
        if (Double.compare(vector4.z, z) != 0) {
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
    public Vector4d clone() {
        return new Vector4d(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
