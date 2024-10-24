FROM openjdk:17-slim
WORKDIR /app

# Copie o arquivo JAR gerado pelo Gradle para dentro do container
COPY build/libs/test-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]