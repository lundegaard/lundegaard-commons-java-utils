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

import java.util.Objects;

/**
 * Triple (3-tuple) of three values.
 *
 * Use as parent for specific classes, in Java8 streams or as return type when
 * one value or {@link Pair} are not enough. The values MUST NOT be
 * {@code null}, otherwise {@link IllegalArgumentException} is thrown.
 *
 * The {@link Triple} is implemented as immutable. Of course if you are building
 * immutable data structures it also depend on the value types used.
 *
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
@SuppressWarnings("WeakerAccess")
public class Triple<T, U, V> {

    private T first;
    private U second;
    private V third;

    public Triple(T first, U second, V third) {
        if (first == null || second == null || third == null) {
            throw new IllegalArgumentException("Values of must not be null.");
        }

        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    /**
     * Get new {@link Triple} with the first value changed.
     *
     * @param newFirst New value for the first value
     * @return New instance of {@link Triple}.
     */
    public Triple<T, U, V> withFirst(T newFirst) {
        return new Triple<>(newFirst, second, third);
    }

    public U getSecond() {
        return second;
    }

    /**
     * Get new {@link Triple} with the second value changed.
     * 
     * @param newSecond New value for the first value
     * @return New instance of {@link Triple}.
     */
    public Triple<T, U, V> withSecond(U newSecond) {
        return new Triple<>(first, newSecond, third);
    }

    public V getThird() {
        return third;
    }

    /**
     * Get new {@link Triple} with the third value changed.
     * 
     * @param newThird New value for the first value
     * @return New instance of {@link Triple}.
     */
    public Triple<T, U, V> withThird(V newThird) {
        return new Triple<>(first, second, newThird);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triple<T, U, V> triple = (Triple<T, U, V>) o;

        if (!first.equals(triple.first)) {
            return false;
        }

        if (!second.equals(triple.second)) {
            return false;
        }

        return third.equals(triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + first + "," + second + "," + third + "}";
    }
}
