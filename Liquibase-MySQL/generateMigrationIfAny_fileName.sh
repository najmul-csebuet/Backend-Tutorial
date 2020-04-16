#!/bin/bash

useDatabase() {
  databaseLine="spring.datasource.url = jdbc:mysql://localhost:3306/${1}"
  sed -i "/spring.datasource.url/c ${databaseLine}" ./src/main/resources/application.properties
}

enableLiquibase() {
  flywayEnabledLine="spring.liquibase.enabled = ${1}"
  sed -i "/spring.liquibase.enabled/c ${flywayEnabledLine}" ./src/main/resources/application.properties
}

generateDDL() {
  generateDdlLine="spring.jpa.generate-ddl = ${1}"
  sed -i "/spring.jpa.generate-ddl/c ${generateDdlLine}" ./src/main/resources/application.properties
}

productionDbName="production_db_demo"
userName="test"
password="1234"
host="localhost"
port="3306"

nextVersion=$(cat nextVersion.txt)
migrationFileName="${nextVersion}_"

sum=$(( nextVersion + 1 ))
echo ${sum} > nextVersion.txt

for var in "$@"
do
  migrationFileName="${migrationFileName}_${var}"
done
migrationFileName="${migrationFileName}.xml"

docker exec -it mysql-docker mysql -h localhost -u root -proot -e "CREATE DATABASE test_db"
useDatabase test_db
enableLiquibase false
generateDDL true

./gradlew clean build
java -jar build/libs/*.jar
#java -jar build/libs/Web-JPA-Postgres-Flyway-Test-0.0.1-SNAPSHOT.jar & echo $! > ./pid.file &
#sleep 5
#kill $(cat ./pid.file)

lb --changeLogFile="src/main/resources/db/changelog/${migrationFileName}" diffChangeLog

# Now revert
docker exec -it mysql-docker mysql -h localhost -u root -proot -e "DROP DATABASE test_db"
useDatabase ${productionDbName}
enableLiquibase true
generateDDL false
