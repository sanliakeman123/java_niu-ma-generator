package com.process.controller.generator;
import com.process.entity.generator.DataMetadata;
import com.process.service.generator.DataMetadataService;
import com.common.PageInfo;
import com.common.PageQuery;
import com.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/dataMetadata")
public class DataMetadataController {
    private static final Logger log = LoggerFactory.getLogger(DataMetadataController.class);
    @Autowired
    DataMetadataService service;
    @PostMapping(value = "/page")
    public Result<PageInfo<DataMetadata>> page(@RequestBody PageQuery<DataMetadata> query){
        try{
            return new Result<>(service.page(query.getEntity(),query));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    @PostMapping(value = "/list")
    public Result<List<DataMetadata>> list(@RequestBody DataMetadata query){
        try{
            return new Result<>(service.list(query));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    
    @PostMapping(value = "/save")
    public Result<String> save(@RequestBody DataMetadata entity){
        try{
            service.save(entity);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

    @PostMapping(value = "/saveList")
    public Result<String> saveList(@RequestBody List<DataMetadata> list){
        try{
            service.saveList(list);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

    /**
    * 根据主键删除数据
    * @param primaryKey 主键
    * */
    @PostMapping(value = "/deleteByPrimaryKey")
    public Result<String> deleteByPrimaryKey(@RequestParam Integer primaryKey){
        try{
            service.deleteByPrimaryKey(primaryKey);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    /**
    * 根据主键查询数据
    * @param primaryKey 主键
    * @return 返回查询数据
    * */
    @PostMapping(value = "/selectByPrimaryKey")
    public Result<DataMetadata> selectByPrimaryKey(@RequestParam Integer primaryKey){
        try{
            return new Result<>(service.selectByPrimaryKey(primaryKey));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    /**
    * 根据主键修改数据
    * @param entity 实体类
    * */
    @PostMapping(value = "/updateByPrimaryKeySelective")
    public Result<String> updateByPrimaryKeySelective(@RequestBody DataMetadata entity){
        try{
            service.updateByPrimaryKeySelective(entity);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
 
 
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  uuid唯一标识符
    * @return 返回查询数据
    */
    @PostMapping(value = "/selectByUuid")
    public Result<DataMetadata> selectByUuid (@RequestParam String uuid){
        try{
            return new Result<>(service.selectByUuid(uuid));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    /**
    * 根据uuid删除数据
    * @param uuid  uuid唯一标识符
    * */
    @PostMapping(value = "/deleteByUuid")
    public Result<String> deleteByUuid(@RequestParam String uuid){
        try{
            service.deleteByUuid(uuid);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    /**
    * 根据uuid修改数据
    * @param entity 实体类
    * */
    @PostMapping(value = "/updateByUuid")
    public Result<String> updateByUuid(@RequestBody DataMetadata entity){
        try{
            service.updateByUuid(entity);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
 
    /**
    * 根据tableUuid查询数据(前台)
    * @param tableUuid  data_table uuid
    * @return 返回查询数据列表
    */
    @PostMapping(value = "/selectByTableUuid")
    public Result<List<DataMetadata>> selectByTableUuid (@RequestParam String tableUuid){
        try{
            return new Result<>(service.selectByTableUuid(tableUuid));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
