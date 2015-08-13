package com.flowpowered.math.vector;

import java.io.Serializable;
import java.util.Arrays;

import com.flowpowered.math.GenericMath;

public class VectorNl implements Vectorl, Comparable<VectorNl>, Serializable, Cloneable {
    public static VectorNl ZERO_2 = new ImmutableZeroVectorN(0, 0);
    public static VectorNl ZERO_3 = new ImmutableZeroVectorN(0, 0, 0);
    public static VectorNl ZERO_4 = new ImmutableZeroVectorN(0, 0, 0, 0);
    private static final long serialVersionUID = 1;
    private final long[] vec;

    public VectorNl(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Minimum vector size is 2");
        }
        vec = new long[size];
    }

    public VectorNl(Vector2l v) {
        this(v.getX(), v.getY());
    }

    public VectorNl(Vector3l v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public VectorNl(Vector4l v) {
        this(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public VectorNl(VectorNl v) {
        this(v.vec);
    }

    public VectorNl(long... v) {
        vec = v.clone();
    }

    public int size() {
        return vec.length;
    }

    public long get(int comp) {
        return vec[comp];
    }

    public void set(int comp, long val) {
        vec[comp] = val;
    }

    public void setZero() {
        Arrays.fill(vec, 0);
    }

    public VectorNl resize(int size) {
        final VectorNl d = new VectorNl(size);
        System.arraycopy(vec, 0, d.vec, 0, Math.min(size, size()));
        return d;
    }

    public VectorNl add(VectorNl v) {
        return add(v.vec);
    }

    public VectorNl add(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] + v[comp];
        }
        return d;
    }

    public VectorNl sub(VectorNl v) {
        return sub(v.vec);
    }

    public VectorNl sub(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] - v[comp];
        }
        return d;
    }

    public VectorNl mul(double a) {
        return mul(GenericMath.floorl(a));
    }

    @Override
    public VectorNl mul(long a) {
        final int size = size();
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] * a;
        }
        return d;
    }

    public VectorNl mul(VectorNl v) {
        return mul(v.vec);
    }

    public VectorNl mul(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] * v[comp];
        }
        return d;
    }

    public VectorNl div(double a) {
        return div(GenericMath.floorl(a));
    }

    @Override
    public VectorNl div(long a) {
        final int size = size();
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] / a;
        }
        return d;
    }

    public VectorNl div(VectorNl v) {
        return div(v.vec);
    }

    public VectorNl div(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] / v[comp];
        }
        return d;
    }

    public long dot(VectorNl v) {
        return dot(v.vec);
    }

    public long dot(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        long d = 0;
        for (int comp = 0; comp < size; comp++) {
            d += vec[comp] * v[comp];
        }
        return d;
    }

    public VectorNl project(VectorNl v) {
        return project(v.vec);
    }

    public VectorNl project(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        long lengthSquared = 0;
        for (int comp = 0; comp < size; comp++) {
            lengthSquared += v[comp] * v[comp];
        }
        if (lengthSquared == 0) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = (double) dot(v) / lengthSquared;
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = GenericMath.floorl(a * v[comp]);
        }
        return d;
    }

    public VectorNl pow(double pow) {
        return pow(GenericMath.floorl(pow));
    }

    @Override
    public VectorNl pow(long power) {
        final int size = size();
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = GenericMath.floorl(Math.pow(vec[comp], power));
        }
        return d;
    }

    @Override
    public VectorNl abs() {
        final int size = size();
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.abs(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNl negate() {
        final int size = size();
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = -vec[comp];
        }
        return d;
    }

    public VectorNl min(VectorNl v) {
        return min(v.vec);
    }

    public VectorNl min(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.min(vec[comp], v[comp]);
        }
        return d;
    }

    public VectorNl max(VectorNl v) {
        return max(v.vec);
    }

    public VectorNl max(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNl d = new VectorNl(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.max(vec[comp], v[comp]);
        }
        return d;
    }

    public long distanceSquared(VectorNl v) {
        return distanceSquared(v.vec);
    }

    public long distanceSquared(long... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        long d = 0;
        for (int comp = 0; comp < size; comp++) {
            final long delta = vec[comp] - v[comp];
            d += delta * delta;
        }
        return d;
    }

    public double distance(VectorNl v) {
        return distance(v.vec);
    }

    public double distance(long... v) {
        return (double) Math.sqrt(distanceSquared(v));
    }

    @Override
    public long lengthSquared() {
        final int size = size();
        long l = 0;
        for (int comp = 0; comp < size; comp++) {
            l += vec[comp] * vec[comp];
        }
        return l;
    }

    @Override
    public double length() {
        return (double) Math.sqrt(lengthSquared());
    }

    @Override
    public int getMinAxis() {
        int axis = 0;
        long value = vec[axis];
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
        long value = vec[axis];
        final int size = size();
        for (int comp = 1; comp < size; comp++) {
            if (vec[comp] > value) {
                value = vec[comp];
                axis = comp;
            }
        }
        return axis;
    }

    public Vector2l toVector2() {
        return new Vector2l(this);
    }

    public Vector3l toVector3() {
        return new Vector3l(this);
    }

    public Vector4l toVector4() {
        return new Vector4l(this);
    }

    @Override
    public long[] toArray() {
        return vec.clone();
    }

    @Override
    public VectorNi toInt() {
        final int size = size();
        final int[] intVec = new int[size];
        for (int comp = 0; comp < size; comp++) {
            intVec[comp] = (int) vec[comp];
        }
        return new VectorNi(intVec);
    }

    @Override
    public VectorNl toLong() {
        final int size = size();
        final long[] longVec = new long[size];
        for (int comp = 0; comp < size; comp++) {
            longVec[comp] = (long) vec[comp];
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
    public int compareTo(VectorNl v) {
        return (int) (lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VectorNl)) {
            return false;
        }
        return Arrays.equals(vec, ((VectorNl) obj).vec);
    }

    @Override
    public int hashCode() {
        return 67 * 5 + Arrays.hashCode(vec);
    }

    @Override
    public VectorNl clone() {
        return new VectorNl(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(vec).replace('[', '(').replace(']', ')');
    }

    private static class ImmutableZeroVectorN extends VectorNl {
        public ImmutableZeroVectorN(long... v) {
            super(v);
        }

        @Override
        public void set(int comp, long val) {
            throw new UnsupportedOperationException("You may not alter this vector");
        }
    }
}
