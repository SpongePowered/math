package com.flowpowered.math.test.vector;

import static com.flowpowered.math.test.TestUtild.SQRT2;
import static com.flowpowered.math.test.TestUtild.SQRT5;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector4d;
import com.flowpowered.math.vector.VectorNd;

public class Vector3dTest {
    @Test
    public void testEmptyConstructor() {
        Vector3d vector = new Vector3d();
        TestUtild.assertEquals(vector, 0, 0, 0);
    }

    @Test
    public void testCopyVector2DefaultZConstructor() {
        Vector3d vector = new Vector3d(new Vector2d(0, 1));
        TestUtild.assertEquals(vector, 0, 1, 0);
    }

    @Test
    public void testCopyVector2DoubleZConstructor() {
        Vector3d vector = new Vector3d(new Vector2d(0, 1), 3d);
        TestUtild.assertEquals(vector, 0, 1, 3);
    }

    @Test
    public void testCopyVector2FloatZConstructor() {
        Vector3d vector = new Vector3d(new Vector2d(0, 1), 3);
        TestUtild.assertEquals(vector, 0, 1, 3);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector3d vector = new Vector3d(new Vector3d(0, 1, 2));
        TestUtild.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector3d vector = new Vector3d(new Vector4d(0, 1, 2, 3));
        TestUtild.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector3d vector = new Vector3d(new VectorNd(0, 1, 2, 3, 4));
        TestUtild.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector3d vector = new Vector3d(0.5, 1.7, 3.8);
        TestUtild.assertEquals(vector, (double) 0.5, (double) 1.7, (double) 3.8);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Vector3d vector = new Vector3d(0.5f, 1.7f, 3.8f);
        TestUtild.assertEquals(vector, 0.5f, 1.7f, 3.8f);
    }

    @Test
    public void testGetters() {
        Vector3d vector = new Vector3d(0.5, 1.7, 3.8);
        TestUtild.assertEquals(vector.getX(), (double) 0.5);
        TestUtild.assertEquals(vector.getY(), (double) 1.7);
        TestUtild.assertEquals(vector.getZ(), (double) 3.8);
    }

    @Test
    public void testFloorGetters() {
        Vector3d vector = new Vector3d(0.5, 1.7, 3.8);
        TestUtild.assertEquals(vector.getFloorX(), 0);
        TestUtild.assertEquals(vector.getFloorY(), 1);
        TestUtild.assertEquals(vector.getFloorZ(), 3);
    }

