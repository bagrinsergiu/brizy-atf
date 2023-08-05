package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.version.CreateVersionDto;
import com.brizy.io.web.kiwi.tcms.dto.request.version.CreateVersionRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.request.version.VersionByNameDto;
import com.brizy.io.web.kiwi.tcms.dto.request.version.VersionByNameRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.response.version.CreateVersionResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.version.VersionDto;
import com.brizy.io.web.kiwi.tcms.dto.response.version.VersionResponseDto;
import com.brizy.io.web.kiwi.tcms.properties.api.AbstractProperty;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.base.KiwiTcmsBaseProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class VersionService extends AbstractService {

    AbstractProperty versionProperties;

    @Autowired
    public VersionService(RestTemplate restTemplate, KiwiTcmsBaseProperties baseProperties, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.versionProperties = apiProperties.getVersion();
    }

    public VersionDto getVersionByValue(String versionName) {
        List<VersionByNameDto> params = List.of(VersionByNameDto.builder().value(versionName).build());
        VersionByNameRequestDto body = VersionByNameRequestDto.builder().method(versionProperties.getFilter()).params(params).build();
        VersionResponseDto response = postAndGetEntity(body, VersionResponseDto.class);
        return response.getResult().stream().findFirst().orElse(new VersionDto());
    }

    public VersionDto createVersion(CreateVersionDto createVersion) {
        CreateVersionRequestDto body = CreateVersionRequestDto.builder().method(versionProperties.getCreate()).params(List.of(createVersion)).build();
        CreateVersionResponseDto VersionResponseDto = postAndGetEntity(body, CreateVersionResponseDto.class);
        return VersionResponseDto.getResult();
    }

}
