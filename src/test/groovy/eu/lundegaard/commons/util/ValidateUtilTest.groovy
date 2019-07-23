/**
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
