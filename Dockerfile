FROM openjdk:17

WORKDIR /app

COPY . /app

# Add this line to give execute permission to mvnw
RUN chmod +x mvnw

RUN ./mvnw package -DskipTests

EXPOSE 8080

CMD ["java", "-jar","target/*.jar"]
