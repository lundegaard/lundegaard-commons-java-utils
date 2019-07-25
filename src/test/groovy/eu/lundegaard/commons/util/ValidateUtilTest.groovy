/**
 * Copyright (C) 2019 Lundegaard a.s., All Rights Reserved
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; version 3.0 of the
 * License.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
 */
package eu.lundegaard.commons.util

import spock.lang.Specification

import static eu.lundegaard.commons.util.ValidateUtil.validateNotEmpty
import static eu.lundegaard.commons.util.ValidateUtil.validateNotNull


/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
class ValidateUtilTest extends Specification {

    def "Test validateNotNull with null"() {
        when:
        validateNotNull(null)

        then:
        thrown(IllegalArgumentException)
    }

    def "Test validateNotNull with value"() {
        when:
        validateNotNull("hello")

        then:
        notThrown(IllegalArgumentException)
    }

    def "Test validateNotEmpty with empty things"() {
        when:
        validateNotEmpty(input)

        then:
        thrown(IllegalArgumentException)

        where:
        input            | _
        ""               | _
        new ArrayList()  | _
        []               | _
        new HashMap()    | _
    }

    def "Test validateNotEmpty with null"() {
        when:
        validateNotEmpty((List)null)

        then:
        thrown(IllegalArgumentException)
    }

    def "Test validateNotEmpty with non empty things"() {
        when:
        validateNotEmpty(input)

        then:
        notThrown(IllegalArgumentException)

        where:
        input              | _
        "a"                | _
        Arrays.asList("a") | _
        ["a"]              | _
        ["a": "b"]         | _

    }

}
