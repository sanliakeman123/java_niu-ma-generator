package com.ancient.service.entity;

public class JdbcDto {
    private String databaseType;
    private String ip;
    private String port;
    private String username;
    private String password;
    private String database;
    private String schema;

    public String getSchema() {
        return schema;
    }

    public JdbcDto setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public JdbcDto setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public JdbcDto setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getPort() {
        return port;
    }

    public JdbcDto setPort(String port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public JdbcDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JdbcDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDatabase() {
        return database;
    }

    public JdbcDto setDatabase(String database) {
        this.database = database;
        return this;
    }
}
