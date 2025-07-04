# Use an official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Copy the source code
COPY . /app
WORKDIR /app

# Package the application
RUN mvn clean package -DskipTests

# Use a lightweight JDK to run the app
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
