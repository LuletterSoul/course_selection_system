package org.app.service;


import org.app.dao.repository.CourseArrangementRepository;
import org.app.dao.repository.CourseRepository;
import org.app.dao.repository.CourseSelectionRepository;
import org.app.dao.repository.TeacherRepository;

import org.app.entity.Teacher;
import org.app.service.model.BaseServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author ÁõÏéµÂ qq313700046@icloud.com .
 * @date Created in ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Service
public class TeacherService extends BaseService<Teacher, String>
{
    private TeacherRepository teacherRepository;

    private CourseArrangementRepository courseArrangementRepository;

    private CourseRepository courseRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository)
    {
        super.setBaseRepository(teacherRepository);
    }

    @Autowired
    public void setCourseArrangementRepository(CourseArrangementRepository courseArrangementRepository)
    {
        this.courseArrangementRepository = courseArrangementRepository;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }
}
