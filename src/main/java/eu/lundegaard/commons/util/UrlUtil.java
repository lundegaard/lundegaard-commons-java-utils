/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * @author Milan Hruban (milan.hruban@lundegaard.eu)
 */
public class UrlUtil {

    private UrlUtil() {
        // private constructor for util class
    }

    /**
     * Parse query parameters from HTTP URL.
     *
     * The parsed parameter values are not URL-decoded!
     *
     * @param url string value of the encoded URL
     * @return parameter names mapped to list of respective parameter values in raw
     *         format. Empty map for malformed or empty URLs and for URLs with no
     *         parameters.
     */
    public static Map<String, List<String>> getUrlQueryParameters(String url) {
        if (url == null) {
            return Collections.emptyMap();
        }

        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            return Collections.emptyMap();
        }

        return parseUrlQueryParameters(uri.getRawQuery());
    }

    /**
     * Parse query parameters from the query part of the HTTP URL.
     *
     * The parsed parameter values are not URL-decoded!
     *
     * @param urlQuery Query part of the URL (the part after <code>?</code> in the
     *        URL)
     * @return parameter names mapped to list of respective parameter values in raw
     *         format. Empty map for malformed or empty URLs and for URLs with no
     *         parameters.
     */
    public static Map<String, List<String>> parseUrlQueryParameters(String urlQuery) {
        if (urlQuery != null && !urlQuery.isEmpty()) {
            return Arrays.stream(urlQuery.split("&"))
                    .map(UrlUtil::splitStringToMapEntry)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(groupingBy(Map.Entry::getKey, LinkedHashMap::new, mapping(Map.Entry::getValue, toList())));
        }

        return Collections.emptyMap();
    }

    /**
     * Split string into map entry by '=' separator. If more separators are present,
     * the first one is used.
     *
     * @param str String value to be split
     * @return Optional of Map.Entry
     */
    private static Optional<Map.Entry<String, String>> splitStringToMapEntry(String str) {
        String[] splitString = str.split("=", 2);
        if (splitString.length != 2) {
            return Optional.empty();
        }
        return Optional.of(new AbstractMap.SimpleEntry<>(splitString[0], splitString[1]));
    }
}
