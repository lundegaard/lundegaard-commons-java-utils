/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
public class Maps {

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
