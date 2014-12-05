package com.flowpowered.math.test.matrix;

import static org.junit.Assert.assertEquals;
import static com.flowpowered.math.test.TestUtilf.SQRT13;


import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.matrix.Matrix2f;
import com.flowpowered.math.matrix.Matrix3f;
import com.flowpowered.math.matrix.Matrix4f;
import com.flowpowered.math.matrix.MatrixNf;
import com.flowpowered.math.test.TestUtilf;
import com.flowpowered.math.vector.VectorNf;

public class MatrixNfTest {
    @Test
    public void testSizeConstructor() {
        MatrixNf matrix = new MatrixNf(4);
        assertEquals(matrix.size(), 4);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        MatrixNf matrix = new MatrixNf(new Matrix2f(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        MatrixNf matrix = new MatrixNf(new Matrix3f(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtilf.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        MatrixNf matrix = new MatrixNf(new Matrix4f(
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
        MatrixNf matrix = new MatrixNf(new MatrixNf(
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
    public void testFloatComponentsConstructor() {
        MatrixNf matrix = new MatrixNf(
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
    public void testSize() {
        MatrixNf matrix = new MatrixNf(5);
        assertEquals(matrix.size(), 5);
    }

    @Test
    public void testGetter() {
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
    public void testSetterFloatValue() {
        MatrixNf matrix = new MatrixNf(4);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(0, 3, 4);
        matrix.set(1, 0, 5);
        matrix.set(1, 1, 6);
        matrix.set(1, 2, 7);
        matrix.set(1, 3, 8);
        matrix.set(2, 0, 9);
        matrix.set(2, 1, 10);
        matrix.set(2, 2, 11);
        matrix.set(2, 3, 12);
        matrix.set(3, 0, 13);
        matrix.set(3, 1, 14);
        matrix.set(3, 2, 15);
        matrix.set(3, 3, 16);
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testSetterDoubleValue() {
        MatrixNf matrix = new MatrixNf(4);
        matrix.set(0, 0, 1d);
        matrix.set(0, 1, 2d);
        matrix.set(0, 2, 3d);
        matrix.set(0, 3, 4d);
        matrix.set(1, 0, 5d);
        matrix.set(1, 1, 6d);
        matrix.set(1, 2, 7d);
        matrix.set(1, 3, 8d);
        matrix.set(2, 0, 9d);
        matrix.set(2, 1, 10d);
        matrix.set(2, 2, 11d);
        matrix.set(2, 3, 12d);
        matrix.set(3, 0, 13d);
        matrix.set(3, 1, 14d);
        matrix.set(3, 2, 15d);
        matrix.set(3, 3, 16d);
        TestUtilf.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testSetIdentity() {
        MatrixNf matrix = new MatrixNf(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix.setIdentity();
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testSetZero() {
        MatrixNf matrix = new MatrixNf(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix.setZero();
        TestUtilf.assertEquals(matrix,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
    }

    @Test
    public void testResize() {
        MatrixNf matrix1 = new MatrixNf(4);
        MatrixNf resize1 = matrix1.resize(2);
        TestUtilf.assertEquals(resize1.size(), 2);
        MatrixNf matrix2 = new MatrixNf(4);
        MatrixNf resize2 = matrix2.resize(8);
        TestUtilf.assertEquals(resize2.size(), 8);
        TestUtilf.assertEquals(resize2.get(7, 7), 0);
    }

    @Test
    public void testMatrixNAddition() {
        MatrixNf matrix = new MatrixNf(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        MatrixNf m = new MatrixNf(
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
    public void testMatrixNSubtraction() {
        MatrixNf matrix = new MatrixNf(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        MatrixNf m = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
    public void testMatrixNMultiplication() {
        MatrixNf matrix = new MatrixNf(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        MatrixNf m = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
    public void testMatrixNDivision() {
        MatrixNf matrix = new MatrixNf(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        MatrixNf m = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
    public void testTranslateVectorN() {
        MatrixNf matrix = new MatrixNf(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(new VectorNf(2, 3, 4));
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testTranslateFloatComponents() {
        MatrixNf matrix = new MatrixNf(
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
    public void testScaleVectorN() {
        MatrixNf matrix = new MatrixNf(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(new VectorNf(2, 3, 4, 5));
        TestUtilf.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testScaleFloatComponents() {
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
    public void testTransformVectorN() {
        MatrixNf matrix = new MatrixNf(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        VectorNf vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(new VectorNf(3, 2, 8, 1));
        TestUtilf.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        MatrixNf matrix = new MatrixNf(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        VectorNf vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(3, 2, 8, 1);
        TestUtilf.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testFloor() {
        MatrixNf matrix = new MatrixNf(
                (float) -1.1, (float) 2.5, (float) 2.9, (float) 3.2,
                (float) -6.3, (float) 2.2, (float) 2.1, (float) 5.6,
                (float) -8.8, (float) 8.1, (float) 4.6, (float) 6.7,
                (float) -1.3, (float) 1.7, (float) 7.3, (float) 7.6);
        matrix = matrix.floor();
        TestUtilf.assertEquals(matrix,
                -2, 2, 2, 3,
                -7, 2, 2, 5,
                -9, 8, 4, 6,
                -2, 1, 7, 7);
    }

    @Test
    public void testCeiling() {
        MatrixNf matrix = new MatrixNf(
                (float) -1.1, (float) 2.5, (float) 2.9, (float) 3.2,
                (float) -6.3, (float) 2.2, (float) 2.1, (float) 5.6,
                (float) -8.8, (float) 8.1, (float) 4.6, (float) 6.7,
                (float) -1.3, (float) 1.7, (float) 7.3, (float) 7.6);
        matrix = matrix.ceil();
        TestUtilf.assertEquals(matrix,
                -1, 3, 3, 4,
                -6, 3, 3, 6,
                -8, 9, 5, 7,
                -1, 2, 8, 8);
    }

    @Test
    public void testRound() {
        MatrixNf matrix = new MatrixNf(
                (float) -1.1, (float) 2.5, (float) 2.9, (float) 3.2,
                (float) -6.3, (float) 2.2, (float) 2.1, (float) 5.6,
                (float) -8.8, (float) 8.1, (float) 4.6, (float) 6.7,
                (float) -1.3, (float) 1.7, (float) 7.3, (float) 7.6);
        matrix = matrix.round();
        TestUtilf.assertEquals(matrix,
                -1, 3, 3, 3,
                -6, 2, 2, 6,
                -9, 8, 5, 7,
                -1, 2, 7, 8);
    }

    @Test
    public void testAbsolute() {
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix2 = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float value = matrix.trace();
        TestUtilf.assertEquals(value, 10);
    }

    @Test
    public void testDeterminant() {
        MatrixNf matrix1 = new MatrixNf(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float value1 = matrix1.determinant();
        TestUtilf.assertEquals(value1, 24);
        MatrixNf matrix2 = new MatrixNf(0, 1, 2, 3, 4, 5, 6, 7, 8);
        float value2 = matrix2.determinant();
        TestUtilf.assertEquals(value2, 0);
    }

    @Test
    public void testInvert() {
        MatrixNf matrix = new MatrixNf(
                1, 2, 3, 4,
                4, 1, 2, 3,
                3, 4, 1, 2,
                2, 3, 1, 4);
        matrix = matrix.invert();
        TestUtilf.assertEquals(matrix,
                (float) -0.1875, (float) 0.275, (float) 0.0625, (float) -0.05,
                (float) 0.0625, (float) -0.225, (float) 0.3125, (float) -0.05,
                (float) 0.4375, (float) 0.025, (float) 0.1875, (float) -0.55,
                (float) -0.0625, (float) 0.025, (float) -0.3125, (float) 0.45);
        try {
            new MatrixNf(
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0).invert();
            Assert.fail();
        } catch (ArithmeticException ex) {
        }
    }

    @Test
    public void testConvertToMatrix2() {
        MatrixNf matrix = new MatrixNf(
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
        MatrixNf matrix = new MatrixNf(
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
    public void testConvertToMatrix4() {
        MatrixNf matrix = new MatrixNf(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix4f matrix4 = matrix.toMatrix4();
        TestUtilf.assertEquals(matrix4,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        MatrixNf matrix = new MatrixNf(
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
    public void testConvertToArray() {
        MatrixNf matrix1 = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float[] array1 = matrix1.toArray(false);
        TestUtilf.assertEquals(array1,
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNf matrix2 = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        float[] array2 = matrix2.toArray(true);
        TestUtilf.assertEquals(array2,
                1, 0, 0, 0,
                2, 2, 0, 0,
                3, 0, 3, 0,
                4, 0, 0, 4);
    }

    @Test
    public void testEquals() {
        MatrixNf matrix01 = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNf matrix02 = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertTrue(matrix01.equals(matrix02));
        MatrixNf matrix11 = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNf matrix12 = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 4, 0,
                0, 7, 3, 0,
                0, 0, 0, 4);
        Assert.assertFalse(matrix11.equals(matrix12));
    }

    @Test
    public void testCloning() {
        MatrixNf matrix = new MatrixNf(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testCreateFromScalingVectorN() {
        MatrixNf matrix = MatrixNf.createScaling(new VectorNf(1, 2, 3, 4));
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        MatrixNf matrix = MatrixNf.createScaling(1, 2, 3, 4);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateTranslationVectorN() {
        MatrixNf matrix = MatrixNf.createTranslation(new VectorNf(1, 2, 3));
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationFloatComponents() {
        MatrixNf matrix = MatrixNf.createTranslation(1, 2, 3);
        TestUtilf.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        MatrixNf matrix = MatrixNf.createRotation(4, new Complexf(2, 3));
        TestUtilf.assertEquals(matrix,
                (float) (2/SQRT13), (float) (-3/SQRT13), 0, 0,
                (float) (3/SQRT13), (float) (2/SQRT13), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromQuaternion() {
        MatrixNf matrix = MatrixNf.createRotation(4, new Quaternionf(4, 3, 2, 0));
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
