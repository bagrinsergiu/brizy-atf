package com.brizy.io.web.interactions.constants;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public final class TimingConstants {

    public static final Duration MAX_WAITING_TIME_FOR_FRAME_TO_LOAD = Duration.of(30, ChronoUnit.SECONDS);
    public static final Duration POLL_DELAY_FOR_NUMERIC_VALUE_READ = Duration.of(500, ChronoUnit.MILLIS);
    public static final Duration MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY = Duration.of(1, ChronoUnit.MILLIS);
    public static final Duration MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY = Duration.of(10, ChronoUnit.SECONDS);

}