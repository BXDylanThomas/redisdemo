redis 是一种开源的，基于内存的、可持久化的、高性能的key-value数据存储系统

# 特点

 - 高性能
- 数据类型丰富（String hash list setsortedSet）
- 支持事务处理
- 批量处理（pipeline机制）
- 支持设置key的有效期
- 支持主从赋值（master-Slave）和故障自动迁移
- 支持大规模集群部署
- 支持put/sub消息通讯机制
- 支持lua脚本实现复杂的数据库操作

# redis能做什么

- 持久化
- 高速缓存
- 消息中间件

##指令，对key操作

插入 set one 1

查询所有的 keys *

删除  del one

得到 get one

是否存在  exists one 

修改key  rename one two

查看类型  type

设置生存周期 	

 - expire 单位是秒
 - perist 让设置了生命周期的，永生
 - ttl  还能活多久
 - 

--默认有16个库

 移动 move one 10

migrate 移动到另一个实例中

## server命令

dbsize 该库中有多少数据

flushdb/flushall 清空数据

save/bgsave

config get

config set

config rewrite  将配置信息持久化

shutdown 关闭服务



~~~
安装
	redis-server.exe --service-install --service-name redis001 --port 6380 --requirepass 12345

卸载
redis-server.exe --service-uninstall


连接客户端
	默认端口是6379
	redis-cli.exe -h localhost -p 6379
~~~



# jar包

jedis.jar



# pipeline

redis 数据库的主要瓶颈是网络速度，其次是内存和CPU的速度和容量

pipeline实现批量发出请求/一次性获取响应，不必每个请求都阻塞等待响应。极大提升了访问效率

# redis 事务处理



# 哨兵

~~~
启动
	redis-server.exe sentinale.conf --sentinel

查看主从配置
	info replication
	
哨兵配置：
	建立一个 sentinal.conf
	
~~~

	port 26386
	protectd-mode no
	dir "e:\\redis\\install-sentinel"
	
	//设置主数据库  1表示至少几个哨兵判断，才算
	sentinel monitor redis6379 127.0.0.1 6379 1
	//主从密码必须相同
	sentinel auth-pass redis6379 12345  //密码
	
	//主节点，多长时间没有反应，表示下线
	sentinel down-fater-milliseconds redis6379 5000
	
	//故障迁移的超时时间
	sentinel failover-timeout redis6379 15000