package com.brizy.io.web.common.dto.element.properties.counter;

import com.brizy.io.web.common.dto.element.properties.counter.enums.StypeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Counter {

    StypeType style;

}