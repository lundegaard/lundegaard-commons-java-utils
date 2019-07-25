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
import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(alpha).isEqualTo(beta);
        assertThat(beta).isEqualTo(alpha);
    }

    @Test
    public void pairWithSwitchedValuesAreNotEqual() {
        Pair<String, String> alpha = new Pair<>(FIRST, SECOND);
        Pair<String, String> beta = new Pair<>(SECOND, FIRST);

        assertThat(alpha).isNotEqualTo(beta);
        assertThat(beta).isNotEqualTo(alpha);
    }

    @Test
    public void gettersWork() {
        Pair<String, String> alpha = new Pair<>(FIRST, SECOND);

        assertThat(alpha.getFirst()).isEqualTo(FIRST);
        assertThat(alpha.getSecond()).isEqualTo(SECOND);
    }

    @Test
    public void withWorks() {
        Pair<String, String> alpha = new Pair<>(FIRST, FIRST);

        alpha = alpha.withFirst(SECOND).withSecond(SECOND);

        assertThat(alpha.getFirst()).isEqualTo(SECOND);
        assertThat(alpha.getSecond()).isEqualTo(SECOND);
    }

}
