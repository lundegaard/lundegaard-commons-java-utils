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
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
class CaseUtilTest extends Specification {

    def "Test conversion fromCamelCase"() {
        expect:
        output == CaseUtil.fromCamelCase(input)

        where:
        input         | output
        ""            | [""] as String[]
        "this"        | ["this"]
        "This"        | ["This"]
        "thisIsATest" | ["this", "Is", "A", "Test"]
        "ThisIsATest" | ["This", "Is", "A", "Test"]
    }

    def "Test conversion fromKebabCase"() {
        expect:
        output == CaseUtil.fromKebabCase(input)

        where:
        input            | output
        ""               | [""] as String[]
        "this"           | ["this"]
        "This"           | ["This"]
        "this-is-a-test" | ["this", "is", "a", "test"]
        "This-Is-A-Test" | ["This", "Is", "A", "Test"]
    }

    def "Test conversion fromUpperCase"() {
        expect:
        output == CaseUtil.fromUpperCase(input)

        where:
        input            | output
        ""               | [""] as String[]
        "this"           | ["this"]
        "THIS"           | ["THIS"]
        "this is a test" | ["this", "is", "a", "test"]
        "THIS IS A TEST" | ["THIS", "IS", "A", "TEST"]
    }

    def "Test conversion fromLowerCase"() {
        expect:
        output == CaseUtil.fromLowerCase(input)

        where:
        input            | output
        ""               | [""] as String[]
        "this"           | ["this"]
        "this is a test" | ["this", "is", "a", "test"]
        "This Is A Test" | ["This", "Is", "A", "Test"]
    }

    def "Test conversion fromConstantCase"() {
        expect:
        output == CaseUtil.fromConstantCase(input)

        where:
        input            | output
        ""               | [""] as String[]
        "THIS"           | ["THIS"]
        "THIS_IS_A_TEST" | ["THIS", "IS", "A", "TEST"]
    }

    def "Test conversion fromSnakeCase"() {
        expect:
        output == CaseUtil.fromSnakeCase(input)

        where:
        input            | output
        ""               | [""] as String[]
        "this"           | ["this"]
        "this_is_a_test" | ["this", "is", "a", "test"]
    }

    def "Test conversion toUpperCamelCase"() {
        expect:
        output == CaseUtil.toUpperCamelCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "A"
        ["A"]                       | "A"
        ["test"]                    | "Test"
        ["this", "is", "a", "test"] | "ThisIsATest"
        ["This", "Is", "A", "Test"] | "ThisIsATest"
        ["THIS", "IS", "A", "TEST"] | "ThisIsATest"
        ["THiS", "iS", "a", "TeST"] | "ThisIsATest"
        ["thIs", "Is", "A", "tEst"] | "ThisIsATest"
    }

    def "Test conversion toLowerCamelCase"() {
        expect:
        output == CaseUtil.toLowerCamelCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "a"
        ["A"]                       | "a"
        ["test"]                    | "test"
        ["this", "is", "a", "test"] | "thisIsATest"
        ["This", "Is", "A", "Test"] | "thisIsATest"
        ["THIS", "IS", "A", "TEST"] | "thisIsATest"
        ["THiS", "iS", "a", "TeST"] | "thisIsATest"
        ["thIs", "Is", "A", "tEst"] | "thisIsATest"
    }

    def "Test conversion toKebabCase"() {
        expect:
        output == CaseUtil.toKebabCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "a"
        ["A"]                       | "a"
        ["test"]                    | "test"
        ["this", "is", "a", "test"] | "this-is-a-test"
        ["This", "Is", "A", "Test"] | "this-is-a-test"
        ["THIS", "IS", "A", "TEST"] | "this-is-a-test"
        ["THiS", "iS", "a", "TeST"] | "this-is-a-test"
        ["thIs", "Is", "A", "tEst"] | "this-is-a-test"
    }

    def "Test conversion toUpperCase"() {
        expect:
        output == CaseUtil.toUpperCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "A"
        ["A"]                       | "A"
        ["test"]                    | "TEST"
        ["this", "is", "a", "test"] | "THIS IS A TEST"
        ["This", "Is", "A", "Test"] | "THIS IS A TEST"
        ["THIS", "IS", "A", "TEST"] | "THIS IS A TEST"
        ["THiS", "iS", "a", "TeST"] | "THIS IS A TEST"
        ["thIs", "Is", "A", "tEst"] | "THIS IS A TEST"
    }

    def "Test conversion toLowerCase"() {
        expect:
        output == CaseUtil.toLowerCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "a"
        ["A"]                       | "a"
        ["test"]                    | "test"
        ["this", "is", "a", "test"] | "this is a test"
        ["This", "Is", "A", "Test"] | "this is a test"
        ["THIS", "IS", "A", "TEST"] | "this is a test"
        ["THiS", "iS", "a", "TeST"] | "this is a test"
        ["thIs", "Is", "A", "tEst"] | "this is a test"
    }

    def "Test conversion toConstantCase"() {
        expect:
        output == CaseUtil.toConstantCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "A"
        ["A"]                       | "A"
        ["test"]                    | "TEST"
        ["this", "is", "a", "test"] | "THIS_IS_A_TEST"
        ["This", "Is", "A", "Test"] | "THIS_IS_A_TEST"
        ["THIS", "IS", "A", "TEST"] | "THIS_IS_A_TEST"
        ["THiS", "iS", "a", "TeST"] | "THIS_IS_A_TEST"
        ["thIs", "Is", "A", "tEst"] | "THIS_IS_A_TEST"
    }

    def "Test conversion toSnakeCase"() {
        expect:
        output == CaseUtil.toSnakeCase(input as String[])

        where:
        input                       | output
        [""]                        | ""
        ["a"]                       | "a"
        ["A"]                       | "a"
        ["test"]                    | "test"
        ["this", "is", "a", "test"] | "this_is_a_test"
        ["This", "Is", "A", "Test"] | "this_is_a_test"
        ["THIS", "IS", "A", "TEST"] | "this_is_a_test"
        ["THiS", "iS", "a", "TeST"] | "this_is_a_test"
        ["thIs", "Is", "A", "tEst"] | "this_is_a_test"
    }
}
