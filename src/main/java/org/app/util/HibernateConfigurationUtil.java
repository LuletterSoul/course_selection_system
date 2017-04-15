package org.app.util;


import java.util.Iterator;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;


/**
 * 根据实体类得到对应的表名、主键名、字段名（与Spring集成） 这里使用xml文件配置的映射，需要保证实体类名与对应映射文件名一致，即User.java与User.hbm.xml </p>
 * 这里使用继承ApplicationContextAware的方式来获得ApplicationContext,
 * 因此需要在Spring配置文件中配置一下该类，才能自动注入ApplicationContext对象 <bean
 * class="util.HibernateConfigurationUtil"/>
 */
public class HibernateConfigurationUtil
{

    private static <T> PersistentClass getPersistentClass(Class<T> clazz)
    {
        synchronized (HibernateConfigurationUtil.class)
        {

            return SpringMetaDataBuilder.getMetadata().getEntityBinding(clazz.getSimpleName());
        }
    }

    /**
     * 获得实体类对应的表名
     *
     * @param clazz
     *            实体类的Class对象
     * @return 表名
     */
    public static <T> String getTableName(Class<T> clazz)
    {
        return getPersistentClass(clazz).getTable().getName();
    }

    /**
     * 获得实体类对应表的主键字段名称
     *
     * @param clazz
     *            实体类的Class对象
     * @return 主键字段名称
     */
    public static <T> String getPKColumnName(Class<T> clazz)
    {
        return getPersistentClass(clazz).getTable().getPrimaryKey().getColumn(0).getName();
    }

    /**
     * 获得类属性对应的字段名
     *
     * @param clazz
     *            实体类的Class对象
     * @param propertyName
     *            实体类的属性名
     * @return 属性对应的字段名
     */
    public static <T> String getColumnName(Class<T> clazz, String propertyName)
    {
        String columnName = "";
        PersistentClass persistentClass = getPersistentClass(clazz);
        Property property = persistentClass.getProperty(propertyName);
        Iterator<?> iterator = property.getColumnIterator();
        if (iterator.hasNext())
        {
            Column column = (Column) iterator.next();
            return column.getName();
        }
        return columnName;
    }

    public static <T> String getAllFomattedColumnNames(Class<T> clazz)
    {
        String columnFormattedNameString="";
        ClassMetadata classMetadata=SpringMetaDataBuilder.getClassMetadata(clazz);
        String[] propertyNames = classMetadata.getPropertyNames();
        for(int i=0;i<propertyNames.length;++i)
        {
            if(i!=propertyNames.length-1)
                columnFormattedNameString+=getColumnName(clazz,propertyNames[i])+",";
            else
                columnFormattedNameString+=getColumnName(clazz,propertyNames[i]);

        }
        return columnFormattedNameString;
    }

}