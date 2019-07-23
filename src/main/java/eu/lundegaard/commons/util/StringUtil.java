/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
