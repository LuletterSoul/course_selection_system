package org.app.service;


import org.app.dao.repository.BaseRepository;
import org.app.service.model.BaseServiceModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by 31370 on 2017/4/8.
 */
@Service
public class BaseService<E, PK extends Serializable> implements BaseServiceModel<E, PK>
{
    protected BaseRepository<E, PK> baseRepository;

    public Session getOperableSession()
    {

        return baseRepository.getSession();
    }

    public void setBaseRepository(BaseRepository<E, PK> baseRepository)
    {
        this.baseRepository = baseRepository;
    }

    public List<E> findAll()
        throws Exception
    {
        return baseRepository.findAll("", null);
    }

    public List<E> findAll(String columns)
        throws Exception
    {
        return baseRepository.findAll(columns, null);
    }

    public void save(E e)
        throws Exception
    {

        baseRepository.save(e);
    }

    public void saveBatch(Set<E> e) throws Exception
    {
        baseRepository.saveBatch(e);
    }

    public void delete(E e)
        throws Exception
    {
        baseRepository.delete(e);
    }

    public void deleteByProperty(String propertyName, Object value)
        throws Exception
    {
        baseRepository.deleteByProperty(propertyName, value);
    }

    public List<E> findByProperty(String columns, String propertyName, Object value)
        throws Exception
    {
        return baseRepository.findByProperty(columns, propertyName, value, null);
    }

    public List<E> findByProperty(String propertyName, Object value)
        throws Exception
    {
        return baseRepository.findByProperty("", propertyName, value, null);
    }

    public List<E> findByProperties(String columns, String[] propertyNames, Object[] values)
        throws Exception
    {
        return baseRepository.findByProperties(columns, propertyNames, values, null);
    }

    public List<E> findByProperties(String[] propertyNames, Object[] values)
        throws Exception
    {
        return baseRepository.findByProperties("", propertyNames, values, null);
    }

    public List<E> findByPropertyFuzzy(String columns, String propertyName, Object value)
        throws Exception
    {
        return baseRepository.findByPropertyFuzzy(columns, propertyName, value, null);
    }

    public List<E> findByPropertyFuzzy(String propertyName, Object value)
        throws Exception
    {
        return baseRepository.findByPropertyFuzzy("", propertyName, value, null);
    }

    public List<E> findByPropertiesFuzzy(String columns, String[] propertyNames, Object[] values)
        throws Exception
    {
        return baseRepository.findByProperties(columns, propertyNames, values, null);
    }

    public List<E> findByPropertiesFuzzy(String[] propertyNames, Object[] values)
        throws Exception
    {
        return baseRepository.findByProperties("", propertyNames, values, null);
    }

    public int updateEntityBatch(Map<String, Object> updateMapping,
                                 Map<String, Object> conditionMapping)
    {
        return baseRepository.updateBatchByHql(updateMapping, conditionMapping);
    }

    public List<Map<String, Object>> queryMapByHQL(String hql, Object[] args)
        throws Exception
    {
        return baseRepository.queryMapByHQL(hql, args, null);

    }

    public int countAll()
        throws Exception
    {
        return baseRepository.countAll();
    }

    public int countByProperty(String propertyName, Object value)
        throws Exception
    {
        return baseRepository.countByProperty(propertyName, value);
    }

    public int countByProperties(String[] propertyNames, Object[] values)
        throws Exception
    {
        return baseRepository.countByProperties(propertyNames, values);
    }

    public int countByPropertiesFuzzy(String propertyName, Object value)
        throws Exception
    {
        String[] properNames = {propertyName};
        Object[] values = {value};
        return baseRepository.countByProperties(properNames, values);
    }

    public int countByPropertiesFuzzy(String[] propertyNames, Object[] values)
        throws Exception
    {
        return baseRepository.countByProperties(propertyNames, values);
    }

    public void saveOrUpdate(E e)
        throws Exception
    {
        baseRepository.save(e);
    }

    public E findById(PK id)
        throws Exception
    {
        return baseRepository.findById(id);
    }

    public void update(E e)
        throws Exception
    {
        baseRepository.update(e);
    }

    public Class<E> getClazz()
        throws Exception
    {
        return baseRepository.getClazz();
    }
}
