/**
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
package eu.lundegaard.commons.util

import spock.lang.Specification

/**
 *
 * @author AldaR
 */
class StringUtilTest extends Specification {

    def "Method getSafeFilename should handle diacritics and special chars"() {
        expect:
        output == StringUtil.getSafeFilename(input)

        where:
        input            | output
        "ěščřžýáíéůú"    | "escrzyaieuu"
        "ĚŠČŘŽÝÁÍÉŮÚ"    | "ESCRZYAIEUU"
        "ľňďťëäüö"       | "lndteauo"
        "ĽŇĎŤËÄÜÖ"       | "LNDTEAUO"
        "`~!@#\$%^&*={}" | "_____________"
        ";'\\:\"|,/<>?"  | "___________"
        "()-_+[]."       | "()-_+[]."
    }

    def "Test method replaceFilenameUnsafeChars"() {
        expect:
        output == StringUtil.replaceFilenameUnsafeChars(input, "_")

        where:
        input            | output
        "`~!@#\$%^&*={}" | "_____________"
        ";'\\:\"|,/<>?"  | "___________"
        "()-_+[]."       | "()-_+[]."
    }

    def "Test method removeMultipleOccurrencesOfChar"() {
        expect:
        output == StringUtil.removeMultipleOccurrencesOfChar(input, '_' as char)

        where:
        input         | output
        "_"           | "_"
        "__"          | "_"
        "___"         | "_"
        "____"        | "_"
        "_____"       | "_"
        "______"      | "_"
        "_______"     | "_"
        "________"    | "_"
        "_A_"         | "_A_"
        "__A__"       | "_A_"
        "___A___"     | "_A_"
        "__A__A__"    | "_A_A_"
        "_____A_____" | "_A_"
        "A____A____A" | "A_A_A"
        "_A___A___A_" | "_A_A_A_"
    }

    def "Test method removeDiacriticalMarks"() {
        expect:
        output == StringUtil.removeDiacriticalMarks(input)

        where:
        input         | output
        "ěščřžýáíéůú" | "escrzyaieuu"
        "ĚŠČŘŽÝÁÍÉŮÚ" | "ESCRZYAIEUU"
        "ľňďťëäüö"    | "lndteauo"
        "ĽŇĎŤËÄÜÖ"    | "LNDTEAUO"
    }

    def "Test method startsWithIgnoreCase"() {
        expect:
        output == StringUtil.startsWithIgnoreCase(haystack, prefix)

        where:
        haystack | prefix | output
        ""       | ""     | true
        "a"      | ""     | true
        "a"      | "a"    | true
        "a"      | "A"    | true
        "A"      | "a"    | true
        "A"      | "A"    | true
        "ab"     | "a"    | true
        "ab"     | "A"    | true
        "Ab"     | "a"    | true
        "Ab"     | "A"    | true
        ""       | "a"    | false
        "b"      | "a"    | false
        "ba"     | "a"    | false
    }
}
