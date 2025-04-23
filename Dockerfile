# Build stage
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Create non-root user
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Copy the built artifact from build stage
COPY --from=build /app/target/*.jar app.jar

# Environment variables
ENV SPRING_PROFILES_ACTIVE=prod

# Set file ownership to non-root user
RUN chown appuser:appuser /app/app.jar

# Set security configurations
RUN mkdir -p /app/logs && \
    chown -R appuser:appuser /app/logs && \
    chmod -R 755 /app

# Switch to non-root user
USER appuser

# Set security options
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom -Dfile.encoding=UTF-8 -Duser.timezone=UTC"

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]