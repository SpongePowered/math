package com.flowpowered.math.vector;

import java.io.Serializable;
import java.util.Arrays;

import com.flowpowered.math.GenericMath;

public class VectorNd implements Vectord, Comparable<VectorNd>, Serializable, Cloneable {
    public static VectorNd ZERO_2 = new ImmutableZeroVectorN(0, 0);
    public static VectorNd ZERO_3 = new ImmutableZeroVectorN(0, 0, 0);
    public static VectorNd ZERO_4 = new ImmutableZeroVectorN(0, 0, 0, 0);
    private static final long serialVersionUID = 1;
    private final double[] vec;

    public VectorNd(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Minimum vector size is 2");
        }
        vec = new double[size];
    }

    public VectorNd(Vector2d v) {
        this(v.getX(), v.getY());
    }

    public VectorNd(Vector3d v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public VectorNd(Vector4d v) {
        this(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public VectorNd(VectorNd v) {
        this(v.vec);
    }

    public VectorNd(double... v) {
        vec = v.clone();
    }

    public int size() {
        return vec.length;
    }

    public double get(int comp) {
        return vec[comp];
    }

    public int getFloored(int comp) {
        return GenericMath.floor(get(comp));
    }

    public void set(int comp, float val) {
        set(comp, (double) val);
    }

    public void set(int comp, double val) {
        vec[comp] = val;
    }

    public void setZero() {
        Arrays.fill(vec, 0);
    }

    public VectorNd resize(int size) {
        final VectorNd d = new VectorNd(size);
        System.arraycopy(vec, 0, d.vec, 0, Math.min(size, size()));
        return d;
    }

    public VectorNd add(VectorNd v) {
        return add(v.vec);
    }

    public VectorNd add(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] + v[comp];
        }
        return d;
    }

    public VectorNd sub(VectorNd v) {
        return sub(v.vec);
    }

    public VectorNd sub(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] - v[comp];
        }
        return d;
    }

    public VectorNd mul(float a) {
        return mul((double) a);
    }

    @Override
    public VectorNd mul(double a) {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] * a;
        }
        return d;
    }

    public VectorNd mul(VectorNd v) {
        return mul(v.vec);
    }

    public VectorNd mul(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] * v[comp];
        }
        return d;
    }

    public VectorNd div(float a) {
        return div((double) a);
    }

    @Override
    public VectorNd div(double a) {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] / a;
        }
        return d;
    }

    public VectorNd div(VectorNd v) {
        return div(v.vec);
    }

    public VectorNd div(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = vec[comp] / v[comp];
        }
        return d;
    }

    public double dot(VectorNd v) {
        return dot(v.vec);
    }

    public double dot(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        double d = 0;
        for (int comp = 0; comp < size; comp++) {
            d += vec[comp] * v[comp];
        }
        return d;
    }

    public VectorNd project(VectorNd v) {
        return project(v.vec);
    }

    public VectorNd project(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        double lengthSquared = 0;
        for (int comp = 0; comp < size; comp++) {
            lengthSquared += v[comp] * v[comp];
        }
        if (Math.abs(lengthSquared) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot project onto the zero vector");
        }
        final double a = dot(v) / lengthSquared;
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = a * v[comp];
        }
        return d;
    }

    public VectorNd pow(float pow) {
        return pow((double) pow);
    }

    @Override
    public VectorNd pow(double power) {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = (double) Math.pow(vec[comp], power);
        }
        return d;
    }

    @Override
    public VectorNd ceil() {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = (double) Math.ceil(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNd floor() {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = GenericMath.floor(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNd round() {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.round(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNd abs() {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.abs(vec[comp]);
        }
        return d;
    }

    @Override
    public VectorNd negate() {
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = -vec[comp];
        }
        return d;
    }

    public VectorNd min(VectorNd v) {
        return min(v.vec);
    }

    public VectorNd min(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.min(vec[comp], v[comp]);
        }
        return d;
    }

    public VectorNd max(VectorNd v) {
        return max(v.vec);
    }

    public VectorNd max(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = Math.max(vec[comp], v[comp]);
        }
        return d;
    }

    public double distanceSquared(VectorNd v) {
        return distanceSquared(v.vec);
    }

    public double distanceSquared(double... v) {
        final int size = size();
        if (size != v.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }
        double d = 0;
        for (int comp = 0; comp < size; comp++) {
            final double delta = vec[comp] - v[comp];
            d += delta * delta;
        }
        return d;
    }

    public double distance(VectorNd v) {
        return distance(v.vec);
    }

    public double distance(double... v) {
        return (double) Math.sqrt(distanceSquared(v));
    }

    @Override
    public double lengthSquared() {
        final int size = size();
        double l = 0;
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
    public VectorNd normalize() {
        final double length = length();
        if (Math.abs(length) < GenericMath.DBL_EPSILON) {
            throw new ArithmeticException("Cannot normalize the zero vector");
        }
        final int size = size();
        final VectorNd d = new VectorNd(size);
        for (int comp = 0; comp < size; comp++) {
            d.vec[comp] = (double) (vec[comp] / length);
        }
        return d;
    }

    @Override
    public int getMinAxis() {
        int axis = 0;
        double value = vec[axis];
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
        double value = vec[axis];
        final int size = size();
        for (int comp = 1; comp < size; comp++) {
            if (vec[comp] > value) {
                value = vec[comp];
                axis = comp;
            }
        }
        return axis;
    }

    public Vector2d toVector2() {
        return new Vector2d(this);
    }

    public Vector3d toVector3() {
        return new Vector3d(this);
    }

    public Vector4d toVector4() {
        return new Vector4d(this);
    }

    @Override
    public double[] toArray() {
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
    public int compareTo(VectorNd v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VectorNd)) {
            return false;
        }
        return Arrays.equals(vec, ((VectorNd) obj).vec);
    }

    @Override
    public int hashCode() {
        return 67 * 5 + Arrays.hashCode(vec);
    }

    @Override
    public VectorNd clone() {
        return new VectorNd(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(vec).replace('[', '(').replace(']', ')');
    }

    private static class ImmutableZeroVectorN extends VectorNd {
        public ImmutableZeroVectorN(double... v) {
            super(v);
        }

        @Override
        public void set(int comp, double val) {
            throw new UnsupportedOperationException("You may not alter this vector");
        }
    }
}
