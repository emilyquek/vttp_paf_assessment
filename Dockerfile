FROM eclipse-temurin:23-noble AS builder

WORKDIR /src

COPY mvnw .
COPY pom.xml .

COPY src src
COPY .mvn .mvn

RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true

FROM eclipse-temurin:23-jre-noble

WORKDIR /app

COPY --from=builder /src/target/movies-0.0.1-SNAPSHOT.jar vttp-paf-assessment.jar

ENV SERVER_PORT=8080 SPRING_DATASOURCE_URL=jdbc:mysql://root:mwradwpYEgxnZsmIOCiNxUOjTCMeDLgG@junction.proxy.rlwy.net:13398/railway SPRING_DATASOURCE_USERNAME= SPRING_DATASOURCE_PASSWORD= SPRING_DATA_MONGODB_URI=mongodb://cluster0-shard-00-00.miecl.mongodb.net:27017,cluster0-shard-00-01.miecl.mongodb.net:27017,cluster0-shard-00-02.miecl.mongodb.net:27017/?ssl=true&replicaSet=atlas-qhlqh1-shard-0&authSource=admin&retryWrites=true&w=majority&appName=Cluster0 SPRING_DATA_MONGODB_DATABASE=movies SPRING_DATA_MONGODB_USERNAME= SPRING_DATA_MONGODB_PASSWORD=

EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar vttp-paf-assesment.jar