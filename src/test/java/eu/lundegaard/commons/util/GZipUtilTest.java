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
import static eu.lundegaard.commons.util.GzipUtil.gunzip;
import static eu.lundegaard.commons.util.GzipUtil.gzip;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public class GZipUtilTest {

    private static final String LOREM_IPSUM = "Contrary to popular belief, Lorem Ipsum is not simply random text. "
            + "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. "
            + "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the "
            + "more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of "
            + "the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections "
            + "1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, "
            + "written in 45 BC. This book is a treatise on the theory of ethics, very popular during the "
            + "Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in "
            + "section 1.10.32.";

    @Test
    public void testGzipCompressionWorks() throws Exception {
        // given
        byte[] original = LOREM_IPSUM.getBytes("UTF-8");

        // when
        byte[] gzipped = gzip(original);
        System.out.println(gzipped.length);
        byte[] gunzipped = gunzip(gzipped);

        // then
        assertThat(gzipped.length).isLessThan(original.length);
        assertThat(gunzipped).isEqualTo(original);
    }

    @Test
    public void testGzip_null() throws Exception {
        // given
        byte[] emptyByteArray = new byte[0];

        // when
        byte[] result = gzip(null);

        // expect
        assertThat(result).isEqualTo(emptyByteArray);
    }

    @Test
    public void testGzip_empty() throws Exception {
        // given
        byte[] emptyByteArray = new byte[0];

        // when
        byte[] result = gzip(emptyByteArray);

        // expect
        assertThat(result).isEqualTo(emptyByteArray);
    }

    @Test
    public void testGunzip_null() throws Exception {
        // given
        byte[] emptyByteArray = new byte[0];

        // when
        byte[] result = gunzip(null);

        // expect
        assertThat(result).isEqualTo(emptyByteArray);
    }

    @Test
    public void testGunzip_empty() throws Exception {
        // given
        byte[] emptyByteArray = new byte[0];

        // when
        byte[] result = gunzip(emptyByteArray);

        // expect
        assertThat(result).isEqualTo(emptyByteArray);
    }

}

