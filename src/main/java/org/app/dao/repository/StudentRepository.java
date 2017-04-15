package org.app.dao.repository;


import org.app.dao.model.StudentDAO;
import org.app.entity.AdministrationClass;
import org.app.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class StudentRepository extends BaseRepository<Student,String> implements StudentDAO
{
    public StudentRepository()
    {
        super(Student.class);
    }
    public List getStudentAllName()
    {
        String hqlString = "select distinct s.studentName " + "from Student as s";
        return super.getSession().createQuery(hqlString).list();
    }

    public int updateStudentBatch(Map<String,Object> conditionMapping,Map<String,Object> updateMapping)
    {

        return updateBatchByHql(updateMapping,conditionMapping);
    }
}
