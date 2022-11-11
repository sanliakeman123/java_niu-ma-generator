package com.ancient.service.entity;

public class JoinSelectField {
    private String tableName;
    private String fieldName;
    private String alias;
    private String javaType;
    private String jdbcType;

    public String getJdbcType() {
        return jdbcType;
    }

    public JoinSelectField setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
        return this;
    }

    public String getJavaType() {
        return javaType;
    }

    public JoinSelectField setJavaType(String javaType) {
        this.javaType = javaType;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public JoinSelectField setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public JoinSelectField setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public JoinSelectField setAlias(String alias) {
        this.alias = alias;
        return this;
    }
}
