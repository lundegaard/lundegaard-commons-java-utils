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

import java.text.Normalizer;
import static eu.lundegaard.commons.util.ValidateUtil.validateNotNull;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public final class StringUtil {

    private StringUtil() {
        // private constructor for util class
    }

    public static String getSafeFilename(String input) {
        validateNotNull(input);

        String s = input;
        s = removeDiacriticalMarks(s);
        s = replaceFilenameUnsafeChars(s, "_");
        return s;
    }

    public static String removeDiacriticalMarks(String input) {
        validateNotNull(input);

        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static String replaceFilenameUnsafeChars(String input, String replacement) {
        validateNotNull(input);
        validateNotNull(replacement);

        return input.replaceAll("[^a-zA-Z0-9 \\(\\)_\\+\\[\\]\\.-]", replacement);
    }

    public static String removeMultipleOccurrencesOfChar(String input, char character) {
        String pattern = "[" + character + "]{2,}";
        String replacement = String.valueOf(character);
        return input.replaceAll(pattern, replacement);
    }

    public static boolean startsWithIgnoreCase(String haystack, String prefix) {
        validateNotNull(haystack);
        validateNotNull(prefix);

        if (haystack.length() < prefix.length()) {
            return false;
        }

        String hayPrefix = haystack.substring(0, prefix.length());

        return hayPrefix.equalsIgnoreCase(prefix);
    }

}
