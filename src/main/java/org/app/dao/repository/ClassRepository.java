package org.app.dao.repository;


import org.app.dao.model.ClassDAO;
import org.app.entity.AdministrationClass;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ClassRepository extends BaseRepository<AdministrationClass,String> implements ClassDAO
{

    public ClassRepository()
    {
        super(AdministrationClass.class);
    }

    public List getAllStudentsInChargeById(String classId)
    {
        return super.findByProperty(null,"students",classId,null);
    }

    public int getClassStudentNumber(String classId)
    {
        return getAllStudentsInChargeById(classId).size();
    }
}
