package com.example.registrationlogindemo.mapper;


import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.registrationlogindemo.dto.RoleDto;
import com.example.registrationlogindemo.dto.UserDto;




@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(name, email, password) " +
            "VALUES ( CONCAT(#{firstName} ,' ', #{lastName}), #{email}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(UserDto userDto);

    @Insert({
        "<script>",
        "INSERT INTO users_roles(user_id, role_id) VALUES",
        "<foreach collection='roles' item='role' separator=','>",
        "(#{userDto.id}, #{role.id})",
        "</foreach>",
        "</script>"
    })
    void setRoles(UserDto userDto,List<RoleDto> roles);

    @Select("SELECT * FROM users")
    List<UserDto> findAll();

    @Select("SELECT * FROM users WHERE email  = #{email} ")
     UserDto findByEmail(String email);

    @Select("SELECT roles.id id,roles.name name FROM users_roles,roles WHERE roles.id =role_id AND user_id  = #{id} ")
    Collection<RoleDto> getRoles(UserDto userDto);

    // 如果有其他操作，可以继续添加注解方法
}