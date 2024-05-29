package com.rupp.java.PFM_API.controller;

import com.rupp.java.PFM_API.dto.request.UserRequest;
import com.rupp.java.PFM_API.dto.response.StatusResponse;
import com.rupp.java.PFM_API.dto.response.UserResponse;
import com.rupp.java.PFM_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponse statusResponse = new StatusResponse();
        UserResponse data = userService.createUser(userRequest);
        if (data != null) {
            statusResponse.setErrCode(200);
            statusResponse.setErrMsg("User created successfully");
            response.put("data", data);
        }else {
            statusResponse.setErrCode(204); // No Content
            statusResponse.setErrMsg("Your Content Unexceptionable!");
            response.put("data", null);
        }
        response.put("status", statusResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
