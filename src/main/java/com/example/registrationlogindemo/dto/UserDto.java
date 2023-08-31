package com.example.registrationlogindemo.dto;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    private String name;
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
 
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;


    public void setName(String name){
        if(StringUtils.isNotBlank(name)){
             String[] names = name.split(" ");
             if (names.length>1){
                firstName = names[0];
                lastName = names[1];
             }
        }
    }
}
