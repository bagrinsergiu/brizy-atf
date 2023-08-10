package com.brizy.io.web.interactions.dto.editor.container.toolbar;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Configuration {

    String name;
    Supplier<?> element;

}
