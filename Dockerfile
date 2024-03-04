FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-master-0.0.1-SNAPSHOT.jar coffee-order-master.jar
ENTRYPOINT ["java", "-jar", "coffee-order-master.jar"]