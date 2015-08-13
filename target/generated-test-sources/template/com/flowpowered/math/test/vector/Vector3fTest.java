package com.flowpowered.math.test.vector;

import static com.flowpowered.math.test.TestUtilf.SQRT2;
import static com.flowpowered.math.test.TestUtilf.SQRT5;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;
import com.flowpowered.math.vector.VectorNf;

public class Vector3fTest {
    @Test
    public void testEmptyConstructor() {
        Vector3f vector = new Vector3f();
        TestUtilf.assertEquals(vector, 0, 0, 0);
    }

    @Test
    public void testCopyVector2DefaultZConstructor() {
        Vector3f vector = new Vector3f(new Vector2f(0, 1));
        TestUtilf.assertEquals(vector, 0, 1, 0);
    }

    @Test
    public void testCopyVector2DoubleZConstructor() {
        Vector3f vector = new Vector3f(new Vector2f(0, 1), 3d);
        TestUtilf.assertEquals(vector, 0, 1, 3);
    }

    @Test
    public void testCopyVector2FloatZConstructor() {
        Vector3f vector = new Vector3f(new Vector2f(0, 1), 3);
        TestUtilf.assertEquals(vector, 0, 1, 3);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector3f vector = new Vector3f(new Vector3f(0, 1, 2));
        TestUtilf.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector3f vector = new Vector3f(new Vector4f(0, 1, 2, 3));
        TestUtilf.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector3f vector = new Vector3f(new VectorNf(0, 1, 2, 3, 4));
        TestUtilf.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector3f vector = new Vector3f(0.5, 1.7, 3.8);
        TestUtilf.assertEquals(vector, (float) 0.5, (float) 1.7, (float) 3.8);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Vector3f vector = new Vector3f(0.5f, 1.7f, 3.8f);
        TestUtilf.assertEquals(vector, 0.5f, 1.7f, 3.8f);
    }

    @Test
    public void testGetters() {
        Vector3f vector = new Vector3f(0.5, 1.7, 3.8);
        TestUtilf.assertEquals(vector.getX(), (float) 0.5);
        TestUtilf.assertEquals(vector.getY(), (float) 1.7);
        TestUtilf.assertEquals(vector.getZ(), (float) 3.8);
    }

    @Test
    public void testFloorGetters() {
        Vector3f vector = new Vector3f(0.5, 1.7, 3.8);
        TestUtilf.assertEquals(vector.getFloorX(), 0);
        TestUtilf.assertEquals(vector.getFloorY(), 1);
        TestUtilf.assertEquals(vector.getFloorZ(), 3);
    }

