package com.epam.training.transport.model.db.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "ROUTES")
public class RouteEntity extends BaseEntity implements Comparable<RouteEntity> {

    @Column(name = "number", nullable = false, unique = true, length = 20)
    private String number;

    @Column(name = "description", length = 200)
    private String description;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RoutePointEntity> routePoints = new ArrayList<>();

    public RouteEntity() {
    }

    public RouteEntity(final long id, final String number, final String description) {
        super(id);
        this.number = number;
        this.description = description;
    }

    public RouteEntity(final String number, final String description) {
        this.number = number;
        this.description = description;
    }

    public List<RoutePointEntity> getRoutePoints() {
        routePoints.sort(Comparator.comparingInt(RoutePointEntity::getSequence));
        return routePoints;
    }

    public void setRoutePoints(final List<RoutePointEntity> routePoints) {
        this.routePoints = routePoints;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public int compareTo(@NotNull
    final RouteEntity o) {
        return this.number.toLowerCase()
            .compareTo(o.getNumber()
                .toLowerCase());
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        final RouteEntity that = (RouteEntity) o;

        if (number != null ? !number.equals(that.number) : that.number != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        return routePoints != null ? routePoints.equals(that.routePoints) : that.routePoints == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (routePoints != null ? routePoints.hashCode() : 0);
        return result;
    }
}
