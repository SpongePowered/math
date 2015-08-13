package com.flowpowered.math.test.vector;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.test.TestUtill;
import com.flowpowered.math.vector.Vector2l;
import com.flowpowered.math.vector.Vector3l;
import com.flowpowered.math.vector.Vector4l;
import com.flowpowered.math.vector.VectorNl;

public class VectorNlTest {
    @Test
    public void testSizeConstructor() {
        VectorNl vector = new VectorNl(5);
        TestUtill.assertEquals(vector, (long) 0, (long) 0, (long) 0, (long) 0, (long) 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        VectorNl vector = new VectorNl(new Vector2l(0, 1));
        TestUtill.assertEquals(vector, (long) 0, (long) 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        VectorNl vector = new VectorNl(new Vector3l(0, 1, 2));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        VectorNl vector = new VectorNl(new Vector4l(0, 1, 2, 3));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2, (long) 3);
    }

    @Test
    public void testCopyVectorNConstructor() {
        VectorNl vector = new VectorNl(new VectorNl(0, 1, 2, 3, 4, 5));
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2, (long) 3, (long) 4, (long) 5);
    }

    @Test
    public void testComponentsConstructor() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5);
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 2, (long) 3, (long) 4, (long) 5);
    }

    @Test
    public void testSize() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5);
        assertEquals(vector.size(), (long) 6);
    }

    @Test
    public void testGetter() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5);
        TestUtill.assertEquals(vector.get(0), 0);
        TestUtill.assertEquals(vector.get(1), 1);
        TestUtill.assertEquals(vector.get(2), 2);
        TestUtill.assertEquals(vector.get(3), 3);
        TestUtill.assertEquals(vector.get(4), 4);
        TestUtill.assertEquals(vector.get(5), 5);
    }

    @Test
    public void testSetterLongValue() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5);
        vector.set(0, (long) 6);
        TestUtill.assertEquals(vector.get(0), 6);
    }

    @Test
    public void testSetZero() {
        VectorNl vector = new VectorNl(0, 1, 2);
        vector.setZero();
        TestUtill.assertEquals(vector.get(0), 0);
        TestUtill.assertEquals(vector.get(1), 0);
        TestUtill.assertEquals(vector.get(2), 0);
    }

    @Test
    public void testResize() {
        VectorNl vector1 = new VectorNl(0, 1, 2);
        VectorNl resize1 = vector1.resize(2);
        TestUtili.assertEquals(resize1.size(), 2);
        VectorNl vector2 = new VectorNl(0, 1, 2);
        VectorNl resize2 = vector2.resize(4);
        TestUtili.assertEquals(resize2.size(), 4);
    }

    @Test
    public void testVectorNAddition() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).add(new VectorNl(0, 1, 2, 3, 4, 6));
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 4, (long) 6, (long) 8, (long) 11);
    }

    @Test
    public void testLongComponentsAddition() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).add((long) 0, (long) 1, (long) 2, (long) 3, (long) 4, (long) 6);
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 4, (long) 6, (long) 8, (long) 11);
    }

    @Test
    public void testVectorNSubtraction() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).sub(new VectorNl(0, 1, 2, 3, 4, 4));
        TestUtill.assertEquals(vector, (long) 0, (long) 0, (long) 0, (long) 0, (long) 0, (long) 1);
    }

    @Test
    public void testLongComponentsSubtraction() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).sub((long) 0, (long) 1, (long) 2, (long) 3, (long) 4, (long) 4);
        TestUtill.assertEquals(vector, (long) 0, (long) 0, (long) 0, (long) 0, (long) 0, (long) 1);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).mul(2.1);
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 4, (long) 6, (long) 8, (long) 10);
    }

    @Test
    public void testLongFactorMultiplication() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).mul((long) 2);
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 4, (long) 6, (long) 8, (long) 10);
    }

    @Test
    public void testVectorNMultiplication() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).mul(new VectorNl(1, 2, 3, 4, 5, 6));
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 6, (long) 12, (long) 20, (long) 30);
    }

    @Test
    public void testLongComponentsMultiplication() {
        VectorNl vector = new VectorNl(0, 1, 2, 3, 4, 5).mul((long) 2, (long) 2, (long) 3, (long) 3, (long) 4, (long) 4);
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 6, (long) 9, (long) 16, (long) 20);
    }

    @Test
    public void testDoubleFactorDivision() {
        VectorNl vector = new VectorNl(1, 2, 3, 4, 5, 6).div(2.1);
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 1, (long) 2, (long) 2, (long) 3);
    }

    @Test
    public void testLongFactorDivision() {
        VectorNl vector = new VectorNl(1, 2, 3, 4, 5, 6).div(2);
        TestUtill.assertEquals(vector, (long) 0, (long) 1, (long) 1, (long) 2, (long) 2, (long) 3);
    }

    @Test
    public void testVectorNDivision() {
        VectorNl vector = new VectorNl(1, 2, 3, 4, 5, 8).div(new VectorNl(2, 1, 2, 4, 2, 3));
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 1, (long) 1, (long) 2, (long) 2);
    }

    @Test
    public void testLongComponentsDivision() {
        VectorNl vector = new VectorNl(1, 2, 3, 4, 5, 6).div((long) 2, (long) 1, (long) 2, (long) 4, (long) 2, (long) 3);
        TestUtill.assertEquals(vector, (long) 0, (long) 2, (long) 1, (long) 1, (long) 2, (long) 2);
    }

    @Test
    public void testVectorNDotProduct() {
        long f = new VectorNl(2, 3, 4, 5).dot(new VectorNl(6, 7, 8, 9));
        TestUtill.assertEquals(f, 110);
    }

    @Test
    public void testLongComponentsDotProduct() {
        long f = new VectorNl(2, 3, 4, 5).dot((long) 6, (long) 7, (long) 8, (long) 9);
        TestUtill.assertEquals(f, 110);
    }

    @Test
    public void testVectorNProject() {
        VectorNl vector = new VectorNl(20, 30, 40, 50).project(new VectorNl(10, 10, 10, 10));
        TestUtill.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testFloatComponentsProject() {
        VectorNl vector = new VectorNl(20, 30, 40, 50).project(10, 10, 10, 10);
        TestUtill.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testRaiseToDoublePower() {
        VectorNl vector = new VectorNl(2, 6, 8, 5).pow(2d);
        TestUtill.assertEquals(vector, (long) 4, (long) 36, (long) 64, (long) 25);
    }

    @Test
    public void testRaiseToLongPower() {
        VectorNl vector = new VectorNl(2, 6, 8, (long) 5.5).pow((long) 2);
        TestUtill.assertEquals(vector, (long) 4, (long) 36, (long) 64, (long) 25);
    }

    @Test
    public void testAbsolute() {
        VectorNl vector1 = new VectorNl(-2, -6, -55, 0).abs();
        TestUtill.assertEquals(vector1, (long) 2, (long) 6, (long) 55, (long) 0);
        VectorNl vector2 = new VectorNl(2, 6, 55, 0).abs();
        TestUtill.assertEquals(vector2, (long) 2, (long) 6, (long) 55, (long) 0);
    }

    @Test
    public void testNegate() {
        VectorNl vector = new VectorNl(2, -6, 15, 20).negate();
        TestUtill.assertEquals(vector, (long) -2, (long) 6, (long) -15, (long) -20);
    }

    @Test
    public void testVectorNMinimum() {
        VectorNl vector = new VectorNl(2, 6, -1, 0).min(new VectorNl(3, 4, 10, -1));
        TestUtill.assertEquals(vector, (long) 2, (long) 4, (long) -1, (long) -1);
    }

    @Test
    public void testLongComponentsMinimum() {
        VectorNl vector = new VectorNl(2, 6, -1, 0).min((long) 3, (long) 4, (long) 10, (long) -1);
        TestUtill.assertEquals(vector, (long) 2, (long) 4, (long) -1, (long) -1);
    }

    @Test
    public void testVectorNMaximum() {
        VectorNl vector = new VectorNl(2, 6, -1, 0).max(new VectorNl(3, 4, 10, -1));
        TestUtill.assertEquals(vector, (long) 3, (long) 6, (long) 10, (long) 0);
    }

    @Test
    public void testLongComponentsMaximum() {
        VectorNl vector = new VectorNl(2, 6, -1, 0).max((long) 3, (long) 4, (long) 10, (long) -1);
        TestUtill.assertEquals(vector, (long) 3, (long) 6, (long) 10, (long) 0);
    }

    @Test
    public void testVectorNDistanceSquared() {
        long f = new VectorNl(2, 3, 4).distanceSquared(new VectorNl(5, 6, 7));
        TestUtill.assertEquals(f, 27);
    }

    @Test
    public void testLongComponentsDistanceSquared() {
        long f = new VectorNl(2, 3, 4, 5).distanceSquared((long) 5, (long) 6, (long) 7, (long) 5);
        TestUtill.assertEquals(f, 27);
    }

    @Test
    public void testVectorNDistance() {
        double f = new VectorNl(0, 6, 13, 8).distance(new VectorNl(2, 8, 16, 16));
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testLongComponentsDistance() {
        double f = new VectorNl(0, 6, 13, 8).distance((long) 2, (long) 8, (long) 16, (long) 16);
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testLength() {
        double f = new VectorNl(2, 2, 3, 8).length();
        TestUtild.assertEquals(f, 9);
    }

    @Test
    public void testLengthSquared() {
        long f = new VectorNl(3, 4, 5, 6).lengthSquared();
        TestUtill.assertEquals(f, 86);
    }

    @Test
    public void testGetMinAxis() {
        VectorNl vector1 = new VectorNl(1, 2, 3, 4);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        VectorNl vector2 = new VectorNl(2, 1, 3, 4);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
        VectorNl vector3 = new VectorNl(3, 2, 1, 4);
        TestUtili.assertEquals(vector3.getMinAxis(), 2);
        VectorNl vector4 = new VectorNl(4, 2, 3, 1);
        TestUtili.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        VectorNl vector1 = new VectorNl(4, 2, 3, 1);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        VectorNl vector2 = new VectorNl(1, 4, 3, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
        VectorNl vector3 = new VectorNl(1, 2, 4, 3);
        TestUtili.assertEquals(vector3.getMaxAxis(), 2);
        VectorNl vector4 = new VectorNl(1, 2, 3, 4);
        TestUtili.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        VectorNl vector = new VectorNl(1, 2, 3, 4);
        TestUtill.assertEquals(vector.toVector2(), 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        VectorNl vector = new VectorNl(1, 2, 3, 4);
        TestUtill.assertEquals(vector.toVector3(), 1, 2, 3);
    }

    @Test
    public void testConvertToVector4() {
        VectorNl vector = new VectorNl(1, 2, 3, 4);
        TestUtill.assertEquals(vector.toVector4(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorInteger() {
        VectorNl vector = new VectorNl(1, 2, 3, 4);
        TestUtili.assertEquals(vector.toInt(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorLong() {
        VectorNl vector = new VectorNl(1, 2, 3, 4);
        TestUtill.assertEquals(vector.toLong(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArray() {
        long[] array = new VectorNl(1, 2, 3, 4).toArray();
        TestUtill.assertEquals(array, (long) 1, (long) 2, (long) 3, (long) 4);
    }

    @Test
    public void testComparison() {
        int c1 = new VectorNl(10, 20, 30, 40).compareTo(new VectorNl(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new VectorNl(10, 20, 30, 40).compareTo(new VectorNl(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new VectorNl(10, 20, 30, 40).compareTo(new VectorNl(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new VectorNl(1, 2, 3).equals(new VectorNl(1, 2, 3)));
        Assert.assertFalse(new VectorNl(1, 2, 3).equals(new VectorNl(2, 2, 3)));
    }

    @Test
    public void testCloning() {
        VectorNl vector = new VectorNl(1, 2, 3);
        Assert.assertEquals(vector, vector.clone());
    }
}
