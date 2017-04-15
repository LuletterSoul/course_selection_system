package org.app.service.model;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 31370 on 2017/4/5.
 */
public interface BaseServiceModel <E, PK extends Serializable>
{

    /**
     * ���Ƽ�ʹ��ȫ�в�ѯ���Ǳ�Ҫ���磺�㵱ǰ�޷�֪������Щ�У�
     * ��ȡ��ǰ��������м�¼����������
     * @return ���м�¼
     */
    @Deprecated
    List<E> findAll() throws Exception;

    /**
     * ��ȡ��ǰ��������м�¼(ֻ����ָ������,�����ԡ������Ÿ�����
     * @param columns ����
     * @return ���м�¼
     */
    List<E> findAll(String columns) throws Exception;

    /**
     * �������У�����ҳ
     *
     * @param page Ҫ���ص�ҳ��
     * @param pageSize û�м�¼��
     * @return
     */
//    ResponsePage<E> pageAll(String columns,Pagination pagination)throws Exception;

    /**
     * �������
     * @param e ����
     */
    void save(E e)throws Exception;

    /**
     * �����������
     * @param set ���󼯺�
     */

    void saveBatch(Set<E> set)throws Exception;

    /**
     * ɾ������
     * @param e ����
     */
    void delete(E e)throws Exception;;

    /**
     * ɾ��������ΪpropertyName������ֵΪvalue�ļ�¼
     */
    void deleteByProperty(String propertyName, Object value)throws Exception;

    /**
     * ͨ�����Բ��Ҳ�������Ҫ����
     * @param ��Ҫ���ص������ԡ������Ÿ���
     * @param propertyName ��������
     * @param value ���Ե�ֵ
     * @return
     */
    List<E> findByProperty(String columns,String propertyName, Object value)throws Exception;

    /**
     * ͨ�����Բ��Ҳ�����������
     * ���Ƽ�ʹ��ȫ�в�ѯ���Ǳ�Ҫ���磺�㵱ǰ�޷�֪������Щ�У�
     * @param ��Ҫ���ص������ԡ������Ÿ���
     * @param propertyName ��������
     * @param value ���Ե�ֵ
     * @return
     */
    @Deprecated
    List<E> findByProperty(String propertyName, Object value)throws Exception;

    /**
     * ͨ��������Բ��Ҳ�ָ����������
     * @param columns ��Ҫ���ص�����
     * @param propertyNames ������������
     * @param values ����ֵ����
     * @return
     */
    List<E> findByProperties(String columns,String[] propertyNames, Object[] values)throws Exception;


    /**
     * ͨ��������Բ��Ҳ�����������
     * ���Ƽ�ʹ��ȫ�в�ѯ���Ǳ�Ҫ���磺�㵱ǰ�޷�֪������Щ�У�
     * @param propertyNames ������������
     * @param values ����ֵ����
     * @return
     */
    @Deprecated
    List<E> findByProperties(String[] propertyNames, Object[] values)throws Exception;

    /**
     * ͨ������ģ�����Ҳ�ָ����������
     * @param columns ��Ҫ���ص�����
     * @param propertyName ��������
     * @param value ���Ե�ֵ
     * @return
     */
    List<E> findByPropertyFuzzy(String columns,String propertyName, Object value)throws Exception;

    /**
     * ͨ������ģ�����Ҳ�����������
     * ���Ƽ�ʹ��ȫ�в�ѯ���Ǳ�Ҫ���磺�㵱ǰ�޷�֪������Щ�У�
     * @param propertyName ��������
     * @param value ���Ե�ֵ
     * @return
     */
    @Deprecated
    List<E> findByPropertyFuzzy(String propertyName, Object value)throws Exception;


    /**
     * ͨ���������ģ�����Ҳ�����ָ������
     * @param columns ��Ҫ���ص�����
     * @param propertyNames ������������
     * @param values ����ֵ����
     * @return
     */
    List<E> findByPropertiesFuzzy(String columns,String[] propertyNames, Object[] values)throws Exception;

    /**
     * ͨ���������ģ�����Ҳ�����������
     * ���Ƽ�ʹ��ȫ�в�ѯ���Ǳ�Ҫ���磺�㵱ǰ�޷�֪������Щ�У�
     * @param propertyNames ������������
     * @param values ����ֵ����
     * @return
     */
    @Deprecated
    List<E> findByPropertiesFuzzy(String[] propertyNames, Object[] values)throws Exception;


