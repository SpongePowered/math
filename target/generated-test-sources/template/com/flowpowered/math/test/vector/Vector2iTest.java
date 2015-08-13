package com.flowpowered.math.test.vector;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.test.TestUtili;
import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.VectorNi;

public class Vector2iTest {
    @Test
    public void testEmptyConstructor() {
        Vector2i vector = new Vector2i();
        TestUtili.assertEquals(vector, (int) 0, (int) 0);
    }

    @Test
    public void testCopyVector2Constructor() {
        Vector2i vector = new Vector2i(new Vector2i(0, 1));
        TestUtili.assertEquals(vector, (int) 0, (int) 1);
    }

    @Test
    public void testCopyVector3Constructor() {
        Vector2i vector = new Vector2i(new Vector3i(0, 1, 2));
        TestUtili.assertEquals(vector, (int) 0, (int) 1);
    }

    @Test
    public void testCopyVector4Constructor() {
        Vector2i vector = new Vector2i(new Vector4i(0, 1, 2, 3));
        TestUtili.assertEquals(vector, (int) 0, (int) 1);
    }

    @Test
    public void testCopyVectorNConstructor() {
        Vector2i vector = new Vector2i(new VectorNi(0, 1, 2, 3, 4));
        TestUtili.assertEquals(vector, (int) 0, (int) 1);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Vector2i vector = new Vector2i(0.5, 1.7);
        TestUtili.assertEquals(vector, (int) 0, (int) 1);
    }

    @Test
    public void testIntComponentsConstructor() {
        Vector2i vector = new Vector2i((int) 1, (int) 3);
        TestUtili.assertEquals(vector, (int) 1, (int) 3);
    }

    @Test
    public void testGetters() {
        Vector2i vector = new Vector2i(1, 3);
        TestUtili.assertEquals(vector.getX(), (int) 1);
        TestUtili.assertEquals(vector.getY(), (int) 3);
    }

    @Test
    public void testVector2Addition() {
        Vector2i vector = new Vector2i(1, 3).add(new Vector2i(5, -1));
        TestUtili.assertEquals(vector, (int) 6, (int) 2);
    }

    @Test
    public void testDoubleComponentsAddition() {
        Vector2i vector = new Vector2i(1, 3).add(5.5, -1.5);
        TestUtili.assertEquals(vector, (int) 6, (int) 1);
    }

    @Test
    public void testIntComponentsAddition() {
        Vector2i vector = new Vector2i(1, 3).add(5, -1);
        TestUtili.assertEquals(vector, (int) 6, (int) 2);
    }

    @Test
    public void testVector2Subtraction() {
        Vector2i vector = new Vector2i(10, 5).sub(new Vector2i(13, 4));
        TestUtili.assertEquals(vector, (int) -3, (int) 1);
    }

    @Test
    public void testDoubleComponentsSubtraction() {
        Vector2i vector = new Vector2i(10, 5).sub(13, 4);
        TestUtili.assertEquals(vector, (int) -3, (int) 1);
    }

    @Test
    public void testIntComponentsSubtraction() {
        Vector2i vector = new Vector2i(10, 5).sub(13f, 4.5f);
        TestUtili.assertEquals(vector, (int) -3, (int) 1);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Vector2i vector = new Vector2i(2, 3).mul(2.5);
        TestUtili.assertEquals(vector, (int) 4, (int) 6);
    }

    @Test
    public void testIntFactorMultiplication() {
        Vector2i vector = new Vector2i(2, 3).mul((int) 3);
        TestUtili.assertEquals(vector, (int) 6, (int) 9);
    }

    @Test
    public void testVector2Multiplication() {
        Vector2i vector = new Vector2i(2, 3).mul(new Vector2i(5, 2));
        TestUtili.assertEquals(vector, (int) 10, (int) 6);
    }

    @Test
    public void testDoubleComponentsMultiplication() {
        Vector2i vector = new Vector2i(2, 3).mul(1.5, 2.5);
        TestUtili.assertEquals(vector, (int) 2, (int) 6);
    }

    @Test
    public void testIntComponentsMultiplication() {
        Vector2i vector = new Vector2i(2, 3).mul((int) 5, (int) 2);
        TestUtili.assertEquals(vector, (int) 10, (int) 6);
    }

    @Test
    public void testDoubleFactorDivision() {
        Vector2i vector = new Vector2i(2, 5).div(2d);
        TestUtili.assertEquals(vector, (int) 1, (int) 2);
    }

