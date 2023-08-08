package com.brizy.io.web.interactions.constants;

import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class TimingConstants {

    public Duration MAX_WAITING_TIME_FOR_FRAME_TO_LOAD = Duration.of(30, ChronoUnit.SECONDS);
    public Duration POLL_DELAY_FOR_NUMERIC_VALUE_READ = Duration.of(500, ChronoUnit.MILLIS);
    public Duration MIN_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY = Duration.of(1, ChronoUnit.MILLIS);
    public Duration MAX_TIME_OF_WAITING_FOR_NUMERIC_VALUE_TO_APPLY = Duration.of(10, ChronoUnit.SECONDS);

}