    /**
     * @param updateMapping ������,��ֵ����ֵ��
     * @param conditionMapping �����ԣ�Լ������ֵ��
     * @return ������ɢ���ݷ�Χ
     */
    int updateEntityBatch(Map<String,Object> updateMapping, Map<String,Object> conditionMapping);

    /**
     * ͨ��������Բ��ң�����ҳ�� �����������������ֵ���������Ҫ��Ӧ
     * @param columns ��Ҫ���ص�����
     * @param propertyNames ������������
     * @param values ����ֵ����
     * @param pagination ��ҳ����
     * @return ��ҳ��Ľ��
     */
//    ResponsePage<E> pageByProperties(String columns,String[] propertyNames, Object[] values,Pagination pagination)throws Exception;

    /**
     * ͨ�����Բ��ң�����ҳ�� �����������������ֵ���������Ҫ��Ӧ
     * @param columns ��Ҫ���ص�����
     * @param propertyNames ��������
     * @param values ����ֵ
     * @param pagination ��ҳ����
     * @return
     */
//    ResponsePage<E> pageByProperty(String columns,String propertyName, Object value,Pagination pagination)throws Exception;
    /**
     * ͨ���������ģ�����ң�����ҳ�� �����������������ֵ���������Ҫ��Ӧ
     * @param columns ��Ҫ���ص�����
     * @param propertyNames ������������
     * @param values ����ֵ����
     * @param pagination ��ҳ����
     * @return ��ҳ��Ľ��
     */
//    ResponsePage<E> pageByPropertysFuzzy(String columns,String[] propertyNames, Object[] values,Pagination pagination)throws Exception;

    /**
     * ͨ������ģ�����ң�����ҳ�� �����������������ֵ���������Ҫ��Ӧ
     * @param columns ��Ҫ���ص�����
     * @param propertyNames ��������
     * @param values ����ֵ
     * @param pagination ��ҳ����
     * @return
     */
//    ResponsePage<E> pageByPropertyFuzzy(String columns,String propertyName, Object value,Pagination pagination)throws Exception;


//    List<E> queryBySQL(SqlBean sql)throws Exception;

    List<Map<String, Object>> queryMapByHQL(String hql, Object[] args)throws Exception;

//    ResponsePage<E> pageBySQL(SqlBean sql,Pagination pagination)throws Exception;
//
//    ResponsePage<Map<String, Object>> pageMapByHQL(String hql,Object[] args,Pagination pagination)throws Exception;


    /**
     * ͳ�����м�¼������
     *
     * @return ����
     */
    int countAll()throws Exception;

    /**
     * ͳ�����ݿ��е�propertyName=valueʱ�ļ�¼����
     *
     * @param propertyName
     * @param value
     * @return
     */
    int countByProperty(String propertyName, Object value)throws Exception;

    /**
     * ͳ�����ݿ��е����propertyName=valueʱ�ļ�¼����
     *
     * @param propertyNames
     * @param values
     * @return
     */
    int countByProperties(String[] propertyNames, Object[] values)throws Exception;


    /**
     * ͳ�����ݿ��е�propertyName=value ģ����ѯʱ�ļ�¼����
     *
     * @param propertyName
     * @param value
     * @return
     */
    int countByPropertiesFuzzy(String propertyName, Object value)throws Exception;

    /**
     * ͳ�����ݿ��е����propertyName=value ģ����ѯʱ�ļ�¼����
     *
     * @param propertyNames
     * @param values
     * @return
     */
    int countByPropertiesFuzzy(String[] propertyNames, Object[] values)throws Exception;


    /**
     * ����SQL����ѯ���������
     * @return
     */
//    int countBySql(SqlBean sql)throws Exception;

    /**
     * ��������
     * @param e
     */
    void saveOrUpdate(E e)throws Exception;




    /**
     * ͨ��ID��ѯ����
     * @param id �������
     * @return
     */
    E findById(PK id)throws Exception;

    /**
     * ���¶���
     * @param e
     * @throws Exception
     */
    void update(E e) throws Exception;

    /**
     * ��ó־û����������
     *
     * @return
     */
    Class<E> getClazz()throws Exception;
}
