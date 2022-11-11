package com.ancient.service;

import com.process.entity.generator.DataMetadata;
import com.process.entity.generator.DataSource;
import com.process.entity.generator.DataTable;

import java.util.List;

public interface JdbcService {


    void test(DataSource dataSource);

    List<String> databases(DataSource dataSource);

    List<DataTable> dataTables(DataSource dataSource);

    List<DataMetadata> dataMetadatas(DataSource dataSource,String tableName);


    void syncTableField(DataSource dataSource);

    void testUrl(DataSource dataSource);
}
