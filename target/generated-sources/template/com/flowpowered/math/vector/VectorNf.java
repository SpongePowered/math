package com.flowpowered.math.vector;

import java.io.Serializable;
import java.util.Arrays;

import com.flowpowered.math.GenericMath;

public class VectorNf implements Vectorf, Comparable<VectorNf>, Serializable, Cloneable {
    public static VectorNf ZERO_2 = new ImmutableZeroVectorN(0, 0);
    public static VectorNf ZERO_3 = new ImmutableZeroVectorN(0, 0, 0);
    public static VectorNf ZERO_4 = new ImmutableZeroVectorN(0, 0, 0, 0);
    private static final long serialVersionUID = 1;
    private final float[] vec;

    public VectorNf(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Minimum vector size is 2");
        }
        vec = new float[size];
    }

    public VectorNf(Vector2f v) {
        this(v.getX(), v.getY());
    }

    public VectorNf(Vector3f v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public VectorNf(Vector4f v) {
        this(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public VectorNf(VectorNf v) {
        this(v.vec);
    }

    public VectorNf(float... v) {
        vec = v.clone();
    }

    public int size() {
        return vec.length;
    }

    public float get(int comp) {
        return vec[comp];
    }

    public int getFloored(int comp) {
        return GenericMath.floor(get(comp));
    }

    public void set(int comp, double val) {
        set(comp, (float) val);
    }

    public void set(int comp, float val) {
        vec[comp] = val;
    }

    public void setZero() {
        Arrays.fill(vec, 0);
    }

    public VectorNf resize(int size) {
        final VectorNf d = new VectorNf(size);
        System.arraycopy(vec, 0, d.vec, 0, Math.min(size, size()));
        return d;
    }

    public VectorNf add(VectorNf v) {
        return add(v.vec);
    }

    public VectorNf add(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] + v[comp];
        }
        return d;
    }

    public VectorNf sub(VectorNf v) {
        return sub(v.vec);
    }

    public VectorNf sub(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] - v[comp];
        }
        return d;
    }

    public VectorNf mul(double a) {
        return mul((float) a);
    }

    @Override
    public VectorNf mul(float a) {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] * a;
        }
        return d;
    }

    public VectorNf mul(VectorNf v) {
        return mul(v.vec);
    }

    public VectorNf mul(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] * v[comp];
        }
        return d;
    }

    public VectorNf div(double a) {
        return div((float) a);
    }

    @Override
    public VectorNf div(float a) {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] / a;
        }
        return d;
    }

    public VectorNf div(VectorNf v) {
        return div(v.vec);
    }

    public VectorNf div(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] / v[comp];
        }
        return d;
    }

    public float dot(VectorNf v) {
        return dot(v.vec);
    }

    public float dot(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        float d = 0;
        for (int comp = 0; comp < size; comp++) {
            d += vec[comp] * v[comp];
        }
        return d;
    }

    public VectorNf project(VectorNf v) {
        return project(v.vec);
    }

    public VectorNf project(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        float lengthSquared = 0;
        for (int comp = 0; comp < size; comp++) {
            lengthSquared += v[comp] * v[comp];
        }
        if (Math.abs(lengthSquared) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final float a = dot(v) / lengthSquared;
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = a * v[comp];
        }
        return d;
    }

    public VectorNf pow(double pow) {
        return pow((float) pow);
    }

    @Override
    public VectorNf pow(float power) {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = (float) Math.pow(vec[comp], power);
        }
        return d;
    }

    @Override
    public VectorNf ceil() {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = (float) Math.ceil(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNf floor() {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = GenericMath.floor(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNf round() {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.round(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNf abs() {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.abs(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNf negate() {
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = -vec[comp];
        }
        return d;
    }

    public VectorNf min(VectorNf v) {
        return min(v.vec);
    }

    public VectorNf min(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.min(vec[comp], v[comp]);
        }
        return d;
    }

    public VectorNf max(VectorNf v) {
        return max(v.vec);
    }

    public VectorNf max(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.max(vec[comp], v[comp]);
        }
        return d;
    }

    public float distanceSquared(VectorNf v) {
        return distanceSquared(v.vec);
    }

    public float distanceSquared(float... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        float d = 0;
        for (int comp = 0; comp < size; comp++) {
            final float delta = vec[comp] - v[comp];
            d += delta * delta;
        }
        return d;
    }

    public float distance(VectorNf v) {
        return distance(v.vec);
    }

    public float distance(float... v) {
        return (float) Math.sqrt(distanceSquared(v));
    }

    @Override
    public float lengthSquared() {
        final int size = size();
        float l = 0;
        for (int comp = 0; comp < size; comp++) {
            l += vec[comp] * vec[comp];
        }
        return l;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public VectorNf normalize() {
        final float length = length();
        if (Math.abs(length) < GenericMath.FLT_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        final int size = size();
        final VectorNf d = new VectorNf(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = (float) (vec[comp] / length);
        }
        return d;
    }

    @Override
    public int getMinAxis() {
        int axis = 0;
        float value = vec[axis];
        final int size = size();
        for (int comp = 1; comp < size; comp++) {
            if (vec[comp] < value) {
                value = vec[comp];
                axis = comp;
            }
        }
        return axis;
    }

    @Override
    public int getMaxAxis() {
        int axis = 0;
        float value = vec[axis];
        final int size = size();
        for (int comp = 1; comp < size; comp++) {
            if (vec[comp] > value) {
                value = vec[comp];
                axis = comp;
            }
        }
        return axis;
    }

    public Vector2f toVector2() {
        return new Vector2f(this);
    }

    public Vector3f toVector3() {
        return new Vector3f(this);
    }

    public Vector4f toVector4() {
        return new Vector4f(this);
    }

    @Override
    public float[] toArray() {
        return vec.clone();
    }

    @Override
    public VectorNi toInt() {
        final int size = size();
        final int[] intVec = new int[size];
        for (int comp = 0; comp < size; comp++) {
            intVec[comp] = GenericMath.floor(vec[comp]);
        }
        return new VectorNi(intVec);
    }

    @Override
    public VectorNl toLong() {
        final int size = size();
        final long[] longVec = new long[size];
        for (int comp = 0; comp < size; comp++) {
            longVec[comp] = GenericMath.floorl(vec[comp]);
        }
        return new VectorNl(longVec);
    }

    @Override
    public VectorNf toFloat() {
        final int size = size();
        final float[] floatVec = new float[size];
        for (int comp = 0; comp < size; comp++) {
            floatVec[comp] = (float) vec[comp];
        }
        return new VectorNf(floatVec);
    }

    @Override
    public VectorNd toDouble() {
        final int size = size();
        final double[] doubleVec = new double[size];
        for (int comp = 0; comp < size; comp++) {
            doubleVec[comp] = (double) vec[comp];
        }
        return new VectorNd(doubleVec);
    }

    @Override
    public int compareTo(VectorNf v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VectorNf)) {
            return false;
        }
        return Arrays.equals(vec, ((VectorNf) obj).vec);
    }

    @Override
    public int hashCode() {
        return 67 * 5 + Arrays.hashCode(vec);
    }

    @Override
    public VectorNf clone() {
        return new VectorNf(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(vec).replace('[', '(').replace(']', ')');
    }

    private static class ImmutableZeroVectorN extends VectorNf {
        public ImmutableZeroVectorN(float... v) {
            super(v);
        }

        @Override
        public void set(int comp, float val) {
            throw new UnsupportedOperationException("You may not alter this vector");
        }
    }
}
