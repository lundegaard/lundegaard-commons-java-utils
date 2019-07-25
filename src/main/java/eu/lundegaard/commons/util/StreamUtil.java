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
