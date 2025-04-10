package com.maxiflexy.userservice.service;

import com.maxiflexy.userservice.dto.request.RegisterRequestDTO;
import com.maxiflexy.userservice.dto.response.UserResponseDTO;
import com.maxiflexy.userservice.model.User;
import com.maxiflexy.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO register(RegisterRequestDTO registerRequest) {

        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());

        var savedUser = userRepository.save(user);
        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }

    @Override
    public Boolean existsByUserId(String userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public UserResponseDTO getUserProfile(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow( () -> new RuntimeException("User not found"));

        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }
}
