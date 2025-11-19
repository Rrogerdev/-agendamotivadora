FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
WORKDIR /app
COPY --from=build /app/target/*.jar DeiApplication.jar
EXPOSE 8415
ENTRYPOINT ["java", "-jar", "DeiApplication.jar"]
