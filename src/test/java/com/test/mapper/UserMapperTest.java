package com.test.mapper;

import com.test.controller.request.UserRequestBody;
import com.test.repository.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        UserMapperImpl.class
})
class UserMapperTest {

    private static final String USERNAME = "test";
    private static final String EMAIL = "test@test.com";
    @Autowired
    private UserMapper userMapper;

    @Test
    void toEntity() {
        var request = UserRequestBody.builder()
                .username(USERNAME)
                .email(EMAIL)
                .build();

        var response = userMapper.toEntity(request);

        assertThat(response).isNotNull();
        assertThat(response.getUsername()).isEqualTo(USERNAME);
        assertThat(response.getEmail()).isEqualTo(EMAIL);
    }

    @Test
    void toResponseBody() {
        var entity = UserEntity.builder()
                .username(USERNAME)
                .email(EMAIL)
                .build();

        var response = userMapper.toResponseBody(entity);

        assertThat(response).isNotNull();
        assertThat(response.getUsername()).isEqualTo(USERNAME);
        assertThat(response.getEmail()).isEqualTo(EMAIL);
    }
}