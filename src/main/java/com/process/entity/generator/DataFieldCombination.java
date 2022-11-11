package com.process.entity.generator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* 字段联合查询主表
* @author 牛马
*/
public class DataFieldCombination{
	/**
	* int(${field.columnMaxLength})
	* 返回数据类型 0 单个对象 1 集合
	*/
	private Integer resType;
	/**
	* varchar(255)
	* 查询名称
	*/
	private String name;
	/**
	* varchar(255)
	* data_table uuid
	*/
	private String tableUuid;
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* 说明
	*/
	private String describe;
	/**
	* varchar(255)
	* 
	*/
	private String uuid;

	/**
	* int(${field.columnMaxLength})
	* 返回数据类型 0 单个对象 1 集合
	*/
	public Integer getResType(){
		return resType;
	}
	/**
	* int(${field.columnMaxLength})
	* 返回数据类型 0 单个对象 1 集合
	*/
	public DataFieldCombination setResType(Integer resType){
		this.resType = resType;
		return this;
	}
	/**
	* varchar(255)
	* 查询名称
	*/
	public String getName(){
		return name;
	}
	/**
	* varchar(255)
	* 查询名称
	*/
	public DataFieldCombination setName(String name){
		this.name = name == null ? null : name.trim();
		return this;
	}
	/**
	* varchar(255)
	* data_table uuid
	*/
	public String getTableUuid(){
		return tableUuid;
	}
	/**
	* varchar(255)
	* data_table uuid
	*/
	public DataFieldCombination setTableUuid(String tableUuid){
		this.tableUuid = tableUuid == null ? null : tableUuid.trim();
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
	public DataFieldCombination setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* 说明
	*/
	public String getDescribe(){
		return describe;
	}
	/**
	* varchar(255)
	* 说明
	*/
	public DataFieldCombination setDescribe(String describe){
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
	public DataFieldCombination setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}



	public void check(){
		String regex = "^[a-zA-Z_]+$";
		final Pattern pattern= Pattern.compile(regex);
		final Matcher matcher=pattern.matcher(name);
		if(uuid == null || "".equals(uuid) ){
			if(name==null || "".equals(name)){
				throw new IllegalArgumentException("name不可以为空");
			}
			if(!matcher.find()){
				throw new IllegalArgumentException("name必须是英文字符或下划线");
			}
		}else{
			if(name!=null){
				if(!matcher.find()){
					throw new IllegalArgumentException("name必须是英文字符或下划线");
				}
			}
		}
	}

	public DataFieldCombination() {}

	public DataFieldCombination(DataFieldCombination dataFieldCombination) {
		this.resType = dataFieldCombination.resType;
		this.name = dataFieldCombination.name;
		this.tableUuid = dataFieldCombination.tableUuid;
		this.id = dataFieldCombination.id;
		this.describe = dataFieldCombination.describe;
		this.uuid = dataFieldCombination.uuid;
	}
	/**
	* 清空对象
	*/
	public DataFieldCombination setEmpty(){
		this.resType = null;
		this.name = null;
		this.tableUuid = null;
		this.id = null;
		this.describe = null;
		this.uuid = null;
		return this;
	}
}