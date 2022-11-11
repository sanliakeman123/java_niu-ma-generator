package com.process.entity.generator;
import java.util.Date;
/**
* 虚拟表查询字段
* @author 牛马
*/
public class UnRealFieldSelect{
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
	* 虚拟表子表uuid
	*/
	public String getUnRealTableSubUuid(){
		return unRealTableSubUuid;
	}
	/**
	* varchar(255)
	* 虚拟表子表uuid
	*/
	public UnRealFieldSelect setUnRealTableSubUuid(String unRealTableSubUuid){
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
	public UnRealFieldSelect setAlias(String alias){
		this.alias = alias == null ? null : alias.trim();
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
	public UnRealFieldSelect setId(Integer id){
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
	public UnRealFieldSelect setUuid(String uuid){
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
	public UnRealFieldSelect setRealFieldUuid(String realFieldUuid){
		this.realFieldUuid = realFieldUuid == null ? null : realFieldUuid.trim();
		return this;
	}

	public UnRealFieldSelect() {}

	public UnRealFieldSelect(UnRealFieldSelect unRealFieldSelect) {
		this.unRealTableSubUuid = unRealFieldSelect.unRealTableSubUuid;
		this.alias = unRealFieldSelect.alias;
		this.id = unRealFieldSelect.id;
		this.uuid = unRealFieldSelect.uuid;
		this.realFieldUuid = unRealFieldSelect.realFieldUuid;
	}
	/**
	* 清空对象
	*/
	public UnRealFieldSelect setEmpty(){
		this.unRealTableSubUuid = null;
		this.alias = null;
		this.id = null;
		this.uuid = null;
		this.realFieldUuid = null;
		return this;
	}
}