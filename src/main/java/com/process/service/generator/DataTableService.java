package com.process.service.generator;
import com.common.ParentListSon;
import com.process.entity.generator.DataMetadata;
import com.process.entity.generator.DataTable;
import com.common.PageInfo;
import com.common.PageQuery;
import java.util.List;
import java.util.Map;

public interface DataTableService {
    /**
    * 分页返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * @param pageQuery 筛选条件 limit 条件使用
    * */
    PageInfo<DataTable> page(DataTable query, PageQuery pageQuery);
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    List<DataTable> list(DataTable query);
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    void save(DataTable entity);
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
    DataTable selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    void updateByPrimaryKeySelective(DataTable entity);
    /**
    * 根据uuid查询数据(数据库)
    * @param uuid  
    * @return 返回查询数据
    */
    DataTable selectByUuid(String uuid);
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
    void updateByUuid(DataTable entity);
    /**
    * 根据sourceUuid查询数据(后台)
    * @param sourceUuid  数据源 data_source uuid
    * @return 返回查询数据列表
    */
    List<DataTable> selectBySourceUuid(String sourceUuid);


    List< ParentListSon<DataTable, DataMetadata> >selectMapBySourceUuid(String sourceUuid);

    /**
    * 根据sourceUuid删除数据
    * @param sourceUuid  数据源 data_source uuid
    * @return 返回影响行数
    * */
    void deleteBySourceUuid(String sourceUuid);
    /**
    * 根据selected查询数据(后台)
    * @param selected  是否选中 0没有选中 1选中
    * @return 返回查询数据列表
    */
    List<DataTable> selectBySelected(Integer selected);
    /**
    * 根据selected删除数据
    * @param selected  是否选中 0没有选中 1选中
    * @return 返回影响行数
    * */
    void deleteBySelected(Integer selected);
}
