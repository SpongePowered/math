package com.flowpowered.math.test.vector;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.VectorNi;

public class Vector4iTest {
    @Test
    public void testEmptyConstructor() {
        Vector4i vector = new Vector4i();
        TestUtili.assertEquals(vector, 0, 0, 0, 0);
    }

    @Test
    public void testCopyVector2DefaultZWConstructor() {
        Vector4i vector = new Vector4i(new Vector2i(0, 1));
        TestUtili.assertEquals(vector, 0, 1, 0, 0);
    }

    @Test
    public void testCopyVector2IntZWConstructor() {
        Vector4i vector = new Vector4i(new Vector2i(0, 1), (int) 1, (int) 2);
        TestUtili.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector3DefaultWConstructor() {
        Vector4i vector = new Vector4i(new Vector3i(0, 1, 1));
        TestUtili.assertEquals(vector, 0, 1, 1, 0);
    }

    @Test
    public void testCopyVector3IntWConstructor() {
        Vector4i vector = new Vector4i(new Vector3i(0, 1, 1), (int) 2);
        TestUtili.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector4i vector = new Vector4i(new Vector4i(0, 1, 1, 2));
        TestUtili.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector4i vector = new Vector4i(new VectorNi(0, 1, 1, 2, 5));
        TestUtili.assertEquals(vector, 0, 1, 1, 2);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector4i vector = new Vector4i(0.5, 1.7, 3.8, 5.5);
        TestUtili.assertEquals(vector, 0, 1, 3, 5);
    }

    @Test
    public void testIntComponentsConstructor() {
        Vector4i vector = new Vector4i((int) 0, (int) 1, (int) 3, (int) 5);
        TestUtili.assertEquals(vector, 0, 1, 3, 5);
    }

    @Test
    public void testGetters() {
        Vector4i vector = new Vector4i(0, 1, 3, 5);
        TestUtili.assertEquals(vector.getX(), 0);
        TestUtili.assertEquals(vector.getY(), 1);
        TestUtili.assertEquals(vector.getZ(), 3);
        TestUtili.assertEquals(vector.getW(), 5);
    }

    @Test
    public void testVector4Addition() {
        Vector4i vector = new Vector4i(0, 1, 1, 1).add(new Vector4i(5, -2, 3, 5));
        TestUtili.assertEquals(vector, 5, -1, 4, 6);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector4i vector = new Vector4i(0, 1, 1, 1).add(5.5, -2.5, 3.8, 5.5);
        TestUtili.assertEquals(vector, 5, -2, 4, 6);
    }

    @Test
    public void testIntComponentsAddition() {
        Vector4i vector = new Vector4i(0, 1, 1, 1).add((int) 5, (int) -2, (int) 3, (int) 5);
        TestUtili.assertEquals(vector, 5, -1, 4, 6);
    }

    @Test
    public void testVector4Subtraction() {
        Vector4i vector = new Vector4i(10, 5, 1, 1).sub(new Vector4i(9, 4, 2, 1));
        TestUtili.assertEquals(vector, 1, 1, -1, 0);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector4i vector = new Vector4i(10, 5, 1, 1).sub(9, 4.5, 2, 1);
        TestUtili.assertEquals(vector, 1, 1, -1, 0);
    }

    @Test
    public void testIntComponentsSubtraction() {
        Vector4i vector = new Vector4i(10, 5, 1, 1).sub((int) 9, (int) 4, (int) 2, (int) 1);
        TestUtili.assertEquals(vector, 1, 1, -1, 0);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector4i vector = new Vector4i(2, 3, 4, 5).mul(2.5);
        TestUtili.assertEquals(vector, 4, 6, 8, 10);
    }

    @Test
    public void testIntFactorMultiplication() {
        Vector4i vector = new Vector4i(2, 3, 4, 5).mul((int) 2);
        TestUtili.assertEquals(vector, 4, 6, 8, 10);
    }

    @Test
    public void testVector4Multiplication() {
        Vector4i vector = new Vector4i(2, 3, 4, 5).mul(new Vector4i(1, 2, 3, 4));
        TestUtili.assertEquals(vector, 2, 6, 12, 20);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector4i vector = new Vector4i(2, 3, 4, 5).mul(1.1, 2.5, 3.2, 4.3);
        TestUtili.assertEquals(vector, 2, 6, 12, 20);
    }

    @Test
    public void testIntComponentsMultiplication() {
        Vector4i vector = new Vector4i(2, 3, 4, 5).mul((int) 1, (int) 2, (int) 3, (int) 4);
        TestUtili.assertEquals(vector, 2, 6, 12, 20);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector4i vector = new Vector4i(2, 3, 5, 7).div(2.1);
        TestUtili.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testIntFactorDivision() {
        Vector4i vector = new Vector4i(2, 3, 5, 7).div((int) 2);
        TestUtili.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testVector4Division() {
        Vector4i vector = new Vector4i(2, 6, 16, 28).div(new Vector4i(2, 4, 8, 9));
        TestUtili.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector4i vector = new Vector4i(2, 6, 16, 28).div(2.5, 4.1, 8.3, 9.2);
        TestUtili.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testIntComponentsDivision() {
        Vector4i vector = new Vector4i(2, 6, 16, 28).div((int) 2, (int) 4, (int) 8, (int) 9);
        TestUtili.assertEquals(vector, 1, 1, 2, 3);
    }

    @Test
    public void testVector4DotProduct() {
        int f = new Vector4i(2, 3, 4, 5).dot(new Vector4i(6, 7, 8, 9));
        TestUtili.assertEquals(f, 110);
    }

    @Test
    public void testVector4Project() {
        Vector4i vector = new Vector4i(20, 30, 40, 50).project(new Vector4i(10, 10, 10, 10));
        TestUtili.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector4i vector = new Vector4i(20, 30, 40, 50).project(10d, 10d, 10d, 10d);
        TestUtili.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector4i vector = new Vector4i(20, 30, 40, 50).project(10, 10, 10, 10);
        TestUtili.assertEquals(vector, 35, 35, 35, 35);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        int f = new Vector4i(2, 3, 4, 5).dot(6.1, 7.5, 8.3, 9.2);
        TestUtili.assertEquals(f, 110);
    }

    @Test
    public void testIntComponentsDotProduct() {
        int f = new Vector4i(2, 3, 4, 5).dot(6, 7, 8, 9);
        TestUtili.assertEquals(f, 110);
    }

    @Test
    public void testRaiseToIntPower() {
        Vector4i vector = new Vector4i(2, 6, 8, 5).pow((int) 2);
        TestUtili.assertEquals(vector, 4, 36, 64, 25);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector4i vector = new Vector4i(2, 6, 8, 5).pow(2d);
        TestUtili.assertEquals(vector, 4, 36, 64, 25);
    }

    @Test
    public void testAbsolute() {
        Vector4i vector1 = new Vector4i(-2, -6, -55, 0).abs();
        TestUtili.assertEquals(vector1, 2, 6, 55, 0);
        Vector4i vector2 = new Vector4i(2, 6, 55, 0).abs();
        TestUtili.assertEquals(vector2, 2, 6, 55, 0);
    }

    @Test
    public void testNegate() {
        Vector4i vector = new Vector4i(2, -6, 15, 20).negate();
        TestUtili.assertEquals(vector, -2, 6, -15, -20);
    }

    @Test
    public void testVector4Minimum() {
        Vector4i vector = new Vector4i(2, 6, -1, 0).min(new Vector4i(3, 4, 10, -1));
        TestUtili.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector4i vector = new Vector4i(2, 6, -1, 0).min(3, 4, 10, -1.1);
        TestUtili.assertEquals(vector, 2, 4, -1, -2);
    }

    @Test
    public void testIntComponentsMinimum() {
        Vector4i vector = new Vector4i(2, 6, -1, 0).min((int) 3, (int) 4, (int) 10, (int) -1);
        TestUtili.assertEquals(vector, 2, 4, -1, -1);
    }

    @Test
    public void testVector4Maximum() {
        Vector4i vector = new Vector4i(2, 6, -1, 0).max(new Vector4i(3, 4, 10, -1));
        TestUtili.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector4i vector = new Vector4i(2, 6, -1, 0).max(3, 4, 10, -1.1);
        TestUtili.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testIntComponentsMaximum() {
        Vector4i vector = new Vector4i(2, 6, -1, 0).max((int) 3, (int) 4, (int) 10, (int) -1);
        TestUtili.assertEquals(vector, 3, 6, 10, 0);
    }

    @Test
    public void testVector4DistanceSquared() {
        int f = new Vector4i(2, 3, 4, 5).distanceSquared(new Vector4i(5, 6, 7, 8));
        TestUtili.assertEquals(f, 36);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        int f = new Vector4i(2, 3, 4, 1).distanceSquared(5.1, 6.5, 7.3, 1.2);
        TestUtili.assertEquals(f, 27);
    }

    @Test
    public void testIntComponentsDistanceSquared() {
        int f = new Vector4i(2, 3, 4, 5).distanceSquared((int) 5, (int) 6, (int) 7, (int) 5);
        TestUtili.assertEquals(f, 27);
    }

    @Test
    public void testVector4Distance() {
        float f = new Vector4i(0, 6, 13, 8).distance(new Vector4i(2, 8, 16, 16));
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testDoubleComponentsDistance() {
        float f = new Vector4i(0, 6, 13, 8).distance(new Vector4i(2d, 8.3, 16.5, 16.1));
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testIntComponentsDistance() {
        float f = new Vector4i(0, 6, 13, 8).distance(new Vector4i((int) 2, (int) 8, (int) 16, (int) 16));
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testLength() {
        float f = new Vector4i(2, 2, 3, 8).length();
        TestUtilf.assertEquals(f, 9);
    }

    @Test
    public void testLengthSquared() {
        int f = new Vector4i(3, 4, 5, 6).lengthSquared();
        TestUtili.assertEquals(f, 86);
    }

    @Test
    public void testGetMinAxis() {
        Vector4i vector1 = new Vector4i(1, 2, 3, 4);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        Vector4i vector2 = new Vector4i(2, 1, 3, 4);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
        Vector4i vector3 = new Vector4i(3, 2, 1, 4);
        TestUtili.assertEquals(vector3.getMinAxis(), 2);
        Vector4i vector4 = new Vector4i(4, 2, 3, 1);
        TestUtili.assertEquals(vector4.getMinAxis(), 3);
    }

    @Test
    public void testGetMaxAxis() {
        Vector4i vector1 = new Vector4i(4, 2, 3, 1);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        Vector4i vector2 = new Vector4i(1, 4, 3, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
        Vector4i vector3 = new Vector4i(1, 2, 4, 3);
        TestUtili.assertEquals(vector3.getMaxAxis(), 2);
        Vector4i vector4 = new Vector4i(1, 2, 3, 4);
        TestUtili.assertEquals(vector4.getMaxAxis(), 3);
    }

    @Test
    public void testConvertToVector2() {
        Vector2i vector = new Vector4i(1, 2, 3, 4).toVector2();
        TestUtili.assertEquals(vector, 1, 2);
    }

    @Test
    public void testConvertToVector3() {
        Vector3i vector = new Vector4i(1, 2, 3, 4).toVector3();
        TestUtili.assertEquals(vector, 1, 2, 3);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNi vector = new Vector4i(1, 2, 3, 4).toVectorN();
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testConvertToArray() {
        int[] array = new Vector4i(1, 2, 3, 4).toArray();
        TestUtili.assertEquals(array, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector4i(10, 20, 30, 40).compareTo(new Vector4i(20, 20, 30, 40));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector4i(10, 20, 30, 40).compareTo(new Vector4i(10, 20, 30, 40));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector4i(10, 20, 30, 40).compareTo(new Vector4i(10, 10, 30, 40));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector4i(122, 43, 96, 50).equals(new Vector4i(122, 43, 96, 50)));
        Assert.assertFalse(new Vector4i(122, 43, 96, 50).equals(new Vector4i(378, 95, 96, 0)));
    }

    @Test
    public void testCloning() {
        Vector4i vector = new Vector4i(3, 2, 5, 6);
        Assert.assertEquals(vector, vector.clone());
    }

    @Test
    public void testStream() {
        Vector4i vector = new Vector4i(10, 20, 30, 40);
        int[] expected = new int[]{20, 30, 40};
        int[] actual = vector.stream()
            .filter((n) -> n > 10)
            .toArray();
        TestUtili.assertEquals(actual, expected);
    }
}
