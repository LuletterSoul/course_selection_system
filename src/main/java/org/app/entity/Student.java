package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "student_inf", schema = "selection_course_system_db", catalog = "")
public class Student implements EntityIdentity
{
    private String studentId;

    private String studentName;

    private Integer studentAge;

    private String gender;

    private String grade;

    private String stuHometown;

    private Date enrolTime;

    private Phone phone;

    private Department department;

    private Set<Profession> professionSet;

    private AdministrationClass administrationClass;

    private Set<CourseSelectionInfo> courses;

    public Student()
    {}

    public Student(String studentId, String studentName, Integer studentAge, String gender,
                   String grade, Department department, Set<Profession> professionSet,
                   AdministrationClass administrationClass)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.gender = gender;
        this.grade = grade;
        this.department = department;
        this.professionSet = professionSet;
        this.administrationClass = administrationClass;
    }

    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinTable(name = "student_address_inf", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId", unique = true), inverseJoinColumns = @JoinColumn(name = "addressId", referencedColumnName = "addressId"))
    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    private Address address;
////
////    @OneToOne(targetEntity = Phone.class)
////    @JoinColumn(name = "phone", referencedColumnName = "number", unique = true)
//    public Phone getPhone()
//    {
//        return phone;
//    }
//
//    public void setPhone(Phone phone)
//    {
//        this.phone = phone;
//    }

    @Id
    @Column(name = "studentId", nullable = false, length = 45)
    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "studentName", nullable = false, length = 45)
    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "studentAge", nullable = true)
    public Integer getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge)
    {
        this.studentAge = studentAge;
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
    @Column(name = "grade", nullable = false, length = 45)
    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    @Basic
    @Column(name = "hometown", nullable = true, length = 45)
    public String getStuHometown()
    {
        return stuHometown;
    }

    public void setStuHometown(String stuHometown)
    {
        this.stuHometown = stuHometown;
    }

    @Basic
    @Column(name = "enrollmentTime")
    public Date getEnrolTime()
    {
        return enrolTime;
    }

    public void setEnrolTime(Date enrolTime)
    {
        this.enrolTime = enrolTime;
    }

    @ManyToOne(targetEntity = Department.class,fetch = FetchType.LAZY)
    @JoinTable(name = "student_department_inf", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId", unique = true), inverseJoinColumns = @JoinColumn(name = "departmentId", referencedColumnName = "departmentId"))
    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    @ManyToMany(targetEntity = Profession.class)
    @JoinTable(name = "student_pro_inf", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"), inverseJoinColumns = @JoinColumn(name = "proId", referencedColumnName = "proId"))
    public Set<Profession> getProfessionSet()
    {
        return professionSet;
    }

    public void setProfessionSet(Set<Profession> professionSet)
    {
        this.professionSet = professionSet;
    }

    @ManyToOne(targetEntity = AdministrationClass.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "student_class_inf", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"), inverseJoinColumns = @JoinColumn(name = "classId", referencedColumnName = "classId"))
    public AdministrationClass getAdministrationClass()
    {
        return administrationClass;
    }

    public void setAdministrationClass(AdministrationClass administrationClass)
    {
        this.administrationClass = administrationClass;
    }

    @OneToMany(targetEntity = CourseSelectionInfo.class, mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<CourseSelectionInfo> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<CourseSelectionInfo> courses)
    {
        this.courses = courses;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(studentId);
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
        final Student other = (Student)obj;
        return Objects.equal(this.studentId, other.studentId);
    }


    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("studentId", studentId)
                .add("studentName", studentName)
                .add("studentAge", studentAge)
                .add("gender", gender)
                .add("grade", grade)
                .add("stuHometown", stuHometown)
                .add("enrolTime", enrolTime)
                .add("phone", phone)
                .add("department", department)
                .add("professions",professionSet)
                .add("administrationClass", administrationClass)
                .add("address", address)
                .toString();
    }

}
