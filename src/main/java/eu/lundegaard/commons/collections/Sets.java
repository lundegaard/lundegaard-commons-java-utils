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
package eu.lundegaard.commons.collections;

import java.util.Collections;
import java.util.HashSet;

/**
 * Utility class for easy initialization of sets.
 *
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class Sets {

    /**
     * Use this method to easy and quick creation of HashSet.
     *
     * @param elements Elements from which the set will be created
     * @param <E> Type of the elements in the set.
     * @return New {@link HashSet} with given elements
     */
    @SafeVarargs
    public static <E> HashSet<E> of(E... elements) {
        HashSet<E> set = new HashSet<E>(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

}
