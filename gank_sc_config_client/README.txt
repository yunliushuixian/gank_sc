1.Could not locate PropertySource: Invalid URL: localhost:8888
spring.cloud.config,uri: localhost:8888 (X)
spring.cloud.config.uri: https://localhost:8888 (√)

2.spring.application.profiles.active = dev,实际日志
2019-11-06 17:49:48.445  INFO 41820 --- [           main] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=personservice, profiles=[default], label=null, version=null, state=null;
No active profile set, falling back to default profiles: default;?

应该为spring.profiles.active=dev;也可以在idea里面配置启动属性.
