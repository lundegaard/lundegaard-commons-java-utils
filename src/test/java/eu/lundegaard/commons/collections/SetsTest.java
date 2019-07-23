/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.collections;

import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class SetsTest {

    @Test
    public void getEmptySet() throws Exception {
        Set<Integer> set = Sets.of();

        assertNotNull(set);
        assertTrue(set.isEmpty());
    }

    @Test
    public void getOneElementSet() throws Exception {
        Set<Integer> set = Sets.of(1);

        assertNotNull(set);
        assertFalse(set.isEmpty());
        assertTrue(set.contains(1));
    }

    @Test
    public void getTwoElementSet() throws Exception {
        Set<Integer> set = Sets.of(1, 2, 1);

        assertNotNull(set);
        assertFalse(set.isEmpty());
        assertEquals(2, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
    }

}
