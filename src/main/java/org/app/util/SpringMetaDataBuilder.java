package org.app.util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * Created by 31370 on 2017/4/6.
 */
public class SpringMetaDataBuilder implements ApplicationContextAware
{
    private static ApplicationContext applicationContext;

    public  void setApplicationContext(ApplicationContext context) throws BeansException
    {
        applicationContext=context;
    }

    public static  LocalSessionFactoryBean getLocalSessionFactoryBean()
    {
        return (LocalSessionFactoryBean)applicationContext.getBean("&sessionFactory");
    }

    public static SessionFactory getSessionFactory(){
        return (SessionFactory)applicationContext.getBean("sessionFactory");
    }

    public static Metadata getMetadata()
    {
        return getLocalSessionFactoryBean().getMetadataSources().buildMetadata();
    }

    public static <T> ClassMetadata getClassMetadata(Class<T> clazz)
    {
        return getSessionFactory().getClassMetadata(clazz);
    }
}
