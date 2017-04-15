package org.app.entity;


import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.app.entity.marke.EntityIdentity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Created by 31370 on 2017/4/7.
 */
@Entity
@Table(name = "student_course", schema = "selection_course_system_db", catalog = "")
public class CourseSelectionInfo implements EntityIdentity

{
    private int selectionId;

    private Student student;

    private Course course;

    private Double score;

    @Id
    @GenericGenerator(name = "pk_course_selection", strategy = "identity")
    @GeneratedValue(generator = "pk_course_selection")
    @Column(name = "selectionId")
    public int getSelectionId()
    {
        return selectionId;
    }

    public void setSelectionId(int logicId)
    {
        this.selectionId = logicId;
    }

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
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

    @Column(name = "score", precision = 4)
    public Double getScore()
    {
        return score;
    }

    public void setScore(Double score)
    {
        this.score = score;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(selectionId, student, course, score);
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
        final CourseSelectionInfo other = (CourseSelectionInfo)obj;
        return Objects.equal(this.selectionId, other.selectionId)
               && Objects.equal(this.student.getStudentId(), other.student.getStudentId())
               && Objects.equal(this.course.getCourseId(), other.course.getCourseId());
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("selectionId", selectionId)
                .add("student", student)
                .add("course", course)
                .add("score", score)
                .toString();
    }
}
