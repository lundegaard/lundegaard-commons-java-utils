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

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class RandomUtilTest {


    private static final int RANDOM_COUNT = 1000;

    @Test
    public void getRandomInt() {
        // when
        int result = RandomUtil.getRandomInt();

        // then
        assertThat(result)
                .isGreaterThanOrEqualTo(Integer.MIN_VALUE)
                .isLessThanOrEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void getRandomInt_bound() {
        // when - I generate X random numbers
        List<Integer> randoms = new ArrayList<>(RANDOM_COUNT);
        for (int i = 0; i < RANDOM_COUNT; i++) {
            randoms.add(RandomUtil.getRandomInt(3));
        }

        // then
        assertThat(randoms).containsOnly(0, 1, 2); // containsOnly -> only those numbers must be present
    }

    @Test
    public void getRandomInt_originAndBound() {
        // when - I generate X random numbers
        List<Integer> randoms = new ArrayList<>(RANDOM_COUNT);
        for (int i = 0; i < RANDOM_COUNT; i++) {
            randoms.add(RandomUtil.getRandomInt(2, 5));
        }

        // then
        assertThat(randoms).containsOnly(2, 3, 4); // containsOnly -> only those numbers must be present
    }

    @Test
    public void getRandomLong() {
        // when
        long result = RandomUtil.getRandomLong();

        // then
        assertThat(result)
                .isGreaterThanOrEqualTo(Long.MIN_VALUE)
                .isLessThanOrEqualTo(Long.MAX_VALUE);
    }

    @Test
    public void getRandomLong_bound() {
        // when - I generate X random numbers
        List<Long> randoms = new ArrayList<>(RANDOM_COUNT);
        for (int i = 0; i < RANDOM_COUNT; i++) {
            randoms.add(RandomUtil.getRandomLong(3));
        }

        // then
        assertThat(randoms).containsOnly(0L, 1L, 2L); // containsOnly -> only those numbers must be present
    }

    @Test
    public void getRandomLong_originAndBound() {
        // when - I generate X random numbers
        List<Long> randoms = new ArrayList<>(RANDOM_COUNT);
        for (int i = 0; i < RANDOM_COUNT; i++) {
            randoms.add(RandomUtil.getRandomLong(2, 5));
        }

        // then
        assertThat(randoms).containsOnly(2L, 3L, 4L); // containsOnly -> only those numbers must be present
    }

    @Test
    public void getRandomBoolean() {
        // when - I generate X random booleans
        List<Boolean> randoms = new ArrayList<>(RANDOM_COUNT);
        for (int i = 0; i < RANDOM_COUNT; i++) {
            randoms.add(RandomUtil.getRandomBoolean());
        }

        // then
        assertThat(randoms).containsOnly(true, false); // containsOnly -> only those numbers must be present
    }

    @Test
    public void getRandomFromList() {
        // given
        List<String> options = Arrays.asList("alpha", "beta", "gamma", "delta");

        // when - I generate X random booleans
        List<String> randoms = new ArrayList<>(RANDOM_COUNT);
        for (int i = 0; i < RANDOM_COUNT; i++) {
            randoms.add(RandomUtil.getRandomFromList(options));
        }

        // then
        assertThat(randoms).containsOnlyElementsOf(options); // containsOnlyElementsOf -> only those items must be present
    }
}
