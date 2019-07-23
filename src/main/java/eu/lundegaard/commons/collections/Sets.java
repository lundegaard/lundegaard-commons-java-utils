/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
