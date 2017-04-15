package org.app.service;

import org.app.dao.repository.ClassRepository;
import org.app.dao.repository.ClassroomRepository;
import org.app.entity.Classroom;
import org.app.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ΑυΟιµΒ qq313700046@icloud.com .
 * @date Created in  ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Service
public class ClassroomService extends BaseService<Classroom,Long>
{


    @Autowired
    public void setClassroomRepository(ClassroomRepository classroomRepository)
    {
        super.setBaseRepository(classroomRepository);
    }

}
