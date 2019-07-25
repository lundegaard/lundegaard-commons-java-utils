/*
 * Copyright (C) 2019 Lundegaard a.s., All Rights Reserved
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; version 3.0 of the License.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
 */
package eu.lundegaard.commons.util;

import org.junit.Assert;
import org.junit.Test;
import static eu.lundegaard.commons.util.ArraysUtil.asArray;
import static org.junit.Assert.*;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class ArraysUtilTest {

    @Test
    public void asArrayByte() {
        byte one = 1;
        byte two = 2;

        Assert.assertArrayEquals(new byte[] {}, asArray(new byte[] {}));
        Assert.assertArrayEquals(new byte[] {one}, asArray(one));
        Assert.assertArrayEquals(new byte[] {one, two}, asArray(one, two));
    }

    @Test
    public void asArrayShort() {
        short one = 1;
        short two = 2;

        Assert.assertArrayEquals(new short[] {}, asArray(new short[] {}));
        Assert.assertArrayEquals(new short[] {one}, asArray(one));
        Assert.assertArrayEquals(new short[] {one, two}, asArray(one, two));
    }

    @Test
    public void asArrayInt() {
        Assert.assertArrayEquals(new int[] {}, asArray(new int[] {}));
        Assert.assertArrayEquals(new int[] {1}, asArray(1));
        Assert.assertArrayEquals(new int[] {1, 2}, asArray(1, 2));
    }

    @Test
    public void asArrayLong() {
        Assert.assertArrayEquals(new long[] {}, asArray(new long[] {}));
        Assert.assertArrayEquals(new long[] {1L}, asArray(1L));
        Assert.assertArrayEquals(new long[] {1L, 2L}, asArray(1L, 2L));
    }

    @Test
    public void asArrayFloat() {
        Assert.assertArrayEquals(new float[] {}, asArray(new float[] {}), 0.0f);
        Assert.assertArrayEquals(new float[] {1.0f}, asArray(1.0f), 0.0f);
        Assert.assertArrayEquals(new float[] {1.0f, 2.0f}, asArray(1.0f, 2.0f), 0.0f);
    }

    @Test
    public void asArrayDouble() {
        Assert.assertArrayEquals(new double[] {}, asArray(new double[] {}), 0.0d);
        Assert.assertArrayEquals(new double[] {1.0d}, asArray(1.0d), 0.0d);
        Assert.assertArrayEquals(new double[] {1.0d, 2.0d}, asArray(1.0d, 2.0d), 0.0d);
    }

    @Test
    public void asArrayBoolean() {
        Assert.assertArrayEquals(new boolean[] {}, asArray(new boolean[] {}));
        Assert.assertArrayEquals(new boolean[] {true}, asArray(true));
        Assert.assertArrayEquals(new boolean[] {true, false}, asArray(true, false));
    }

    @Test
    public void asArrayChar() {
        Assert.assertArrayEquals(new char[] {}, asArray(new char[] {}));
        Assert.assertArrayEquals(new char[] {'a'}, asArray('a'));
        Assert.assertArrayEquals(new char[] {'a', 'b'}, asArray('a', 'b'));
    }

    @Test
    public void asArrayString() {
        Assert.assertArrayEquals(new String[] {}, asArray(new String[] {}));
        Assert.assertArrayEquals(new String[] {"A"}, asArray("A"));
        Assert.assertArrayEquals(new String[] {"A", "B"}, asArray("A", "B"));
    }
}
