package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RoleId;

    @NotNull
    private AppRole roleName;

    public Role(AppRole role) {
        this.roleName = role;
    }

    public AppRole getRoleName() {
        return roleName;
    }

    public void setRoleName(AppRole roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }
}
