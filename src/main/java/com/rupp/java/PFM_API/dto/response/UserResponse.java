package com.rupp.java.PFM_API.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private String username;
    private String password;
    private String email;
}
