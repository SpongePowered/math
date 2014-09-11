package com.flowpowered.math.test.imaginary;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2d;

public class ComplexdTest {
    @Test
    public void testDefaultConstructor() {
        Complexd complex = new Complexd();
        TestUtild.assertEquals(complex, 1, 0);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Complexd complex = new Complexd(2d, 3d);
        TestUtild.assertEquals(complex, 2, 3);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Complexd complex = new Complexd(2, 3);
        TestUtild.assertEquals(complex, 2, 3);
    }

    @Test
    public void testCopyConstructor() {
        Complexd complex = new Complexd(new Complexd(2, 3));
        TestUtild.assertEquals(complex, 2, 3);
    }

    @Test
    public void testGetters() {
        Complexd complex = new Complexd(2, 3);
        TestUtild.assertEquals(complex.getX(), 2);
        TestUtild.assertEquals(complex.getY(), 3);
    }

    @Test
    public void testComplexAddition() {
        Complexd vector = new Complexd(0, 1).add(new Complexd(5.5, -0.5));
        TestUtild.assertEquals(vector, (double) 5.5, (double) 0.5);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Complexd complex = new Complexd(0, 1).add(5.5, -0.5);
        TestUtild.assertEquals(complex, (double) 5.5, (double) 0.5);
    }

    @Test
    public void testFloatComponentsAddition() {
        Complexd complex = new Complexd(0, 1).add(5.5f, -0.5f);
        TestUtild.assertEquals(complex, 5.5f, 0.5f);
    }

    @Test
    public void testComplexSubtraction() {
        Complexd complex = new Complexd(10, 5).sub(new Complexd(9f, 4.5));
        TestUtild.assertEquals(complex, 1, (double) 0.5);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Complexd complex = new Complexd(10, 5).sub(9, 4.5);
        TestUtild.assertEquals(complex, 1, (double) 0.5);
    }

