package com.process.entity.generator;

/**
* 数据源表
* @author 牛马
*/
public class DataSource{
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
	* 数据源名称
	*/
	private String name;
	/**
	* varchar(255)
	* 数据库开发商
	*/
	private String dataBaseAutor;
	/**
	* varchar(255)
	* 数据库地址
	*/
	private String host;
	/**
	* varchar(255)
	* 数据库端口
	*/
	private String port;
	/**
	* varchar(255)
	* 数据库用户名
	*/
	private String user;
	/**
	* varchar(255)
	* 数据库密码
	*/
	private String password;
	/**
	* varchar(255)
	* 数据库名称
	*/
	private String database;

	/**
	 * schema
	 * */
	private String schema;

	public String getSchema() {
		return schema;
	}

	public DataSource setSchema(String schema) {
		this.schema = schema;
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
	public DataSource setId(Integer id){
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
	public DataSource setUuid(String uuid){
		this.uuid = uuid == null ? null : uuid.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据源名称
	*/
	public String getName(){
		return name;
	}
	/**
	* varchar(255)
	* 数据源名称
	*/
	public DataSource setName(String name){
		this.name = name == null ? null : name.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据库开发商
	*/
	public String getDataBaseAutor(){
		return dataBaseAutor;
	}
	/**
	* varchar(255)
	* 数据库开发商
	*/
	public DataSource setDataBaseAutor(String dataBaseAutor){
		this.dataBaseAutor = dataBaseAutor == null ? null : dataBaseAutor.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据库地址
	*/
	public String getHost(){
		return host;
	}
	/**
	* varchar(255)
	* 数据库地址
	*/
	public DataSource setHost(String host){
		this.host = host == null ? null : host.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据库端口
	*/
	public String getPort(){
		return port;
	}
	/**
	* varchar(255)
	* 数据库端口
	*/
	public DataSource setPort(String port){
		this.port = port == null ? null : port.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据库用户名
	*/
	public String getUser(){
		return user;
	}
	/**
	* varchar(255)
	* 数据库用户名
	*/
	public DataSource setUser(String user){
		this.user = user == null ? null : user.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据库密码
	*/
	public String getPassword(){
		return password;
	}
	/**
	* varchar(255)
	* 数据库密码
	*/
	public DataSource setPassword(String password){
		this.password = password == null ? null : password.trim();
		return this;
	}
	/**
	* varchar(255)
	* 数据库名称
	*/
	public String getDatabase(){
		return database;
	}
	/**
	* varchar(255)
	* 数据库名称
	*/
	public DataSource setDatabase(String database){
		this.database = database == null ? null : database.trim();
		return this;
	}
	public DataSource() {}
	public DataSource(DataSource dataSource) {
		this.id = dataSource.id;
		this.uuid = dataSource.uuid;
		this.name = dataSource.name;
		this.dataBaseAutor = dataSource.dataBaseAutor;
		this.host = dataSource.host;
		this.port = dataSource.port;
		this.user = dataSource.user;
		this.password = dataSource.password;
		this.database = dataSource.database;
	}
	/**
	* 清空对象
	*/
	public DataSource setEmpty(){
		this.id = null;
		this.uuid = null;
		this.name = null;
		this.dataBaseAutor = null;
		this.host = null;
		this.port = null;
		this.user = null;
		this.password = null;
		this.database = null;
		return this;
	}
	
}