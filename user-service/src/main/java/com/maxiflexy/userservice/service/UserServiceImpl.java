package com.maxiflexy.userservice.service;

import com.maxiflexy.userservice.dto.request.RegisterRequestDTO;
import com.maxiflexy.userservice.dto.response.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{



    @Override
    public UserResponseDTO getUserProfile(String userId) {

    }

    @Override
    public UserResponseDTO register(RegisterRequestDTO registerRequest) {
        return null;
    }
}
