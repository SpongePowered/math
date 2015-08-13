package com.flowpowered.math.test.vector;

import static org.junit.Assert.assertEquals;
import static com.flowpowered.math.test.TestUtilf.SQRT5;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;
import com.flowpowered.math.vector.VectorNf;

public class VectorNfTest {
    @Test
    public void testSizeConstructor() {
        VectorNf vector = new VectorNf(5);
        TestUtilf.assertEquals(vector, 0, 0, 0, 0, 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        VectorNf vector = new VectorNf(new Vector2f(0, 1));
        TestUtilf.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        VectorNf vector = new VectorNf(new Vector3f(0, 1, 2));
        TestUtilf.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        VectorNf vector = new VectorNf(new Vector4f(0, 1, 2, 3));
        TestUtilf.assertEquals(vector, 0, 1, 2, 3);
    }

    @Test
    public void testCopyVectorNConstructor() {
        VectorNf vector = new VectorNf(new VectorNf(0, 1, 2, 3, 4, 5));
        TestUtilf.assertEquals(vector, 0, 1, 2, 3, 4, 5);
    }

    @Test
    public void testComponentsConstructor() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5);
        TestUtilf.assertEquals(vector, 0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5);
    }

    @Test
    public void testSize() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5);
        assertEquals(vector.size(), 6);
    }

    @Test
    public void testGetter() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5);
        TestUtilf.assertEquals(vector.get(0), 0);
        TestUtilf.assertEquals(vector.get(1), (float) 1.1);
        TestUtilf.assertEquals(vector.get(2), (float) 2.2);
        TestUtilf.assertEquals(vector.get(3), (float) 3.3);
        TestUtilf.assertEquals(vector.get(4), (float) 4.4);
        TestUtilf.assertEquals(vector.get(5), (float) 5.5);
    }

    @Test
    public void testFlooredGetter() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5, (float) -6.6);
        TestUtilf.assertEquals(vector.getFloored(0), 0);
        TestUtilf.assertEquals(vector.getFloored(1), 1);
        TestUtilf.assertEquals(vector.getFloored(2), 2);
        TestUtilf.assertEquals(vector.getFloored(3), 3);
        TestUtilf.assertEquals(vector.getFloored(4), 4);
        TestUtilf.assertEquals(vector.getFloored(5), 5);
        TestUtilf.assertEquals(vector.getFloored(6), -7);
    }

    @Test
    public void testSetterFloatValue() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5);
        vector.set(0, (float) 6.6);
        TestUtilf.assertEquals(vector.get(0), (float) 6.6);
    }

    @Test
    public void testSetZero() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2);
        vector.setZero();
        TestUtilf.assertEquals(vector.get(0), 0);
        TestUtilf.assertEquals(vector.get(1), 0);
        TestUtilf.assertEquals(vector.get(2), 0);
    }

    @Test
    public void testResize() {
        VectorNf vector1 = new VectorNf(0, (float) 1.1, (float) 2.2);
        VectorNf resize1 = vector1.resize(2);
        TestUtilf.assertEquals(resize1.size(), 2);
        VectorNf vector2 = new VectorNf(0, (float) 1.1, (float) 2.2);
        VectorNf resize2 = vector2.resize(4);
        TestUtilf.assertEquals(resize2.size(), 4);
        TestUtilf.assertEquals(resize2.get(3), 0);
    }

    @Test
    public void testVectorNAddition() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5).add(new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5));
        TestUtilf.assertEquals(vector, 0, (float) 2.2, (float) 4.4, (float) 6.6, (float) 8.8, 11);
    }

    @Test
    public void testVectorNSubtraction() {
        VectorNf vector = new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5).sub(new VectorNf(0, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5));
        TestUtilf.assertEquals(vector, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        VectorNf vector = new VectorNf((float) 0.1, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5).mul(2d);
        TestUtilf.assertEquals(vector, (float) 0.2, (float) 2.2, (float) 4.4, (float) 6.6, (float) 8.8, 11);
    }

    @Test
    public void testFloatFactorMultiplication() {
        VectorNf vector = new VectorNf((float) 0.1, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5).mul(2);
        TestUtilf.assertEquals(vector, 0.2f, 2.2f, (float) 4.4, (float) 6.6, (float) 8.8, 11f);
    }

    @Test
    public void testVectorNMultiplication() {
        VectorNf vector = new VectorNf((float) 0.1, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5).mul(new VectorNf(1, 2, 3, 4, 5, 6));
        TestUtilf.assertEquals(vector, (float) 0.1, (float) 2.2, (float) 6.6, (float) 13.2, 22, 33);
    }

    @Test
    public void testFloatComponentsMultiplication() {
        VectorNf vector = new VectorNf((float) 0.1, (float) 1.1, (float) 2.2, (float) 3.3, (float) 4.4, (float) 5.5).mul(2, 2, 3, 3, 4, 4);
        TestUtilf.assertEquals(vector, (float) 0.2, (float) 2.2, (float) 6.6, (float) 9.9, (float) 17.6, 22);
    }

    @Test
    public void testDoubleFactorDivision() {
        VectorNf vector = new VectorNf(1, 2, 3, 4, 5, 6).div(2d);
        TestUtilf.assertEquals(vector, (float) 0.5, 1, (float) 1.5, 2, (float) 2.5, 3);
    }

    @Test
    public void testFloatFactorDivision() {
        VectorNf vector = new VectorNf(1, 2, 3, 4, 5, 6).div(2);
        TestUtilf.assertEquals(vector, 0.5f, 1, 1.5f, 2, 2.5f, 3);
    }

    @Test
    public void testVectorNDivision() {
        VectorNf vector = new VectorNf(1, 2, 3, 4, 5, 6).div(new VectorNf(2, 1, (float) 0.5, 8, 4, 6));
        TestUtilf.assertEquals(vector, (float) 0.5, 2, 6, (float) 0.5, (float) 1.25, 1);
    }

    @Test
    public void testFloatComponentsDivision() {
        VectorNf vector = new VectorNf(1, 2, 3, 4, 5, 6).div(2, 1, (float) 0.5, 8, 4, 6);
        TestUtilf.assertEquals(vector, (float) 0.5, 2, 6, (float) 0.5, (float) 1.25, 1);
    }

    @Test
    public void testVectorNDotProduct() {
        float f = new VectorNf(2, 3, 4, 5).dot(new VectorNf(6, 7, 8, 9));
        TestUtilf.assertEquals(f, 110);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        float f = new VectorNf(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtilf.assertEquals(f, 110f);
    }

    @Test
    public void testVectorNProject() {
        VectorNf vector = new VectorNf(2, 3, 4, 5).project(new VectorNf(1, 1, 1, 1));
        TestUtilf.assertEquals(vector, (float) 3.5, (float) 3.5, (float) 3.5, (float) 3.5);
    }

    @Test
    public void testFloatComponentsProject() {
        VectorNf vector = new VectorNf(2, 3, 4, 5).project(1, 1, 1, 1);
        TestUtilf.assertEquals(vector, (float) 3.5, (float) 3.5, (float) 3.5, (float) 3.5);
    }

    @Test
    public void testRaiseToDoublePower() {
        VectorNf vector = new VectorNf(2, 6, 8, (float) 5.5).pow(2d);
        TestUtilf.assertEquals(vector, 4, 36, 64, (float) 30.25);
    }

    @Test
    public void testRaiseToFloatPower() {
        VectorNf vector = new VectorNf(2, 6, 8, (float) 5.5).pow(2);
        TestUtilf.assertEquals(vector, 4, 36, 64, 30.25f);
    }

    @Test
    public void testCeiling() {
        VectorNf vector = new VectorNf((float) 2.5, (float) 6.7, (float) 7.9, (float) 8.1).ceil();
        TestUtilf.assertEquals(vector, 3, 7, 8, 9);
    }

    @Test
    public void testFloor() {
        VectorNf vector = new VectorNf((float) 2.5, (float) 6.7, (float) 7.8, (float) 9.1).floor();
        TestUtilf.assertEquals(vector, 2, 6, 7, 9);
    }

    @Test
    public void testRound() {
        VectorNf vector = new VectorNf((float) 2.2, (float) 6.7, (float) 7.8, (float) 9.1).round();
        TestUtilf.assertEquals(vector, 2, 7, 8, 9);
    }

    @Test
    public void testAbsolute() {
        VectorNf vector1 = new VectorNf((float) -2.5, (float) -6.7, (float) -55, 0).abs();
        TestUtilf.assertEquals(vector1, (float) 2.5, (float) 6.7, 55, 0);
        VectorNf vector2 = new VectorNf((float) 2.5, (float) 6.7, 55, 0).abs();
        TestUtilf.assertEquals(vector2, (float) 2.5, (float) 6.7, 55, 0);
    }

    @Test
    public void testNegate() {
        VectorNf vector = new VectorNf((float) 2.2, (float) -6.7, (float) 15.8, 20).negate();
        TestUtilf.assertEquals(vector, (float) -2.2, (float) 6.7, (float) -15.8, -20);
    }

    @Test
    public void testVectorNMinimum() {
        VectorNf vector = new VectorNf(2, 6, -1, 0).min(new VectorNf(3, 4, 10, -1));
        TestUtilf.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testFloatComponentsMinimum() {
        VectorNf vector = new VectorNf(2, 6, -1, 0).min(3, 4, 10, (float) -1.1);
        TestUtilf.assertEquals(vector, 2, 4, -1, (float) -1.1);
    }

    @Test
    public void testVectorNMaximum() {
        VectorNf vector = new VectorNf(2, 6, -1, 0).max(new VectorNf(3, 4, 10, -1));
        TestUtilf.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testFloatComponentsMaximum() {
        VectorNf vector = new VectorNf(2, 6, -1, 0).max(3, 4, 10, (float) -1.1);
        TestUtilf.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testVectorNDistanceSquared() {
        float f = new VectorNf(2, 3, 4).distanceSquared(new VectorNf(5, 6, 7));
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        float f = new VectorNf(2, 3, 4, 5).distanceSquared(5, 6, 7, 5);
        TestUtilf.assertEquals(f, 27);
    }

    @Test
    public void testVectorNDistance() {
        float f = new VectorNf(0, 2, 4, 8).distance(new VectorNf(0, 8, 16, 8));
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testFloatComponentsDistance() {
        float f = new VectorNf(0, 2, 4, 8).distance(0, 8, 16, 8);
        TestUtilf.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testLength() {
        float f = new VectorNf(3, 4, 5, 6).length();
        TestUtilf.assertEquals(f, (float) Math.sqrt(86));
    }

    @Test
    public void testLengthSquared() {
        float f = new VectorNf(3, 4, 5, 6).lengthSquared();
        TestUtilf.assertEquals(f, 86);
    }

    @Test
    public void testNormalize() {
        VectorNf v1 = new VectorNf(1, 1, 0, 0).normalize();
        TestUtilf.assertEquals(v1, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO, 0, 0);
        VectorNf v2 = new VectorNf(0, 1, 0, 1).normalize();
        TestUtilf.assertEquals(v2, 0, (float) TrigMath.HALF_SQRT_OF_TWO, 0, (float) TrigMath.HALF_SQRT_OF_TWO);
        try {
            VectorNf.ZERO_3.normalize();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testGetMinAxis() {
        VectorNf vector1 = new VectorNf(1, 2, 3, 4);
        TestUtilf.assertEquals(vector1.getMinAxis(), 0);
        VectorNf vector2 = new VectorNf(2, 1, 3, 4);
        TestUtilf.assertEquals(vector2.getMinAxis(), 1);
        VectorNf vector3 = new VectorNf(3, 2, 1, 4);
        TestUtilf.assertEquals(vector3.getMinAxis(), 2);
        VectorNf vector4 = new VectorNf(4, 2, 3, 1);
        TestUtilf.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        VectorNf vector1 = new VectorNf(4, 2, 3, 1);
        TestUtilf.assertEquals(vector1.getMaxAxis(), 0);
        VectorNf vector2 = new VectorNf(1, 4, 3, 2);
        TestUtilf.assertEquals(vector2.getMaxAxis(), 1);
        VectorNf vector3 = new VectorNf(1, 2, 4, 3);
        TestUtilf.assertEquals(vector3.getMaxAxis(), 2);
        VectorNf vector4 = new VectorNf(1, 2, 3, 4);
        TestUtilf.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        VectorNf vector = new VectorNf(1, 2, 3, 4);
        TestUtilf.assertEquals(vector.toVector2(), 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        VectorNf vector = new VectorNf(1, 2, 3, 4);
        TestUtilf.assertEquals(vector.toVector3(), 1, 2, 3);
    }

    @Test
    public void testConvertToVector4() {
        VectorNf vector = new VectorNf(1, 2, 3, 4);
        TestUtilf.assertEquals(vector.toVector4(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorFloat() {
        VectorNf vector = new VectorNf(1, 2, 3, 4);
        TestUtilf.assertEquals(vector.toFloat(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorDouble() {
        VectorNf vector = new VectorNf(1, 2, 3, 4);
        TestUtild.assertEquals(vector.toDouble(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArray() {
        float[] array = new VectorNf(1, 2, 3, 4).toArray();
        TestUtilf.assertEquals(array, 1, 2, 3, 4);
    }

    @Test
    public void testComparison() {
        int c1 = new VectorNf(10, 20, 30, 40).compareTo(new VectorNf(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new VectorNf(10, 20, 30, 40).compareTo(new VectorNf(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new VectorNf(10, 20, 30, 40).compareTo(new VectorNf(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
        int c4 = new VectorNf((float) 0.2, (float) 0.2, (float) 0.2, (float) 0.2).compareTo(new VectorNf((float) 0.1, (float) 0.1, (float) 0.1, (float) 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new VectorNf(1, 2, 3).equals(new VectorNf(1, 2, 3)));
        Assert.assertFalse(new VectorNf(1, 2, 3).equals(new VectorNf(2, 2, 3)));
    }

    @Test
    public void testCloning() {
        VectorNf vector = new VectorNf(1, 2, 3);
        Assert.assertEquals(vector, vector.clone());
    }
}
