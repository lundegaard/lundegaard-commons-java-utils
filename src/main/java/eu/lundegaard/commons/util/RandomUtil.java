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

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static eu.lundegaard.commons.util.ValidateUtil.validateNotEmpty;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class RandomUtil {

    private RandomUtil() {
        // private constructor for util class
    }

    /**
     * Get a pseudorandom int number.
     *
     * @return Pseudorandom int number.
     */
    public static int getRandomInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    /**
     * Get a pseudorandom int number between zero (inclusive) and bound (exclusive).
     *
     * @param bound the upper bound (exclusive). Must be positive.
     * @return Pseudorandom int number.
     */
    public static int getRandomInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    /**
     * Get a pseudorandom int number between origin (inclusive) and bound
     * (exclusive).
     *
     * @param origin the lower bound (inclusive). Must be positive.
     * @param bound the upper bound (exclusive). Must be positive and greater than
     *        origin.
     * @return Pseudorandom int number.
     */
    public static int getRandomInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    /**
     * Get a pseudorandom long number.
     *
     * @return Pseudorandom long number.
     */
    public static long getRandomLong() {
        return ThreadLocalRandom.current().nextLong();
    }

    /**
     * Get a pseudorandom long number between zero (inclusive) and bound
     * (exclusive).
     *
     * @param bound the upper bound (exclusive)
     * @return Pseudorandom long number.
     */
    public static long getRandomLong(long bound) {
        return ThreadLocalRandom.current().nextLong(bound);
    }

    /**
     * Get a pseudorandom long number between origin (inclusive) and bound
     * (exclusive).
     *
     * @param origin the lower bound (inclusive). Must be positive.
     * @param bound the upper bound (exclusive). Must be positive and greater than
     *        origin.
     * @return Pseudorandom long number.
     */
    public static long getRandomLong(long origin, long bound) {
        return ThreadLocalRandom.current().nextLong(origin, bound);
    }

    /**
     * Get a pseudorandom boolean value.
     *
     * @return Pseudorandom boolean value.
     */
    public static boolean getRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * Get random item from the given list.
     *
     * @param objects List of objects to select from. Must not be null, must not be
     *        empty
     * @param <T> Type of items in the list
     * @return Single item selected randomly from the list.
     */
    public static <T> T getRandomFromList(List<T> objects) {
        validateNotEmpty(objects, "Input list must not be empty or null.");
        return objects.get(getRandomInt(objects.size()));
    }

}
