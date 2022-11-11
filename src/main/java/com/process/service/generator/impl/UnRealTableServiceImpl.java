package com.process.service.generator.impl;

import com.process.entity.generator.UnRealTable;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.UnRealTableDao;
import com.process.service.generator.UnRealTableService;
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
public class UnRealTableServiceImpl implements UnRealTableService{

    private static final Logger log = LoggerFactory.getLogger(UnRealTableServiceImpl.class);

    @Resource
    UnRealTableDao dao;

    @Resource
    UnRealTableSubService unRealTableSubService;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<UnRealTable> page(UnRealTable query, PageQuery pageQuery){
        log.info("UnRealTableServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<UnRealTable> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("UnRealTableServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<UnRealTable> list(UnRealTable query){
        log.info("UnRealTableServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(UnRealTable entity) {
        
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
        log.info("UnRealTableServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public UnRealTable selectByPrimaryKey(Integer primaryKey){
        log.info("UnRealTableServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(UnRealTable entity){
        log.info("UnRealTableServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据sourceUuid查询数据(后台)
    * @param sourceUuid  数据源uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<UnRealTable> selectBySourceUuid(String sourceUuid){
        log.info("UnRealTableServiceImpl-selectBySourceUuid: sourceUuid: {}",sourceUuid);
        return dao.selectBySourceUuid(sourceUuid);
    }

    /**
    * 根据sourceUuid删除数据
    * @param sourceUuid  数据源uuid
    * */
    @Override
    public void deleteBySourceUuid(String sourceUuid){
        log.info("UnRealTableServiceImpl-deleteBySourceUuid: sourceUuid: {}",sourceUuid);
        dao.deleteBySourceUuid(sourceUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public UnRealTable selectByUuid (String uuid){
        log.info("UnRealTableServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("UnRealTableServiceImpl-deleteByUuid: uuid: {}",uuid);
        unRealTableSubService.deleteByUnRealTableUuid(uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(UnRealTable entity){
        log.info("UnRealTableServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

    /**
    * 根据数居源uuid查询选中的虚拟表
    * @param entity 实体类
    * @return 返回查询数据
    * */
    @Override
    public  List<UnRealTable>  selectByBySourceSelected(UnRealTable entity){
        log.info("UnRealTableServiceImpl-selectByBySourceSelected: UnRealTable: {}",entity);
        return dao.selectByBySourceSelected(entity);
    }
}