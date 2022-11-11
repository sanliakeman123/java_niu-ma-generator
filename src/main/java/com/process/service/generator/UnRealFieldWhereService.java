package com.process.service.generator;
import com.process.entity.generator.UnRealFieldWhere;
import com.common.PageInfo;
import com.common.PageQuery;
import java.util.List;
public interface UnRealFieldWhereService {

    /**
    * 分页返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * @param pageQuery 筛选条件 limit 条件使用
    * */
    PageInfo<UnRealFieldWhere> page(UnRealFieldWhere query, PageQuery pageQuery);

    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    List<UnRealFieldWhere> list(UnRealFieldWhere query);

    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    void save(UnRealFieldWhere entity);
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
    UnRealFieldWhere selectByPrimaryKey(Integer primaryKey);
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * @return 返回影响行数
    * */
    void updateByPrimaryKeySelective(UnRealFieldWhere entity);
    /**
    * 根据unRealTableSubUuid查询数据(后台)
    * @param unRealTableSubUuid  虚拟表子表uuid
    * @return 返回查询数据列表
    */
    List<UnRealFieldWhere> selectByUnRealTableSubUuid(String unRealTableSubUuid);
    /**
    * 根据unRealTableSubUuid删除数据
    * @param unRealTableSubUuid  虚拟表子表uuid
    * @return 返回影响行数
    * */
    void deleteByUnRealTableSubUuid(String unRealTableSubUuid);
    /**
    * 根据uuid查询数据(数据库)
    * @param uuid  
    * @return 返回查询数据
    */
    UnRealFieldWhere selectByUuid(String uuid);

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
    void updateByUuid(UnRealFieldWhere entity);


}