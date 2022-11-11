package com.process.entity.generator;

/**
* 数据字段表
* @author 牛马
*/
public class DataMetadata{
	/**
	* int(null)
	* 
	*/
	private Integer id;
	/**
	* varchar(255)
	* uuid唯一标识符
	*/
	private String uuid;
	/**
	* varchar(255)
	* data_table uuid
	*/
	private String tableUuid;
	/**
	* varchar(255)
	* 字段名
	*/
	private String columnName;
	/**
	* varchar(255)
	* 默认值
	*/
	private String defaultValue;
	/**
	* varchar(255)
	* 是否可以为空
	*/
	private String isNullable;
	/**
	* varchar(255)
	* 字段数据类型
	*/
	private String columnDataType;
	/**
	* varchar(255)
	* 长度大小
	*/
	private String columnMaxLength;
	/**
	* varchar(255)
	* 索引名称
	*/
	private String indexName;
	/**
	* varchar(255)
	* 扩展
	*/
	private String extra;
	/**
	* varchar(255)
	* 字段说明
	*/
	private String columnComment;
	/**
	* varchar(255)
	* java字段名称
	*/
	private String fieldName;
	/**
	* varchar(255)
	* java字段类型
	*/
	private String fieldDataType;
	/**
	* varchar(255)
	* 是否必填
	*/
	private String required;
	/**
	* varchar(255)
	* 是否主键
	*/
	private String primaryKeyFlag;
	/**
	* varchar(255)
	* 查询类型
	*/
	private String whereType;
	/**
	* varchar(255)
	* mybatis 数据类型
	*/
	private String jdbcType;


	private Integer selected;

	public Integer getSelected() {
		return selected;
	}

