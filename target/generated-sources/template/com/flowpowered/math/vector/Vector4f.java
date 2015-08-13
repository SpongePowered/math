package com.flowpowered.math.vector;

import java.io.Serializable;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.HashFunctions;

public class Vector4f implements Vectorf, Comparable<Vector4f>, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public static final Vector4f ZERO = new Vector4f(0, 0, 0, 0);
    public static final Vector4f UNIT_X = new Vector4f(1, 0, 0, 0);
    public static final Vector4f UNIT_Y = new Vector4f(0, 1, 0, 0);
    public static final Vector4f UNIT_Z = new Vector4f(0, 0, 1, 0);
    public static final Vector4f UNIT_W = new Vector4f(0, 0, 0, 1);
    public static final Vector4f ONE = new Vector4f(1, 1, 1, 1);
    private final float x;
    private final float y;
    private final float z;
    private final float w;
    private transient volatile boolean hashed = false;
    private transient volatile int hashCode = 0;

    public Vector4f() {
        this(0, 0, 0, 0);
    }

    public Vector4f(Vector2f v) {
        this(v, 0, 0);
    }

    public Vector4f(Vector2f v, double z, double w) {
        this(v, (float) z, (float) w);
    }

    public Vector4f(Vector2f v, float z, float w) {
        this(v.getX(), v.getY(), z, w);
    }

    public Vector4f(Vector3f v) {
        this(v, 0);
    }

    public Vector4f(Vector3f v, double w) {
        this(v, (float) w);
    }

    public Vector4f(Vector3f v, float w) {
        this(v.getX(), v.getY(), v.getZ(), w);
    }

    public Vector4f(Vector4f v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vector4f(VectorNf v) {
        this(v.get(0), v.get(1), v.size() > 2 ? v.get(2) : 0, v.size() > 3 ? v.get(3) : 0);
    }

    public Vector4f(double x, double y, double z, double w) {
        this((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public float getW() {
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

    public Vector4f add(Vector4f v) {
        return add(v.x, v.y, v.z, v.w);
    }

    public Vector4f add(double x, double y, double z, double w) {
        return add((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f add(float x, float y, float z, float w) {
        return new Vector4f(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public Vector4f sub(Vector4f v) {
        return sub(v.x, v.y, v.z, v.w);
    }

    public Vector4f sub(double x, double y, double z, double w) {
        return sub((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f sub(float x, float y, float z, float w) {
        return new Vector4f(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    public Vector4f mul(double a) {
        return mul((float) a);
    }

    @Override
    public Vector4f mul(float a) {
        return mul(a, a, a, a);
    }

    public Vector4f mul(Vector4f v) {
        return mul(v.x, v.y, v.z, v.w);
    }

    public Vector4f mul(double x, double y, double z, double w) {
        return mul((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f mul(float x, float y, float z, float w) {
        return new Vector4f(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    public Vector4f div(double a) {
        return div((float) a);
    }

    @Override
    public Vector4f div(float a) {
        return div(a, a, a, a);
    }

    public Vector4f div(Vector4f v) {
        return div(v.x, v.y, v.z, v.w);
    }

    public Vector4f div(double x, double y, double z, double w) {
        return div((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f div(float x, float y, float z, float w) {
        return new Vector4f(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    public float dot(Vector4f v) {
        return dot(v.x, v.y, v.z, v.w);
    }

    public float dot(double x, double y, double z, double w) {
        return dot((float) x, (float) y, (float) z, (float) w);
    }

    public float dot(float x, float y, float z, float w) {
        return this.x * x + this.y * y + this.z * z + this.w * w;
    }

    public Vector4f project(Vector4f v) {
        return project(v.x, v.y, v.z, v.w);
    }

    public Vector4f project(double x, double y, double z, double w) {
        return project((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f project(float x, float y, float z, float w) {
        final float lengthSquared = x * x + y * y + z * z + w * w;
        if (Math.abs(lengthSquared) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final float a = dot(x, y, z, w) / lengthSquared;
        return new Vector4f(a * x, a * y, a * z, a * w);
    }

    public Vector4f pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public Vector4f pow(float power) {
        return new Vector4f(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power), Math.pow(w, power));
    }

    @Override
    public Vector4f ceil() {
        return new Vector4f(Math.ceil(x), Math.ceil(y), Math.ceil(z), Math.ceil(w));
    }

    @Override
    public Vector4f floor() {
        return new Vector4f(GenericMath.floor(x), GenericMath.floor(y), GenericMath.floor(z), GenericMath.floor(w));
    }

    @Override
    public Vector4f round() {
        return new Vector4f(Math.round(x), Math.round(y), Math.round(z), Math.round(w));
    }

    @Override
    public Vector4f abs() {
        return new Vector4f(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public Vector4f negate() {
        return new Vector4f(-x, -y, -z, -w);
    }

    public Vector4f min(Vector4f v) {
        return min(v.x, v.y, v.z, v.w);
    }

    public Vector4f min(double x, double y, double z, double w) {
        return min((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f min(float x, float y, float z, float w) {
        return new Vector4f(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z), Math.min(this.w, w));
    }

    public Vector4f max(Vector4f v) {
        return max(v.x, v.y, v.z, v.w);
    }

    public Vector4f max(double x, double y, double z, double w) {
        return max((float) x, (float) y, (float) z, (float) w);
    }

    public Vector4f max(float x, float y, float z, float w) {
        return new Vector4f(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z), Math.max(this.w, w));
    }

    public float distanceSquared(Vector4f v) {
        return distanceSquared(v.x, v.y, v.z, v.w);
    }

    public float distanceSquared(double x, double y, double z, double w) {
        return distanceSquared((float) x, (float) y, (float) z, (float) w);
    }

    public float distanceSquared(float x, float y, float z, float w) {
        final float dx = this.x - x;
        final float dy = this.y - y;
        final float dz = this.z - z;
        final float dw = this.w - w;
        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    public float distance(Vector4f v) {
        return distance(v.x, v.y, v.z, v.w);
    }

    public float distance(double x, double y, double z, double w) {
        return distance((float) x, (float) y, (float) z, (float) w);
    }

    public float distance(float x, float y, float z, float w) {
        return (float) Math.sqrt(distanceSquared(x, y, z, w));
    }

    @Override
    public float lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector4f normalize() {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        return new Vector4f(x / length, y / length, z / length, w / length);
    }

    /**
     * Return the axis with the minimal value.
     *
     * @return {@link int} axis with minimal value
     */
    @Override
    public int getMinAxis() {
        float value = x;
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
        float value = x;
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

    public Vector2f toVector2() {
        return new Vector2f(this);
    }

    public Vector3f toVector3() {
        return new Vector3f(this);
    }

    public VectorNf toVectorN() {
        return new VectorNf(this);
    }

    @Override
    public float[] toArray() {
        return new float[]{x, y, z, w};
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
    public int compareTo(Vector4f v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector4f)) {
            return false;
        }
        final Vector4f vector4 = (Vector4f) o;
        if (Float.compare(vector4.w, w) != 0) {
            return false;
        }
        if (Float.compare(vector4.x, x) != 0) {
            return false;
        }
        if (Float.compare(vector4.y, y) != 0) {
            return false;
        }
        if (Float.compare(vector4.z, z) != 0) {
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
    public Vector4f clone() {
        return new Vector4f(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