    @Test
    public void testIntFactorDivision() {
        Vector2i vector = new Vector2i(2, 6).div((int) 2);
        TestUtili.assertEquals(vector, (int) 1, (int) 3);
    }

    @Test
    public void testVector2Division() {
        Vector2i vector = new Vector2i(2, 7).div(new Vector2i(2, 3));
        TestUtili.assertEquals(vector, (int) 1, (int) 2);
    }

    @Test
    public void testDoubleComponentsDivision() {
        Vector2i vector = new Vector2i(2, 6).div(2d, 2.5);
        TestUtili.assertEquals(vector, (int) 1, (int) 3);
    }

    @Test
    public void testIntComponentsDivision() {
        Vector2i vector = new Vector2i(2, 7).div((int) 2, (int) 3);
        TestUtili.assertEquals(vector, (int) 1, (int) 2);
    }

    @Test
    public void testVector2DotProduct() {
        int f = new Vector2i(2, 3).dot(new Vector2i(4, 5));
        TestUtili.assertEquals(f, (int) 23);
    }

    @Test
    public void testDoubleComponentsDotProduct() {
        int f = new Vector2i(2, 3).dot(4d, 5d);
        TestUtili.assertEquals(f, (int) 23);
    }

    @Test
    public void testIntComponentsDotProduct() {
        int f = new Vector2i(2, 3).dot(4, 5);
        TestUtili.assertEquals(f, (int) 23);
    }

    @Test
    public void testVector2Project() {
        Vector2i vector = new Vector2i(20, 30).project(new Vector2i(10, 10));
        TestUtili.assertEquals(vector, 25, 25);
    }

    @Test
    public void testDoubleComponentsProject() {
        Vector2i vector = new Vector2i(20, 30).project(10d, 10d);
        TestUtili.assertEquals(vector, 25, 25);
    }

    @Test
    public void testFloatComponentsProject() {
        Vector2i vector = new Vector2i(20, 30).project(10, 10);
        TestUtili.assertEquals(vector, 25, 25);
    }

    @Test
    public void testRaiseToIntPower() {
        Vector2i vector = new Vector2i(2, 6).pow((int) 2);
        TestUtili.assertEquals(vector, (int) 4, (int) 36);
    }

    @Test
    public void testRaiseToDoublePower() {
        Vector2i vector = new Vector2i(2, 6).pow(2d);
        TestUtili.assertEquals(vector, (int) 4, (int) 36);
    }

    @Test
    public void testAbsolute() {
        Vector2i vector1 = new Vector2i(-2, -6).abs();
        TestUtili.assertEquals(vector1, (int) 2, (int) 6);
        Vector2i vector2 = new Vector2i(2, 6).abs();
        TestUtili.assertEquals(vector2, (int) 2, (int) 6);
    }

    @Test
    public void testNegate() {
        Vector2i vector = new Vector2i(2, -6).negate();
        TestUtili.assertEquals(vector, (int) -2, (int) 6);
    }

    @Test
    public void testVector2Minimum() {
        Vector2i vector = new Vector2i(2, 6).min(new Vector2i(3, 4));
        TestUtili.assertEquals(vector, (int) 2, (int) 4);
    }

    @Test
    public void testDoubleComponentsMinimum() {
        Vector2i vector = new Vector2i(2, 6).min(3d, 4d);
        TestUtili.assertEquals(vector, (int) 2, (int) 4);
    }

    @Test
    public void testIntComponentsMinimum() {
        Vector2i vector = new Vector2i(2, 6).min((int) 3, (int) 4);
        TestUtili.assertEquals(vector, (int) 2, (int) 4);
    }

    @Test
    public void testVector2Maximum() {
        Vector2i vector = new Vector2i(2, 6).max(new Vector2i(3, 4));
        TestUtili.assertEquals(vector, (int) 3, (int) 6);
    }

    @Test
    public void testDoubleComponentsMaximum() {
        Vector2i vector = new Vector2i(2, 6).max(3d, 4d);
        TestUtili.assertEquals(vector, (int) 3, (int) 6);
    }

    @Test
    public void testIntComponentsMaximum() {
        Vector2i vector = new Vector2i(2, 6).max((int) 3, (int) 4);
        TestUtili.assertEquals(vector, (int) 3, (int) 6);
    }

