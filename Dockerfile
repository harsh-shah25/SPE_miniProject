FROM openjdk:17-alpine

WORKDIR /app

COPY calculator/target/calculator-1.0-SNAPSHOT.jar /app/calculator.jar

ENTRYPOINT ["java", "-jar", "calculator.jar"]