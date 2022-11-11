package com.process.service.generator.impl;

import com.process.entity.generator.UnRealTableSub;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.UnRealTableSubDao;
import com.process.service.generator.UnRealFieldSelectService;
import com.process.service.generator.UnRealFieldWhereService;
import com.process.service.generator.UnRealTableSubService;
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
public class UnRealTableSubServiceImpl implements UnRealTableSubService{

    private static final Logger log = LoggerFactory.getLogger(UnRealTableSubServiceImpl.class);

    @Resource
    UnRealTableSubDao dao;

    @Resource
    UnRealFieldSelectService unRealFieldSelectService;

    @Resource
    UnRealFieldWhereService unRealFieldWhereService;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<UnRealTableSub> page(UnRealTableSub query, PageQuery pageQuery){
        log.info("UnRealTableSubServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<UnRealTableSub> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("UnRealTableSubServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<UnRealTableSub> list(UnRealTableSub query){
        log.info("UnRealTableSubServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(UnRealTableSub entity) {
        
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
        log.info("UnRealTableSubServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public UnRealTableSub selectByPrimaryKey(Integer primaryKey){
        log.info("UnRealTableSubServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(UnRealTableSub entity){
        log.info("UnRealTableSubServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据unRealTableUuid查询数据(后台)
    * @param unRealTableUuid  虚拟表主表uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<UnRealTableSub> selectByUnRealTableUuid(String unRealTableUuid){
        log.info("UnRealTableSubServiceImpl-selectByUnRealTableUuid: unRealTableUuid: {}",unRealTableUuid);
        return dao.selectByUnRealTableUuid(unRealTableUuid);
    }

    /**
    * 根据unRealTableUuid删除数据
    * @param unRealTableUuid  虚拟表主表uuid
    * */
    @Override
    public void deleteByUnRealTableUuid(String unRealTableUuid){
        log.info("UnRealTableSubServiceImpl-deleteByUnRealTableUuid: unRealTableUuid: {}",unRealTableUuid);
        List<UnRealTableSub> unRealTableSubs = selectByUnRealTableUuid(unRealTableUuid);
        for (UnRealTableSub tableSub : unRealTableSubs) {
            String subUuid = tableSub.getUuid();
            unRealFieldSelectService.deleteByUnRealTableSubUuid(subUuid);
            unRealFieldWhereService.deleteByUnRealTableSubUuid(subUuid);
        }
        dao.deleteByUnRealTableUuid(unRealTableUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public UnRealTableSub selectByUuid (String uuid){
        log.info("UnRealTableSubServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("UnRealTableSubServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(UnRealTableSub entity){
        log.info("UnRealTableSubServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

}