    @Test
    public void testVector3Addition() {
        Vector3d vector = new Vector3d(0, 1, 1).add(new Vector3d(5.5, -0.5, 3.8));
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5, (double) 4.8);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector3d vector = new Vector3d(0, 1, 5).add(5.5, -0.5, 3.8);
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5, (double) 8.8);
    }

    @Test
    public void testFloatComponentsAddition() {
        Vector3d vector = new Vector3d(0, 1, 5).add(5.5f, -0.5f, 3.8f);
        TestUtild.assertEquals(vector, 5.5f, 0.5f, (double) 8.8);
    }

    @Test
    public void testVector3Subtraction() {
        Vector3d vector = new Vector3d(10, 5, 1).sub(new Vector3d(9, 4.5, 2));
        TestUtild.assertEquals(vector, 1, (double) 0.5, -1);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector3d vector = new Vector3d(10, 5, 1).sub(9, 4.5, 2);
        TestUtild.assertEquals(vector, 1, (double) 0.5, -1);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Vector3d vector = new Vector3d(10, 5, 1).sub(9, 4.5f, 2);
        TestUtild.assertEquals(vector, 1f, 0.5f, -1f);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector3d vector = new Vector3d(2, 3, 4).mul(1.5);
        TestUtild.assertEquals(vector, 3, (double) 4.5, 6);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Vector3d vector = new Vector3d(2, 3, 4).mul(1.5f);
        TestUtild.assertEquals(vector, 3, 4.5f, 6);
    }

    @Test
    public void testVector3Multiplication() {
        Vector3d vector = new Vector3d(2, 3, 4).mul(new Vector3d(1.5, 2.5, 3.5));
        TestUtild.assertEquals(vector, 3, (double) 7.5, 14);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector3d vector = new Vector3d(2, 3, 4).mul(1.5, 2.5, 3.5);
        TestUtild.assertEquals(vector, 3, (double) 7.5, 14);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Vector3d vector = new Vector3d(2, 3, 4).mul(1.5f, 2.5f, 3.5f);
        TestUtild.assertEquals(vector, 3, (double) 7.5, 14);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector3d vector = new Vector3d(2, 3, 4).div(2d);
        TestUtild.assertEquals(vector, 1, (double) 1.5, 2);
    }

    @Test
    public void testFloatFactorDivision() {
        Vector3d vector = new Vector3d(2, 3, 4).div(2);
        TestUtild.assertEquals(vector, 1, 1.5f, 2);
    }

    @Test
    public void testVector3Division() {
        Vector3d vector = new Vector3d(2, 6, 12).div(new Vector3d(2, 4, 8));
        TestUtild.assertEquals(vector, 1, (double) 1.5, (double) 1.5);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector3d vector = new Vector3d(2, 6, 16).div(2d, 4d, 8d);
        TestUtild.assertEquals(vector, 1, (double) 1.5, 2);
    }

    @Test
    public void testFloatComponentsDivision() {
        Vector3d vector = new Vector3d(2, 6, 16).div(2, 4, 8);
        TestUtild.assertEquals(vector, 1, 1.5f, 2);
    }

    @Test
    public void testVector3DotProduct() {
        double f = new Vector3d(2, 3, 4).dot(new Vector3d(4, 5, 6));
        TestUtild.assertEquals(f, 47);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        double f = new Vector3d(2, 3, 4).dot(4d, 5d, 6d);
        TestUtild.assertEquals(f, 47);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        double f = new Vector3d(2, 3, 4).dot(4, 5, 6);
        TestUtild.assertEquals(f, 47);
    }

    @Test
    public void testVector3Project() {
        Vector3d vector = new Vector3d(2, 3, 4).project(new Vector3d(1, 1, 1));
        TestUtild.assertEquals(vector, 3, 3, 3);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector3d vector = new Vector3d(2, 3, 4).project(1d, 1d, 1d);
        TestUtild.assertEquals(vector, 3, 3, 3);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector3d vector = new Vector3d(2, 3, 4).project(1, 1, 1);
        TestUtild.assertEquals(vector, 3, 3, 3);
    }

    @Test
    public void testVector3Cross() {
        Vector3d f = new Vector3d(2, 3, 4).cross(new Vector3d(4, 5, 6.5));
        TestUtild.assertEquals(f, (double) -0.5, 3, -2);
    }

    @Test
    public void testDoubleComponentsCross() {
        Vector3d f = new Vector3d(2, 3, 4).cross(4, 5, 6.5);
        TestUtild.assertEquals(f, (double) -0.5, 3, -2);
    }

    @Test
    public void testFloatComponentsCross() {
        Vector3d f = new Vector3d(2, 3, 4).cross(4, 5, 6.5f);
        TestUtild.assertEquals(f, -0.5f, 3, -2);
    }

    @Test
    public void testRaiseToFloatPower() {
        Vector3d vector = new Vector3d(2, 6, 8).pow(2);
        TestUtild.assertEquals(vector, 4f, 36f, 64f);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector3d vector = new Vector3d(2, 6, 8).pow(2d);
        TestUtild.assertEquals(vector, 4, 36, 64);
    }

    @Test
    public void testCeiling() {
        Vector3d vector = new Vector3d(2.5, 6.7, 7.9).ceil();
        TestUtild.assertEquals(vector, 3, 7, 8);
    }

    @Test
    public void testFloor() {
        Vector3d vector = new Vector3d(2.5, 6.7, 7.8).floor();
        TestUtild.assertEquals(vector, 2, 6, 7);
    }

    @Test
    public void testRound() {
        Vector3d vector = new Vector3d(2.2, 6.7, 7.8).round();
        TestUtild.assertEquals(vector, 2, 7, 8);
    }

    @Test
    public void testAbsolute() {
        Vector3d vector1 = new Vector3d(-2.5, -6.7, -55).abs();
        TestUtild.assertEquals(vector1, (double) 2.5, (double) 6.7, 55);
        Vector3d vector2 = new Vector3d(2.5, 6.7, 55).abs();
        TestUtild.assertEquals(vector2, (double) 2.5, (double) 6.7, 55);
    }

    @Test
    public void testNegate() {
        Vector3d vector = new Vector3d(2.2, -6.7, 15.8).negate();
        TestUtild.assertEquals(vector, (double) -2.2, (double) 6.7, (double) -15.8);
    }

    @Test
    public void testVector3Minimum() {
        Vector3d vector = new Vector3d(2, 6, -1).min(new Vector3d(3, 4, 10));
        TestUtild.assertEquals(vector, 2, 4, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector3d vector = new Vector3d(2, 6, 10).min(3d, 4d, -5d);
        TestUtild.assertEquals(vector, 2, 4, -5);
    }

    @Test
    public void testFloatComponentsMinimum() {
        Vector3d vector = new Vector3d(2, 6, 10).min(3, 4, -5);
        TestUtild.assertEquals(vector, 2, 4, -5);
    }

    @Test
    public void testVector3Maximum() {
        Vector3d vector = new Vector3d(2, 6, 10).max(new Vector3d(3, 4, -5));
        TestUtild.assertEquals(vector, 3, 6, 10);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector3d vector = new Vector3d(2, 6, 10).max(3d, 4d, -5d);
        TestUtild.assertEquals(vector, 3, 6, 10);
    }

    @Test
    public void testFloatComponentsMaximum() {
        Vector3d vector = new Vector3d(2, 6, 10).max(3, 4, -5);
        TestUtild.assertEquals(vector, 3, 6, 10);
    }

    @Test
    public void testVector3DistanceSquared() {
        double f = new Vector3d(2, 3, 4).distanceSquared(new Vector3d(5, 6, 7));
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        double f = new Vector3d(2, 3, 4).distanceSquared(5d, 6d, 7d);
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        double f = new Vector3d(2, 3, 4).distanceSquared(5, 6, 7);
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testVector3Distance() {
        double f = new Vector3d(0, 2, 4).distance(new Vector3d(0, 8, 16));
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        double f = new Vector3d(0, 2, 4).distance(0d, 8d, 16d);
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testFloatComponentsDistance() {
        double f = new Vector3d(0, 2, 4).distance(0, 8, 16);
        TestUtild.assertEquals(f,  6 * SQRT5);
    }

    @Test
    public void testLength() {
        double f = new Vector3d(3, 4, 5).length();
        TestUtild.assertEquals(f, 5 * SQRT2);
    }

    @Test
    public void testLengthSquared() {
        double f = new Vector3d(3, 4, 5).lengthSquared();
        TestUtild.assertEquals(f, 50);
    }

    @Test
    public void testNormalize() {
        Vector3d vector = new Vector3d(2, 2, 0).normalize();
        TestUtild.assertEquals(vector, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0);
        try {
            Vector3d.ZERO.normalize();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testGetMinAxis() {
        Vector3d vector1 = new Vector3d(1, 2, 3);
        TestUtild.assertEquals(vector1.getMinAxis(), 0);
        Vector3d vector2 = new Vector3d(2, 1, 3);
        TestUtild.assertEquals(vector2.getMinAxis(), 1);
        Vector3d vector3 = new Vector3d(3, 2, 1);
        TestUtild.assertEquals(vector3.getMinAxis(), 2);
    }

    @Test
    public void testGetMaxAxis() {
        Vector3d vector1 = new Vector3d(3, 1, 2);
        TestUtild.assertEquals(vector1.getMaxAxis(), 0);
        Vector3d vector2 = new Vector3d(1, 3, 2);
        TestUtild.assertEquals(vector2.getMaxAxis(), 1);
        Vector3d vector3 = new Vector3d(1, 2, 3);
        TestUtild.assertEquals(vector3.getMaxAxis(), 2);
    }

    @Test
    public void testConvertToVector2() {
        Vector2d vector = new Vector3d(1, 2, 3).toVector2();
        TestUtild.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToVector4DefaultW() {
        Vector4d vector = new Vector3d(1, 2, 3).toVector4();
        TestUtild.assertEquals(vector, 1, 2, 3, 0);
    }

    @Test
    public void testConvertToVector4FloatW() {
        Vector4d vector = new Vector3d(1, 2, 3).toVector4(4);
        TestUtild.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVector4DoubleW() {
        Vector4d vector = new Vector3d(1, 2, 3).toVector4(4d);
        TestUtild.assertEquals(vector, 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNd vector = new Vector3d(1, 2, 3).toVectorN();
        TestUtild.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToArray() {
        double[] array = new Vector3d(1, 2, 3).toArray();
        TestUtild.assertEquals(array, 1, 2, 3);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector3d(10, 20, 30).compareTo(new Vector3d(20, 20, 30));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector3d(10, 20, 30).compareTo(new Vector3d(10, 20, 30));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector3d(10, 20, 30).compareTo(new Vector3d(10, 10, 30));
        Assert.assertTrue(c3 > 0);
        int c4 = new Vector3d(0.2, 0.2, 0.2).compareTo(new Vector3d(0.1, 0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector3d(122, 43, 96).equals(new Vector3d(122, 43, 96)));
        Assert.assertFalse(new Vector3d(122, 43, 96).equals(new Vector3d(378, 95, 96)));
    }

    @Test
    public void testCloning() {
        Vector3d vector = new Vector3d(3, 2, 5);
        Assert.assertEquals(vector, vector.clone());
    }

    @Test
    public void testVectorFromN() {
        Vector3d vector = Vector3d.from(1);
        TestUtild.assertEquals(vector, 1, 1, 1);
    }

    @Test
    public void testVectorFromXYZ() {
        Vector3d vector = Vector3d.from(1, 2, 3);
        TestUtild.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testCreateDirectionFromRandom() {
        Random random = new Random(0xF5514E866AA4L);
        for (int i = 0; i < 10; i++) {
            Vector3d vector = Vector3d.createRandomDirection(random);
            TestUtild.assertEquals(vector.length(), 1);
        }
    }

    @Test
    public void testCreateDirectionFromDoubleAnglesDegrees() {
        Vector3d vector1 = Vector3d.createDirectionDeg(0d, 0d);
        TestUtild.assertEquals(vector1, 0, 0, 1);
        Vector3d vector2 = Vector3d.createDirectionDeg(45d, 90d);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3d vector3 = Vector3d.createDirectionDeg(90d, 90d);
        TestUtild.assertEquals(vector3, 0, 1, 0);
        Vector3d vector4 = Vector3d.createDirectionDeg(180d, 180d);
        TestUtild.assertEquals(vector4, 0, 0, -1);
        Vector3d vector5 = Vector3d.createDirectionDeg(270d, 270d);
        TestUtild.assertEquals(vector5, 0, 1, 0);
        Vector3d vector6 = Vector3d.createDirectionDeg(360d, 360d);
        TestUtild.assertEquals(vector6, 0, 0, 1);
    }

    @Test
    public void testCreateDirectionFromFloatAnglesDegrees() {
        Vector3d vector1 = Vector3d.createDirectionDeg(0, 0);
        TestUtild.assertEquals(vector1, 0, 0, 1);
        Vector3d vector2 = Vector3d.createDirectionDeg(45, 90);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3d vector3 = Vector3d.createDirectionDeg(90, 90);
        TestUtild.assertEquals(vector3, 0, 1, 0);
        Vector3d vector4 = Vector3d.createDirectionDeg(180, 180);
        TestUtild.assertEquals(vector4, 0, 0, -1);
        Vector3d vector5 = Vector3d.createDirectionDeg(270, 270);
        TestUtild.assertEquals(vector5, 0, 1, 0);
        Vector3d vector6 = Vector3d.createDirectionDeg(360, 360);
        TestUtild.assertEquals(vector6, 0, 0, 1);
    }

    @Test
    public void testCreateDirectionFromDoubleAnglesRadians() {
        Vector3d vector1 = Vector3d.createDirectionRad(0d, 0d);
        TestUtild.assertEquals(vector1, 0, 0, 1);
        Vector3d vector2 = Vector3d.createDirectionRad(TrigMath.QUARTER_PI, TrigMath.HALF_PI);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3d vector3 = Vector3d.createDirectionRad(TrigMath.HALF_PI, TrigMath.HALF_PI);
        TestUtild.assertEquals(vector3, 0, 1, 0);
        Vector3d vector4 = Vector3d.createDirectionRad(TrigMath.PI, TrigMath.PI);
        TestUtild.assertEquals(vector4, 0, 0, -1);
        Vector3d vector5 = Vector3d.createDirectionRad(TrigMath.THREE_PI_HALVES, TrigMath.THREE_PI_HALVES);
        TestUtild.assertEquals(vector5, 0, 1, 0);
        Vector3d vector6 = Vector3d.createDirectionRad(TrigMath.TWO_PI, TrigMath.TWO_PI);
        TestUtild.assertEquals(vector6, 0, 0, 1);
    }

    @Test
    public void testCreateDirectionFromFloatAnglesRadians() {
        Vector3d vector1 = Vector3d.createDirectionRad(0, 0);
        TestUtild.assertEquals(vector1, 0, 0, 1);
        Vector3d vector2 = Vector3d.createDirectionRad((float) TrigMath.QUARTER_PI, (float) TrigMath.HALF_PI);
        TestUtild.assertEquals(vector2, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0);
        Vector3d vector3 = Vector3d.createDirectionRad((float) TrigMath.HALF_PI, (float) TrigMath.HALF_PI);
        TestUtild.assertEquals(vector3, 0, 1, 0);
        Vector3d vector4 = Vector3d.createDirectionRad((float) TrigMath.PI, (float) TrigMath.PI);
        TestUtild.assertEquals(vector4, 0, 0, -1);
        Vector3d vector5 = Vector3d.createDirectionRad((float) TrigMath.THREE_PI_HALVES, (float) TrigMath.THREE_PI_HALVES);
        TestUtild.assertEquals(vector5, 0, 1, 0);
        Vector3d vector6 = Vector3d.createDirectionRad((float) TrigMath.TWO_PI, (float) TrigMath.TWO_PI);
        TestUtild.assertEquals(vector6, 0, 0, 1);
    }
}
