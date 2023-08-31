package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.dto.RoleDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.mapper.RoleMapper;
import com.example.registrationlogindemo.mapper.UserMapper;
import com.example.registrationlogindemo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserMapper usermapper;
    private RoleMapper rolemapper;
    private PasswordEncoder passwordEncoder;

    
    public UserServiceImpl(UserMapper usermapper,
                           RoleMapper rolemapper,
                           PasswordEncoder passwordEncoder) {
        this.usermapper = usermapper;
        this.rolemapper = rolemapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        RoleDto role = rolemapper.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        usermapper.insertUser(userDto);
        userDto = usermapper.findByEmail(userDto.getEmail());
        usermapper.setRoles(userDto,Arrays.asList(role));
        
    }

    @Override
    public UserDto findByEmail(String email) {
        return usermapper.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> users = usermapper.findAll();
        return users;
    }

    

    private RoleDto checkRoleExist() {
        RoleDto role = new RoleDto();
        role.setName("ROLE_ADMIN");
        rolemapper.insertRole(role);
        return rolemapper.findByName("ROLE_ADMIN");
    }
}
