package com.brizy.io.web.test.functional;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface Attachment {
}
