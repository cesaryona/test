package com.test.service.validator;

import com.test.controller.request.UserRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final List<UserValidation> validations;

    public boolean validateUser(final UserRequestBody requestBody) {
        for (UserValidation validation : validations) {
            if (!validation.validate(requestBody)) {
                return false;
            }
        }

        return true;
    }
}
