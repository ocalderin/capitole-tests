FROM amazoncorretto:17.0.9-alpine3.18

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

CMD ["mvn", "clean", "test"]