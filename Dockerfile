FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
WORKDIR /app
COPY --from=build /app/target/dei-0.0.1-SNAPSHOT.jar DeiApplication.jar
EXPOSE 8419
ENTRYPOINT ["java", "-jar", "DeiApplication.jar"]
