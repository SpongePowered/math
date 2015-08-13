package com.flowpowered.math.test.vector;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.test.TestUtill;
import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.VectorNi;

public class VectorNiTest {
    @Test
    public void testSizeConstructor() {
        VectorNi vector = new VectorNi(5);
        TestUtili.assertEquals(vector, (int) 0, (int) 0, (int) 0, (int) 0, (int) 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        VectorNi vector = new VectorNi(new Vector2i(0, 1));
        TestUtili.assertEquals(vector, (int) 0, (int) 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        VectorNi vector = new VectorNi(new Vector3i(0, 1, 2));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        VectorNi vector = new VectorNi(new Vector4i(0, 1, 2, 3));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2, (int) 3);
    }

    @Test
    public void testCopyVectorNConstructor() {
        VectorNi vector = new VectorNi(new VectorNi(0, 1, 2, 3, 4, 5));
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2, (int) 3, (int) 4, (int) 5);
    }

    @Test
    public void testComponentsConstructor() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5);
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 2, (int) 3, (int) 4, (int) 5);
    }

    @Test
    public void testSize() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5);
        assertEquals(vector.size(), (int) 6);
    }

    @Test
    public void testGetter() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5);
        TestUtili.assertEquals(vector.get(0), 0);
        TestUtili.assertEquals(vector.get(1), 1);
        TestUtili.assertEquals(vector.get(2), 2);
        TestUtili.assertEquals(vector.get(3), 3);
        TestUtili.assertEquals(vector.get(4), 4);
        TestUtili.assertEquals(vector.get(5), 5);
    }

    @Test
    public void testSetterIntValue() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5);
        vector.set(0, (int) 6);
        TestUtili.assertEquals(vector.get(0), 6);
    }

    @Test
    public void testSetZero() {
        VectorNi vector = new VectorNi(0, 1, 2);
        vector.setZero();
        TestUtili.assertEquals(vector.get(0), 0);
        TestUtili.assertEquals(vector.get(1), 0);
        TestUtili.assertEquals(vector.get(2), 0);
    }

    @Test
    public void testResize() {
        VectorNi vector1 = new VectorNi(0, 1, 2);
        VectorNi resize1 = vector1.resize(2);
        TestUtili.assertEquals(resize1.size(), 2);
        VectorNi vector2 = new VectorNi(0, 1, 2);
        VectorNi resize2 = vector2.resize(4);
        TestUtili.assertEquals(resize2.size(), 4);
    }

    @Test
    public void testVectorNAddition() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).add(new VectorNi(0, 1, 2, 3, 4, 6));
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 4, (int) 6, (int) 8, (int) 11);
    }

    @Test
    public void testIntComponentsAddition() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).add((int) 0, (int) 1, (int) 2, (int) 3, (int) 4, (int) 6);
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 4, (int) 6, (int) 8, (int) 11);
    }

    @Test
    public void testVectorNSubtraction() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).sub(new VectorNi(0, 1, 2, 3, 4, 4));
        TestUtili.assertEquals(vector, (int) 0, (int) 0, (int) 0, (int) 0, (int) 0, (int) 1);
    }

    @Test
    public void testIntComponentsSubtraction() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).sub((int) 0, (int) 1, (int) 2, (int) 3, (int) 4, (int) 4);
        TestUtili.assertEquals(vector, (int) 0, (int) 0, (int) 0, (int) 0, (int) 0, (int) 1);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).mul(2.1);
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 4, (int) 6, (int) 8, (int) 10);
    }

    @Test
    public void testIntFactorMultiplication() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).mul((int) 2);
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 4, (int) 6, (int) 8, (int) 10);
    }

    @Test
    public void testVectorNMultiplication() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).mul(new VectorNi(1, 2, 3, 4, 5, 6));
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 6, (int) 12, (int) 20, (int) 30);
    }

    @Test
    public void testIntComponentsMultiplication() {
        VectorNi vector = new VectorNi(0, 1, 2, 3, 4, 5).mul((int) 2, (int) 2, (int) 3, (int) 3, (int) 4, (int) 4);
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 6, (int) 9, (int) 16, (int) 20);
    }

    @Test
    public void testDoubleFactorDivision() {
        VectorNi vector = new VectorNi(1, 2, 3, 4, 5, 6).div(2.1);
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 1, (int) 2, (int) 2, (int) 3);
    }

    @Test
    public void testIntFactorDivision() {
        VectorNi vector = new VectorNi(1, 2, 3, 4, 5, 6).div(2);
        TestUtili.assertEquals(vector, (int) 0, (int) 1, (int) 1, (int) 2, (int) 2, (int) 3);
    }

    @Test
    public void testVectorNDivision() {
        VectorNi vector = new VectorNi(1, 2, 3, 4, 5, 8).div(new VectorNi(2, 1, 2, 4, 2, 3));
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 1, (int) 1, (int) 2, (int) 2);
    }

    @Test
    public void testIntComponentsDivision() {
        VectorNi vector = new VectorNi(1, 2, 3, 4, 5, 6).div((int) 2, (int) 1, (int) 2, (int) 4, (int) 2, (int) 3);
        TestUtili.assertEquals(vector, (int) 0, (int) 2, (int) 1, (int) 1, (int) 2, (int) 2);
    }

    @Test
    public void testVectorNDotProduct() {
        int f = new VectorNi(2, 3, 4, 5).dot(new VectorNi(6, 7, 8, 9));
        TestUtili.assertEquals(f, 110);
    }

    @Test
    public void testIntComponentsDotProduct() {
        int f = new VectorNi(2, 3, 4, 5).dot((int) 6, (int) 7, (int) 8, (int) 9);
        TestUtili.assertEquals(f, 110);
    }

    @Test
    public void testVectorNProject() {
        VectorNi vector = new VectorNi(20, 30, 40, 50).project(new VectorNi(10, 10, 10, 10));
        TestUtili.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testFloatComponentsProject() {
        VectorNi vector = new VectorNi(20, 30, 40, 50).project(10, 10, 10, 10);
        TestUtili.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testRaiseToDoublePower() {
        VectorNi vector = new VectorNi(2, 6, 8, 5).pow(2d);
        TestUtili.assertEquals(vector, (int) 4, (int) 36, (int) 64, (int) 25);
    }

    @Test
    public void testRaiseToIntPower() {
        VectorNi vector = new VectorNi(2, 6, 8, (int) 5.5).pow((int) 2);
        TestUtili.assertEquals(vector, (int) 4, (int) 36, (int) 64, (int) 25);
    }

    @Test
    public void testAbsolute() {
        VectorNi vector1 = new VectorNi(-2, -6, -55, 0).abs();
        TestUtili.assertEquals(vector1, (int) 2, (int) 6, (int) 55, (int) 0);
        VectorNi vector2 = new VectorNi(2, 6, 55, 0).abs();
        TestUtili.assertEquals(vector2, (int) 2, (int) 6, (int) 55, (int) 0);
    }

    @Test
    public void testNegate() {
        VectorNi vector = new VectorNi(2, -6, 15, 20).negate();
        TestUtili.assertEquals(vector, (int) -2, (int) 6, (int) -15, (int) -20);
    }

    @Test
    public void testVectorNMinimum() {
        VectorNi vector = new VectorNi(2, 6, -1, 0).min(new VectorNi(3, 4, 10, -1));
        TestUtili.assertEquals(vector, (int) 2, (int) 4, (int) -1, (int) -1);
    }

    @Test
    public void testIntComponentsMinimum() {
        VectorNi vector = new VectorNi(2, 6, -1, 0).min((int) 3, (int) 4, (int) 10, (int) -1);
        TestUtili.assertEquals(vector, (int) 2, (int) 4, (int) -1, (int) -1);
    }

    @Test
    public void testVectorNMaximum() {
        VectorNi vector = new VectorNi(2, 6, -1, 0).max(new VectorNi(3, 4, 10, -1));
        TestUtili.assertEquals(vector, (int) 3, (int) 6, (int) 10, (int) 0);
    }

    @Test
    public void testIntComponentsMaximum() {
        VectorNi vector = new VectorNi(2, 6, -1, 0).max((int) 3, (int) 4, (int) 10, (int) -1);
        TestUtili.assertEquals(vector, (int) 3, (int) 6, (int) 10, (int) 0);
    }

    @Test
    public void testVectorNDistanceSquared() {
        int f = new VectorNi(2, 3, 4).distanceSquared(new VectorNi(5, 6, 7));
        TestUtili.assertEquals(f, 27);
    }

    @Test
    public void testIntComponentsDistanceSquared() {
        int f = new VectorNi(2, 3, 4, 5).distanceSquared((int) 5, (int) 6, (int) 7, (int) 5);
        TestUtili.assertEquals(f, 27);
    }

    @Test
    public void testVectorNDistance() {
        float f = new VectorNi(0, 6, 13, 8).distance(new VectorNi(2, 8, 16, 16));
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testIntComponentsDistance() {
        float f = new VectorNi(0, 6, 13, 8).distance((int) 2, (int) 8, (int) 16, (int) 16);
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testLength() {
        float f = new VectorNi(2, 2, 3, 8).length();
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testLengthSquared() {
        int f = new VectorNi(3, 4, 5, 6).lengthSquared();
        TestUtili.assertEquals(f, 86);
    }

    @Test
    public void testGetMinAxis() {
        VectorNi vector1 = new VectorNi(1, 2, 3, 4);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        VectorNi vector2 = new VectorNi(2, 1, 3, 4);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
        VectorNi vector3 = new VectorNi(3, 2, 1, 4);
        TestUtili.assertEquals(vector3.getMinAxis(), 2);
        VectorNi vector4 = new VectorNi(4, 2, 3, 1);
        TestUtili.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        VectorNi vector1 = new VectorNi(4, 2, 3, 1);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        VectorNi vector2 = new VectorNi(1, 4, 3, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
        VectorNi vector3 = new VectorNi(1, 2, 4, 3);
        TestUtili.assertEquals(vector3.getMaxAxis(), 2);
        VectorNi vector4 = new VectorNi(1, 2, 3, 4);
        TestUtili.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        VectorNi vector = new VectorNi(1, 2, 3, 4);
        TestUtili.assertEquals(vector.toVector2(), 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        VectorNi vector = new VectorNi(1, 2, 3, 4);
        TestUtili.assertEquals(vector.toVector3(), 1, 2, 3);
    }

    @Test
    public void testConvertToVector4() {
        VectorNi vector = new VectorNi(1, 2, 3, 4);
        TestUtili.assertEquals(vector.toVector4(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorInteger() {
        VectorNi vector = new VectorNi(1, 2, 3, 4);
        TestUtili.assertEquals(vector.toInt(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToVectorLong() {
        VectorNi vector = new VectorNi(1, 2, 3, 4);
        TestUtill.assertEquals(vector.toLong(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArray() {
        int[] array = new VectorNi(1, 2, 3, 4).toArray();
        TestUtili.assertEquals(array, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testComparison() {
        int c1 = new VectorNi(10, 20, 30, 40).compareTo(new VectorNi(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new VectorNi(10, 20, 30, 40).compareTo(new VectorNi(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new VectorNi(10, 20, 30, 40).compareTo(new VectorNi(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new VectorNi(1, 2, 3).equals(new VectorNi(1, 2, 3)));
        Assert.assertFalse(new VectorNi(1, 2, 3).equals(new VectorNi(2, 2, 3)));
    }

    @Test
    public void testCloning() {
        VectorNi vector = new VectorNi(1, 2, 3);
        Assert.assertEquals(vector, vector.clone());
    }
}
