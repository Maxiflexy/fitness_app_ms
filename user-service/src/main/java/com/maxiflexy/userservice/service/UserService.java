package com.maxiflexy.userservice.service;

import com.maxiflexy.userservice.dto.request.RegisterRequestDTO;
import com.maxiflexy.userservice.dto.response.UserResponseDTO;
import jakarta.validation.Valid;

public interface UserService {
    UserResponseDTO getUserProfile(String userId);

    UserResponseDTO register(@Valid RegisterRequestDTO registerRequest);
    Boolean existsByUserId(String userId);
}
