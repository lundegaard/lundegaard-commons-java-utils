/**
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
