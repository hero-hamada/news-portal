package com.epam.newsPortal.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean object that represents a User.
 *
 * @author Merey
 * @version 1.0
 */

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
