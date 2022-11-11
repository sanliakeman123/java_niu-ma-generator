package com.process.dao.generator;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.process.entity.generator.UnRealTableSub;
import com.common.PageQuery;
/**
 * @author 牛马
 * @version 1.0
 */
@Mapper
public interface UnRealTableSubDao {
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
    UnRealTableSub selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByPrimaryKeySelective(UnRealTableSub entity); 
    /**
    * 新增一条数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int insertSelective(UnRealTableSub entity);

    /**
    * 查询数据列表
    * @param entity 实体类
    * @return 返回查询数据列表
    * */
    List<UnRealTableSub> selectByOther(@Param(value = "entity") UnRealTableSub entity);

    /**
    * 批量插入
    * @param list 实体类列表
    * @return 返回影响行数
    * */
    int insertBatch(List<UnRealTableSub> list);

    /**
    * 统计符合实体条件的数据量结合selectPageByOther分页使用
    * @param entity 实体类
    * @return 返回符合数据量
    * */
    long count(@Param(value = "entity") UnRealTableSub entity);

    /**
    * 分页查询数据
    * @param entity 实体类
    * @param page 分页参数
    * @return 返回查询数据列表
    * */
    List<UnRealTableSub> selectPageByOther(@Param(value = "entity") UnRealTableSub entity,@Param(value = "page") PageQuery page);

    /**
    * 根据unRealTableUuid查询数据
    * @param unRealTableUuid  虚拟表主表uuid
    * @return 返回查询数据列表
    */
    List<UnRealTableSub> selectByUnRealTableUuid(String unRealTableUuid);
    /**
    * 根据unRealTableUuid删除数据
    * @param unRealTableUuid  虚拟表主表uuid
    * @return 返回影响行数
    * */
    int deleteByUnRealTableUuid(String unRealTableUuid);
    /**
    * 根据uuid查询数据
    * @param uuid  
    * @return 返回查询数据
    */
    UnRealTableSub selectByUuid (String uuid);
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
    int updateByUuid(UnRealTableSub entity);


}