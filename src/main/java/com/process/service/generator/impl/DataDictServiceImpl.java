package com.process.service.generator.impl;


import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataDictDao;
import com.process.dao.generator.DataDictStaticDao;
import com.process.entity.generator.DataDict;
import com.process.service.generator.DataDictService;
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
public class DataDictServiceImpl implements DataDictService {

    private static final Logger log = LoggerFactory.getLogger(DataDictServiceImpl.class);

    @Resource
    DataDictDao dao;

    @Resource
    DataDictStaticDao dataDictStaticDao;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataDict> page(DataDict query, PageQuery pageQuery){
        log.info("DataDictServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataDict> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataDictServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataDict> list(DataDict query){
        log.info("DataDictServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(DataDict entity) {

        entity.check();

        String uuid = entity.getUuid();
        String sourceUuid = entity.getSourceUuid();
        String name = entity.getName();
        List<DataDict> dicts = dao.selectByOther(new DataDict().setSourceUuid(sourceUuid).setName(name));
        if(dicts.size()>0 && !dicts.get(0).getUuid().equals(uuid)){
            throw new IllegalArgumentException("存在相同的名称");
        }


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
        log.info("DataDictServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataDict selectByPrimaryKey(Integer primaryKey){
        log.info("DataDictServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataDict entity){
        log.info("DataDictServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据sourceUuid查询数据(后台)
    * @param sourceUuid  数据源 data_source uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<DataDict> selectBySourceUuid(String sourceUuid){
        log.info("DataDictServiceImpl-selectBySourceUuid: sourceUuid: {}",sourceUuid);
        return dao.selectBySourceUuid(sourceUuid);
    }

    /**
    * 根据sourceUuid删除数据
    * @param sourceUuid  数据源 data_source uuid
    * */
    @Override
    public void deleteBySourceUuid(String sourceUuid){
        log.info("DataDictServiceImpl-deleteBySourceUuid: sourceUuid: {}",sourceUuid);
        dao.deleteBySourceUuid(sourceUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public DataDict selectByUuid (String uuid){
        log.info("DataDictServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByUuid(String uuid){
        log.info("DataDictServiceImpl-deleteByUuid: uuid: {}",uuid);
        dataDictStaticDao.deleteByDictUuid(uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataDict entity){
        log.info("DataDictServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

}