    @Test
    public void testVector2DistanceSquared() {
        int f = new Vector2i(2, 3).distanceSquared(new Vector2i(4, 5));
        TestUtili.assertEquals(f, (int) 8);
    }

    @Test
    public void testDoubleComponentsDistanceSquared() {
        int f = new Vector2i(2, 3).distanceSquared(4d, 5d);
        TestUtili.assertEquals(f, (int) 8);
    }

    @Test
    public void testIntComponentsDistanceSquared() {
        int f = new Vector2i(2, 3).distanceSquared((int) 4, (int) 5);
        TestUtili.assertEquals(f, (int) 8);
    }

    @Test
    public void testVector2Distance() {
        float f = new Vector2i(4, 6).distance(new Vector2i(7, 2));
        TestUtilf.assertEquals(f, (int) 5);
    }

    @Test
    public void testDoubleComponentsDistance() {
        float f = new Vector2i(4, 6).distance(7d, 2d);
        TestUtilf.assertEquals(f, (int) 5);
    }

    @Test
    public void testIntComponentsDistance() {
        float f = new Vector2i(4, 6).distance((int) 7, (int) 2);
        TestUtilf.assertEquals(f, (int) 5);
    }

    @Test
    public void testLength() {
        float f = new Vector2i(3, 4).length();
        TestUtilf.assertEquals(f, (int) 5);
    }

    @Test
    public void testLengthSquared() {
        int f = new Vector2i(3, 4).lengthSquared();
        TestUtili.assertEquals(f, (int) 25);
    }

    @Test
    public void testGetMinAxis() {
        Vector2i vector1 = new Vector2i(1, 2);
        TestUtili.assertEquals(vector1.getMinAxis(), 0);
        Vector2i vector2 = new Vector2i(2, 1);
        TestUtili.assertEquals(vector2.getMinAxis(), 1);
    }

    @Test
    public void testGetMaxAxis() {
        Vector2i vector1 = new Vector2i(2, 1);
        TestUtili.assertEquals(vector1.getMaxAxis(), 0);
        Vector2i vector2 = new Vector2i(1, 2);
        TestUtili.assertEquals(vector2.getMaxAxis(), 1);
    }

    @Test
    public void testConvertToVector3DefaultZ() {
        Vector3i vector = new Vector2i(1, 2).toVector3();
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 0);
    }

    @Test
    public void testConvertToVector3IntZ() {
        Vector3i vector = new Vector2i(1, 2).toVector3((int) 3);
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3);
    }

    @Test
    public void testConvertToVector3DoubleZ() {
        Vector3i vector = new Vector2i(1, 2).toVector3(3d);
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3);
    }

    @Test
    public void testConvertToVector4DefaultZW() {
        Vector4i vector = new Vector2i(1, 2).toVector4();
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 0, (int) 0);
    }

    @Test
    public void testConvertToVector4IntZW() {
        Vector4i vector = new Vector2i(1, 2).toVector4((int) 3, (int) 4);
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testConvertToVector4DoubleZW() {
        Vector4i vector = new Vector2i(1, 2).toVector4(3d, 4d);
        TestUtili.assertEquals(vector, (int) 1, (int) 2, (int) 3, (int) 4);
    }

    @Test
    public void testConvertToVectorN() {
        VectorNi vector = new Vector2i(1, 2).toVectorN();
        TestUtili.assertEquals(vector, (int) 1, (int) 2);
    }

    @Test
    public void testConvertToArray() {
        int[] array = new Vector2i(1, 2).toArray();
        TestUtili.assertEquals(array, (int) 1, (int) 2);
    }

    @Test
    public void testComparison() {
        int c1 = new Vector2i(10, 20).compareTo(new Vector2i(20, 20));
        Assert.assertTrue(c1 < 0);
        int c2 = new Vector2i(10, 20).compareTo(new Vector2i(10, 20));
        Assert.assertTrue(c2 == 0);
        int c3 = new Vector2i(10, 20).compareTo(new Vector2i(10, 10));
        Assert.assertTrue(c3 > 0);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Vector2i(122, 43).equals(new Vector2i(122, 43)));
        Assert.assertFalse(new Vector2i(122, 43).equals(new Vector2i(378, 95)));
    }

    @Test
    public void testCloning() {
        Vector2i vector = new Vector2i(3, 2);
        Assert.assertEquals(vector, vector.clone());
    }
}
