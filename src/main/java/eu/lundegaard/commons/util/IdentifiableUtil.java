/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
                .map(item -> item.getId())
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
