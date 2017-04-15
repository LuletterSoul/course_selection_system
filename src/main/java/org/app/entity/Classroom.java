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
@Table(name = "classroom_inf", schema = "selection_course_system_db", catalog = "")
public class Classroom implements EntityIdentity
{

    private Long classroomId;

    private int capacity;

    private String classroomDoorId;

    private Set<CourseArrangementInfo> courses;

    private TeachingBuilding teachingBuilding;

    @Id
    @GenericGenerator(name = "pk_classroom", strategy = "identity")
    @GeneratedValue(generator = "pk_classroom")
    @Column(name = "classroomId")
    public Long getClassroomId()
    {
        return classroomId;
    }

    public void setClassroomId(Long classroomId)
    {
        this.classroomId = classroomId;
    }

    @Basic
    @Column(name = "capacity", nullable = false)
    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Column(name = "classroomDoorId", nullable = false, length = 15)
    public String getClassroomDoorId()
    {
        return classroomDoorId;
    }

    public void setClassroomDoorId(String classroomId)
    {
        this.classroomDoorId = classroomId;
    }

    @OneToMany(targetEntity = CourseArrangementInfo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "course_classroom", joinColumns = @JoinColumn(name = "classroomId", referencedColumnName = "classroomId"), inverseJoinColumns = @JoinColumn(name = "arrangementId", referencedColumnName = "arrangementId"))
    public Set<CourseArrangementInfo> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<CourseArrangementInfo> courses)
    {
        this.courses = courses;
    }

    @ManyToOne(targetEntity = TeachingBuilding.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name="building_classroom_inf",joinColumns = @JoinColumn(name = "classroomId",referencedColumnName = "classroomID",unique =true),inverseJoinColumns = @JoinColumn(name="buildingName",referencedColumnName = "buildingName"))
    public TeachingBuilding getTeachingBuilding()
    {
        return teachingBuilding;
    }

    public void setTeachingBuilding(TeachingBuilding teachingBuilding)
    {
        this.teachingBuilding = teachingBuilding;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(classroomId,classroomDoorId,teachingBuilding);
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
        final Classroom other = (Classroom)obj;
        return Objects.equal(this.classroomId, other.classroomId)
               && Objects.equal(this.teachingBuilding.getBuildingName(), other.teachingBuilding.getBuildingName());
    }


    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("teachingBuilding", teachingBuilding)
                .add("classroomDoorId", classroomDoorId)
                .toString();
    }
}
