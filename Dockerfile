FROM openjdk
LABEL authors="aredicus"
ARG JAR_FILE=target/*.jar
COPY ./target/StudentBot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]