package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.countdown.CountdownProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Countdown extends AbstractPropertyType<CountdownProperties> implements ItemType {

    CountdownProperties properties;

}
