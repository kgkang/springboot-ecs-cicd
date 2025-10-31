FROM amazoncorretto:17-alpine3.19
RUN apk --no-cache add curl
VOLUME /tmp
EXPOSE 8080
ADD build/libs/springboot-ecs-cicd.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]