package com.process.service.generator.impl;
import com.common.ParentListSon;
import com.process.dao.generator.DataMetadataDao;
import com.process.entity.generator.DataMetadata;
import com.process.entity.generator.DataTable;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataTableDao;
import com.process.service.generator.DataTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import javax.annotation.Resource;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class DataTableServiceImpl implements DataTableService{
    private static final Logger log = LoggerFactory.getLogger(DataTableServiceImpl.class);
    @Resource
    DataTableDao dao;
    @Resource
    DataMetadataDao dataMetadataDao;
    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataTable> page(DataTable query, PageQuery pageQuery){
        log.info("DataTableServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataTable> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataTableServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataTable> list(DataTable query){
        log.info("DataTableServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(DataTable entity) {
        
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
        log.info("DataTableServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataTable selectByPrimaryKey(Integer primaryKey){
        log.info("DataTableServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataTable entity){
        log.info("DataTableServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public DataTable selectByUuid (String uuid){
        log.info("DataTableServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }
    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("DataTableServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }
    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataTable entity){
        log.info("DataTableServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }
    /**
    * 根据sourceUuid查询数据(后台)
    * @param sourceUuid  数据源 data_source uuid
    * @return 返回查询数据列表
    */
    @Override
    public List<DataTable> selectBySourceUuid(String sourceUuid){
        log.info("DataTableServiceImpl-selectBySourceUuid: sourceUuid: {}",sourceUuid);
        return dao.selectBySourceUuid(sourceUuid);
    }

    @Override
    public List< ParentListSon<DataTable, DataMetadata> > selectMapBySourceUuid(String sourceUuid) {
        ArrayList<ParentListSon<DataTable, DataMetadata>> list = new ArrayList<>();

        List<DataTable> dataTables = selectBySourceUuid(sourceUuid);
        for (DataTable dataTable : dataTables) {
            ParentListSon<DataTable, DataMetadata> single = new ParentListSon<>();
            String tableUuid = dataTable.getUuid();
            List<DataMetadata> dataMetadatas = dataMetadataDao.selectByTableUuid(tableUuid);
            single.setParent(dataTable);
            single.setSons(dataMetadatas);
            list.add(single);
        }

        return list;
    }

    /**
    * 根据sourceUuid删除数据
    * @param sourceUuid  数据源 data_source uuid
    * */
    @Override
    public void deleteBySourceUuid(String sourceUuid){
        log.info("DataTableServiceImpl-deleteBySourceUuid: sourceUuid: {}",sourceUuid);
        dao.deleteBySourceUuid(sourceUuid);
    }
    /**
    * 根据selected查询数据(后台)
    * @param selected  是否选中 0没有选中 1选中
    * @return 返回查询数据列表
    */
    @Override
    public List<DataTable> selectBySelected(Integer selected){
        log.info("DataTableServiceImpl-selectBySelected: selected: {}",selected);
        return dao.selectBySelected(selected);
    }
    /**
    * 根据selected删除数据
    * @param selected  是否选中 0没有选中 1选中
    * */
    @Override
    public void deleteBySelected(Integer selected){
        log.info("DataTableServiceImpl-deleteBySelected: selected: {}",selected);
        dao.deleteBySelected(selected);
    }
}
