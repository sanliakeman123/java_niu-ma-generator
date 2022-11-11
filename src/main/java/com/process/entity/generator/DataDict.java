package com.process.entity.generator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* 数据字典总表
* @author 牛马
*/
public class DataDict{
	/**
	* varchar(255)
	* 字典名称 DICT_MAP
	*/
	private String name;
	/**
	* varchar(255)
	* 数据源 data_source uuid
	*/
	private String sourceUuid;
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* 字典描述
	*/
	private String describe;
	/**
	* varchar(255)
	* label name
	*/
	private String label;
	/**
	* int(${field.columnMaxLength})
	* 字典来源类型 0固定值 1 数据表
	*/
	private Integer type;
	/**
	* varchar(255)
	* 
	*/
	private String uuid;
	/**
	* varchar(255)
	* type为1 关联的数据表名
	*/
	private String tableName;
	/**
	* varchar(255)
	* value name
	*/
	private String value;

	private String combinationUuid;

	/**
	* varchar(255)
	* 字典名称 DICT_MAP
	*/
	public String getName(){
		return name;
	}
	/**
	* varchar(255)
	* 字典名称 DICT_MAP
	*/
	public DataDict setName(String name){
		this.name = name == null ? null : name.trim();
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
	public DataDict setSourceUuid(String sourceUuid){
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
	public DataDict setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* 字典描述
	*/
	public String getDescribe(){
		return describe;
	}
	/**
	* varchar(255)
	* 字典描述
	*/
	public DataDict setDescribe(String describe){
		this.describe = describe == null ? null : describe.trim();
		return this;
	}
	/**
	* varchar(255)
	* label name
	*/
	public String getLabel(){
		return label;
	}
	/**
	* varchar(255)
	* label name
	*/
	public DataDict setLabel(String label){
		this.label = label == null ? null : label.trim();
		return this;
	}
	/**
	* int(${field.columnMaxLength})
	* 字典来源类型 0固定值 1 数据表
	*/
	public Integer getType(){
		return type;
	}
	/**
	* int(${field.columnMaxLength})
	* 字典来源类型 0固定值 1 数据表
	*/
	public DataDict setType(Integer type){
		this.type = type;
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
	public DataDict setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* type为1 关联的数据表名
	*/
	public String getTableName(){
		return tableName;
	}
	/**
	* varchar(255)
	* type为1 关联的数据表名
	*/
	public DataDict setTableName(String tableName){
		this.tableName = tableName == null ? null : tableName.trim();
		return this;
	}
	/**
	* varchar(255)
	* value name
	*/
	public String getCombinationUuid(){
		return combinationUuid;
	}
	/**
	* varchar(255)
	* value name
	*/
	public DataDict setCombinationUuid(String combinationUuid){
		this.combinationUuid = combinationUuid == null ? null : combinationUuid.trim();
		return this;
	}

	/**
	 *
	 *
	 */
	public String getValue(){
		return value;
	}
	/**
	 *
	 *
	 */
	public DataDict setValue(String value){
		this.value = value == null ? null : value.trim();
		return this;
	}

	public DataDict() {}

	public DataDict(DataDict dataDict) {
		this.name = dataDict.name;
		this.sourceUuid = dataDict.sourceUuid;
		this.id = dataDict.id;
		this.describe = dataDict.describe;
		this.label = dataDict.label;
		this.type = dataDict.type;
		this.uuid = dataDict.uuid;
		this.tableName = dataDict.tableName;
		this.value = dataDict.value;
		this.combinationUuid = dataDict.combinationUuid;
	}
	/**
	* 清空对象
	*/
	public DataDict setEmpty(){
		this.name = null;
		this.sourceUuid = null;
		this.id = null;
		this.describe = null;
		this.label = null;
		this.type = null;
		this.uuid = null;
		this.tableName = null;
		this.value = null;
		this.combinationUuid = null;
		return this;
	}

    public void check() {
		String regex = "^[A-Z_]+$";
		final Pattern pattern= Pattern.compile(regex);
		final Matcher matcher=pattern.matcher(name);
		if(uuid == null || "".equals(uuid) ){
			if(name==null || "".equals(name)){
				throw new IllegalArgumentException("name不可以为空");
			}
			if(!matcher.find()){
				throw new IllegalArgumentException("name必须是大写字母或者下划线");
			}
		}else{
			if(name!=null){
				if(!matcher.find()){
					throw new IllegalArgumentException("name必须是大写字母或者下划线");
				}
			}
		}
    }
}