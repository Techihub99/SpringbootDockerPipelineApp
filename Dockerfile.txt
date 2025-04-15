FROM openjdk:17
EXPOSE 8080
ADD target/springboot-javatechi-docker.jar springboot-javatechi-docker.jar
ENTRYPOINT ["java","-jar","/springboot-javatechi-docker.jar"]