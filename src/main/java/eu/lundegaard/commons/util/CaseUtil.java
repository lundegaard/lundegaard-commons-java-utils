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

import java.util.Arrays;
import java.util.stream.Collectors;
import static eu.lundegaard.commons.util.ValidateUtil.validateNotEmpty;
import static eu.lundegaard.commons.util.ValidateUtil.validateNotNull;

/**
 * This class allows you to convert strings between different formatting.
 *
 * The typical usage is to use fromX method to get words in the string followed
 * with toX method to put the string into target format.
 *
 * We support following formats:
 * <ul>
 * <li>lower case - 'this is an example'</li>
 * <li>upper case - 'THIS IS AN EXAMPLE'</li>
 * <li>camel case - 'thisIsAnExample'</li>
 * <li>upper camel case - 'ThisIsAnExample'</li>
 * <li>lower camel case - 'thisIsAnExample'</li>
 * <li>kebab case - 'this-is-an-example'</li>
 * <li>constant case - 'THIS_IS_AN_EXAMPLE'</li>
 * <li>snake case - 'this_is_an_example'</li>
 * </ul>
 * 
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class CaseUtil {

    private CaseUtil() {
        // private constructor for util class
    }

    /**
     * Parse words from camel case (e.g. 'thisIsAnExample').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromCamelCase(String input) {
        validateNotNull(input);

        return input.split("(?<!^)(?=[A-Z])");
    }

    /**
     * Parse words from upper camel case (e.g. 'ThisIsAnExample').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromUpperCamelCase(String input) {
        return fromCamelCase(input);
    }

    /**
     * Parse words from lower camel case (e.g. 'thisIsAnExample').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromLowerCamelCase(String input) {
        return fromCamelCase(input);
    }

    /**
     * Parse words from kebab case (e.g. 'this-is-an-example').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromKebabCase(String input) {
        validateNotNull(input);

        return input.split("-");
    }

    /**
     * Parse words from upper case (separated with spaces, e.g. 'THIS IS AN
     * EXAMPLE').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromUpperCase(String input) {
        // parsing is the same as from lower case
        return fromLowerCase(input);
    }

    /**
     * Parse words from lower case (separated with spaces, e.g. 'this is an
     * example')
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromLowerCase(String input) {
        validateNotNull(input);

        return input.split(" ");
    }

    /**
     * Parse words from constant case (e.g. 'THIS_IS_AN_EXAMPLE').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromConstantCase(String input) {
        // parsing is the same as for the snake case
        return fromSnakeCase(input);
    }

    /**
     * Parse words from snake case (e.g. 'this_is_an_example').
     *
     * @param input phrase to parse
     * @return array of parsed words with original case
     */
    public static String[] fromSnakeCase(String input) {
        validateNotNull(input);

        return input.split("_");
    }

    /**
     * Format array of words into camel case (e.g. 'thisIsAnExample').
     *
     * @param words words to format
     * @return String formatted in camel case
     */
    public static String toCamelCase(String[] words) {
        return toLowerCamelCase(words);
    }

    /**
     * Format array of words into upper camel case (e.g. 'ThisIsAnExample').
     *
     * @param words words to format
     * @return String formatted in upper camel case
     */
    public static String toUpperCamelCase(String[] words) {
        validateNotNull(words);

        return format(words, "", false, true, true);
    }

    /**
     * Format array of words into lower camel case (e.g. 'thisIsAnExample').
     *
     * @param words words to format
     * @return String formatted in lower camel case
     */
    public static String toLowerCamelCase(String[] words) {
        validateNotNull(words);

        return format(words, "", false, true, false);
    }

    /**
     * Format array of words into kebab case (e.g. 'this-is-an-example').
     *
     * @param words words to format
     * @return String formatted in kebab case
     */
    public static String toKebabCase(String[] words) {
        validateNotNull(words);

        return format(words, "-", false);
    }

    /**
     * Format array of words into upper case (separated with spaces, e.g. 'THIS IS
     * AN EXAMPLE').
     *
     * @param words words to format
     * @return String formatted in upper case
     */
    public static String toUpperCase(String[] words) {
        validateNotNull(words);

        return format(words, " ", true);
    }

    /**
     * Format array of words into lower case (separated with spaces, e.g. 'this is
     * an example').
     *
     * @param words words to format
     * @return String formatted in lower case
     */
    public static String toLowerCase(String[] words) {
        validateNotNull(words);

        return format(words, " ", false);
    }

    /**
     * Format array of words into constant case (e.g. 'THIS_IS_AN_EXAMPLE').
     *
     * @param words words to format
     * @return String formatted in constant case
     */
    public static String toConstantCase(String[] words) {
        validateNotNull(words);

        return format(words, "_", true);
    }

    /**
     * Format array of words into snake case (e.g. 'this_is_an_example').
     *
     * @param words words to format
     * @return String formatted in snake case
     */
    public static String toSnakeCase(String[] words) {
        validateNotNull(words);

        return format(words, "_", false);
    }

    private static String format(String[] words, String separator, boolean capitalized) {
        return format(words, separator, capitalized, capitalized, capitalized);
    }

    private static String format(String[] words, String separator, boolean capitalizedLetters, boolean capitalizedWords,
            boolean capitalizedPhrase) {
        validateNotEmpty(words);
        validateNotNull(separator);

        String phrase = Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .map(word -> formatWordCase(word, capitalizedLetters, capitalizedWords))
                .collect(Collectors.joining(separator));

        if (capitalizedPhrase != capitalizedWords) {
            phrase = formatFirstLetterCase(phrase, capitalizedPhrase);
        }

        return phrase;
    }

    private static String formatWordCase(String input, boolean allLettersCapital, boolean firstLetterCapital) {
        validateNotNull(input);

        if (input.isEmpty()) {
            return input;
        }

        if (input.length() == 1) {
            return formatStringCase(input, firstLetterCapital);
        }

        String result = formatStringCase(input, allLettersCapital);

        if (allLettersCapital != firstLetterCapital) {
            result = formatFirstLetterCase(result, firstLetterCapital);
        }

        return result;
    }

    private static String formatStringCase(String input, boolean toUpperCase) {
        validateNotNull(input);

        return toUpperCase ? input.toUpperCase() : input.toLowerCase();
    }

    private static String formatFirstLetterCase(String input, boolean toUpperCase) {
        validateNotNull(input);

        if (input.isEmpty()) {
            return input;
        }

        if (input.length() == 1) {
            return formatStringCase(input, toUpperCase);
        }

        String firstLetter = input.substring(0, 1);
        String otherLetters = input.substring(1);
        return formatStringCase(firstLetter, toUpperCase) + otherLetters;
    }

}
