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

import org.junit.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.*;

/**
 * @author Milan Hruban (milan.hruban@lundegaard.eu)
 */
public class UrlUtilTest {

    @Test
    public void getUrlQueryParameters_Simple() {
        // Given
        String url = "www.domain.com/search?user=Jared";

        // When
        Map<String, List<String>> parsedParams = UrlUtil.getUrlQueryParameters(url);

        // Then
        assertThat(parsedParams).isNotEmpty().hasSize(1);
        assertThat(parsedParams).containsKeys("user");
        assertThat(parsedParams.get("user")).contains("Jared");
    }

    @Test
    public void getUrlQueryParameters_MultipleParams() {
        // Given
        String url =
                "www.domain.com/search?user=John&query=dog+toys&position=first&position=second&position=third&id=15";

        // When
        Map<String, List<String>> parsedParams = UrlUtil.getUrlQueryParameters(url);

        // Then
        assertThat(parsedParams).isNotEmpty().hasSize(4);
        assertThat(parsedParams).containsKeys("position", "query", "user", "id");
        assertThat(parsedParams.get("position")).contains("first", "second", "third");
        assertThat(parsedParams.get("query")).contains("dog+toys");
        assertThat(parsedParams.get("user")).contains("John");
        assertThat(parsedParams.get("id")).contains("15");
    }

    @Test
    public void getUrlQueryParameters_NoParams() {
        assertThat(UrlUtil.getUrlQueryParameters("www.google.com/search/results")).isEmpty();
    }

    @Test
    public void getUrlQueryParameters_MalformedParams() {
        // Given
        String url = "www.domain.com/search?alpha=&beta&&gamma==&delta=+&";

        // When
        Map<String, List<String>> parsedParams = UrlUtil.getUrlQueryParameters(url);

        // Then
        assertThat(parsedParams).isNotEmpty().hasSize(3);
        assertThat(parsedParams).containsOnlyKeys("alpha", "gamma", "delta");
        assertThat(parsedParams.get("alpha")).contains("");
        assertThat(parsedParams.get("gamma")).contains("=");
        assertThat(parsedParams.get("delta")).contains("+");
    }

    @Test
    public void getUrlQueryParameters_Malformed() {
        assertThat(UrlUtil.getUrlQueryParameters(null)).isEmpty();
        assertThat(UrlUtil.getUrlQueryParameters("")).isEmpty();
        assertThat(UrlUtil.getUrlQueryParameters("&$(@)$")).isEmpty();
    }

    @Test
    public void parseUrlQueryParameters_Simple() {
        // Given
        String urlQuery = "user=Jared";

        // When
        Map<String, List<String>> parsedParams = UrlUtil.parseUrlQueryParameters(urlQuery);

        // Then
        assertThat(parsedParams).isNotEmpty().hasSize(1);
        assertThat(parsedParams).containsKeys("user");
        assertThat(parsedParams.get("user")).contains("Jared");
    }

    @Test
    public void parseUrlQueryParameters_MultipleParams() {
        // Given
        String url = "user=John&query=dog+toys&position=first&position=second&position=third&id=15";

        // When
        Map<String, List<String>> parsedParams = UrlUtil.parseUrlQueryParameters(url);

        // Then
        assertThat(parsedParams).isNotEmpty().hasSize(4);
        assertThat(parsedParams).containsKeys("position", "query", "user", "id");
        assertThat(parsedParams.get("position")).contains("first", "second", "third");
        assertThat(parsedParams.get("query")).contains("dog+toys");
        assertThat(parsedParams.get("user")).contains("John");
        assertThat(parsedParams.get("id")).contains("15");
    }

    @Test
    public void parseUrlQueryParameters_NoParams() {
        assertThat(UrlUtil.getUrlQueryParameters(null)).isEmpty();
        assertThat(UrlUtil.getUrlQueryParameters("")).isEmpty();
    }

    @Test
    public void parseUrlQueryParameters_MalformedParams() {
        // Given
        String urlQuery = "alpha=&beta&&gamma==&delta=+&";

        // When
        Map<String, List<String>> parsedParams = UrlUtil.parseUrlQueryParameters(urlQuery);

        // Then
        assertThat(parsedParams).isNotEmpty().hasSize(3);
        assertThat(parsedParams).containsOnlyKeys("alpha", "gamma", "delta");
        assertThat(parsedParams.get("alpha")).contains("");
        assertThat(parsedParams.get("gamma")).contains("=");
        assertThat(parsedParams.get("delta")).contains("+");
    }

    @Test
    public void parseUrlQueryParameters_Malformed() {
        assertThat(UrlUtil.parseUrlQueryParameters(null)).isEmpty();
        assertThat(UrlUtil.parseUrlQueryParameters("")).isEmpty();
        assertThat(UrlUtil.parseUrlQueryParameters("&$(@)$")).isEmpty();
    }
}
