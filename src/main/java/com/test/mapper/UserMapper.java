package com.test.mapper;

import com.test.controller.request.UserRequestBody;
import com.test.controller.response.UserResponseBody;
import com.test.repository.entity.UserEntity;
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
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(getDataAtual())")
    @Mapping(target = "updatedAt", expression = "java(getDataAtual())")
    UserEntity toEntity(UserRequestBody requestBody);

    UserResponseBody toResponseBody(UserEntity userEntity);

    default LocalDateTime getDataAtual() {
        return LocalDateTime.now();
    }
}
