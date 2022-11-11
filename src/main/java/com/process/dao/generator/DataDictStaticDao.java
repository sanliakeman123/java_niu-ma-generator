package com.process.dao.generator;
import java.util.List;

import com.common.PageQuery;
import com.process.entity.generator.DataDictStatic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 牛马
 * @version 1.0
 */
@Mapper
public interface DataDictStaticDao {
    /** 0
    * 根据主键删除数据
    * @param primaryKey 主键
    * @return 返回影响行数
    * */
    int deleteByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    DataDictStatic selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByPrimaryKeySelective(DataDictStatic entity); 
    /**
    * 新增一条数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int insertSelective(DataDictStatic entity);

    /**
    * 查询数据列表
    * @param entity 实体类
    * @return 返回查询数据列表
    * */
    List<DataDictStatic> selectByOther(@Param(value = "entity") DataDictStatic entity);

    /**
    * 批量插入
    * @param list 实体类列表
    * @return 返回影响行数
    * */
    int insertBatch(List<DataDictStatic> list);

    /**
    * 统计符合实体条件的数据量结合selectPageByOther分页使用
    * @param entity 实体类
    * @return 返回符合数据量
    * */
    long count(@Param(value = "entity") DataDictStatic entity);

    /**
    * 分页查询数据
    * @param entity 实体类
    * @param page 分页参数
    * @return 返回查询数据列表
    * */
    List<DataDictStatic> selectPageByOther(@Param(value = "entity") DataDictStatic entity,@Param(value = "page") PageQuery page);

    /**
    * 根据dictUuid查询数据
    * @param dictUuid  data_dict uuid
    * @return 返回查询数据列表
    */
    List<DataDictStatic> selectByDictUuid(String dictUuid);
    /**
    * 根据dictUuid删除数据
    * @param dictUuid  data_dict uuid
    * @return 返回影响行数
    * */
    int deleteByDictUuid(String dictUuid);
    /**
    * 根据uuid查询数据
    * @param uuid  
    * @return 返回查询数据
    */
    DataDictStatic selectByUuid (String uuid);
    /**
    * 根据uuid删除数据
    * @param uuid  
    * @return 返回影响行数
    * */
    int deleteByUuid(String uuid);

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByUuid(DataDictStatic entity);


}