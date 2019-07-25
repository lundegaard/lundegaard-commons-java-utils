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
package eu.lundegaard.commons.tuple;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 */
public class PairTest {

    private final static String FIRST = "first value";
    private final static String SECOND = "second value";

    @Test(expected = IllegalArgumentException.class)
    public void nullValuesNotAllowed() {
        Pair<String, String> alpha = new Pair<>(null, SECOND);
    }

    @Test
    public void samePairsEqual() {
        Pair<String, String> alpha = new Pair<>(FIRST, SECOND);
        Pair<String, String> beta = new Pair<>(FIRST, SECOND);

        assertTrue(alpha.equals(beta));
        assertTrue(beta.equals(alpha));
    }

    @Test
    public void pairWithSwitchedValuesAreNotEqual() {
        Pair<String, String> alpha = new Pair<>(FIRST, SECOND);
        Pair<String, String> beta = new Pair<>(SECOND, FIRST);

        assertFalse(alpha.equals(beta));
        assertFalse(beta.equals(alpha));
    }

    @Test
    public void gettersWork() {
        Pair<String, String> alpha = new Pair<>(FIRST, SECOND);

        assertEquals(FIRST, alpha.getFirst());
        assertEquals(SECOND, alpha.getSecond());
    }

}
