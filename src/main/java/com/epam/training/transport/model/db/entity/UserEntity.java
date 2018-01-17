package com.epam.training.transport.model.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity {

    @Column(name = "login", unique = true, length = 15, nullable = false)
    private String login;

    @Column(name = "password", length = 10, nullable = false)
    private String password;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private RoleEntity role;

    public UserEntity() {
    }

    public UserEntity(final long id, final String login, final String password, final RoleEntity role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserEntity(final String login, final String password, final RoleEntity role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
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
