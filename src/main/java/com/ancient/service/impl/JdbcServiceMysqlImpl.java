package com.ancient.service.impl;

import com.ancient.JdbcFactory;
import com.ancient.service.JdbcService;
import com.ancient.service.entity.JdbcDto;
import com.common.dict.JdbcDict;
import com.common.util.StrUtil;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.process.entity.generator.DataMetadata;
import com.process.entity.generator.DataTable;
import com.process.service.generator.DataMetadataService;
import com.process.service.generator.DataTableService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.process.entity.generator.DataSource;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.*;
import java.util.*;

@Service
public class JdbcServiceMysqlImpl implements JdbcService {
    @Resource
    DataMetadataService dataMetadataService;
    @Resource
    DataTableService dataTableService;

    @Override
    public void test(DataSource dataSource) {
        JdbcDto jdbcDto = getDto(dataSource);

        Connection connection = JdbcFactory.initConnection(jdbcDto);
        JdbcFactory.close(connection);
    }

    @Override
    public void testUrl(DataSource dataSource) {
        JdbcDto jdbcDto = getDto(dataSource);
        JdbcFactory.initConnection(jdbcDto);
    }

    private JdbcDto getDto(DataSource dataSource) {
        JdbcDto jdbcDto = new JdbcDto().setDatabaseType(dataSource.getDataBaseAutor())
                .setIp(dataSource.getHost())
                .setPort(dataSource.getPort())
                .setUsername(dataSource.getUser())
                .setPassword(dataSource.getPassword())
                .setDatabase(dataSource.getDatabase())
                .setSchema(dataSource.getSchema());
        return jdbcDto;
    }

    @Override
    public List<String> databases(DataSource dataSource) {
        List<String> list = new ArrayList<>();
        JdbcDto jdbcDto = getDto(dataSource);
        Connection connection = JdbcFactory.initConnection(jdbcDto);
        try{
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getCatalogs();
            while (rs.next()){
                String dataBase = rs.getString(1);
                list.add(dataBase);
            }
            JdbcFactory.close(rs);
        } catch (SQLException e) {
            throw new IllegalArgumentException("查询数据库列表异常");
        }
        JdbcFactory.close(connection);
        return list;
    }

//    @Override
//    public List<DataTable> dataTables(DataSource dataSource) {
//        List<DataTable> tables = new ArrayList<>();
//        JdbcDto jdbcDto = getDto(dataSource);
//        Connection connection = JdbcFactory.initConnection(jdbcDto);
//        try {
//            PreparedStatement statement = connection.prepareStatement("select lower(table_name) name,table_comment tableComment from information_schema.tables where TABLE_SCHEMA='"+dataSource.getDatabase()+"'");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()){
//                DataTable dataTable = new DataTable();
//                String name = rs.getString("name");
//                String tableComment = rs.getString("tableComment");
//                dataTable.setName(name);
//                dataTable.setDescribe(tableComment);
//
//                tables.add(dataTable);
//            }
//            JdbcFactory.close(rs);
//            JdbcFactory.close(statement);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        JdbcFactory.close(connection);
//        return tables;
//    }

