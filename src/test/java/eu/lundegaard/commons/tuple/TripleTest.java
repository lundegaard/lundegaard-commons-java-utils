/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.tuple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 */
public class TripleTest {

    private final static String FIRST = "first value";
    private final static String SECOND = "second value";
    private final static String THIRD = "third value";

    @Test(expected = IllegalArgumentException.class)
    public void nullValuesNotAllowed() {
        Triple<String, String, String> alpha = new Triple<>(null, SECOND, THIRD);
    }

    @Test
    public void sameTriplesEqual() {
        Triple<String, String, String> alpha = new Triple<>(FIRST, SECOND, THIRD);
        Triple<String, String, String> beta = new Triple<>(FIRST, SECOND, THIRD);

        assertTrue(alpha.equals(beta));
        assertTrue(beta.equals(alpha));
    }

    @Test
    public void pairWithSwitchedValuesAreNotEqual() {
        Triple<String, String, String> alpha = new Triple<>(FIRST, SECOND, THIRD);
        Triple<String, String, String> beta = new Triple<>(SECOND, THIRD, FIRST);

        assertFalse(alpha.equals(beta));
        assertFalse(beta.equals(alpha));
    }

    @Test
    public void gettersWork() {
        Triple<String, String, String> alpha = new Triple<>(FIRST, SECOND, THIRD);

        assertEquals(FIRST, alpha.getFirst());
        assertEquals(SECOND, alpha.getSecond());
        assertEquals(THIRD, alpha.getThird());
    }

}
