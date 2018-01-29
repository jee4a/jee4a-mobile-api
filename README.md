# jee4a-mobile-api

springcloud 客户端负载均衡之 ribbon，断熔器 之 hystrix<br>

1、<br>
前提：<br>
需启动服务注册中心：jee4a-eureka-server <br>
启动两个user-service实例: jee4a-user-service <br>

2、<br>
打包：<br>
cd jee4a-mobile-api<br>
mvn clean install -D maven.test.skip=true<br>


3、<br>
启动：<br>
java -jar target/jee4a-mobile-api-0.0.1-SNAPSHOT.jar<br>

4、<br>
访问：<br>
负载均衡：  http://localhost:8080/userinfo/1<br>
断熔器：http://localhost:8080/userinfo-1/1<br>


