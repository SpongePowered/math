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
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector4f;

import static com.flowpowered.math.test.TestUtilf.SQRT13;

public class Matrix4fTest {
    @Test
    public void testDefaultConstructor() {
        Matrix4f matrix = new Matrix4f();
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        Matrix4f matrix = new Matrix4f(new Matrix2f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix,
                1, 2, 0, 0,
                3, 4, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        Matrix4f matrix = new Matrix4f(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 0,
                4, 5, 6, 0,
                7, 8, 9, 0,
                0, 0, 0, 0);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        Matrix4f matrix = new Matrix4f(new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16));
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testCopyMatrixNConstructor() {
        Matrix4f matrix = new Matrix4f(new MatrixNf(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16
                ));
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Matrix4f matrix = new Matrix4f(
                1d, 2d, 3d, 4d,
                5d, 6d, 7d, 8d,
                9d, 10d, 11d, 12d,
                13d, 14d, 15d, 16d);
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testGetter() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtilf.assertEquals(matrix.get(0, 0), 1);
        TestUtilf.assertEquals(matrix.get(0, 1), 2);
        TestUtilf.assertEquals(matrix.get(0, 2), 3);
        TestUtilf.assertEquals(matrix.get(0, 3), 4);
        TestUtilf.assertEquals(matrix.get(1, 0), 5);
        TestUtilf.assertEquals(matrix.get(1, 1), 6);
        TestUtilf.assertEquals(matrix.get(1, 2), 7);
        TestUtilf.assertEquals(matrix.get(1, 3), 8);
        TestUtilf.assertEquals(matrix.get(2, 0), 9);
        TestUtilf.assertEquals(matrix.get(2, 1), 10);
        TestUtilf.assertEquals(matrix.get(2, 2), 11);
        TestUtilf.assertEquals(matrix.get(2, 3), 12);
        TestUtilf.assertEquals(matrix.get(3, 0), 13);
        TestUtilf.assertEquals(matrix.get(3, 1), 14);
        TestUtilf.assertEquals(matrix.get(3, 2), 15);
        TestUtilf.assertEquals(matrix.get(3, 3), 16);
    }

    @Test
    public void testRowGetter() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtilf.assertEquals(matrix.getRow(0), 1, 2, 3, 4);
        TestUtilf.assertEquals(matrix.getRow(1), 5, 6, 7, 8);
        TestUtilf.assertEquals(matrix.getRow(2), 9, 10, 11, 12);
        TestUtilf.assertEquals(matrix.getRow(3), 13, 14, 15, 16);
    }

