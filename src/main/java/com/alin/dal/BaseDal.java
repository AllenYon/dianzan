package com.alin.dal;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * dal的基类，其他的dal都继承这个类
 * Created by dinglaijia on 2017/8/11.
 */
public interface BaseDal<T> {

    /**
     * 插入
     * @param entity 业务对象
     */
    int insertSelective(T entity);


    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T selectByPrimaryKey( Long id);


    /**
     * 删除
     * @param id 主键
     * @param updated  最后更新时间
     * @return
     */
    Integer delete(Long id, Date updated);


    /**
     * 更新
     * @param t
     * @return
     */
    Integer updateByPrimaryKeySelective(T t);


    /**
     * 查询
     * @param map（查询条件）
     * @return
     */
    List<T> selectByExample(Map<String, Object> map);


    /**
     * 查询count
     * @param map (查询条件)
     * @return
     */
    Integer countByExample(Map<String, Object> map);

}
