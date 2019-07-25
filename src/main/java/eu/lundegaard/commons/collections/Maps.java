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
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for easy initialization of maps.
 *
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public final class Maps {

    private Maps() {
        // empty constructor for utility class
    }

    public static <K, V> MapBuilder<K, V> of(K firstKey, V firstValue) {
        return new MapBuilder<>(new HashMap<K, V>()).put(firstKey, firstValue);
    }

    public static <K, V> MapBuilder<K, V> with(Map<K, V> map) {
        return new MapBuilder<>(map);
    }

    public static class MapBuilder<K, V> {

        private final Map<K, V> map;

        public MapBuilder(Map<K, V> map) {
            this.map = map;
        }

        public MapBuilder<K, V> put(K key, V value) {
            map.put(key, value);
            return this;
        }

        public Map<K, V> build() {
            return map;
        }

        public Map<K, V> buildUnmodifiable() {
            return Collections.unmodifiableMap(map);
        }

        public Map<K, V> buildSynchronized() {
            return Collections.synchronizedMap(map);
        }

    }

}
