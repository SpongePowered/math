package com.flowpowered.math.test.vector;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.VectorNi;

public class Vector3iTest {
    @Test
    public void testEmptyConstructor() {
        Vector3i vector = new Vector3i();
        TestUtili.assertEquals(vector, (int) 0, (int) 0, (int) 0);
    }

    @Test
    public void testCopyVector2DefaultZConstructor() {
        Vector3i vector = new Vector3i(new Vector2i(0, 1));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 0);
    }

    @Test
    public void testCopyVector2IntZConstructor() {
        Vector3i vector = new Vector3i(new Vector2i(0, 1), (int) 3);
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 3);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector3i vector = new Vector3i(new Vector3i(0, 1, 2));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector3i vector = new Vector3i(new Vector4i(0, 1, 2, 3));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector3i vector = new Vector3i(new VectorNi(0, 1, 2, 3, 4));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector3i vector = new Vector3i(0.5, 1.7, 3.8);
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 3);
    }

    @Test
    public void testIntComponentsConstructor() {
        Vector3i vector = new Vector3i((int) 0, (int) 1, (int) 3);
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 3);
    }

    @Test
    public void testGetters() {
        Vector3i vector = new Vector3i(0, 1, 3);
        TestUtili.assertEquals(vector.getX(), (int) 0);
        TestUtili.assertEquals(vector.getY(), (int) 1);
        TestUtili.assertEquals(vector.getZ(), (int) 3);
    }

    @Test
    public void testVector3Addition() {
        Vector3i vector = new Vector3i(0, 1, 1).add(new Vector3i(5, -2, 3));
        TestUtili.assertEquals(vector, (int) 5, (int) -1, (int) 4);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector3i vector = new Vector3i(0, 1, 5).add(5.5, -2.5, 3.8);
        TestUtili.assertEquals(vector, (int) 5, (int) -1, (int) 8);
    }

    @Test
    public void testIntComponentsAddition() {
        Vector3i vector = new Vector3i(0, 1, 5).add((int) 5, (int) -2, (int) 3);
        TestUtili.assertEquals(vector, (int) 5, (int) -1, (int) 8);
    }

    @Test
    public void testVector3Subtraction() {
        Vector3i vector = new Vector3i(10, 5, 1).sub(new Vector3i(9, 4, 2));
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) -1);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector3i vector = new Vector3i(10, 5, 1).sub(9, 4.5, 2);
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) -1);
    }

    @Test
    public void testIntComponentsSubtraction() {
        Vector3i vector = new Vector3i(10, 5, 1).sub((int) 9, (int) 4, (int) 2);
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) -1);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector3i vector = new Vector3i(2, 3, 4).mul(2.5);
        TestUtili.assertEquals(vector, (int) 4, (int) 6, (int) 8);
    }

    @Test
    public void testIntFactorMultiplication() {
        Vector3i vector = new Vector3i(2, 3, 4).mul((int) 2);
        TestUtili.assertEquals(vector, (int) 4, (int) 6, (int) 8);
    }

    @Test
    public void testVector3Multiplication() {
        Vector3i vector = new Vector3i(2, 3, 4).mul(new Vector3i(1, 2, 3));
        TestUtili.assertEquals(vector, (int) 2, (int) 6, (int) 12);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector3i vector = new Vector3i(2, 3, 4).mul(1.1, 2.5, 3.4);
        TestUtili.assertEquals(vector, (int) 2, (int) 6, (int) 12);
    }

    @Test
    public void testIntComponentsMultiplication() {
        Vector3i vector = new Vector3i(2, 3, 4).mul((int) 1, (int) 2, (int) 3);
        TestUtili.assertEquals(vector, (int) 2, (int) 6, (int) 12);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector3i vector = new Vector3i(2, 3, 5).div(2.1);
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) 2);
    }

    @Test
    public void testIntFactorDivision() {
        Vector3i vector = new Vector3i(2, 3, 5).div((int) 2);
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) 2);
    }

    @Test
    public void testVector3Division() {
        Vector3i vector = new Vector3i(2, 6, 20).div(new Vector3i(2, 4, 8));
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) 2);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector3i vector = new Vector3i(2, 6, 17).div(2.1, 4.5, 8.3);
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) 2);
    }

    @Test
    public void testIntComponentsDivision() {
        Vector3i vector = new Vector3i(2, 6, 17).div((int) 2, (int) 4, (int) 8);
        TestUtili.assertEquals(vector, (int) 1, (int) 1, (int) 2);
    }

    @Test
    public void testVector3DotProduct() {
        int f = new Vector3i(2, 3, 4).dot(new Vector3i(4, 5, 6));
        TestUtili.assertEquals(f, (int) 47);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        int f = new Vector3i(2, 3, 4).dot(4d, 5d, 6d);
        TestUtili.assertEquals(f, (int) 47);
    }

    @Test
    public void testIntComponentsDotProduct() {
        int f = new Vector3i(2, 3, 4).dot((int) 4, (int) 5, (int) 6);
        TestUtili.assertEquals(f, (int) 47);
    }

    @Test
    public void testVector3Cross() {
        Vector3i f = new Vector3i(2, 3, 4).cross(new Vector3i(4, 3, 6.5));
        TestUtili.assertEquals(f, (int) 6, (int) 4, (int) -6);
    }

    @Test
    public void testDoubleComponentsCross() {
        Vector3i f = new Vector3i(2, 3, 4).cross(4, 3, 6.5);
        TestUtili.assertEquals(f, (int) 6, (int) 4, (int) -6);
    }

    @Test
    public void testIntComponentsCross() {
        Vector3i f = new Vector3i(2, 3, 4).cross((int) 4, (int) 3, (int) 6);
        TestUtili.assertEquals(f, (int) 6, (int) 4, (int) -6);
    }

    @Test
    public void testRaiseToIntPower() {
        Vector3i vector = new Vector3i(2, 6, 8).pow((int) 2);
        TestUtili.assertEquals(vector, (int) 4, (int) 36, (int) 64);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector3i vector = new Vector3i(2, 6, 8).pow(2d);
        TestUtili.assertEquals(vector, (int) 4, (int) 36, (int) 64);
    }

    @Test
    public void testAbsolute() {
        Vector3i vector1 = new Vector3i(-2, -6, -55).abs();
        TestUtili.assertEquals(vector1, (int) 2, (int) 6, (int) 55);
        Vector3i vector2 = new Vector3i(2, 6, 55).abs();
        TestUtili.assertEquals(vector2, (int) 2, (int) 6, (int) 55);
    }

    @Test
    public void testNegate() {
        Vector3i vector = new Vector3i(2, -6, 15).negate();
        TestUtili.assertEquals(vector, (int) -2, (int) 6, (int) -15);
    }

    @Test
    public void testVector3Minimum() {
        Vector3i vector = new Vector3i(2, 6, -1).min(new Vector3i(3, 4, 10));
        TestUtili.assertEquals(vector, (int) 2, (int) 4, (int) -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector3i vector = new Vector3i(2, 6, 10).min(3d, 4d, -5d);
        TestUtili.assertEquals(vector, (int) 2, (int) 4, (int) -5);
    }

    @Test
    public void testIntComponentsMinimum() {
        Vector3i vector = new Vector3i(2, 6, 10).min((int) 3, (int) 4, (int) -5);
        TestUtili.assertEquals(vector, (int) 2, (int) 4, (int) -5);
    }

    @Test
    public void testVector3Maximum() {
        Vector3i vector = new Vector3i(2, 6, 10).max(new Vector3i(3, 4, -5));
        TestUtili.assertEquals(vector, (int) 3, (int) 6, (int) 10);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector3i vector = new Vector3i(2, 6, 10).max(3d, 4d, -5d);
        TestUtili.assertEquals(vector, (int) 3, (int) 6, (int) 10);
    }

    @Test
    public void testIntComponentsMaximum() {
        Vector3i vector = new Vector3i(2, 6, 10).max((int) 3, (int) 4, (int) -5);
        TestUtili.assertEquals(vector, (int) 3, (int) 6, (int) 10);
    }

    @Test
    public void testVector3DistanceSquared() {
        int f = new Vector3i(2, 3, 4).distanceSquared(new Vector3i(5, 6, 7));
        TestUtili.assertEquals(f, (int) 27);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        int f = new Vector3i(2, 3, 4).distanceSquared(5d, 6d, 7d);
        TestUtili.assertEquals(f, (int) 27);
    }

    @Test
    public void testIntComponentsDistanceSquared() {
        int f = new Vector3i(2, 3, 4).distanceSquared((int) 5, (int) 6, (int) 7);
        TestUtili.assertEquals(f, (int) 27);
    }

    @Test
    public void testVector3Distance() {
        int f = new Vector3i(0, 2, 4).distance(new Vector3i(0, 8, 16));
        TestUtili.assertEquals(f, (int) 13);
    }

    @Test
    public void testDoubleComponentsDistance() {
        int f = new Vector3i(0, 2, 4).distance(0d, 8d, 16d);
        TestUtili.assertEquals(f, (int) 13);
    }

    @Test
    public void testIntComponentsDistance() {
        int f = new Vector3i(0, 2, 4).distance((int) 0, (int) 8, (int) 16);
        TestUtili.assertEquals(f,  (int) 13);
    }

    @Test
    public void testLength() {
        int f = new Vector3i(3, 4, 5).length();
        TestUtili.assertEquals(f, (int) 7);
    }

    @Test
    public void testLengthSquared() {
        int f = new Vector3i(3, 4, 5).lengthSquared();
        TestUtili.assertEquals(f, (int) 50);
    }

    @Test
    public void testGetMinAxis() {
        Vector3i vector1 = new Vector3i(1, 2, 3);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        Vector3i vector2 = new Vector3i(2, 1, 3);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
        Vector3i vector3 = new Vector3i(3, 2, 1);
        TestUtili.assertEquals(vector3.getMinAxis(), 2);
    }

    @Test
    public void testGetMaxAxis() {
        Vector3i vector1 = new Vector3i(3, 1, 2);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        Vector3i vector2 = new Vector3i(1, 3, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
        Vector3i vector3 = new Vector3i(1, 2, 3);
        TestUtili.assertEquals(vector3.getMaxAxis(), 2);
    }

    @Test
    public void testConvertToVector2() {
        Vector2i vector = new Vector3i(1, 2, 3).toVector2();
        TestUtili.assertEquals(vector, (int) 1, (int) 2);
    }

    @Test
    public void testConvertToVector4DefaultW() {
        Vector4i vector = new Vector3i(1, 2, 3).toVector4();
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3, (int) 0);
    }

    @Test
    public void testConvertToVector4IntW() {
        Vector4i vector = new Vector3i(1, 2, 3).toVector4((int) 4);
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testConvertToVector4DoubleW() {
        Vector4i vector = new Vector3i(1, 2, 3).toVector4(4d);
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNi vector = new Vector3i(1, 2, 3).toVectorN();
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3);
    }

    @Test
    public void testConvertToArray() {
        int[] array = new Vector3i(1, 2, 3).toArray();
        TestUtili.assertEquals(array, (int) 1, (int) 2, (int) 3);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector3i(10, 20, 30).compareTo(new Vector3i(20, 20, 30));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector3i(10, 20, 30).compareTo(new Vector3i(10, 20, 30));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector3i(10, 20, 30).compareTo(new Vector3i(10, 10, 30));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector3i(122, 43, 96).equals(new Vector3i(122, 43, 96)));
        Assert.assertFalse(new Vector3i(122, 43, 96).equals(new Vector3i(378, 95, 96)));
    }

    @Test
    public void testCloning() {
        Vector3i vector = new Vector3i(3, 2, 5);
        Assert.assertEquals(vector, vector.clone());
    }
}
