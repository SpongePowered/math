package com.flowpowered.math.test.imaginary;

import static com.flowpowered.math.test.TestUtild.SQRT54;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix3d;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector3d;

public class QuaterniondTest {
    @Test
    public void testDefaultConstructor() {
        Quaterniond quaternion = new Quaterniond();
        TestUtild.assertEquals(quaternion, 0, 0, 0, 1);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Quaterniond quaternion = new Quaterniond(1d, 2d, 3d, 4d);
        TestUtild.assertEquals(quaternion, 1, 2, 3, 4);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Quaterniond quaternion = new Quaterniond(1, 2, 3, 4);
        TestUtild.assertEquals(quaternion, 1, 2, 3, 4);
    }

    @Test
    public void testCopyConstructor() {
        Quaterniond quaternion = new Quaterniond(new Quaterniond(1, 2, 3, 4));
        TestUtild.assertEquals(quaternion, 1, 2, 3, 4);
    }

    @Test
    public void testGetters() {
        Quaterniond quaternion = new Quaterniond(1, 2, 3, 4);
        TestUtild.assertEquals(quaternion.getX(), 1);
        TestUtild.assertEquals(quaternion.getY(), 2);
        TestUtild.assertEquals(quaternion.getZ(), 3);
        TestUtild.assertEquals(quaternion.getW(), 4);
    }

