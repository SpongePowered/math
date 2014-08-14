/*
 * This file is part of Flow Math, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Spout LLC <https://spout.org/>
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

import com.flowpowered.math.TrigMath;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TrigMathTest {
    private void testValue(float angle, float result, float realValue) {
        assertTrue("angle=" + angle + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.0001);
    }

    private void testSin(float value) {
        testValue(value, TrigMath.sin(value), (float) Math.sin(value));
    }

    private void testCos(float value) {
        testValue(value, TrigMath.cos(value), (float) Math.cos(value));
    }

    @Test
    public void testSinCos() {
        float step = (float) (TrigMath.TWO_PI / 100.0); //100 steps in the circle
        for (float i = (float) -TrigMath.PI; i < TrigMath.TWO_PI; i += step) {
            testSin(i);
            testCos(i);
        }
    }

    private void testValue(double value, double result, double realValue) {
        assertTrue("value=" + value + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.0000001);
    }

    private void testAsin(double value) {
        testValue(value, TrigMath.asin(value), Math.asin(value));
    }

    private void testAcos(double value) {
        testValue(value, TrigMath.acos(value), Math.acos(value));
    }

    private void testAsec(double value) {
        testValue(value, TrigMath.asec(value), Math.acos(1 / value));
    }

    private void testAcosec(double value) {
        testValue(value, TrigMath.acsc(value), Math.asin(1 / value));
    }

    private void testAtan(double value) {
        testValue(value, TrigMath.atan(value), Math.atan(value));
    }

    private void testAtan2(double y, double x) {
        double realValue = Math.atan2(y, x);
        double result = TrigMath.atan2(y, x);
        assertTrue("x=" + x + ",y=" + y + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.0000001);
    }

    @Test
    public void testAsinAcos() {
        double step = 2.0 / 100.0;
        for (double i = -1.0; i <= 1.0; i += step) {
            testAsin(i);
            testAcos(i);
        }
    }

    @Test
    public void testAsecAcosec() {
        double step = 4.0 / 100.0;
        for (double i = -2.0; i <= -1; i += step) {
            testAsec(i);
            testAcosec(i);
        }
        for (double i = 1; i <= 2; i += step) {
            testAsec(i);
            testAcosec(i);
        }
    }

    @Test
    public void testAtan() {
        double step = 0.1;
        for (double i = -10.0; i <= 10.0; i += step) {
            testAtan(i);
        }
    }

    @Test
    public void testAtan2() {
        double step = 0.2;
        for (double x = -5.0; x <= 5.0; x += step) {
            for (double y = -5.0; y <= 5.0; y += step) {
                testAtan2(y, x);
            }
        }
    }
}
