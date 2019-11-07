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