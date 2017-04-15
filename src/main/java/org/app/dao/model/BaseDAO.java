package org.app.dao.model;


import jdk.nashorn.internal.objects.annotations.Where;
import org.app.util.HibernatePagination;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by 31370 on 2017/3/29.
 */
public interface BaseDAO<E, PK extends Serializable>
{
    // Object getByUniquePrimaryKey(Class clazz,Serializable id);
    // Object get(String queryString,Object ... values);
    // void saveOrUpdate(Object entity);
    // void delete(Object entity);
    // void update(Object entity);
    // List getList(String queryString);
    /**
     * �������
     *
     * @param e ����ʵ��
     *
     * @return
     */
    Serializable save(E entity);

    /**
     * �����������
     *
     * @param set ����ʵ��
     *
     * @return
     */
    int saveBatch(Set<E> set);

    void update(E entity);

    void delete(E entity);

    /**
     * ɾ��propertyName == value �ļ�¼
     */
    void deleteByProperty(String propertyName, Object value);

    /**
     * ͨ��ID��ѯ����
     * 
     * @param id
     *            ����
     * @return
     */
    E findById(PK id) throws Exception;

    /**
     * ��ȡ��ǰ��������м�¼ @ columns ��Ҫ���ص����� @ pagination ��ҳ��Ϣ
     * 
     * @return ���м�¼
     */
    List<E> findAll(String columns, HibernatePagination pagination);

    /**
     * ͨ��������Բ���
     *
     * @param propertyNames
     *            ������������
     * @param values
     *            ����ֵ����
     * @return
     */
    List<E> findByProperties(String columns, String[] propertyNames, Object[] values,
                             HibernatePagination pagination);

    /**
     * ͨ��������Բ���
     *
     * @param propertyName
     *            ������������
     * @param value
     *            ����ֵ����
     * @return
     */
    List<E> findByProperty(String columns, String propertyName, Object value,
                           HibernatePagination pagination);

    /**
     * ͨ���������ģ������
     *
     * @param propertyNames
     *            ������������
     * @param values
     *            ����ֵ����
     * @return
     */
    List<E> findByPropertiesFuzzy(String columns, String[] propertyNames, Object[] values,
                                  HibernatePagination pagination);

    /**
     * ͨ��ĳ������ģ������
     *
     * @param propertyName
     *            ��������
     * @param value
     *            ����ֵ
     * @return  ����ֵ����
     */
    List<E> findByPropertyFuzzy(String columns, String propertyName, Object value,
                                HibernatePagination pagination);

    /**
     * ͳ�����м�¼������
     *
     * @return ����
     */
    int countAll();

    /**
     * ͳ�����ݿ��е�propertyName=valueʱ�ļ�¼����
     *
     * @param propertyNames
     * @param values
     * @return
     */
    int countByProperties(String[] propertyNames, Object[] values);


    /**
     * ͳ�����ݿ��е�propertyName=valueʱ�ļ�¼����
     *
     * @param propertyName
     * @param value
     * @return
     */
    int countByProperty(String propertyName, Object value);


    int countByPropertiesFuzzy(String[] propertyNames, Object[] values);

    // /**
    // * ����SQL��ѯ��¼��
    // */
    // int queryCountBySQL(SqlBean sql);
    //
    // int mapCountByHQL(String hql,Object[] args);
    // /**
    // * ���Ҳ�ͨ��ĳһ��������
    // *
    // * @param property
    // * �������ݵ�˳��
    // * @param isSequence
    // * �Ƿ�˳������
    // */
    //
    // /**
    // * ����SQL�﷨��ѯ
    // *
    // * @param sql
    // * @return
    // */
    // List<E> queryBySQL(SqlBean sql);
    //
    //
    // /**
    // * ����SQL�﷨��ҳ��ѯ
    // *
    // * @param sql
    // * @return
    // */
    // List<E> queryBySQL(SqlBean sql,Pagination pagination);

     /**
     * ����SQL�﷨��ѯ
     * @param hqlString
     * @return �����Զ����Map����
     */
     List<Map<String, Object>> queryMapByHQL(String hqlString, Object[] args,
                                                    HibernatePagination pagination);
    /**
     * ����hql�﷨��������
     * @param updateMappingValues ����������Բ�����
     * @param conditionMappingValues �����������Բ�����
     * @return �����Զ����Map����
     */
    int updateBatchByHql(Map<String, Object> updateMappingValues,
                         Map<String, Object> conditionMappingValues);
}
