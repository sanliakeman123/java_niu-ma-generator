package com.process.service.generator.impl;
import com.process.entity.generator.DataMetadata;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataMetadataDao;
import com.process.service.generator.DataMetadataService;
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
public class DataMetadataServiceImpl implements DataMetadataService{
    private static final Logger log = LoggerFactory.getLogger(DataMetadataServiceImpl.class);
    @Resource
    DataMetadataDao dao;
    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataMetadata> page(DataMetadata query, PageQuery pageQuery){
        log.info("DataMetadataServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataMetadata> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataMetadataServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataMetadata> list(DataMetadata query){
        log.info("DataMetadataServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(DataMetadata entity) {
        
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
        log.info("DataMetadataServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataMetadata selectByPrimaryKey(Integer primaryKey){
        log.info("DataMetadataServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataMetadata entity){
        log.info("DataMetadataServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  uuid唯一标识符
    * @return 返回查询数据
    */
    @Override
    public DataMetadata selectByUuid (String uuid){
        log.info("DataMetadataServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }
    /**
    * 根据uuid删除数据
    * @param uuid  uuid唯一标识符
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("DataMetadataServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }
    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataMetadata entity){
        log.info("DataMetadataServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }
    /**
    * 根据tableUuid查询数据(后台)
    * @param tableUuid  data_table uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<DataMetadata> selectByTableUuid(String tableUuid){
        log.info("DataMetadataServiceImpl-selectByTableUuid: tableUuid: {}",tableUuid);
        return dao.selectByTableUuid(tableUuid);
    }
    /**
    * 根据tableUuid删除数据
    * @param tableUuid  data_table uuid
    * */
    @Override
    public void deleteByTableUuid(String tableUuid){
        log.info("DataMetadataServiceImpl-deleteByTableUuid: tableUuid: {}",tableUuid);
        dao.deleteByTableUuid(tableUuid);
    }

    @Override
    public void saveList(List<DataMetadata> list) {
        for (DataMetadata metadata : list) {
            save(metadata);
        }
    }
}