    @Test
    public void testVector3Addition() {
        Vector3f vector = new Vector3f(0, 1, 1).add(new Vector3f(5.5, -0.5, 3.8));
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5, (float) 4.8);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector3f vector = new Vector3f(0, 1, 5).add(5.5, -0.5, 3.8);
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5, (float) 8.8);
    }

    @Test
    public void testFloatComponentsAddition() {
        Vector3f vector = new Vector3f(0, 1, 5).add(5.5f, -0.5f, 3.8f);
        TestUtilf.assertEquals(vector, 5.5f, 0.5f, (float) 8.8);
    }

    @Test
    public void testVector3Subtraction() {
        Vector3f vector = new Vector3f(10, 5, 1).sub(new Vector3f(9, 4.5, 2));
        TestUtilf.assertEquals(vector, 1, (float) 0.5, -1);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector3f vector = new Vector3f(10, 5, 1).sub(9, 4.5, 2);
        TestUtilf.assertEquals(vector, 1, (float) 0.5, -1);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Vector3f vector = new Vector3f(10, 5, 1).sub(9, 4.5f, 2);
        TestUtilf.assertEquals(vector, 1f, 0.5f, -1f);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector3f vector = new Vector3f(2, 3, 4).mul(1.5);
        TestUtilf.assertEquals(vector, 3, (float) 4.5, 6);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Vector3f vector = new Vector3f(2, 3, 4).mul(1.5f);
        TestUtilf.assertEquals(vector, 3, 4.5f, 6);
    }

    @Test
    public void testVector3Multiplication() {
        Vector3f vector = new Vector3f(2, 3, 4).mul(new Vector3f(1.5, 2.5, 3.5));
        TestUtilf.assertEquals(vector, 3, (float) 7.5, 14);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector3f vector = new Vector3f(2, 3, 4).mul(1.5, 2.5, 3.5);
        TestUtilf.assertEquals(vector, 3, (float) 7.5, 14);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Vector3f vector = new Vector3f(2, 3, 4).mul(1.5f, 2.5f, 3.5f);
        TestUtilf.assertEquals(vector, 3, (float) 7.5, 14);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector3f vector = new Vector3f(2, 3, 4).div(2d);
        TestUtilf.assertEquals(vector, 1, (float) 1.5, 2);
    }

    @Test
    public void testFloatFactorDivision() {
        Vector3f vector = new Vector3f(2, 3, 4).div(2);
        TestUtilf.assertEquals(vector, 1, 1.5f, 2);
    }

    @Test
    public void testVector3Division() {
        Vector3f vector = new Vector3f(2, 6, 12).div(new Vector3f(2, 4, 8));
        TestUtilf.assertEquals(vector, 1, (float) 1.5, (float) 1.5);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector3f vector = new Vector3f(2, 6, 16).div(2d, 4d, 8d);
        TestUtilf.assertEquals(vector, 1, (float) 1.5, 2);
    }

    @Test
    public void testFloatComponentsDivision() {
        Vector3f vector = new Vector3f(2, 6, 16).div(2, 4, 8);
        TestUtilf.assertEquals(vector, 1, 1.5f, 2);
    }

    @Test
    public void testVector3DotProduct() {
        float f = new Vector3f(2, 3, 4).dot(new Vector3f(4, 5, 6));
        TestUtilf.assertEquals(f, 47);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        float f = new Vector3f(2, 3, 4).dot(4d, 5d, 6d);
        TestUtilf.assertEquals(f, 47);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        float f = new Vector3f(2, 3, 4).dot(4, 5, 6);
        TestUtilf.assertEquals(f, 47);
    }

    @Test
    public void testVector3Project() {
        Vector3f vector = new Vector3f(2, 3, 4).project(new Vector3f(1, 1, 1));
        TestUtilf.assertEquals(vector, 3, 3, 3);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector3f vector = new Vector3f(2, 3, 4).project(1d, 1d, 1d);
        TestUtilf.assertEquals(vector, 3, 3, 3);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector3f vector = new Vector3f(2, 3, 4).project(1, 1, 1);
        TestUtilf.assertEquals(vector, 3, 3, 3);
    }

    @Test
    public void testVector3Cross() {
        Vector3f f = new Vector3f(2, 3, 4).cross(new Vector3f(4, 5, 6.5));
        TestUtilf.assertEquals(f, (float) -0.5, 3, -2);
    }

    @Test
    public void testDoubleComponentsCross() {
        Vector3f f = new Vector3f(2, 3, 4).cross(4, 5, 6.5);
        TestUtilf.assertEquals(f, (float) -0.5, 3, -2);
    }

    @Test
    public void testFloatComponentsCross() {
        Vector3f f = new Vector3f(2, 3, 4).cross(4, 5, 6.5f);
        TestUtilf.assertEquals(f, -0.5f, 3, -2);
    }

    @Test
    public void testRaiseToFloatPower() {
        Vector3f vector = new Vector3f(2, 6, 8).pow(2);
        TestUtilf.assertEquals(vector, 4f, 36f, 64f);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector3f vector = new Vector3f(2, 6, 8).pow(2d);
        TestUtilf.assertEquals(vector, 4, 36, 64);
    }

    @Test
    public void testCeiling() {
        Vector3f vector = new Vector3f(2.5, 6.7, 7.9).ceil();
        TestUtilf.assertEquals(vector, 3, 7, 8);
    }

    @Test
    public void testFloor() {
        Vector3f vector = new Vector3f(2.5, 6.7, 7.8).floor();
        TestUtilf.assertEquals(vector, 2, 6, 7);
    }

    @Test
    public void testRound() {
        Vector3f vector = new Vector3f(2.2, 6.7, 7.8).round();
        TestUtilf.assertEquals(vector, 2, 7, 8);
    }

    @Test
    public void testAbsolute() {
        Vector3f vector1 = new Vector3f(-2.5, -6.7, -55).abs();
        TestUtilf.assertEquals(vector1, (float) 2.5, (float) 6.7, 55);
        Vector3f vector2 = new Vector3f(2.5, 6.7, 55).abs();
        TestUtilf.assertEquals(vector2, (float) 2.5, (float) 6.7, 55);
    }

    @Test
    public void testNegate() {
        Vector3f vector = new Vector3f(2.2, -6.7, 15.8).negate();
        TestUtilf.assertEquals(vector, (float) -2.2, (float) 6.7, (float) -15.8);
    }

    @Test
    public void testVector3Minimum() {
        Vector3f vector = new Vector3f(2, 6, -1).min(new Vector3f(3, 4, 10));
        TestUtilf.assertEquals(vector, 2, 4, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector3f vector = new Vector3f(2, 6, 10).min(3d, 4d, -5d);
        TestUtilf.assertEquals(vector, 2, 4, -5);
    }

    @Test
    public void testFloatComponentsMinimum() {
        Vector3f vector = new Vector3f(2, 6, 10).min(3, 4, -5);
        TestUtilf.assertEquals(vector, 2, 4, -5);
    }

    @Test
    public void testVector3Maximum() {
        Vector3f vector = new Vector3f(2, 6, 10).max(new Vector3f(3, 4, -5));
        TestUtilf.assertEquals(vector, 3, 6, 10);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector3f vector = new Vector3f(2, 6, 10).max(3d, 4d, -5d);
        TestUtilf.assertEquals(vector, 3, 6, 10);
    }

    @Test
    public void testFloatComponentsMaximum() {
        Vector3f vector = new Vector3f(2, 6, 10).max(3, 4, -5);
        TestUtilf.assertEquals(vector, 3, 6, 10);
    }

    @Test
    public void testVector3DistanceSquared() {
        float f = new Vector3f(2, 3, 4).distanceSquared(new Vector3f(5, 6, 7));
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        float f = new Vector3f(2, 3, 4).distanceSquared(5d, 6d, 7d);
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        float f = new Vector3f(2, 3, 4).distanceSquared(5, 6, 7);
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testVector3Distance() {
        float f = new Vector3f(0, 2, 4).distance(new Vector3f(0, 8, 16));
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        float f = new Vector3f(0, 2, 4).distance(0d, 8d, 16d);
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testFloatComponentsDistance() {
        float f = new Vector3f(0, 2, 4).distance(0, 8, 16);
        TestUtilf.assertEquals(f,  6 * SQRT5);
    }

    @Test
    public void testLength() {
        float f = new Vector3f(3, 4, 5).length();
        TestUtilf.assertEquals(f, 5 * SQRT2);
    }

    @Test
    public void testLengthSquared() {
        float f = new Vector3f(3, 4, 5).lengthSquared();
        TestUtilf.assertEquals(f, 50);
    }

    @Test
    public void testNormalize() {
        Vector3f vector = new Vector3f(2, 2, 0).normalize();
        TestUtilf.assertEquals(vector, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0);
        try {
            Vector3f.ZERO.normalize();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testGetMinAxis() {
        Vector3f vector1 = new Vector3f(1, 2, 3);
        TestUtilf.assertEquals(vector1.getMinAxis(), 0);
        Vector3f vector2 = new Vector3f(2, 1, 3);
        TestUtilf.assertEquals(vector2.getMinAxis(), 1);
        Vector3f vector3 = new Vector3f(3, 2, 1);
        TestUtilf.assertEquals(vector3.getMinAxis(), 2);
    }

    @Test
    public void testGetMaxAxis() {
        Vector3f vector1 = new Vector3f(3, 1, 2);
        TestUtilf.assertEquals(vector1.getMaxAxis(), 0);
        Vector3f vector2 = new Vector3f(1, 3, 2);
        TestUtilf.assertEquals(vector2.getMaxAxis(), 1);
        Vector3f vector3 = new Vector3f(1, 2, 3);
        TestUtilf.assertEquals(vector3.getMaxAxis(), 2);
    }

    @Test
    public void testConvertToVector2() {
        Vector2f vector = new Vector3f(1, 2, 3).toVector2();
        TestUtilf.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToVector4DefaultW() {
        Vector4f vector = new Vector3f(1, 2, 3).toVector4();
        TestUtilf.assertEquals(vector, 1, 2, 3, 0);
    }

    @Test
    public void testConvertToVector4FloatW() {
        Vector4f vector = new Vector3f(1, 2, 3).toVector4(4);
        TestUtilf.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVector4DoubleW() {
        Vector4f vector = new Vector3f(1, 2, 3).toVector4(4d);
        TestUtilf.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNf vector = new Vector3f(1, 2, 3).toVectorN();
        TestUtilf.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToArray() {
        float[] array = new Vector3f(1, 2, 3).toArray();
        TestUtilf.assertEquals(array, 1, 2, 3);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector3f(10, 20, 30).compareTo(new Vector3f(20, 20, 30));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector3f(10, 20, 30).compareTo(new Vector3f(10, 20, 30));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector3f(10, 20, 30).compareTo(new Vector3f(10, 10, 30));
        Assert.assertTrue(c3 > 0);
        int c4 = new Vector3f(0.2, 0.2, 0.2).compareTo(new Vector3f(0.1, 0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector3f(122, 43, 96).equals(new Vector3f(122, 43, 96)));
        Assert.assertFalse(new Vector3f(122, 43, 96).equals(new Vector3f(378, 95, 96)));
    }

    @Test
    public void testCloning() {
        Vector3f vector = new Vector3f(3, 2, 5);
        Assert.assertEquals(vector, vector.clone());
    }

    @Test
    public void testCreateDirectionFromRandom() {
        Random random = new Random(0xF5514E866AA4L);
        for (int i = 0; i < 10; i++) {
            Vector3f vector = Vector3f.createRandomDirection(random);
            TestUtilf.assertEquals(vector.length(), 1);
        }
    }

    @Test
    public void testCreateDirectionFromDoubleAnglesDegrees() {
        Vector3f vector1 = Vector3f.createDirectionDeg(0d, 0d);
        TestUtilf.assertEquals(vector1, 0, 0, 1);
        Vector3f vector2 = Vector3f.createDirectionDeg(45d, 90d);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3f vector3 = Vector3f.createDirectionDeg(90d, 90d);
        TestUtilf.assertEquals(vector3, 0, 1, 0);
        Vector3f vector4 = Vector3f.createDirectionDeg(180d, 180d);
        TestUtilf.assertEquals(vector4, 0, 0, -1);
        Vector3f vector5 = Vector3f.createDirectionDeg(270d, 270d);
        TestUtilf.assertEquals(vector5, 0, 1, 0);
        Vector3f vector6 = Vector3f.createDirectionDeg(360d, 360d);
        TestUtilf.assertEquals(vector6, 0, 0, 1);
    }

    @Test
    public void testCreateDirectionFromFloatAnglesDegrees() {
        Vector3f vector1 = Vector3f.createDirectionDeg(0, 0);
        TestUtilf.assertEquals(vector1, 0, 0, 1);
        Vector3f vector2 = Vector3f.createDirectionDeg(45, 90);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3f vector3 = Vector3f.createDirectionDeg(90, 90);
        TestUtilf.assertEquals(vector3, 0, 1, 0);
        Vector3f vector4 = Vector3f.createDirectionDeg(180, 180);
        TestUtilf.assertEquals(vector4, 0, 0, -1);
        Vector3f vector5 = Vector3f.createDirectionDeg(270, 270);
        TestUtilf.assertEquals(vector5, 0, 1, 0);
        Vector3f vector6 = Vector3f.createDirectionDeg(360, 360);
        TestUtilf.assertEquals(vector6, 0, 0, 1);
    }

    @Test
    public void testCreateDirectionFromDoubleAnglesRadians() {
        Vector3f vector1 = Vector3f.createDirectionRad(0d, 0d);
        TestUtilf.assertEquals(vector1, 0, 0, 1);
        Vector3f vector2 = Vector3f.createDirectionRad(TrigMath.QUARTER_PI, TrigMath.HALF_PI);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3f vector3 = Vector3f.createDirectionRad(TrigMath.HALF_PI, TrigMath.HALF_PI);
        TestUtilf.assertEquals(vector3, 0, 1, 0);
        Vector3f vector4 = Vector3f.createDirectionRad(TrigMath.PI, TrigMath.PI);
        TestUtilf.assertEquals(vector4, 0, 0, -1);
        Vector3f vector5 = Vector3f.createDirectionRad(TrigMath.THREE_PI_HALVES, TrigMath.THREE_PI_HALVES);
        TestUtilf.assertEquals(vector5, 0, 1, 0);
        Vector3f vector6 = Vector3f.createDirectionRad(TrigMath.TWO_PI, TrigMath.TWO_PI);
        TestUtilf.assertEquals(vector6, 0, 0, 1);
    }

    @Test
    public void testCreateDirectionFromFloatAnglesRadians() {
        Vector3f vector1 = Vector3f.createDirectionRad(0, 0);
        TestUtilf.assertEquals(vector1, 0, 0, 1);
        Vector3f vector2 = Vector3f.createDirectionRad((float) TrigMath.QUARTER_PI, (float) TrigMath.HALF_PI);
        TestUtilf.assertEquals(vector2, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3f vector3 = Vector3f.createDirectionRad((float) TrigMath.HALF_PI, (float) TrigMath.HALF_PI);
        TestUtilf.assertEquals(vector3, 0, 1, 0);
        Vector3f vector4 = Vector3f.createDirectionRad((float) TrigMath.PI, (float) TrigMath.PI);
        TestUtilf.assertEquals(vector4, 0, 0, -1);
        Vector3f vector5 = Vector3f.createDirectionRad((float) TrigMath.THREE_PI_HALVES, (float) TrigMath.THREE_PI_HALVES);
        TestUtilf.assertEquals(vector5, 0, 1, 0);
        Vector3f vector6 = Vector3f.createDirectionRad((float) TrigMath.TWO_PI, (float) TrigMath.TWO_PI);
        TestUtilf.assertEquals(vector6, 0, 0, 1);
    }
}
