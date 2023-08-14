package com.brizy.io.web.interactions.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public abstract class AbstractProperty {
    /**
     * Locator that will help to detect the item on page
     */
    String self;

}
