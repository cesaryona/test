package com.test.service.impl;


import com.test.controller.request.UserRequestBody;
import com.test.controller.response.UserResponseBody;
import com.test.mapper.UserMapper;
import com.test.repository.UserRepository;
import com.test.service.UserService;
import com.test.service.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final UserValidator userValidator;

    @Override
    public List<UserResponseBody> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseBody)
                .toList();
    }

    @Override
    public void saveUser(UserRequestBody request) {
        if (userValidator.validateUser(request)) {
            repository.save(mapper.toEntity(request));
        } else {
            log.info("erro");
        }

    }
}
