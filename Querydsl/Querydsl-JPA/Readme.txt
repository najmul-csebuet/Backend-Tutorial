To run a postgres docker instance:
-----------------------------------
docker pull postgres
docker run -d --rm -p 5432:5432 --name pg-docker -e POSTGRES_DB=testDB -e POSTGRES_USER=test -e POSTGRES_PASSWORD=1234 postgres:latest


Then add datasource info in application.properties file:
--------------------------------------------------------
spring.datasource.url = jdbc:postgresql://localhost:5432/testDB
spring.datasource.username = test
spring.datasource.password = 1234

