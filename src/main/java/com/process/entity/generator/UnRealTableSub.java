package com.process.entity.generator;
import java.util.Date;
/**
* 虚拟表子表
* @author 牛马
*/
public class UnRealTableSub{
	/**
	* varchar(255)
	* 表别名
	*/
	private String alias;
	/**
	* int(${field.columnMaxLength})
	* 查询方式权重 数值  left == right inner ; left > right left; left < right right ;
	*/
	private Integer weight;
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* 虚拟表主表uuid
	*/
	private String unRealTableUuid;
	/**
	* varchar(255)
	* 
	*/
	private String uuid;
	/**
	* varchar(255)
	* 真实表uuid
	*/
	private String realTableUuid;
	/**
	* varchar(255)
	* 关联字段uuid
	*/
	private String joinFieldUuid;
	/**
	* int(${field.columnMaxLength})
	* 查询顺序 数字越大越靠前
	*/
	private Integer order;
	/**
	* varchar(255)
	* 关联字段uuid
	*/
	private String selfFieldUuid;

	/**
	* varchar(255)
	* 表别名
	*/
	public String getAlias(){
		return alias;
	}
	/**
	* varchar(255)
	* 表别名
	*/
	public UnRealTableSub setAlias(String alias){
		this.alias = alias == null ? null : alias.trim();
		return this;
	}
	/**
	* int(${field.columnMaxLength})
	* 查询方式权重 数值  left == right inner ; left > right left; left < right right ;
	*/
	public Integer getWeight(){
		return weight;
	}
	/**
	* int(${field.columnMaxLength})
	* 查询方式权重 数值  left == right inner ; left > right left; left < right right ;
	*/
	public UnRealTableSub setWeight(Integer weight){
		this.weight = weight;
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
	public UnRealTableSub setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* 虚拟表主表uuid
	*/
	public String getUnRealTableUuid(){
		return unRealTableUuid;
	}
	/**
	* varchar(255)
	* 虚拟表主表uuid
	*/
	public UnRealTableSub setUnRealTableUuid(String unRealTableUuid){
		this.unRealTableUuid = unRealTableUuid == null ? null : unRealTableUuid.trim();
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
	public UnRealTableSub setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 真实表uuid
	*/
	public String getRealTableUuid(){
		return realTableUuid;
	}
	/**
	* varchar(255)
	* 真实表uuid
	*/
	public UnRealTableSub setRealTableUuid(String realTableUuid){
		this.realTableUuid = realTableUuid == null ? null : realTableUuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 关联字段uuid
	*/
	public String getJoinFieldUuid(){
		return joinFieldUuid;
	}
	/**
	* varchar(255)
	* 关联字段uuid
	*/
	public UnRealTableSub setJoinFieldUuid(String joinFieldUuid){
		this.joinFieldUuid = joinFieldUuid == null ? null : joinFieldUuid.trim();
		return this;
	}
	/**
	* int(${field.columnMaxLength})
	* 查询顺序 数字越大越靠前
	*/
	public Integer getOrder(){
		return order;
	}
	/**
	* int(${field.columnMaxLength})
	* 查询顺序 数字越大越靠前
	*/
	public UnRealTableSub setOrder(Integer order){
		this.order = order;
		return this;
	}
	/**
	* varchar(255)
	* 关联字段uuid
	*/
	public String getSelfFieldUuid(){
		return selfFieldUuid;
	}
	/**
	* varchar(255)
	* 关联字段uuid
	*/
	public UnRealTableSub setSelfFieldUuid(String selfFieldUuid){
		this.selfFieldUuid = selfFieldUuid == null ? null : selfFieldUuid.trim();
		return this;
	}

	public UnRealTableSub() {}

	public UnRealTableSub(UnRealTableSub unRealTableSub) {
		this.alias = unRealTableSub.alias;
		this.weight = unRealTableSub.weight;
		this.id = unRealTableSub.id;
		this.unRealTableUuid = unRealTableSub.unRealTableUuid;
		this.uuid = unRealTableSub.uuid;
		this.realTableUuid = unRealTableSub.realTableUuid;
		this.joinFieldUuid = unRealTableSub.joinFieldUuid;
		this.order = unRealTableSub.order;
		this.selfFieldUuid = unRealTableSub.selfFieldUuid;
	}
	/**
	* 清空对象
	*/
	public UnRealTableSub setEmpty(){
		this.alias = null;
		this.weight = null;
		this.id = null;
		this.unRealTableUuid = null;
		this.uuid = null;
		this.realTableUuid = null;
		this.joinFieldUuid = null;
		this.order = null;
		this.selfFieldUuid = null;
		return this;
	}
}