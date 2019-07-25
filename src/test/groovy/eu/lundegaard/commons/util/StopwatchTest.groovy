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

import java.time.LocalDateTime

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
class StopwatchTest extends Specification {

    def "Basic usage"() {
        when:
        Stopwatch stopwatch = Stopwatch.start();
        Thread.sleep(500)
        long time1 = stopwatch.stop()
        long time2 = stopwatch.elapsedTime()

        then:
        time1 == time2
        time1 >= 500 && time1 < 600
    }

    def "ElapsedTime"() {
        when:
        Stopwatch stopwatch = Stopwatch.start();
        Thread.sleep(500)
        long time1 = stopwatch.elapsedTime()
        Thread.sleep(500)
        long time2 = stopwatch.stop()

        then:
        time1 != time2
        time1 >= 500 && time1 < 600
        time2 >= 1000 && time2 < 1100
    }

    def "Pretty formatting"() {
        when:
        Stopwatch stopwatch = Stopwatch.startedAt(start)
        String result = stopwatch.pretty()

        then:
        result.endsWith(endsWith);

        where:
        start                                | endsWith
        LocalDateTime.now()                  | "ms"
        LocalDateTime.now().minusSeconds(45) | "45s"
        LocalDateTime.now().minusMinutes(15) | "15m"
    }
}
