package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "department_inf", schema = "selection_course_system_db", catalog = "")
public class Department implements EntityIdentity
{
    private String departmentID;

    private String departmentName;

    private Timestamp setTime;

    private Set<Profession> professions;

    private Set<Student> students;

    private Set<Teacher> teachers;

    public Department()
    {}

    @Id
    @Column(name = "departmentId", nullable = false, length = 45)
    public String getDepartmentID()
    {
        return departmentID;
    }

    public void setDepartmentID(String depId)
    {
        this.departmentID = depId;
    }

    @Basic
    @Column(name = "departmentName", nullable = false, length = 45)
    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String depName)
    {
        this.departmentName = depName;
    }

    @Basic
    @Column(name = "settledTime", nullable = true)
    public Timestamp getSetTime()
    {
        return setTime;
    }

    public void setSetTime(Timestamp setTime)
    {
        this.setTime = setTime;
    }

    @OneToMany(targetEntity = Profession.class, mappedBy = "department",fetch = FetchType.LAZY)
    public Set<Profession> getProfessions()
    {
        return professions;
    }

    public void setProfessions(Set<Profession> professions)
    {
        this.professions = professions;
    }

    @OneToMany(targetEntity = Student.class, mappedBy = "department",fetch = FetchType.LAZY)
    public Set<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }

    @OneToMany(targetEntity = Teacher.class, mappedBy = "department",fetch = FetchType.LAZY)

    public Set<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers)
    {
        this.teachers = teachers;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(departmentID, departmentName, setTime, professions, students,
            teachers);
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
        final Department other = (Department)obj;
        return Objects.equal(this.departmentID, other.departmentID);
    }


    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("departmentName", departmentName)
                .toString();
    }
}
