package com.brizy.io.web.test.steps.validations;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.NewPageContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.PagesTableContentDto;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPageCmsPopUpSteps {

    Storage storage;

    @Then("the created page must be in the list")
    public void theCreatedPageMustBeInTheList() {
        var expected = storage.getValue(StorageKey.TO_ASSERT_EXPECTED, NewPageContentDto.class);
        var actual = storage.getValue(StorageKey.TO_ASSERT_ACTUAL, PagesTableContentDto.class);
        boolean found = false;
        for (List<String> strings : actual.getContent()) {
            if (strings.contains(expected.getPageTitle())) {
                found = true;
                break;
            }
        }
        Assertions.assertThat(found).isTrue();
    }

}