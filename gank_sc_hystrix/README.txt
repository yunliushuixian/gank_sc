1.启动报错：Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
om.mysql.cj.jdbc.Driver

com.mysql.jdbc.Driver'已经被弃用了、应当使用新的驱动com.mysql.cj.jdbc.Driver

2.The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone
根据报错我们知道这是时间报错，没有指定明确的时区，是因为新版的mysql会询问是否SSL连接，返回一个Boolean值，我们需要手动指定true或者false。所以再次更改配置文件中的 url 满足其要求即可，如下
?characterEncoding=utf-8&serverTimezone=GMT&useSSL=false

3.spring boot jpa-java.lang.IllegalArgumentException: Not a managed type异常问题解决方法
1)实体类没有加上@Entity注解
2)没有按照SpringBoot的约定,默认扫描(application.java 入口类相对的兄弟包及其子包)
 @ComponentScan(basePackages = "com.boot.demo.xxx.*.*")  用于扫描@Controller @Service;
 @EnableJpaRepositories(basePackages = "com.boot.demo.xxx.*.dao") 用于扫描Dao @Repository;
 @EntityScan("com.boot.demo.xxx.*.*") 用于扫描JPA实体类 @Entity

4.pom引入了spring-cloud-starter-hystrix就需要配置eureka server.

5.pom 引入spring-boot-starter-web才会启动内置tomcat，不然运行就是jar包

---
一、使用Hystrix实现断路器
1.步骤
1)maven中引入soring-cloud-starter-hystrix，告诉Maven拉取Spring Cloud Hystrix依赖。没有回退可能是因为hystrix-javanica的版本不一致
2)使用@EnableCircuitBreaker注解注释你的服务引导类，告诉Spring Cloud你将为你的服务使用Hystrix

2.两大类型的Hystrix实现
1)用Hystrix包装所有对数据库的调用
2)使用Hystrix包装Inter-service的调用

3.@HystrixCommand注解被用于使用Hystrix断路器包装方法，Hystrix允许你通过commandProperties属性自定义的断路器的行为。commandProperties属性接受一个HystrixProperty对象数组。
使用execution.isolation.thread.timeoutMilliseconds属性设置最大超时时间。

4.回退处理
fallbackMethod属性在你的类中定义一个单一的功能，如果Hystrix失败该类将会被调用。可以让回退方法从其他数据源读取数据。

5.舱壁模式实现
Hystrix使用了一个线程池代理远程服务的请求，默认情况下，所有Hystrix命令将共享相同的线程池来处理请求。这个线程池有10个线程用于处理远程服务调用。性能较差的服务只会影响同意线程池中其他服务调用。
Hystrix使用@HystrixCommand注解为不同的远程资源创建舱壁。
1) threadPoolKey 属性定义了线程池唯一的名称。
2) threadPoolProperties属性允许你定义和定制的线程池的行为
coreSize:最大线程数
maxQueueSize:在线程池前面定义一个队列，它能使进入的请求排队。一旦请求数量超过队列大小，任何向线程池额外的请求都会失败，直到队列中有空间为止。
-1:一个Java同步队列用来存储所有传入的请求。LinkedBlockingQueue
maxQueueSize属性只能在线程池首次初始化时被设置。Hystrix会允许你用queueSizeRejectionThreshold属性动态改变队列的大小，但是这个属性只能设置在maxQueueSize属性，并且值大于0

自定义线程池的正确大小，Netflix推荐公式：
（当服务正常是每秒的峰值请求*99%平均响应时间）+少量额外线程用于开销


