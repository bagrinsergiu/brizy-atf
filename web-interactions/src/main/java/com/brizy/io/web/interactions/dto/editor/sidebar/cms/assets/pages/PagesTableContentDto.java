package com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PagesTableContentDto implements TableContentDto {

    List<List<String>> content;

}
