/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.util.Arrays;
import org.junit.*;
import static eu.lundegaard.commons.util.GzipUtil.gunzip;
import static eu.lundegaard.commons.util.GzipUtil.gzip;
import static org.junit.Assert.*;

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
        byte[] gunzipped = gunzip(gzipped);

        // then
        assertTrue("Compressed data are smaller than original.", gzipped.length < original.length);
        assertTrue("Decompressed data are same as original.", Arrays.equals(original, gunzipped));
    }

}
