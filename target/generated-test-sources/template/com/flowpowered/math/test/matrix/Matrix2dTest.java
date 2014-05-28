package com.flowpowered.math.test.matrix;

import static com.flowpowered.math.test.TestUtild.SQRT13;

import org.junit.Assert;
import org.junit.Test;

import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.matrix.Matrix2d;
import com.flowpowered.math.matrix.Matrix3d;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.matrix.MatrixNd;
import com.flowpowered.math.test.TestUtild;
import com.flowpowered.math.vector.Vector2d;

public class Matrix2dTest {
    @Test
    public void testDefaultConstructor() {
        Matrix2d matrix = new Matrix2d();
        TestUtild.assertEquals(matrix, 1, 0, 0, 1);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        Matrix2d matrix = new Matrix2d(new Matrix2d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        Matrix2d matrix = new Matrix2d(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtild.assertEquals(matrix, 1, 2, 4, 5);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        Matrix2d matrix = new Matrix2d(new Matrix4d(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        TestUtild.assertEquals(matrix, 1, 2, 5, 6);
    }

    @Test
    public void testCopyMatrixNConstructor() {
        Matrix2d matrix = new Matrix2d(new MatrixNd(1, 2, 3, 4));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Matrix2d matrix = new Matrix2d(1d, 2d, 3d, 4d);
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testGetter() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix.get(0, 0), 1);
        TestUtild.assertEquals(matrix.get(0, 1), 2);
        TestUtild.assertEquals(matrix.get(1, 0), 3);
        TestUtild.assertEquals(matrix.get(1, 1), 4);
    }

    @Test
    public void testRowGetter() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix.getRow(0), 1, 2);
        TestUtild.assertEquals(matrix.getRow(1), 3, 4);
    }

    @Test
    public void testColumnGetter() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix.getColumn(0), 1, 3);
        TestUtild.assertEquals(matrix.getColumn(1), 2, 4);
    }

    @Test
    public void testMatrix2Addition() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).add(new Matrix2d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testMatrix2Subtraction() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).sub(new Matrix2d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix, 0, 0, 0, 0);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).mul(2f);
        TestUtild.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).mul(2d);
        TestUtild.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testMatrix2Multiplication() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).mul(new Matrix2d(1, 0, 0, 1));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testFloatFactorDivision() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).div(0.5f);
        TestUtild.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testDoubleFactorDivision() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).div(0.5);
        TestUtild.assertEquals(matrix, 2, 4, 6, 8);
    }

    @Test
    public void testMatrix2Division() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).mul(new Matrix2d(1, 0, 0, 1));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4);
    }

    @Test
    public void testRaiseToFloatPower() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).pow(2f);
        TestUtild.assertEquals(matrix, 1, 4, 9, 16);
    }

    @Test
    public void testRaiseToDoublePower() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).pow(2d);
        TestUtild.assertEquals(matrix, 1, 4, 9, 16);
    }

    @Test
    public void testTranslateDoubleDistance() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).translate(5d);
        TestUtild.assertEquals(matrix, 1, 5, 0, 1);
    }

    @Test
    public void testTranslateFloatDistance() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).translate(5f);
        TestUtild.assertEquals(matrix, 1, 5, 0, 1);
    }

    @Test
    public void testScaleDoubleFactor() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).scale(2.5);
        TestUtild.assertEquals(matrix, (double) 2.5, 0, 0, (double) 2.5);
    }

    @Test
    public void testScaleFloatFactor() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).scale(2.5f);
        TestUtild.assertEquals(matrix, (double) 2.5, 0, 0, (double) 2.5);
    }

    @Test
    public void testScaleVector2() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).scale(new Vector2d(2, 3));
        TestUtild.assertEquals(matrix, 2, 0, 0, 3);
    }

    @Test
    public void testScaleDoubleComponents() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).scale(2d, 3d);
        TestUtild.assertEquals(matrix, 2, 0, 0, 3);
    }

    @Test
    public void testScaleFloatComponents() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).scale(2, 3);
        TestUtild.assertEquals(matrix, 2, 0, 0, 3);
    }

    @Test
    public void testRotateComplex() {
        Matrix2d matrix = new Matrix2d(1, 0, 0, 1).rotate(new Complexd(0, 1));
        TestUtild.assertEquals(matrix, 0, -1, 1, 0);
    }

    @Test
    public void testTransformVector2() {
        Vector2d vector = new Matrix2d(1, 0, 0, 1).scale(2, 1).translate(4).transform(new Vector2d(3, 1));
        TestUtild.assertEquals(vector, 10, 1);
    }

    @Test
    public void testTransformDoubleComponents() {
        Vector2d vector = new Matrix2d(1, 0, 0, 1).scale(2, 1).translate(4).transform(3d, 1d);
        TestUtild.assertEquals(vector, 10, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        Vector2d vector = new Matrix2d(1, 0, 0, 1).scale(2, 1).translate(4).transform(3, 1);
        TestUtild.assertEquals(vector, 10, 1);
    }

    @Test
    public void testFloor() {
        Matrix2d matrix = new Matrix2d(1.1, 2.5, 3.9, -4.8).floor();
        TestUtild.assertEquals(matrix, 1, 2, 3, -5);
    }

    @Test
    public void testCeiling() {
        Matrix2d matrix = new Matrix2d(1.1, 2.5, 3.9, -4.8).ceil();
        TestUtild.assertEquals(matrix, 2, 3, 4, -4);
    }

    @Test
    public void testRound() {
        Matrix2d matrix = new Matrix2d(1.1, 2.5, 3.9, -4.8).round();
        TestUtild.assertEquals(matrix, 1, 3, 4, -5);
    }

    @Test
    public void testAbsolute() {
        Matrix2d matrix = new Matrix2d(1.1, 2.5, 3.9, -4.8).abs();
        TestUtild.assertEquals(matrix, (double) 1.1, (double) 2.5, (double) 3.9, (double) 4.8);
    }

    @Test
    public void testNegate() {
        Matrix2d matrix = new Matrix2d(1.1, 2.5, 3.9, -4.8).negate();
        TestUtild.assertEquals(matrix, (double) -1.1, (double) -2.5, (double) -3.9, (double) 4.8);
    }

    @Test
    public void testTranspose() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).transpose();
        TestUtild.assertEquals(matrix, 1, 3, 2, 4);
    }

    @Test
    public void testTrace() {
        double f = new Matrix2d(1, 2, 3, 4).trace();
        TestUtild.assertEquals(f, 5);
    }

    @Test
    public void testDeterminant() {
        double f = new Matrix2d(1, 2, 3, 4).determinant();
        TestUtild.assertEquals(f, -2);
    }

    @Test
    public void testInvert() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4).invert();
        TestUtild.assertEquals(matrix, -2, 1, (double) 1.5, (double) -0.5);
    }

    @Test
    public void testConvertToMatrix3() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix.toMatrix3(), 1, 2, 0, 3, 4, 0, 0, 0, 0);
    }

    @Test
    public void testConvertToMatrix4() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix.toMatrix4(), 1, 2, 0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testConvertToMatrixN() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        TestUtild.assertEquals(matrix.toMatrixN(), 1, 2, 3, 4);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        double[] array = new Matrix2d(1, 2, 3, 4).toArray(true);
        TestUtild.assertEquals(array, 1, 3, 2, 4);
    }

    @Test
    public void testConvertToArray() {
        double[] array = new Matrix2d(1, 2, 3, 4).toArray();
        TestUtild.assertEquals(array, 1, 2, 3, 4);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Matrix2d(1, 2, 3, 4).equals(new Matrix2d(1, 2, 3, 4)));
        Assert.assertFalse(new Matrix2d(1, 2, 3, 4).equals(new Matrix2d(1, 2, 3, 5)));
    }

    @Test
    public void testCloning() {
        Matrix2d matrix = new Matrix2d(1, 2, 3, 4);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testCreateFromScalingDoubleFactor() {
        Matrix2d matrix = Matrix2d.createScaling(2d);
        TestUtild.assertEquals(matrix, 2, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingFloatFactor() {
        Matrix2d matrix = Matrix2d.createScaling(2);
        TestUtild.assertEquals(matrix, 2, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingVector2() {
        Matrix2d matrix = Matrix2d.createScaling(new Vector2d(2, 1.5));
        TestUtild.assertEquals(matrix, 2, 0, 0, (double) 1.5);
    }

    @Test
    public void testCreateFromScalingDoubleComponents() {
        Matrix2d matrix = Matrix2d.createScaling(2, 1.5);
        TestUtild.assertEquals(matrix, 2, 0, 0, (double) 1.5);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        Matrix2d matrix = Matrix2d.createScaling(2, 1.5f);
        TestUtild.assertEquals(matrix, 2, 0, 0, (double) 1.5);
    }

    @Test
    public void testCreateTranslationFromDoubleDistance() {
        Matrix2d matrix = Matrix2d.createTranslation(5d);
        TestUtild.assertEquals(matrix, 1, 5, 0, 1);
    }


    @Test
    public void testCreateTranslationFromFloatDistance() {
        Matrix2d matrix = Matrix2d.createTranslation(5);
        TestUtild.assertEquals(matrix, 1, 5, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        Matrix2d matrix = Matrix2d.createRotation(new Complexd(2, 3));
        TestUtild.assertEquals(matrix,
                (double) (2/SQRT13), (double) (-3/SQRT13),
                (double) (3/SQRT13), (double) (2/SQRT13));
    }
}
