package com.senac.dei.service;


import com.senac.dei.entity.Usuario;
import com.senac.dei.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private Usuario user; // Classe de usuário que criamos anteriormente

    public UserDetailsImpl(Usuario user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
         Este método converte a lista de papéis (roles) associados ao usuário
         em uma coleção de GrantedAuthorities, que é a forma que o Spring Security
         usa para representar papéis. Isso é feito mapeando cada papel para um
         novo SimpleGrantedAuthority, que é uma implementação simples de
         GrantedAuthority
        */
        return user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_name().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getUsuario_senha();
    } // Retorna a credencial do usuário que criamos anteriormente

    @Override
    public String getUsername() {
        return user.getUsuario_email();
    } // Retorna o nome de usuário do usuário que criamos anteriormente



    public int getId(){
        return user.getUsuario_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}