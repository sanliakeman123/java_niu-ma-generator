package com.process.entity.generator;

/**
* 数据表名
* @author 牛马
*/
public class DataTable{
	/**
	* int(null)
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
	* 数据源 data_source uuid
	*/
	private String sourceUuid;
	/**
	* int(null)
	* 是否选中 0没有选中 1选中
	*/
	private Integer selected;
	/**
	* varchar(255)
	* 数据表名
	*/
	private String name;
	/**
	* varchar(255)
	* 数据表描述
	*/
	private String describe;
	/**
	* int(null)
	* 
	*/
	public Integer getId(){
		return id;
	}
	/**
	* int(null)
	* 
	*/
	public DataTable setId(Integer id){
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
	public DataTable setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据源 data_source uuid
	*/
	public String getSourceUuid(){
		return sourceUuid;
	}
	/**
	* varchar(255)
	* 数据源 data_source uuid
	*/
	public DataTable setSourceUuid(String sourceUuid){
		this.sourceUuid = sourceUuid == null ? null : sourceUuid.trim();
		return this;
	}
	/**
	* int(null)
	* 是否选中 0没有选中 1选中
	*/
	public Integer getSelected(){
		return selected;
	}
	/**
	* int(null)
	* 是否选中 0没有选中 1选中
	*/
	public DataTable setSelected(Integer selected){
		this.selected = selected;
		return this;
	}
	/**
	* varchar(255)
	* 数据表名
	*/
	public String getName(){
		return name;
	}
	/**
	* varchar(255)
	* 数据表名
	*/
	public DataTable setName(String name){
		this.name = name == null ? null : name.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据表描述
	*/
	public String getDescribe(){
		return describe;
	}
	/**
	* varchar(255)
	* 数据表描述
	*/
	public DataTable setDescribe(String describe){
		this.describe = describe == null ? null : describe.trim();
		return this;
	}
	public DataTable() {}
	public DataTable(DataTable dataTable) {
		this.id = dataTable.id;
		this.uuid = dataTable.uuid;
		this.sourceUuid = dataTable.sourceUuid;
		this.selected = dataTable.selected;
		this.name = dataTable.name;
		this.describe = dataTable.describe;
	}
	/**
	* 清空对象
	*/
	public DataTable setEmpty(){
		this.id = null;
		this.uuid = null;
		this.sourceUuid = null;
		this.selected = null;
		this.name = null;
		this.describe = null;
		return this;
	}
	
}