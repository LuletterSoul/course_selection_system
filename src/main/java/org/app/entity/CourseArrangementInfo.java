package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by 31370 on 2017/4/7.
 */
@Entity
@Table(name = "teacher_course", schema = "selection_course_system_db", catalog = "")
public class CourseArrangementInfo
{
    private Long arrangementId;

    private Teacher teacher;

    private Course course;

    private Integer courseOrder;

    private Set<Schedule> schedules;

    @Id
    @GenericGenerator(name = "pk_course_arrangement", strategy = "identity")
    @GeneratedValue(generator = "pk_course_arrangement")
    @Column(name = "arrangementId")
    public Long getArrangementId()
    {
        return arrangementId;
    }

    public void setArrangementId(Long logicId)
    {
        this.arrangementId = logicId;
    }

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherID", unique = true)
    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    @Column(name = "courseOrder", nullable = false)
    public Integer getCourseOrder()
    {
        return courseOrder;
    }

    public void setCourseOrder(Integer courseOrder)
    {
        this.courseOrder = courseOrder;
    }

    @OneToMany(targetEntity = Schedule.class, cascade = CascadeType.ALL)
    @JoinTable(name = "course_schedule", joinColumns = @JoinColumn(name = "arrangementId", referencedColumnName = "arrangementId"), inverseJoinColumns = @JoinColumn(name = "timeId", referencedColumnName = "timeId"))
    public Set<Schedule> getSchedules()
    {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules)
    {
        this.schedules = schedules;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(arrangementId, teacher, course);
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
        final CourseArrangementInfo other = (CourseArrangementInfo)obj;
        return Objects.equal(this.arrangementId, other.arrangementId)
               && Objects.equal(this.teacher.getTeacherId(), other.teacher.getTeacherId())
               && Objects.equal(this.course.getCourseId(), other.course.getCourseId());
    }


    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("arrangementId", arrangementId)
                .add("teacher", teacher)
                .add("course", course)
                .add("courseOrder", courseOrder)
                .add("schedules", schedules)
                .toString();
    }
}
