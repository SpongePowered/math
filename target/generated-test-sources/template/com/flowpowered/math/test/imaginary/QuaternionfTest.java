package com.flowpowered.math.test.imaginary;

import static com.flowpowered.math.test.TestUtilf.SQRT54;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.matrix.Matrix3f;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector3f;

public class QuaternionfTest {
    @Test
    public void testDefaultConstructor() {
        Quaternionf quaternion = new Quaternionf();
        TestUtilf.assertEquals(quaternion, 0, 0, 0, 1);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Quaternionf quaternion = new Quaternionf(1d, 2d, 3d, 4d);
        TestUtilf.assertEquals(quaternion, 1, 2, 3, 4);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Quaternionf quaternion = new Quaternionf(1, 2, 3, 4);
        TestUtilf.assertEquals(quaternion, 1, 2, 3, 4);
    }

    @Test
    public void testCopyConstructor() {
        Quaternionf quaternion = new Quaternionf(new Quaternionf(1, 2, 3, 4));
        TestUtilf.assertEquals(quaternion, 1, 2, 3, 4);
    }

    @Test
    public void testGetters() {
        Quaternionf quaternion = new Quaternionf(1, 2, 3, 4);
        TestUtilf.assertEquals(quaternion.getX(), 1);
        TestUtilf.assertEquals(quaternion.getY(), 2);
        TestUtilf.assertEquals(quaternion.getZ(), 3);
        TestUtilf.assertEquals(quaternion.getW(), 4);
    }

