package com.flowpowered.math.test.vector;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtill;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.vector.Vector2l;
import com.flowpowered.math.vector.Vector3l;
import com.flowpowered.math.vector.Vector4l;
import com.flowpowered.math.vector.VectorNl;

public class Vector2lTest {
    @Test
    public void testEmptyConstructor() {
        Vector2l vector = new Vector2l();
        TestUtill.assertEquals(vector, (long) 0, (long) 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        Vector2l vector = new Vector2l(new Vector2l(0, 1));
        TestUtill.assertEquals(vector, (long) 0, (long) 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector2l vector = new Vector2l(new Vector3l(0, 1, 2));
        TestUtill.assertEquals(vector, (long) 0, (long) 1);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector2l vector = new Vector2l(new Vector4l(0, 1, 2, 3));
        TestUtill.assertEquals(vector, (long) 0, (long) 1);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector2l vector = new Vector2l(new VectorNl(0, 1, 2, 3, 4));
        TestUtill.assertEquals(vector, (long) 0, (long) 1);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector2l vector = new Vector2l(0.5, 1.7);
        TestUtill.assertEquals(vector, (long) 0, (long) 1);
    }

    @Test
    public void testLongComponentsConstructor() {
        Vector2l vector = new Vector2l((long) 1, (long) 3);
        TestUtill.assertEquals(vector, (long) 1, (long) 3);
    }

    @Test
    public void testGetters() {
        Vector2l vector = new Vector2l(1, 3);
        TestUtill.assertEquals(vector.getX(), (long) 1);
        TestUtill.assertEquals(vector.getY(), (long) 3);
    }

    @Test
    public void testVector2Addition() {
        Vector2l vector = new Vector2l(1, 3).add(new Vector2l(5, -1));
        TestUtill.assertEquals(vector, (long) 6, (long) 2);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector2l vector = new Vector2l(1, 3).add(5.5, -1.5);
        TestUtill.assertEquals(vector, (long) 6, (long) 1);
    }

    @Test
    public void testLongComponentsAddition() {
        Vector2l vector = new Vector2l(1, 3).add(5, -1);
        TestUtill.assertEquals(vector, (long) 6, (long) 2);
    }

    @Test
    public void testVector2Subtraction() {
        Vector2l vector = new Vector2l(10, 5).sub(new Vector2l(13, 4));
        TestUtill.assertEquals(vector, (long) -3, (long) 1);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector2l vector = new Vector2l(10, 5).sub(13, 4);
        TestUtill.assertEquals(vector, (long) -3, (long) 1);
    }

    @Test
    public void testLongComponentsSubtraction() {
        Vector2l vector = new Vector2l(10, 5).sub(13f, 4.5f);
        TestUtill.assertEquals(vector, (long) -3, (long) 1);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector2l vector = new Vector2l(2, 3).mul(2.5);
        TestUtill.assertEquals(vector, (long) 4, (long) 6);
    }

    @Test
    public void testLongFactorMultiplication() {
        Vector2l vector = new Vector2l(2, 3).mul((long) 3);
        TestUtill.assertEquals(vector, (long) 6, (long) 9);
    }

    @Test
    public void testVector2Multiplication() {
        Vector2l vector = new Vector2l(2, 3).mul(new Vector2l(5, 2));
        TestUtill.assertEquals(vector, (long) 10, (long) 6);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector2l vector = new Vector2l(2, 3).mul(1.5, 2.5);
        TestUtill.assertEquals(vector, (long) 2, (long) 6);
    }

    @Test
    public void testLongComponentsMultiplication() {
        Vector2l vector = new Vector2l(2, 3).mul((long) 5, (long) 2);
        TestUtill.assertEquals(vector, (long) 10, (long) 6);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector2l vector = new Vector2l(2, 5).div(2d);
        TestUtill.assertEquals(vector, (long) 1, (long) 2);
    }

    @Test
    public void testLongFactorDivision() {
        Vector2l vector = new Vector2l(2, 6).div((long) 2);
        TestUtill.assertEquals(vector, (long) 1, (long) 3);
    }

    @Test
    public void testVector2Division() {
        Vector2l vector = new Vector2l(2, 7).div(new Vector2l(2, 3));
        TestUtill.assertEquals(vector, (long) 1, (long) 2);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector2l vector = new Vector2l(2, 6).div(2d, 2.5);
        TestUtill.assertEquals(vector, (long) 1, (long) 3);
    }

    @Test
    public void testLongComponentsDivision() {
        Vector2l vector = new Vector2l(2, 7).div((long) 2, (long) 3);
        TestUtill.assertEquals(vector, (long) 1, (long) 2);
    }

    @Test
    public void testVector2DotProduct() {
        long f = new Vector2l(2, 3).dot(new Vector2l(4, 5));
        TestUtill.assertEquals(f, (long) 23);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        long f = new Vector2l(2, 3).dot(4d, 5d);
        TestUtill.assertEquals(f, (long) 23);
    }

    @Test
    public void testLongComponentsDotProduct() {
        long f = new Vector2l(2, 3).dot(4, 5);
        TestUtill.assertEquals(f, (long) 23);
    }

    @Test
    public void testRaiseToLongPower() {
        Vector2l vector = new Vector2l(2, 6).pow((long) 2);
        TestUtill.assertEquals(vector, (long) 4, (long) 36);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector2l vector = new Vector2l(2, 6).pow(2d);
        TestUtill.assertEquals(vector, (long) 4, (long) 36);
    }

    @Test
    public void testAbsolute() {
        Vector2l vector1 = new Vector2l(-2, -6).abs();
        TestUtill.assertEquals(vector1, (long) 2, (long) 6);
        Vector2l vector2 = new Vector2l(2, 6).abs();
        TestUtill.assertEquals(vector2, (long) 2, (long) 6);
    }

    @Test
    public void testNegate() {
        Vector2l vector = new Vector2l(2, -6).negate();
        TestUtill.assertEquals(vector, (long) -2, (long) 6);
    }

    @Test
    public void testVector2Minimum() {
        Vector2l vector = new Vector2l(2, 6).min(new Vector2l(3, 4));
        TestUtill.assertEquals(vector, (long) 2, (long) 4);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector2l vector = new Vector2l(2, 6).min(3d, 4d);
        TestUtill.assertEquals(vector, (long) 2, (long) 4);
    }

    @Test
    public void testLongComponentsMinimum() {
        Vector2l vector = new Vector2l(2, 6).min((long) 3, (long) 4);
        TestUtill.assertEquals(vector, (long) 2, (long) 4);
    }

    @Test
    public void testVector2Maximum() {
        Vector2l vector = new Vector2l(2, 6).max(new Vector2l(3, 4));
        TestUtill.assertEquals(vector, (long) 3, (long) 6);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector2l vector = new Vector2l(2, 6).max(3d, 4d);
        TestUtill.assertEquals(vector, (long) 3, (long) 6);
    }

    @Test
    public void testLongComponentsMaximum() {
        Vector2l vector = new Vector2l(2, 6).max((long) 3, (long) 4);
        TestUtill.assertEquals(vector, (long) 3, (long) 6);
    }

    @Test
    public void testVector2DistanceSquared() {
        long f = new Vector2l(2, 3).distanceSquared(new Vector2l(4, 5));
        TestUtill.assertEquals(f, (long) 8);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        long f = new Vector2l(2, 3).distanceSquared(4d, 5d);
        TestUtill.assertEquals(f, (long) 8);
    }

    @Test
    public void testLongComponentsDistanceSquared() {
        long f = new Vector2l(2, 3).distanceSquared((long) 4, (long) 5);
        TestUtill.assertEquals(f, (long) 8);
    }

    @Test
    public void testVector2Distance() {
        double f = new Vector2l(4, 6).distance(new Vector2l(7, 2));
        TestUtild.assertEquals(f, (long) 5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        double f = new Vector2l(4, 6).distance(7d, 2d);
        TestUtild.assertEquals(f, (long) 5);
    }

    @Test
    public void testLongComponentsDistance() {
        double f = new Vector2l(4, 6).distance((long) 7, (long) 2);
        TestUtild.assertEquals(f, (long) 5);
    }

    @Test
    public void testLength() {
        double f = new Vector2l(3, 4).length();
        TestUtild.assertEquals(f, (long) 5);
    }

    @Test
    public void testLengthSquared() {
        long f = new Vector2l(3, 4).lengthSquared();
        TestUtill.assertEquals(f, (long) 25);
    }

    @Test
    public void testGetMinAxis() {
        Vector2l vector1 = new Vector2l(1, 2);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        Vector2l vector2 = new Vector2l(2, 1);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
    }

    @Test
    public void testGetMaxAxis() {
        Vector2l vector1 = new Vector2l(2, 1);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        Vector2l vector2 = new Vector2l(1, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
    }

    @Test
    public void testConvertToVector3DefaultZ() {
        Vector3l vector = new Vector2l(1, 2).toVector3();
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 0);
    }

    @Test
    public void testConvertToVector3LongZ() {
        Vector3l vector = new Vector2l(1, 2).toVector3((long) 3);
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3);
    }

    @Test
    public void testConvertToVector3DoubleZ() {
        Vector3l vector = new Vector2l(1, 2).toVector3(3d);
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3);
    }

    @Test
    public void testConvertToVector4DefaultZW() {
        Vector4l vector = new Vector2l(1, 2).toVector4();
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 0, (long) 0);
    }

    @Test
    public void testConvertToVector4LongZW() {
        Vector4l vector = new Vector2l(1, 2).toVector4((long) 3, (long) 4);
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testConvertToVector4DoubleZW() {
        Vector4l vector = new Vector2l(1, 2).toVector4(3d, 4d);
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNl vector = new Vector2l(1, 2).toVectorN();
        TestUtill.assertEquals(vector, (long) 1, (long) 2);
    }

    @Test
    public void testConvertToArray() {
        long[] array = new Vector2l(1, 2).toArray();
        TestUtill.assertEquals(array, (long) 1, (long) 2);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector2l(10, 20).compareTo(new Vector2l(20, 20));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector2l(10, 20).compareTo(new Vector2l(10, 20));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector2l(10, 20).compareTo(new Vector2l(10, 10));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector2l(122, 43).equals(new Vector2l(122, 43)));
        Assert.assertFalse(new Vector2l(122, 43).equals(new Vector2l(378, 95)));
    }

    @Test
    public void testCloning() {
        Vector2l vector = new Vector2l(3, 2);
        Assert.assertEquals(vector, vector.clone());
    }
}
