package org.app.entity;


import com.google.common.base.Objects;
import org.app.entity.marke.EntityIdentity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Created by 31370 on 2017/4/8.
 */
@Entity
@Table(name = "schedule_inf", schema = "selection_course_system_db", catalog = "")
public class Schedule implements EntityIdentity
{
    private Long timeId;

//    private Integer term;

    private Integer timeNode;

    private Integer week;

    private Integer workday;

//    private int year;

    @Id
    @GenericGenerator(name = "pk_time", strategy = "identity")
    @GeneratedValue(generator = "pk_time")
    @Column(name = "timeId")
    public Long getTimeId()
    {
        return timeId;
    }

    public void setTimeId(Long timeId)
    {
        this.timeId = timeId;
    }

//    @Basic
//    @Column(name = "term", nullable = true)
//    public Integer getTerm()
//    {
//        return term;
//    }
//
//    public void setTerm(Integer term)
//    {
//        this.term = term;
//    }

    @Basic
    @Column(name = "timeNode", nullable = true)
    public Integer getTimeNode()
    {
        return timeNode;
    }

    public void setTimeNode(Integer timeNode)
    {
        this.timeNode = timeNode;
    }

    @Basic
    @Column(name = "week", nullable = true)
    public Integer getWeek()
    {
        return week;
    }

    public void setWeek(Integer week)
    {
        this.week = week;
    }

    @Basic
    @Column(name = "workday", nullable = true)
    public Integer getWorkday()
    {
        return workday;
    }

    public void setWorkday(Integer workday)
    {
        this.workday = workday;
    }
//
//    @Basic
//    @Column(name = "year", nullable = false)
//    public int getYear()
//    {
//        return year;
//    }
//
//    public void setYear(int year)
//    {
//        this.year = year;
//    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(timeId);
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
        final Schedule other = (Schedule)obj;
        return Objects.equal(this.timeId, other.timeId);
    }
}
