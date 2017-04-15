package org.app.service;


import org.app.entity.Teacher;
import org.app.service.ClassService;
import org.app.service.StudentService;
import org.app.service.TeacherService;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;


/**
 * TeacherService Tester.
 * 
 * @author <Authors name>
 * @since
 * 
 *        <pre>
 * ËÄÔÂ 13, 2017
 *        </pre>
 * 
 * @version 1.0
 */
public class TeacherServiceTest extends BaseServiceTest<Teacher,String>
{
    private TeacherService teacherService;

    @Before
    public void buildApplicationAndService() throws Exception
    {
        super.buildApplicationAndService();
        teacherService = (TeacherService)getContext().getBean("teacherService");
    }

    @Test
    public void testUpdateTeacherBatch() throws Exception
    {
        getUpdateMapping().put("gender","Å®");
        getConditionMapping().put("gender","feman");
        teacherService.updateEntityBatch(getUpdateMapping(),getConditionMapping());
    }

    /**
     * Method: setTeacherRepository(TeacherRepository teacherRepository)
     */
    @Test
    public void testSetTeacherRepository()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: setCourseArrangementRepository(CourseArrangementRepository
     * courseArrangementRepository)
     */
    @Test
    public void testSetCourseArrangementRepository()
        throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: setCourseRepository(CourseRepository courseRepository)
     */
    @Test
    public void testSetCourseRepository()
        throws Exception
    {
        // TODO: Test goes here...
    }

}
