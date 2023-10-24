package com.brizy.io.web.test.parameter_type;


import com.github.javafaker.Faker;
import io.cucumber.java.ParameterType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class StringParameterType {

    Faker faker;

    @ParameterType(name = "customString", value = "randomSentence|randomEmail")
    public String customString(String rawValue) {
        if (rawValue.equalsIgnoreCase("randomSentence")) {
            return faker.lorem().sentence(150, 100);
        }
        if (rawValue.equalsIgnoreCase("randomEmail")) {
            return faker.internet().emailAddress();
        }
        return rawValue;
    }

}
