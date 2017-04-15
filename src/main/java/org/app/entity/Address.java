package org.app.entity;


import com.google.common.base.Objects;
import org.app.entity.marke.EntityIdentity;

import javax.persistence.*;


/**
 * Created by 31370 on 2017/3/26.
 */
@Entity
@Table(name = "address_inf", schema = "selection_course_system_db", catalog = "")
public class Address implements EntityIdentity
{
    private String addId;

    private String province;

    private String city;

    private String prefecture;

    private String village;

    private String house;

    public Address()
    {

    }

    @Id
    @Column(name = "addressId", nullable = false, length = 45)
    public String getAddId()
    {
        return addId;
    }

    public void setAddId(String addId)
    {
        this.addId = addId;
    }

    @Basic
    @Column(name = "province", nullable = false, length = 45)
    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Basic
    @Column(name = "prefecture", nullable = false, length = 45)
    public String getPrefecture()
    {
        return prefecture;
    }

    public void setPrefecture(String prefecture)
    {
        this.prefecture = prefecture;
    }

    @Basic
    @Column(name = "village", nullable = true, length = 45)
    public String getVillage()
    {
        return village;
    }

    public void setVillage(String village)
    {
        this.village = village;
    }

    @Basic
    @Column(name = "house", nullable = true, length = 45)
    public String getHouse()
    {
        return house;
    }

    public void setHouse(String house)
    {
        this.house = house;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(addId, province, city, prefecture, village, house);
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
        final Address other = (Address)obj;
        return Objects.equal(this.addId, other.addId)
               && Objects.equal(this.province, other.province)
               && Objects.equal(this.city, other.city)
               && Objects.equal(this.prefecture, other.prefecture)
               && Objects.equal(this.village, other.village)
               && Objects.equal(this.house, other.house);
    }

}
