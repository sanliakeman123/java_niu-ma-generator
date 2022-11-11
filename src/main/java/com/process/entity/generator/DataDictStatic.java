package com.process.entity.generator;
import java.util.Date;
/**
* 数据字典静态表
* @author 牛马
*/
public class DataDictStatic{
	/**
	* varchar(255)
	* data_dict uuid
	*/
	private String dictUuid;
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
	* varchar(255)
	* 
	*/
	private String uuid;
	/**
	* varchar(255)
	* value name
	*/
	private String value;

	/**
	* varchar(255)
	* data_dict uuid
	*/
	public String getDictUuid(){
		return dictUuid;
	}
	/**
	* varchar(255)
	* data_dict uuid
	*/
	public DataDictStatic setDictUuid(String dictUuid){
		this.dictUuid = dictUuid == null ? null : dictUuid.trim();
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
	public DataDictStatic setId(Integer id){
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
	public DataDictStatic setDescribe(String describe){
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
	public DataDictStatic setLabel(String label){
		this.label = label == null ? null : label.trim();
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
	public DataDictStatic setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* value name
	*/
	public String getValue(){
		return value;
	}
	/**
	* varchar(255)
	* value name
	*/
	public DataDictStatic setValue(String value){
		this.value = value == null ? null : value.trim();
		return this;
	}

	public DataDictStatic() {}

	public DataDictStatic(DataDictStatic dataDictStatic) {
		this.dictUuid = dataDictStatic.dictUuid;
		this.id = dataDictStatic.id;
		this.describe = dataDictStatic.describe;
		this.label = dataDictStatic.label;
		this.uuid = dataDictStatic.uuid;
		this.value = dataDictStatic.value;
	}
	/**
	* 清空对象
	*/
	public DataDictStatic setEmpty(){
		this.dictUuid = null;
		this.id = null;
		this.describe = null;
		this.label = null;
		this.uuid = null;
		this.value = null;
		return this;
	}

	public void check() {
		if( (uuid==null || "".equals(uuid) ) && value==null ){
			throw new IllegalArgumentException("新增value不能为空");
		}

		if( (uuid==null || "".equals(uuid) ) && label==null ){
			throw new IllegalArgumentException("新增label不能为空");
		}


	}
}