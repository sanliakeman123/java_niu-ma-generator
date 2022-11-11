package com.common.dict;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class JdbcDict {


    public static final Map<Integer,String> DATABASE_DRIVER_MAP = ImmutableMap.<Integer,String>builder()
            .put(0,"com.mysql.jdbc.Driver")
            .put(1,"com.kingbase8.Driver")
            .build();

    public static final Map<String,String> AUTO_INTEGER_MAP = ImmutableMap.<String,String>builder()
            .put("smallserial","")
            .put("serial","")
            .put("bigserial","")
            .build();

    public static final Map<String,String> JAVA_DATA_MAP = ImmutableMap.<String,String>builder()
            .put("bigint","Integer")
            .put("bit","Integer")
            .put("decimal","Integer")
            .put("int","Integer")
            .put("integer","Integer")
            .put("mediumint","Integer")
            .put("smallint","Integer")
            .put("tinyint","Integer")
            .put("binary","String")
            .put("blob","String")
            .put("char","String")
            .put("enum","String")
            .put("longblob","String")
            .put("longtext","String")
            .put("mediumblob","String")
            .put("mediumtext","String")
            .put("text","String")
            .put("tinyblob","String")
            .put("varbinary","String")
            .put("varchar","String")
            .put("date","Date")
            .put("datetime","Date")
            .put("time","Date")
            .put("timestamp","Date")
            .put("year","Date")
            .put("double","Double")
            .put("numeric","Double")
            .put("real","Double")
            .put("float","Float")
            .put("float4","Float")
            .put("float8","Float")
            .put("tinytext","String")
            .put("int4","Integer")
            .put("int8","Integer")
            .put("bpchar","String")
            .put("bigserial","Integer")
            .put("serial","Integer")
            .put("smallserial","Integer")
            .build();

    public static final Map<String,String> JAVA_TYPE_MAP = ImmutableMap.<String,String>builder()
            .put("String","VARCHAR")
            .put("Integer","INTEGER")
            .put("Date","TIMESTAMP")
            .put("Double","DOUBLE")
            .put("Float","FLOAT")
            .build();
}
