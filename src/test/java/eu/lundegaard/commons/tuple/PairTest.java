/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
