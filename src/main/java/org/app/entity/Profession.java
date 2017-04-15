package org.app.entity;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "profession_inf", schema = "selection_course_system_db", catalog = "")
public class Profession implements EntityIdentity
{
    private String proId;

    private String proName;

    private String proType;

    private Integer proLevel;

    private Department department;

    private Set<Student> studentSet;

    public Profession()
    {}

    @Id
    @Column(name = "proId", nullable = false, length = 45)
    public String getProId()
    {
        return proId;
    }

    public void setProId(String proId)
    {
        this.proId = proId;
    }

    @Basic
    @Column(name = "proName", nullable = false, length = 45)
    public String getProName()
    {
        return proName;
    }

    public void setProName(String proName)
    {
        this.proName = proName;
    }

    @Basic
    @Column(name = "proType", nullable = true, length = 45)
    public String getProType()
    {
        return proType;
    }

    public void setProType(String proType)
    {
        this.proType = proType;
    }

    @Basic
    @Column(name = "proLevel", nullable = true)
    public Integer getProLevel()
    {
        return proLevel;
    }

    public void setProLevel(Integer proLevel)
    {
        this.proLevel = proLevel;
    }

    @ManyToOne(targetEntity = Department.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    @ManyToMany(targetEntity = Student.class,fetch = FetchType.LAZY)
    @JoinTable(name = "student_pro_inf", joinColumns = @JoinColumn(name = "proId", referencedColumnName = "proId"), inverseJoinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"))
    public Set<Student> getStudentSet()
    {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet)
    {
        this.studentSet = studentSet;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(proId, proName, proType, proLevel, department, studentSet);
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
        final Profession other = (Profession)obj;
        return Objects.equal(this.proId, other.proId) ;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("proName", proName).toString();
    }
}
