package com.flowpowered.math.test.matrix;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix2d;
import com.flowpowered.math.matrix.Matrix3d;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.matrix.MatrixNd;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector4d;

import static com.flowpowered.math.test.TestUtild.SQRT13;

public class Matrix4dTest {
    @Test
    public void testDefaultConstructor() {
        Matrix4d matrix = new Matrix4d();
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        Matrix4d matrix = new Matrix4d(new Matrix2d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix,
                1, 2, 0, 0,
                3, 4, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        Matrix4d matrix = new Matrix4d(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtild.assertEquals(matrix,
                1, 2, 3, 0,
                4, 5, 6, 0,
                7, 8, 9, 0,
                0, 0, 0, 0);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        Matrix4d matrix = new Matrix4d(new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16));
        TestUtild.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testCopyMatrixNConstructor() {
        Matrix4d matrix = new Matrix4d(new MatrixNd(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16
                ));
        TestUtild.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Matrix4d matrix = new Matrix4d(
                1d, 2d, 3d, 4d,
                5d, 6d, 7d, 8d,
                9d, 10d, 11d, 12d,
                13d, 14d, 15d, 16d);
        TestUtild.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtild.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testGetter() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtild.assertEquals(matrix.get(0, 0), 1);
        TestUtild.assertEquals(matrix.get(0, 1), 2);
        TestUtild.assertEquals(matrix.get(0, 2), 3);
        TestUtild.assertEquals(matrix.get(0, 3), 4);
        TestUtild.assertEquals(matrix.get(1, 0), 5);
        TestUtild.assertEquals(matrix.get(1, 1), 6);
        TestUtild.assertEquals(matrix.get(1, 2), 7);
        TestUtild.assertEquals(matrix.get(1, 3), 8);
        TestUtild.assertEquals(matrix.get(2, 0), 9);
        TestUtild.assertEquals(matrix.get(2, 1), 10);
        TestUtild.assertEquals(matrix.get(2, 2), 11);
        TestUtild.assertEquals(matrix.get(2, 3), 12);
        TestUtild.assertEquals(matrix.get(3, 0), 13);
        TestUtild.assertEquals(matrix.get(3, 1), 14);
        TestUtild.assertEquals(matrix.get(3, 2), 15);
        TestUtild.assertEquals(matrix.get(3, 3), 16);
    }

    @Test
    public void testRowGetter() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtild.assertEquals(matrix.getRow(0), 1, 2, 3, 4);
        TestUtild.assertEquals(matrix.getRow(1), 5, 6, 7, 8);
        TestUtild.assertEquals(matrix.getRow(2), 9, 10, 11, 12);
        TestUtild.assertEquals(matrix.getRow(3), 13, 14, 15, 16);
    }

    @Test
    public void testColumnGetter() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        TestUtild.assertEquals(matrix.getColumn(0), 1, 5, 9, 13);
        TestUtild.assertEquals(matrix.getColumn(1), 2, 6, 10, 14);
        TestUtild.assertEquals(matrix.getColumn(2), 3, 7, 11, 15);
        TestUtild.assertEquals(matrix.getColumn(3), 4, 8, 12, 16);
    }

    @Test
    public void testMatrix4Addition() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        Matrix4d m = new Matrix4d(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        matrix = matrix.add(m);
        TestUtild.assertEquals(matrix,
                2, 3, 4, 5,
                6, 7, 8, 9,
                10, 11, 12, 13,
                14, 15, 16, 17);
    }

    @Test
    public void testMatrix4Subtraction() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        Matrix4d m = new Matrix4d(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        matrix = matrix.sub(m);
        TestUtild.assertEquals(matrix,
                0, 1, 2, 3,
                4, 5, 6, 7,
                8, 9, 10, 11,
                12, 13, 14, 15);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.mul(2);
        TestUtild.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.mul(2d);
        TestUtild.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testMatrix4Multiplication() {
        Matrix4d matrix = new Matrix4d(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Matrix4d m = new Matrix4d(
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 4, 1);
        matrix = matrix.mul(m);
        TestUtild.assertEquals(matrix,
                -1, 10, 0, 0,
                0, 1, 16, 4,
                0, 0, 1, 0,
                0, 0, 4, 1);
    }

    @Test
    public void testFloatFactorDivision() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.div(0.5f);
        TestUtild.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testDoubleFactorDivision() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.div(0.5);
        TestUtild.assertEquals(matrix,
                2, 4, 6, 8,
                10, 12, 14, 16,
                18, 20, 22, 24,
                26, 28, 30, 32);
    }

    @Test
    public void testMatrix4Division() {
        Matrix4d matrix = new Matrix4d(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Matrix4d m = new Matrix4d(
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 4, 1);
        matrix = matrix.div(m);
        TestUtild.assertEquals(matrix,
                -1, 10, 0, 0,
                0, 1, -16, 4,
                0, 0, 1, 0,
                0, 0, -4, 1);
    }

    @Test
    public void testRaiseToFloatPower() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.pow(2);
        TestUtild.assertEquals(matrix,
                1, 4, 9, 16,
                25, 36, 49, 64,
                81, 100, 121, 144,
                169, 196, 225, 256);
    }

    @Test
    public void testRaiseToDoublePower() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.pow(2d);
        TestUtild.assertEquals(matrix,
                1, 4, 9, 16,
                25, 36, 49, 64,
                81, 100, 121, 144,
                169, 196, 225, 256);
    }

