package com.flowpowered.math.test.matrix;

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
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector3d;

public class Matrix3dTest {
    @Test
    public void testDefaultConstructor() {
        Matrix3d matrix = new Matrix3d();
        TestUtild.assertEquals(matrix, 1, 0, 0, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testCopyMatrix2Constructor() {
        Matrix3d matrix = new Matrix3d(new Matrix2d(1, 2, 3, 4));
        TestUtild.assertEquals(matrix, 1, 2, 0, 3, 4, 0, 0, 0, 0);
    }

    @Test
    public void testCopyMatrix3Constructor() {
        Matrix3d matrix = new Matrix3d(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testCopyMatrix4Constructor() {
        Matrix3d matrix = new Matrix3d(new Matrix4d(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        TestUtild.assertEquals(matrix, 1, 2, 3, 5, 6, 7, 9, 10, 11);
    }

    @Test
    public void testCopyMatrixNConstructor() {
        Matrix3d matrix = new Matrix3d(new MatrixNd(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testDoubleComponentsConstructor() {
        Matrix3d matrix = new Matrix3d(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testFloatComponentsConstructor() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testGetter() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtild.assertEquals(matrix.get(0, 0), 1);
        TestUtild.assertEquals(matrix.get(0, 1), 2);
        TestUtild.assertEquals(matrix.get(0, 2), 3);
        TestUtild.assertEquals(matrix.get(1, 0), 4);
        TestUtild.assertEquals(matrix.get(1, 1), 5);
        TestUtild.assertEquals(matrix.get(1, 2), 6);
        TestUtild.assertEquals(matrix.get(2, 0), 7);
        TestUtild.assertEquals(matrix.get(2, 1), 8);
        TestUtild.assertEquals(matrix.get(2, 2), 9);
    }

    @Test
    public void testRowGetter() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtild.assertEquals(matrix.getRow(0), 1, 2, 3);
        TestUtild.assertEquals(matrix.getRow(1), 4, 5, 6);
        TestUtild.assertEquals(matrix.getRow(2), 7, 8, 9);
    }

    @Test
    public void testColumnGetter() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        TestUtild.assertEquals(matrix.getColumn(0), 1, 4, 7);
        TestUtild.assertEquals(matrix.getColumn(1), 2, 5, 8);
        TestUtild.assertEquals(matrix.getColumn(2), 3, 6, 9);
    }

    @Test
    public void testMatrix3Addition() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).add(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TestUtild.assertEquals(matrix, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    }

    @Test
    public void testMatrix3Subtraction() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).sub(new Matrix3d(0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5));
        TestUtild.assertEquals(matrix, (double) 0.5, 1, (double) 1.5, 2, (double) 2.5, 3, (double) 3.5, 4, (double) 4.5);
    }

    @Test
    public void testFloatFactorMultiplication() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).mul(2);
        TestUtild.assertEquals(matrix, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    }

    @Test
    public void testDoubleFactorMultiplication() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).mul(2d);
        TestUtild.assertEquals(matrix, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    }

    @Test
    public void testMatrix3Multiplication() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).mul(new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testFloatFactorDivision() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).div(2);
        TestUtild.assertEquals(matrix, (double) 0.5, 1, (double) 1.5, 2, (double) 2.5, 3, (double) 3.5, 4, (double) 4.5);
    }

    @Test
    public void testDoubleFactorDivision() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).div(2d);
        TestUtild.assertEquals(matrix, (double) 0.5, 1, (double) 1.5, 2, (double) 2.5, 3, (double) 3.5, 4, (double) 4.5);
    }

