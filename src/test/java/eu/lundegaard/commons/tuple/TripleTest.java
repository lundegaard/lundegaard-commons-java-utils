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

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
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

        assertThat(alpha).isEqualTo(beta);
        assertThat(beta).isEqualTo(alpha);
    }

    @Test
    public void pairWithSwitchedValuesAreNotEqual() {
        Triple<String, String, String> alpha = new Triple<>(FIRST, SECOND, THIRD);
        Triple<String, String, String> beta = new Triple<>(SECOND, THIRD, FIRST);

        assertThat(alpha).isNotEqualTo(beta);
        assertThat(beta).isNotEqualTo(alpha);
    }

    @Test
    public void gettersWork() {
        Triple<String, String, String> alpha = new Triple<>(FIRST, SECOND, THIRD);

        assertThat(alpha.getFirst()).isEqualTo(FIRST);
        assertThat(alpha.getSecond()).isEqualTo(SECOND);
        assertThat(alpha.getThird()).isEqualTo(THIRD);
    }

    @Test
    public void withWorks() {
        Triple<String, String, String> alpha = new Triple<>(FIRST, FIRST, FIRST);

        alpha = alpha.withFirst(SECOND).withSecond(SECOND).withThird(SECOND);

        assertThat(alpha.getFirst()).isEqualTo(SECOND);
        assertThat(alpha.getSecond()).isEqualTo(SECOND);
        assertThat(alpha.getThird()).isEqualTo(SECOND);
    }

}
