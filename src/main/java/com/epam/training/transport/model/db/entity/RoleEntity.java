package com.epam.training.transport.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "ROLES")
public class RoleEntity extends BaseEntity {

    @Column (name = "role", length = 10, nullable = false, unique = true)
    private String role;

    public RoleEntity() {
           }


    public RoleEntity(long id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "role='" + role + '\'' +
                '}';
    }
}
