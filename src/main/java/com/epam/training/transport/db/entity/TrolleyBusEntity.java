package com.epam.training.transport.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "TROLLEY_BUS_ENTITY")
public class TrolleyBusEntity extends BaseEntity {

    static final String TROLLEY_BUS_PREFIX = "TB ";

    @Column(name = "name", unique = true, length = 20, nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public TrolleyBusEntity() {
    }

    public TrolleyBusEntity(final long id, final String name, final boolean isActive) {
        super(id);
        this.name = TROLLEY_BUS_PREFIX + name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TROLLEY_BUS_PREFIX + name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(final boolean active) {
        isActive = active;
    }
}
