package org.app.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory
{
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";

    private static final ThreadLocal threadLocal = new ThreadLocal();

    private static final Configuration cfg = new Configuration();

    private static org.hibernate.SessionFactory sessionFactory;

    public static Session currentSession()
        throws HibernateException
    {
        Session session = (Session)threadLocal.get();

        if (session == null)
        {
            if (sessionFactory == null)
            {
                try
                {
                    cfg.configure(CONFIG_FILE_LOCATION);
                    sessionFactory = cfg.buildSessionFactory();
                    session=sessionFactory.getCurrentSession();
                }
                catch (Exception e)
                {
                    System.err.println("Error Creating CurrentSession.");
                    e.printStackTrace();
                }
            }
        }
        return session;
    }

    public static SessionFactory buildSessionFactory()
    {
        if (sessionFactory == null)
        {
            cfg.configure(CONFIG_FILE_LOCATION);
            sessionFactory = cfg.buildSessionFactory();
            return sessionFactory;
        }
        return sessionFactory;
    }

    public static void closeSession()
        throws HibernateException
    {
        Session session = (Session)threadLocal.get();
        threadLocal.set(null);
        if (session != null)
        {
            session.close();
        }

    }

    private HibernateSessionFactory()
    {

    }
}
