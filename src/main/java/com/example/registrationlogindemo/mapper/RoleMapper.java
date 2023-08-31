package com.example.registrationlogindemo.mapper;


import org.apache.ibatis.annotations.*;

import com.example.registrationlogindemo.dto.RoleDto;


@Mapper
public interface RoleMapper {

    @Insert("INSERT INTO roles(id, name) " +
            "VALUES (#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertRole(RoleDto roleDto);

    @Select("SELECT id, name FROM roles WHERE name = #{name} " )
    RoleDto findByName(String name);

}