FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/mcp-server-test-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-Dspring.ai.mcp.server.stdio=true", "-jar", "app.jar"]