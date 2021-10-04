package com.ist.workshopspring.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tbl_role")
@Data
public class Role {

    @Id
    private Long id;
    private String roleName;
    private String permissionDesc;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissions;
}
