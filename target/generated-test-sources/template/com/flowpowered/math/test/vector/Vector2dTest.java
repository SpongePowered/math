package com.flowpowered.math.test.vector;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector4d;
import com.flowpowered.math.vector.VectorNd;

public class Vector2dTest {
    @Test
    public void testEmptyConstructor() {
        Vector2d vector = new Vector2d();
        TestUtild.assertEquals(vector, 0, 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        Vector2d vector = new Vector2d(new Vector2d(0, 1));
        TestUtild.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector2d vector = new Vector2d(new Vector3d(0, 1, 2));
        TestUtild.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector2d vector = new Vector2d(new Vector4d(0, 1, 2, 3));
        TestUtild.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector2d vector = new Vector2d(new VectorNd(0, 1, 2, 3, 4));
        TestUtild.assertEquals(vector, 0, 1);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector2d vector = new Vector2d(0.5, 1.7);
        TestUtild.assertEquals(vector, (double) 0.5, (double) 1.7);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Vector2d vector = new Vector2d(0.5f, 1.7f);
        TestUtild.assertEquals(vector, 0.5f, 1.7f);
    }

    @Test
    public void testGetters() {
        Vector2d vector = new Vector2d((double) 0.5, (double) 1.7);
        TestUtild.assertEquals(vector.getX(), (double) 0.5);
        TestUtild.assertEquals(vector.getY(), (double) 1.7);
    }

    @Test
    public void testFloorGetters() {
        Vector2d vector = new Vector2d(0.5, 1.7);
        TestUtild.assertEquals(vector.getFloorX(), 0);
        TestUtild.assertEquals(vector.getFloorY(), 1);
    }

    @Test
    public void testVector2Addition() {
        Vector2d vector = new Vector2d(0, 1).add(new Vector2d(5.5, -0.5));
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector2d vector = new Vector2d(0, 1).add(5.5, -0.5);
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Vector2d vector = new Vector2d(0, 1).add(5.5f, -0.5f);
        TestUtild.assertEquals(vector, 5.5f, 0.5f);
    }

    @Test
    public void testVector2Subtraction() {
        Vector2d vector = new Vector2d(10, 5).sub(new Vector2d(9, 4.5));
        TestUtild.assertEquals(vector, 1, (double) 0.5);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector2d vector = new Vector2d(10, 5).sub(9, 4.5);
        TestUtild.assertEquals(vector, 1, (double) 0.5);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Vector2d vector = new Vector2d(10, 5).sub(9f, 4.5f);
        TestUtild.assertEquals(vector, 1, 0.5f);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector2d vector = new Vector2d(2, 3).mul(1.5);
        TestUtild.assertEquals(vector, 3, (double) 4.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Vector2d vector = new Vector2d(2, 3).mul(1.5f);
        TestUtild.assertEquals(vector, 3, 4.5f);
    }

    @Test
    public void testVector2Multiplication() {
        Vector2d vector = new Vector2d(2, 3).mul(new Vector2d(1.5, 2.5));
        TestUtild.assertEquals(vector, 3, (double) 7.5);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector2d vector = new Vector2d(2, 3).mul(1.5, 2.5);
        TestUtild.assertEquals(vector, 3, (double) 7.5);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Vector2d vector = new Vector2d(2, 3).mul(1.5f, 2.5f);
        TestUtild.assertEquals(vector, 3, 7.5f);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector2d vector = new Vector2d(2, 3).div(2d);
        TestUtild.assertEquals(vector, 1, (double) 1.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Vector2d vector = new Vector2d(2, 3).div(2);
        TestUtild.assertEquals(vector, 1, 1.5f);
    }

    @Test
    public void testVector2Division() {
        Vector2d vector = new Vector2d(2, 6).div(new Vector2d(2, 4));
        TestUtild.assertEquals(vector, 1, (double) 1.5);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector2d vector = new Vector2d(2, 6).div(2d, 4d);
        TestUtild.assertEquals(vector, 1, (double) 1.5);
    }

    @Test
    public void testFloatComponentsDivision() {
        Vector2d vector = new Vector2d(2, 6).div(2, 4);
        TestUtild.assertEquals(vector, 1f, 1.5f);
    }

    @Test
    public void testVector2DotProduct() {
        double f = new Vector2d(2, 3).dot(new Vector2d(4, 5));
        TestUtild.assertEquals(f, 23);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        double f = new Vector2d(2, 3).dot(4d, 5d);
        TestUtild.assertEquals(f, 23);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        double f = new Vector2d(2, 3).dot(4, 5);
        TestUtild.assertEquals(f, 23);
    }

    @Test
    public void testVector2Project() {
        Vector2d vector = new Vector2d(2, 3).project(new Vector2d(1, 1));
        TestUtild.assertEquals(vector, (double) 2.5, (double) 2.5);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector2d vector = new Vector2d(2, 3).project(1d, 1d);
        TestUtild.assertEquals(vector, (double) 2.5, (double) 2.5);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector2d vector = new Vector2d(2, 3).project(1, 1);
        TestUtild.assertEquals(vector, (double) 2.5, (double) 2.5);
    }

    @Test
    public void testRaiseToFloatPower() {
        Vector2d vector = new Vector2d(2, 6).pow(2);
        TestUtild.assertEquals(vector, 4, 36);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector2d vector = new Vector2d(2, 6).pow(2d);
        TestUtild.assertEquals(vector, 4, 36);
    }

    @Test
    public void testCeiling() {
        Vector2d vector = new Vector2d(2.5, 6.7).ceil();
        TestUtild.assertEquals(vector, 3, 7);
    }

    @Test
    public void testFloor() {
        Vector2d vector = new Vector2d(2.5, 6.7).floor();
        TestUtild.assertEquals(vector, 2, 6);
    }

    @Test
    public void testRound() {
        Vector2d vector = new Vector2d(2.2, 6.7).round();
        TestUtild.assertEquals(vector, 2, 7);
    }

    @Test
    public void testAbsolute() {
        Vector2d vector1 = new Vector2d(-2.5, -6.7).abs();
        TestUtild.assertEquals(vector1, (double) 2.5, (double) 6.7);
        Vector2d vector2 = new Vector2d(2.5, 6.7).abs();
        TestUtild.assertEquals(vector2, (double) 2.5, (double) 6.7);
    }

    @Test
    public void testNegate() {
        Vector2d vector = new Vector2d(2.2, -6.7).negate();
        TestUtild.assertEquals(vector, -(double) 2.2, (double) 6.7);
    }

    @Test
    public void testVector2Minimum() {
        Vector2d vector = new Vector2d(2, 6).min(new Vector2d(3, 4));
        TestUtild.assertEquals(vector, 2, 4);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector2d vector = new Vector2d(2, 6).min(3d, 4d);
        TestUtild.assertEquals(vector, 2, 4);
    }

    @Test
    public void testFloatComponentsMinimum() {
        Vector2d vector = new Vector2d(2, 6).min(3, 4);
        TestUtild.assertEquals(vector, 2, 4);
    }

    @Test
    public void testVector2Maximum() {
        Vector2d vector = new Vector2d(2, 6).max(new Vector2d(3, 4));
        TestUtild.assertEquals(vector, 3, 6);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector2d vector = new Vector2d(2, 6).max(3d, 4d);
        TestUtild.assertEquals(vector, 3, 6);
    }

    @Test
    public void testFloatComponentsMaximum() {
        Vector2d vector = new Vector2d(2, 6).max(3, 4);
        TestUtild.assertEquals(vector, 3, 6);
    }

    @Test
    public void testVector2DistanceSquared() {
        double f = new Vector2d(2, 3).distanceSquared(new Vector2d(4, 5));
        TestUtild.assertEquals(f, 8);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        double f = new Vector2d(2, 3).distanceSquared(4d, 5d);
        TestUtild.assertEquals(f, 8);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        double f = new Vector2d(2, 3).distanceSquared(4, 5);
        TestUtild.assertEquals(f, 8);
    }

    @Test
    public void testVector2Distance() {
        double f = new Vector2d(4, 6).distance(new Vector2d(7, 2));
        TestUtild.assertEquals(f, 5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        double f = new Vector2d(4, 6).distance(7d, 2d);
        TestUtild.assertEquals(f, 5);
    }

    @Test
    public void testFloatComponentsDistance() {
        double f = new Vector2d(4, 6).distance(7, 2);
        TestUtild.assertEquals(f, 5);
    }

    @Test
    public void testLength() {
        double f = new Vector2d(3, 4).length();
        TestUtild.assertEquals(f, 5);
    }

    @Test
    public void testLengthSquared() {
        double f = new Vector2d(3, 4).lengthSquared();
        TestUtild.assertEquals(f, 25);
    }

    @Test
    public void testNormalize() {
        Vector2d vector = new Vector2d(2, 2).normalize();
        TestUtild.assertEquals(vector, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
        try {
            Vector2d.ZERO.normalize();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testGetMinAxis() {
        Vector2d vector1 = new Vector2d(1, 2);
        TestUtild.assertEquals(vector1.getMinAxis(), 0);
        Vector2d vector2 = new Vector2d(2, 1);
        TestUtild.assertEquals(vector2.getMinAxis(), 1);
    }

    @Test
    public void testGetMaxAxis() {
        Vector2d vector1 = new Vector2d(2, 1);
        TestUtild.assertEquals(vector1.getMaxAxis(), 0);
        Vector2d vector2 = new Vector2d(1, 2);
        TestUtild.assertEquals(vector2.getMaxAxis(), 1);
    }

    @Test
    public void testConvertToVector3DefaultZ() {
        Vector3d vector = new Vector2d(1, 2).toVector3();
        TestUtild.assertEquals(vector, 1, 2, 0);
    }

    @Test
    public void testConvertToVector3FloatZ() {
        Vector3d vector = new Vector2d(1, 2).toVector3(3);
        TestUtild.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVector3DoubleZ() {
        Vector3d vector = new Vector2d(1, 2).toVector3(3d);
        TestUtild.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVector4DefaultZW() {
        Vector4d vector = new Vector2d(1, 2).toVector4();
        TestUtild.assertEquals(vector, 1, 2, 0, 0);
    }

    @Test
    public void testConvertToVector4FloatZW() {
        Vector4d vector = new Vector2d(1, 2).toVector4(3, 4);
        TestUtild.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVector4DoubleZW() {
        Vector4d vector = new Vector2d(1, 2).toVector4(3d, 4d);
        TestUtild.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNd vector = new Vector2d(1, 2).toVectorN();
        TestUtild.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToArray() {
        double[] array = new Vector2d(1, 2).toArray();
        TestUtild.assertEquals(array, 1, 2);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector2d(10, 20).compareTo(new Vector2d(20, 20));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector2d(10, 20).compareTo(new Vector2d(10, 20));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector2d(10, 20).compareTo(new Vector2d(10, 10));
        Assert.assertTrue(c3 > 0);
        int c4 = new Vector2d(0.2, 0.2).compareTo(new Vector2d(0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector2d(122, 43).equals(new Vector2d(122, 43)));
        Assert.assertFalse(new Vector2d(122, 43).equals(new Vector2d(378, 95)));
    }

    @Test
    public void testCloning() {
        Vector2d vector = new Vector2d(3, 2);
        Assert.assertEquals(vector, vector.clone());
    }

    @Test
    public void testVectorFromN() {
        Vector2d vector = Vector2d.from(1);
        TestUtild.assertEquals(vector, 1, 1);
    }

    @Test
    public void testVectorFromXY() {
        Vector2d vector = Vector2d.from(1, 2);
        TestUtild.assertEquals(vector, 1, 2);
    }

    @Test
    public void testVectorFromMinAB() {
        Vector2d vector = Vector2d.fromMin(Vector2d.from(1, 0),
                                           Vector2d.from(2, 1));
        TestUtild.assertEquals(vector, 1, 0);
    }

    @Test
    public void testVectorFromMinMany() {
        Vector2d vector = Vector2d.fromMin(Vector2d.from(9, 0),
                                           Vector2d.from(8, 1),
                                           Vector2d.from(7, 2),
                                           Vector2d.from(6, 3),
                                           Vector2d.from(5, 4));
        TestUtild.assertEquals(vector, 5, 0);
    }

    @Test
    public void testVectorFromMaxAB() {
        Vector2d vector = Vector2d.fromMax(Vector2d.from(1, 0),
                                           Vector2d.from(2, 1));
        TestUtild.assertEquals(vector, 2, 1);
    }

    @Test
    public void testVectorFromMaxMany() {
        Vector2d vector = Vector2d.fromMax(Vector2d.from(9, 0),
                                           Vector2d.from(8, 1),
                                           Vector2d.from(7, 2),
                                           Vector2d.from(6, 3),
                                           Vector2d.from(5, 4));
        TestUtild.assertEquals(vector, 9, 4);
    }

    @Test
    public void testCreateDirectionFromRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Vector2d vector = Vector2d.createRandomDirection(random);
            TestUtild.assertEquals(vector.length(), 1);
        }
    }

    @Test
    public void testCreateDirectionFromDoubleAngleDegrees() {
        Vector2d vector1 = Vector2d.createDirectionDeg(0d);
        TestUtild.assertEquals(vector1, 1, 0);
        Vector2d vector2 = Vector2d.createDirectionDeg(45d);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
        Vector2d vector3 = Vector2d.createDirectionDeg(90d);
        TestUtild.assertEquals(vector3, 0, 1);
        Vector2d vector4 = Vector2d.createDirectionDeg(180d);
        TestUtild.assertEquals(vector4, -1, 0);
        Vector2d vector5 = Vector2d.createDirectionDeg(270d);
        TestUtild.assertEquals(vector5, 0, -1);
        Vector2d vector6 = Vector2d.createDirectionDeg(360d);
        TestUtild.assertEquals(vector6, 1, 0);
    }

    @Test
    public void testCreateDirectionFromFloatAngleDegrees() {
        Vector2d vector1 = Vector2d.createDirectionDeg(0);
        TestUtild.assertEquals(vector1, 1, 0);
        Vector2d vector2 = Vector2d.createDirectionDeg(45);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
        Vector2d vector3 = Vector2d.createDirectionDeg(90);
        TestUtild.assertEquals(vector3, 0, 1);
        Vector2d vector4 = Vector2d.createDirectionDeg(180);
        TestUtild.assertEquals(vector4, -1, 0);
        Vector2d vector5 = Vector2d.createDirectionDeg(270);
        TestUtild.assertEquals(vector5, 0, -1);
        Vector2d vector6 = Vector2d.createDirectionDeg(360);
        TestUtild.assertEquals(vector6, 1, 0);
    }

    @Test
    public void testCreateDirectionFromDoubleAngleRadians() {
        Vector2d vector1 = Vector2d.createDirectionRad(0d);
        TestUtild.assertEquals(vector1, 1, 0);
        Vector2d vector2 = Vector2d.createDirectionRad(TrigMath.QUARTER_PI);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
        Vector2d vector3 = Vector2d.createDirectionRad(TrigMath.HALF_PI);
        TestUtild.assertEquals(vector3, 0, 1);
        Vector2d vector4 = Vector2d.createDirectionRad(TrigMath.PI);
        TestUtild.assertEquals(vector4, -1, 0);
        Vector2d vector5 = Vector2d.createDirectionRad(TrigMath.THREE_PI_HALVES);
        TestUtild.assertEquals(vector5, 0, -1);
        Vector2d vector6 = Vector2d.createDirectionRad(TrigMath.TWO_PI);
        TestUtild.assertEquals(vector6, 1, 0);
    }

    @Test
    public void testCreateDirectionFromFloatAngleRadians() {
        Vector2d vector1 = Vector2d.createDirectionRad(0);
        TestUtild.assertEquals(vector1, 1, 0);
        Vector2d vector2 = Vector2d.createDirectionRad((float) TrigMath.QUARTER_PI);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
        Vector2d vector3 = Vector2d.createDirectionRad((float) TrigMath.HALF_PI);
        TestUtild.assertEquals(vector3, 0, 1);
        Vector2d vector4 = Vector2d.createDirectionRad((float) TrigMath.PI);
        TestUtild.assertEquals(vector4, -1, 0);
        Vector2d vector5 = Vector2d.createDirectionRad((float) TrigMath.THREE_PI_HALVES);
        TestUtild.assertEquals(vector5, 0, -1);
        Vector2d vector6 = Vector2d.createDirectionRad((float) TrigMath.TWO_PI);
        TestUtild.assertEquals(vector6, 1, 0);
    }
}
