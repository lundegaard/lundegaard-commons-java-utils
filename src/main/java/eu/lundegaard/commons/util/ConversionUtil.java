/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import eu.lundegaard.commons.iface.Identifiable;
import static eu.lundegaard.commons.util.ValidateUtil.validateNotNull;

/**
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public final class ConversionUtil {

    private ConversionUtil() {
        // private constructor for util class
    }

    /**
     * Converts list of objects to list of longs.
     *
     * Method supports converting of these types:
     * <ul>
     * <li>numbers</li>
     * <li>strings (which contain parsable long value)</li>
     * <li>{@link Identifiable} (tries to convert ID to long)</li>
     * </ul>
     *
     * If the object cannot be converted to long, it is quietly omitted from the
     * result (no exception is thrown). This means that the resulting list might be
     * shorter than the input list.
     *
     * @param inputList List of the input objects
     * @return List of longs.
     */
    public static List<Long> toLongs(List<Object> inputList) {
        validateNotNull(inputList);

        return inputList.stream()
                .map(ConversionUtil::toLongOrNull)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Tries best to convert given object to long.
     *
     * Method supports converting of these types:
     * <ul>
     * <li>numbers</li>
     * <li>strings (which contain parsable long value)</li>
     * <li>{@link Identifiable} (tries to convert ID to long)</li>
     * </ul>
     *
     * @param input The input object to be converted into long
     * @return Long value of given object
     */
    public static Long toLong(Object input) {
        Optional<Long> result = Optional.ofNullable(toLongOrNull(input));
        return result.orElseThrow(() -> new NumberFormatException("Cannot convert " + input + " to long."));
    }

    private static Long toLongOrNull(Object input) {
        if (input == null) {
            return null;
        }

        if (input instanceof Number) {
            return ((Number) input).longValue();
        }

        if (input instanceof String) {
            return stringToLongOrNull((String) input);
        }

        if (input instanceof Identifiable) {
            Object id = ((Identifiable) input).getId();
            return toLongOrNull(id);
        }

        return null;
    }

    private static Long stringToLongOrNull(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
