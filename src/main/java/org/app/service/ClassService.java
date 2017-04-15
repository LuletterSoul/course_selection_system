package org.app.service;

import org.app.dao.repository.ClassRepository;
import org.app.entity.AdministrationClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 31370 on 2017/4/9.
 */
@Service
public class ClassService extends BaseService<AdministrationClass,String>
{
    @Autowired
    public void setClassRepository(ClassRepository classRepository)
    {
        setBaseRepository(classRepository);
    }
}
