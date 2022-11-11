package com.ancient.service.impl;

import com.ancient.service.MakeService;
import com.ancient.service.entity.JoinSelectField;
import com.ancient.service.entity.JoinUnRealTable;
import com.ancient.service.entity.JoinWhereField;
import com.common.ParentListSon;
import com.common.util.FileUtil;
import com.common.util.StrUtil;
import com.process.entity.generator.*;
import com.process.service.generator.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class MakeServiceImpl implements MakeService {
    @Resource
    DataTableService dataTableService;

    @Resource
    DataMetadataService dataMetadataService;

    @Resource
    DataFieldCombinationService dataFieldCombinationService;

    @Resource
    DataFieldCombinationSelectService dataFieldCombinationSelectService;

    @Resource
    TemplateConfigService templateConfigService;

    @Resource
    DataDictService dataDictService;

    @Resource
    UnRealTableService unRealTableService;

    @Resource
    UnRealTableSubService unRealTableSubService;

    @Resource
    UnRealFieldSelectService unRealFieldSelectService;

    @Resource
    UnRealFieldWhereService unRealFieldWhereService;

    @Resource
    DataDictStaticService dataDictStaticService;
    @Override
    public String makeFiles(String sourceUuid, String templateUuid) throws IOException, InterruptedException {
        TemplateConfig templateConfig = templateConfigService.selectByUuid(templateUuid);
        if(templateConfig != null){
            String content = templateConfig.getContent();
            // 用户主目录
            String userHome = System.getProperties().getProperty("user.home");
            // 分隔符
            String fileSeparator = File.separator;

            String uuid = UUID.randomUUID().toString();
            String file = uuid + ".vm";

            String fileName = userHome + fileSeparator + file;
            Path path = Paths.get(fileName);

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write(content);
            }

            VelocityEngine velocityEngine = new VelocityEngine();
            Properties p = new Properties();
            p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, userHome);
            velocityEngine.init(p);

            List<DataTable> dataTables = dataTableService.list(new DataTable().setSourceUuid(sourceUuid).setSelected(1));
            Template template = velocityEngine.getTemplate(file);
            String parentFilePath = userHome + fileSeparator + uuid;
            if(dataTables.size()==0){
                return null;
            }
            for (DataTable table : dataTables) {
                List<ParentListSon< DataFieldCombination, DataFieldCombinationSelect >> parentSons =  new ArrayList<>();

                String tableUuid = table.getUuid();
                List<DataMetadata> fields = dataMetadataService.selectByTableUuid(tableUuid);
                List<DataFieldCombination> dataFieldCombinations = dataFieldCombinationService.selectByTableUuid(tableUuid);
                for (DataFieldCombination combination : dataFieldCombinations) {
                    ParentListSon<DataFieldCombination, DataFieldCombinationSelect> parentSon = new ParentListSon<>();
                    String combinationUuid = combination.getUuid();
                    List<DataFieldCombinationSelect> combinationSelects = dataFieldCombinationSelectService.selectByCombinationUuid(combinationUuid);
                    parentSon.setParent(combination).setSons(combinationSelects);
                    parentSons.add(parentSon);
                }
                List<DataMetadata> simpleFields = new ArrayList<>();
                for (DataMetadata field : fields) {
                    if(field.getSelected().compareTo(1)==0){
                        simpleFields.add(field);
                    }
                }

                VelocityContext context = new VelocityContext();
                context.put("namespace",templateConfig.getNamespace());
                context.put("sourceNamespace",templateConfig.getSourceNamespace());
                context.put("tableRemarks",table.getDescribe());
                String tableName = table.getName();
                String entityName = StrUtil.firstCharToUp(StrUtil.tToe(tableName));
                context.put("entityName", entityName);
                context.put("fieldList", fields );
                context.put("simpleFields", simpleFields );
                context.put("tableName", tableName);
                context.put("strUtil", StrUtil.class);
                context.put("combinationList",parentSons);
                String generatorFileName = parentFilePath + fileSeparator + entityName + templateConfig.getFileSuffix() ;

                File generatorFile = new File(generatorFileName);

                File parentFile = generatorFile.getParentFile();
                if(!parentFile.exists()){
                    parentFile.mkdirs();
                }

                if(!generatorFile.exists()){
                    generatorFile.createNewFile();
                }

                FileOutputStream outStream = new FileOutputStream(generatorFile);
                OutputStreamWriter writer = new OutputStreamWriter(outStream, StandardCharsets.UTF_8);
                BufferedWriter sw = new BufferedWriter( writer );
                if ( template != null){
                    template.merge(context, sw);
                }

                sw.flush();
                sw.close();
                outStream.close();
            }
            String zipname = parentFilePath + ".zip";
            FileUtil.filetozip(parentFilePath, zipname);
            FileUtil.deleteFile(new File(fileName));
            FileUtil.deleteFile(new File(parentFilePath));
            return zipname;
        }
        return null;
    }
    @Override
    public String makeDictFile(String sourceUuid, String templateUuid) throws IOException, InterruptedException {
        TemplateConfig templateConfig = templateConfigService.selectByUuid(templateUuid);
        if(templateConfig != null){
            String content = templateConfig.getContent();
            // 用户主目录
            String userHome = System.getProperties().getProperty("user.home");
            // 分隔符
            String fileSeparator = File.separator;

            String uuid = UUID.randomUUID().toString();
            String file = uuid + ".vm";

            String fileName = userHome + fileSeparator + file;
            Path path = Paths.get(fileName);

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write(content);
            }

            VelocityEngine velocityEngine = new VelocityEngine();
            Properties p = new Properties();
            p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, userHome);
            velocityEngine.init(p);

            Template template = velocityEngine.getTemplate(file);
            String parentFilePath = userHome + fileSeparator + uuid;

            List<DataDict> dictList = dataDictService.selectBySourceUuid(sourceUuid);
            List<ParentListSon<DataDict, DataDictStatic>> parentSonArrayList = new ArrayList<>();
            HashMap<String, Object> tableMap = new HashMap<>();
            for (DataDict dataDict : dictList) {
                ParentListSon<DataDict, DataDictStatic> parentSon = new ParentListSon<>();
                Integer type = dataDict.getType();
                parentSon.setParent(dataDict);
                switch (type){
                    case 0:
                        String dictUuid = dataDict.getUuid();
                        List<DataDictStatic> dataDictStaticList = dataDictStaticService.selectByDictUuid(dictUuid);
                        parentSon.setSons(dataDictStaticList);
                        break;
                    case 1:
                        String label = dataDict.getLabel();
                        DataMetadata dataMetadata = dataMetadataService.selectByUuid(label);
                        dataDict.setLabel(dataMetadata.getFieldName());
                        String value = dataDict.getValue();
                        dataMetadata = dataMetadataService.selectByUuid(value);
                        dataDict.setValue(dataMetadata.getFieldName());
                        String tableUuid = dataDict.getTableName();

                        DataTable dataTable = dataTableService.selectByUuid(tableUuid);
                        tableMap.put(dataTable.getName(),"");
                        dataDict.setTableName(dataTable.getName());

                        String combinationUuid = dataDict.getCombinationUuid();
                        DataFieldCombination combination = dataFieldCombinationService.selectByUuid(combinationUuid);
                        String daoMethodName = combination.getName();
                        dataDict.setCombinationUuid(daoMethodName);

                        break;
                    default:
                        break;
                }
                parentSonArrayList.add(parentSon);
            }
            String fileSuffix = templateConfig.getFileSuffix();
            String generatorFileName = parentFilePath + fileSeparator  + fileSuffix;
            VelocityContext context = new VelocityContext();
            context.put("namespace",templateConfig.getNamespace());
            context.put("sourceNamespace",templateConfig.getSourceNamespace());
            context.put("strUtil", StrUtil.class);
            context.put("dictList", parentSonArrayList);
            context.put("className", fileSuffix);
            context.put("tableMap", tableMap);
            File generatorFile = new File(generatorFileName);
            File parentFile = generatorFile.getParentFile();
            if(!parentFile.exists()){
                parentFile.mkdirs();
            }

            if(!generatorFile.exists()){
                generatorFile.createNewFile();
            }

            FileOutputStream outStream = new FileOutputStream(generatorFile);
            OutputStreamWriter writer = new OutputStreamWriter(outStream, StandardCharsets.UTF_8);
            BufferedWriter sw = new BufferedWriter( writer );
            if ( template != null){
                template.merge(context, sw);
            }
            sw.flush();
            sw.close();
            outStream.close();

            String zipname = parentFilePath + ".zip";
            FileUtil.filetozip(parentFilePath, zipname);
            FileUtil.deleteFile(new File(fileName));
            FileUtil.deleteFile(new File(parentFilePath));
            return zipname;
        }
        return null;
    }
    @Override
    public String makeJoinFile(String sourceUuid, String templateUuid) throws IOException, InterruptedException {
        TemplateConfig templateConfig = templateConfigService.selectByUuid(templateUuid);
        if(templateConfig != null){
            String content = templateConfig.getContent();
            // 用户主目录
            String userHome = System.getProperties().getProperty("user.home");
            // 分隔符
            String fileSeparator = File.separator;
            String uuid = UUID.randomUUID().toString();
            String file = uuid + ".vm";
            String fileName = userHome + fileSeparator + file;
            Path path = Paths.get(fileName);
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write(content);
            }
            VelocityEngine velocityEngine = new VelocityEngine();
            Properties p = new Properties();
            p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, userHome);
            velocityEngine.init(p);
            VelocityContext context = new VelocityContext();
            List<UnRealTable> unRealTables = unRealTableService.list(new UnRealTable().setSourceUuid(sourceUuid).setSelected(1));
            Template template = velocityEngine.getTemplate(file);
            String parentFilePath = userHome + fileSeparator + uuid;
            if(unRealTables.size()==0){
                return null;
            }
            for (UnRealTable unRealTable : unRealTables) {
                String unRealTableName = unRealTable.getName();

                String entityName = StrUtil.firstCharToUp(StrUtil.tToe(unRealTableName));
                String unRealTableUuid = unRealTable.getUuid();
                List<UnRealTableSub> unRealTableSubs = unRealTableSubService.selectByUnRealTableUuid(unRealTableUuid);
                List<JoinSelectField> joinSelectFields = new ArrayList<>();
                List<JoinUnRealTable> joinUnRealTables = new ArrayList<>();
                List<JoinWhereField> joinWhereFields = new ArrayList<>();
                int size = unRealTableSubs.size();
                int tableCount = 0;
                for (UnRealTableSub unRealTableSub : unRealTableSubs) {
                    DataTable dataTable = dataTableService.selectByUuid(unRealTableSub.getRealTableUuid());
                    String unRealTableSubUuid = unRealTableSub.getUuid();
                    List<UnRealFieldSelect> unRealFieldSelects = unRealFieldSelectService.selectByUnRealTableSubUuid(unRealTableSubUuid);
                    String tableName = dataTable.getName();
                    for (UnRealFieldSelect unRealFieldSelect : unRealFieldSelects) {
                        DataMetadata dataMetadata = dataMetadataService.selectByUuid(unRealFieldSelect.getRealFieldUuid());
                        joinSelectFields.add(
                                new JoinSelectField()
                                        .setTableName(unRealTableSub.getAlias())
                                        .setFieldName(dataMetadata.getColumnName())
                                        .setAlias(unRealFieldSelect.getAlias())
                                        .setJavaType(dataMetadata.getFieldDataType())
                                        .setJdbcType(dataMetadata.getJdbcType())
                        );
                    }
                    UnRealTableSub cur = unRealTableSubs.get(tableCount);
                    if(size > tableCount + 1){

                        UnRealTableSub next = unRealTableSubs.get(tableCount+1);
                        Integer curWeight = cur.getWeight();
                        Integer nextWeight = next.getWeight();
                        int i = curWeight.compareTo(nextWeight);
                        String joinType = "inner join";
                        if(i < 0){
                            joinType = "right join";
                        } else if( i > 0){
                            joinType = "left join";
                        }
                        DataTable dataTable1 = dataTableService.selectByUuid(next.getRealTableUuid());
                        DataMetadata selfDataMetadata = dataMetadataService.selectByUuid(unRealTableSub.getSelfFieldUuid());
                        DataMetadata joinDataMetadata = dataMetadataService.selectByUuid(unRealTableSub.getJoinFieldUuid());
                        joinUnRealTables.add(
                                new JoinUnRealTable()
                                        .setTableName(tableName)
                                        .setAlias(unRealTableSub.getAlias())
                                        .setJoinType(joinType)
                                        .setSelfField(selfDataMetadata.getColumnName())
                                        .setJoinAlias(next.getAlias())
                                        .setJoinField(joinDataMetadata.getColumnName())
                                        .setJoinTableName(dataTable1.getName())
                        );
                    }
                    List<UnRealFieldWhere> unRealFieldWheres = unRealFieldWhereService.selectByUnRealTableSubUuid(unRealTableSubUuid);
                    for (UnRealFieldWhere unRealFieldWhere : unRealFieldWheres) {
                        DataMetadata dataMetadata = dataMetadataService.selectByUuid(unRealFieldWhere.getRealFieldUuid());
                        joinWhereFields.add(
                                new JoinWhereField()
                                        .setTableAlias(cur.getAlias())
                                        .setColumnName(dataMetadata.getColumnName())
                                        .setFieldName(unRealFieldWhere.getAlias())
                                        .setJdbcType(unRealFieldWhere.getJdbcType())
                                        .setWhereType(unRealFieldWhere.getWhereType())
                                        .setJavaType(dataMetadata.getFieldDataType())
                        );

                    }
                    tableCount++;
                }
                context.put("strUtil", StrUtil.class);
                context.put("namespace",templateConfig.getNamespace());
                context.put("sourceNamespace",templateConfig.getSourceNamespace());
                context.put("tableRemarks",unRealTable.getDescribe());
                context.put("entityName", entityName);
                context.put("joinSelectFields", joinSelectFields );
                context.put("joinUnRealTables", joinUnRealTables);
                context.put("joinWhereFields",joinWhereFields);



                String generatorFileName = parentFilePath + fileSeparator + entityName + templateConfig.getFileSuffix() ;

                File generatorFile = new File(generatorFileName);

                File parentFile = generatorFile.getParentFile();
                if(!parentFile.exists()){
                    parentFile.mkdirs();
                }

                if(!generatorFile.exists()){
                    generatorFile.createNewFile();
                }

                FileOutputStream outStream = new FileOutputStream(generatorFile);
                OutputStreamWriter writer = new OutputStreamWriter(outStream, StandardCharsets.UTF_8);
                BufferedWriter sw = new BufferedWriter( writer );
                if ( template != null){
                    template.merge(context, sw);
                }

                sw.flush();
                sw.close();
                outStream.close();
            }
            String zipname = parentFilePath + ".zip";
            FileUtil.filetozip(parentFilePath, zipname);
            FileUtil.deleteFile(new File(fileName));
            FileUtil.deleteFile(new File(parentFilePath));
            return zipname;
        }
        return null;
    }

}
