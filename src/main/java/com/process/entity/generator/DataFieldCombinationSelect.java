package com.process.entity.generator;
import java.util.Date;
/**
* 字段联合查询子表
* @author 牛马
*/
public class DataFieldCombinationSelect{
	/**
	* int(${field.columnMaxLength})
	* 查询方式
	*/
	private Integer whereType;
	/**
	* int(${field.columnMaxLength})
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* data_field_combination uuid
	*/
	private String combinationUuid;
	/**
	* varchar(255)
	* 
	*/
	private String uuid;
	/**
	* varchar(255)
	* 数据表字段名称
	*/
	private String fieldName;

	/**
	 * varchar(255)
	 * 默认值，写死在xml文件中
	 * */
	private String defaultValue;


	private String jdbcType;


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
	public DataFieldCombinationSelect setWhereType(Integer whereType){
		this.whereType = whereType;
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
	public DataFieldCombinationSelect setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* data_field_combination uuid
	*/
	public String getCombinationUuid(){
		return combinationUuid;
	}
	/**
	* varchar(255)
	* data_field_combination uuid
	*/
	public DataFieldCombinationSelect setCombinationUuid(String combinationUuid){
		this.combinationUuid = combinationUuid == null ? null : combinationUuid.trim();
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
	public DataFieldCombinationSelect setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据表字段名称
	*/
	public String getFieldName(){
		return fieldName;
	}
	/**
	* varchar(255)
	* 数据表字段名称
	*/
	public DataFieldCombinationSelect setFieldName(String fieldName){
		this.fieldName = fieldName == null ? null : fieldName.trim();
		return this;
	}

	/**
	 * varchar(255)
	 *
	 */
	public String getDefaultValue(){
		return defaultValue;
	}
	/**
	 * varchar(255)
	 *
	 */
	public DataFieldCombinationSelect setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue == null ? null : defaultValue.trim();
		return this;
	}

	/**
	 * varchar(255)
	 *
	 */
	public String getJdbcType(){
		return jdbcType;
	}
	/**
	 * varchar(255)
	 *
	 */
	public DataFieldCombinationSelect setJdbcType(String jdbcType){
		this.jdbcType = jdbcType == null ? null : jdbcType.trim();
		return this;
	}

	public DataFieldCombinationSelect() {}

	public DataFieldCombinationSelect(DataFieldCombinationSelect dataFieldCombinationSelect) {
		this.whereType = dataFieldCombinationSelect.whereType;
		this.id = dataFieldCombinationSelect.id;
		this.combinationUuid = dataFieldCombinationSelect.combinationUuid;
		this.uuid = dataFieldCombinationSelect.uuid;
		this.fieldName = dataFieldCombinationSelect.fieldName;
		this.defaultValue = dataFieldCombinationSelect.defaultValue;
		this.jdbcType = dataFieldCombinationSelect.jdbcType;
	}
	/**
	* 清空对象
	*/
	public DataFieldCombinationSelect setEmpty(){
		this.whereType = null;
		this.id = null;
		this.combinationUuid = null;
		this.uuid = null;
		this.fieldName = null;
		this.defaultValue = null;
		this.jdbcType = null;
		return this;
	}
}