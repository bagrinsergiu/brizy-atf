package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.build.CreateBuildDto;
import com.brizy.io.web.kiwi.tcms.dto.request.build.CreateBuildRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.request.build.BuildByNameDto;
import com.brizy.io.web.kiwi.tcms.dto.request.build.BuildByNameRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.response.build.BuildResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.build.CreateBuildResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.build.BuildDto;
import com.brizy.io.web.kiwi.tcms.properties.api.AbstractProperty;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.base.KiwiTcmsBaseProperties;
import io.vavr.control.Option;
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
public class BuildService extends AbstractService {

    AbstractProperty buildProperties;

    @Autowired
    public BuildService(RestTemplate restTemplate, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.buildProperties = apiProperties.getBuild();
    }

    public BuildDto getBuildByName(String buildName) {
        List<BuildByNameDto> params = List.of(BuildByNameDto.builder().name(buildName).build());
        BuildByNameRequestDto body = BuildByNameRequestDto.builder().method(buildProperties.getFilter()).params(params).build();
        BuildResponseDto response = postAndGetEntity(body, BuildResponseDto.class);
        return Option.of(response.getResult())
                .map(e -> e.stream().findFirst().orElse(new BuildDto()))
                .getOrElse(new BuildDto());
    }

    public BuildDto createBuild(CreateBuildDto createBuild) {
        CreateBuildRequestDto body = CreateBuildRequestDto.builder().method(buildProperties.getCreate()).params(List.of(createBuild)).build();
        CreateBuildResponseDto BuildResponseDto = postAndGetEntity(body, CreateBuildResponseDto.class);
        return BuildResponseDto.getResult();
    }

}
