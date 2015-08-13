package com.flowpowered.math.test.vector;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtill;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.vector.Vector2l;
import com.flowpowered.math.vector.Vector3l;
import com.flowpowered.math.vector.Vector4l;
import com.flowpowered.math.vector.VectorNl;

public class Vector4lTest {
    @Test
    public void testEmptyConstructor() {
        Vector4l vector = new Vector4l();
        TestUtill.assertEquals(vector, 0, 0, 0, 0);
    }

    @Test
    public void testCopyVector2DefaultZWConstructor() {
        Vector4l vector = new Vector4l(new Vector2l(0, 1));
        TestUtill.assertEquals(vector, 0, 1, 0, 0);
    }

    @Test
    public void testCopyVector2LongZWConstructor() {
        Vector4l vector = new Vector4l(new Vector2l(0, 1), (long) 1, (long) 2);
        TestUtill.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector3DefaultWConstructor() {
        Vector4l vector = new Vector4l(new Vector3l(0, 1, 1));
        TestUtill.assertEquals(vector, 0, 1, 1, 0);
    }

    @Test
    public void testCopyVector3LongWConstructor() {
        Vector4l vector = new Vector4l(new Vector3l(0, 1, 1), (long) 2);
        TestUtill.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector4l vector = new Vector4l(new Vector4l(0, 1, 1, 2));
        TestUtill.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector4l vector = new Vector4l(new VectorNl(0, 1, 1, 2, 5));
        TestUtill.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector4l vector = new Vector4l(0.5, 1.7, 3.8, 5.5);
        TestUtill.assertEquals(vector, 0, 1, 3, 5);
    }

    @Test
    public void testLongComponentsConstructor() {
        Vector4l vector = new Vector4l((long) 0, (long) 1, (long) 3, (long) 5);
        TestUtill.assertEquals(vector, 0, 1, 3, 5);
    }

    @Test
    public void testGetters() {
        Vector4l vector = new Vector4l(0, 1, 3, 5);
        TestUtill.assertEquals(vector.getX(), 0);
        TestUtill.assertEquals(vector.getY(), 1);
        TestUtill.assertEquals(vector.getZ(), 3);
        TestUtill.assertEquals(vector.getW(), 5);
    }

    @Test
    public void testVector4Addition() {
        Vector4l vector = new Vector4l(0, 1, 1, 1).add(new Vector4l(5, -2, 3, 5));
        TestUtill.assertEquals(vector, 5, -1, 4, 6);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector4l vector = new Vector4l(0, 1, 1, 1).add(5.5, -2.5, 3.8, 5.5);
        TestUtill.assertEquals(vector, 5, -2, 4, 6);
    }

    @Test
    public void testLongComponentsAddition() {
        Vector4l vector = new Vector4l(0, 1, 1, 1).add((long) 5, (long) -2, (long) 3, (long) 5);
        TestUtill.assertEquals(vector, 5, -1, 4, 6);
    }

    @Test
    public void testVector4Subtraction() {
        Vector4l vector = new Vector4l(10, 5, 1, 1).sub(new Vector4l(9, 4, 2, 1));
        TestUtill.assertEquals(vector, 1, 1, -1, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector4l vector = new Vector4l(10, 5, 1, 1).sub(9, 4.5, 2, 1);
        TestUtill.assertEquals(vector, 1, 1, -1, 0);
    }

    @Test
    public void testLongComponentsSubtraction() {
        Vector4l vector = new Vector4l(10, 5, 1, 1).sub((long) 9, (long) 4, (long) 2, (long) 1);
        TestUtill.assertEquals(vector, 1, 1, -1, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector4l vector = new Vector4l(2, 3, 4, 5).mul(2.5);
        TestUtill.assertEquals(vector, 4, 6, 8, 10);
    }

    @Test
    public void testLongFactorMultiplication() {
        Vector4l vector = new Vector4l(2, 3, 4, 5).mul((long) 2);
        TestUtill.assertEquals(vector, 4, 6, 8, 10);
    }

    @Test
    public void testVector4Multiplication() {
        Vector4l vector = new Vector4l(2, 3, 4, 5).mul(new Vector4l(1, 2, 3, 4));
        TestUtill.assertEquals(vector, 2, 6, 12, 20);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector4l vector = new Vector4l(2, 3, 4, 5).mul(1.1, 2.5, 3.2, 4.3);
        TestUtill.assertEquals(vector, 2, 6, 12, 20);
    }

    @Test
    public void testLongComponentsMultiplication() {
        Vector4l vector = new Vector4l(2, 3, 4, 5).mul((long) 1, (long) 2, (long) 3, (long) 4);
        TestUtill.assertEquals(vector, 2, 6, 12, 20);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector4l vector = new Vector4l(2, 3, 5, 7).div(2.1);
        TestUtill.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testLongFactorDivision() {
        Vector4l vector = new Vector4l(2, 3, 5, 7).div((long) 2);
        TestUtill.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testVector4Division() {
        Vector4l vector = new Vector4l(2, 6, 16, 28).div(new Vector4l(2, 4, 8, 9));
        TestUtill.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector4l vector = new Vector4l(2, 6, 16, 28).div(2.5, 4.1, 8.3, 9.2);
        TestUtill.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testLongComponentsDivision() {
        Vector4l vector = new Vector4l(2, 6, 16, 28).div((long) 2, (long) 4, (long) 8, (long) 9);
        TestUtill.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testVector4DotProduct() {
        long f = new Vector4l(2, 3, 4, 5).dot(new Vector4l(6, 7, 8, 9));
        TestUtill.assertEquals(f, 110);
    }

    @Test
    public void testVector4Project() {
        Vector4l vector = new Vector4l(20, 30, 40, 50).project(new Vector4l(10, 10, 10, 10));
        TestUtill.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector4l vector = new Vector4l(20, 30, 40, 50).project(10d, 10d, 10d, 10d);
        TestUtill.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector4l vector = new Vector4l(20, 30, 40, 50).project(10, 10, 10, 10);
        TestUtill.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        long f = new Vector4l(2, 3, 4, 5).dot(6.1, 7.5, 8.3, 9.2);
        TestUtill.assertEquals(f, 110);
    }

    @Test
    public void testLongComponentsDotProduct() {
        long f = new Vector4l(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtill.assertEquals(f, 110);
    }

    @Test
    public void testRaiseToLongPower() {
        Vector4l vector = new Vector4l(2, 6, 8, 5).pow((long) 2);
        TestUtill.assertEquals(vector, 4, 36, 64, 25);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector4l vector = new Vector4l(2, 6, 8, 5).pow(2d);
        TestUtill.assertEquals(vector, 4, 36, 64, 25);
    }

    @Test
    public void testAbsolute() {
        Vector4l vector1 = new Vector4l(-2, -6, -55, 0).abs();
        TestUtill.assertEquals(vector1, 2, 6, 55, 0);
        Vector4l vector2 = new Vector4l(2, 6, 55, 0).abs();
        TestUtill.assertEquals(vector2, 2, 6, 55, 0);
    }

    @Test
    public void testNegate() {
        Vector4l vector = new Vector4l(2, -6, 15, 20).negate();
        TestUtill.assertEquals(vector, -2, 6, -15, -20);
    }

    @Test
    public void testVector4Minimum() {
        Vector4l vector = new Vector4l(2, 6, -1, 0).min(new Vector4l(3, 4, 10, -1));
        TestUtill.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector4l vector = new Vector4l(2, 6, -1, 0).min(3, 4, 10, -1.1);
        TestUtill.assertEquals(vector, 2, 4, -1, -2);
    }

    @Test
    public void testLongComponentsMinimum() {
        Vector4l vector = new Vector4l(2, 6, -1, 0).min((long) 3, (long) 4, (long) 10, (long) -1);
        TestUtill.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testVector4Maximum() {
        Vector4l vector = new Vector4l(2, 6, -1, 0).max(new Vector4l(3, 4, 10, -1));
        TestUtill.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector4l vector = new Vector4l(2, 6, -1, 0).max(3, 4, 10, -1.1);
        TestUtill.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testLongComponentsMaximum() {
        Vector4l vector = new Vector4l(2, 6, -1, 0).max((long) 3, (long) 4, (long) 10, (long) -1);
        TestUtill.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testVector4DistanceSquared() {
        long f = new Vector4l(2, 3, 4, 5).distanceSquared(new Vector4l(5, 6, 7, 8));
        TestUtill.assertEquals(f, 36);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        long f = new Vector4l(2, 3, 4, 1).distanceSquared(5.1, 6.5, 7.3, 1.2);
        TestUtill.assertEquals(f, 27);
    }

    @Test
    public void testLongComponentsDistanceSquared() {
        long f = new Vector4l(2, 3, 4, 5).distanceSquared((long) 5, (long) 6, (long) 7, (long) 5);
        TestUtill.assertEquals(f, 27);
    }

    @Test
    public void testVector4Distance() {
        double f = new Vector4l(0, 6, 13, 8).distance(new Vector4l(2, 8, 16, 16));
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testDoubleComponentsDistance() {
        double f = new Vector4l(0, 6, 13, 8).distance(new Vector4l(2d, 8.3, 16.5, 16.1));
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testLongComponentsDistance() {
        double f = new Vector4l(0, 6, 13, 8).distance(new Vector4l((long) 2, (long) 8, (long) 16, (long) 16));
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testLength() {
        double f = new Vector4l(2, 2, 3, 8).length();
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testLengthSquared() {
        long f = new Vector4l(3, 4, 5, 6).lengthSquared();
        TestUtill.assertEquals(f, 86);
    }

    @Test
    public void testGetMinAxis() {
        Vector4l vector1 = new Vector4l(1, 2, 3, 4);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        Vector4l vector2 = new Vector4l(2, 1, 3, 4);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
        Vector4l vector3 = new Vector4l(3, 2, 1, 4);
        TestUtili.assertEquals(vector3.getMinAxis(), 2);
        Vector4l vector4 = new Vector4l(4, 2, 3, 1);
        TestUtili.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        Vector4l vector1 = new Vector4l(4, 2, 3, 1);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        Vector4l vector2 = new Vector4l(1, 4, 3, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
        Vector4l vector3 = new Vector4l(1, 2, 4, 3);
        TestUtili.assertEquals(vector3.getMaxAxis(), 2);
        Vector4l vector4 = new Vector4l(1, 2, 3, 4);
        TestUtili.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        Vector2l vector = new Vector4l(1, 2, 3, 4).toVector2();
        TestUtill.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        Vector3l vector = new Vector4l(1, 2, 3, 4).toVector3();
        TestUtill.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNl vector = new Vector4l(1, 2, 3, 4).toVectorN();
        TestUtill.assertEquals(vector, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testConvertToArray() {
        long[] array = new Vector4l(1, 2, 3, 4).toArray();
        TestUtill.assertEquals(array, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector4l(10, 20, 30, 40).compareTo(new Vector4l(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector4l(10, 20, 30, 40).compareTo(new Vector4l(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector4l(10, 20, 30, 40).compareTo(new Vector4l(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector4l(122, 43, 96, 50).equals(new Vector4l(122, 43, 96, 50)));
        Assert.assertFalse(new Vector4l(122, 43, 96, 50).equals(new Vector4l(378, 95, 96, 0)));
    }

    @Test
    public void testCloning() {
        Vector4l vector = new Vector4l(3, 2, 5, 6);
        Assert.assertEquals(vector, vector.clone());
    }
}
