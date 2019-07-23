/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
