package com.test.mapper;

import com.test.controller.request.ProductRequestBody;
import com.test.controller.response.ProductResponseBody;
import com.test.repository.entity.ProductEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDateTime;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true),
        imports = {LocalDateTime.class}
)
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(getDataAtual())")
    @Mapping(target = "updatedAt", expression = "java(getDataAtual())")
    ProductEntity toEntity(ProductRequestBody requestBody);

    ProductResponseBody toResponseBody(ProductEntity product);

    default LocalDateTime getDataAtual() {
        return LocalDateTime.now();
    }
}
