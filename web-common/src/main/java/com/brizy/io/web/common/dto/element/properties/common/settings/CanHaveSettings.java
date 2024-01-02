package com.brizy.io.web.common.dto.element.properties.common.settings;

import com.brizy.io.web.common.dto.element.properties.common.Settings;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;

public interface CanHaveSettings extends Settings {

    InputWithUnitsProperties getWidth();

    InputWithUnitsProperties getHeight();

}
