package com.flowpowered.math.test.matrix;

import static org.junit.Assert.assertEquals;
import static com.flowpowered.math.test.TestUtild.SQRT13;


import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix2d;
import com.flowpowered.math.matrix.Matrix3d;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.matrix.MatrixNd;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.VectorNd;

public class MatrixNdTest {
    @Test
    public void testSizeConstructor() {
        MatrixNd matrix = new MatrixNd(4);
        assertEquals(matrix.size(), 4);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        MatrixNd matrix = new MatrixNd(new Matrix2d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        MatrixNd matrix = new MatrixNd(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        MatrixNd matrix = new MatrixNd(new Matrix4d(
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
        MatrixNd matrix = new MatrixNd(new MatrixNd(
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
    public void testFloatComponentsConstructor() {
        MatrixNd matrix = new MatrixNd(
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
    public void testSize() {
        MatrixNd matrix = new MatrixNd(5);
        assertEquals(matrix.size(), 5);
    }

    @Test
    public void testGetter() {
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
    public void testSetterFloatValue() {
        MatrixNd matrix = new MatrixNd(4);
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
        TestUtild.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testSetterDoubleValue() {
        MatrixNd matrix = new MatrixNd(4);
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
        TestUtild.assertEquals(matrix,
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
    }

    @Test
    public void testSetIdentity() {
        MatrixNd matrix = new MatrixNd(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix.setIdentity();
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testSetZero() {
        MatrixNd matrix = new MatrixNd(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        matrix.setZero();
        TestUtild.assertEquals(matrix,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
    }

    @Test
    public void testResize() {
        MatrixNd matrix1 = new MatrixNd(4);
        MatrixNd resize1 = matrix1.resize(2);
        TestUtild.assertEquals(resize1.size(), 2);
        MatrixNd matrix2 = new MatrixNd(4);
        MatrixNd resize2 = matrix2.resize(8);
        TestUtild.assertEquals(resize2.size(), 8);
        TestUtild.assertEquals(resize2.get(7, 7), 0);
    }

    @Test
    public void testMatrixNAddition() {
        MatrixNd matrix = new MatrixNd(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        MatrixNd m = new MatrixNd(
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
    public void testMatrixNSubtraction() {
        MatrixNd matrix = new MatrixNd(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16);
        MatrixNd m = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
    public void testMatrixNMultiplication() {
        MatrixNd matrix = new MatrixNd(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        MatrixNd m = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
    public void testMatrixNDivision() {
        MatrixNd matrix = new MatrixNd(
                1, 10, 0, 0,
                0, 1, 0, 4,
                0, 0, 1, 0,
                0, 0, 0, 1);
        MatrixNd m = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
    public void testTranslateVectorN() {
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.translate(new VectorNd(2, 3, 4));
        TestUtild.assertEquals(matrix,
                1, 0, 0, 2,
                0, 1, 0, 3,
                0, 0, 1, 4,
                0, 0, 0, 1);
    }

    @Test
    public void testTranslateFloatComponents() {
        MatrixNd matrix = new MatrixNd(
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
    public void testScaleVectorN() {
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        matrix = matrix.scale(new VectorNd(2, 3, 4, 5));
        TestUtild.assertEquals(matrix,
                2, 0, 0, 0,
                0, 3, 0, 0,
                0, 0, 4, 0,
                0, 0, 0, 5);
    }

    @Test
    public void testScaleFloatComponents() {
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
    public void testTransformVectorN() {
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        VectorNd vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(new VectorNd(3, 2, 8, 1));
        TestUtild.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
        VectorNd vector = matrix.scale(2, 3, 4, 1).translate(4, 5, 3).transform(3, 2, 8, 1);
        TestUtild.assertEquals(vector, 10, 11, 35, 1);
    }

    @Test
    public void testFloor() {
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix2 = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double value = matrix.trace();
        TestUtild.assertEquals(value, 10);
    }

    @Test
    public void testDeterminant() {
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double value = matrix.determinant();
        TestUtild.assertEquals(value, 24);
    }

    @Test
    public void testInvert() {
        MatrixNd matrix = new MatrixNd(
                1, 2, 3, 4,
                4, 1, 2, 3,
                3, 4, 1, 2,
                2, 3, 1, 4);
        matrix = matrix.invert();
        TestUtild.assertEquals(matrix,
                (double) -0.1875, (double) 0.275, (double) 0.0625, (double) -0.05,
                (double) 0.0625, (double) -0.225, (double) 0.3125, (double) -0.05,
                (double) 0.4375, (double) 0.025, (double) 0.1875, (double) -0.55,
                (double) -0.0625, (double) 0.025, (double) -0.3125, (double) 0.45);
    }

    @Test
    public void testConvertToMatrix2() {
        MatrixNd matrix = new MatrixNd(
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
        MatrixNd matrix = new MatrixNd(
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
    public void testConvertToMatrix4() {
        MatrixNd matrix = new MatrixNd(
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Matrix4d matrix4 = matrix.toMatrix4();
        TestUtild.assertEquals(matrix4,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        MatrixNd matrix = new MatrixNd(
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
    public void testConvertToArray() {
        MatrixNd matrix1 = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double[] array1 = matrix1.toArray(false);
        TestUtild.assertEquals(array1,
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNd matrix2 = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        double[] array2 = matrix2.toArray(true);
        TestUtild.assertEquals(array2,
                1, 0, 0, 0,
                2, 2, 0, 0,
                3, 0, 3, 0,
                4, 0, 0, 4);
    }

    @Test
    public void testEquals() {
        MatrixNd matrix01 = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNd matrix02 = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertTrue(matrix01.equals(matrix02));
        MatrixNd matrix11 = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        MatrixNd matrix12 = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 4, 0,
                0, 7, 3, 0,
                0, 0, 0, 4);
        Assert.assertFalse(matrix11.equals(matrix12));
    }

    @Test
    public void testCloning() {
        MatrixNd matrix = new MatrixNd(
                1, 2, 3, 4,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testCreateFromScalingVectorN() {
        MatrixNd matrix = MatrixNd.createScaling(new VectorNd(1, 2, 3, 4));
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        MatrixNd matrix = MatrixNd.createScaling(1, 2, 3, 4);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 3, 0,
                0, 0, 0, 4);
    }

    @Test
    public void testCreateTranslationVectorN() {
        MatrixNd matrix = MatrixNd.createTranslation(new VectorNd(1, 2, 3));
        TestUtild.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationFloatComponents() {
        MatrixNd matrix = MatrixNd.createTranslation(1, 2, 3);
        TestUtild.assertEquals(matrix,
                1, 0, 0, 1,
                0, 1, 0, 2,
                0, 0, 1, 3,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        MatrixNd matrix = MatrixNd.createRotation(4, new Complexd(2, 3));
        TestUtild.assertEquals(matrix,
                (double) (2/SQRT13), (double) (-3/SQRT13), 0, 0,
                (double) (3/SQRT13), (double) (2/SQRT13), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromQuaternion() {
        MatrixNd matrix = MatrixNd.createRotation(4, new Quaterniond(4, 3, 2, 0));
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
