package com.flowpowered.math.test.matrix;

import static com.flowpowered.math.test.TestUtilf.SQRT13;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.matrix.Matrix2f;
import com.flowpowered.math.matrix.Matrix3f;
import com.flowpowered.math.matrix.Matrix4f;
import com.flowpowered.math.matrix.MatrixNf;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector2f;

public class Matrix2fTest {
    @Test
    public void testDefaultConstructor() {
        Matrix2f matrix = new Matrix2f();
        TestUtilf.assertEquals(matrix, 1, 0, 0, 1);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        Matrix2f matrix = new Matrix2f(new Matrix2f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        Matrix2f matrix = new Matrix2f(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtilf.assertEquals(matrix, 1, 2, 4, 5);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        Matrix2f matrix = new Matrix2f(new Matrix4f(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        TestUtilf.assertEquals(matrix, 1, 2, 5, 6);
    }

    @Test
    public void testCopyMatrixNConstructor() {
        Matrix2f matrix = new Matrix2f(new MatrixNf(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Matrix2f matrix = new Matrix2f(1d, 2d, 3d, 4d);
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testGetter() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.get(0, 0), 1);
        TestUtilf.assertEquals(matrix.get(0, 1), 2);
        TestUtilf.assertEquals(matrix.get(1, 0), 3);
        TestUtilf.assertEquals(matrix.get(1, 1), 4);
    }

    @Test
    public void testRowGetter() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.getRow(0), 1, 2);
        TestUtilf.assertEquals(matrix.getRow(1), 3, 4);
    }

    @Test
    public void testColumnGetter() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.getColumn(0), 1, 3);
        TestUtilf.assertEquals(matrix.getColumn(1), 2, 4);
    }

    @Test
    public void testMatrix2Addition() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).add(new Matrix2f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testMatrix2Subtraction() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).sub(new Matrix2f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix, 0, 0, 0, 0);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).mul(2f);
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).mul(2d);
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testMatrix2Multiplication() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).mul(new Matrix2f(1, 0, 0, 1));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testFloatFactorDivision() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).div(0.5f);
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testDoubleFactorDivision() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).div(0.5);
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testMatrix2Division() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).mul(new Matrix2f(1, 0, 0, 1));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testRaiseToFloatPower() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).pow(2f);
        TestUtilf.assertEquals(matrix, 1, 4, 9, 16);
    }

    @Test
    public void testRaiseToDoublePower() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).pow(2d);
        TestUtilf.assertEquals(matrix, 1, 4, 9, 16);
    }

    @Test
    public void testTranslateDoubleDistance() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).translate(5d);
        TestUtilf.assertEquals(matrix, 1, 5, 0, 1);
    }

    @Test
    public void testTranslateFloatDistance() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).translate(5f);
        TestUtilf.assertEquals(matrix, 1, 5, 0, 1);
    }

    @Test
    public void testScaleDoubleFactor() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).scale(2.5);
        TestUtilf.assertEquals(matrix, (float) 2.5, 0, 0, (float) 2.5);
    }

    @Test
    public void testScaleFloatFactor() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).scale(2.5f);
        TestUtilf.assertEquals(matrix, (float) 2.5, 0, 0, (float) 2.5);
    }

    @Test
    public void testScaleVector2() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).scale(new Vector2f(2, 3));
        TestUtilf.assertEquals(matrix, 2, 0, 0, 3);
    }

    @Test
    public void testScaleDoubleComponents() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).scale(2d, 3d);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 3);
    }

    @Test
    public void testScaleFloatComponents() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).scale(2, 3);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 3);
    }

    @Test
    public void testRotateComplex() {
        Matrix2f matrix = new Matrix2f(1, 0, 0, 1).rotate(new Complexf(0, 1));
        TestUtilf.assertEquals(matrix, 0, -1, 1, 0);
    }

    @Test
    public void testTransformVector2() {
        Vector2f vector = new Matrix2f(1, 0, 0, 1).scale(2, 1).translate(4).transform(new Vector2f(3, 1));
        TestUtilf.assertEquals(vector, 10, 1);
    }

    @Test
    public void testTransformDoubleComponents() {
        Vector2f vector = new Matrix2f(1, 0, 0, 1).scale(2, 1).translate(4).transform(3d, 1d);
        TestUtilf.assertEquals(vector, 10, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        Vector2f vector = new Matrix2f(1, 0, 0, 1).scale(2, 1).translate(4).transform(3, 1);
        TestUtilf.assertEquals(vector, 10, 1);
    }

    @Test
    public void testFloor() {
        Matrix2f matrix = new Matrix2f(1.1, 2.5, 3.9, -4.8).floor();
        TestUtilf.assertEquals(matrix, 1, 2, 3, -5);
    }

    @Test
    public void testCeiling() {
        Matrix2f matrix = new Matrix2f(1.1, 2.5, 3.9, -4.8).ceil();
        TestUtilf.assertEquals(matrix, 2, 3, 4, -4);
    }

    @Test
    public void testRound() {
        Matrix2f matrix = new Matrix2f(1.1, 2.5, 3.9, -4.8).round();
        TestUtilf.assertEquals(matrix, 1, 3, 4, -5);
    }

    @Test
    public void testAbsolute() {
        Matrix2f matrix = new Matrix2f(1.1, 2.5, 3.9, -4.8).abs();
        TestUtilf.assertEquals(matrix, (float) 1.1, (float) 2.5, (float) 3.9, (float) 4.8);
    }

    @Test
    public void testNegate() {
        Matrix2f matrix = new Matrix2f(1.1, 2.5, 3.9, -4.8).negate();
        TestUtilf.assertEquals(matrix, (float) -1.1, (float) -2.5, (float) -3.9, (float) 4.8);
    }

    @Test
    public void testTranspose() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).transpose();
        TestUtilf.assertEquals(matrix, 1, 3, 2, 4);
    }

    @Test
    public void testTrace() {
        float f = new Matrix2f(1, 2, 3, 4).trace();
        TestUtilf.assertEquals(f, 5);
    }

    @Test
    public void testDeterminant() {
        float f = new Matrix2f(1, 2, 3, 4).determinant();
        TestUtilf.assertEquals(f, -2);
    }

    @Test
    public void testInvert() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4).invert();
        TestUtilf.assertEquals(matrix, -2, 1, (float) 1.5, (float) -0.5);
        try {
            Matrix2f.ZERO.invert();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testConvertToMatrix3() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.toMatrix3(), 1, 2, 0, 3, 4, 0, 0, 0, 0);
    }

    @Test
    public void testConvertToMatrix4() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.toMatrix4(), 1, 2, 0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testConvertToMatrixN() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.toMatrixN(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        float[] array = new Matrix2f(1, 2, 3, 4).toArray(true);
        TestUtilf.assertEquals(array, 1, 3, 2, 4);
    }

    @Test
    public void testConvertToArray() {
        float[] array = new Matrix2f(1, 2, 3, 4).toArray();
        TestUtilf.assertEquals(array, 1, 2, 3, 4);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Matrix2f(1, 2, 3, 4).equals(new Matrix2f(1, 2, 3, 4)));
        Assert.assertFalse(new Matrix2f(1, 2, 3, 4).equals(new Matrix2f(1, 2, 3, 5)));
    }

    @Test
    public void testCloning() {
        Matrix2f matrix = new Matrix2f(1, 2, 3, 4);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testCreateFromScalingDoubleFactor() {
        Matrix2f matrix = Matrix2f.createScaling(2d);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingFloatFactor() {
        Matrix2f matrix = Matrix2f.createScaling(2);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingVector2() {
        Matrix2f matrix = Matrix2f.createScaling(new Vector2f(2, 1.5));
        TestUtilf.assertEquals(matrix, 2, 0, 0, (float) 1.5);
    }

    @Test
    public void testCreateFromScalingDoubleComponents() {
        Matrix2f matrix = Matrix2f.createScaling(2, 1.5);
        TestUtilf.assertEquals(matrix, 2, 0, 0, (float) 1.5);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        Matrix2f matrix = Matrix2f.createScaling(2, 1.5f);
        TestUtilf.assertEquals(matrix, 2, 0, 0, (float) 1.5);
    }

    @Test
    public void testCreateTranslationFromDoubleDistance() {
        Matrix2f matrix = Matrix2f.createTranslation(5d);
        TestUtilf.assertEquals(matrix, 1, 5, 0, 1);
    }


    @Test
    public void testCreateTranslationFromFloatDistance() {
        Matrix2f matrix = Matrix2f.createTranslation(5);
        TestUtilf.assertEquals(matrix, 1, 5, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        Matrix2f matrix = Matrix2f.createRotation(new Complexf(2, 3));
        TestUtilf.assertEquals(matrix,
                (float) (2/SQRT13), (float) (-3/SQRT13),
                (float) (3/SQRT13), (float) (2/SQRT13));
    }
}
