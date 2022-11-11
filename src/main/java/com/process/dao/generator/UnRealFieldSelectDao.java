package com.process.dao.generator;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.process.entity.generator.UnRealFieldSelect;
import com.common.PageQuery;
/**
 * @author 牛马
 * @version 1.0
 */
@Mapper
public interface UnRealFieldSelectDao {
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
    UnRealFieldSelect selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int updateByPrimaryKeySelective(UnRealFieldSelect entity); 
    /**
    * 新增一条数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    int insertSelective(UnRealFieldSelect entity);

    /**
    * 查询数据列表
    * @param entity 实体类
    * @return 返回查询数据列表
    * */
    List<UnRealFieldSelect> selectByOther(@Param(value = "entity") UnRealFieldSelect entity);

    /**
    * 批量插入
    * @param list 实体类列表
    * @return 返回影响行数
    * */
    int insertBatch(List<UnRealFieldSelect> list);

    /**
    * 统计符合实体条件的数据量结合selectPageByOther分页使用
    * @param entity 实体类
    * @return 返回符合数据量
    * */
    long count(@Param(value = "entity") UnRealFieldSelect entity);

    /**
    * 分页查询数据
    * @param entity 实体类
    * @param page 分页参数
    * @return 返回查询数据列表
    * */
    List<UnRealFieldSelect> selectPageByOther(@Param(value = "entity") UnRealFieldSelect entity,@Param(value = "page") PageQuery page);

    /**
    * 根据unRealTableSubUuid查询数据
    * @param unRealTableSubUuid  虚拟表子表uuid
    * @return 返回查询数据列表
    */
    List<UnRealFieldSelect> selectByUnRealTableSubUuid(String unRealTableSubUuid);
    /**
    * 根据unRealTableSubUuid删除数据
    * @param unRealTableSubUuid  虚拟表子表uuid
    * @return 返回影响行数
    * */
    int deleteByUnRealTableSubUuid(String unRealTableSubUuid);
    /**
    * 根据uuid查询数据
    * @param uuid  
    * @return 返回查询数据
    */
    UnRealFieldSelect selectByUuid (String uuid);
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
    int updateByUuid(UnRealFieldSelect entity);


}