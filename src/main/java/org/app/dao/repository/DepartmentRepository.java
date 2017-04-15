package org.app.dao.repository;


import org.app.dao.model.DeparmentDAO;
import org.app.entity.Department;
import org.springframework.stereotype.Repository;


/**
 * @author ΑυΟιµΒ qq313700046@icloud.com .
 * @date Created in ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Repository
public class DepartmentRepository extends BaseRepository<Department, String> implements DeparmentDAO
{
    public DepartmentRepository()
    {
        super(Department.class);
    }
}
