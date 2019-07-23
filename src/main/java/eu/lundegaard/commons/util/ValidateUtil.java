/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class ValidateUtil {

    private ValidateUtil() {
        // private constructor for util class
    }

    public static void validateNotNull(Object object) {
        validateNotNull(object, "Object must not be null.");
    }

    public static void validateNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(Object[] array) {
        validateNotEmpty(array, "Array must not be empty.");
    }

    public static void validateNotEmpty(Object[] array, String message) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(Collection collection) {
        validateNotEmpty(collection, "Collection must not be empty.");
    }

    public static void validateNotEmpty(Collection collection, String message) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(Map map) {
        validateNotEmpty(map, "Map must not be empty.");
    }

    public static void validateNotEmpty(Map map, String message) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEmpty(String string) {
        validateNotEmpty(string, "String value must not be empty.");
    }

    public static void validateNotEmpty(String string, String message) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

}
