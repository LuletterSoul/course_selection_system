package org.app.service;

import org.app.entity.Student;
import org.app.service.ClassService;
import org.app.service.StudentService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 
* StudentService Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 15, 2017</pre> 
* @version 1.0 
*/
/**
 * StudentService Tester.
 *
 * @author <Authors name>
 * @since
 *
 *        <pre>
 * 四月 4, 2017
 *        </pre>
 *
 * @version 1.0
 */
public class StudentServiceTest extends BaseServiceTest<Student,String>
{

    private StudentService studentService;

    private ClassService classService;


    @Before
    public void buildApplicationAndService() throws Exception
    {
        super.buildApplicationAndService();
        studentService = (StudentService)getContext().getBean("studentService");
        classService = (ClassService)getContext().getBean("classService");
    }

    /**
     * Method: getStudentRepository()
     */
    @Test
    public void testGetStudentRepository()
            throws Exception
    {
        // TODO: Test goes here...
    }

    /**
     * Method: setStudentRepository(StudentRepository studentRepository)
     */
    @Test
    public void testSetStudentRepository()
            throws Exception
    {
        // TODO: Test goes here...
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void testGetStudentById()
            throws Exception
    {
        String studentId = "915106840327";
        Student student = studentService.findById(studentId);
        System.out.println(student);
    }

    @Test
    public void testUpdateStudentInfo()
            throws Exception
    {

        String studentId = "915106840327";

        Student student = studentService.findById(studentId);

        System.out.println(student);

        if (student.getEnrolTime() == null)
        {
            System.out.println("student enrolment time :" + student.getEnrolTime());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            student.setEnrolTime(timestamp);
            System.out.println("student enrolment time :" + student.getEnrolTime());
        }
        // studentService.getOperableSession().getTransaction().commit();

        // System.out.println("student enrolment time :" + student.getEnrolTime());
    }

    /**
     * Method: saveStudentInfo(Student student)
     */
    @Test
    public void testSaveStudentInfo()
            throws Exception
    {
        // AdministrationClass adminClass=new AdministrationClass();
        Student student = new Student();
        // adminClass.setClassId("9151068403");
        // classService.save(adminClass);
        student.setStudentName("刘祥德");
        student.setGender("男");
        student.setStudentId("915106840327");
        student.setStudentAge(22);
        student.setGrade("大二");
        student.setAdministrationClass(classService.findById("9151065501"));
        // adminClass.getStudents().add(student);
        studentService.save(student);
    }

    @Test
    public void testCancelStudentInfo()
            throws Exception
    {
        String studentId = "915106840327";
        studentService.deleteByProperty("studentId", studentId);
    }

    @Test
    public void testGetAllStudentName()
            throws Exception
    {
        studentService.getAllStudentNames();
    }

    @Test
    public void testGetStudentByName()
            throws Exception
    {
        String studentName = "刘祥德";
        studentService.getStudentByName(studentName);
        // System.out.println(HibernateConfigurationUtil.getAllFomattedColumnNames(Student.class));
    }

    @Test
    public void testSaveStudentBatch()
            throws Exception
    {
        System.out.println("Enter student information:");
    }

    @Test
    public void testUpdateStudentBatchClass()
            throws Exception
    {
        Map<String, Object> restricitionMapping = new HashMap<String, Object>();
        restricitionMapping.put("grade", null);
        Map<String ,Object> updateMapping = new HashMap<String,Object>();
        updateMapping.put("administrationClass",classService.findById("9151062302"));
        int result = studentService.updateEntityBatch(updateMapping,restricitionMapping);
        System.out.println(result);
    }

    @Test
    public void testUpdateStudentBatchGrade()
            throws Exception
    {
        Map<String, Object> restricitionMapping = new HashMap<String, Object>();
        restricitionMapping.put("grade", null);
        Map<String ,Object> updateMapping = new HashMap<String,Object>();
        updateMapping.put("grade","大二");
        int result = studentService.updateEntityBatch(updateMapping,restricitionMapping);
        System.out.println(result);
    }

    @Test
    public void testUpdateStudentBatchEnrollmentTime()
            throws Exception
    {
        Date enrollmentTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "2015-09-01";
        enrollmentTime = simpleDateFormat.parse(date);
        Map<String, Object> restrictionMapping = new HashMap<String, Object>();
        restrictionMapping.put("enrollmentTime", null);
        Map<String, Object> updateMapping = new HashMap<String, Object>();
        updateMapping.put("enrollmentTime", enrollmentTime);
        int result = studentService.updateEntityBatch(updateMapping, restrictionMapping);
        System.out.println(result);
    }
}