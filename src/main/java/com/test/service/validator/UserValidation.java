package com.test.service.validator;

import com.test.controller.request.UserRequestBody;

public interface UserValidation {
    boolean validate(UserRequestBody userRequestBody);

}
