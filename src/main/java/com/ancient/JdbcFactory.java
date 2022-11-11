package com.ancient;

import com.ancient.service.entity.JdbcDto;
import com.common.dict.JdbcDict;

import java.sql.*;
import java.util.Properties;

public class JdbcFactory {
    // 初始化连接
    public static Connection initConnection(JdbcDto jdbcDto) {
        Connection connection = null;

        Integer databaseType = Integer.parseInt(jdbcDto.getDatabaseType());
        if(!JdbcDict.DATABASE_DRIVER_MAP.containsKey(databaseType)){
            throw new IllegalArgumentException("不存在的数据库Driver");
        }
        String driver = JdbcDict.DATABASE_DRIVER_MAP.get(databaseType);
        String url = null;

        String targerSchema = jdbcDto.getSchema();
        switch (databaseType){
            case 0:
                url = "jdbc:mysql://"+ jdbcDto.getIp() + ":" + jdbcDto.getPort() + "/"+jdbcDto.getDatabase()+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true&useSSL=false&nullNamePatternMatchesAll=true";
                break;
            case 1:
                url = "jdbc:kingbase8://"+ jdbcDto.getIp() +":" + jdbcDto.getPort() + "/" + jdbcDto.getDatabase() +  "?currentSchema=" + targerSchema;
                break;
            default:
                throw new IllegalArgumentException("目前支持mysql");
        }

        Properties properties = new Properties();
        /**
         * 数据库备注信息
         * */
        properties.put("remarksReporting","true");
        properties.put("useInformationSchema","true");
        properties.put("user",jdbcDto.getUsername());
        properties.put("password",jdbcDto.getPassword());
        try{
            // 加载驱动
            Class.forName(driver);
            // 获取connection
            connection = DriverManager.getConnection(url, properties);
            String schema = connection.getSchema();
            if(targerSchema!=null && !targerSchema.equals("") && !targerSchema.equals(schema)){
                throw new IllegalArgumentException("schema不匹配");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("driver不存在");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("数据库不否存在");
        }

        return connection;
    }

    // close
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    public static void close(Statement statement){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    public static void close(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
