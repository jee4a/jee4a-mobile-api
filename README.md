# jee4a-ribbon-consumer

springcloud 客户端负载均衡之 ribbon<br>

1、<br>
前提：<br>
需启动服务注册中心：jee4a-eureka-server <br>
启动两个user-service实例: jee4a-user-service <br>

2、<br>
打包：<br>
cd jee4a-ribbon-consumer<br>
mvn clean install -D maven.test.skip=true<br>


3、<br>
启动：<br>
java -jar target/jee4a-ribbon-consumer-0.0.1-SNAPSHOT.jar<br>

4、<br>
访问：<br>
http://localhost:8080/userinfo/1<br>


