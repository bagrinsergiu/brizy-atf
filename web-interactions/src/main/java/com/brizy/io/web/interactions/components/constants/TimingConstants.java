package com.brizy.io.web.interactions.components.constants;

import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class TimingConstants {

    public Duration MAX_WAITING_TIME_FOR_FRAME_TO_LOAD = Duration.of(30, ChronoUnit.SECONDS);

}