package com.flowpowered.math.test;

import org.junit.Assert;

import com.flowpowered.math.vector.Vector2l;
import com.flowpowered.math.vector.Vector3l;
import com.flowpowered.math.vector.Vector4l;
import com.flowpowered.math.vector.VectorNl;

public class TestUtill {
    public static void assertEquals(long value, long expected) {
        Assert.assertEquals(expected, value);
    }

    public static void assertEquals(long value, int expected) {
        assertEquals(value, (long) expected);
    }
    public static void assertEquals(Vector2l v, long x, long y) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
    }

    public static void assertEquals(Vector2l v, int x, int y) {
        assertEquals(v, (long) x, (long) y);
    }

    public static void assertEquals(Vector3l v, long x, long y, long z) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
    }

    public static void assertEquals(Vector3l v, int x, int y, int z) {
            assertEquals(v, (long) x, (long) y, (long) z);
        }

    public static void assertEquals(Vector4l v, long x, long y, long z, long w) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
        assertEquals(v.getW(), w);
    }

    public static void assertEquals(Vector4l v, int x, int y, int z, int w) {
        assertEquals(v, (long) x, (long) y, (long) z, (long) w);
    }

    public static void assertEquals(VectorNl v, long... f) {
        Assert.assertArrayEquals(f, v.toArray());
    }

    public static void assertEquals(long[] a, long... f) {
        Assert.assertArrayEquals(f, a);
    }
}
