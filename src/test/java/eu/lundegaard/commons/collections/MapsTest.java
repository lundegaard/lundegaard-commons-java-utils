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

import java.util.List;
import java.util.Map;
import org.junit.Test;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class MapsTest {

    @Test
    public void with() throws Exception {
        // Given
        Map<String, Integer> map1 = Maps.of("Ahoj", 2).build();

        // When
        Map<String, Integer> map2 = Maps.with(map1)
                .put("Cau", 3)
                .build();

        // Then
        assertNotNull(map2);
        assertEquals(2, map2.size());
        assertTrue(map2.containsKey("Ahoj"));
        assertEquals((Integer) 2, map2.get("Ahoj"));
        assertTrue(map2.containsKey("Cau"));
        assertEquals((Integer) 3, map2.get("Cau"));
    }

    @Test
    public void of() {
        // When
        Map<String, Integer> map = Maps.of("Ahoj", 2).put("Cau", 3).build();

        // Then
        assertNotNull(map);
        assertEquals(2, map.size());
        assertTrue(map.containsKey("Ahoj"));
        assertEquals((Integer) 2, map.get("Ahoj"));
        assertTrue(map.containsKey("Cau"));
        assertEquals((Integer) 3, map.get("Cau"));
    }

    @Test
    public void ofWithList() throws Exception {
        // When
        Map<String, List<Integer>> map = Maps
                .of("Ahoj", asList(2, 5, 6))
                .put("Cau", asList(3, 4))
                .put("Hey", asList(7, 8, 9, 10))
                .build();

        // Then
        assertNotNull(map);
        assertEquals(3, map.size());
    }

    @Test
    public void buildUnmodifiable() {
        // When
        Map<String, Integer> map = Maps.of("Ahoj", 2).buildUnmodifiable();

        // Then
        assertNotNull(map);
        assertEquals(1, map.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableMapCantBeModified() {
        // When
        Map<String, Integer> map = Maps.of("Ahoj", 2).buildUnmodifiable();

        // Then
        map.put("Cau", 3); // Should throw exception
    }

    @Test
    public void buildSynchronized() {
        // When
        Map<String, Integer> map = Maps.of("Ahoj", 2).buildSynchronized();

        // Then
        assertNotNull(map);
        assertEquals(1, map.size());
        // there is no easy way to test, that map is synchronized :-/
    }

}
