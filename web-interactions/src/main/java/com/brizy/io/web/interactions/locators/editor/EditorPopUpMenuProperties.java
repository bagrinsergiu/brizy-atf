package com.brizy.io.web.interactions.locators.editor;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.pop_up.EditorPopUpMenuBodyProperties;
import com.brizy.io.web.interactions.locators.editor.pop_up.EditorPopUpMenuHeaderProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorPopUpMenuProperties extends AbstractProperty {

    @NestedConfigurationProperty
    EditorPopUpMenuHeaderProperties header;
    @NestedConfigurationProperty
    EditorPopUpMenuBodyProperties body;

}
