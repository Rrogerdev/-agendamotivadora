package com.senac.dei.entity;

import jakarta.persistence.*;

@Entity
@Table(name="role")

public class Role {
    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public RoleName getRole_name() {
        return role_name;
    }

    public void setRole_name(RoleName role_name) {
        this.role_name = role_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long role_id;

    @Enumerated(EnumType.STRING)
    @Column(name="role_name")
    private RoleName role_name;

}