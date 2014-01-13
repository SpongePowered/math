package com.flowpowered.math.test;

import org.junit.Assert;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.VectorNi;

public class TestUtili {
    public static void assertEquals(int value, int expected) {
        Assert.assertEquals(expected, value);
    }

    public static void assertEquals(int value, long expected) {
        assertEquals(value, (int) expected);
    }
    public static void assertEquals(Vector2i v, int x, int y) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
    }

    public static void assertEquals(Vector2i v, long x, long y) {
        assertEquals(v, (int) x, (int) y);
    }

    public static void assertEquals(Vector3i v, int x, int y, int z) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
    }

    public static void assertEquals(Vector3i v, long x, long y, long z) {
            assertEquals(v, (int) x, (int) y, (int) z);
        }

    public static void assertEquals(Vector4i v, int x, int y, int z, int w) {
        assertEquals(v.getX(), x);
        assertEquals(v.getY(), y);
        assertEquals(v.getZ(), z);
        assertEquals(v.getW(), w);
    }

    public static void assertEquals(Vector4i v, long x, long y, long z, long w) {
        assertEquals(v, (int) x, (int) y, (int) z, (int) w);
    }

    public static void assertEquals(VectorNi v, int... f) {
        Assert.assertArrayEquals(f, v.toArray());
    }

    public static void assertEquals(int[] a, int... f) {
        Assert.assertArrayEquals(f, a);
    }
}
