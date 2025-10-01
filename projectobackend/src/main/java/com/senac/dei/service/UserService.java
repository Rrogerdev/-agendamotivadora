package com.senac.dei.service;

import com.senac.dei.config.SecurityConfiguration;
import com.senac.dei.entity.Role;
import com.senac.dei.entity.Usuario;
import com.senac.dei.entity.Usuario;
import com.senac.dei.dto.CreateUserDto;
import com.senac.dei.dto.LoginUserDto;
import com.senac.dei.dto.RecoveryJwtTokenDto;
import com.senac.dei.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final UsuarioRepository userRepository;
    private final SecurityConfiguration securityConfiguration;

    public UserService(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, UsuarioRepository userRepository, SecurityConfiguration securityConfiguration) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userRepository = userRepository;
        this.securityConfiguration = securityConfiguration;
    }

    // Método responsável por autenticar um usuário e retornar um token JWT


    // Método responsável por criar um usuário

}