    @Test
    public void testFloatComponentsSubtraction() {
        Complexd complex = new Complexd(10, 5).sub(9f, 4.5f);
        TestUtild.assertEquals(complex, 1, 0.5f);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Complexd complex = new Complexd(2, 3).mul(1.5);
        TestUtild.assertEquals(complex, 3, (double) 4.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Complexd complex = new Complexd(2, 3).mul(1.5f);
        TestUtild.assertEquals(complex, 3, 4.5f);
    }

    @Test
    public void testComplexMultiplication() {
        Complexd complex = new Complexd(2, 3).mul(new Complexd(6, 9));
        TestUtild.assertEquals(complex, -15, 36);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Complexd complex = new Complexd(2, 3).mul(6d, 9d);
        TestUtild.assertEquals(complex, -15, 36);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        Complexd complex = new Complexd(2, 3).mul(6, 9);
        TestUtild.assertEquals(complex, -15, 36);
    }

    @Test
    public void testDoubleFactorDivision() {
        Complexd complex = new Complexd(2, 3).div(2d);
        TestUtild.assertEquals(complex, 1, (double) 1.5);
    }

    @Test
    public void testFloatFactorDivision() {
        Complexd complex = new Complexd(2, 3).div(2);
        TestUtild.assertEquals(complex, 1, (double) 1.5);
    }

    @Test
    public void testComplexDivision() {
        Complexd complex1 = new Complexd(7, 3);
        Complexd complex2 = new Complexd(2, 5);
        Complexd div = complex1.div(complex2);
        Complexd invMul = complex1.mul(complex2.invert());
        TestUtild.assertEquals(div, invMul.getX(), invMul.getY());
    }

    @Test
    public void testDoubleComponentsDivision() {
        Complexd complex1 = new Complexd(7, 3);
        Complexd complex2 = new Complexd(2, 5);
        Complexd div = complex1.div((double) complex2.getX(), (double) complex2.getY());
        Complexd invMul = complex1.mul(complex2.invert());
        TestUtild.assertEquals(div, invMul.getX(), invMul.getY());
    }

    @Test
    public void testFloatComponentsDivision() {
        Complexd complex1 = new Complexd(7, 3);
        Complexd complex2 = new Complexd(2, 5);
        Complexd div = complex1.div(complex2.getX(), complex2.getY());
        Complexd invMul = complex1.mul(complex2.invert());
        TestUtild.assertEquals(div, invMul.getX(), invMul.getY());
    }

    @Test
    public void testComplexDotProduct() {
        double f = new Complexd(2, 3).dot(new Complexd(4, 5));
        TestUtild.assertEquals(f, 23);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        double f = new Complexd(2, 3).dot(4d, 5d);
        TestUtild.assertEquals(f, 23);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        double f = new Complexd(2, 3).dot(4, 5);
        TestUtild.assertEquals(f, 23);
    }

    @Test
    public void testDirection() {
        Vector2d vector = new Complexd(4, 3).getDirection();
        TestUtild.assertEquals(vector, (double) 0.8, (double) 0.6);
    }

    @Test
    public void testAngleRadians() {
        double f = new Complexd((double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO).getAngleRad();
        TestUtild.assertEquals(f, (double) TrigMath.QUARTER_PI);
    }

    @Test
    public void testAngleDegrees() {
        double f = new Complexd((double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO).getAngleDeg();
        TestUtild.assertEquals(f, 45);
    }

    @Test
    public void testConjugate() {
        Complexd complex = new Complexd(2, 3).conjugate();
        TestUtild.assertEquals(complex, 2, -3);
    }

    @Test
    public void testInvert() {
        Complexd complex = new Complexd(2, 3).invert();
        TestUtild.assertEquals(complex, (double) (2/13d), (double) (-3/13d));
    }

    @Test
    public void testLengthSquared() {
        double f = new Complexd(3, 4).lengthSquared();
        TestUtild.assertEquals(f, 25);
    }

    @Test
    public void testLength() {
        double f = new Complexd(3, 4).length();
        TestUtild.assertEquals(f, 5);
    }

    @Test
    public void testNormalize() {
        Complexd complex = new Complexd(3, 4).normalize();
        TestUtild.assertEquals(complex, (double) 0.6, (double) 0.8);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Complexd(122, 43).equals(new Complexd(122, 43)));
        Assert.assertFalse(new Complexd(122, 43).equals(new Complexd(378, 95)));
    }

    @Test
    public void testComparison() {
        int c1 = new Complexd(10, 20).compareTo(new Complexd(20, 20));
        Assert.assertTrue(c1 < 0);
        int c2 = new Complexd(10, 20).compareTo(new Complexd(10, 20));
        Assert.assertTrue(c2 == 0);
        int c3 = new Complexd(10, 20).compareTo(new Complexd(10, 10));
        Assert.assertTrue(c3 > 0);
        int c4 = new Complexd(0.2, 0.2).compareTo(new Complexd(0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testCloning() {
        Complexd complex = new Complexd(3, 2);
        Assert.assertEquals(complex, complex.clone());
    }

    @Test
    public void testCreateFromRotationBetweenTwoVector2() {
        Complexd complex = Complexd.fromRotationTo(new Vector2d(0, 1), new Vector2d(-1, 0));
        TestUtild.assertEquals(complex, 0, 1);
    }

    @Test
    public void testCreateFromDoubleAngleDegrees() {
        Complexd complex = Complexd.fromAngleDeg(45d);
        TestUtild.assertEquals(complex, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleDegrees() {
        Complexd complex = Complexd.fromAngleDeg(45);
        TestUtild.assertEquals(complex, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromDoubleAngleRadians() {
        Complexd complex = Complexd.fromAngleRad(TrigMath.QUARTER_PI);
        TestUtild.assertEquals(complex, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testCreateFromFloatAngleRadians() {
        Complexd complex = Complexd.fromAngleRad((double) TrigMath.QUARTER_PI);
        TestUtild.assertEquals(complex, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO);
    }
}
