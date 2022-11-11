package com.process.service.generator.impl;

import com.process.entity.generator.UnRealFieldSelect;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.UnRealFieldSelectDao;
import com.process.service.generator.UnRealFieldSelectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class UnRealFieldSelectServiceImpl implements UnRealFieldSelectService{

    private static final Logger log = LoggerFactory.getLogger(UnRealFieldSelectServiceImpl.class);

    @Resource
    UnRealFieldSelectDao dao;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<UnRealFieldSelect> page(UnRealFieldSelect query, PageQuery pageQuery){
        log.info("UnRealFieldSelectServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<UnRealFieldSelect> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("UnRealFieldSelectServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<UnRealFieldSelect> list(UnRealFieldSelect query){
        log.info("UnRealFieldSelectServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(UnRealFieldSelect entity) {
        
        String uuid = entity.getUuid();

        if( uuid == null || uuid.length()==0 || uuid.equals("null")){
            dao.insertSelective( entity.setUuid( UUID.randomUUID().toString() ) );
        }else{
            dao.updateByUuid(entity);
        }
        
    }
    /**
    * 根据主键删除数据
    * @param primaryKey 主键
    * */
    @Override
    public void deleteByPrimaryKey(Integer primaryKey){
        log.info("UnRealFieldSelectServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public UnRealFieldSelect selectByPrimaryKey(Integer primaryKey){
        log.info("UnRealFieldSelectServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(UnRealFieldSelect entity){
        log.info("UnRealFieldSelectServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据unRealTableSubUuid查询数据(后台)
    * @param unRealTableSubUuid  虚拟表子表uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<UnRealFieldSelect> selectByUnRealTableSubUuid(String unRealTableSubUuid){
        log.info("UnRealFieldSelectServiceImpl-selectByUnRealTableSubUuid: unRealTableSubUuid: {}",unRealTableSubUuid);
        return dao.selectByUnRealTableSubUuid(unRealTableSubUuid);
    }

    /**
    * 根据unRealTableSubUuid删除数据
    * @param unRealTableSubUuid  虚拟表子表uuid
    * */
    @Override
    public void deleteByUnRealTableSubUuid(String unRealTableSubUuid){
        log.info("UnRealFieldSelectServiceImpl-deleteByUnRealTableSubUuid: unRealTableSubUuid: {}",unRealTableSubUuid);
        dao.deleteByUnRealTableSubUuid(unRealTableSubUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public UnRealFieldSelect selectByUuid (String uuid){
        log.info("UnRealFieldSelectServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("UnRealFieldSelectServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(UnRealFieldSelect entity){
        log.info("UnRealFieldSelectServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

}