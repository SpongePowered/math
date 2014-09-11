package com.flowpowered.math.test.vector;

import static org.junit.Assert.assertEquals;
import static com.flowpowered.math.test.TestUtild.SQRT5;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector4d;
import com.flowpowered.math.vector.VectorNd;

public class VectorNdTest {
    @Test
    public void testSizeConstructor() {
        VectorNd vector = new VectorNd(5);
        TestUtild.assertEquals(vector, 0, 0, 0, 0, 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        VectorNd vector = new VectorNd(new Vector2d(0, 1));
        TestUtild.assertEquals(vector, 0, 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        VectorNd vector = new VectorNd(new Vector3d(0, 1, 2));
        TestUtild.assertEquals(vector, 0, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        VectorNd vector = new VectorNd(new Vector4d(0, 1, 2, 3));
        TestUtild.assertEquals(vector, 0, 1, 2, 3);
    }

    @Test
    public void testCopyVectorNConstructor() {
        VectorNd vector = new VectorNd(new VectorNd(0, 1, 2, 3, 4, 5));
        TestUtild.assertEquals(vector, 0, 1, 2, 3, 4, 5);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5);
        TestUtild.assertEquals(vector, 0, (double) 1.1, (double) 2.2, (double) 3.3, (double) 4.4, (double) 5.5);
    }

    @Test
    public void testFloatComponentsConstructor() {
        VectorNd vector = new VectorNd(0, 1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
        TestUtild.assertEquals(vector, 0, 1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
    }

    @Test
    public void testSize() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5);
        assertEquals(vector.size(), 6);
    }

    @Test
    public void testGetter() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5);
        TestUtild.assertEquals(vector.get(0), 0);
        TestUtild.assertEquals(vector.get(1), (double) 1.1);
        TestUtild.assertEquals(vector.get(2), (double) 2.2);
        TestUtild.assertEquals(vector.get(3), (double) 3.3);
        TestUtild.assertEquals(vector.get(4), (double) 4.4);
        TestUtild.assertEquals(vector.get(5), (double) 5.5);
    }

