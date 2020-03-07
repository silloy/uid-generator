UidGenerator - Spring Boot
==========================

基于[baidu/uid-generator](https://github.com/baidu/uid-generator)改造的spring-boot版本，默认使用`spring boot 2.1`版本实现开箱即用，同时提供rest-api供其他服务调用，修改数据库连接池为HikariCP

### 配置要点

```yaml
spring:
  datasource:
    url: jdbc:mysql://xx.xx.xx.xx:3306/xx?serverTimezone=GMT%2b8:00&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&useSSL=false
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: xx
    password: xx
    type: com.zaxxer.hikari.HikariDataSource
    hikari:
      maximum-pool-size: 15
      pool-name: uid
      connection-timeout: 3000
      idle-timeout: 60000
      max-lifetime: 176500
      auto-commit: true

uid:
  config:
    time-bits: 28
    worker-bits: 22
    seq-bits: 13
    epoch-str: '2016-05-20'
    cached: false  # 是否采用高性能模式，默认为false

mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.slf4j.Slf4jImpl
    mapUnderscoreToCamelCase: true
  mapper-locations: classpath:mapper/*.xml
```

### API

http://127.0.0.1:7890/uid