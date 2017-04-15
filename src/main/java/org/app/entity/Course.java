package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "course_inf", schema = "selection_course_system_db", catalog = "")
public class Course implements Serializable,EntityIdentity
{
    private String courseId;

    private String courseName;

    private Byte courseTime;

    private float creditHour;

    private float credit;

    private String courseProperty;

    private String examType;

    private int finalWeek;

    private String isCompulsory;

    @Id
    @Column(name = "courseId", nullable = false, length = 45)
    public String getCourseId()
    {
        return courseId;
    }

    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "courseName", nullable = false, length = 45)
    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "courseTime")
    public Byte getCourseTime()
    {
        return courseTime;
    }

    public void setCourseTime(Byte courseTime)
    {
        this.courseTime = courseTime;
    }


    @Basic
    @Column(name = "creditHour",precision = 1)

    public float getCreditHour() {
        return creditHour;
    }
    public void setCreditHour(float creditHour) {
        this.creditHour = creditHour;
    }

    @Basic
    @Column(name="credit",precision = 1)
    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "examType", length = 45)
    public String getExamType()
    {
        return examType;
    }

    public void setExamType(String examType)
    {
        this.examType = examType;
    }

    @Basic
    @Column(name = "finalWeek")
    public int getFinalWeek()
    {
        return finalWeek;
    }

    public void setFinalWeek(int finalWeek)
    {
        this.finalWeek = finalWeek;
    }

    @Basic
    @Column(name = "courseProperty", nullable = false, length = 45)
    public String getCourseProperty()
    {
        return courseProperty;
    }

    public void setCourseProperty(String courseProperty)
    {
        this.courseProperty = courseProperty;
    }

    @Column(name = "isCompulsory", nullable = false, length = 4)

    public String isCompulsory()
    {
        return isCompulsory;
    }

    public void setCompulsory(String compulsory)
    {
        isCompulsory = compulsory;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(courseId);
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
        final Course other = (Course)obj;
        return Objects.equal(this.courseId, other.courseId);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("courseId", courseId)
                .add("courseName", courseName)
                .add("courseTime", courseTime)
                .add("creditHour", creditHour)
                .add("courseProperty", courseProperty)
                .add("examType", examType)
                .add("finalWeek", finalWeek)
                .add("isCompulsory", isCompulsory)
                .toString();
    }
}
