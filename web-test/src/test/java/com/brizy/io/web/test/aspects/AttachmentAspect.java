package com.brizy.io.web.test.aspects;

import com.brizy.io.web.test.service.ActivePageService;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static io.qameta.allure.Allure.getLifecycle;

@Aspect
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class AttachmentAspect {

    ActivePageService activePageService;

    @Pointcut("@annotation(com.brizy.io.web.test.functional.Attachment)")
    public void hasAttachmentAnnotation() {
    }

    @Pointcut("@within(com.brizy.io.web.test.functional.Attachment)")
    public void hasAttachmentClassAnnotation() {
    }

    @Pointcut("execution(* *(..))")
    public void methodExecution() {
    }

    @Before("methodExecution() && (hasAttachmentAnnotation() || hasAttachmentClassAnnotation())")
    public void attachScreenshotBefore(JoinPoint joinPoint) {
        Page activePage = activePageService.getPage();
        byte[] screenshot = activePage.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        getLifecycle().addAttachment("Before Method Execution Screenshot ".concat(LocalDateTime.now().toString()),
                "image/png",
                "png",
                screenshot
        );
    }

    @After("methodExecution() && (hasAttachmentAnnotation() || hasAttachmentClassAnnotation())")
    public void attachScreenshotAfter(JoinPoint joinPoint) {
        Page activePage = activePageService.getPage();
        byte[] screenshot = activePage.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        getLifecycle().addAttachment("After Method Execution Screenshot ".concat(LocalDateTime.now().toString()),
                "image/png",
                "png",
                screenshot
        );
    }

}
