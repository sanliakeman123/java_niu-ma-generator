package com.process.service.generator.impl;
import com.process.entity.generator.TemplateConfig;
import com.common.PageInfo;
import com.common.PageQuery;
import com.process.dao.generator.TemplateConfigDao;
import com.process.service.generator.TemplateConfigService;
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
public class TemplateConfigServiceImpl implements TemplateConfigService{
    private static final Logger log = LoggerFactory.getLogger(TemplateConfigServiceImpl.class);
    @Resource
    TemplateConfigDao dao;
    /**
    * 分页查询数据 
    * @param query 筛选条件
    * @param pageQuery 分页条件
    *    
    */
    @Override
    public PageInfo<TemplateConfig> page(TemplateConfig query, PageQuery pageQuery){
        log.info("TemplateConfigServiceImpl-page: query: {}, pageQuery: {}",query,pageQuery);
        long total = dao.count(query);
        if( total == 0L ){
            return new PageInfo<>(new ArrayList<>(), total);
        }
        List<TemplateConfig> list = dao.selectPageByOther(query, pageQuery.make());
        log.info("TemplateConfigServiceImpl-page: list: {}",list);
        return new PageInfo<>(list,total);
    }
    /**
    * 返回数据 （原始数据）
    * @param query 筛选条件 where条件使用
    * 
    * */
    @Override
    public List<TemplateConfig> list(TemplateConfig query){
        log.info("TemplateConfigServiceImpl-list: query: {}",query);
        return dao.selectByOther(query);
    }
    /**
    * 新增/修改数据 
    * @param entity 实体类
    *
    * */
    @Override
    public void save(TemplateConfig entity) {
        
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
        log.info("TemplateConfigServiceImpl-deleteByPrimaryKey: primaryKey: {}",primaryKey);
        dao.deleteByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @Override
    public TemplateConfig selectByPrimaryKey(Integer primaryKey){
        log.info("TemplateConfigServiceImpl-selectByPrimaryKey: primaryKey: {}",primaryKey);
        return dao.selectByPrimaryKey(primaryKey);
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByPrimaryKeySelective(TemplateConfig entity){
        log.info("TemplateConfigServiceImpl-updateByPrimaryKeySelective: entity: {}",entity);
        dao.updateByPrimaryKeySelective(entity);
    } 
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @Override
    public TemplateConfig selectByUuid (String uuid){
        log.info("TemplateConfigServiceImpl-selectByUuid: uuid: {}",uuid);
        return dao.selectByUuid(uuid);
    }
    /**
    * 根据uuid删除数据
    * @param uuid  
    * */
    @Override
    public void deleteByUuid(String uuid){
        log.info("TemplateConfigServiceImpl-deleteByUuid: uuid: {}",uuid);
        dao.deleteByUuid(uuid);
    }
    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @Override
    public void updateByUuid(TemplateConfig entity){
        log.info("TemplateConfigServiceImpl-updateByUuid: entity: {}",entity);
        dao.updateByUuid(entity);
    }
}
