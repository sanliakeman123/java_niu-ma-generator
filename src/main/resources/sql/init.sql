-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: generator
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data_dict`
--

DROP TABLE IF EXISTS `data_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '字典名称 DICT_MAP',
  `describe` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `type` int(2) DEFAULT NULL COMMENT '字典来源类型 0固定值 1 数据表 ',
  `source_uuid` varchar(255) DEFAULT NULL COMMENT '数据源 data_source uuid',
  `table_name` varchar(255) DEFAULT NULL COMMENT 'type为1 关联的数据表名',
  `label` varchar(255) DEFAULT NULL COMMENT 'label name',
  `value` varchar(255) DEFAULT NULL COMMENT 'value name',
  `combination_uuid` varchar(255) DEFAULT NULL COMMENT '字段联合查询主表uuid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='数据字典总表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_dict_static`
--

DROP TABLE IF EXISTS `data_dict_static`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_dict_static` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `dict_uuid` varchar(255) DEFAULT NULL COMMENT 'data_dict uuid',
  `describe` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `label` varchar(255) DEFAULT NULL COMMENT 'label name',
  `value` varchar(255) DEFAULT NULL COMMENT 'value name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COMMENT='数据字典静态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_field_combination`
--

DROP TABLE IF EXISTS `data_field_combination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_field_combination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '查询名称',
  `describe` varchar(255) DEFAULT NULL COMMENT '说明',
  `table_uuid` varchar(255) DEFAULT NULL COMMENT 'data_table uuid',
  `res_type` int(2) DEFAULT NULL COMMENT '返回数据类型 0 单个对象 1 集合',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='字段联合查询主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_field_combination_select`
--

DROP TABLE IF EXISTS `data_field_combination_select`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_field_combination_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `combination_uuid` varchar(255) DEFAULT NULL COMMENT 'data_field_combination uuid',
  `field_name` varchar(255) DEFAULT NULL COMMENT '数据表字段名称',
  `where_type` int(2) DEFAULT NULL COMMENT '查询方式',
  `default_value` varchar(255) DEFAULT NULL COMMENT '默认值，写死在xml文件',
  `jdbc_type` varchar(255) DEFAULT NULL COMMENT 'jdbc数据类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='字段联合查询子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_metadata`
--

DROP TABLE IF EXISTS `data_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_metadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL COMMENT 'uuid唯一标识符',
  `table_uuid` varchar(255) DEFAULT NULL COMMENT 'data_table uuid',
  `column_name` varchar(255) DEFAULT NULL COMMENT '字段名',
  `default_value` varchar(255) DEFAULT NULL COMMENT '默认值',
  `is_nullable` varchar(255) DEFAULT NULL COMMENT '是否可以为空',
  `column_data_type` varchar(255) DEFAULT NULL COMMENT '字段数据类型',
  `column_max_length` varchar(255) DEFAULT NULL COMMENT '长度大小',
  `index_name` varchar(255) DEFAULT NULL COMMENT '索引名称',
  `extra` varchar(255) DEFAULT NULL COMMENT '扩展',
  `column_comment` varchar(2000) DEFAULT NULL COMMENT '字段说明',
  `field_name` varchar(255) DEFAULT NULL COMMENT 'java字段名称',
  `field_data_type` varchar(255) DEFAULT NULL COMMENT 'java字段类型',
  `required` varchar(255) DEFAULT NULL COMMENT '是否必填',
  `primary_key_flag` varchar(255) DEFAULT NULL COMMENT '是否主键',
  `where_type` varchar(255) DEFAULT NULL COMMENT '查询类型',
  `jdbc_type` varchar(255) DEFAULT NULL COMMENT 'mybatis 数据类型',
  `selected` int(11) DEFAULT '0' COMMENT '是否查询字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_id` (`id`),
  KEY `idx_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=51416 DEFAULT CHARSET=utf8 COMMENT='数据字段表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_source`
--

