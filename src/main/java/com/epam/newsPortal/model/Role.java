package com.epam.newsPortal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@NamedNativeQuery(
        name = "get_role_by_id",
        query = "SELECT * FROM news_db.public.roles WHERE id = :id"
)

@Entity
@Data
@Table(name = "roles")
public class Role {

    public Role () {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String
    toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
