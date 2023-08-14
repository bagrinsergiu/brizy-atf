package com.brizy.io.web.kiwi.tcms.service;

import com.brizy.io.web.kiwi.tcms.dto.request.classification.ClassificationByNameDto;
import com.brizy.io.web.kiwi.tcms.dto.request.classification.ClassificationByNameRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.request.classification.CreateClassificationDto;
import com.brizy.io.web.kiwi.tcms.dto.request.classification.CreateClassificationRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.response.classification.ClassificationDto;
import com.brizy.io.web.kiwi.tcms.dto.response.classification.ClassificationResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.classification.CreateClassificationResponseDto;
import com.brizy.io.web.kiwi.tcms.properties.api.AbstractProperty;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import com.brizy.io.web.kiwi.tcms.properties.base.KiwiTcmsBaseProperties;
import com.brizy.io.web.kiwi.tcms.properties.base.details.ClassificationProperties;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class ClassificationService extends AbstractService {

    KiwiTcmsBaseProperties baseProperties;
    AbstractProperty classificationProperties;

    @Autowired
    public ClassificationService(RestTemplate restTemplate, KiwiTcmsBaseProperties baseProperties, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.baseProperties = baseProperties;
        this.classificationProperties = apiProperties.getClassification();
    }

    public ClassificationDto getClassificationByName(String classificationName) {
        List<ClassificationByNameDto> params = List.of(ClassificationByNameDto.builder().name(classificationName).build());
        ClassificationByNameRequestDto body = ClassificationByNameRequestDto.builder().method(classificationProperties.getFilter()).params(params).build();
        ClassificationResponseDto response = postAndGetEntity(body, ClassificationResponseDto.class);
        return response.getResult().stream().findFirst().orElse(new ClassificationDto());
    }

    public ClassificationDto createDefaultClassification() {
        ClassificationProperties classification = baseProperties.getDetails().getClassification();
        List<CreateClassificationDto> params = List.of(CreateClassificationDto.builder().name(classification.getName()).build());
        CreateClassificationRequestDto body = CreateClassificationRequestDto.builder().method(classificationProperties.getCreate()).params(params).build();
        CreateClassificationResponseDto classificationResponseDto = postAndGetEntity(body, CreateClassificationResponseDto.class);
        return classificationResponseDto.getResult();
    }

}
