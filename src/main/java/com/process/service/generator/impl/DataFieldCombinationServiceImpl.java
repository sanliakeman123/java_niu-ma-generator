package com.process.service.generator.impl;


import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataFieldCombinationDao;
import com.process.dao.generator.DataFieldCombinationSelectDao;
import com.process.entity.generator.DataFieldCombination;
import com.process.service.generator.DataFieldCombinationService;
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
public class DataFieldCombinationServiceImpl implements DataFieldCombinationService {

    private static final Logger log = LoggerFactory.getLogger(DataFieldCombinationServiceImpl.class);

    @Resource
    DataFieldCombinationDao dao;

    @Resource
    DataFieldCombinationSelectDao dataFieldCombinationSelectDao;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataFieldCombination> page(DataFieldCombination query, PageQuery pageQuery){
        log.info("DataFieldCombinationServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataFieldCombination> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataFieldCombinationServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataFieldCombination> list(DataFieldCombination query){
        log.info("DataFieldCombinationServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(DataFieldCombination entity) {
        entity.check();

        String uuid = entity.getUuid();
        List<DataFieldCombination> dataFieldCombinations = dao.selectByOther(new DataFieldCombination().setTableUuid(entity.getTableUuid()).setName(entity.getName()));
        int size = dataFieldCombinations.size();
        if(size>0 && !dataFieldCombinations.get(0).getUuid().equals(uuid)){
            throw new IllegalArgumentException("name不可以重复");
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
        log.info("DataFieldCombinationServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataFieldCombination selectByPrimaryKey(Integer primaryKey){
        log.info("DataFieldCombinationServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataFieldCombination entity){
        log.info("DataFieldCombinationServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据tableUuid查询数据(后台)
    * @param tableUuid  data_table uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<DataFieldCombination> selectByTableUuid(String tableUuid){
        log.info("DataFieldCombinationServiceImpl-selectByTableUuid: tableUuid: {}",tableUuid);
        return dao.selectByTableUuid(tableUuid);
    }

    /**
    * 根据tableUuid删除数据
    * @param tableUuid  data_table uuid
    * */
    @Override
    public void deleteByTableUuid(String tableUuid){
        log.info("DataFieldCombinationServiceImpl-deleteByTableUuid: tableUuid: {}",tableUuid);
        dao.deleteByTableUuid(tableUuid);
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public DataFieldCombination selectByUuid (String uuid){
        log.info("DataFieldCombinationServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }


    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByUuid(String uuid){
        log.info("DataFieldCombinationServiceImpl-deleteByUuid: uuid: {}",uuid);
        dataFieldCombinationSelectDao.selectByCombinationUuid(uuid);
        dao.deleteByUuid(uuid);
    }

    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataFieldCombination entity){
        log.info("DataFieldCombinationServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }

}