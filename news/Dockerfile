FROM adoptopenjdk:16-jre-hotspot
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} news.jar
ENTRYPOINT ["java", "-jar", "news.jar"]