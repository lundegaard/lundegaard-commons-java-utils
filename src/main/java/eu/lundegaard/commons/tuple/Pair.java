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
 * Pair of two values.
 *
 * Use as parent for specific classes, in Java8 streams or as return type when
 * one value is not enough. The values MUST NOT be {@code null}, otherwise
 * {@link IllegalArgumentException} is thrown.
 *
 * The {@link Pair} is implemented as immutable. Of course if you are building
 * immutable data structures it also depend on the value types used.
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
@SuppressWarnings("WeakerAccess")
public class Pair<T, U> {

    private final T first;
    private final U second;

    public Pair(T first, U second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Values of the pair must not be null.");
        }

        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    /**
     * Get new {@link Pair} with the first value changed.
     *
     * @param newFirst New value for the first value
     * @return New instance of {@link Pair}.
     */
    public Pair<T, U> withFirst(T newFirst) {
        return new Pair<>(newFirst, second);
    }

    public U getSecond() {
        return second;
    }

    /**
     * Get new {@link Pair} with the second value changed.
     *
     * @param newSecond New value for the second value
     * @return New instance of {@link Pair}.
     */
    public Pair<T, U> withSecond(U newSecond) {
        return new Pair<>(first, newSecond);
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

        Pair<T, U> pair = (Pair<T, U>) o;

        if (!first.equals(pair.first)) {
            return false;
        }

        return second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + first + "," + second + "}";
    }
}
