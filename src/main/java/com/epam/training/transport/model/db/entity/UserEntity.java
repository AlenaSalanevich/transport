package com.epam.training.transport.model.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity {

    @Column(name = "login", unique = true, length = 15, nullable = false)
    private String login;

    @Column(name = "password", length = 10, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    public UserEntity() {
    }

    public UserEntity(final long id, final String login, final String password, final RoleEntity role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(final RoleEntity role) {
        this.role = role;
    }
}