DROP TABLE IF EXISTS `data_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '数据源名称',
  `data_base_autor` varchar(255) DEFAULT NULL COMMENT '数据库开发商',
  `host` varchar(255) DEFAULT NULL COMMENT '数据库地址',
  `port` varchar(255) DEFAULT NULL COMMENT '数据库端口',
  `user` varchar(255) DEFAULT NULL COMMENT '数据库用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '数据库密码',
  `database` varchar(255) DEFAULT NULL COMMENT '数据库名称',
  `schema` varchar(255) DEFAULT NULL COMMENT '模式',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_id` (`id`),
  KEY `idx_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='数据源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_table`
--

DROP TABLE IF EXISTS `data_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `source_uuid` varchar(255) DEFAULT NULL COMMENT '数据源 data_source uuid',
  `selected` int(11) DEFAULT '0' COMMENT '是否选中 0没有选中 1选中',
  `name` varchar(255) DEFAULT NULL COMMENT '数据表名',
  `describe` varchar(255) DEFAULT NULL COMMENT '数据表描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_id` (`id`),
  KEY `idx_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3483 DEFAULT CHARSET=utf8 COMMENT='数据表名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `template_config`
--

DROP TABLE IF EXISTS `template_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '模板名称',
  `namespace` varchar(255) DEFAULT NULL COMMENT 'java文件命名空间',
  `source_namespace` varchar(255) DEFAULT NULL COMMENT '数据源命名空间',
  `content` text COMMENT '模板内容',
  `file_suffix` varchar(255) DEFAULT NULL COMMENT '生成文件后缀',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='模板配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `un_real_field_select`
--

DROP TABLE IF EXISTS `un_real_field_select`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `un_real_field_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `un_real_table_sub_uuid` varchar(255) DEFAULT NULL COMMENT '虚拟表子表uuid',
  `alias` varchar(255) DEFAULT NULL COMMENT '字段别名',
  `real_field_uuid` varchar(255) DEFAULT NULL COMMENT '实体字段uuid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8 COMMENT='虚拟表查询字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `un_real_field_where`
--

DROP TABLE IF EXISTS `un_real_field_where`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `un_real_field_where` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `un_real_table_sub_uuid` varchar(255) DEFAULT NULL COMMENT '虚拟表子表uuid',
  `alias` varchar(255) DEFAULT NULL COMMENT '字段别名',
  `real_field_uuid` varchar(255) DEFAULT NULL COMMENT '实体字段uuid',
  `where_type` int(2) DEFAULT NULL COMMENT '查询方式',
  `default_value` varchar(255) DEFAULT NULL COMMENT '默认值，写死在xml文件',
  `jdbc_type` varchar(255) DEFAULT NULL COMMENT 'jdbc数据类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='虚拟表条件字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `un_real_table`
--

DROP TABLE IF EXISTS `un_real_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `un_real_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `source_uuid` varchar(255) DEFAULT NULL COMMENT '数据源uuid',
  `name` varchar(255) DEFAULT NULL COMMENT '虚拟表名',
  `describe` varchar(255) DEFAULT NULL COMMENT '查询需求描述',
  `selected` int(2) DEFAULT '0' COMMENT '是否选中 0没有选中 1选中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='虚拟表主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `un_real_table_sub`
--

DROP TABLE IF EXISTS `un_real_table_sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `un_real_table_sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `un_real_table_uuid` varchar(255) DEFAULT NULL COMMENT '虚拟表主表uuid',
  `real_table_uuid` varchar(255) DEFAULT NULL COMMENT '真实表uuid',
  `self_field_uuid` varchar(255) DEFAULT NULL COMMENT '关联字段uuid',
  `alias` varchar(255) DEFAULT NULL COMMENT '表别名',
  `weight` int(2) DEFAULT NULL COMMENT '查询方式权重 数值  left == right inner ; left > right left; left < right right ;',
  `join_field_uuid` varchar(255) DEFAULT NULL COMMENT '关联字段uuid',
  `order` int(11) DEFAULT NULL COMMENT '查询顺序 数字越大越靠前',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='虚拟表子表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-11 10:15:17
