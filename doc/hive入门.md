# hive入门


## 前提 ##

- 安装并配置好jdk
- 安装并配置好hadoop
- 安装并启动mysql

## 下载hive并解压 ##

    本例子下载的是1.0.1

## 配置 ##

- 配置环境变量
 <pre>
	vi /etc/profile
	增加如下内容：
	export HIVE_HOME=/opt/hive-1.0.1
	export PATH=$HIVE_HOME/bin:$PATH  
	保存并退出;
	source /etc/profile
</pre>

- hive-config.sh
   <pre>
	增加如下内容：
	export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-1.7.0.85.x86_64
	export HIVE_HOME=/opt/hive-1.0.1
	export HADOOP_HOME=/opt/hadoop-1.2.1
   </pre>
- mysql准备

	新建一个hive库，并设置编码为latin1（自己设置为utf8有点问题）
	新建hive用户，并且设置密码为hive （如果是练习，也可一不设置，直接使用root用户）

- 配置mysql

	拷贝一份hive-default.xml.template 命名为hive-site.xml
	在hive-site增加如下内容，并保证数据库连接url，用户名，密码都正确。仔细检查hive-site.xml中是否已经存在name与想面相同的property配置节点，如果存在，删除即可
   ``` xml
    <property>     
	  <name>javax.jdo.option.ConnectionURL</name>  
	  <value>jdbc:mysql://127.0.0.1:3306/hive?createDatabaseIfNotExist=true</value>     
	  <description>JDBC connect string FOR a JDBC metastore</description>     
	</property>     
	<property>  
	  <name>javax.jdo.option.ConnectionDriverName</name>  
	  <value>com.mysql.jdbc.Driver</value>     
	  <description>Driver class name FOR a JDBC metastore</description> 
	</property>     
	<property>  
	  <name>javax.jdo.option.ConnectionUserName</name>  
	  <value>hive</value>     
	  <description>username TOUSE against metastore database</description>     
	</property>     
	<property>     
	  <name>javax.jdo.option.ConnectionPassword</name>  
	  <value>hive</value>     
	  <description>password TOUSE against metastore database</description>     
	</property>
	```
- 其他配置
	
- 针对hive-site.xml，我使用其默认配置的工作目录，总是会报目录通配符错误。为了方便测试，直接将所有的${system:java.io.tmpdir}/${system:user.name} 替换为/tmp/hive_test；本例子中并没有配置与hadoop相关的配置，因为我直接在本地运行的hadoop，所以，默认找本地的配置
- 输入hive，也可一输入hive -hiveconf hive.root.logger=DEBUG,console 来进行测试，可以方便的看到很多打印信息。
- 输入 create table test(key string); 创建一个表。
- 输入show tables 查看到刚才创建的test表。


## 参考资料 ##

- [hive的Specified key was too long; max key length is 767 bytes问题解决 ](http://blog.csdn.net/lengzijian/article/details/7045538)
 
