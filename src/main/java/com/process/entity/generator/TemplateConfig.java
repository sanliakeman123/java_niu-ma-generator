package com.process.entity.generator;

/**
* 模板配置表
* @author 牛马
*/
public class TemplateConfig{
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
	* 模板名称
	*/
	private String name;
	/**
	* varchar(255)
	* java文件命名空间
	*/
	private String namespace;

	/**
	 * varchar(255)
	 * 数据源命名空间
	 */
	private String sourceNamespace;

	/**
	* text(65535)
	* 模板内容
	*/
	private String content;
	/**
	* varchar(255)
	* 生成文件后缀
	*/
	private String fileSuffix;
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
	public TemplateConfig setId(Integer id){
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
	public TemplateConfig setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 模板名称
	*/
	public String getName(){
		return name;
	}
	/**
	* varchar(255)
	* 模板名称
	*/
	public TemplateConfig setName(String name){
		this.name = name == null ? null : name.trim();
		return this;
	}
	/**
	* varchar(255)
	* java文件命名空间
	*/
	public String getNamespace(){
		return namespace;
	}
	/**
	* varchar(255)
	* java文件命名空间
	*/
	public TemplateConfig setNamespace(String namespace){
		this.namespace = namespace == null ? null : namespace.trim();
		return this;
	}
	/**
	 * varchar(255)
	 * 数据源命名空间
	 */
	public String getSourceNamespace() {
		return sourceNamespace;
	}
	/**
	 * varchar(255)
	 * 数据源命名空间
	 */
	public TemplateConfig setSourceNamespace(String sourceNamespace) {
		this.sourceNamespace = sourceNamespace == null ? null : sourceNamespace.trim();
		return this;
	}

	/**
	* text(65535)
	* 模板内容
	*/
	public String getContent(){
		return content;
	}
	/**
	* text(65535)
	* 模板内容
	*/
	public TemplateConfig setContent(String content){
		this.content = content == null ? null : content.trim();
		return this;
	}
	/**
	* varchar(255)
	* 生成文件后缀
	*/
	public String getFileSuffix(){
		return fileSuffix;
	}
	/**
	* varchar(255)
	* 生成文件后缀
	*/
	public TemplateConfig setFileSuffix(String fileSuffix){
		this.fileSuffix = fileSuffix == null ? null : fileSuffix.trim();
		return this;
	}
	public TemplateConfig() {}
	public TemplateConfig(TemplateConfig templateConfig) {
		this.id = templateConfig.id;
		this.uuid = templateConfig.uuid;
		this.name = templateConfig.name;
		this.namespace = templateConfig.namespace;
		this.content = templateConfig.content;
		this.fileSuffix = templateConfig.fileSuffix;
	}
	/**
	* 清空对象
	*/
	public TemplateConfig setEmpty(){
		this.id = null;
		this.uuid = null;
		this.name = null;
		this.namespace = null;
		this.content = null;
		this.fileSuffix = null;
		return this;
	}
	
}