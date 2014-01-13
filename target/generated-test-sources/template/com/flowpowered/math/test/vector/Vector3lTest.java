package com.flowpowered.math.test.vector;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtill;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.vector.Vector2l;
import com.flowpowered.math.vector.Vector3l;
import com.flowpowered.math.vector.Vector4l;
import com.flowpowered.math.vector.VectorNl;

public class Vector3lTest {
    @Test
    public void testEmptyConstructor() {
        Vector3l vector = new Vector3l();
        TestUtill.assertEquals(vector, (long) 0, (long) 0, (long) 0);
    }

    @Test
    public void testCopyVector2DefaultZConstructor() {
        Vector3l vector = new Vector3l(new Vector2l(0, 1));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 0);
    }

    @Test
    public void testCopyVector2LongZConstructor() {
        Vector3l vector = new Vector3l(new Vector2l(0, 1), (long) 3);
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 3);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector3l vector = new Vector3l(new Vector3l(0, 1, 2));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector3l vector = new Vector3l(new Vector4l(0, 1, 2, 3));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector3l vector = new Vector3l(new VectorNl(0, 1, 2, 3, 4));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector3l vector = new Vector3l(0.5, 1.7, 3.8);
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 3);
    }

    @Test
    public void testLongComponentsConstructor() {
        Vector3l vector = new Vector3l((long) 0, (long) 1, (long) 3);
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 3);
    }

    @Test
    public void testGetters() {
        Vector3l vector = new Vector3l(0, 1, 3);
        TestUtill.assertEquals(vector.getX(), (long) 0);
        TestUtill.assertEquals(vector.getY(), (long) 1);
        TestUtill.assertEquals(vector.getZ(), (long) 3);
    }

    @Test
    public void testVector3Addition() {
        Vector3l vector = new Vector3l(0, 1, 1).add(new Vector3l(5, -2, 3));
        TestUtill.assertEquals(vector, (long) 5, (long) -1, (long) 4);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector3l vector = new Vector3l(0, 1, 5).add(5.5, -2.5, 3.8);
        TestUtill.assertEquals(vector, (long) 5, (long) -1, (long) 8);
    }

    @Test
    public void testLongComponentsAddition() {
        Vector3l vector = new Vector3l(0, 1, 5).add((long) 5, (long) -2, (long) 3);
        TestUtill.assertEquals(vector, (long) 5, (long) -1, (long) 8);
    }

    @Test
    public void testVector3Subtraction() {
        Vector3l vector = new Vector3l(10, 5, 1).sub(new Vector3l(9, 4, 2));
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) -1);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector3l vector = new Vector3l(10, 5, 1).sub(9, 4.5, 2);
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) -1);
    }

    @Test
    public void testLongComponentsSubtraction() {
        Vector3l vector = new Vector3l(10, 5, 1).sub((long) 9, (long) 4, (long) 2);
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) -1);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector3l vector = new Vector3l(2, 3, 4).mul(2.5);
        TestUtill.assertEquals(vector, (long) 4, (long) 6, (long) 8);
    }

    @Test
    public void testLongFactorMultiplication() {
        Vector3l vector = new Vector3l(2, 3, 4).mul((long) 2);
        TestUtill.assertEquals(vector, (long) 4, (long) 6, (long) 8);
    }

    @Test
    public void testVector3Multiplication() {
        Vector3l vector = new Vector3l(2, 3, 4).mul(new Vector3l(1, 2, 3));
        TestUtill.assertEquals(vector, (long) 2, (long) 6, (long) 12);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector3l vector = new Vector3l(2, 3, 4).mul(1.1, 2.5, 3.4);
        TestUtill.assertEquals(vector, (long) 2, (long) 6, (long) 12);
    }

    @Test
    public void testLongComponentsMultiplication() {
        Vector3l vector = new Vector3l(2, 3, 4).mul((long) 1, (long) 2, (long) 3);
        TestUtill.assertEquals(vector, (long) 2, (long) 6, (long) 12);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector3l vector = new Vector3l(2, 3, 5).div(2.1);
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) 2);
    }

    @Test
    public void testLongFactorDivision() {
        Vector3l vector = new Vector3l(2, 3, 5).div((long) 2);
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) 2);
    }

    @Test
    public void testVector3Division() {
        Vector3l vector = new Vector3l(2, 6, 20).div(new Vector3l(2, 4, 8));
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) 2);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector3l vector = new Vector3l(2, 6, 17).div(2.1, 4.5, 8.3);
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) 2);
    }

    @Test
    public void testLongComponentsDivision() {
        Vector3l vector = new Vector3l(2, 6, 17).div((long) 2, (long) 4, (long) 8);
        TestUtill.assertEquals(vector, (long) 1, (long) 1, (long) 2);
    }

    @Test
    public void testVector3DotProduct() {
        long f = new Vector3l(2, 3, 4).dot(new Vector3l(4, 5, 6));
        TestUtill.assertEquals(f, (long) 47);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        long f = new Vector3l(2, 3, 4).dot(4d, 5d, 6d);
        TestUtill.assertEquals(f, (long) 47);
    }

    @Test
    public void testLongComponentsDotProduct() {
        long f = new Vector3l(2, 3, 4).dot((long) 4, (long) 5, (long) 6);
        TestUtill.assertEquals(f, (long) 47);
    }

    @Test
    public void testVector3Cross() {
        Vector3l f = new Vector3l(2, 3, 4).cross(new Vector3l(4, 3, 6.5));
        TestUtill.assertEquals(f, (long) 6, (long) 4, (long) -6);
    }

    @Test
    public void testDoubleComponentsCross() {
        Vector3l f = new Vector3l(2, 3, 4).cross(4, 3, 6.5);
        TestUtill.assertEquals(f, (long) 6, (long) 4, (long) -6);
    }

    @Test
    public void testLongComponentsCross() {
        Vector3l f = new Vector3l(2, 3, 4).cross((long) 4, (long) 3, (long) 6);
        TestUtill.assertEquals(f, (long) 6, (long) 4, (long) -6);
    }

    @Test
    public void testRaiseToLongPower() {
        Vector3l vector = new Vector3l(2, 6, 8).pow((long) 2);
        TestUtill.assertEquals(vector, (long) 4, (long) 36, (long) 64);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector3l vector = new Vector3l(2, 6, 8).pow(2d);
        TestUtill.assertEquals(vector, (long) 4, (long) 36, (long) 64);
    }

    @Test
    public void testAbsolute() {
        Vector3l vector1 = new Vector3l(-2, -6, -55).abs();
        TestUtill.assertEquals(vector1, (long) 2, (long) 6, (long) 55);
        Vector3l vector2 = new Vector3l(2, 6, 55).abs();
        TestUtill.assertEquals(vector2, (long) 2, (long) 6, (long) 55);
    }

    @Test
    public void testNegate() {
        Vector3l vector = new Vector3l(2, -6, 15).negate();
        TestUtill.assertEquals(vector, (long) -2, (long) 6, (long) -15);
    }

    @Test
    public void testVector3Minimum() {
        Vector3l vector = new Vector3l(2, 6, -1).min(new Vector3l(3, 4, 10));
        TestUtill.assertEquals(vector, (long) 2, (long) 4, (long) -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector3l vector = new Vector3l(2, 6, 10).min(3d, 4d, -5d);
        TestUtill.assertEquals(vector, (long) 2, (long) 4, (long) -5);
    }

    @Test
    public void testLongComponentsMinimum() {
        Vector3l vector = new Vector3l(2, 6, 10).min((long) 3, (long) 4, (long) -5);
        TestUtill.assertEquals(vector, (long) 2, (long) 4, (long) -5);
    }

    @Test
    public void testVector3Maximum() {
        Vector3l vector = new Vector3l(2, 6, 10).max(new Vector3l(3, 4, -5));
        TestUtill.assertEquals(vector, (long) 3, (long) 6, (long) 10);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector3l vector = new Vector3l(2, 6, 10).max(3d, 4d, -5d);
        TestUtill.assertEquals(vector, (long) 3, (long) 6, (long) 10);
    }

    @Test
    public void testLongComponentsMaximum() {
        Vector3l vector = new Vector3l(2, 6, 10).max((long) 3, (long) 4, (long) -5);
        TestUtill.assertEquals(vector, (long) 3, (long) 6, (long) 10);
    }

    @Test
    public void testVector3DistanceSquared() {
        long f = new Vector3l(2, 3, 4).distanceSquared(new Vector3l(5, 6, 7));
        TestUtill.assertEquals(f, (long) 27);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        long f = new Vector3l(2, 3, 4).distanceSquared(5d, 6d, 7d);
        TestUtill.assertEquals(f, (long) 27);
    }

    @Test
    public void testLongComponentsDistanceSquared() {
        long f = new Vector3l(2, 3, 4).distanceSquared((long) 5, (long) 6, (long) 7);
        TestUtill.assertEquals(f, (long) 27);
    }

    @Test
    public void testVector3Distance() {
        long f = new Vector3l(0, 2, 4).distance(new Vector3l(0, 8, 16));
        TestUtill.assertEquals(f, (long) 13);
    }

    @Test
    public void testDoubleComponentsDistance() {
        long f = new Vector3l(0, 2, 4).distance(0d, 8d, 16d);
        TestUtill.assertEquals(f, (long) 13);
    }

    @Test
    public void testLongComponentsDistance() {
        long f = new Vector3l(0, 2, 4).distance((long) 0, (long) 8, (long) 16);
        TestUtill.assertEquals(f,  (long) 13);
    }

    @Test
    public void testLength() {
        long f = new Vector3l(3, 4, 5).length();
        TestUtill.assertEquals(f, (long) 7);
    }

    @Test
    public void testLengthSquared() {
        long f = new Vector3l(3, 4, 5).lengthSquared();
        TestUtill.assertEquals(f, (long) 50);
    }

    @Test
    public void testGetMinAxis() {
        Vector3l vector1 = new Vector3l(1, 2, 3);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        Vector3l vector2 = new Vector3l(2, 1, 3);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
        Vector3l vector3 = new Vector3l(3, 2, 1);
        TestUtili.assertEquals(vector3.getMinAxis(), 2);
    }

    @Test
    public void testGetMaxAxis() {
        Vector3l vector1 = new Vector3l(3, 1, 2);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        Vector3l vector2 = new Vector3l(1, 3, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
        Vector3l vector3 = new Vector3l(1, 2, 3);
        TestUtili.assertEquals(vector3.getMaxAxis(), 2);
    }

    @Test
    public void testConvertToVector2() {
        Vector2l vector = new Vector3l(1, 2, 3).toVector2();
        TestUtill.assertEquals(vector, (long) 1, (long) 2);
    }

    @Test
    public void testConvertToVector4DefaultW() {
        Vector4l vector = new Vector3l(1, 2, 3).toVector4();
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3, (long) 0);
    }

    @Test
    public void testConvertToVector4LongW() {
        Vector4l vector = new Vector3l(1, 2, 3).toVector4((long) 4);
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testConvertToVector4DoubleW() {
        Vector4l vector = new Vector3l(1, 2, 3).toVector4(4d);
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNl vector = new Vector3l(1, 2, 3).toVectorN();
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3);
    }

    @Test
    public void testConvertToArray() {
        long[] array = new Vector3l(1, 2, 3).toArray();
        TestUtill.assertEquals(array, (long) 1, (long) 2, (long) 3);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector3l(10, 20, 30).compareTo(new Vector3l(20, 20, 30));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector3l(10, 20, 30).compareTo(new Vector3l(10, 20, 30));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector3l(10, 20, 30).compareTo(new Vector3l(10, 10, 30));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector3l(122, 43, 96).equals(new Vector3l(122, 43, 96)));
        Assert.assertFalse(new Vector3l(122, 43, 96).equals(new Vector3l(378, 95, 96)));
    }

    @Test
    public void testCloning() {
        Vector3l vector = new Vector3l(3, 2, 5);
        Assert.assertEquals(vector, vector.clone());
    }
}