    @Test
    public void testColumnGetter() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtilf.assertEquals(matrix.getColumn(0), 1, 5, 9, 13);
        TestUtilf.assertEquals(matrix.getColumn(1), 2, 6, 10, 14);
        TestUtilf.assertEquals(matrix.getColumn(2), 3, 7, 11, 15);
        TestUtilf.assertEquals(matrix.getColumn(3), 4, 8, 12, 16);
    }

    @Test
    public void testMatrix4Addition() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        Matrix4f m = new Matrix4f(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        matrix = matrix.add(m);
        TestUtilf.assertEquals(matrix,
                2, 3, 4, 5,
                6, 7, 8, 9,
                10, 11, 12, 13,
                14, 15, 16, 17);
    }

    @Test
    public void testMatrix4Subtraction() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        Matrix4f m = new Matrix4f(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        matrix = matrix.sub(m);
        TestUtilf.assertEquals(matrix,
                0, 1, 2, 3,
                4, 5, 6, 7,
                8, 9, 10, 11,
                12, 13, 14, 15);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.mul(2);
        TestUtilf.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.mul(2d);
        TestUtilf.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testMatrix4Multiplication() {
        Matrix4f matrix = new Matrix4f(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Matrix4f m = new Matrix4f(
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 4, 1);
        matrix = matrix.mul(m);
        TestUtilf.assertEquals(matrix,
                -1, 10, 0, 0,
                0, 1, 16, 4,
                0, 0, 1, 0,
                0, 0, 4, 1);
    }

    @Test
    public void testFloatFactorDivision() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.div(0.5f);
        TestUtilf.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testDoubleFactorDivision() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.div(0.5);
        TestUtilf.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testMatrix4Division() {
        Matrix4f matrix = new Matrix4f(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Matrix4f m = new Matrix4f(
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 4, 1);
        matrix = matrix.div(m);
        TestUtilf.assertEquals(matrix,
                -1, 10, 0, 0,
                0, 1, -16, 4,
                0, 0, 1, 0,
                0, 0, -4, 1);
    }

    @Test
    public void testRaiseToFloatPower() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.pow(2);
        TestUtilf.assertEquals(matrix,
                1, 4, 9, 16,
                25, 36, 49, 64,
                81, 100, 121, 144,
                169, 196, 225, 256);
    }

    @Test
    public void testRaiseToDoublePower() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.pow(2d);
        TestUtilf.assertEquals(matrix,
                1, 4, 9, 16,
                25, 36, 49, 64,
                81, 100, 121, 144,
                169, 196, 225, 256);
    }

    @Test
    public void testTranslateVector3() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(new Vector3f(2, 3, 4));
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testTranslateDoubleComponents() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(2d, 3d, 4d);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testTranslateFloatComponents() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(2, 3, 4);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testScaleDoubleFactor() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2d);
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testScaleFloatFactor() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2);
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testScaleVector4() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(new Vector4f(2, 3, 4, 5));
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testScaleDoubleComponents() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2d, 3d, 4d, 5d);
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testScaleFloatComponents() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2, 3, 4, 5);
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testRotateComplex() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.rotate(new Complexf(2, 3));
        TestUtilf.assertEquals(matrix,
                (float) (2/SQRT13), (float) (-3/SQRT13), 0, 0,
                (float) (3/SQRT13), (float) (2/SQRT13), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testRotateQuaternion() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.rotate(new Quaternionf(4, 3, 2, 0));
        TestUtilf.assertEquals(matrix,
                (float) (3/29d), (float) (24/29d), (float) (16/29d), 0,
                (float) (24/29d), (float) (-11/29d), (float) (12/29d), 0,
                (float) (16/29d), (float) (12/29d), (float) (-21/29d), 0,
                0, 0, 0, 1);
    }

    @Test
    public void testTransformVector4() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Vector4f vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(new Vector4f(3, 2, 8, 1));
        TestUtilf.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testTransformDoubleComponents() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Vector4f vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(3d, 2d, 8d, 1d);
        TestUtilf.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Vector4f vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(3, 2, 8, 1);
        TestUtilf.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testFloor() {
        Matrix4f matrix = new Matrix4f(
                -1.1, 2.5, 2.9, 3.2,
                -6.3, 2.2, 2.1, 5.6,
                -8.8, 8.1, 4.6, 6.7,
                -1.3, 1.7, 7.3, 7.6);
        matrix = matrix.floor();
        TestUtilf.assertEquals(matrix,
                -2, 2, 2, 3,
                -7, 2, 2, 5,
                -9, 8, 4, 6,
                -2, 1, 7, 7);
    }

    @Test
    public void testCeiling() {
        Matrix4f matrix = new Matrix4f(
                -1.1, 2.5, 2.9, 3.2,
                -6.3, 2.2, 2.1, 5.6,
                -8.8, 8.1, 4.6, 6.7,
                -1.3, 1.7, 7.3, 7.6);
        matrix = matrix.ceil();
        TestUtilf.assertEquals(matrix,
                -1, 3, 3, 4,
                -6, 3, 3, 6,
                -8, 9, 5, 7,
                -1, 2, 8, 8);
    }

    @Test
    public void testRound() {
        Matrix4f matrix = new Matrix4f(
                -1.1, 2.5, 2.9, 3.2,
                -6.3, 2.2, 2.1, 5.6,
                -8.8, 8.1, 4.6, 6.7,
                -1.3, 1.7, 7.3, 7.6);
        matrix = matrix.round();
        TestUtilf.assertEquals(matrix,
                -1, 3, 3, 3,
                -6, 2, 2, 6,
                -9, 8, 5, 7,
                -1, 2, 7, 8);
    }

    @Test
    public void testAbsolute() {
        Matrix4f matrix = new Matrix4f(
                -1, -1, -1, -1,
                -1, -1, -1, -1,
                -1, -1, -1, -1,
                -1, -1, -1, -1);
        matrix = matrix.abs();
        TestUtilf.assertEquals(matrix,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        Matrix4f matrix2 = new Matrix4f(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        matrix2 = matrix2.abs();
        TestUtilf.assertEquals(matrix2,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
    }

    @Test
    public void testNegate() {
        Matrix4f matrix = new Matrix4f(
                1, -1, 1, -1,
                -1, 1, -1, 1,
                1, -1, 1, -1,
                -1, 1, -1, 1);
        matrix = matrix.negate();
        TestUtilf.assertEquals(matrix,
                -1, 1, -1, 1,
                1, -1, 1, -1,
                -1, 1, -1, 1,
                1, -1, 1, -1);
    }

    @Test
    public void testTranspose() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.transpose();
        TestUtilf.assertEquals(matrix,
                1, 5, 9, 13,
                2, 6, 10, 14,
                3, 7, 11, 15,
                4, 8, 12, 16);
    }

    @Test
    public void testTrace() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float value = matrix.trace();
        TestUtilf.assertEquals(value, 10);
    }

    @Test
    public void testDeterminant() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float value = matrix.determinant();
        TestUtilf.assertEquals(value, 24);
    }

    @Test
    public void testInvert() {
        Matrix4f matrix0 = new Matrix4f(
                1, 2, 3, 4,
                4, 1, 2, 3,
                3, 4, 1, 2,
                2, 3, 1, 4);
        Matrix4f matrix = matrix0.invert();
        TestUtilf.assertEquals(matrix,
                (float) -0.1875, (float) 0.275, (float) 0.0625, (float) -0.05,
                (float) 0.0625, (float) -0.225, (float) 0.3125, (float) -0.05,
                (float) 0.4375, (float) 0.025, (float) 0.1875, (float) -0.55,
                (float) -0.0625, (float) 0.025, (float) -0.3125, (float) 0.45);
        try {
            Matrix4f.ZERO.invert();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testConvertToMatrix2() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix2f matrix2 = matrix.toMatrix2();
        TestUtilf.assertEquals(matrix2,
                1, 0,
                0, 2);
    }

    @Test
    public void testConvertToMatrix3() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix3f matrix3 = matrix.toMatrix3();
        TestUtilf.assertEquals(matrix3,
                1, 0, 0,
                0, 2, 0,
                0, 0, 3);
    }

    @Test
    public void testConvertToMatrixN() {
        Matrix4f matrix = new Matrix4f(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNf matrixN = matrix.toMatrixN();
        TestUtilf.assertEquals(matrixN,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float[] array = matrix.toArray(true);
        TestUtilf.assertEquals(array,
                1, 0, 0, 0,
                2, 2, 0, 0,
                3, 0, 3, 0,
                4, 0, 0, 4);
    }

    @Test
    public void testConvertToArray() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float[] array = matrix.toArray();
        TestUtilf.assertEquals(array,
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testEquals() {
        Matrix4f matrix01 = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix4f matrix02 = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertTrue(matrix01.equals(matrix02));
        Matrix4f matrix11 = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix4f matrix12 = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 4, 0,
                0, 7, 3, 0,
                0, 0, 0, 4);
        Assert.assertFalse(matrix11.equals(matrix12));
    }

    @Test
    public void testCloning() {
        Matrix4f matrix = new Matrix4f(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testMatrixFromN() {
        Matrix4f matrix = Matrix4f.from(1);
        TestUtilf.assertEquals(matrix, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void testMatrixFromMany() {
        Matrix4f matrix = Matrix4f.from(
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 16);
        TestUtilf.assertEquals(matrix,
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 16);
    }

    @Test
    public void testMatrixFromDiagonal() {
        Matrix4f matrix = Matrix4f.fromDiagonal(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix,
            1, 0, 0, 0,
            0, 2, 0, 0,
            0, 0, 3, 0,
            0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingDoubleFactor() {
        Matrix4f matrix = Matrix4f.createScaling(2d);
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingFloatFactor() {
        Matrix4f matrix = Matrix4f.createScaling(2);
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingVector4() {
        Matrix4f matrix = Matrix4f.createScaling(new Vector4f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingDoubleComponents() {
        Matrix4f matrix = Matrix4f.createScaling(1d, 2d, 3d, 4d);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        Matrix4f matrix = Matrix4f.createScaling(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateTranslationVector3() {
        Matrix4f matrix = Matrix4f.createTranslation(new Vector3f(1, 2, 3));
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationDoubleComponents() {
        Matrix4f matrix = Matrix4f.createTranslation(1d, 2d, 3d);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationFloatComponents() {
        Matrix4f matrix = Matrix4f.createTranslation(1, 2, 3);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        Matrix4f matrix = Matrix4f.createRotation(new Complexf(2, 3));
        TestUtilf.assertEquals(matrix,
                (float) (2/SQRT13), (float) (-3/SQRT13), 0, 0,
                (float) (3/SQRT13), (float) (2/SQRT13), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromQuaternion() {
        Matrix4f matrix = Matrix4f.createRotation(new Quaternionf(4, 3, 2, 0));
        TestUtilf.assertEquals(matrix,
                (float) (3/29d), (float) (24/29d), (float) (16/29d), 0,
                (float) (24/29d), (float) (-11/29d), (float) (12/29d), 0,
                (float) (16/29d), (float) (12/29d), (float) (-21/29d), 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateLookAt() {
        // TODO: figure out a test for this
    }

    @Test
    public void testCreatePerspectiveDouble() {
        // TODO: figure out a test for this
    }

    @Test
    public void testCreatePerspectiveFloat() {
        // TODO: figure out a test for this
    }

    @Test
    public void testCreateOrthographicDouble() {
        // TODO: figure out a test for this
    }

    @Test
    public void testCreateOrthographicFloat() {
        // TODO: figure out a test for this
    }
}
