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
