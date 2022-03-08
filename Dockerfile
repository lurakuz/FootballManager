FROM openjdk:11
ADD target/football-manager-mysql.jar football-manager-mysql.jar
EXPOSE 3306
ENTRYPOINT ["java", "-jar", "football-manager-mysql.jar"]
