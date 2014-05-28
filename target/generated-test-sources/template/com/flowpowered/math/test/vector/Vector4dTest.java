package com.flowpowered.math.test.vector;

import static com.flowpowered.math.test.TestUtild.SQRT5;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector4d;
import com.flowpowered.math.vector.VectorNd;

public class Vector4dTest {
    @Test
    public void testEmptyConstructor() {
        Vector4d vector = new Vector4d();
        TestUtild.assertEquals(vector, 0, 0, 0, 0);
    }

    @Test
    public void testCopyVector2DefaultZWConstructor() {
        Vector4d vector = new Vector4d(new Vector2d(0, 1));
        TestUtild.assertEquals(vector, 0, 1, 0, 0);
    }

    @Test
    public void testCopyVector2DoubleZWConstructor() {
        Vector4d vector = new Vector4d(new Vector2d(0, 1), 1d, 2d);
        TestUtild.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector2FloatZWConstructor() {
        Vector4d vector = new Vector4d(new Vector2d(0, 1), 1, 2);
        TestUtild.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector3DefaultWConstructor() {
        Vector4d vector = new Vector4d(new Vector3d(0, 1, 1));
        TestUtild.assertEquals(vector, 0, 1, 1, 0);
    }

    @Test
    public void testCopyVector3DoubleWConstructor() {
        Vector4d vector = new Vector4d(new Vector3d(0, 1, 1), 2d);
        TestUtild.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector3FloatWConstructor() {
        Vector4d vector = new Vector4d(new Vector3d(0, 1, 1), 2);
        TestUtild.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector4d vector = new Vector4d(new Vector4d(0, 1, 1, 2));
        TestUtild.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector4d vector = new Vector4d(new VectorNd(0, 1, 1, 2, 5));
        TestUtild.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector4d vector = new Vector4d(0.5, 1.7, 3.8, 5.5);
        TestUtild.assertEquals(vector, (double) 0.5, (double) 1.7, (double) 3.8, (double) 5.5);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Vector4d vector = new Vector4d(0.5f, 1.7f, 3.8f, 5.5f);
        TestUtild.assertEquals(vector, 0.5f, 1.7f, 3.8f, 5.5f);
    }

    @Test
    public void testGetters() {
        Vector4d vector = new Vector4d(0.5, 1.7, 3.8, 5.5);
        TestUtild.assertEquals(vector.getX(), (double) 0.5);
        TestUtild.assertEquals(vector.getY(), (double) 1.7);
        TestUtild.assertEquals(vector.getZ(), (double) 3.8);
        TestUtild.assertEquals(vector.getW(), (double) 5.5);
    }

    @Test
    public void testFloorGetters() {
        Vector4d vector = new Vector4d(0.5, 1.7, 3.8, 5.5);
        TestUtild.assertEquals(vector.getFloorX(), 0);
        TestUtild.assertEquals(vector.getFloorY(), 1);
        TestUtild.assertEquals(vector.getFloorZ(), 3);
        TestUtild.assertEquals(vector.getFloorW(), 5);
    }

    @Test
    public void testVector4Addition() {
        Vector4d vector = new Vector4d(0, 1, 1, 1).add(new Vector4d(5.5, -0.5, 3.8, 5.5));
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5, (double) 4.8, (double) 6.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector4d vector = new Vector4d(0, 1, 1, 1).add(5.5, -0.5, 3.8, 5.5);
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5, (double) 4.8, (double) 6.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Vector4d vector = new Vector4d(0, 1, 1, 1).add(5.5f, -0.5f, 3.8f, 5.5f);
        TestUtild.assertEquals(vector, 5.5f, 0.5f, (double) 4.8, 6.5f);
    }

    @Test
    public void testVector4Subtraction() {
        Vector4d vector = new Vector4d(10, 5, 1, 1).sub(new Vector4d(9, 4.5, 2, 1));
        TestUtild.assertEquals(vector, 1, (double) 0.5, -1, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector4d vector = new Vector4d(10, 5, 1, 1).sub(9, 4.5, 2, 1);
        TestUtild.assertEquals(vector, 1, (double) 0.5, -1, 0);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Vector4d vector = new Vector4d(10, 5, 1, 1).sub(9, 4.5f, 2f, 1f);
        TestUtild.assertEquals(vector, 1, 0.5f, -1, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).mul(1.5);
        TestUtild.assertEquals(vector, 3, (double) 4.5, 6, (double) 7.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).mul(1.5f);
        TestUtild.assertEquals(vector, 3, 4.5f, 6, 7.5f);
    }

    @Test
    public void testVector4Multiplication() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).mul(new Vector4d(1.5, 2.5, 3.5, 4.5));
        TestUtild.assertEquals(vector, 3, (double) 7.5, 14, (double) 22.5);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).mul(1.5, 2.5, 3.5, 4.5);
        TestUtild.assertEquals(vector, 3, (double) 7.5, 14, (double) 22.5);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).mul(1.5f, 2.5f, 3.5f, 4.5f);
        TestUtild.assertEquals(vector, 3, 7.5f, 14, 22.5f);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).div(2d);
        TestUtild.assertEquals(vector, 1, (double) 1.5, 2, (double) 2.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Vector4d vector = new Vector4d(2, 3, 4, 5).div(2);
        TestUtild.assertEquals(vector, 1, 1.5f, 2, 2.5f);
    }

