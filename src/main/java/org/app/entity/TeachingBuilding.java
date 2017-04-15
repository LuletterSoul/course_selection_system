package org.app.entity;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.app.entity.marke.EntityIdentity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;


/**
 * Created by 31370 on 2017/4/7.
 */
@Entity
@Table(name = "teaching_building_inf", schema = "selection_course_system_db", catalog = "")
public class TeachingBuilding implements EntityIdentity
{
    private String buildingName;

    private String buildingLocation;

    private int storeyNumber;

    private Double coveringArea;

    private Set<Classroom> classrooms;

    @Id
    @Column(name = "buildingName", nullable = false, length = 25)
    public String getBuildingName()
    {
        return buildingName;
    }

    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }

    @Basic
    @Column(name = "buildingLocation", length = 45)
    public String getBuildingLocation()
    {
        return buildingLocation;
    }

    public void setBuildingLocation(String buildingLocation)
    {
        this.buildingLocation = buildingLocation;
    }

    @Basic
    @Column(name = "storeyNumber")
    public int getStoreyNumber()
    {
        return storeyNumber;
    }

    public void setStoreyNumber(int storeyNumber)
    {
        this.storeyNumber = storeyNumber;
    }

    @Basic
    @Column(name = "coveringArea", precision = 0)
    public Double getCoveringArea()
    {
        return coveringArea;
    }

    public void setCoveringArea(Double converingArea)
    {
        this.coveringArea = converingArea;
    }

    @OneToMany(targetEntity = Classroom.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "teachingBuilding")
//    @JoinTable(name = "building_classroom_inf", joinColumns = @JoinColumn(name = "buildingName", referencedColumnName = "buildingName"), inverseJoinColumns = @JoinColumn(name = "classroomId", referencedColumnName = "classroomId"))
    public Set<Classroom> getClassrooms()
    {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms)
    {
        this.classrooms = classrooms;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(buildingName);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        final TeachingBuilding other = (TeachingBuilding)obj;
        return Objects.equal(this.buildingName, other.buildingName);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("buildingName", buildingName).toString();
    }
}
