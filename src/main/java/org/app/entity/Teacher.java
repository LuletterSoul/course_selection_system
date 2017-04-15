package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "teacher_inf", schema = "selection_course_system_db", catalog = "")
public class Teacher implements EntityIdentity
{
    private String teacherId;

    private String teacherName;

    private int age;

    private String gender;

    private String duty;

    private Department department;

    private Date birthday;

    private String researchField;

    private String highestDegree;

    private String achievement;

    private Set<Address> addresses;

    private Set<CourseArrangementInfo> courses;

    public Teacher()
    {}

    @Id
    @Column(name = "teacherId", nullable = false, length = 45)
    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacherName", nullable = false, length = 45)
    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String tacherName)
    {
        this.teacherName = tacherName;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Basic
    @Column(name = "gender", nullable = false, length = 45)
    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Basic
    @Column(name = "duty", nullable = true, length = 45)
    public String getDuty()
    {
        return duty;
    }

    public void setDuty(String duty)
    {
        this.duty = duty;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    @Column(name = "researchField", length = 45)
    public String getResearchField()
    {
        return researchField;
    }

    public void setResearchField(String researchField)
    {
        this.researchField = researchField;
    }

    @Column(name = "highestDegree", length = 20)
    public String getHighestDegree()
    {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree)
    {
        this.highestDegree = highestDegree;
    }

    @Column(name = "achievement", length = 90)
    public String getAchievement()
    {
        return achievement;
    }

    public void setAchievement(String achivement)
    {
        this.achievement = achivement;
    }

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_department_inf", joinColumns = @JoinColumn(name = "teacherId", referencedColumnName = "teacherId"), inverseJoinColumns = @JoinColumn(name = "departmentId", referencedColumnName = "departmentId"))
    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    @OneToMany(targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_address_inf", joinColumns = @JoinColumn(name = "teacherId", referencedColumnName = "teacherId"), inverseJoinColumns = @JoinColumn(name = "addressId", referencedColumnName = "addressId", unique = true))

    public Set<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses)
    {
        this.addresses = addresses;
    }

    @OneToMany(targetEntity = CourseArrangementInfo.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teacher")
    public Set<CourseArrangementInfo> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<CourseArrangementInfo> courses)
    {
        this.courses = courses;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(teacherId);
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
        final Teacher other = (Teacher)obj;
        return Objects.equal(this.teacherId, other.teacherId);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("teacherId", teacherId).add("teacherName",
            teacherName).add("age", age).add("gender", gender).add("duty", duty).add("department",
                department).toString();
    }
}
