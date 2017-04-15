package org.app.service;

import org.app.service.TeacherService;
import org.app.util.BufferStream;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
* ClassroomService Tester. 
* 
* @author <Authors name> 
* @since <pre>ËÄÔÂ 13, 2017</pre> 
* @version 1.0 
*/ 
public class BaseServiceTest<E,PK extends Serializable>
{


    private BufferStream stream;
    private ApplicationContext context;
    private Map<String,Object> updateMapping;
    private Map<String,Object> conditionMapping;
    private Set<E> set;

    @Before
    public void buildApplicationAndService() throws Exception
    {
        context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");;
        updateMapping=  new HashMap<String,Object>();
        conditionMapping = new HashMap<String,Object>();
        set = new HashSet<E>();
        stream=new BufferStream();
    }

    public BufferStream getStream()
    {
        return stream;
    }

    protected ApplicationContext getContext()
    {
        return context;
    }

    protected Map<String, Object> getUpdateMapping() {
        return updateMapping;
    }

    protected Map<String, Object> getConditionMapping() {
        return conditionMapping;
    }

    protected Set<E> getSet()
    {
        return set;
    }

/**
* 
* Method: setClassroomRepository(ClassroomRepository classroomRepository) 
* 
*/
    @Test
    public  void testBaseService()
    {

    }
} 
