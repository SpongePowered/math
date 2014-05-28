package com.flowpowered.math.test.vector;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;
import com.flowpowered.math.vector.VectorNf;

public class Vector2fTest {
    @Test
    public void testEmptyConstructor() {
        Vector2f vector = new Vector2f();
        TestUtilf.assertEquals(vector, 0, 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        Vector2f vector = new Vector2f(new Vector2f(0, 1));
        TestUtilf.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector2f vector = new Vector2f(new Vector3f(0, 1, 2));
        TestUtilf.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector2f vector = new Vector2f(new Vector4f(0, 1, 2, 3));
        TestUtilf.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector2f vector = new Vector2f(new VectorNf(0, 1, 2, 3, 4));
        TestUtilf.assertEquals(vector, 0, 1);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector2f vector = new Vector2f(0.5, 1.7);
        TestUtilf.assertEquals(vector, (float) 0.5, (float) 1.7);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Vector2f vector = new Vector2f(0.5f, 1.7f);
        TestUtilf.assertEquals(vector, 0.5f, 1.7f);
    }

    @Test
    public void testGetters() {
        Vector2f vector = new Vector2f((float) 0.5, (float) 1.7);
        TestUtilf.assertEquals(vector.getX(), (float) 0.5);
        TestUtilf.assertEquals(vector.getY(), (float) 1.7);
    }

    @Test
    public void testFloorGetters() {
        Vector2f vector = new Vector2f(0.5, 1.7);
        TestUtilf.assertEquals(vector.getFloorX(), 0);
        TestUtilf.assertEquals(vector.getFloorY(), 1);
    }

    @Test
    public void testVector2Addition() {
        Vector2f vector = new Vector2f(0, 1).add(new Vector2f(5.5, -0.5));
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector2f vector = new Vector2f(0, 1).add(5.5, -0.5);
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Vector2f vector = new Vector2f(0, 1).add(5.5f, -0.5f);
        TestUtilf.assertEquals(vector, 5.5f, 0.5f);
    }

    @Test
    public void testVector2Subtraction() {
        Vector2f vector = new Vector2f(10, 5).sub(new Vector2f(9, 4.5));
        TestUtilf.assertEquals(vector, 1, (float) 0.5);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector2f vector = new Vector2f(10, 5).sub(9, 4.5);
        TestUtilf.assertEquals(vector, 1, (float) 0.5);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Vector2f vector = new Vector2f(10, 5).sub(9f, 4.5f);
        TestUtilf.assertEquals(vector, 1, 0.5f);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector2f vector = new Vector2f(2, 3).mul(1.5);
        TestUtilf.assertEquals(vector, 3, (float) 4.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Vector2f vector = new Vector2f(2, 3).mul(1.5f);
        TestUtilf.assertEquals(vector, 3, 4.5f);
    }

    @Test
    public void testVector2Multiplication() {
        Vector2f vector = new Vector2f(2, 3).mul(new Vector2f(1.5, 2.5));
        TestUtilf.assertEquals(vector, 3, (float) 7.5);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector2f vector = new Vector2f(2, 3).mul(1.5, 2.5);
        TestUtilf.assertEquals(vector, 3, (float) 7.5);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Vector2f vector = new Vector2f(2, 3).mul(1.5f, 2.5f);
        TestUtilf.assertEquals(vector, 3, 7.5f);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector2f vector = new Vector2f(2, 3).div(2d);
        TestUtilf.assertEquals(vector, 1, (float) 1.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Vector2f vector = new Vector2f(2, 3).div(2);
        TestUtilf.assertEquals(vector, 1, 1.5f);
    }

    @Test
    public void testVector2Division() {
        Vector2f vector = new Vector2f(2, 6).div(new Vector2f(2, 4));
        TestUtilf.assertEquals(vector, 1, (float) 1.5);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector2f vector = new Vector2f(2, 6).div(2d, 4d);
        TestUtilf.assertEquals(vector, 1, (float) 1.5);
    }

    @Test
    public void testFloatComponentsDivision() {
        Vector2f vector = new Vector2f(2, 6).div(2, 4);
        TestUtilf.assertEquals(vector, 1f, 1.5f);
    }

    @Test
    public void testVector2DotProduct() {
        float f = new Vector2f(2, 3).dot(new Vector2f(4, 5));
        TestUtilf.assertEquals(f, 23);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        float f = new Vector2f(2, 3).dot(4d, 5d);
        TestUtilf.assertEquals(f, 23);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        float f = new Vector2f(2, 3).dot(4, 5);
        TestUtilf.assertEquals(f, 23);
    }

    @Test
    public void testRaiseToFloatPower() {
        Vector2f vector = new Vector2f(2, 6).pow(2);
        TestUtilf.assertEquals(vector, 4, 36);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector2f vector = new Vector2f(2, 6).pow(2d);
        TestUtilf.assertEquals(vector, 4, 36);
    }

    @Test
    public void testCeiling() {
        Vector2f vector = new Vector2f(2.5, 6.7).ceil();
        TestUtilf.assertEquals(vector, 3, 7);
    }

    @Test
    public void testFloor() {
        Vector2f vector = new Vector2f(2.5, 6.7).floor();
        TestUtilf.assertEquals(vector, 2, 6);
    }

    @Test
    public void testRound() {
        Vector2f vector = new Vector2f(2.2, 6.7).round();
        TestUtilf.assertEquals(vector, 2, 7);
    }

    @Test
    public void testAbsolute() {
        Vector2f vector1 = new Vector2f(-2.5, -6.7).abs();
        TestUtilf.assertEquals(vector1, (float) 2.5, (float) 6.7);
        Vector2f vector2 = new Vector2f(2.5, 6.7).abs();
        TestUtilf.assertEquals(vector2, (float) 2.5, (float) 6.7);
    }

    @Test
    public void testNegate() {
        Vector2f vector = new Vector2f(2.2, -6.7).negate();
        TestUtilf.assertEquals(vector, -(float) 2.2, (float) 6.7);
    }

    @Test
    public void testVector2Minimum() {
        Vector2f vector = new Vector2f(2, 6).min(new Vector2f(3, 4));
        TestUtilf.assertEquals(vector, 2, 4);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector2f vector = new Vector2f(2, 6).min(3d, 4d);
        TestUtilf.assertEquals(vector, 2, 4);
    }

    @Test
    public void testFloatComponentsMinimum() {
        Vector2f vector = new Vector2f(2, 6).min(3, 4);
        TestUtilf.assertEquals(vector, 2, 4);
    }

    @Test
    public void testVector2Maximum() {
        Vector2f vector = new Vector2f(2, 6).max(new Vector2f(3, 4));
        TestUtilf.assertEquals(vector, 3, 6);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector2f vector = new Vector2f(2, 6).max(3d, 4d);
        TestUtilf.assertEquals(vector, 3, 6);
    }

    @Test
    public void testFloatComponentsMaximum() {
        Vector2f vector = new Vector2f(2, 6).max(3, 4);
        TestUtilf.assertEquals(vector, 3, 6);
    }

    @Test
    public void testVector2DistanceSquared() {
        float f = new Vector2f(2, 3).distanceSquared(new Vector2f(4, 5));
        TestUtilf.assertEquals(f, 8);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        float f = new Vector2f(2, 3).distanceSquared(4d, 5d);
        TestUtilf.assertEquals(f, 8);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        float f = new Vector2f(2, 3).distanceSquared(4, 5);
        TestUtilf.assertEquals(f, 8);
    }

    @Test
    public void testVector2Distance() {
        float f = new Vector2f(4, 6).distance(new Vector2f(7, 2));
        TestUtilf.assertEquals(f, 5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        float f = new Vector2f(4, 6).distance(7d, 2d);
        TestUtilf.assertEquals(f, 5);
    }

    @Test
    public void testFloatComponentsDistance() {
        float f = new Vector2f(4, 6).distance(7, 2);
        TestUtilf.assertEquals(f, 5);
    }

    @Test
    public void testLength() {
        float f = new Vector2f(3, 4).length();
        TestUtilf.assertEquals(f, 5);
    }

    @Test
    public void testLengthSquared() {
        float f = new Vector2f(3, 4).lengthSquared();
        TestUtilf.assertEquals(f, 25);
    }

    @Test
    public void testNormalize() {
        Vector2f vector = new Vector2f(2, 2).normalize();
        TestUtilf.assertEquals(vector, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testGetMinAxis() {
        Vector2f vector1 = new Vector2f(1, 2);
        TestUtilf.assertEquals(vector1.getMinAxis(), 0);
        Vector2f vector2 = new Vector2f(2, 1);
        TestUtilf.assertEquals(vector2.getMinAxis(), 1);
    }

    @Test
    public void testGetMaxAxis() {
        Vector2f vector1 = new Vector2f(2, 1);
        TestUtilf.assertEquals(vector1.getMaxAxis(), 0);
        Vector2f vector2 = new Vector2f(1, 2);
        TestUtilf.assertEquals(vector2.getMaxAxis(), 1);
    }

    @Test
    public void testConvertToVector3DefaultZ() {
        Vector3f vector = new Vector2f(1, 2).toVector3();
        TestUtilf.assertEquals(vector, 1, 2, 0);
    }

    @Test
    public void testConvertToVector3FloatZ() {
        Vector3f vector = new Vector2f(1, 2).toVector3(3);
        TestUtilf.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVector3DoubleZ() {
        Vector3f vector = new Vector2f(1, 2).toVector3(3d);
        TestUtilf.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVector4DefaultZW() {
        Vector4f vector = new Vector2f(1, 2).toVector4();
        TestUtilf.assertEquals(vector, 1, 2, 0, 0);
    }

    @Test
    public void testConvertToVector4FloatZW() {
        Vector4f vector = new Vector2f(1, 2).toVector4(3, 4);
        TestUtilf.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVector4DoubleZW() {
        Vector4f vector = new Vector2f(1, 2).toVector4(3d, 4d);
        TestUtilf.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNf vector = new Vector2f(1, 2).toVectorN();
        TestUtilf.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToArray() {
        float[] array = new Vector2f(1, 2).toArray();
        TestUtilf.assertEquals(array, 1, 2);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector2f(10, 20).compareTo(new Vector2f(20, 20));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector2f(10, 20).compareTo(new Vector2f(10, 20));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector2f(10, 20).compareTo(new Vector2f(10, 10));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector2f(122, 43).equals(new Vector2f(122, 43)));
        Assert.assertFalse(new Vector2f(122, 43).equals(new Vector2f(378, 95)));
    }

    @Test
    public void testCloning() {
        Vector2f vector = new Vector2f(3, 2);
        Assert.assertEquals(vector, vector.clone());
    }

    @Test
    public void testCreateDirectionFromRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Vector2f vector = Vector2f.createRandomDirection(random);
            TestUtilf.assertEquals(vector.length(), 1);
        }
    }

    @Test
    public void testCreateDirectionFromDoubleAngleDegrees() {
        Vector2f vector1 = Vector2f.createDirectionDeg(0d);
        TestUtilf.assertEquals(vector1, 1, 0);
        Vector2f vector2 = Vector2f.createDirectionDeg(45d);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
        Vector2f vector3 = Vector2f.createDirectionDeg(90d);
        TestUtilf.assertEquals(vector3, 0, 1);
        Vector2f vector4 = Vector2f.createDirectionDeg(180d);
        TestUtilf.assertEquals(vector4, -1, 0);
        Vector2f vector5 = Vector2f.createDirectionDeg(270d);
        TestUtilf.assertEquals(vector5, 0, -1);
        Vector2f vector6 = Vector2f.createDirectionDeg(360d);
        TestUtilf.assertEquals(vector6, 1, 0);
    }

    @Test
    public void testCreateDirectionFromFloatAngleDegrees() {
        Vector2f vector1 = Vector2f.createDirectionDeg(0);
        TestUtilf.assertEquals(vector1, 1, 0);
        Vector2f vector2 = Vector2f.createDirectionDeg(45);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
        Vector2f vector3 = Vector2f.createDirectionDeg(90);
        TestUtilf.assertEquals(vector3, 0, 1);
        Vector2f vector4 = Vector2f.createDirectionDeg(180);
        TestUtilf.assertEquals(vector4, -1, 0);
        Vector2f vector5 = Vector2f.createDirectionDeg(270);
        TestUtilf.assertEquals(vector5, 0, -1);
        Vector2f vector6 = Vector2f.createDirectionDeg(360);
        TestUtilf.assertEquals(vector6, 1, 0);
    }

    @Test
    public void testCreateDirectionFromDoubleAngleRadians() {
        Vector2f vector1 = Vector2f.createDirectionRad(0d);
        TestUtilf.assertEquals(vector1, 1, 0);
        Vector2f vector2 = Vector2f.createDirectionRad(TrigMath.QUARTER_PI);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
        Vector2f vector3 = Vector2f.createDirectionRad(TrigMath.HALF_PI);
        TestUtilf.assertEquals(vector3, 0, 1);
        Vector2f vector4 = Vector2f.createDirectionRad(TrigMath.PI);
        TestUtilf.assertEquals(vector4, -1, 0);
        Vector2f vector5 = Vector2f.createDirectionRad(TrigMath.THREE_PI_HALVES);
        TestUtilf.assertEquals(vector5, 0, -1);
        Vector2f vector6 = Vector2f.createDirectionRad(TrigMath.TWO_PI);
        TestUtilf.assertEquals(vector6, 1, 0);
    }

    @Test
    public void testCreateDirectionFromFloatAngleRadians() {
        Vector2f vector1 = Vector2f.createDirectionRad(0);
        TestUtilf.assertEquals(vector1, 1, 0);
        Vector2f vector2 = Vector2f.createDirectionRad((float) TrigMath.QUARTER_PI);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
        Vector2f vector3 = Vector2f.createDirectionRad((float) TrigMath.HALF_PI);
        TestUtilf.assertEquals(vector3, 0, 1);
        Vector2f vector4 = Vector2f.createDirectionRad((float) TrigMath.PI);
        TestUtilf.assertEquals(vector4, -1, 0);
        Vector2f vector5 = Vector2f.createDirectionRad((float) TrigMath.THREE_PI_HALVES);
        TestUtilf.assertEquals(vector5, 0, -1);
        Vector2f vector6 = Vector2f.createDirectionRad((float) TrigMath.TWO_PI);
        TestUtilf.assertEquals(vector6, 1, 0);
    }
}