    @Test
    public void testFlooredGetter() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5, -6.6);
        TestUtild.assertEquals(vector.getFloored(0), 0);
        TestUtild.assertEquals(vector.getFloored(1), 1);
        TestUtild.assertEquals(vector.getFloored(2), 2);
        TestUtild.assertEquals(vector.getFloored(3), 3);
        TestUtild.assertEquals(vector.getFloored(4), 4);
        TestUtild.assertEquals(vector.getFloored(5), 5);
        TestUtild.assertEquals(vector.getFloored(6), -7);
    }

    @Test
    public void testSetterDoubleValue() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5);
        vector.set(0, (double) 6.6);
        TestUtild.assertEquals(vector.get(0), (double) 6.6);
    }

    @Test
    public void testSetZero() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2);
        vector.setZero();
        TestUtild.assertEquals(vector.get(0), 0);
        TestUtild.assertEquals(vector.get(1), 0);
        TestUtild.assertEquals(vector.get(2), 0);
    }

    @Test
    public void testResize() {
        VectorNd vector1 = new VectorNd(0, 1.1, 2.2);
        VectorNd resize1 = vector1.resize(2);
        TestUtild.assertEquals(resize1.size(), 2);
        VectorNd vector2 = new VectorNd(0, 1.1, 2.2);
        VectorNd resize2 = vector2.resize(4);
        TestUtild.assertEquals(resize2.size(), 4);
        TestUtild.assertEquals(resize2.get(3), 0);
    }

    @Test
    public void testVectorNAddition() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5).add(new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5));
        TestUtild.assertEquals(vector, 0, (double) 2.2, (double) 4.4, (double) 6.6, (double) 8.8, 11);
    }

    @Test
    public void testDoubleComponentsAddition() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5).add(0, (double) 1.1, (double) 2.2, (double) 3.3, (double) 4.4, (double) 5.5);
        TestUtild.assertEquals(vector, 0, (double) 2.2, (double) 4.4, (double) 6.6, (double) 8.8, 11);
    }

    @Test
    public void testVectorNSubtraction() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5).sub(new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5));
        TestUtild.assertEquals(vector, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        VectorNd vector = new VectorNd(0, 1.1, 2.2, 3.3, 4.4, 5.5).sub(0, (double) 1.1, (double) 2.2, (double) 3.3, (double) 4.4, (double) 5.5);
        TestUtild.assertEquals(vector, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        VectorNd vector = new VectorNd(0.1, 1.1, 2.2, 3.3, 4.4, 5.5).mul(2d);
        TestUtild.assertEquals(vector, (double) 0.2, (double) 2.2, (double) 4.4, (double) 6.6, (double) 8.8, 11);
    }

    @Test
    public void testFloatFactorMultiplication() {
        VectorNd vector = new VectorNd(0.1, 1.1, 2.2, 3.3, 4.4, 5.5).mul(2);
        TestUtild.assertEquals(vector, 0.2f, 2.2f, (double) 4.4, (double) 6.6, (double) 8.8, 11f);
    }

    @Test
    public void testVectorNMultiplication() {
        VectorNd vector = new VectorNd(0.1, 1.1, 2.2, 3.3, 4.4, 5.5).mul(new VectorNd(1, 2, 3, 4, 5, 6));
        TestUtild.assertEquals(vector, (double) 0.1, (double) 2.2, (double) 6.6, (double) 13.2, 22, 33);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        VectorNd vector = new VectorNd(0.1, 1.1, 2.2, 3.3, 4.4, 5.5).mul(2, 2, 3, 3, 4, 4);
        TestUtild.assertEquals(vector, (double) 0.2, (double) 2.2, (double) 6.6, (double) 9.9, (double) 17.6, 22);
    }

    @Test
    public void testDoubleFactorDivision() {
        VectorNd vector = new VectorNd(1, 2, 3, 4, 5, 6).div(2d);
        TestUtild.assertEquals(vector, (double) 0.5, 1, (double) 1.5, 2, (double) 2.5, 3);
    }

    @Test
    public void testFloatFactorDivision() {
        VectorNd vector = new VectorNd(1, 2, 3, 4, 5, 6).div(2);
        TestUtild.assertEquals(vector, 0.5f, 1, 1.5f, 2, 2.5f, 3);
    }

    @Test
    public void testVectorNDivision() {
        VectorNd vector = new VectorNd(1, 2, 3, 4, 5, 6).div(new VectorNd(2, 1, (double) 0.5, 8, 4, 6));
        TestUtild.assertEquals(vector, (double) 0.5, 2, 6, (double) 0.5, (double) 1.25, 1);
    }

    @Test
    public void testDoubleComponentsDivision() {
        VectorNd vector = new VectorNd(1, 2, 3, 4, 5, 6).div(2, 1, (double) 0.5, 8, 4, 6);
        TestUtild.assertEquals(vector, (double) 0.5, 2, 6, (double) 0.5, (double) 1.25, 1);
    }

    @Test
    public void testVectorNDotProduct() {
        double f = new VectorNd(2, 3, 4, 5).dot(new VectorNd(6, 7, 8, 9));
        TestUtild.assertEquals(f, 110);
    }

    @Test
    public void testFloatComponentsDotProduct() {
        double f = new VectorNd(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtild.assertEquals(f, 110f);
    }

    @Test
    public void testRaiseToDoublePower() {
        VectorNd vector = new VectorNd(2, 6, 8, 5.5).pow(2d);
        TestUtild.assertEquals(vector, 4, 36, 64, (double) 30.25);
    }

    @Test
    public void testRaiseToFloatPower() {
        VectorNd vector = new VectorNd(2, 6, 8, 5.5f).pow(2);
        TestUtild.assertEquals(vector, 4, 36, 64, 30.25f);
    }

    @Test
    public void testCeiling() {
        VectorNd vector = new VectorNd(2.5, 6.7, 7.9, 8.1).ceil();
        TestUtild.assertEquals(vector, 3, 7, 8, 9);
    }

    @Test
    public void testFloor() {
        VectorNd vector = new VectorNd(2.5, 6.7, 7.8, 9.1).floor();
        TestUtild.assertEquals(vector, 2, 6, 7, 9);
    }

    @Test
    public void testRound() {
        VectorNd vector = new VectorNd(2.2, 6.7, 7.8, 9.1).round();
        TestUtild.assertEquals(vector, 2, 7, 8, 9);
    }

    @Test
    public void testAbsolute() {
        VectorNd vector1 = new VectorNd(-2.5, -6.7, -55, 0).abs();
        TestUtild.assertEquals(vector1, (double) 2.5, (double) 6.7, 55, 0);
        VectorNd vector2 = new VectorNd(2.5, 6.7, 55, 0).abs();
        TestUtild.assertEquals(vector2, (double) 2.5, (double) 6.7, 55, 0);
    }

    @Test
    public void testNegate() {
        VectorNd vector = new VectorNd(2.2, -6.7, 15.8, 20).negate();
        TestUtild.assertEquals(vector, (double) -2.2, (double) 6.7, (double) -15.8, -20);
    }

    @Test
    public void testVectorNMinimum() {
        VectorNd vector = new VectorNd(2, 6, -1, 0).min(new VectorNd(3, 4, 10, -1));
        TestUtild.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        VectorNd vector = new VectorNd(2, 6, -1, 0).min(3, 4, 10, (double) -1.1);
        TestUtild.assertEquals(vector, 2, 4, -1, (double) -1.1);
    }

    @Test
    public void testVectorNMaximum() {
        VectorNd vector = new VectorNd(2, 6, -1, 0).max(new VectorNd(3, 4, 10, -1));
        TestUtild.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        VectorNd vector = new VectorNd(2, 6, -1, 0).max(3, 4, 10, (double) -1.1);
        TestUtild.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testVectorNDistanceSquared() {
        double f = new VectorNd(2, 3, 4).distanceSquared(new VectorNd(5, 6, 7));
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testFloatComponentsDistanceSquared() {
        double f = new VectorNd(2, 3, 4, 5).distanceSquared(5, 6, 7, 5);
        TestUtild.assertEquals(f, 27);
    }

    @Test
    public void testVectorNDistance() {
        double f = new VectorNd(0, 2, 4, 8).distance(new VectorNd(0, 8, 16, 8));
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        double f = new VectorNd(0, 2, 4, 8).distance(0, 8, 16, 8);
        TestUtild.assertEquals(f, 6 * SQRT5);
    }

    @Test
    public void testLength() {
        double f = new VectorNd(3, 4, 5, 6).length();
        TestUtild.assertEquals(f, (double) Math.sqrt(86));
    }

    @Test
    public void testLengthSquared() {
        double f = new VectorNd(3, 4, 5, 6).lengthSquared();
        TestUtild.assertEquals(f, 86);
    }

    @Test
    public void testNormalize() {
        VectorNd v1 = new VectorNd(1, 1, 0, 0).normalize();
        TestUtild.assertEquals(v1, (double) TrigMath.HALF_SQRT_OF_TWO, (double) TrigMath.HALF_SQRT_OF_TWO, 0, 0);
        VectorNd v2 = new VectorNd(0, 1, 0, 1).normalize();
        TestUtild.assertEquals(v2, 0, (double) TrigMath.HALF_SQRT_OF_TWO, 0, (double) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void testGetMinAxis() {
        VectorNd vector1 = new VectorNd(1, 2, 3, 4);
        TestUtild.assertEquals(vector1.getMinAxis(), 0);
        VectorNd vector2 = new VectorNd(2, 1, 3, 4);
        TestUtild.assertEquals(vector2.getMinAxis(), 1);
        VectorNd vector3 = new VectorNd(3, 2, 1, 4);
        TestUtild.assertEquals(vector3.getMinAxis(), 2);
        VectorNd vector4 = new VectorNd(4, 2, 3, 1);
        TestUtild.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        VectorNd vector1 = new VectorNd(4, 2, 3, 1);
        TestUtild.assertEquals(vector1.getMaxAxis(), 0);
        VectorNd vector2 = new VectorNd(1, 4, 3, 2);
        TestUtild.assertEquals(vector2.getMaxAxis(), 1);
        VectorNd vector3 = new VectorNd(1, 2, 4, 3);
        TestUtild.assertEquals(vector3.getMaxAxis(), 2);
        VectorNd vector4 = new VectorNd(1, 2, 3, 4);
        TestUtild.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        VectorNd vector = new VectorNd(1, 2, 3, 4);
        TestUtild.assertEquals(vector.toVector2(), 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        VectorNd vector = new VectorNd(1, 2, 3, 4);
        TestUtild.assertEquals(vector.toVector3(), 1, 2, 3);
    }

    @Test
    public void testConvertToVector4() {
        VectorNd vector = new VectorNd(1, 2, 3, 4);
        TestUtild.assertEquals(vector.toVector4(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArray() {
        double[] array = new VectorNd(1, 2, 3, 4).toArray();
        TestUtild.assertEquals(array, 1, 2, 3, 4);
    }

    @Test
    public void testComparison() {
        int c1 = new VectorNd(10, 20, 30, 40).compareTo(new VectorNd(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new VectorNd(10, 20, 30, 40).compareTo(new VectorNd(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new VectorNd(10, 20, 30, 40).compareTo(new VectorNd(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
        int c4 = new VectorNd(0.2, 0.2, 0.2, 0.2).compareTo(new VectorNd(0.1, 0.1, 0.1, 0.1));
        Assert.assertTrue(c4 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new VectorNd(1, 2, 3).equals(new VectorNd(1, 2, 3)));
        Assert.assertFalse(new VectorNd(1, 2, 3).equals(new VectorNd(2, 2, 3)));
    }

    @Test
    public void testCloning() {
        VectorNd vector = new VectorNd(1, 2, 3);
        Assert.assertEquals(vector, vector.clone());
    }
}
