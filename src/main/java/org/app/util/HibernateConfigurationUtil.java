package org.app.util;


import java.util.Iterator;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;


/**
 * ����ʵ����õ���Ӧ�ı��������������ֶ�������Spring���ɣ� ����ʹ��xml�ļ����õ�ӳ�䣬��Ҫ��֤ʵ���������Ӧӳ���ļ���һ�£���User.java��User.hbm.xml </p>
 * ����ʹ�ü̳�ApplicationContextAware�ķ�ʽ�����ApplicationContext,
 * �����Ҫ��Spring�����ļ�������һ�¸��࣬�����Զ�ע��ApplicationContext���� <bean
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
     * ���ʵ�����Ӧ�ı���
     *
     * @param clazz
     *            ʵ�����Class����
     * @return ����
     */
    public static <T> String getTableName(Class<T> clazz)
    {
        return getPersistentClass(clazz).getTable().getName();
    }

    /**
     * ���ʵ�����Ӧ��������ֶ�����
     *
     * @param clazz
     *            ʵ�����Class����
     * @return �����ֶ�����
     */
    public static <T> String getPKColumnName(Class<T> clazz)
    {
        return getPersistentClass(clazz).getTable().getPrimaryKey().getColumn(0).getName();
    }

    /**
     * ��������Զ�Ӧ���ֶ���
     *
     * @param clazz
     *            ʵ�����Class����
     * @param propertyName
     *            ʵ�����������
     * @return ���Զ�Ӧ���ֶ���
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