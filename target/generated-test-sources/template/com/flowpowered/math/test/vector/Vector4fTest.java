package com.flowpowered.math.test.vector;

import static com.flowpowered.math.test.TestUtilf.SQRT5;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;
import com.flowpowered.math.vector.VectorNf;

public class Vector4fTest {
    @Test
    public void testEmptyConstructor() {
        Vector4f vector = new Vector4f();
        TestUtilf.assertEquals(vector, 0, 0, 0, 0);
    }

    @Test
    public void testCopyVector2DefaultZWConstructor() {
        Vector4f vector = new Vector4f(new Vector2f(0, 1));
        TestUtilf.assertEquals(vector, 0, 1, 0, 0);
    }

    @Test
    public void testCopyVector2DoubleZWConstructor() {
        Vector4f vector = new Vector4f(new Vector2f(0, 1), 1d, 2d);
        TestUtilf.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector2FloatZWConstructor() {
        Vector4f vector = new Vector4f(new Vector2f(0, 1), 1, 2);
        TestUtilf.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector3DefaultWConstructor() {
        Vector4f vector = new Vector4f(new Vector3f(0, 1, 1));
        TestUtilf.assertEquals(vector, 0, 1, 1, 0);
    }

    @Test
    public void testCopyVector3DoubleWConstructor() {
        Vector4f vector = new Vector4f(new Vector3f(0, 1, 1), 2d);
        TestUtilf.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector3FloatWConstructor() {
        Vector4f vector = new Vector4f(new Vector3f(0, 1, 1), 2);
        TestUtilf.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector4f vector = new Vector4f(new Vector4f(0, 1, 1, 2));
        TestUtilf.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector4f vector = new Vector4f(new VectorNf(0, 1, 1, 2, 5));
        TestUtilf.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector4f vector = new Vector4f(0.5, 1.7, 3.8, 5.5);
        TestUtilf.assertEquals(vector, (float) 0.5, (float) 1.7, (float) 3.8, (float) 5.5);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Vector4f vector = new Vector4f(0.5f, 1.7f, 3.8f, 5.5f);
        TestUtilf.assertEquals(vector, 0.5f, 1.7f, 3.8f, 5.5f);
    }

    @Test
    public void testGetters() {
        Vector4f vector = new Vector4f(0.5, 1.7, 3.8, 5.5);
        TestUtilf.assertEquals(vector.getX(), (float) 0.5);
        TestUtilf.assertEquals(vector.getY(), (float) 1.7);
        TestUtilf.assertEquals(vector.getZ(), (float) 3.8);
        TestUtilf.assertEquals(vector.getW(), (float) 5.5);
    }

    @Test
    public void testFloorGetters() {
        Vector4f vector = new Vector4f(0.5, 1.7, 3.8, 5.5);
        TestUtilf.assertEquals(vector.getFloorX(), 0);
        TestUtilf.assertEquals(vector.getFloorY(), 1);
        TestUtilf.assertEquals(vector.getFloorZ(), 3);
        TestUtilf.assertEquals(vector.getFloorW(), 5);
    }

    @Test
    public void testVector4Addition() {
        Vector4f vector = new Vector4f(0, 1, 1, 1).add(new Vector4f(5.5, -0.5, 3.8, 5.5));
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5, (float) 4.8, (float) 6.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector4f vector = new Vector4f(0, 1, 1, 1).add(5.5, -0.5, 3.8, 5.5);
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5, (float) 4.8, (float) 6.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Vector4f vector = new Vector4f(0, 1, 1, 1).add(5.5f, -0.5f, 3.8f, 5.5f);
        TestUtilf.assertEquals(vector, 5.5f, 0.5f, (float) 4.8, 6.5f);
    }

    @Test
    public void testVector4Subtraction() {
        Vector4f vector = new Vector4f(10, 5, 1, 1).sub(new Vector4f(9, 4.5, 2, 1));
        TestUtilf.assertEquals(vector, 1, (float) 0.5, -1, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector4f vector = new Vector4f(10, 5, 1, 1).sub(9, 4.5, 2, 1);
        TestUtilf.assertEquals(vector, 1, (float) 0.5, -1, 0);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Vector4f vector = new Vector4f(10, 5, 1, 1).sub(9, 4.5f, 2f, 1f);
        TestUtilf.assertEquals(vector, 1, 0.5f, -1, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).mul(1.5);
        TestUtilf.assertEquals(vector, 3, (float) 4.5, 6, (float) 7.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).mul(1.5f);
        TestUtilf.assertEquals(vector, 3, 4.5f, 6, 7.5f);
    }

    @Test
    public void testVector4Multiplication() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).mul(new Vector4f(1.5, 2.5, 3.5, 4.5));
        TestUtilf.assertEquals(vector, 3, (float) 7.5, 14, (float) 22.5);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).mul(1.5, 2.5, 3.5, 4.5);
        TestUtilf.assertEquals(vector, 3, (float) 7.5, 14, (float) 22.5);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).mul(1.5f, 2.5f, 3.5f, 4.5f);
        TestUtilf.assertEquals(vector, 3, 7.5f, 14, 22.5f);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).div(2d);
        TestUtilf.assertEquals(vector, 1, (float) 1.5, 2, (float) 2.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).div(2);
        TestUtilf.assertEquals(vector, 1, 1.5f, 2, 2.5f);
    }

    @Test
    public void testVector4Division() {
        Vector4f vector = new Vector4f(2, 6, 12, 16).div(new Vector4f(2, 4, 8, 8));
        TestUtilf.assertEquals(vector, 1, (float) 1.5, (float) 1.5, 2f);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector4f vector = new Vector4f(2, 6, 16, 18).div(2d, 4d, 8d, 9d);
        TestUtilf.assertEquals(vector, 1, (float) 1.5, 2, 2);
    }

    @Test
    public void testFloatComponentsDivision() {
        Vector4f vector = new Vector4f(2, 6, 16, 18).div(2, 4, 8, 9);
        TestUtilf.assertEquals(vector, 1, 1.5f, 2, 2);
    }

    @Test
    public void testVector4DotProduct() {
        float f = new Vector4f(2, 3, 4, 5).dot(new Vector4f(6, 7, 8, 9));
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        float f = new Vector4f(2, 3, 4, 5).dot(6d, 7d, 8d, 9d);
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        float f = new Vector4f(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testVector4Project() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).project(new Vector4f(1, 1, 1, 1));
        TestUtilf.assertEquals(vector, (float) 3.5, (float) 3.5, (float) 3.5, (float) 3.5);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).project(1d, 1d, 1d, 1d);
        TestUtilf.assertEquals(vector, (float) 3.5, (float) 3.5, (float) 3.5, (float) 3.5);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector4f vector = new Vector4f(2, 3, 4, 5).project(1, 1, 1, 1);
        TestUtilf.assertEquals(vector, (float) 3.5, (float) 3.5, (float) 3.5, (float) 3.5);
    }

    @Test
    public void testRaiseToFloatPower() {
        Vector4f vector = new Vector4f(2, 6, 8, 5.5).pow(2);
        TestUtilf.assertEquals(vector, 4, 36, 64, 30.25f);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector4f vector = new Vector4f(2, 6, 8, 5.5).pow(2d);
        TestUtilf.assertEquals(vector, 4, 36, 64, (float) 30.25);
    }

    @Test
    public void testCeiling() {
        Vector4f vector = new Vector4f(2.5, 6.7, 7.9, 8.1).ceil();
        TestUtilf.assertEquals(vector, 3, 7, 8, 9);
    }

    @Test
    public void testFloor() {
        Vector4f vector = new Vector4f(2.5, 6.7, 7.8, 9.1).floor();
        TestUtilf.assertEquals(vector, 2, 6, 7, 9);
    }

    @Test
    public void testRound() {
        Vector4f vector = new Vector4f(2.2, 6.7, 7.8, 9.1).round();
        TestUtilf.assertEquals(vector, 2, 7, 8, 9);
    }

    @Test
    public void testAbsolute() {
        Vector4f vector1 = new Vector4f(-2.5, -6.7, -55, 0).abs();
        TestUtilf.assertEquals(vector1, (float) 2.5, (float) 6.7, 55, 0);
        Vector4f vector2 = new Vector4f(2.5, 6.7, 55, 0).abs();
        TestUtilf.assertEquals(vector2, (float) 2.5, (float) 6.7, 55, 0);
    }

    @Test
    public void testNegate() {
        Vector4f vector = new Vector4f(2.2, -6.7, 15.8, 20).negate();
        TestUtilf.assertEquals(vector, (float) -2.2, (float) 6.7, (float) -15.8, -20);
    }

    @Test
    public void testVector4Minimum() {
        Vector4f vector = new Vector4f(2, 6, -1, 0).min(new Vector4f(3, 4, 10, -1));
        TestUtilf.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector4f vector = new Vector4f(2, 6, -1, 0).min(3, 4, 10, -1.1);
        TestUtilf.assertEquals(vector, 2, 4, -1, (float) -1.1);
    }

    @Test
    public void testFloatComponentsMinimum() {
        Vector4f vector = new Vector4f(2, 6, -1, 0).min(3, 4, 10, -1.1f);
        TestUtilf.assertEquals(vector, 2, 4, -1, -1.1f);
    }

    @Test
    public void testVector4Maximum() {
        Vector4f vector = new Vector4f(2, 6, -1, 0).max(new Vector4f(3, 4, 10, -1));
        TestUtilf.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector4f vector = new Vector4f(2, 6, -1, 0).max(3, 4, 10, -1.1);
        TestUtilf.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testFloatComponentsMaximum() {
        Vector4f vector = new Vector4f(2, 6, -1, 0).max(3, 4, 10, -1.1f);
        TestUtilf.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testVector4DistanceSquared() {
        float f = new Vector3f(2, 3, 4).distanceSquared(new Vector3f(5, 6, 7));
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        float f = new Vector4f(2, 3, 4, 1).distanceSquared(5d, 6d, 7d, 1d);
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        float f = new Vector4f(2, 3, 4, 5).distanceSquared(5, 6, 7, 5);
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testVector4Distance() {
        float f = new Vector4f(0, 2, 4, 8).distance(new Vector4f(0, 8, 16, 8));
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        float f = new Vector4f(0, 2, 4, 8).distance(new Vector4f(0d, 8d, 16d, 8d));
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testFloatComponentsDistance() {
        float f = new Vector4f(0, 2, 4, 8).distance(new Vector4f(0, 8, 16, 8));
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testLength() {
        float f = new Vector4f(3, 4, 5, 6).length();
        TestUtilf.assertEquals(f, (float) Math.sqrt(86));
    }

    @Test
    public void testLengthSquared() {
        float f = new Vector4f(3, 4, 5, 6).lengthSquared();
        TestUtilf.assertEquals(f, 86);
    }

    @Test
    public void testNormalize() {
        Vector4f v1 = new Vector4f(1, 1, 0, 0).normalize();
        TestUtilf.assertEquals(v1, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0);
        Vector4f v2 = new Vector4f(0, 1, 0, 1).normalize();
        TestUtilf.assertEquals(v2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        try {
            Vector4f.ZERO.normalize();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testGetMinAxis() {
        Vector4f vector1 = new Vector4f(1, 2, 3, 4);
        TestUtilf.assertEquals(vector1.getMinAxis(), 0);
        Vector4f vector2 = new Vector4f(2, 1, 3, 4);
        TestUtilf.assertEquals(vector2.getMinAxis(), 1);
        Vector4f vector3 = new Vector4f(3, 2, 1, 4);
        TestUtilf.assertEquals(vector3.getMinAxis(), 2);
        Vector4f vector4 = new Vector4f(4, 2, 3, 1);
        TestUtilf.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        Vector4f vector1 = new Vector4f(4, 2, 3, 1);
        TestUtilf.assertEquals(vector1.getMaxAxis(), 0);
        Vector4f vector2 = new Vector4f(1, 4, 3, 2);
        TestUtilf.assertEquals(vector2.getMaxAxis(), 1);
        Vector4f vector3 = new Vector4f(1, 2, 4, 3);
        TestUtilf.assertEquals(vector3.getMaxAxis(), 2);
        Vector4f vector4 = new Vector4f(1, 2, 3, 4);
        TestUtilf.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        Vector2f vector = new Vector4f(1, 2, 3, 4).toVector2();
        TestUtilf.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        Vector3f vector = new Vector4f(1, 2, 3, 4).toVector3();
        TestUtilf.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNf vector = new Vector4f(1, 2, 3, 4).toVectorN();
        TestUtilf.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArray() {
        float[] array = new Vector4f(1, 2, 3, 4).toArray();
        TestUtilf.assertEquals(array, 1, 2, 3, 4);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector4f(10, 20, 30, 40).compareTo(new Vector4f(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector4f(10, 20, 30, 40).compareTo(new Vector4f(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector4f(10, 20, 30, 40).compareTo(new Vector4f(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
        int c4 = new Vector4f(0.2, 0.2, 0.2, 0.2).compareTo(new Vector4f(0.1, 0.1, 0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector4f(122, 43, 96, 50).equals(new Vector4f(122, 43, 96, 50)));
        Assert.assertFalse(new Vector4f(122, 43, 96, 50).equals(new Vector4f(378, 95, 96, 0)));
    }

    @Test
    public void testCloning() {
        Vector4f vector = new Vector4f(3, 2, 5, 6);
        Assert.assertEquals(vector, vector.clone());
    }

    @Test
    public void testVectorFromN() {
        Vector4f vector = Vector4f.from(1);
        TestUtilf.assertEquals(vector, 1, 1, 1, 1);
    }

    @Test
    public void testVectorFromXYZW() {
        Vector4f vector = Vector4f.from(1, 2, 3, 4);
        TestUtilf.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testVectorFromMinAB() {
        Vector4f vector = Vector4f.fromMin(Vector4f.from(1, 0, 2, 5),
                                           Vector4f.from(2, 1, 3, 4));
        TestUtilf.assertEquals(vector, 1, 0, 2, 4);
    }

    @Test
    public void testVectorFromMinMany() {
        Vector4f vector = Vector4f.fromMin(Vector4f.from(9, 0, 10, 19),
                                           Vector4f.from(8, 1, 11, 18),
                                           Vector4f.from(7, 2, 12, 17),
                                           Vector4f.from(6, 3, 13, 16),
                                           Vector4f.from(5, 4, 14, 15));
        TestUtilf.assertEquals(vector, 5, 0, 10, 15);
    }

    @Test
    public void testVectorFromMaxAB() {
        Vector4f vector = Vector4f.fromMax(Vector4f.from(1, 0, 2, 5),
                                           Vector4f.from(2, 1, 3, 4));
        TestUtilf.assertEquals(vector, 2, 1, 3, 5);
    }

    @Test
    public void testVectorFromMaxMany() {
        Vector4f vector = Vector4f.fromMax(Vector4f.from(9, 0, 10, 19),
                                           Vector4f.from(8, 1, 11, 18),
                                           Vector4f.from(7, 2, 12, 17),
                                           Vector4f.from(6, 3, 13, 16),
                                           Vector4f.from(5, 4, 14, 15));
        TestUtilf.assertEquals(vector, 9, 4, 14, 19);
    }
}
