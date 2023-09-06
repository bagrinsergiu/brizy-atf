package com.brizy.io.web.common.dto.element.properties.common.settings;

import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import com.brizy.io.web.common.dto.element.properties.common.Settings;

public interface CanHaveSettings extends Settings {

    InputWithUnitsProperties getWidth();

    InputWithUnitsProperties getHeight();

}
