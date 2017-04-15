package org.app.service;


import org.app.entity.AdministrationClass;
import org.app.service.ClassService;
import org.app.service.StudentService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ClassService Tester.
 * 
 * @author <Authors name>
 * @since
 * 
 *        <pre>
 * ËÄÔÂ 11, 2017
 *        </pre>
 * 
 * @version 1.0
 */
public class ClassServiceTest
{
    StudentService studentService;

    ClassService classService;

    ApplicationContext context;

    @Before
    public void before()
        throws Exception
    {}

    @After
    public void after()
        throws Exception
    {}

    public ClassServiceTest()
    {

        init();
    }

    private  void init()
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService=(StudentService)context.getBean("studentService");
        classService=(ClassService)context.getBean("classService");
    }

    /**
     * Method: setClassRepository(ClassRepository classRepository)
     */
    @Test
    public void testSetClassRepository()
        throws Exception
    {
        // TODO: Test goes here...
    }

    @Test
    public void testDeleteClass() throws Exception
    {
        AdministrationClass administrationClass=classService.findById("9151068403");

        System.out.println(administrationClass);

        classService.deleteByProperty("classId","9151068403");
//        classService.getOperableSession().getTransaction().commit();

    }

}
