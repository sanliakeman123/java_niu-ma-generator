package com.process.service.generator;
import com.process.entity.generator.DataSource;
import com.common.PageInfo;
import com.common.PageQuery;
import java.util.List;
public interface DataSourceService {
    /**
    * 分页返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * @param pageQuery 筛选条件 limit 条件使用
    * */
    PageInfo<DataSource> page(DataSource query, PageQuery pageQuery);
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    List<DataSource> list(DataSource query);
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    void save(DataSource entity);
    /**
    * 根据主键删除数据
    * @param primaryKey 主键
    * @return 返回影响行数
    *
    * */
    void deleteByPrimaryKey(Integer primaryKey);
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
    void updateByPrimaryKeySelective(DataSource entity);
    /**
    * 根据uuid查询数据(数据库)
    * @param uuid  
    * @return 返回查询数据
    */
    DataSource selectByUuid(String uuid);
    /**
    * 根据uuid删除数据
    * @param uuid  
    * @return 返回影响行数
    * */
    void deleteByUuid(String uuid);
    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    void updateByUuid(DataSource entity);
}
