package com.epam.training.transport.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RoleEntity extends BaseEntity {

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
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        final RoleEntity that = (RoleEntity) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
