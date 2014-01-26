/*
 * This file is part of Flow Math, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.flowpowered.math.vector.Vector3i;

public final class HashTest {

    private static final int NUM_LIN_VECS = 100;
    private static final int M_NUM_LIN_VECS = -100;
    private final Map<Integer, Integer> linearCols = new HashMap<Integer, Integer>();
    private final Set<Vector3i> lVecList = new HashSet<Vector3i>();
    private int[] lColCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    @Before
    public void initialize() {
        System.out.println("Generating linearly distributed vectors for x,y,z from " + M_NUM_LIN_VECS +  " to " + NUM_LIN_VECS);
        for (int x = M_NUM_LIN_VECS; x < NUM_LIN_VECS; x++) {
            for (int y = M_NUM_LIN_VECS; y < NUM_LIN_VECS; y++) {
                for (int z = M_NUM_LIN_VECS; z < NUM_LIN_VECS; z++) {
                    lVecList.add(new Vector3i(x, y, z));
                }
            }
        }
    }

    @Test
    public void collisionTestLinear() {
        System.out.println("Beginning linearly distributed vector hash test");
        for (Vector3i vec : lVecList) {
            int hash = vec.hashCode();
            if (linearCols.containsKey(hash)) {
                linearCols.put(hash, linearCols.get(hash) + 1);
            } else {
                linearCols.put(hash, 0);
            }
        }
        System.out.println("Calculating hash distribution for " + linearCols.size() + " total hashes");
        for (Entry<Integer, Integer> entry : linearCols.entrySet()) {
            switch(entry.getValue()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                lColCount[entry.getValue()] += 1;
                break;
            default:
                lColCount[9] += 1;
                break;
            }
        }
        for (int val = 0; val < 10; val++) {
            System.out.println("Number of Linearly distributed Vectors with " + (val != 9 ? val : "9 or more ") + " collisions: " + lColCount[val]);
        }
    }
    
}