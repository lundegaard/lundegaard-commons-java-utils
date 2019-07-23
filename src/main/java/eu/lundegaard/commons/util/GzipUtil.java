/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
@SuppressWarnings("WeakerAccess")
public final class GzipUtil {

    private static final int BUFFER_SIZE = 4096;

    /**
     * Gunzip data.
     *
     * @param input Input containing compressed data
     * @return byte array of decompressed data
     * @throws IOException when there is an I/O problem while reading the data from
     *         the source.
     */
    public static byte[] gunzip(byte[] input) throws IOException {
        if (input == null) {
            return null;
        }
        if (input.length == 0) {
            return new byte[] {};
        }

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
                GZIPInputStream gzipInput = new GZIPInputStream(inputStream);
                ByteArrayOutputStream output = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = gzipInput.read(buffer, 0, BUFFER_SIZE)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            return output.toByteArray();

        }
    }

    /**
     * Gzip data.
     *
     * @param input Input containing plain data
     * @return byte array with gzipped data
     * @throws IOException when there is an I/O problem while reading the data from
     *         the source.
     */
    public static byte[] gzip(byte[] input) throws IOException {
        if (input == null) {
            return null;
        }
        if (input.length == 0) {
            return new byte[] {};
        }

        try (ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
                GZIPOutputStream gzipOutput = new GZIPOutputStream(bytesOutput)) {

            gzipOutput.write(input);
            gzipOutput.close();
            return bytesOutput.toByteArray();

        }
    }
}
