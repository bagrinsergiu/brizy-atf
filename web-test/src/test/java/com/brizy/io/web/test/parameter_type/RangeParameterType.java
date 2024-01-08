package com.brizy.io.web.test.parameter_type;


import io.cucumber.java.ParameterType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class RangeParameterType {

    @ParameterType(value = ".*", name = "rangeType")
    public Range<Integer> rangeType(String rawValue) {
        var list = Arrays.stream(rawValue.replaceAll("\\[", StringUtils.EMPTY)
                        .replaceAll("]", StringUtils.EMPTY)
                        .split("[ !,?._'@]+"))
                .map(Integer::parseInt)
                .toList();
        return Range.between(list.get(0), list.get(1));
    }

}
