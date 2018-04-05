FROM nextmetaphor/alpine-java:latest
ADD build/libs/java-microservice-api.war /tmp
CMD ["java", "-jar", "/tmp/java-microservice-api.war"]