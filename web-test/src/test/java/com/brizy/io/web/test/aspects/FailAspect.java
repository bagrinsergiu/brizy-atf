package com.brizy.io.web.test.aspects;

import com.brizy.io.web.test.service.ActivePageService;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static io.qameta.allure.Allure.getLifecycle;

@Aspect
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class FailAspect {

    ActivePageService activePageService;

    @AfterThrowing(pointcut = "execution(* com.brizy.io.web.test.steps..*(..))", throwing = "throwable")
    public void attachScreenshotOnFailure(Throwable throwable) {
        Page activePage = activePageService.getPage();
        byte[] screenshot = activePage.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        getLifecycle().addAttachment("Failed Method Execution Screenshot ".concat(LocalDateTime.now().toString()),
                "image/png",
                "png",
                screenshot
        );

        if (throwable instanceof com.microsoft.playwright.TimeoutError) {
            byte[] content = "Steps failed because of loading issue, page loading took more than 30 seconds".getBytes();
            getLifecycle().addAttachment("Cause of failing: ".concat(LocalDateTime.now().toString()),
                    "text/plain",
                    "log",
                    content
            );
        }
    }


}
