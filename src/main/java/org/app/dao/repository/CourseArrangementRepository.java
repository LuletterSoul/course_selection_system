package org.app.dao.repository;

import org.app.dao.model.CourseArrangementDAO;
import org.app.entity.CourseArrangementInfo;
import org.app.entity.CourseSelectionInfo;
import org.springframework.stereotype.Repository;

/**
 * @author ΑυΟιµΒ qq313700046@icloud.com .
 * @date Created in  ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Repository
public class CourseArrangementRepository extends BaseRepository<CourseArrangementInfo,Integer> implements CourseArrangementDAO
{
    public CourseArrangementRepository()
    {
        super(CourseArrangementInfo.class);
    }
}
