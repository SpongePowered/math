package com.flowpowered.math.test.imaginary;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector2f;

public class ComplexfTest {
    @Test
    public void testDefaultConstructor() {
        Complexf complex = new Complexf();
        TestUtilf.assertEquals(complex, 1, 0);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Complexf complex = new Complexf(2d, 3d);
        TestUtilf.assertEquals(complex, 2, 3);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Complexf complex = new Complexf(2, 3);
        TestUtilf.assertEquals(complex, 2, 3);
    }

    @Test
    public void testCopyConstructor() {
        Complexf complex = new Complexf(new Complexf(2, 3));
        TestUtilf.assertEquals(complex, 2, 3);
    }

    @Test
    public void testGetters() {
        Complexf complex = new Complexf(2, 3);
        TestUtilf.assertEquals(complex.getX(), 2);
        TestUtilf.assertEquals(complex.getY(), 3);
    }

    @Test
    public void testComplexAddition() {
        Complexf vector = new Complexf(0, 1).add(new Complexf(5.5, -0.5));
        TestUtilf.assertEquals(vector, (float) 5.5, (float) 0.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Complexf complex = new Complexf(0, 1).add(5.5, -0.5);
        TestUtilf.assertEquals(complex, (float) 5.5, (float) 0.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Complexf complex = new Complexf(0, 1).add(5.5f, -0.5f);
        TestUtilf.assertEquals(complex, 5.5f, 0.5f);
    }

    @Test
    public void testComplexSubtraction() {
        Complexf complex = new Complexf(10, 5).sub(new Complexf(9f, 4.5));
        TestUtilf.assertEquals(complex, 1, (float) 0.5);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Complexf complex = new Complexf(10, 5).sub(9, 4.5);
        TestUtilf.assertEquals(complex, 1, (float) 0.5);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Complexf complex = new Complexf(10, 5).sub(9f, 4.5f);
        TestUtilf.assertEquals(complex, 1, 0.5f);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Complexf complex = new Complexf(2, 3).mul(1.5);
        TestUtilf.assertEquals(complex, 3, (float) 4.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Complexf complex = new Complexf(2, 3).mul(1.5f);
        TestUtilf.assertEquals(complex, 3, 4.5f);
    }

    @Test
    public void testComplexMultiplication() {
        Complexf complex = new Complexf(2, 3).mul(new Complexf(6, 9));
        TestUtilf.assertEquals(complex, -15, 36);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Complexf complex = new Complexf(2, 3).mul(6d, 9d);
        TestUtilf.assertEquals(complex, -15, 36);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Complexf complex = new Complexf(2, 3).mul(6, 9);
        TestUtilf.assertEquals(complex, -15, 36);
    }

    @Test
    public void testDoubleFactorDivision() {
        Complexf complex = new Complexf(2, 3).div(2d);
        TestUtilf.assertEquals(complex, 1, (float) 1.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Complexf complex = new Complexf(2, 3).div(2);
        TestUtilf.assertEquals(complex, 1, (float) 1.5);
    }

    @Test
    public void testComplexDivision() {
        Complexf complex1 = new Complexf(7, 3);
        Complexf complex2 = new Complexf(2, 5);
        Complexf div = complex1.div(complex2);
        Complexf invMul = complex1.mul(complex2.invert());
        TestUtilf.assertEquals(div, invMul.getX(), invMul.getY());
    }

    @Test
    public void testDoubleComponentsDivision() {
        Complexf complex1 = new Complexf(7, 3);
        Complexf complex2 = new Complexf(2, 5);
        Complexf div = complex1.div((double) complex2.getX(), (double) complex2.getY());
        Complexf invMul = complex1.mul(complex2.invert());
        TestUtilf.assertEquals(div, invMul.getX(), invMul.getY());
    }

    @Test
    public void testFloatComponentsDivision() {
        Complexf complex1 = new Complexf(7, 3);
        Complexf complex2 = new Complexf(2, 5);
        Complexf div = complex1.div(complex2.getX(), complex2.getY());
        Complexf invMul = complex1.mul(complex2.invert());
        TestUtilf.assertEquals(div, invMul.getX(), invMul.getY());
    }

    @Test
    public void testComplexDotProduct() {
        float f = new Complexf(2, 3).dot(new Complexf(4, 5));
        TestUtilf.assertEquals(f, 23);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        float f = new Complexf(2, 3).dot(4d, 5d);
        TestUtilf.assertEquals(f, 23);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        float f = new Complexf(2, 3).dot(4, 5);
        TestUtilf.assertEquals(f, 23);
    }

    @Test
    public void testDirection() {
        Vector2f vector = new Complexf(4, 3).getDirection();
        TestUtilf.assertEquals(vector, (float) 0.8, (float) 0.6);
    }

    @Test
    public void testAngleRadians() {
        float f = new Complexf((float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO).getAngleRad();
        TestUtilf.assertEquals(f, (float) TrigMath.QUARTER_PI);
    }

    @Test
    public void testAngleDegrees() {
        float f = new Complexf((float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO).getAngleDeg();
        TestUtilf.assertEquals(f, 45);
    }

    @Test
    public void testConjugate() {
        Complexf complex = new Complexf(2, 3).conjugate();
        TestUtilf.assertEquals(complex, 2, -3);
    }

    @Test
    public void testInvert() {
        Complexf complex = new Complexf(2, 3).invert();
        TestUtilf.assertEquals(complex, (float) (2/13d), (float) (-3/13d));
    }

    @Test
    public void testLengthSquared() {
        float f = new Complexf(3, 4).lengthSquared();
        TestUtilf.assertEquals(f, 25);
    }

    @Test
    public void testLength() {
        float f = new Complexf(3, 4).length();
        TestUtilf.assertEquals(f, 5);
    }

    @Test
    public void testNormalize() {
        Complexf complex = new Complexf(3, 4).normalize();
        TestUtilf.assertEquals(complex, (float) 0.6, (float) 0.8);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Complexf(122, 43).equals(new Complexf(122, 43)));
        Assert.assertFalse(new Complexf(122, 43).equals(new Complexf(378, 95)));
    }

    @Test
    public void testComparison() {
        int c1 = new Complexf(10, 20).compareTo(new Complexf(20, 20));
        Assert.assertTrue(c1 < 0);
        int c2 = new Complexf(10, 20).compareTo(new Complexf(10, 20));
        Assert.assertTrue(c2 == 0);
        int c3 = new Complexf(10, 20).compareTo(new Complexf(10, 10));
        Assert.assertTrue(c3 > 0);
        int c4 = new Complexf(0.2, 0.2).compareTo(new Complexf(0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testCloning() {
        Complexf complex = new Complexf(3, 2);
        Assert.assertEquals(complex, complex.clone());
    }

    @Test
    public void testCreateFromRotationBetweenTwoVector2() {
        Complexf complex = Complexf.fromRotationTo(new Vector2f(0, 1), new Vector2f(-1, 0));
        TestUtilf.assertEquals(complex, 0, 1);
    }

    @Test
    public void testCreateFromDoubleAngleDegrees() {
        Complexf complex = Complexf.fromAngleDeg(45d);
        TestUtilf.assertEquals(complex, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleDegrees() {
        Complexf complex = Complexf.fromAngleDeg(45);
        TestUtilf.assertEquals(complex, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleRadians() {
        Complexf complex = Complexf.fromAngleRad(TrigMath.QUARTER_PI);
        TestUtilf.assertEquals(complex, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleRadians() {
        Complexf complex = Complexf.fromAngleRad((float) TrigMath.QUARTER_PI);
        TestUtilf.assertEquals(complex, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }
}
