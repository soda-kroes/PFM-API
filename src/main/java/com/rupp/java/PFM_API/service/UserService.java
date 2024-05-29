package com.rupp.java.PFM_API.service;

import com.rupp.java.PFM_API.dto.request.UserRequest;
import com.rupp.java.PFM_API.dto.response.UserResponse;
import com.rupp.java.PFM_API.exception.AlreadyExistException;

public interface UserService {
    UserResponse createUser(UserRequest userRequest) throws Exception;
}
