package org.app.dao.repository;


import org.app.dao.model.TeacherDAO;
import org.app.entity.Teacher;
import org.app.service.BaseService;
import org.springframework.stereotype.Repository;


/**
 * Created by 31370 on 2017/4/4.
 */
@Repository
public class TeacherRepository extends BaseRepository<Teacher, String> implements TeacherDAO
{
    public TeacherRepository()
    {
        super(Teacher.class);
    }
}
