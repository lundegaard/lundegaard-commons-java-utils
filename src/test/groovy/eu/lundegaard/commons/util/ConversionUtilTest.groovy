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

import eu.lundegaard.commons.iface.Identifiable
import spock.lang.Specification

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
class ConversionUtilTest extends Specification {

    private static final LongThing LT_1 = new LongThing(1L);

    private static final StringThing ST_1 = new StringThing("1");
    private static final StringThing ST_2 = new StringThing("2");
    private static final StringThing ST_X = new StringThing("X");


    def "toLongs"() {
        expect:
        result == ConversionUtil.toLongs(input)

        where:
        input                    | result
        [1]                      | [1L]
        [1L]                     | [1L]
        ["1"]                    | [1L]
        [LT_1]                   | [1L]
        [ST_1]                   | [1L]
        [1, 1L, "1", LT_1, ST_1] | [1L, 1L, 1L, 1L, 1L]
        []                       | []
        [null]                   | []
        [null, LT_1]             | [1L]
        [LT_1, null]             | [1L]
        [ST_1, ST_X, ST_2]       | [1L, 2L]
        [ST_X]                   | []
        [LT_1, LT_1]             | [1L, 1L]
    }

    def "toLong"() {
        expect:
        result == ConversionUtil.toLong(input)

        where:
        input | result
        0     | 0L
        1     | 1L
        -1    | -1L
        0L    | 0L
        1L    | 1L
        -1L   | -1L
        "0"   | 0L
        "1"   | 1L
        "-1"  | -1L
        LT_1  | 1L
        ST_1  | 1L
    }

    static class LongThing implements Identifiable<Long> {

        private long id;

        public LongThing(long id) {
            this.id = id
        }

        @Override
        Long getId() {
            return id;
        }
    }

    static class StringThing implements Identifiable<String> {

        private String id;

        public StringThing(String id) {
            this.id = id
        }

        @Override
        String getId() {
            return id;
        }
    }

}

