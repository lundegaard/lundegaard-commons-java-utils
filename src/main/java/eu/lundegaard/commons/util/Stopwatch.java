/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Simple stopwatch for measuring time spent in different tasks.
 *
 * Typical usage would be:
 * 
 * <pre>
 * {@code
 * Stopwatch stopwatch = Stopwatch.start();
 * // action performed here
 * stopwatch.stop()
 * LOG.info{"Action took {}", stopwatch.pretty()}
 * }
 * </pre>
 *
 * The {@code pretty()} has some small overhead, so if you're really obsessed
 * with effectiveness you should use
 * 
 * <pre>
 * {@code
 * Stopwatch stopwatch = Stopwatch.start();
 * // action performed here
 * stopwatch.stop()
 * LOG.info{"Action took {}ms", stopwatch.elapsedTime()}
 * }
 * </pre>
 *
 * You don't need to use {@code stop()} method. Then the elapsed time will be
 * calculated from current time.
 *
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class Stopwatch {

    private static final long NO_TIME = -1;

    private static final long MILLIS_IN_SECOND = 1000;
    private static final long MILLIS_IN_MINUTE = 60 * MILLIS_IN_SECOND;

    private final long startTime;
    private long elapsedTime = NO_TIME;

    private Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    private Stopwatch(Date startDate) {
        this.startTime = startDate.getTime();
    }

    /**
     * Starts new stopwatch.
     *
     * This is the way you will use this class the most.
     *
     * @return New instance of stopwatch started at current time.
     */
    public static Stopwatch start() {
        return new Stopwatch();
    }

    /**
     * Get new stopwatch with defined start time.
     *
     * You probably won't need this. But it is useful for writing tests.
     *
     * @param startDateTime Time to be used as starting time of measuring
     * @return New instance of stopwatch started at given time.
     */
    public static Stopwatch startedAt(Date startDateTime) {
        return new Stopwatch(startDateTime);
    }

    /**
     * Get new stopwatch with defined start time.
     *
     * You probably won't need this. But it is useful for writing tests.
     *
     * @param startDateTime Time to be used as starting time of measuring
     * @return New instance of stopwatch started at given time.
     */
    public static Stopwatch startedAt(LocalDateTime startDateTime) {
        return new Stopwatch(DateUtil.toDate(startDateTime));
    }

    /**
     * Stop the stopwatch at current time.
     *
     * The method returns the elapsed time so you don't have to call
     * {@code elapsedTime()} separately (but you can).
     *
     * @return Elapsed time.
     */
    public long stop() {
        elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }

    /**
     * Get elapsed time for this stopwatch.
     *
     * If the stopwatch has been stopped, the elapsed time is time between the
     * moment of start and the moment the {@code stop()} method has been called.
     *
     * If the method {@code stop()} hasn't been called on this stopwatch, current
     * time is used instead.
     *
     * @return Elapsed time in milliseconds.
     */
    public long elapsedTime() {
        return (elapsedTime == NO_TIME) ? System.currentTimeMillis() - startTime : elapsedTime;
    }

    /**
     * Prints out formatted elapsed time.
     *
     * @return String with representation of the elapsed time.
     */
    public String pretty() {
        long time = elapsedTime();
        if (time > 3 * MILLIS_IN_MINUTE) {
            return Long.toString(time / MILLIS_IN_MINUTE) + "m";
        } else if (time > 3 * MILLIS_IN_SECOND) {
            return Long.toString(time / MILLIS_IN_SECOND) + "s";
        } else {
            return Long.toString(time) + "ms";
        }
    }

}