    @Test
    public void testTranslateVector3() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(new Vector3d(2, 3, 4));
        TestUtild.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testTranslateDoubleComponents() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(2d, 3d, 4d);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testTranslateFloatComponents() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(2, 3, 4);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testScaleDoubleFactor() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2d);
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testScaleFloatFactor() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2);
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testScaleVector4() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(new Vector4d(2, 3, 4, 5));
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testScaleDoubleComponents() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2d, 3d, 4d, 5d);
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testScaleFloatComponents() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(2, 3, 4, 5);
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testRotateComplex() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.rotate(new Complexd(2, 3));
        TestUtild.assertEquals(matrix,
                (double) (2/SQRT13), (double) (-3/SQRT13), 0, 0,
                (double) (3/SQRT13), (double) (2/SQRT13), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testRotateQuaternion() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.rotate(new Quaterniond(4, 3, 2, 0));
        TestUtild.assertEquals(matrix,
                (double) (3/29d), (double) (24/29d), (double) (16/29d), 0,
                (double) (24/29d), (double) (-11/29d), (double) (12/29d), 0,
                (double) (16/29d), (double) (12/29d), (double) (-21/29d), 0,
                0, 0, 0, 1);
    }

    @Test
    public void testTransformVector4() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Vector4d vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(new Vector4d(3, 2, 8, 1));
        TestUtild.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testTransformDoubleComponents() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Vector4d vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(3d, 2d, 8d, 1d);
        TestUtild.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        Vector4d vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(3, 2, 8, 1);
        TestUtild.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testFloor() {
        Matrix4d matrix = new Matrix4d(
                -1.1, 2.5, 2.9, 3.2,
                -6.3, 2.2, 2.1, 5.6,
                -8.8, 8.1, 4.6, 6.7,
                -1.3, 1.7, 7.3, 7.6);
        matrix = matrix.floor();
        TestUtild.assertEquals(matrix,
                -2, 2, 2, 3,
                -7, 2, 2, 5,
                -9, 8, 4, 6,
                -2, 1, 7, 7);
    }

    @Test
    public void testCeiling() {
        Matrix4d matrix = new Matrix4d(
                -1.1, 2.5, 2.9, 3.2,
                -6.3, 2.2, 2.1, 5.6,
                -8.8, 8.1, 4.6, 6.7,
                -1.3, 1.7, 7.3, 7.6);
        matrix = matrix.ceil();
        TestUtild.assertEquals(matrix,
                -1, 3, 3, 4,
                -6, 3, 3, 6,
                -8, 9, 5, 7,
                -1, 2, 8, 8);
    }

    @Test
    public void testRound() {
        Matrix4d matrix = new Matrix4d(
                -1.1, 2.5, 2.9, 3.2,
                -6.3, 2.2, 2.1, 5.6,
                -8.8, 8.1, 4.6, 6.7,
                -1.3, 1.7, 7.3, 7.6);
        matrix = matrix.round();
        TestUtild.assertEquals(matrix,
                -1, 3, 3, 3,
                -6, 2, 2, 6,
                -9, 8, 5, 7,
                -1, 2, 7, 8);
    }

    @Test
    public void testAbsolute() {
        Matrix4d matrix = new Matrix4d(
                -1, -1, -1, -1,
                -1, -1, -1, -1,
                -1, -1, -1, -1,
                -1, -1, -1, -1);
        matrix = matrix.abs();
        TestUtild.assertEquals(matrix,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        Matrix4d matrix2 = new Matrix4d(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
        matrix2 = matrix2.abs();
        TestUtild.assertEquals(matrix2,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1);
    }

    @Test
    public void testNegate() {
        Matrix4d matrix = new Matrix4d(
                1, -1, 1, -1,
                -1, 1, -1, 1,
                1, -1, 1, -1,
                -1, 1, -1, 1);
        matrix = matrix.negate();
        TestUtild.assertEquals(matrix,
                -1, 1, -1, 1,
                1, -1, 1, -1,
                -1, 1, -1, 1,
                1, -1, 1, -1);
    }

    @Test
    public void testTranspose() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix = matrix.transpose();
        TestUtild.assertEquals(matrix,
                1, 5, 9, 13,
                2, 6, 10, 14,
                3, 7, 11, 15,
                4, 8, 12, 16);
    }

    @Test
    public void testTrace() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double value = matrix.trace();
        TestUtild.assertEquals(value, 10);
    }

    @Test
    public void testDeterminant() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double value = matrix.determinant();
        TestUtild.assertEquals(value, 24);
    }

    @Test
    public void testInvert() {
        Matrix4d matrix0 = new Matrix4d(
                1, 2, 3, 4,
                4, 1, 2, 3,
                3, 4, 1, 2,
                2, 3, 1, 4);
        Matrix4d matrix = matrix0.invert();
        TestUtild.assertEquals(matrix,
                (double) -0.1875, (double) 0.275, (double) 0.0625, (double) -0.05,
                (double) 0.0625, (double) -0.225, (double) 0.3125, (double) -0.05,
                (double) 0.4375, (double) 0.025, (double) 0.1875, (double) -0.55,
                (double) -0.0625, (double) 0.025, (double) -0.3125, (double) 0.45);
        try {
            Matrix4d.ZERO.invert();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testConvertToMatrix2() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix2d matrix2 = matrix.toMatrix2();
        TestUtild.assertEquals(matrix2,
                1, 0,
                0, 2);
    }

    @Test
    public void testConvertToMatrix3() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix3d matrix3 = matrix.toMatrix3();
        TestUtild.assertEquals(matrix3,
                1, 0, 0,
                0, 2, 0,
                0, 0, 3);
    }

    @Test
    public void testConvertToMatrixN() {
        Matrix4d matrix = new Matrix4d(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNd matrixN = matrix.toMatrixN();
        TestUtild.assertEquals(matrixN,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double[] array = matrix.toArray(true);
        TestUtild.assertEquals(array,
                1, 0, 0, 0,
                2, 2, 0, 0,
                3, 0, 3, 0,
                4, 0, 0, 4);
    }

    @Test
    public void testConvertToArray() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double[] array = matrix.toArray();
        TestUtild.assertEquals(array,
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testEquals() {
        Matrix4d matrix01 = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix4d matrix02 = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertTrue(matrix01.equals(matrix02));
        Matrix4d matrix11 = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix4d matrix12 = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 4, 0,
                0, 7, 3, 0,
                0, 0, 0, 4);
        Assert.assertFalse(matrix11.equals(matrix12));
    }

    @Test
    public void testCloning() {
        Matrix4d matrix = new Matrix4d(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testMatrixFromN() {
        Matrix4d matrix = Matrix4d.from(1);
        TestUtild.assertEquals(matrix, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void testMatrixFromMany() {
        Matrix4d matrix = Matrix4d.from(
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 16);
        TestUtild.assertEquals(matrix,
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 16);
    }

    @Test
    public void testMatrixFromDiagonal() {
        Matrix4d matrix = Matrix4d.fromDiagonal(1, 2, 3, 4);
        TestUtild.assertEquals(matrix,
            1, 0, 0, 0,
            0, 2, 0, 0,
            0, 0, 3, 0,
            0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingDoubleFactor() {
        Matrix4d matrix = Matrix4d.createScaling(2d);
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingFloatFactor() {
        Matrix4d matrix = Matrix4d.createScaling(2);
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingVector4() {
        Matrix4d matrix = Matrix4d.createScaling(new Vector4d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingDoubleComponents() {
        Matrix4d matrix = Matrix4d.createScaling(1d, 2d, 3d, 4d);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        Matrix4d matrix = Matrix4d.createScaling(1, 2, 3, 4);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateTranslationVector3() {
        Matrix4d matrix = Matrix4d.createTranslation(new Vector3d(1, 2, 3));
        TestUtild.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationDoubleComponents() {
        Matrix4d matrix = Matrix4d.createTranslation(1d, 2d, 3d);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationFloatComponents() {
        Matrix4d matrix = Matrix4d.createTranslation(1, 2, 3);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        Matrix4d matrix = Matrix4d.createRotation(new Complexd(2, 3));
        TestUtild.assertEquals(matrix,
                (double) (2/SQRT13), (double) (-3/SQRT13), 0, 0,
                (double) (3/SQRT13), (double) (2/SQRT13), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromQuaternion() {
        Matrix4d matrix = Matrix4d.createRotation(new Quaterniond(4, 3, 2, 0));
        TestUtild.assertEquals(matrix,
                (double) (3/29d), (double) (24/29d), (double) (16/29d), 0,
                (double) (24/29d), (double) (-11/29d), (double) (12/29d), 0,
                (double) (16/29d), (double) (12/29d), (double) (-21/29d), 0,
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
