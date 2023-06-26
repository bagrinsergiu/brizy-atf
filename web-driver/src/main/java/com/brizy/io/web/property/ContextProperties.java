package com.brizy.io.web.property;

import com.microsoft.playwright.options.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ContextProperties {

    Boolean acceptDownloads;
    String baseUrl;
    Boolean bypassCSP;
    ColorScheme colorScheme;
    Double deviceScaleFactor;
    Map<String, String> extraHTTPHeaders;
    ForcedColors forcedColors;
    GeoLocation geoLocation;
    Boolean hasTouch;
    HttpCredentials httpCredentials;
    Boolean ignoreHTTPSErrors;
    Boolean isMobile;
    Boolean javaScriptEnabled;
    String locale;
    Boolean offline;
    List<String> permissions;
    String proxy;
    HarContentPolicy recordHarContent;
    HarMode recordHarMode;
    Boolean recordHarOmitContent;
    Path recordHarPath;
    String recordHarUrlFilter;
    Path recordVideoDir;
    RecordVideoSize recordVideoSize;
    ReducedMotion reducedMotion;
    ScreenSize screenSize;
    ServiceWorkerPolicy serviceWorkers;
    String storageState;
    Path storageStatePath;
    Boolean strictSelectors;
    Integer timezoneId;
    String userAgent;
    ViewportSize viewportSize;

}
