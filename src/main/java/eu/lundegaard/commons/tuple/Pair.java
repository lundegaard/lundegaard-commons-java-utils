/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.tuple;

import java.io.Serializable;
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
public class Pair<T, U> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T first;
    private U second;

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
