package com.process.service.generator.impl;


import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataFieldCombinationSelectDao;
import com.process.entity.generator.DataFieldCombination;
import com.process.entity.generator.DataFieldCombinationSelect;
import com.process.entity.generator.DataMetadata;
import com.process.service.generator.DataFieldCombinationSelectService;
import com.process.service.generator.DataFieldCombinationService;
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
public class DataFieldCombinationSelectServiceImpl implements DataFieldCombinationSelectService {

    private static final Logger log = LoggerFactory.getLogger(DataFieldCombinationSelectServiceImpl.class);

    @Resource
    DataFieldCombinationSelectDao dao;

    @Resource
    DataFieldCombinationService dataFieldCombinationService;

    @Resource
    DataMetadataService dataMetadataService;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataFieldCombinationSelect> page(DataFieldCombinationSelect query, PageQuery pageQuery){
        log.info("DataFieldCombinationSelectServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataFieldCombinationSelect> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataFieldCombinationSelectServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataFieldCombinationSelect> list(DataFieldCombinationSelect query){
        log.info("DataFieldCombinationSelectServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(DataFieldCombinationSelect entity) {
        DataFieldCombination dataFieldCombination = dataFieldCombinationService.selectByUuid(entity.getCombinationUuid());

        List<DataMetadata> list = dataMetadataService.list(new DataMetadata().setTableUuid(dataFieldCombination.getTableUuid()).setColumnName(entity.getFieldName()));
        int size = list.size();
        if(size>0){
            DataMetadata dataMetadata = list.get(0);
            entity.setJdbcType(dataMetadata.getJdbcType());
        }

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
        log.info("DataFieldCombinationSelectServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataFieldCombinationSelect selectByPrimaryKey(Integer primaryKey){
        log.info("DataFieldCombinationSelectServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataFieldCombinationSelect entity){
        log.info("DataFieldCombinationSelectServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据combinationUuid查询数据(后台)
    * @param combinationUuid  data_field_combination uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<DataFieldCombinationSelect> selectByCombinationUuid(String combinationUuid){
        log.info("DataFieldCombinationSelectServiceImpl-selectByCombinationUuid: combinationUuid: {}",combinationUuid);
        return dao.selectByCombinationUuid(combinationUuid);
    }

    /**
    * 根据combinationUuid删除数据
    * @param combinationUuid  data_field_combination uuid
    * */
    @Override
    public void deleteByCombinationUuid(String combinationUuid){
        log.info("DataFieldCombinationSelectServiceImpl-deleteByCombinationUuid: combinationUuid: {}",combinationUuid);
        dao.deleteByCombinationUuid(combinationUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public DataFieldCombinationSelect selectByUuid (String uuid){
        log.info("DataFieldCombinationSelectServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("DataFieldCombinationSelectServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataFieldCombinationSelect entity){
        log.info("DataFieldCombinationSelectServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

}