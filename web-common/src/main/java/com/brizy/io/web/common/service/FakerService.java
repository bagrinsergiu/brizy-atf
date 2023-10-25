package com.brizy.io.web.common.service;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class FakerService {

    @Bean
    public Faker faker() {
        return new Faker(Locale.UK);
    }

}
