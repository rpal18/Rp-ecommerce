package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RoleId;

    @NotBlank
    private AppRole roleName;

    public Role(AppRole role) {
        this.roleName = role;
    }

    public Role() {
    }
}
