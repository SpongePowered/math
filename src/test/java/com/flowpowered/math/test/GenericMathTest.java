/*
 * This file is part of Flow Math, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Flow Powered <https://flowpowered.com/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flowpowered.math.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static com.flowpowered.math.GenericMath.floor;
import static com.flowpowered.math.GenericMath.mean;
import static com.flowpowered.math.GenericMath.roundUpPow2;

public final class GenericMathTest {
    @Test
    public void testMean() {
        final int[] intTestValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        final int intTestResult = 8;
        final double[] doubleTestValues = new double[intTestValues.length];
        final double doubleTestResult = intTestResult + 0.03;
        for (int i = 0; i < intTestValues.length; i++) {
            doubleTestValues[i] = intTestValues[i] + 0.03;
        }
        assertEquals(intTestResult, mean(intTestValues));
        assertEquals(doubleTestResult, mean(doubleTestValues), 0.01);
    }

    @Test
    public void testRoundUpPow2() {
        assertEquals(1, roundUpPow2(-1));
        assertEquals(1, roundUpPow2(0));
        assertEquals(16, roundUpPow2(9));
        assertEquals(8, roundUpPow2(8));
        assertEquals(4096, roundUpPow2(2050));
    }

    @Test
    public void testFloor() {
        assertEquals(1, floor(1.5f));
        assertEquals(1, floor(1.5));
        assertEquals(59, floor(59.987));
        assertEquals(59, floor(59.987f));
        assertEquals(0, floor(0.9));
        assertEquals(0, floor(0.9f));
    }
}
