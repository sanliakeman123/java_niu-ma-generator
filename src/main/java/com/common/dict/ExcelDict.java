package com.common.dict;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class ExcelDict {
    /**
     * 不可变map excel 标头和字段映射 导入
     * */
    public static final Map<String,String> stepImportMap = ImmutableMap.<String,String>builder()
            .put("序号","serialNo")
            .put("实施编码","taskCode")
            .put("事项名称","taskName")
            .put("环节顺序","stepNum")
            .put("环节名称","stepName")
            .put("机构名称","orgName")
            .put("处理人","processor")
            .build();

    /**
     * 考勤导入必填字段 不写会报错
     * */

    public static final Map<String,Boolean>  stepImportRequiredMap = ImmutableMap.<String,Boolean>builder()
            .put("序号",true)
            .put("实施编码",true)
            .put("事项名称",true)
            .put("环节顺序",true)
            .put("环节名称",true)
            .put("机构名称",true)
            .put("处理人",true)
            .build();

    /**
     * 二级标头
     * */
    public static final Map<String,String> stepTwoHeader = ImmutableMap.<String,String>builder()
            .put("序号","serialNo")
            .put("实施编码","taskCode")
            .put("事项名称","taskName")
            .put("环节顺序","stepNum")
            .put("环节名称","stepName")
            .put("机构名称","orgName")
            .put("处理人","processor")
            .build();

}
