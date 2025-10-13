FROM eclipse-temurin:17-jre as runtime
WORKDIR /app
COPY target/spring-boot.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]