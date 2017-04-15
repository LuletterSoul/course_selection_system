package org.app.service;


import org.app.dao.repository.*;
import org.app.entity.AdministrationClass;
import org.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 31370 on 2017/4/4.
 */
@Service
public class StudentService extends BaseService<Student, String>
{

    private ClassRepository classRepository;

    private CourseSelectionRepository coureSelectionInfo;

    private CourseRepository courseRepository;

    private DepartmentRepository departmentRepository;

    private ProfessionRepository professionRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository)
    {
        super.setBaseRepository(studentRepository);
    }

    @Autowired
    public void setClassRepository(ClassRepository classRepository)
    {
        this.classRepository = classRepository;
    }

    @Autowired
    public void setCourseSelectionInfo(CourseSelectionRepository courseSelectionInfo)
    {
        this.coureSelectionInfo = courseSelectionInfo;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
    }

    @Autowired
    public void setProfessionRepository(ProfessionRepository professionRepository)
    {
        this.professionRepository = professionRepository;
    }

    public void getAllStudentNames()
    {
        List studentNameBatch = ((StudentRepository)baseRepository).getStudentAllName();
        for (Object name : studentNameBatch)
        {
            System.out.println((String)name);
        }
    }

    public void getStudentByName(String studentName)
    {
        String columnNames = "studentId,studentName";
        List studentBatch = baseRepository.findByProperty(columnNames, "studentName", studentName,
            null);
        for (Object student : studentBatch)
        {
            Object[] s = (Object[])student;
            System.out.println(s[0] + ":" + s[1]);
        }
    }
}
