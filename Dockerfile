FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY . .

RUN chmod +x gradlew

RUN ./gradlew build -x test

FROM eclipse-temurin:21-jre
COPY --from=builder /app/build/libs/ecommerce-0.0.1-SNAPSHOT.jar /app/ecommerce-0.0.1-SNAPSHOT.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/ecommerce-0.0.1-SNAPSHOT.jar"]