package com.epam.training.transport.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "ROLES")
public class RoleEntity extends BaseEntity /*implements GrantedAuthority*/ {

    @Column(name = "name", length = 10, nullable = false, unique = true)
    private String name;

    public RoleEntity() {
    }

    public RoleEntity(final long id, final String name) {
        super(id);
        this.name = name;
    }

    public RoleEntity(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleEntity{" + "name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name);
    }
}
