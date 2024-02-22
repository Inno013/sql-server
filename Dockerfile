FROM openjdk:17
ADD target/sqlserver-0.0.1-SNAPSHOT.jar sqlserver.jar

ENTRYPOINT ["java", "-jar", "/sqlserver.jar"]