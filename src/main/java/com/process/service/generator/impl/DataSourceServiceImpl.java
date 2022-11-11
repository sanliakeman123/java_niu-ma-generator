package com.process.service.generator.impl;
import com.ancient.service.JdbcService;
import com.process.dao.generator.DataMetadataDao;
import com.process.dao.generator.DataTableDao;
import com.process.entity.generator.DataSource;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.DataSourceDao;
import com.process.entity.generator.DataTable;
import com.process.service.generator.DataSourceService;
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
public class DataSourceServiceImpl implements DataSourceService{
    private static final Logger log = LoggerFactory.getLogger(DataSourceServiceImpl.class);
    @Resource
    DataSourceDao dao;

    @Resource
    DataTableDao tableDao;

    @Resource
    DataMetadataDao metadataDao;

    @Resource
    JdbcService jdbcService;

    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<DataSource> page(DataSource query, PageQuery pageQuery){
        log.info("DataSourceServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<DataSource> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("DataSourceServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<DataSource> list(DataSource query){
        log.info("DataSourceServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DataSource entity) {

        String uuid = entity.getUuid();
        if( uuid == null || uuid.length()==0 || uuid.equals("null")){
            dao.insertSelective( entity.setUuid( UUID.randomUUID().toString() ) );
        }else{
            dao.updateByUuid(entity);
        }
        jdbcService.syncTableField(entity);
        
    }
    /**
    * 根据主键删除数据
    * @param primaryKey 主键
    * */
    @Override
    public void deleteByPrimaryKey(Integer primaryKey){
        log.info("DataSourceServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public DataSource selectByPrimaryKey(Integer primaryKey){
        log.info("DataSourceServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(DataSource entity){
        log.info("DataSourceServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public DataSource selectByUuid (String uuid){
        log.info("DataSourceServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }
    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByUuid(String uuid){
        log.info("DataSourceServiceImpl-deleteByUuid: uuid: {}",uuid);

        List<DataTable> dataTables = tableDao.selectBySourceUuid(uuid);
        for (DataTable table : dataTables) {
            metadataDao.deleteByTableUuid(table.getUuid());
        }
        tableDao.deleteBySourceUuid(uuid);
        dao.deleteByUuid(uuid);
    }
    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(DataSource entity){
        log.info("DataSourceServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }
}
