FROM eclipse-temurin:17.0.6_10-jdk

LABEL org.opencontainers.image.title="aui-star"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.authors="tarixxiv"

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:auistar
ENV SPRINT_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV AUI_PLANET_URL=http://localhost:8081

EXPOSE 8080

COPY target/aui-star-${VERSION}.jar /opt/aui-star/aui-star.jar


CMD ["java", "-jar", "/opt/aui-star/aui-star.jar"]