    @Test
    public void testQuaternionAddition() {
        Quaterniond quaternion = new Quaterniond(0, 1, 1, 1).add(new Quaterniond(5.5, -0.5, 3.8, 5.5));
        TestUtild.assertEquals(quaternion, (double) 5.5, (double) 0.5, (double) 4.8, (double) 6.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Quaterniond quaternion = new Quaterniond(0, 1, 1, 1).add(5.5, -0.5, 3.8, 5.5);
        TestUtild.assertEquals(quaternion, (double) 5.5, (double) 0.5, (double) 4.8, (double) 6.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Quaterniond quaternion = new Quaterniond(0, 1, 1, 1).add(5.5f, -0.5f, 3.8f, 5.5f);
        TestUtild.assertEquals(quaternion, 5.5f, 0.5f, (double) 4.8, 6.5f);
    }

    @Test
    public void testQuaternionSubtraction() {
        Quaterniond quaternion = new Quaterniond(10, 5, 1, 1).sub(new Quaterniond(9, 4.5, 2, 1));
        TestUtild.assertEquals(quaternion, 1, (double) 0.5, -1, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Quaterniond quaternion = new Quaterniond(10, 5, 1, 1).sub(9, 4.5, 2, 1);
        TestUtild.assertEquals(quaternion, 1, (double) 0.5, -1, 0);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Quaterniond quaternion = new Quaterniond(10, 5, 1, 1).sub(9, 4.5f, 2f, 1f);
        TestUtild.assertEquals(quaternion, 1, 0.5f, -1, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).mul(1.5);
        TestUtild.assertEquals(quaternion, 3, (double) 4.5, 6, (double) 7.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).mul(1.5f);
        TestUtild.assertEquals(quaternion, 3, 4.5f, 6, 7.5f);
    }

    @Test
    public void testQuaternionMultiplication() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).mul(new Quaterniond(1, 6, 7, 8));
        TestUtild.assertEquals(quaternion, 18, 44, 76, -8);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).mul(2d);
        TestUtild.assertEquals(quaternion, 4, 6, 8, 10);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).mul(2);
        TestUtild.assertEquals(quaternion, 4, 6, 8, 10);
    }

    @Test
    public void testDoubleFactorDivision() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).div(2d);
        TestUtild.assertEquals(quaternion, 1, (double) 1.5, 2, (double) 2.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).div(2);
        TestUtild.assertEquals(quaternion, 1, 1.5f, 2, 2.5f);
    }

    @Test
    public void testQuaternionDivision() {
        Quaterniond quaternion1 = new Quaterniond(7, 3, 1, 9);
        Quaterniond quaternion2 = new Quaterniond(2, 3, 4, 5);
        Quaterniond div = quaternion1.div(quaternion2);
        Quaterniond invMul = quaternion2.invert().mul(quaternion1);
        TestUtild.assertEquals(div, invMul.getX(), invMul.getY(), invMul.getZ(), invMul.getW());
    }

    @Test
    public void testDoubleComponentsDivision() {
        Quaterniond quaternion1 = new Quaterniond(7, 3, 1, 9);
        Quaterniond quaternion2 = new Quaterniond(2, 3, 4, 5);
        Quaterniond div = quaternion1.div((double) quaternion2.getX(), (double) quaternion2.getY(), (double) quaternion2.getZ(), (double) quaternion2.getW());
        Quaterniond invMul = quaternion2.invert().mul(quaternion1);
        TestUtild.assertEquals(div, invMul.getX(), invMul.getY(), invMul.getZ(), invMul.getW());
    }

    @Test
    public void testFloatComponentsDivision() {
        Quaterniond quaternion1 = new Quaterniond(7, 3, 1, 9);
        Quaterniond quaternion2 = new Quaterniond(2, 3, 4, 5);
        Quaterniond div = quaternion1.div(quaternion2.getX(), quaternion2.getY(), quaternion2.getZ(), quaternion2.getW());
        Quaterniond invMul = quaternion2.invert().mul(quaternion1);
        TestUtild.assertEquals(div, invMul.getX(), invMul.getY(), invMul.getZ(), invMul.getW());
    }

    @Test
    public void testQuaternionDotProduct() {
        double f = new Quaterniond(2, 3, 4, 5).dot(new Quaterniond(6, 7, 8, 9));
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        double f = new Quaterniond(2, 3, 4, 5).dot(6d, 7d, 8d, 9d);
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        double f = new Quaterniond(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testDirection() {
        Vector3d vector = new Quaterniond((double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO).getDirection();
        TestUtild.assertEquals(vector, 0, -1, 0);
    }

    @Test
    public void testAxesAnglesDegrees() {
        Vector3d vector1 = new Quaterniond((double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesDeg();
        TestUtild.assertEquals(vector1, 90, 0, 0);
        Vector3d vector2 = new Quaterniond(0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesDeg();
        TestUtild.assertEquals(vector2, 0, 90, 0);
        Vector3d vector3 = new Quaterniond(0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesDeg();
        TestUtild.assertEquals(vector3, 0, 0, 90);
    }

    @Test
    public void testAxesAnglesRadians() {
        Vector3d vector1 = new Quaterniond((double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesRad();
        TestUtild.assertEquals(vector1, (double) TrigMath.HALF_PI, 0, 0);
        Vector3d vector2 = new Quaterniond(0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesRad();
        TestUtild.assertEquals(vector2, 0, (double) TrigMath.HALF_PI, 0);
        Vector3d vector3 = new Quaterniond(0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO).getAxesAnglesRad();
        TestUtild.assertEquals(vector3, 0, 0, (double) TrigMath.HALF_PI);
    }

    @Test
    public void testConjugate() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).conjugate();
        TestUtild.assertEquals(quaternion, -2, -3, -4, 5);
    }

    @Test
    public void testInvert() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).invert();
        TestUtild.assertEquals(quaternion, (double) (-2/54d), (double) (-3/54d), (double) (-4/54d),(double) (5/54d));
        try {
            Quaterniond.ZERO.invert();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testLengthSquared() {
        double f = new Quaterniond(2, 3, 4, 5).lengthSquared();
        TestUtild.assertEquals(f, 54);
    }

    @Test
    public void testLength() {
        double f = new Quaterniond(2, 3, 4, 5).length();
        TestUtild.assertEquals(f, SQRT54);
    }

    @Test
    public void testNormalize() {
        Quaterniond quaternion = new Quaterniond(2, 3, 4, 5).normalize();
        TestUtild.assertEquals(quaternion, (double) (2/SQRT54), (double) (3/SQRT54), (double) (4/SQRT54), (double) (5/SQRT54));
        try {
            Quaterniond.ZERO.normalize();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Quaterniond(122, 43, 96, 50).equals(new Quaterniond(122, 43, 96, 50)));
        Assert.assertFalse(new Quaterniond(122, 43, 96, 50).equals(new Quaterniond(378, 95, 96, 0)));
    }

    @Test
    public void testComparison() {
        int c1 = new Quaterniond(10, 20, 30, 40).compareTo(new Quaterniond(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new Quaterniond(10, 20, 30, 40).compareTo(new Quaterniond(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new Quaterniond(10, 20, 30, 40).compareTo(new Quaterniond(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
        int c4 = new Quaterniond(0.2, 0.2, 0.2, 0.2).compareTo(new Quaterniond(0.1, 0.1, 0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testCloning() {
        Quaterniond quaternion = new Quaterniond(3, 2, 5, 6);
        Assert.assertEquals(quaternion, quaternion.clone());
    }

    @Test
    public void testCreateFromAxesDoubleAnglesDegrees() {
        Quaterniond quaternion1 = Quaterniond.fromAxesAnglesDeg(90d, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAxesAnglesDeg(0, 90d, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAxesAnglesDeg(0, 0, 90d);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromAxesDoubleAnglesRadians() {
        Quaterniond quaternion1 = Quaterniond.fromAxesAnglesRad(TrigMath.HALF_PI, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAxesAnglesRad(0, TrigMath.HALF_PI, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAxesAnglesRad(0, 0, TrigMath.HALF_PI);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromAxesFloatAnglesDegrees() {
        Quaterniond quaternion1 = Quaterniond.fromAxesAnglesDeg(90, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAxesAnglesDeg(0, 90, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAxesAnglesDeg(0, 0, 90);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromAxesFloatAnglesRadians() {
        Quaterniond quaternion1 = Quaterniond.fromAxesAnglesRad((double) TrigMath.HALF_PI, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAxesAnglesRad(0, (double) TrigMath.HALF_PI, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAxesAnglesRad(0, 0, (double) TrigMath.HALF_PI);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromRotationBetweenTwoVector3() {
        Quaterniond quaternion1 = Quaterniond.fromRotationTo(new Vector3d(0, 1, 0), new Vector3d(0, 0, 1));
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromRotationTo(new Vector3d(0, 0, 1), new Vector3d(1, 0, 0));
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromRotationTo(new Vector3d(1, 0, 0), new Vector3d(0, 1, 0));
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleDegreesVectorAxis() {
        Quaterniond quaternion1 = Quaterniond.fromAngleDegAxis(90d, new Vector3d(1, 0, 0));
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleDegAxis(90d, new Vector3d(0, 1, 0));
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleDegAxis(90d, new Vector3d(0, 0, 1));
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleRadiansVectorAxis() {
        Quaterniond quaternion1 = Quaterniond.fromAngleRadAxis(TrigMath.HALF_PI, new Vector3d(1, 0, 0));
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleRadAxis(TrigMath.HALF_PI, new Vector3d(0, 1, 0));
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleRadAxis(TrigMath.HALF_PI, new Vector3d(0, 0, 1));
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleDegreesVectorAxis() {
        Quaterniond quaternion1 = Quaterniond.fromAngleDegAxis(90, new Vector3d(1, 0, 0));
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleDegAxis(90, new Vector3d(0, 1, 0));
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleDegAxis(90, new Vector3d(0, 0, 1));
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleRadiansVectorAxis() {
        Quaterniond quaternion1 = Quaterniond.fromAngleRadAxis((double) TrigMath.HALF_PI, new Vector3d(1, 0, 0));
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleRadAxis((double) TrigMath.HALF_PI, new Vector3d(0, 1, 0));
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleRadAxis((double) TrigMath.HALF_PI, new Vector3d(0, 0, 1));
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleDegreesAxisDoubleComponents() {
        Quaterniond quaternion1 = Quaterniond.fromAngleDegAxis(90d, 1d, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleDegAxis(90d, 0, 1d, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleDegAxis(90d, 0, 0, 1d);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleRadiansAxisDoubleComponents() {
        Quaterniond quaternion1 = Quaterniond.fromAngleRadAxis(TrigMath.HALF_PI, 1d, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleRadAxis(TrigMath.HALF_PI, 0, 1d, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleRadAxis(TrigMath.HALF_PI, 0, 0, 1d);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleDegreesAxisFloatComponents() {
        Quaterniond quaternion1 = Quaterniond.fromAngleDegAxis(90, 1, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleDegAxis(90, 0, 1, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleDegAxis(90, 0, 0, 1);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleRadiansAxisFloatComponents() {
        Quaterniond quaternion1 = Quaterniond.fromAngleRadAxis((double) TrigMath.HALF_PI, 1, 0, 0);
        TestUtild.assertEquals(quaternion1, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion2 = Quaterniond.fromAngleRadAxis((double) TrigMath.HALF_PI, 0, 1, 0);
        TestUtild.assertEquals(quaternion2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
        Quaterniond quaternion3 = Quaterniond.fromAngleRadAxis((double) TrigMath.HALF_PI, 0, 0, 1);
        TestUtild.assertEquals(quaternion3, 0, 0, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    public void testCreateFromRotationMatrix3() {
        final Quaterniond quaternion = Quaterniond.fromAngleDegAxis(45, 1, 1, -1);
        final Matrix3d matrix = Matrix3d.createRotation(quaternion);
        Assert.assertEquals(quaternion, Quaterniond.fromRotationMatrix(matrix));
    }
}
