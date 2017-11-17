package com.epam.training.transport.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRAM_ENTITY")
public class TramEntity extends BaseEntity {

    static final String TRAM_PREFIX = "T ";

    @Column(name = "name", unique = true, length = 20, nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public TramEntity() {
    }

    public TramEntity(final long id, final String name, final boolean isActive) {
        super(id);
        this.name = TRAM_PREFIX + name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TRAM_PREFIX + name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(final boolean active) {
        isActive = active;
    }
}
