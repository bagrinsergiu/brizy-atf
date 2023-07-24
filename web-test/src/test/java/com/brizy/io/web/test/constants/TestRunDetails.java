package com.brizy.io.web.test.constants;

import com.brizy.io.web.test.listener.TestPhase;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@UtilityClass
public class TestRunDetails {

    public final static Map<TestPhase, Object> testRunDetails = new HashMap<>();
    public static final Supplier<String> getStringFormattedCurrentDateTime = () -> LocalDateTime.now().toInstant(ZoneOffset.UTC).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

}
