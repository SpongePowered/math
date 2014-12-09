package com.flowpowered.math.test.matrix;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.matrix.Matrix2f;
import com.flowpowered.math.matrix.Matrix3f;
import com.flowpowered.math.matrix.Matrix4f;
import com.flowpowered.math.matrix.MatrixNf;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3f;

import static com.flowpowered.math.test.TestUtilf.SQRT13;

public class Matrix3fTest {
    @Test
    public void testDefaultConstructor() {
        Matrix3f matrix = new Matrix3f();
        TestUtilf.assertEquals(matrix, 1, 0, 0, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        Matrix3f matrix = new Matrix3f(new Matrix2f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix, 1, 2, 0, 3, 4, 0, 0, 0, 0);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        Matrix3f matrix = new Matrix3f(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        Matrix3f matrix = new Matrix3f(new Matrix4f(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 5, 6, 7, 9, 10, 11);
    }

    @Test
    public void testCopyMatrixNConstructor() {
        Matrix3f matrix = new Matrix3f(new MatrixNf(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Matrix3f matrix = new Matrix3f(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testGetter() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtilf.assertEquals(matrix.get(0, 0), 1);
        TestUtilf.assertEquals(matrix.get(0, 1), 2);
        TestUtilf.assertEquals(matrix.get(0, 2), 3);
        TestUtilf.assertEquals(matrix.get(1, 0), 4);
        TestUtilf.assertEquals(matrix.get(1, 1), 5);
        TestUtilf.assertEquals(matrix.get(1, 2), 6);
        TestUtilf.assertEquals(matrix.get(2, 0), 7);
        TestUtilf.assertEquals(matrix.get(2, 1), 8);
        TestUtilf.assertEquals(matrix.get(2, 2), 9);
    }

    @Test
    public void testRowGetter() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtilf.assertEquals(matrix.getRow(0), 1, 2, 3);
        TestUtilf.assertEquals(matrix.getRow(1), 4, 5, 6);
        TestUtilf.assertEquals(matrix.getRow(2), 7, 8, 9);
    }

    @Test
    public void testColumnGetter() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtilf.assertEquals(matrix.getColumn(0), 1, 4, 7);
        TestUtilf.assertEquals(matrix.getColumn(1), 2, 5, 8);
        TestUtilf.assertEquals(matrix.getColumn(2), 3, 6, 9);
    }

    @Test
    public void testMatrix3Addition() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).add(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    }

    @Test
    public void testMatrix3Subtraction() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).sub(new Matrix3f(0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5));
        TestUtilf.assertEquals(matrix, (float) 0.5, 1, (float) 1.5, 2, (float) 2.5, 3, (float) 3.5, 4, (float) 4.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).mul(2);
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).mul(2d);
        TestUtilf.assertEquals(matrix, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    }

    @Test
    public void testMatrix3Multiplication() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).mul(new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testFloatFactorDivision() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).div(2);
        TestUtilf.assertEquals(matrix, (float) 0.5, 1, (float) 1.5, 2, (float) 2.5, 3, (float) 3.5, 4, (float) 4.5);
    }

    @Test
    public void testDoubleFactorDivision() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).div(2d);
        TestUtilf.assertEquals(matrix, (float) 0.5, 1, (float) 1.5, 2, (float) 2.5, 3, (float) 3.5, 4, (float) 4.5);
    }

    @Test
    public void testMatrix3Division() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).div(new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testRaiseToFloatPower() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).pow(2);
        TestUtilf.assertEquals(matrix, 1, 4, 9, 16, 25, 36, 49, 64, 81);
    }

    @Test
    public void testRaiseToDoublePower() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).pow(2d);
        TestUtilf.assertEquals(matrix, 1, 4, 9, 16, 25, 36, 49, 64, 81);
    }

    @Test
    public void testTranslateVector2() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).translate(new Vector2f(1, 0));
        TestUtilf.assertEquals(matrix, 1, 0, 1, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testTranslateDoubleComponents() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).translate(1d, 0d);
        TestUtilf.assertEquals(matrix, 1, 0, 1, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testTranslateFloatComponents() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).translate(1, 0);
        TestUtilf.assertEquals(matrix, 1, 0, 1, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testScaleDoubleFactor() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2d);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testScaleFloatFactor() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testScaleVector3() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(new Vector3f(2, 3, 4));
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 3, 0, 0, 0, 4);
    }

    @Test
    public void testScaleDoubleComponents() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2d, 3d, 4d);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 3, 0, 0, 0, 4);
    }

    @Test
    public void testScaleFloatComponents() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2, 3, 4);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 3, 0, 0, 0, 4);
    }

    @Test
    public void testRotateComplex() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).rotate(new Complexf(2, 3));
        TestUtilf.assertEquals(matrix,
                (float) (2/SQRT13), (float) (-3/SQRT13), 0,
                (float) (3/SQRT13), (float) (2/SQRT13), 0,
                0, 0, 1);
    }

    @Test
    public void testRotateQuaternion() {
        Matrix3f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).rotate(new Quaternionf(4, 3, 2, 0));
        TestUtilf.assertEquals(matrix,
                (float) (3/29d), (float) (24/29d), (float) (16/29d),
                (float) (24/29d), (float) (-11/29d), (float) (12/29d),
                (float) (16/29d), (float) (12/29d), (float) (-21/29d));
    }

    @Test
    public void testTransformVector3() {
        Vector3f vector = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2, 3, 1).translate(4, 5).transform(new Vector3f(3, 2, 1));
        TestUtilf.assertEquals(vector, 10, 11, 1);
    }

    @Test
    public void testTransformDoubleComponents() {
        Vector3f vector = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2, 3, 1).translate(4, 5).transform(3d, 2d, 1d);
        TestUtilf.assertEquals(vector, 10, 11, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        Vector3f vector = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2, 3, 1).translate(4, 5).transform(3, 2, 1);
        TestUtilf.assertEquals(vector, 10, 11, 1);
    }

    @Test
    public void testFloor() {
        Matrix3f matrix = new Matrix3f(1.1, 2.9, 3.5, -1.1, -2.5, -3.9, -4.2, 1.4, 8.6).floor();
        TestUtilf.assertEquals(matrix, 1, 2, 3, -2, -3, -4, -5, 1, 8);
    }

    @Test
    public void testCeiling() {
        Matrix3f matrix = new Matrix3f(1.1, 2.9, 3.5, -1.1, -2.5, -3.9, -4.2, 1.4, 8.6).ceil();
        TestUtilf.assertEquals(matrix, 2, 3, 4, -1, -2, -3, -4, 2, 9);
    }

    @Test
    public void testRound() {
        Matrix3f matrix = new Matrix3f(1.1, 2.9, 3.5, -1.1, -2.5, -3.9, -4.2, 1.4, 8.6).round();
        TestUtilf.assertEquals(matrix, 1, 3, 4, -1, -2, -4, -4, 1, 9);
    }

    @Test
    public void testAbsolute() {
        Matrix3f matrix1 = new Matrix3f(-1, -1, -1, -1, -1, -1, -1, -1, -1).abs();
        TestUtilf.assertEquals(matrix1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        Matrix3f matrix2 = new Matrix3f(1, 1, 1, 1, 1, 1, 1, 1, 1).abs();
        TestUtilf.assertEquals(matrix2, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void testNegate() {
        Matrix3f matrix = new Matrix3f(-1, 1, -1, 1, -1, 1, -1, 1, -1).negate();
        TestUtilf.assertEquals(matrix, 1, -1, 1, -1, 1, -1, 1, -1, 1);
    }

    @Test
    public void testTranspose() {
        Matrix3f matrix = new Matrix3f(0, 1, 2, 3, 4, 5, 6, 7, 8).transpose();
        TestUtilf.assertEquals(matrix, 0, 3, 6, 1, 4, 7, 2, 5, 8);
    }

    @Test
    public void testTrace() {
        float f = new Matrix3f(0, 1, 2, 3, 4, 5, 6, 7, 8).trace();
        TestUtilf.assertEquals(f, 12);
    }

    @Test
    public void testDeterminant() {
        float f = new Matrix3f(0, 1, 2, 3, 4, 5, 6, 7, 8).determinant();
        TestUtilf.assertEquals(f, 0);
    }

    @Test
    public void testInvert() {
        Matrix3f matrix2 = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).invert();
        TestUtilf.assertEquals(matrix2, 1, 0, 0, 0, 1, 0, 0, 0, 1);
        Matrix3f matrix3 = new Matrix3f(
                1, 2, 3,
                3, 1, 2,
                2, 3, 1)
                .invert();
        TestUtilf.assertEquals(matrix3,
                (float) (-5/18d), (float) (7/18d), (float) (1/18d),
                (float) (1/18d), (float) (-5/18d), (float) (7/18d),
                (float) (7/18d), (float) (1/18d), (float) (-5/18d));
        try {
            Matrix3f.ZERO.invert();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testConvertToMatrix2() {
        Matrix2f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).toMatrix2();
        TestUtilf.assertEquals(matrix, 1, 0, 0, 1);
    }

    @Test
    public void testConvertToMatrix4() {
        Matrix4f matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).toMatrix4();
        TestUtilf.assertEquals(matrix, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    }

    @Test
    public void testConvertToMatrixN() {
        MatrixNf matrix = new Matrix3f(1, 0, 0, 0, 1, 0, 0, 0, 1).toMatrixN();
        TestUtilf.assertEquals(matrix, 1, 0, 0, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        float[] array = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).toArray(true);
        TestUtilf.assertEquals(array, 1, 4, 7, 2, 5, 8, 3, 6, 9);
    }

    @Test
    public void testConvertToArray() {
        float[] array = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).toArray();
        TestUtilf.assertEquals(array, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).equals(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        Assert.assertFalse(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9).equals(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 0)));
    }

    @Test
    public void testCloning() {
        Matrix3f matrix = new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testCreateFromScalingDoubleFactor() {
        Matrix3f matrix = Matrix3f.createScaling(2d);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingFloatFactor() {
        Matrix3f matrix = Matrix3f.createScaling(2);
        TestUtilf.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingVector3() {
        Matrix3f matrix = Matrix3f.createScaling(new Vector3f(1, 2, 3));
        TestUtilf.assertEquals(matrix, 1, 0, 0, 0, 2, 0, 0, 0, 3);
    }

    @Test
    public void testCreateFromScalingDoubleComponents() {
        Matrix3f matrix = Matrix3f.createScaling(1d, 2d, 3d);
        TestUtilf.assertEquals(matrix, 1, 0, 0, 0, 2, 0, 0, 0, 3);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        Matrix3f matrix = Matrix3f.createScaling(1, 2, 3);
        TestUtilf.assertEquals(matrix, 1, 0, 0, 0, 2, 0, 0, 0, 3);
    }

    @Test
    public void testCreateTranslationVector2() {
        Matrix3f matrix1 = Matrix3f.createTranslation(new Vector2f(1, 0));
        TestUtilf.assertEquals(matrix1, 1, 0, 1, 0, 1, 0, 0, 0, 1);
        Matrix3f matrix2 = Matrix3f.createTranslation(new Vector2f(0, 1));
        TestUtilf.assertEquals(matrix2, 1, 0, 0, 0, 1, 1, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationDoubleComponents() {
        Matrix3f matrix1 = Matrix3f.createTranslation(1d, 0d);
        TestUtilf.assertEquals(matrix1, 1, 0, 1, 0, 1, 0, 0, 0, 1);
        Matrix3f matrix2 = Matrix3f.createTranslation(0d, 1d);
        TestUtilf.assertEquals(matrix2, 1, 0, 0, 0, 1, 1, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationFloatComponents() {
        Matrix3f matrix1 = Matrix3f.createTranslation(1, 0);
        TestUtilf.assertEquals(matrix1, 1, 0, 1, 0, 1, 0, 0, 0, 1);
        Matrix3f matrix2 = Matrix3f.createTranslation(0, 1);
        TestUtilf.assertEquals(matrix2, 1, 0, 0, 0, 1, 1, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        Matrix3f matrix = Matrix3f.createRotation(new Complexf(2, 3));
        TestUtilf.assertEquals(matrix,
                (float) (2/SQRT13), (float) (-3/SQRT13), 0,
                (float) (3/SQRT13), (float) (2/SQRT13), 0,
                0, 0, 1);
    }

    @Test
    public void testCreateRotationFromQuaternion() {
        Matrix3f matrix = Matrix3f.createRotation(new Quaternionf(4, 3, 2, 0));
        TestUtilf.assertEquals(matrix,
                (float) (3/29d), (float) (24/29d), (float) (16/29d),
                (float) (24/29d), (float) (-11/29d), (float) (12/29d),
                (float) (16/29d), (float) (12/29d), (float) (-21/29d));

    }
}
