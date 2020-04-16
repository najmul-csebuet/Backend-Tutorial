#!/bin/bash

useDatabase() {
  databaseLine="spring.datasource.url = jdbc:postgresql://localhost:5432/${1}"
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
port="5432"

nextVersion=$(cat nextVersion.txt)
migrationFileName="${nextVersion}_"

sum=$(( nextVersion + 1 ))
echo ${sum} > nextVersion.txt

for var in "$@"
do
  migrationFileName="${migrationFileName}_${var}"
done
migrationFileName="${migrationFileName}.xml"

# http://postgresguide.com/utilities/psql.html
# psql -h localhost -U username databasename
# psql "dbname=dbhere host=hosthere user=userhere password=pwhere port=5432 sslmode=require"
#psql "dbname=${productionDbName} host=${host} user=${userName} password=${password} port=${port}" -c "DROP DATABASE test_db"
#psql "dbname=${productionDbName} host=${host} user=${userName} password=${password} port=${port}" -c "CREATE DATABASE test_db"
#PGPASSWORD=${password} psql -h localhost -U ${userName} ${productionDbName} -c "DROP DATABASE test_db"
PGPASSWORD=${password} psql -h localhost -U ${userName} ${productionDbName} -c "CREATE DATABASE test_db"
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
#psql "dbname=${productionDbName} host=${host} user=${userName} password=${password} port=${port}" -c "DROP DATABASE test_db"
PGPASSWORD=${password} psql -h localhost -U ${userName} ${productionDbName} -c "DROP DATABASE test_db"
useDatabase ${productionDbName}

enableLiquibase true
generateDDL false
