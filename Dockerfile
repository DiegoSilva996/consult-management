FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar 
COPY ${JAR_FILE} consults.jar
ENTRYPOINT ["java", "-jar", "/consults.jar"]