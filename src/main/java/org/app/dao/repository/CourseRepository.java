package org.app.dao.repository;

import org.app.dao.model.CourseDAO;
import org.app.entity.Course;
import org.springframework.stereotype.Repository;

/**
 * Created by 31370 on 2017/4/9.
 */
@Repository
public class CourseRepository extends BaseRepository<Course,String> implements CourseDAO
{
    public CourseRepository()
    {
        super(Course.class);
    }
}
