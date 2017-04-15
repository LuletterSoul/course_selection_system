package org.app.dao.repository;

import org.app.entity.Classroom;
import org.springframework.stereotype.Repository;

/**
 * @author ΑυΟιµΒ qq313700046@icloud.com .
 * @date Created in  ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Repository
public class ClassroomRepository extends BaseRepository<Classroom,Long>
{

    public ClassroomRepository()
    {
        super(Classroom.class);
    }
}
