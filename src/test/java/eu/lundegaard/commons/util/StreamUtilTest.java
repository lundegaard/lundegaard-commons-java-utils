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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class StreamUtilTest {

    @Test
    public void streamOfNonEmpty() throws Exception {
        // given
        List<Optional<String>> items = Arrays.asList(
                Optional.empty(),
                Optional.of("Streams"),
                Optional.empty(),
                Optional.of("are"),
                Optional.empty(),
                Optional.of("beautiful"),
                Optional.empty());

        // expect
        assertEquals("Standard functionality", 3, items.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .count());

        assertEquals("Our functionality", 3, items.stream()
                .flatMap(StreamUtil::streamOfNonEmpty)
                .count());
    }

}