    @Test
    public void testVector4Division() {
        Vector4d vector = new Vector4d(2, 6, 12, 16).div(new Vector4d(2, 4, 8, 8));
        TestUtild.assertEquals(vector, 1, (double) 1.5, (double) 1.5, 2f);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector4d vector = new Vector4d(2, 6, 16, 18).div(2d, 4d, 8d, 9d);
        TestUtild.assertEquals(vector, 1, (double) 1.5, 2, 2);
    }

    @Test
    public void testFloatComponentsDivision() {
        Vector4d vector = new Vector4d(2, 6, 16, 18).div(2, 4, 8, 9);
        TestUtild.assertEquals(vector, 1, 1.5f, 2, 2);
    }

    @Test
    public void testVector4DotProduct() {
        double f = new Vector4d(2, 3, 4, 5).dot(new Vector4d(6, 7, 8, 9));
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        double f = new Vector4d(2, 3, 4, 5).dot(6d, 7d, 8d, 9d);
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        double f = new Vector4d(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testRaiseToFloatPower() {
        Vector4d vector = new Vector4d(2, 6, 8, 5.5).pow(2);
        TestUtild.assertEquals(vector, 4, 36, 64, 30.25f);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector4d vector = new Vector4d(2, 6, 8, 5.5).pow(2d);
        TestUtild.assertEquals(vector, 4, 36, 64, (double) 30.25);
    }

    @Test
    public void testCeiling() {
        Vector4d vector = new Vector4d(2.5, 6.7, 7.9, 8.1).ceil();
        TestUtild.assertEquals(vector, 3, 7, 8, 9);
    }

    @Test
    public void testFloor() {
        Vector4d vector = new Vector4d(2.5, 6.7, 7.8, 9.1).floor();
        TestUtild.assertEquals(vector, 2, 6, 7, 9);
    }

    @Test
    public void testRound() {
        Vector4d vector = new Vector4d(2.2, 6.7, 7.8, 9.1).round();
        TestUtild.assertEquals(vector, 2, 7, 8, 9);
    }

    @Test
    public void testAbsolute() {
        Vector4d vector1 = new Vector4d(-2.5, -6.7, -55, 0).abs();
        TestUtild.assertEquals(vector1, (double) 2.5, (double) 6.7, 55, 0);
        Vector4d vector2 = new Vector4d(2.5, 6.7, 55, 0).abs();
        TestUtild.assertEquals(vector2, (double) 2.5, (double) 6.7, 55, 0);
    }

    @Test
    public void testNegate() {
        Vector4d vector = new Vector4d(2.2, -6.7, 15.8, 20).negate();
        TestUtild.assertEquals(vector, (double) -2.2, (double) 6.7, (double) -15.8, -20);
    }

    @Test
    public void testVector4Minimum() {
        Vector4d vector = new Vector4d(2, 6, -1, 0).min(new Vector4d(3, 4, 10, -1));
        TestUtild.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector4d vector = new Vector4d(2, 6, -1, 0).min(3, 4, 10, -1.1);
        TestUtild.assertEquals(vector, 2, 4, -1, (double) -1.1);
    }

    @Test
    public void testFloatComponentsMinimum() {
        Vector4d vector = new Vector4d(2, 6, -1, 0).min(3, 4, 10, -1.1f);
        TestUtild.assertEquals(vector, 2, 4, -1, -1.1f);
    }

    @Test
    public void testVector4Maximum() {
        Vector4d vector = new Vector4d(2, 6, -1, 0).max(new Vector4d(3, 4, 10, -1));
        TestUtild.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector4d vector = new Vector4d(2, 6, -1, 0).max(3, 4, 10, -1.1);
        TestUtild.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testFloatComponentsMaximum() {
        Vector4d vector = new Vector4d(2, 6, -1, 0).max(3, 4, 10, -1.1f);
        TestUtild.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testVector4DistanceSquared() {
        double f = new Vector3d(2, 3, 4).distanceSquared(new Vector3d(5, 6, 7));
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        double f = new Vector4d(2, 3, 4, 1).distanceSquared(5d, 6d, 7d, 1d);
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        double f = new Vector4d(2, 3, 4, 5).distanceSquared(5, 6, 7, 5);
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testVector4Distance() {
        double f = new Vector4d(0, 2, 4, 8).distance(new Vector4d(0, 8, 16, 8));
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        double f = new Vector4d(0, 2, 4, 8).distance(new Vector4d(0d, 8d, 16d, 8d));
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testFloatComponentsDistance() {
        double f = new Vector4d(0, 2, 4, 8).distance(new Vector4d(0, 8, 16, 8));
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testLength() {
        double f = new Vector4d(3, 4, 5, 6).length();
        TestUtild.assertEquals(f, (double) Math.sqrt(86));
    }

    @Test
    public void testLengthSquared() {
        double f = new Vector4d(3, 4, 5, 6).lengthSquared();
        TestUtild.assertEquals(f, 86);
    }

    @Test
    public void testNormalize() {
        Vector4d v1 = new Vector4d(1, 1, 0, 0).normalize();
        TestUtild.assertEquals(v1, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0);
        Vector4d v2 = new Vector4d(0, 1, 0, 1).normalize();
        TestUtild.assertEquals(v2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testGetMinAxis() {
        Vector4d vector1 = new Vector4d(1, 2, 3, 4);
        TestUtild.assertEquals(vector1.getMinAxis(), 0);
        Vector4d vector2 = new Vector4d(2, 1, 3, 4);
        TestUtild.assertEquals(vector2.getMinAxis(), 1);
        Vector4d vector3 = new Vector4d(3, 2, 1, 4);
        TestUtild.assertEquals(vector3.getMinAxis(), 2);
        Vector4d vector4 = new Vector4d(4, 2, 3, 1);
        TestUtild.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        Vector4d vector1 = new Vector4d(4, 2, 3, 1);
        TestUtild.assertEquals(vector1.getMaxAxis(), 0);
        Vector4d vector2 = new Vector4d(1, 4, 3, 2);
        TestUtild.assertEquals(vector2.getMaxAxis(), 1);
        Vector4d vector3 = new Vector4d(1, 2, 4, 3);
        TestUtild.assertEquals(vector3.getMaxAxis(), 2);
        Vector4d vector4 = new Vector4d(1, 2, 3, 4);
        TestUtild.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        Vector2d vector = new Vector4d(1, 2, 3, 4).toVector2();
        TestUtild.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        Vector3d vector = new Vector4d(1, 2, 3, 4).toVector3();
        TestUtild.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNd vector = new Vector4d(1, 2, 3, 4).toVectorN();
        TestUtild.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArray() {
        double[] array = new Vector4d(1, 2, 3, 4).toArray();
        TestUtild.assertEquals(array, 1, 2, 3, 4);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector4d(10, 20, 30, 40).compareTo(new Vector4d(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector4d(10, 20, 30, 40).compareTo(new Vector4d(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector4d(10, 20, 30, 40).compareTo(new Vector4d(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector4d(122, 43, 96, 50).equals(new Vector4d(122, 43, 96, 50)));
        Assert.assertFalse(new Vector4d(122, 43, 96, 50).equals(new Vector4d(378, 95, 96, 0)));
    }

    @Test
    public void testCloning() {
        Vector4d vector = new Vector4d(3, 2, 5, 6);
        Assert.assertEquals(vector, vector.clone());
    }
}
