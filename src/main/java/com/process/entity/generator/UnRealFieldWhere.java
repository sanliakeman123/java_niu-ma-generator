package com.process.entity.generator;
import java.util.Date;
/**
* 虚拟表条件字段
* @author 牛马
*/
public class UnRealFieldWhere{
	/**
	* varchar(255)
	* jdbc数据类型
	*/
	private String jdbcType;
	/**
	* varchar(255)
	* 虚拟表子表uuid
	*/
	private String unRealTableSubUuid;
	/**
	* varchar(255)
	* 字段别名
	*/
	private String alias;
	/**
	* int(${field.columnMaxLength})
	* 查询方式
	*/
	private Integer whereType;
	/**
	* varchar(255)
	* 默认值，写死在xml文件
	*/
	private String defaultValue;
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* 
	*/
	private String uuid;
	/**
	* varchar(255)
	* 实体字段uuid
	*/
	private String realFieldUuid;

	/**
	* varchar(255)
	* jdbc数据类型
	*/
	public String getJdbcType(){
		return jdbcType;
	}
	/**
	* varchar(255)
	* jdbc数据类型
	*/
	public UnRealFieldWhere setJdbcType(String jdbcType){
		this.jdbcType = jdbcType == null ? null : jdbcType.trim();
		return this;
	}
	/**
	* varchar(255)
	* 虚拟表子表uuid
	*/
	public String getUnRealTableSubUuid(){
		return unRealTableSubUuid;
	}
	/**
	* varchar(255)
	* 虚拟表子表uuid
	*/
	public UnRealFieldWhere setUnRealTableSubUuid(String unRealTableSubUuid){
		this.unRealTableSubUuid = unRealTableSubUuid == null ? null : unRealTableSubUuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 字段别名
	*/
	public String getAlias(){
		return alias;
	}
	/**
	* varchar(255)
	* 字段别名
	*/
	public UnRealFieldWhere setAlias(String alias){
		this.alias = alias == null ? null : alias.trim();
		return this;
	}
	/**
	* int(${field.columnMaxLength})
	* 查询方式
	*/
	public Integer getWhereType(){
		return whereType;
	}
	/**
	* int(${field.columnMaxLength})
	* 查询方式
	*/
	public UnRealFieldWhere setWhereType(Integer whereType){
		this.whereType = whereType;
		return this;
	}
	/**
	* varchar(255)
	* 默认值，写死在xml文件
	*/
	public String getDefaultValue(){
		return defaultValue;
	}
	/**
	* varchar(255)
	* 默认值，写死在xml文件
	*/
	public UnRealFieldWhere setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue == null ? null : defaultValue.trim();
		return this;
	}
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	public Integer getId(){
		return id;
	}
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	public UnRealFieldWhere setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* 
	*/
	public String getUuid(){
		return uuid;
	}
	/**
	* varchar(255)
	* 
	*/
	public UnRealFieldWhere setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 实体字段uuid
	*/
	public String getRealFieldUuid(){
		return realFieldUuid;
	}
	/**
	* varchar(255)
	* 实体字段uuid
	*/
	public UnRealFieldWhere setRealFieldUuid(String realFieldUuid){
		this.realFieldUuid = realFieldUuid == null ? null : realFieldUuid.trim();
		return this;
	}

	public UnRealFieldWhere() {}

	public UnRealFieldWhere(UnRealFieldWhere unRealFieldWhere) {
		this.jdbcType = unRealFieldWhere.jdbcType;
		this.unRealTableSubUuid = unRealFieldWhere.unRealTableSubUuid;
		this.alias = unRealFieldWhere.alias;
		this.whereType = unRealFieldWhere.whereType;
		this.defaultValue = unRealFieldWhere.defaultValue;
		this.id = unRealFieldWhere.id;
		this.uuid = unRealFieldWhere.uuid;
		this.realFieldUuid = unRealFieldWhere.realFieldUuid;
	}
	/**
	* 清空对象
	*/
	public UnRealFieldWhere setEmpty(){
		this.jdbcType = null;
		this.unRealTableSubUuid = null;
		this.alias = null;
		this.whereType = null;
		this.defaultValue = null;
		this.id = null;
		this.uuid = null;
		this.realFieldUuid = null;
		return this;
	}
}