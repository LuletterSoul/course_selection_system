package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by 31370 on 2017/4/8.
 */
@Entity
@Table(name = "adminclass_inf", schema = "selection_course_system_db", catalog = "")
public class AdministrationClass implements Serializable,EntityIdentity
{
    private String classId;

    private Integer studentNumber;

    private Set<Student> students;

    public AdministrationClass()
    {
        students = new HashSet<Student>();
    }

    @Id
    @Column(name = "classId", nullable = false, length = 30)
    public String getClassId()
    {
        return classId;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    @Basic
    @Column(name = "studentNumber")
    public Integer getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    @OneToMany(targetEntity = Student.class,mappedBy = "administrationClass",fetch = FetchType.LAZY)
    public Set<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(classId);
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
        final AdministrationClass other = (AdministrationClass)obj;
        return Objects.equal(this.classId, other.classId);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).
                add("classId", classId).
//                add("students",students).
                toString();
    }
}
