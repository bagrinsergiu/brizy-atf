package com.brizy.io.web.interactions.dto.editor.container.toolbar.counter;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public abstract class CounterPropertyDto implements EditorComponentProperty {

    Integer end;
    Double duration;

}