    @Test
    public void testQuaternionAddition() {
        Quaternionf quaternion = new Quaternionf(0, 1, 1, 1).add(new Quaternionf(5.5, -0.5, 3.8, 5.5));
        TestUtilf.assertEquals(quaternion, (float) 5.5, (float) 0.5, (float) 4.8, (float) 6.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Quaternionf quaternion = new Quaternionf(0, 1, 1, 1).add(5.5, -0.5, 3.8, 5.5);
        TestUtilf.assertEquals(quaternion, (float) 5.5, (float) 0.5, (float) 4.8, (float) 6.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Quaternionf quaternion = new Quaternionf(0, 1, 1, 1).add(5.5f, -0.5f, 3.8f, 5.5f);
        TestUtilf.assertEquals(quaternion, 5.5f, 0.5f, (float) 4.8, 6.5f);
    }

    @Test
    public void testQuaternionSubtraction() {
        Quaternionf quaternion = new Quaternionf(10, 5, 1, 1).sub(new Quaternionf(9, 4.5, 2, 1));
        TestUtilf.assertEquals(quaternion, 1, (float) 0.5, -1, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Quaternionf quaternion = new Quaternionf(10, 5, 1, 1).sub(9, 4.5, 2, 1);
        TestUtilf.assertEquals(quaternion, 1, (float) 0.5, -1, 0);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Quaternionf quaternion = new Quaternionf(10, 5, 1, 1).sub(9, 4.5f, 2f, 1f);
        TestUtilf.assertEquals(quaternion, 1, 0.5f, -1, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).mul(1.5);
        TestUtilf.assertEquals(quaternion, 3, (float) 4.5, 6, (float) 7.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).mul(1.5f);
        TestUtilf.assertEquals(quaternion, 3, 4.5f, 6, 7.5f);
    }

    @Test
    public void testQuaternionMultiplication() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).mul(new Quaternionf(1, 6, 7, 8));
        TestUtilf.assertEquals(quaternion, 18, 44, 76, -8);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).mul(2d);
        TestUtilf.assertEquals(quaternion, 4, 6, 8, 10);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).mul(2);
        TestUtilf.assertEquals(quaternion, 4, 6, 8, 10);
    }

    @Test
    public void testDoubleFactorDivision() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).div(2d);
        TestUtilf.assertEquals(quaternion, 1, (float) 1.5, 2, (float) 2.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).div(2);
        TestUtilf.assertEquals(quaternion, 1, 1.5f, 2, 2.5f);
    }

    @Test
    public void testQuaternionDivision() {
        Quaternionf quaternion1 = new Quaternionf(7, 3, 1, 9);
        Quaternionf quaternion2 = new Quaternionf(2, 3, 4, 5);
        Quaternionf div = quaternion1.div(quaternion2);
        Quaternionf invMul = quaternion2.invert().mul(quaternion1);
        TestUtilf.assertEquals(div, invMul.getX(), invMul.getY(), invMul.getZ(), invMul.getW());
    }

    @Test
    public void testDoubleComponentsDivision() {
        Quaternionf quaternion1 = new Quaternionf(7, 3, 1, 9);
        Quaternionf quaternion2 = new Quaternionf(2, 3, 4, 5);
        Quaternionf div = quaternion1.div((double) quaternion2.getX(), (double) quaternion2.getY(), (double) quaternion2.getZ(), (double) quaternion2.getW());
        Quaternionf invMul = quaternion2.invert().mul(quaternion1);
        TestUtilf.assertEquals(div, invMul.getX(), invMul.getY(), invMul.getZ(), invMul.getW());
    }

    @Test
    public void testFloatComponentsDivision() {
        Quaternionf quaternion1 = new Quaternionf(7, 3, 1, 9);
        Quaternionf quaternion2 = new Quaternionf(2, 3, 4, 5);
        Quaternionf div = quaternion1.div(quaternion2.getX(), quaternion2.getY(), quaternion2.getZ(), quaternion2.getW());
        Quaternionf invMul = quaternion2.invert().mul(quaternion1);
        TestUtilf.assertEquals(div, invMul.getX(), invMul.getY(), invMul.getZ(), invMul.getW());
    }

    @Test
    public void testQuaternionDotProduct() {
        float f = new Quaternionf(2, 3, 4, 5).dot(new Quaternionf(6, 7, 8, 9));
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        float f = new Quaternionf(2, 3, 4, 5).dot(6d, 7d, 8d, 9d);
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        float f = new Quaternionf(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testDirection() {
        Vector3f vector = new Quaternionf((float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO).getDirection();
        TestUtilf.assertEquals(vector, 0, -1, 0);
    }

    @Test
    public void testAxesAnglesDegrees() {
        Vector3f vector1 = new Quaternionf((float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO).getAxesAngleDeg();
        TestUtilf.assertEquals(vector1, 90, 0, 0);
        Vector3f vector2 = new Quaternionf(0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO).getAxesAngleDeg();
        TestUtilf.assertEquals(vector2, 0, 90, 0);
        Vector3f vector3 = new Quaternionf(0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO).getAxesAngleDeg();
        TestUtilf.assertEquals(vector3, 0, 0, 90);
    }

    @Test
    public void testAxesAnglesRadians() {
        Vector3f vector1 = new Quaternionf((float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesRad();
        TestUtilf.assertEquals(vector1, (float) TrigMath.HALF_PI, 0, 0);
        Vector3f vector2 = new Quaternionf(0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesRad();
        TestUtilf.assertEquals(vector2, 0, (float) TrigMath.HALF_PI, 0);
        Vector3f vector3 = new Quaternionf(0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesRad();
        TestUtilf.assertEquals(vector3, 0, 0, (float) TrigMath.HALF_PI);
    }

    @Test
    public void testConjugate() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).conjugate();
        TestUtilf.assertEquals(quaternion, -2, -3, -4, 5);
    }

    @Test
    public void testInvert() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).invert();
        TestUtilf.assertEquals(quaternion, (float) (-2/54d), (float) (-3/54d), (float) (-4/54d),(float) (5/54d));
    }

    @Test
    public void testLengthSquared() {
        float f = new Quaternionf(2, 3, 4, 5).lengthSquared();
        TestUtilf.assertEquals(f, 54);
    }

    @Test
    public void testLength() {
        float f = new Quaternionf(2, 3, 4, 5).length();
        TestUtilf.assertEquals(f, SQRT54);
    }

    @Test
    public void testNormalize() {
        Quaternionf quaternion = new Quaternionf(2, 3, 4, 5).normalize();
        TestUtilf.assertEquals(quaternion, (float) (2/SQRT54), (float) (3/SQRT54), (float) (4/SQRT54), (float) (5/SQRT54));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Quaternionf(122, 43, 96, 50).equals(new Quaternionf(122, 43, 96, 50)));
        Assert.assertFalse(new Quaternionf(122, 43, 96, 50).equals(new Quaternionf(378, 95, 96, 0)));
    }

    @Test
    public void testComparison() {
        int c1 = new Quaternionf(10, 20, 30, 40).compareTo(new Quaternionf(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new Quaternionf(10, 20, 30, 40).compareTo(new Quaternionf(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new Quaternionf(10, 20, 30, 40).compareTo(new Quaternionf(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
        int c4 = new Quaternionf(0.2, 0.2, 0.2, 0.2).compareTo(new Quaternionf(0.1, 0.1, 0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testCloning() {
        Quaternionf quaternion = new Quaternionf(3, 2, 5, 6);
        Assert.assertEquals(quaternion, quaternion.clone());
    }

    @Test
    public void testCreateFromAxesDoubleAnglesDegrees() {
        Quaternionf quaternion1 = Quaternionf.fromAxesAnglesDeg(90d, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAxesAnglesDeg(0, 90d, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAxesAnglesDeg(0, 0, 90d);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromAxesDoubleAnglesRadians() {
        Quaternionf quaternion1 = Quaternionf.fromAxesAnglesRad(TrigMath.HALF_PI, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAxesAnglesRad(0, TrigMath.HALF_PI, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAxesAnglesRad(0, 0, TrigMath.HALF_PI);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromAxesFloatAnglesDegrees() {
        Quaternionf quaternion1 = Quaternionf.fromAxesAnglesDeg(90, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAxesAnglesDeg(0, 90, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAxesAnglesDeg(0, 0, 90);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromAxesFloatAnglesRadians() {
        Quaternionf quaternion1 = Quaternionf.fromAxesAnglesRad((float) TrigMath.HALF_PI, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAxesAnglesRad(0, (float) TrigMath.HALF_PI, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAxesAnglesRad(0, 0, (float) TrigMath.HALF_PI);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromRotationBetweenTwoVector3() {
        Quaternionf quaternion1 = Quaternionf.fromRotationTo(new Vector3f(0, 1, 0), new Vector3f(0, 0, 1));
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromRotationTo(new Vector3f(0, 0, 1), new Vector3f(1, 0, 0));
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromRotationTo(new Vector3f(1, 0, 0), new Vector3f(0, 1, 0));
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleDegreesVectorAxis() {
        Quaternionf quaternion1 = Quaternionf.fromAngleDegAxis(90d, new Vector3f(1, 0, 0));
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleDegAxis(90d, new Vector3f(0, 1, 0));
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleDegAxis(90d, new Vector3f(0, 0, 1));
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleRadiansVectorAxis() {
        Quaternionf quaternion1 = Quaternionf.fromAngleRadAxis(TrigMath.HALF_PI, new Vector3f(1, 0, 0));
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleRadAxis(TrigMath.HALF_PI, new Vector3f(0, 1, 0));
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleRadAxis(TrigMath.HALF_PI, new Vector3f(0, 0, 1));
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleDegreesVectorAxis() {
        Quaternionf quaternion1 = Quaternionf.fromAngleDegAxis(90, new Vector3f(1, 0, 0));
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleDegAxis(90, new Vector3f(0, 1, 0));
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleDegAxis(90, new Vector3f(0, 0, 1));
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleRadiansVectorAxis() {
        Quaternionf quaternion1 = Quaternionf.fromAngleRadAxis((float) TrigMath.HALF_PI, new Vector3f(1, 0, 0));
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleRadAxis((float) TrigMath.HALF_PI, new Vector3f(0, 1, 0));
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleRadAxis((float) TrigMath.HALF_PI, new Vector3f(0, 0, 1));
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleDegreesAxisDoubleComponents() {
        Quaternionf quaternion1 = Quaternionf.fromAngleDegAxis(90d, 1d, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleDegAxis(90d, 0, 1d, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleDegAxis(90d, 0, 0, 1d);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleRadiansAxisDoubleComponents() {
        Quaternionf quaternion1 = Quaternionf.fromAngleRadAxis(TrigMath.HALF_PI, 1d, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleRadAxis(TrigMath.HALF_PI, 0, 1d, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleRadAxis(TrigMath.HALF_PI, 0, 0, 1d);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleDegreesAxisFloatComponents() {
        Quaternionf quaternion1 = Quaternionf.fromAngleDegAxis(90, 1, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleDegAxis(90, 0, 1, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleDegAxis(90, 0, 0, 1);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleRadiansAxisFloatComponents() {
        Quaternionf quaternion1 = Quaternionf.fromAngleRadAxis((float) TrigMath.HALF_PI, 1, 0, 0);
        TestUtilf.assertEquals(quaternion1, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion2 = Quaternionf.fromAngleRadAxis((float) TrigMath.HALF_PI, 0, 1, 0);
        TestUtilf.assertEquals(quaternion2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        Quaternionf quaternion3 = Quaternionf.fromAngleRadAxis((float) TrigMath.HALF_PI, 0, 0, 1);
        TestUtilf.assertEquals(quaternion3, 0, 0, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    public void testCreateFromRotationMatrix3() {
        final Quaternionf quaternion = Quaternionf.fromAngleDegAxis(45, 1, 1, -1);
        final Matrix3f matrix = Matrix3f.createRotation(quaternion);
        Assert.assertEquals(quaternion, Quaternionf.fromRotationMatrix(matrix));
    }
}
