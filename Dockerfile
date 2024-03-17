FROM amazoncorretto:17.0.9-alpine3.18

RUN apk add --update \
    curl jq \
    && rm -rf /var/cache/apk/*

WORKDIR /app

COPY pom.xml mvnw entrypoint.sh ./
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline

COPY src ./src

ENTRYPOINT ["/bin/sh"]
CMD ["entrypoint.sh"]