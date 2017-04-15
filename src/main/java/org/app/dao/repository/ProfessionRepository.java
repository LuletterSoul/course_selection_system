package org.app.dao.repository;


import org.app.dao.model.ProfessionDAO;
import org.app.entity.Profession;
import org.springframework.stereotype.Repository;


/**
 * @author ΑυΟιµΒ qq313700046@icloud.com .
 * @date Created in ${Time} ${Date}.
 * @decreption
 * @modified By: .
 */
@Repository
public class ProfessionRepository extends BaseRepository<Profession, String> implements ProfessionDAO
{
    public ProfessionRepository()
    {
        super(Profession.class);
    }
}
