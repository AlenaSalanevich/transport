package com.epam.training.transport.model.db.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "POINTS")
public class PointEntity extends BaseEntity implements Comparable<PointEntity> {

    @Column(name = "name", unique = true, length = 100, nullable = false)
    private String name;

    public PointEntity() {
    }

    public PointEntity(final long id, final String name) {
        super(id);
        this.name = name;
    }

    public PointEntity(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        final PointEntity that = (PointEntity) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(@NotNull
    final PointEntity o) {
        return this.getName()
            .toLowerCase()
            .compareTo(o.getName()
                .toLowerCase());
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
