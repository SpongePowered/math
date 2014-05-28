package com.flowpowered.math.test;

import org.junit.Assert;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.matrix.Matrix2f;
import com.flowpowered.math.matrix.Matrix3f;
import com.flowpowered.math.matrix.Matrix4f;
import com.flowpowered.math.matrix.MatrixNf;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;
import com.flowpowered.math.vector.VectorNf;

public class TestUtilf {
    // Constants to reduce the amount of time redundant (5+) quantities are computed:
    public static final float SQRT2 = (float) Math.sqrt(2);
    public static final float SQRT5 = (float) Math.sqrt(5);
    public static final float SQRT13 = (float) Math.sqrt(13);
    public static final float SQRT54 = (float) Math.sqrt(54);

    private static final float EPSILON = 0.00001f;

    public static void assertEquals(float value, float expected) {
        Assert.assertEquals(expected, value, EPSILON);
    }

    public static void assertEquals(Vector2f v, float x, float y) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
    }

    public static void assertEquals(Vector3f v, float x, float y, float z) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
    }

    public static void assertEquals(Vector4f v, float x, float y, float z, float w) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
        assertEquals(v.getW(), w);
    }

    public static void assertEquals(VectorNf v, float... f) {
        Assert.assertArrayEquals(f, v.toArray(), EPSILON);
    }

    public static void assertEquals(Complexf c, float x, float y) {
        assertEquals(c.getX(), x);
        assertEquals(c.getY(), y);
    }

    public static void assertEquals(Quaternionf q, float x, float y, float z, float w) {
        assertEquals(q.getX(), x);
        assertEquals(q.getY(), y);
        assertEquals(q.getZ(), z);
        assertEquals(q.getW(), w);
    }

    public static void assertEquals(Matrix2f m, float m00, float m01, float m10, float m11) {
        assertEquals(m.get(0, 0), m00);
        assertEquals(m.get(0, 1), m01);
        assertEquals(m.get(1, 0), m10);
        assertEquals(m.get(1, 1), m11);
    }

    public static void assertEquals(Matrix3f m, float m00, float m01, float m02, float m10, float m11,
            float m12, float m20, float m21, float m22) {
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

    public static void assertEquals(Matrix4f m, float m00, float m01, float m02, float m03, float m10,
            float m11, float m12, float m13, float m20, float m21, float m22,
            float m23, float m30, float m31, float m32, float m33) {
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

    public static void assertEquals(MatrixNf m, float... f) {
        Assert.assertArrayEquals(f, m.toArray(), EPSILON);
    }

    public static void assertEquals(float[] a, float... f) {
        Assert.assertArrayEquals(f, a, EPSILON);
    }
}
