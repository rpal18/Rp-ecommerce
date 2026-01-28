package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user"  , uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Size(min = 2 , max = 20 , message = "Invalid length of user Name ")
    @NotBlank
    @Column(name = "username")
    private String name;

    @Email
    @NotBlank(message = " please enter email !!")
    @Column(name = "email")
    private String email;

    @NotBlank
    private String mobileNumber ;
    // since user can have multiple roles
    // so here , many-to-many relationship will be made
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable( name = "user_role" , joinColumns = @JoinColumn(name = "user_id")
     , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private  Set<Role> userRole = new HashSet<>() ;

    @NotBlank
    @NotNull
    @Size(min = 6 , max = 30 , message = " password must have at least 6 character")
    private String password ;

    // defining seller side of the things
    @OneToMany(cascade = {CascadeType.MERGE  , CascadeType.PERSIST}  ,
    orphanRemoval = true)
    private Set<Product> products ;

    public Set<Role> getRoles() {
        return userRole;
    }
    public User() {
    }

    public User(String name, String email, String mobileNumber, Set<Role> userRole, String password) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<Role> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
