FROM eclipse-temurin:17.0.6_10-jdk

LABEL org.opencontainers.image.title="aui-planet"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.authors="tarixxiv"


ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:auiplanet
ENV SPRINT_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/aui-planet-${VERSION}.jar /opt/aui-planet/aui-planet.jar

CMD ["java", "-jar", "/opt/aui-planet/aui-planet.jar"]