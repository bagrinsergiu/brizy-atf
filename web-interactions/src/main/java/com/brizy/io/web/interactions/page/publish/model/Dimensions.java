package com.brizy.io.web.interactions.page.publish.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
public class Dimensions {

    double width;
    double height;

}
