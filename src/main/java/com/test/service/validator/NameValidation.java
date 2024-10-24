package com.test.service.validator;

import com.test.controller.request.UserRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NameValidation implements UserValidation{

    @Override
    public boolean validate(UserRequestBody userRequestBody) {
        log.info("1");
        return userRequestBody.getUsername().isBlank();
    }
}
