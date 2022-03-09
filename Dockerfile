FROM openjdk:11
ADD target/footballManager*.jar football-manager-mysql.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "football-manager-mysql.jar"]
