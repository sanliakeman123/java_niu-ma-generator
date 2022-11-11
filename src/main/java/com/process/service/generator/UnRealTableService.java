package com.process.service.generator;
import com.process.entity.generator.UnRealTable;
import com.common.PageInfo;
import com.common.PageQuery;
import java.util.List;
public interface UnRealTableService {

    /**
    * 分页返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * @param pageQuery 筛选条件 limit 条件使用
    * */
    PageInfo<UnRealTable> page(UnRealTable query, PageQuery pageQuery);

    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    List<UnRealTable> list(UnRealTable query);

    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    void save(UnRealTable entity);
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
    UnRealTable selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    void updateByPrimaryKeySelective(UnRealTable entity);
    /**
    * 根据sourceUuid查询数据(后台)
    * @param sourceUuid  数据源uuid
    * @return 返回查询数据列表
    */
    List<UnRealTable> selectBySourceUuid(String sourceUuid);
    /**
    * 根据sourceUuid删除数据
    * @param sourceUuid  数据源uuid
    * @return 返回影响行数
    * */
    void deleteBySourceUuid(String sourceUuid);
    /**
    * 根据uuid查询数据(数据库)
    * @param uuid  
    * @return 返回查询数据
    */
    UnRealTable selectByUuid(String uuid);

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
    void updateByUuid(UnRealTable entity);

    /**
    * 根据数居源uuid查询选中的虚拟表
    * @param entity 实体类
    * @return 返回查询数据
    * */
 List<UnRealTable>  selectByBySourceSelected(UnRealTable entity);

}