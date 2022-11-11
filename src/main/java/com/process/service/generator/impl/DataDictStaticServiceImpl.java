package com.process.service.generator.impl;


import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataDictStaticDao;
import com.process.entity.generator.DataDictStatic;
import com.process.service.generator.DataDictStaticService;
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
public class DataDictStaticServiceImpl implements DataDictStaticService {

    private static final Logger log = LoggerFactory.getLogger(DataDictStaticServiceImpl.class);

    @Resource
    DataDictStaticDao dao;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataDictStatic> page(DataDictStatic query, PageQuery pageQuery){
        log.info("DataDictStaticServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataDictStatic> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataDictStaticServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataDictStatic> list(DataDictStatic query){
        log.info("DataDictStaticServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(DataDictStatic entity) {

        entity.check();
        String uuid = entity.getUuid();
        String dictUuid = entity.getDictUuid();
        String value = entity.getValue();

        List<DataDictStatic> dataDictStatics = dao.selectByOther(new DataDictStatic().setDictUuid(dictUuid).setValue(value));
        if(dataDictStatics.size()>0 && !dataDictStatics.get(0).getUuid().equals(uuid) ){
         throw new IllegalArgumentException("同一字典中value不可重复");
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
        log.info("DataDictStaticServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataDictStatic selectByPrimaryKey(Integer primaryKey){
        log.info("DataDictStaticServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataDictStatic entity){
        log.info("DataDictStaticServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据dictUuid查询数据(后台)
    * @param dictUuid  data_dict uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<DataDictStatic> selectByDictUuid(String dictUuid){
        log.info("DataDictStaticServiceImpl-selectByDictUuid: dictUuid: {}",dictUuid);
        return dao.selectByDictUuid(dictUuid);
    }

    /**
    * 根据dictUuid删除数据
    * @param dictUuid  data_dict uuid
    * */
    @Override
    public void deleteByDictUuid(String dictUuid){
        log.info("DataDictStaticServiceImpl-deleteByDictUuid: dictUuid: {}",dictUuid);
        dao.deleteByDictUuid(dictUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public DataDictStatic selectByUuid (String uuid){
        log.info("DataDictStaticServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("DataDictStaticServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataDictStatic entity){
        log.info("DataDictStaticServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

}