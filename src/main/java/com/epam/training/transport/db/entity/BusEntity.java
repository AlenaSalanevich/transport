package com.epam.training.transport.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "BUS_ENTITY")
public class BusEntity extends BaseEntity {

    static final String BUS_PREFIX = "B ";

    @Column(name = "name", unique = true, length = 20, nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public BusEntity() {
    }

    public BusEntity(final long id, final String name, final boolean isActive) {
        super(id);
        this.name = BUS_PREFIX + name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = BUS_PREFIX + name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final boolean active) {
        isActive = active;
    }
}
