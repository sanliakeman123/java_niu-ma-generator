package com.ancient.service.entity;

public class JoinUnRealTable {
    private String tableName;
    private String selfField;
    private String alias;
    private String joinType;
    private String joinField;
    private String joinTableName;
    private String joinAlias;


    public String getSelfField() {
        return selfField;
    }

    public JoinUnRealTable setSelfField(String selfField) {
        this.selfField = selfField;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public JoinUnRealTable setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public JoinUnRealTable setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getJoinType() {
        return joinType;
    }

    public JoinUnRealTable setJoinType(String joinType) {
        this.joinType = joinType;
        return this;
    }

    public String getJoinField() {
        return joinField;
    }

    public JoinUnRealTable setJoinField(String joinField) {
        this.joinField = joinField;
        return this;
    }

    public String getJoinTableName() {
        return joinTableName;
    }

    public JoinUnRealTable setJoinTableName(String joinTableName) {
        this.joinTableName = joinTableName;
        return this;
    }

    public String getJoinAlias() {
        return joinAlias;
    }

    public JoinUnRealTable setJoinAlias(String joinAlias) {
        this.joinAlias = joinAlias;
        return this;
    }
}
