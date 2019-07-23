/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public final class StreamUtil {

    /**
     * Returns {@code Optional} object as stream.
     *
     * This can be used to shorten constuct like this {@code
     * streamOfOptionalObjects
     *         .filter(Optional::isPresent)  // to filter out empty items
     *         .map(Optional::get)  // to obtain actual value
     * }
     *
     * into more simple and concise {@code
     * streamOfOptionalObjects
     *         .flatMap(StreamUtil::streamOfNonEmpty)
     * }
     *
     * This method will be deprecated in JDK9 in favor of {@code Optional::stream}.
     *
     * @param opt Optional item
     * @param <T> Type of the items in the stream
     * @return Empty stream if the optional was empty, one-item stream otherwise.
     */
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <T> Stream<T> streamOfNonEmpty(Optional<T> opt) {
        return opt.map(Stream::of).orElse(Stream.empty());
    }

}
