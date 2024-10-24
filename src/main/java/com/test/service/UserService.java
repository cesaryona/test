package com.test.service;

import com.test.controller.request.UserRequestBody;
import com.test.controller.response.UserResponseBody;

import java.util.List;

public interface UserService {

    List<UserResponseBody> findAll();

    void saveUser(UserRequestBody request);
}
