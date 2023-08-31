package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    UserDto findByEmail(String email);

    List<UserDto> findAllUsers();
}
