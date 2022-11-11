package com.process.dao.generator;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.process.entity.generator.DataSource;
import com.common.PageQuery;
/**
 * @author 牛马
 * @version 1.0
 */
@Mapper
public interface DataSourceDao {
    /**
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
    DataSource selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByPrimaryKeySelective(DataSource entity); 
    /**
    * 新增一条数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int insertSelective(DataSource entity);
    /**
    * 查询数据列表
    * @param entity 实体类
    * @return 返回查询数据列表
    * */
    List<DataSource> selectByOther(@Param(value = "entity") DataSource entity);
    /**
    * 批量插入
    * @param list 实体类列表
    * @return 返回影响行数
    * */
    int insertBatch(List<DataSource> list);
    /**
    * 统计符合实体条件的数据量结合selectPageByOther分页使用
    * @param entity 实体类
    * @return 返回符合数据量
    * */
    long count(@Param(value = "entity") DataSource entity);
    /**
    * 分页查询数据
    * @param entity 实体类
    * @param page 分页参数
    * @return 返回查询数据列表
    * */
    List<DataSource> selectPageByOther(@Param(value = "entity") DataSource entity,@Param(value = "page") PageQuery page);
    /**
    * 根据uuid查询数据
    * @param uuid  
    * @return 返回查询数据
    */
    DataSource selectByUuid (String uuid);
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
    int updateByUuid(DataSource entity);
}