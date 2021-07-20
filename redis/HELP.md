## 前言
### 1. 学习Spring
核心功能
- IoC
- 类型转换系统
- SpEL
- 集成JMX
- DAO异常层级

### 2. 学习NoSQL和键值型数据库

#### 例子
`retwisj` 例子,----一个基于Redis的twitter克隆版，可以在本地运行，也可以部署到云中

### 3. 要求  
   Spring Data Redis 2。x二进制文件需要JDK 8.0及以上，Spring Framework 5.3.9及以上
   在redis版本方面，Redis 2.6.X或更高。Spring Data Redis目前针对最新的4.0版本进行测试

### 4. 额外帮助资源  
* [社区资源(Stack Overflow spring-data tag)](https://stackoverflow.com/questions/tagged/spring-data)
* [专业支持(Pivotal公司)](https://pivotal.io/)

### 5. 跟随开发进展  
* 关于Spring Data源码仓库，night版本，快照组件的信息，请访问spring data主页[Spring Data](https://spring.io/spring-data)
* 您可以通过在Stack Overflow上与[Spring-Data](https://stackoverflow.com/questions/tagged/spring-data)
或[Spring-Data-redis](https://stackoverflow.com/questions/tagged/spring-data-redis)
上的开发人员交互，帮助Spring Data更好地满足Spring社区的需求
* 要了解Spring生态系统的最新消息和公告，请订阅[Spring社区门户](https://spring.io)
* 最后，您可以在Twitter上关注Spring[博客](https://spring.io/blog)
  或项目团队([@SpringData](https://twitter.com/SpringData))

### 6. 新特性

#### * Spring Data Redis 2.6 的新功能

1. 当使用MessageListener作为订阅确认回调时，支持SubscriptionListener
2. ReactiveRedisMessageListenerContainer和ReactiveRedisOperations提供了receiveLater()和listenToLater()方法来await，直到Redis确认订阅
3. 支持redis6.2命令(LPOP/RPOP with count, LMOVE/BLMOVE, COPY, GETEX, GETDEL, GEOSEARCH, GEOSEARCHSTORE, 
   ZPOPMIN, BZPOPMIN, ZPOPMAX, BZPOPMAX, ZMSCORE, ZDIFF, ZDIFFSTORE, ZINTER, ZUNION, HRANDFIELD, ZRANDMEMBER, SMISMEMBER)

#### * Spring Data Redis 2.5 的新功能

1. MappingRedisConverter不再将字节数组转换为集合表示

#### * Spring Data Redis 2.4 的新功能

1. RedisCache 暴露CacheStatics
2. ACL身份验证支持Redis Standalone，Redis Cluster和Master/Replica
3. 使用Jedis时支持Redis Sentinel的密码连接
4. 支持ZREVRANGEBYLEX和ZLEXCOUNT命令
5. 使用Jedis时支持流命令

#### * Spring Data Redis 2.3 的新功能

1. 对Duration和Instant的模板API方法重定义
2. 扩展流命令

#### * Spring Data Redis 2.2 的新功能

1. Redis Streams
2. 重定义union/diff/intersect的设置操作方法以接受单独的键集合
3. 升级到Jedis3
4. 添加对Jedis集群脚本命令的支持

#### * Spring Data Redis 2.1 的新功能

1. 使用Lettuce作为UNIX系统默认套接字连接
2. 使用Lettuce支持主写从读
3. 集成实例查询
4. @TypeAlias支持 Redis 存储库

#### * Spring Data Redis 2.0 的新功能
1. 升级到 Java 8
2. 升级到 Lettuce5.0
3. 删除了对 SRP 和 JRedis 驱动程序的支持
4. 使用 Lettuce 的反应式连接支持
#### * Spring Data Redis 1.9 的新功能
#### * Spring Data Redis 1.8 的新功能
#### * Spring Data Redis 1.7 的新功能
#### * Spring Data Redis 1.6 的新功能
#### * Spring Data Redis 1.5 的新功能

### 7. 依赖
1. 不成熟版本，release train BOM
   <dependencyManagement>
       <dependencies>
           <dependency>
               <groupId>org.springframework.data</groupId>
               <artifactId>spring-data-bom</artifactId>
               <version>2021.1.0-M1</version>
               <scope>import</scope>
               <type>pom</type>
           </dependency>
       </dependencies>
   </dependencyManagement>
2. 成熟版本
   <dependencies>
       <dependency>
           <groupId>org.springframework.data</groupId>
           <artifactId>spring-data-jpa</artifactId>
       </dependency>
   <dependencies>
3. spring boot管理依赖
4. spring framework依赖

## 参考文档

### 8. 介绍

#### 1. 文档结构

Redis支持介绍了Redis模块的特性集。
Redis Repositories引入了对Redis的存储库支持

### 9. 为什么Spring Data Redis

### 10. Redis支持
