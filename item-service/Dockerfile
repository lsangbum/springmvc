FROM openjdk:11-jdk-slim
ADD /build/libs/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
RUN mkdir -p /app/images/upload
ENV UPLOAD_DIRECTORY=/app/images/upload
