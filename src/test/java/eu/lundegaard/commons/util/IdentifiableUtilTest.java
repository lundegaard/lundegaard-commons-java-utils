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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import eu.lundegaard.commons.iface.Identifiable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 */
public class IdentifiableUtilTest {

    private static final Thing THING_1 = new Thing(1L);
    private static final Thing THING_2 = new Thing(2L);
    private static final Thing THING_3 = new Thing(3L);
    private static final Thing THING_4 = new Thing(4L);

    public static final List<Thing> TEST_LIST = Arrays.asList(THING_4, THING_2, THING_3, THING_1);

    @Test
    public void testGetIds() {
        // when
        List<Long> result = IdentifiableUtil.getIds(TEST_LIST);

        // then
        List<Long> expResult = Arrays.asList(4L, 2L, 3L, 1L);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindInList() {
        // given
        Long id = 3L;

        // when
        Optional<Thing> result = IdentifiableUtil.findInList(TEST_LIST, id);

        // then
        assertTrue(result.isPresent());
        assertEquals(THING_3, result.get());
    }

    @Test
    public void testFindInList_NotFound() {
        // given
        Long id = 100L; // such Thing isn't in the list

        // when
        Optional<Thing> result = IdentifiableUtil.findInList(TEST_LIST, id);

        // then
        assertFalse(result.isPresent());
    }

    private static class Thing implements Identifiable<Long> {

        private Long id;

        public Thing(Long id) {
            this.id = id;
        }

        @Override
        public Long getId() {
            return id;
        }
    }

}