    @Override
    public List<DataTable> dataTables(DataSource dataSource) {
        List<DataTable> tables = new ArrayList<>();
        JdbcDto jdbcDto = getDto(dataSource);
        Connection connection = JdbcFactory.initConnection(jdbcDto);
        try {
            ResultSet rs = connection.getMetaData().getTables(connection.getCatalog(), connection.getSchema(), null, null);
            while (rs.next()){
                DataTable dataTable = new DataTable();
                String name = rs.getString("TABLE_NAME").toLowerCase(Locale.ROOT);
                String tableComment = rs.getString("REMARKS");
                dataTable.setName(name);
                dataTable.setDescribe(tableComment);

                tables.add(dataTable);
            }
            JdbcFactory.close(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcFactory.close(connection);
        return tables;
    }

//    @Override
//    public List<DataMetadata> dataMetadatas(DataSource dataSource, String tableName) {
//        List<DataMetadata> metadatas = new ArrayList<>();
//        JdbcDto jdbcDto = getDto(dataSource);
//        Connection connection = JdbcFactory.initConnection(jdbcDto);
//        try {
//            PreparedStatement statement = connection.prepareStatement("SELECT lower(COLUMN_NAME) columnName, COLUMN_DEFAULT defaultValue, IS_NULLABLE isNullable, DATA_TYPE columnDataType, CHARACTER_MAXIMUM_LENGTH columnMaxLength, COLUMN_KEY indexName, EXTRA extra, COLUMN_COMMENT columnComment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '"+ dataSource.getDatabase() +"' AND TABLE_NAME = '"+tableName+"'");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()){
//                DataMetadata dataMetadata = new DataMetadata();
//                dataMetadata.setColumnName(rs.getString("columnName"));
//                String defaultValue = rs.getString("defaultValue");
//                dataMetadata.setDefaultValue(defaultValue==null?"":defaultValue);
//                dataMetadata.setIsNullable(rs.getString("isNullable"));
//                dataMetadata.setColumnDataType(rs.getString("columnDataType"));
//                dataMetadata.setColumnMaxLength(rs.getString("columnMaxLength"));
//                dataMetadata.setIndexName(rs.getString("indexName"));
//                dataMetadata.setExtra(rs.getString("extra"));
//                dataMetadata.setColumnComment(rs.getString("columnComment"));
//                metadatas.add(dataMetadata);
//            }
//            JdbcFactory.close(rs);
//            JdbcFactory.close(statement);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        JdbcFactory.close(connection);
//        return metadatas;
//    }
    @Override
    public List<DataMetadata> dataMetadatas(DataSource dataSource, String tableName) {
        List<DataMetadata> metadatas = new ArrayList<>();
        JdbcDto jdbcDto = getDto(dataSource);
        Connection connection = JdbcFactory.initConnection(jdbcDto);
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getColumns(jdbcDto.getDatabase(), jdbcDto.getSchema(), tableName, null);
            ResultSet primaryKeys = metaData.getPrimaryKeys(jdbcDto.getDatabase(), jdbcDto.getSchema(), tableName);
            Map<String, String> priMap = new HashMap<>();
            while (primaryKeys.next()){
                priMap.put(primaryKeys.getString("COLUMN_NAME"),"");
            }
            while (rs.next()){
                DataMetadata dataMetadata = new DataMetadata();
                String columnName = rs.getString("column_name").toLowerCase(Locale.ROOT);
                dataMetadata.setColumnName(columnName);
                String defaultValue = rs.getString("COLUMN_DEF");
                dataMetadata.setDefaultValue(defaultValue==null?"":defaultValue);
                dataMetadata.setIsNullable(rs.getString("NULLABLE"));
                dataMetadata.setColumnDataType(rs.getString("TYPE_NAME").toLowerCase(Locale.ROOT));
                dataMetadata.setColumnMaxLength(rs.getString("COLUMN_SIZE"));
                if(priMap.containsKey(columnName)){
                    dataMetadata.setIndexName("PRI");
                    dataMetadata.setDefaultValue("");
                }
                dataMetadata.setColumnComment(rs.getString("REMARKS"));
                metadatas.add(dataMetadata);
            }
            JdbcFactory.close(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcFactory.close(connection);
        return metadatas;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void syncTableField(DataSource dataSource) {
        syncTable(dataSource);
        List<DataTable> dataTables = dataTableService.selectBySourceUuid(dataSource.getUuid());
        for (DataTable table : dataTables) {
            syncField(dataSource, table);
        }

    }

    private void syncField(DataSource dataSource,DataTable dataTable){
        List<DataMetadata> newFields = dataMetadatas(dataSource, dataTable.getName());
        String tableUuid = dataTable.getUuid();
        List<DataMetadata> oldFields = dataMetadataService.selectByTableUuid(tableUuid);
        Map<String, DataMetadata> newMap = new HashMap<>();
        Map<String, DataMetadata> oldMap = new HashMap<>();
        for (DataMetadata newField : newFields) {
            newMap.put(newField.getColumnName(),newField);
        }
        for (DataMetadata oldField : oldFields) {
            oldMap.put(oldField.getColumnName(),oldField);
        }

        MapDifference<String, DataMetadata> difference = Maps.difference(newMap, oldMap);
        // 新增字段
        Map<String, DataMetadata> addMap = difference.entriesOnlyOnLeft();
        for (Map.Entry<String, DataMetadata> tableEntry : addMap.entrySet()) {
            DataMetadata value = tableEntry.getValue();
            value.setTableUuid(tableUuid);
            transformField(value);
            dataMetadataService.save(value);
        }
        // 删除字段
        Map<String, DataMetadata> delMap = difference.entriesOnlyOnRight();
        for (Map.Entry<String, DataMetadata> tableEntry : delMap.entrySet()) {
            DataMetadata value = tableEntry.getValue();
            String fieldUuid = value.getUuid();
            dataMetadataService.deleteByUuid(fieldUuid);
        }
        //
        Map<String, MapDifference.ValueDifference<DataMetadata>> difMap = difference.entriesDiffering();

        for (Map.Entry<String, MapDifference.ValueDifference<DataMetadata>> differenceEntry : difMap.entrySet()) {
            MapDifference.ValueDifference<DataMetadata> dif = differenceEntry.getValue();
            DataMetadata leftValue = dif.leftValue();
            DataMetadata rightValue = dif.rightValue();
            String uuid = rightValue.getUuid();
            String whereType = rightValue.getWhereType();
            BeanUtils.copyProperties(leftValue, rightValue);
            transformField(rightValue);
            rightValue.setUuid(uuid);
            rightValue.setWhereType(whereType);
            dataMetadataService.save(rightValue);
        }
    }
    private void syncTable( DataSource dataSource ){
        List<DataTable> newTables = dataTables(dataSource);
        String dataSourceUuid = dataSource.getUuid();
        List<DataTable> oldTables = dataTableService.selectBySourceUuid(dataSourceUuid);
//        Sets.d
        Map<String, DataTable> newTableMap = new HashMap<>();
        Map<String, DataTable> oldTableMap = new HashMap<>();

        for (DataTable newTable : newTables) {
            newTableMap.put(newTable.getName(),newTable);
        }
        for (DataTable oldTable : oldTables) {
            oldTableMap.put(oldTable.getName(),oldTable);
        }

        MapDifference<String, DataTable> difference = Maps.difference(newTableMap, oldTableMap);
        // 新增表
        Map<String, DataTable> addMap = difference.entriesOnlyOnLeft();
        for (Map.Entry<String, DataTable> tableEntry : addMap.entrySet()) {
            DataTable value = tableEntry.getValue();
            value.setSelected(0);
            value.setSourceUuid(dataSourceUuid);
            dataTableService.save(value);
        }
        // 删除表
        Map<String, DataTable> delMap = difference.entriesOnlyOnRight();
        for (Map.Entry<String, DataTable> tableEntry : delMap.entrySet()) {
            DataTable value = tableEntry.getValue();
            String tableUuid = value.getUuid();
            dataMetadataService.deleteByTableUuid(tableUuid);
            dataTableService.deleteByUuid(tableUuid);
        }
        //
        Map<String, MapDifference.ValueDifference<DataTable>> difMap = difference.entriesDiffering();

        for (Map.Entry<String, MapDifference.ValueDifference<DataTable>> differenceEntry : difMap.entrySet()) {
            MapDifference.ValueDifference<DataTable> dif = differenceEntry.getValue();
            DataTable leftValue = dif.leftValue();
            DataTable rightValue = dif.rightValue();
            rightValue.setDescribe(leftValue.getDescribe());
            dataTableService.save(rightValue);
        }

    }

    private void transformField(DataMetadata field){
        field.setFieldName( StrUtil.tToe( field.getColumnName() ) );
        String columnDataType = field.getColumnDataType();
        field.setFieldDataType( JdbcDict.JAVA_DATA_MAP.get(columnDataType) );
        field.setJdbcType( JdbcDict.JAVA_TYPE_MAP.get( field.getFieldDataType() ) );
        String isNullable = field.getIsNullable();
        field.setRequired( "NO".equals(isNullable)? "0" : "1" );
        String extra = field.getExtra();
        if( "on update CURRENT_TIMESTAMP".equals(extra) ){
            field.setDefaultValue("CURRENT_TIMESTAMP");
        }
        String indexName = field.getIndexName();

        if( "PRI".equals(indexName) || JdbcDict.AUTO_INTEGER_MAP.containsKey(columnDataType) ){
            field.setPrimaryKeyFlag("true");
            field.setDefaultValue("");
        }else {
            field.setPrimaryKeyFlag("false");
        }

        field.setWhereType("0");
    }
}
