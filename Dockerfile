FROM openjdk:8-jdk
ARG JAR_FILE=out/artifacts/test_jar/test.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8187
ENTRYPOINT ["java", "-jar","/app.jar"]
