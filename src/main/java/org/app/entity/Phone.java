package org.app.entity;


import com.google.common.base.Objects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "phone_inf", schema = "selection_course_system_db", catalog = "")
public class Phone implements EntityIdentity
{
    private Integer number;

    private String belong;

    private Integer areaCode;

    private String teleOperator;

    public Phone()
    {}

    @Id
    @Column(name = "number", nullable = false)
    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Basic
    @Column(name = "belong", nullable = false, length = 45)
    public String getBelong()
    {
        return belong;
    }

    public void setBelong(String belong)
    {
        this.belong = belong;
    }

    @Basic
    @Column(name = "areaCode", nullable = true)
    public Integer getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode)
    {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "teleOperator", nullable = false, length = 45)
    public String getTeleOperator()
    {
        return teleOperator;
    }

    public void setTeleOperator(String teleOperator)
    {
        this.teleOperator = teleOperator;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(number);
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
        final Phone other = (Phone)obj;
        return Objects.equal(this.number, other.number) ;
    }
}