	public DataMetadata setSelected(Integer selected) {
		this.selected = selected;
		return this;
	}

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
	public DataMetadata setId(Integer id){
		this.id = id;
		return this;
	}
	/**
	* varchar(255)
	* uuid唯一标识符
	*/
	public String getUuid(){
		return uuid;
	}
	/**
	* varchar(255)
	* uuid唯一标识符
	*/
	public DataMetadata setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
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
	public DataMetadata setTableUuid(String tableUuid){
		this.tableUuid = tableUuid == null ? null : tableUuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 字段名
	*/
	public String getColumnName(){
		return columnName;
	}
	/**
	* varchar(255)
	* 字段名
	*/
	public DataMetadata setColumnName(String columnName){
		this.columnName = columnName == null ? null : columnName.trim();
		return this;
	}
	/**
	* varchar(255)
	* 默认值
	*/
	public String getDefaultValue(){
		return defaultValue;
	}
	/**
	* varchar(255)
	* 默认值
	*/
	public DataMetadata setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue == null ? null : defaultValue.trim();
		return this;
	}
	/**
	* varchar(255)
	* 是否可以为空
	*/
	public String getIsNullable(){
		return isNullable;
	}
	/**
	* varchar(255)
	* 是否可以为空
	*/
	public DataMetadata setIsNullable(String isNullable){
		this.isNullable = isNullable == null ? null : isNullable.trim();
		return this;
	}
	/**
	* varchar(255)
	* 字段数据类型
	*/
	public String getColumnDataType(){
		return columnDataType;
	}
	/**
	* varchar(255)
	* 字段数据类型
	*/
	public DataMetadata setColumnDataType(String columnDataType){
		this.columnDataType = columnDataType == null ? null : columnDataType.trim();
		return this;
	}
	/**
	* varchar(255)
	* 长度大小
	*/
	public String getColumnMaxLength(){
		return columnMaxLength;
	}
	/**
	* varchar(255)
	* 长度大小
	*/
	public DataMetadata setColumnMaxLength(String columnMaxLength){
		this.columnMaxLength = columnMaxLength == null ? null : columnMaxLength.trim();
		return this;
	}
	/**
	* varchar(255)
	* 索引名称
	*/
	public String getIndexName(){
		return indexName;
	}
	/**
	* varchar(255)
	* 索引名称
	*/
	public DataMetadata setIndexName(String indexName){
		this.indexName = indexName == null ? null : indexName.trim();
		return this;
	}
	/**
	* varchar(255)
	* 扩展
	*/
	public String getExtra(){
		return extra;
	}
	/**
	* varchar(255)
	* 扩展
	*/
	public DataMetadata setExtra(String extra){
		this.extra = extra == null ? null : extra.trim();
		return this;
	}
	/**
	* varchar(255)
	* 字段说明
	*/
	public String getColumnComment(){
		return columnComment;
	}
	/**
	* varchar(255)
	* 字段说明
	*/
	public DataMetadata setColumnComment(String columnComment){
		this.columnComment = columnComment == null ? null : columnComment.trim();
		return this;
	}
	/**
	* varchar(255)
	* java字段名称
	*/
	public String getFieldName(){
		return fieldName;
	}
	/**
	* varchar(255)
	* java字段名称
	*/
	public DataMetadata setFieldName(String fieldName){
		this.fieldName = fieldName == null ? null : fieldName.trim();
		return this;
	}
	/**
	* varchar(255)
	* java字段类型
	*/
	public String getFieldDataType(){
		return fieldDataType;
	}
	/**
	* varchar(255)
	* java字段类型
	*/
	public DataMetadata setFieldDataType(String fieldDataType){
		this.fieldDataType = fieldDataType == null ? null : fieldDataType.trim();
		return this;
	}
	/**
	* varchar(255)
	* 是否必填
	*/
	public String getRequired(){
		return required;
	}
	/**
	* varchar(255)
	* 是否必填
	*/
	public DataMetadata setRequired(String required){
		this.required = required == null ? null : required.trim();
		return this;
	}
	/**
	* varchar(255)
	* 是否主键
	*/
	public String getPrimaryKeyFlag(){
		return primaryKeyFlag;
	}
	/**
	* varchar(255)
	* 是否主键
	*/
	public DataMetadata setPrimaryKeyFlag(String primaryKeyFlag){
		this.primaryKeyFlag = primaryKeyFlag == null ? null : primaryKeyFlag.trim();
		return this;
	}
	/**
	* varchar(255)
	* 查询类型
	*/
	public String getWhereType(){
		return whereType;
	}
	/**
	* varchar(255)
	* 查询类型
	*/
	public DataMetadata setWhereType(String whereType){
		this.whereType = whereType == null ? null : whereType.trim();
		return this;
	}
	/**
	* varchar(255)
	* mybatis 数据类型
	*/
	public String getJdbcType(){
		return jdbcType;
	}
	/**
	* varchar(255)
	* mybatis 数据类型
	*/
	public DataMetadata setJdbcType(String jdbcType){
		this.jdbcType = jdbcType == null ? null : jdbcType.trim();
		return this;
	}
	public DataMetadata() {}
	public DataMetadata(DataMetadata dataMetadata) {
		this.id = dataMetadata.id;
		this.uuid = dataMetadata.uuid;
		this.tableUuid = dataMetadata.tableUuid;
		this.columnName = dataMetadata.columnName;
		this.defaultValue = dataMetadata.defaultValue;
		this.isNullable = dataMetadata.isNullable;
		this.columnDataType = dataMetadata.columnDataType;
		this.columnMaxLength = dataMetadata.columnMaxLength;
		this.indexName = dataMetadata.indexName;
		this.extra = dataMetadata.extra;
		this.columnComment = dataMetadata.columnComment;
		this.fieldName = dataMetadata.fieldName;
		this.fieldDataType = dataMetadata.fieldDataType;
		this.required = dataMetadata.required;
		this.primaryKeyFlag = dataMetadata.primaryKeyFlag;
		this.whereType = dataMetadata.whereType;
		this.jdbcType = dataMetadata.jdbcType;
	}
	/**
	* 清空对象
	*/
	public DataMetadata setEmpty(){
		this.id = null;
		this.uuid = null;
		this.tableUuid = null;
		this.columnName = null;
		this.defaultValue = null;
		this.isNullable = null;
		this.columnDataType = null;
		this.columnMaxLength = null;
		this.indexName = null;
		this.extra = null;
		this.columnComment = null;
		this.fieldName = null;
		this.fieldDataType = null;
		this.required = null;
		this.primaryKeyFlag = null;
		this.whereType = null;
		this.jdbcType = null;
		return this;
	}
	
}