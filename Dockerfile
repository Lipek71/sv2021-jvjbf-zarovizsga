FROM adoptopenjdk:16-jre-hotspot
WORKDIR /opt/app
COPY target/*.jar sv2021-jvjbf-zarovizsga-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "sv2021-jvjbf-zarovizsga-0.0.1-SNAPSHOT.jar"]