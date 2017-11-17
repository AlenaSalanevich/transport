package com.epam.training.transport.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAY_BILL_ENTITY")
public class WayBillEntity extends BaseEntity {

    @Column(name = "name", unique = true, length = 50, nullable = false)
    private String name;

    @Column(name = "interval")
    private long interval;

    @Column(name = "description")
    private String description;

    public WayBillEntity() {
    }


    public WayBillEntity(final long id, final String name, final long interval, final String description) {
        super(id);
        this.name = name;
        this.interval = interval;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(final long interval) {
        this.interval = interval;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}




