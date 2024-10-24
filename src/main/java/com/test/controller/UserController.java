package com.test.controller;

import com.test.controller.request.UserRequestBody;
import com.test.controller.response.UserResponseBody;
import com.test.repository.entity.UserEntity;
import com.test.repository.UserRepository;
import com.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserResponseBody> findAll() {
        log.info("find all method called...");
        return service.findAll();
    }

    @PostMapping
    public void save(@RequestBody UserRequestBody requestBody) {
        log.info("saving user: {}", requestBody);
        service.saveUser(requestBody);
    }
}
