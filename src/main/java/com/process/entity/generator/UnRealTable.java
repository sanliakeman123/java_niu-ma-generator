package com.process.entity.generator;
import java.util.Date;
/**
* 虚拟表主表
* @author 牛马
*/
public class UnRealTable{
	/**
	* varchar(255)
	* 虚拟表名
	*/
	private String name;
	/**
	* varchar(255)
	* 数据源uuid
	*/
	private String sourceUuid;
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* 查询需求描述
	*/
	private String describe;
	/**
	* varchar(255)
	* 
	*/
	private String uuid;
	/**
	* int(${field.columnMaxLength})
	* 是否选中 0没有选中 1选中
	*/
	private Integer selected;

	/**
	* varchar(255)
	* 虚拟表名
	*/
	public String getName(){
		return name;
	}
	/**
	* varchar(255)
	* 虚拟表名
	*/
	public UnRealTable setName(String name){
		this.name = name == null ? null : name.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据源uuid
	*/
	public String getSourceUuid(){
		return sourceUuid;
	}
	/**
	* varchar(255)
	* 数据源uuid
	*/
	public UnRealTable setSourceUuid(String sourceUuid){
		this.sourceUuid = sourceUuid == null ? null : sourceUuid.trim();
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
	public UnRealTable setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* 查询需求描述
	*/
	public String getDescribe(){
		return describe;
	}
	/**
	* varchar(255)
	* 查询需求描述
	*/
	public UnRealTable setDescribe(String describe){
		this.describe = describe == null ? null : describe.trim();
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
	public UnRealTable setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* int(${field.columnMaxLength})
	* 是否选中 0没有选中 1选中
	*/
	public Integer getSelected(){
		return selected;
	}
	/**
	* int(${field.columnMaxLength})
	* 是否选中 0没有选中 1选中
	*/
	public UnRealTable setSelected(Integer selected){
		this.selected = selected;
		return this;
	}

	public UnRealTable() {}

	public UnRealTable(UnRealTable unRealTable) {
		this.name = unRealTable.name;
		this.sourceUuid = unRealTable.sourceUuid;
		this.id = unRealTable.id;
		this.describe = unRealTable.describe;
		this.uuid = unRealTable.uuid;
		this.selected = unRealTable.selected;
	}
	/**
	* 清空对象
	*/
	public UnRealTable setEmpty(){
		this.name = null;
		this.sourceUuid = null;
		this.id = null;
		this.describe = null;
		this.uuid = null;
		this.selected = null;
		return this;
	}
}