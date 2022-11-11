package com.ancient.service.entity;

public class JoinWhereField {
    private String tableAlias;
    private String columnName;
    private String fieldName;
    private String jdbcType;
    private Integer whereType;
    private String javaType;

    public String getJavaType() {
        return javaType;
    }

    public JoinWhereField setJavaType(String javaType) {
        this.javaType = javaType;
        return this;
    }

    public Integer getWhereType() {
        return whereType;
    }

    public JoinWhereField setWhereType(Integer whereType) {
        this.whereType = whereType;
        return this;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public JoinWhereField setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
        return this;
    }

    public String getColumnName() {
        return columnName;
    }

    public JoinWhereField setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public JoinWhereField setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public JoinWhereField setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
        return this;
    }
}
