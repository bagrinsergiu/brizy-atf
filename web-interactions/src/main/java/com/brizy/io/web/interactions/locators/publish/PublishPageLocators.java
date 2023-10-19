package com.brizy.io.web.interactions.locators.publish;

import com.brizy.io.web.interactions.locators.publish.section.SectionLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PublishPageLocators {

    @NestedConfigurationProperty
    SectionLocators section;

}
