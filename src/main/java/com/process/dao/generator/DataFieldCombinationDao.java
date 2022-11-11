package com.process.dao.generator;
import java.util.List;

import com.common.PageQuery;
import com.process.entity.generator.DataFieldCombination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 牛马
 * @version 1.0
 */
@Mapper
public interface DataFieldCombinationDao {
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
    DataFieldCombination selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByPrimaryKeySelective(DataFieldCombination entity);
    /**
    * 新增一条数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int insertSelective(DataFieldCombination entity);

    /**
    * 查询数据列表
    * @param entity 实体类
    * @return 返回查询数据列表
    * */
    List<DataFieldCombination> selectByOther(@Param(value = "entity") DataFieldCombination entity);

    /**
    * 批量插入
    * @param list 实体类列表
    * @return 返回影响行数
    * */
    int insertBatch(List<DataFieldCombination> list);

    /**
    * 统计符合实体条件的数据量结合selectPageByOther分页使用
    * @param entity 实体类
    * @return 返回符合数据量
    * */
    long count(@Param(value = "entity") DataFieldCombination entity);

    /**
    * 分页查询数据
    * @param entity 实体类
    * @param page 分页参数
    * @return 返回查询数据列表
    * */
    List<DataFieldCombination> selectPageByOther(@Param(value = "entity") DataFieldCombination entity,@Param(value = "page") PageQuery page);

    /**
    * 根据tableUuid查询数据
    * @param tableUuid  data_table uuid
    * @return 返回查询数据列表
    */
    List<DataFieldCombination> selectByTableUuid(String tableUuid);
    /**
    * 根据tableUuid删除数据
    * @param tableUuid  data_table uuid
    * @return 返回影响行数
    * */
    int deleteByTableUuid(String tableUuid);
    /**
    * 根据uuid查询数据
    * @param uuid  
    * @return 返回查询数据
    */
    DataFieldCombination selectByUuid (String uuid);
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
    int updateByUuid(DataFieldCombination entity);
}