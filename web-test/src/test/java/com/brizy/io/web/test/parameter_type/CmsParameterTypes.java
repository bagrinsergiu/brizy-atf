package com.brizy.io.web.test.parameter_type;

import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.enums.FooterActions;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.common.content.enums.HeaderActions;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.enums.AssetsMenuItems;
import com.brizy.io.web.interactions.page.editor.container.cms.enums.CmsTabs;
import io.cucumber.java.ParameterType;
import io.vavr.control.Try;

public class CmsParameterTypes {

    @ParameterType(name = "cmsTab", value = "assets|menu|ASSETS|MENU|Assets|Menu")
    public CmsTabs cmsTab(String rawValue) {
        return CmsTabs.valueOf(rawValue.toUpperCase());
    }

    @ParameterType(name = "assetsMenuItem", value = "Posts|posts|POSTS|Pages|pages|PAGES|Stories|stories|STORIES|Pop Ups|pop ups|POP UPS|Users|users|USERS")
    public AssetsMenuItems assetsMenuItem(String rawValue) {
        return Try.of(() -> AssetsMenuItems.valueOf(rawValue.toUpperCase())).getOrElse(AssetsMenuItems.POP_UPS);
    }

    @ParameterType(name = "footerNewContentButton", value = "Save Changes|save changes|SAVE CHANGES|Cancel|cancel|CANCEL")
    public FooterActions footerNewContentButton(String rawValue) {
        if (rawValue.toLowerCase().trim().startsWith("save")) {
            return FooterActions.SAVE;
        }
        return FooterActions.CANCEL;
    }

    @ParameterType(name = "headerNewContentButton", value = "Back|back|BACK|Close|close|CLOSE")
    public HeaderActions headerNewContentButton(String rawValue) {
        if (rawValue.toLowerCase().trim().startsWith("back")) {
            return HeaderActions.BACK;
        }
        return HeaderActions.CLOSE;
    }

}
