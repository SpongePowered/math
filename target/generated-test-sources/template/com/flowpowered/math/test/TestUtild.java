package com.flowpowered.math.test;

import org.junit.Assert;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix2d;
import com.flowpowered.math.matrix.Matrix3d;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.matrix.MatrixNd;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector4d;
import com.flowpowered.math.vector.VectorNd;

public class TestUtild {
    // Constants to reduce the amount of time redundant (5+) quantities are computed:
    public static final double SQRT2 = (double) Math.sqrt(2);
    public static final double SQRT5 = (double) Math.sqrt(5);
    public static final double SQRT13 = (double) Math.sqrt(13);
    public static final double SQRT54 = (double) Math.sqrt(54);

    private static final double EPSILON = 0.0000007;

    public static void assertEquals(double value, double expected) {
        Assert.assertEquals(expected, value, EPSILON);
    }

    public static void assertEquals(Vector2d v, double x, double y) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
    }

    public static void assertEquals(Vector3d v, double x, double y, double z) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
    }

    public static void assertEquals(Vector4d v, double x, double y, double z, double w) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
        assertEquals(v.getW(), w);
    }

    public static void assertEquals(VectorNd v, double... f) {
        Assert.assertArrayEquals(f, v.toArray(), EPSILON);
    }

    public static void assertEquals(Complexd c, double x, double y) {
        assertEquals(c.getX(), x);
        assertEquals(c.getY(), y);
    }

    public static void assertEquals(Quaterniond q, double x, double y, double z, double w) {
        assertEquals(q.getX(), x);
        assertEquals(q.getY(), y);
        assertEquals(q.getZ(), z);
        assertEquals(q.getW(), w);
    }

    public static void assertEquals(Matrix2d m, double m00, double m01, double m10, double m11) {
        assertEquals(m.get(0, 0), m00);
        assertEquals(m.get(0, 1), m01);
        assertEquals(m.get(1, 0), m10);
        assertEquals(m.get(1, 1), m11);
    }

    public static void assertEquals(Matrix3d m, double m00, double m01, double m02, double m10, double m11,
            double m12, double m20, double m21, double m22) {
        assertEquals(m.get(0, 0), m00);
        assertEquals(m.get(0, 1), m01);
        assertEquals(m.get(0, 2), m02);
        assertEquals(m.get(1, 0), m10);
        assertEquals(m.get(1, 1), m11);
        assertEquals(m.get(1, 2), m12);
        assertEquals(m.get(2, 0), m20);
        assertEquals(m.get(2, 1), m21);
        assertEquals(m.get(2, 2), m22);
    }

    public static void assertEquals(Matrix4d m, double m00, double m01, double m02, double m03, double m10,
            double m11, double m12, double m13, double m20, double m21, double m22,
            double m23, double m30, double m31, double m32, double m33) {
        assertEquals(m.get(0, 0), m00);
        assertEquals(m.get(0, 1), m01);
        assertEquals(m.get(0, 2), m02);
        assertEquals(m.get(0, 3), m03);
        assertEquals(m.get(1, 0), m10);
        assertEquals(m.get(1, 1), m11);
        assertEquals(m.get(1, 2), m12);
        assertEquals(m.get(1, 3), m13);
        assertEquals(m.get(2, 0), m20);
        assertEquals(m.get(2, 1), m21);
        assertEquals(m.get(2, 2), m22);
        assertEquals(m.get(2, 3), m23);
        assertEquals(m.get(3, 0), m30);
        assertEquals(m.get(3, 1), m31);
        assertEquals(m.get(3, 2), m32);
        assertEquals(m.get(3, 3), m33);
    }

    public static void assertEquals(MatrixNd m, double... f) {
        Assert.assertArrayEquals(f, m.toArray(), EPSILON);
    }

    public static void assertEquals(double[] a, double... f) {
        Assert.assertArrayEquals(f, a, EPSILON);
    }
}