    @Test
    public void testMatrix3Division() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).div(new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1));
        TestUtild.assertEquals(matrix, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testRaiseToFloatPower() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).pow(2);
        TestUtild.assertEquals(matrix, 1, 4, 9, 16, 25, 36, 49, 64, 81);
    }

    @Test
    public void testRaiseToDoublePower() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).pow(2d);
        TestUtild.assertEquals(matrix, 1, 4, 9, 16, 25, 36, 49, 64, 81);
    }

    @Test
    public void testTranslateVector2() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).translate(new Vector2d(1, 0));
        TestUtild.assertEquals(matrix, 1, 0, 1, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testTranslateFloatComponents() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).translate(1, 0);
        TestUtild.assertEquals(matrix, 1, 0, 1, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testScaleFloatFactor() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2);
        TestUtild.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testScaleVector3() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(new Vector3d(2, 2, 2));
        TestUtild.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testScaleFloatComponents() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2d);
        TestUtild.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testRotateComplex() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).rotate(new Complexd(2, 3));
        TestUtild.assertEquals(matrix,
                (double) (2/SQRT13), (double) (-3/SQRT13), 0,
                (double) (3/SQRT13), (double) (2/SQRT13), 0,
                0, 0, 1);
    }

    @Test
    public void testRotateQuaternion() {
        Matrix3d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).rotate(new Quaterniond(4, 3, 2, 0));
        TestUtild.assertEquals(matrix,
                (double) (3/29d), (double) (24/29d), (double) (16/29d),
                (double) (24/29d), (double) (-11/29d), (double) (12/29d),
                (double) (16/29d), (double) (12/29d), (double) (-21/29d));
    }

    @Test
    public void testTransformVector3() {
        Vector3d vector = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2, 3, 1).translate(4, 5).transform(new Vector3d(3, 2, 1));
        TestUtild.assertEquals(vector, 10, 11, 1);
    }

    @Test
    public void testTransformFloatComponents() {
        Vector3d vector = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).scale(2, 3, 1).translate(4, 5).transform(3, 2, 1);
        TestUtild.assertEquals(vector, 10, 11, 1);
    }

    @Test
    public void testFloor() {
        Matrix3d matrix = new Matrix3d(1.1, 2.9, 3.5, -1.1, -2.5, -3.9, -4.2, 1.4, 8.6).floor();
        TestUtild.assertEquals(matrix, 1, 2, 3, -2, -3, -4, -5, 1, 8);
    }

    @Test
    public void testCeiling() {
        Matrix3d matrix = new Matrix3d(1.1, 2.9, 3.5, -1.1, -2.5, -3.9, -4.2, 1.4, 8.6).ceil();
        TestUtild.assertEquals(matrix, 2, 3, 4, -1, -2, -3, -4, 2, 9);
    }

    @Test
    public void testRound() {
        Matrix3d matrix = new Matrix3d(1.1, 2.9, 3.5, -1.1, -2.5, -3.9, -4.2, 1.4, 8.6).round();
        TestUtild.assertEquals(matrix, 1, 3, 4, -1, -2, -4, -4, 1, 9);
    }

    @Test
    public void testAbsolute() {
        Matrix3d matrix1 = new Matrix3d(-1, -1, -1, -1, -1, -1, -1, -1, -1).abs();
        TestUtild.assertEquals(matrix1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        Matrix3d matrix2 = new Matrix3d(1, 1, 1, 1, 1, 1, 1, 1, 1).abs();
        TestUtild.assertEquals(matrix2, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void testNegate() {
        Matrix3d matrix = new Matrix3d(-1, 1, -1, 1, -1, 1, -1, 1, -1).negate();
        TestUtild.assertEquals(matrix, 1, -1, 1, -1, 1, -1, 1, -1, 1);
    }

    @Test
    public void testTranspose() {
        Matrix3d matrix = new Matrix3d(0, 1, 2, 3, 4, 5, 6, 7, 8).transpose();
        TestUtild.assertEquals(matrix, 0, 3, 6, 1, 4, 7, 2, 5, 8);
    }

    @Test
    public void testTrace() {
        double f = new Matrix3d(0, 1, 2, 3, 4, 5, 6, 7, 8).trace();
        TestUtild.assertEquals(f, 12);
    }

    @Test
    public void testDeterminant() {
        double f = new Matrix3d(0, 1, 2, 3, 4, 5, 6, 7, 8).determinant();
        TestUtild.assertEquals(f, 0);
    }

    @Test
    public void testInvert() {
        Matrix3d matrix1 = new Matrix3d(0, 1, 2, 3, 4, 5, 6, 7, 8).invert();
        Assert.assertEquals(matrix1, null);
        Matrix3d matrix2 = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).invert();
        TestUtild.assertEquals(matrix2, 1, 0, 0, 0, 1, 0, 0, 0, 1);
        Matrix3d matrix3 = new Matrix3d(
                1, 2, 3,
                3, 1, 2,
                2, 3, 1)
                .invert();
        TestUtild.assertEquals(matrix3,
                (double) (-5/18d), (double) (7/18d), (double) (1/18d),
                (double) (1/18d), (double) (-5/18d), (double) (7/18d),
                (double) (7/18d), (double) (1/18d), (double) (-5/18d));
/*                -0.2777777777f, 0.3888888888f, 0.0555555555f,
                0.0555555555f, -0.2777777777f, 0.3888888888f,
                0.3888888888f, 0.0555555555f, -0.2777777777f);*/
        }

    @Test
    public void testConvertToMatrix2() {
        Matrix2d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).toMatrix2();
        TestUtild.assertEquals(matrix, 1, 0, 0, 1);
    }

    @Test
    public void testConvertToMatrix4() {
        Matrix4d matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).toMatrix4();
        TestUtild.assertEquals(matrix, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    }

    @Test
    public void testConvertToMatrixN() {
        MatrixNd matrix = new Matrix3d(1, 0, 0, 0, 1, 0, 0, 0, 1).toMatrixN();
        TestUtild.assertEquals(matrix, 1, 0, 0, 0, 1, 0, 0, 0, 1);
    }

    @Test
    public void testConvertToArrayRowMajorDefault() {
        double[] array = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).toArray(true);
        TestUtild.assertEquals(array, 1, 4, 7, 2, 5, 8, 3, 6, 9);
    }

    @Test
    public void testConvertToArray() {
        double[] array = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).toArray();
        TestUtild.assertEquals(array, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).equals(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        Assert.assertFalse(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9).equals(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 0)));
    }

    @Test
    public void testCloning() {
        Matrix3d matrix = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertEquals(matrix, matrix.clone());
    }

    @Test
    public void testCreateFromScalingDoubleFactor() {
        Matrix3d matrix = Matrix3d.createScaling(2d);
        TestUtild.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingFloatFactor() {
        Matrix3d matrix = Matrix3d.createScaling(2);
        TestUtild.assertEquals(matrix, 2, 0, 0, 0, 2, 0, 0, 0, 2);
    }

    @Test
    public void testCreateFromScalingVector3() {
        Matrix3d matrix = Matrix3d.createScaling(new Vector3d(1, 2, 3));
        TestUtild.assertEquals(matrix, 1, 0, 0, 0, 2, 0, 0, 0, 3);
    }

    @Test
    public void testCreateFromScalingFloatComponents() {
        Matrix3d matrix = Matrix3d.createScaling(1, 2, 3);
        TestUtild.assertEquals(matrix, 1, 0, 0, 0, 2, 0, 0, 0, 3);
    }

    @Test
    public void testCreateTranslationVector2() {
        Matrix3d matrix1 = Matrix3d.createTranslation(new Vector2d(1, 0));
        TestUtild.assertEquals(matrix1, 1, 0, 1, 0, 1, 0, 0, 0, 1);
        Matrix3d matrix2 = Matrix3d.createTranslation(new Vector2d(0, 1));
        TestUtild.assertEquals(matrix2, 1, 0, 0, 0, 1, 1, 0, 0, 1);
    }

    @Test
    public void testCreateTranslationFloatComponents() {
        Matrix3d matrix1 = Matrix3d.createTranslation(1, 0);
        TestUtild.assertEquals(matrix1, 1, 0, 1, 0, 1, 0, 0, 0, 1);
        Matrix3d matrix2 = Matrix3d.createTranslation(0, 1);
        TestUtild.assertEquals(matrix2, 1, 0, 0, 0, 1, 1, 0, 0, 1);
    }

    @Test
    public void testCreateRotationFromComplex() {
        Matrix3d matrix = Matrix3d.createRotation(new Complexd(2, 3));
        TestUtild.assertEquals(matrix,
                (double) (2/SQRT13), (double) (-3/SQRT13), 0,
                (double) (3/SQRT13), (double) (2/SQRT13), 0,
                0, 0, 1);
    }

    @Test
    public void testCreateRotationFromQuaternion() {
        Matrix3d matrix = Matrix3d.createRotation(new Quaterniond(4, 3, 2, 0));
        TestUtild.assertEquals(matrix,
                (double) (3/29d), (double) (24/29d), (double) (16/29d),
                (double) (24/29d), (double) (-11/29d), (double) (12/29d),
                (double) (16/29d), (double) (12/29d), (double) (-21/29d));

    }
}
