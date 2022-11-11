package com.config;

import com.properties.Generator;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = GeneratorDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "generatorSqlSessionFactory")
public class GeneratorDataSourceConfig {

    static final String PACKAGE = "com.process.dao.generator";
    @Resource
    Generator generator;
    @Bean(name = "generatorDataSource")
    public DataSource generatorDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(generator.getUrl());
        config.setUsername(generator.getUsername());
        config.setPassword(generator.getPassword());
        config.setConnectionTestQuery("select 1");
        config.setConnectionTimeout(generator.getConnectionTimeout());
        config.setIdleTimeout(generator.getIdleTimeout());
        config.setMaxLifetime(generator.getMaxLifetime());
        config.setMaximumPoolSize(generator.getMaximumPoolSize());
        config.setMinimumIdle(generator.getMinimumIdle());
        return new HikariDataSource(config);
    }

    @Bean(name = "generatorTransactionManager")
    public DataSourceTransactionManager generatorTransactionManager() {
        return new DataSourceTransactionManager(generatorDataSource());
    }
    @Bean(name = "generatorSqlSessionFactory")
    public SqlSessionFactory generatorSqlSessionFactory(
            @Qualifier("generatorDataSource") DataSource generatorDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(generatorDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("com/process/mapper/generator/*.xml"));
        return sessionFactory.getObject();
    }
}
