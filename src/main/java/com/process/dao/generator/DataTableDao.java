package com.process.dao.generator;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.process.entity.generator.DataTable;
import com.common.PageQuery;
/**
 * @author 牛马
 * @version 1.0
 */
@Mapper
public interface DataTableDao {
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
    DataTable selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByPrimaryKeySelective(DataTable entity); 
    /**
    * 新增一条数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int insertSelective(DataTable entity);
    /**
    * 查询数据列表
    * @param entity 实体类
    * @return 返回查询数据列表
    * */
    List<DataTable> selectByOther(@Param(value = "entity") DataTable entity);
    /**
    * 批量插入
    * @param list 实体类列表
    * @return 返回影响行数
    * */
    int insertBatch(List<DataTable> list);
    /**
    * 统计符合实体条件的数据量结合selectPageByOther分页使用
    * @param entity 实体类
    * @return 返回符合数据量
    * */
    long count(@Param(value = "entity") DataTable entity);
    /**
    * 分页查询数据
    * @param entity 实体类
    * @param page 分页参数
    * @return 返回查询数据列表
    * */
    List<DataTable> selectPageByOther(@Param(value = "entity") DataTable entity,@Param(value = "page") PageQuery page);
    /**
    * 根据uuid查询数据
    * @param uuid  
    * @return 返回查询数据
    */
    DataTable selectByUuid (String uuid);
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
    int updateByUuid(DataTable entity);
    /**
    * 根据sourceUuid查询数据
    * @param sourceUuid  数据源 data_source uuid
    * @return 返回查询数据列表
    */
    List<DataTable> selectBySourceUuid(String sourceUuid);
    /**
    * 根据sourceUuid删除数据
    * @param sourceUuid  数据源 data_source uuid
    * @return 返回影响行数
    * */
    int deleteBySourceUuid(String sourceUuid);
    /**
    * 根据selected查询数据
    * @param selected  是否选中 0没有选中 1选中
    * @return 返回查询数据列表
    */
    List<DataTable> selectBySelected(Integer selected);
    /**
    * 根据selected删除数据
    * @param selected  是否选中 0没有选中 1选中
    * @return 返回影响行数
    * */
    int deleteBySelected(Integer selected);
}