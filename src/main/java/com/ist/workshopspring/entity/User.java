package com.ist.workshopspring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    private Long id;
    private String username;
    private String email;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
