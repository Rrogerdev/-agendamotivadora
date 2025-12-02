package com.senac.dei.dto;

import com.senac.dei.entity.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}