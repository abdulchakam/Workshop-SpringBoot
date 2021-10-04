package com.ist.workshopspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_permission")
@Data
public class Permission {

    @Id
    private Long id;
    private String url;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role role;
}
