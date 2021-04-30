/*
 * This file is part of Math, licensed under the MIT License (MIT).
 *
 * Copyright (c) Flow Powered <https://github.com/flow>
 * Copyright (c) SpongePowered <https://github.com/SpongePowered>
 * Copyright (c) contributors
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
package org.spongepowered.math.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.spongepowered.math.TrigMath;

public class TrigMathTest {
    private void testValue(final float angle, final float result, final float realValue) {
        assertTrue(Math.abs(result - realValue) < 0.0001, "angle=" + angle + " expected " + realValue + " but got " + result);
    }

    private void testSin(final float value) {
        this.testValue(value, TrigMath.sin(value), (float) Math.sin(value));
    }

    private void testCos(final float value) {
        this.testValue(value, TrigMath.cos(value), (float) Math.cos(value));
    }

    @Test
    void testSinCos() {
        final float step = (float) (TrigMath.TWO_PI / 100.0); //100 steps in the circle
        for (float i = (float) -TrigMath.PI; i < TrigMath.TWO_PI; i += step) {
            this.testSin(i);
            this.testCos(i);
        }
    }

    private void testValue(final double value, final double result, final double realValue) {
        assertTrue(Math.abs(result - realValue) < 0.0000001, "value=" + value + " expected " + realValue + " but got " + result);
    }

    private void testAsin(final double value) {
        this.testValue(value, TrigMath.asin(value), Math.asin(value));
    }

    private void testAcos(final double value) {
        this.testValue(value, TrigMath.acos(value), Math.acos(value));
    }

    private void testAsec(final double value) {
        this.testValue(value, TrigMath.asec(value), Math.acos(1 / value));
    }

    private void testAcosec(final double value) {
        this.testValue(value, TrigMath.acsc(value), Math.asin(1 / value));
    }

    private void testAtan(final double value) {
        this.testValue(value, TrigMath.atan(value), Math.atan(value));
    }

    private void testAtan2(final double y, final double x) {
        final double realValue = Math.atan2(y, x);
        final double result = TrigMath.atan2(y, x);
        assertTrue(Math.abs(result - realValue) < 0.0000001, "x=" + x + ",y=" + y + " expected " + realValue + " but got " + result);
    }

    @Test
    void testAsinAcos() {
        final double step = 2.0 / 100.0;
        for (double i = -1.0; i <= 1.0; i += step) {
            this.testAsin(i);
            this.testAcos(i);
        }
    }

    @Test
    void testAsecAcosec() {
        final double step = 4.0 / 100.0;
        for (double i = -2.0; i <= -1; i += step) {
            this.testAsec(i);
            this.testAcosec(i);
        }
        for (double i = 1; i <= 2; i += step) {
            this.testAsec(i);
            this.testAcosec(i);
        }
    }

    @Test
    void testAtan() {
        final double step = 0.1;
        for (double i = -10.0; i <= 10.0; i += step) {
            this.testAtan(i);
        }
    }

    @Test
    void testAtan2() {
        final double step = 0.2;
        for (double x = -5.0; x <= 5.0; x += step) {
            for (double y = -5.0; y <= 5.0; y += step) {
                this.testAtan2(y, x);
            }
        }
    }
}
