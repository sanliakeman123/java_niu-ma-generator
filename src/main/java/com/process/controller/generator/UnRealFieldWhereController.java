package com.process.controller.generator;

import com.process.entity.generator.UnRealFieldWhere;
import com.process.service.generator.UnRealFieldWhereService;
import com.common.PageInfo;
import com.common.PageQuery;
import com.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/unRealFieldWhere")
public class UnRealFieldWhereController {
    private static final Logger log = LoggerFactory.getLogger(UnRealFieldWhereController.class);
    @Autowired
    UnRealFieldWhereService service;

    @PostMapping(value = "/page")
    public Result<PageInfo<UnRealFieldWhere>> page(@RequestBody PageQuery<UnRealFieldWhere> query){
        try{
            return new Result<>(service.page(query.getEntity(),query));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    @PostMapping(value = "/list")
    public Result<List<UnRealFieldWhere>> list(@RequestBody UnRealFieldWhere query){
        try{
            return new Result<>(service.list(query));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    

    @PostMapping(value = "/save")
    public Result<String> save(@RequestBody UnRealFieldWhere entity){
        try{
            service.save(entity);
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
    public Result<UnRealFieldWhere> selectByPrimaryKey(@RequestParam Integer primaryKey){
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
    public Result<String> updateByPrimaryKeySelective(@RequestBody UnRealFieldWhere entity){
        try{
            service.updateByPrimaryKeySelective(entity);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

    /**
    * 根据unRealTableSubUuid查询数据(前台)
    * @param unRealTableSubUuid  虚拟表子表uuid
    * @return 返回查询数据列表
    */
    @PostMapping(value = "/selectByUnRealTableSubUuid")
    public Result<List<UnRealFieldWhere>> selectByUnRealTableSubUuid (@RequestParam String unRealTableSubUuid){
        try{
            return new Result<>(service.selectByUnRealTableSubUuid(unRealTableSubUuid));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    /**
    * 根据uuid查询数据(后台)
    * @param uuid  
    * @return 返回查询数据
    */
    @PostMapping(value = "/selectByUuid")
    public Result<UnRealFieldWhere> selectByUuid (@RequestParam String uuid){
        try{
            return new Result<>(service.selectByUuid(uuid));
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    /**
    * 根据uuid删除数据
    * @param uuid  
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
    public Result<String> updateByUuid(@RequestBody UnRealFieldWhere entity){
        try{
            service.updateByUuid(entity);
            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }



}