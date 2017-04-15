package org.app.dao.repository;

import org.app.dao.model.CourseSelectioInfoDAO;
import org.app.entity.CourseSelectionInfo;
import org.springframework.stereotype.Repository;

/**
 * @author ΑυΟιµΒ qq313700046@icloud.com .
 * @date Created in  ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Repository
public class CourseSelectionRepository extends BaseRepository<CourseSelectionInfo,Integer> implements CourseSelectioInfoDAO
{
    public CourseSelectionRepository()
    {
        super(CourseSelectionInfo.class);
    }
}
