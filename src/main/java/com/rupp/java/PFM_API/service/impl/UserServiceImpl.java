package com.rupp.java.PFM_API.service.impl;

import com.rupp.java.PFM_API.dto.request.UserRequest;
import com.rupp.java.PFM_API.dto.response.UserResponse;
import com.rupp.java.PFM_API.entity.User;
import com.rupp.java.PFM_API.exception.AlreadyExistException;
import com.rupp.java.PFM_API.repository.UserRepository;
import com.rupp.java.PFM_API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) throws Exception {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        //check exists in db
        boolean find = userRepository.existsByUsername(userRequest.getUsername());
        if (find) {
            throw new AlreadyExistException("Username not available.");
        }
        try {
            User saveUser = userRepository.save(user);

            //prepare response
            UserResponse userResponse = new UserResponse();
            userResponse.setUsername(saveUser.getUsername());
            userResponse.setPassword(saveUser.getPassword());
            userResponse.setEmail(saveUser.getEmail());
            return userResponse;
        }catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
