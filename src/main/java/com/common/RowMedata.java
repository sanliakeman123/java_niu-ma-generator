package com.common;

public class RowMedata {

    /**
     * 反射字段
     * */
    private String field;

    /**
     * col 索引
     * */
    private int columnIndex;

    /**
     * 中文描述
     * */
    private String describe;

    /**
     * 导入是否必填
     * */
    private Boolean importRequired;


    public Boolean getImportRequired() {
        return importRequired;
    }

    public void setImportRequired(Boolean importRequired) {
        this.importRequired = importRequired;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }
}
