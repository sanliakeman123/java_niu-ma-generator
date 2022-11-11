package com.ancient.service.controller;

import com.ancient.service.JdbcService;
import com.common.Result;
import com.process.entity.generator.DataMetadata;
import com.process.entity.generator.DataTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.process.entity.generator.DataSource;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {
    @Resource
    JdbcService jdbcService;

    @PostMapping("databases")
    public Result<List<String>> databases(@RequestBody DataSource dataSource){
        try{
            jdbcService.test(dataSource);
            return new Result<>(jdbcService.databases(dataSource));
        }catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

    @PostMapping("testUrl")
    public Result<String> testUrl(@RequestBody DataSource dataSource){
        try{
            jdbcService.testUrl(dataSource);
            return new Result<>("");
        }catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

    @PostMapping("tables")
    public Result<List<DataTable>> tables(@RequestBody DataSource dataSource){
        try{
            return new Result<>(jdbcService.dataTables(dataSource));
        }catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }
    @PostMapping("dataMetadatas")
    public Result<List<DataMetadata>> dataMetadatas(@RequestBody DataSource dataSource){
        try{
            return new Result<>(jdbcService.dataMetadatas(dataSource,"data_metadata"));
        }catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

    @PostMapping("syncTables")
    public Result<String> syncTables(@RequestBody DataSource dataSource){
        try{
            jdbcService.syncTableField(dataSource);
            return new Result<>("");
        }catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

}
