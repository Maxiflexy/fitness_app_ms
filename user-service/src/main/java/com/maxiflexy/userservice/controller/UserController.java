package com.maxiflexy.userservice.controller;

import com.maxiflexy.userservice.dto.request.RegisterRequestDTO;
import com.maxiflexy.userservice.dto.response.UserResponseDTO;
import com.maxiflexy.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserProfile(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @GetMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody RegisterRequestDTO registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }
}