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

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import eu.lundegaard.commons.iface.Identifiable;

/**
 * Utility methods to work with {@link Identifiable} items.
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public final class IdentifiableUtil {

    private IdentifiableUtil() {
        // private constructor for util class
    }

    /**
     * Convert list of {@link Identifiable} items into list of their IDs.
     *
     * @param <I> type used for identifying items
     * @param itemsList List of identifiable items
     * @return List of IDs
     */
    public static <I extends Serializable> List<I> getIds(List<? extends Identifiable<I>> itemsList) {
        return itemsList.stream()
                .map(Identifiable::getId)
                .collect(Collectors.toList());
    }

    /**
     * Find item in the list by ID.
     *
     * This method goes through the list of {@link Identifiable} items and finds one
     * with given ID. That isn't very effective and usage of some indexed access is
     * recommended.
     *
     * @param list List of all items to be searched in
     * @param id ID of the item to be found
     * @param <T> Type of the items in the list and the item returned
     * @param <I> Type used for identifying items
     * @return Item with given ID.
     */
    public static <I extends Serializable, T extends Identifiable<I>> Optional<T> findInList(List<T> list, I id) {
        return list.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
