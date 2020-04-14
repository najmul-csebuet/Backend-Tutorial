#!/bin/bash

useDatabase() {
  databaseLine="spring.datasource.url = jdbc:postgresql://localhost:5432/${1}"
  sed -i "/spring.datasource.url/c ${databaseLine}" ./src/main/resources/application.properties
}

enableFlyway() {
  flywayEnabledLine="spring.flyway.enabled = ${1}"
  sed -i "/spring.flyway.enabled/c ${flywayEnabledLine}" ./src/main/resources/application.properties
}

generateDDL() {
  generateDdlLine="spring.jpa.generate-ddl = ${1}"
  sed -i "/spring.jpa.generate-ddl/c ${generateDdlLine}" ./src/main/resources/application.properties
}

productionDbName="production_db_demo"
userName="test"
password="1234"

pushd ./src/main/resources/db/migration/

nextVersion=$(cat nextVersion.txt)
migrationFileName="V${nextVersion}_"

sum=$(( nextVersion + 1 ))
echo ${sum} > nextVersion.txt

popd

for var in "$@"
do
  migrationFileName="${migrationFileName}_${var}"
done
migrationFileName="${migrationFileName}.sql"

PGPASSWORD=${password} psql ${productionDbName} -U ${userName} -h localhost -c "DROP DATABASE test_db"
PGPASSWORD=${password} psql ${productionDbName} -U ${userName} -h localhost -c "CREATE DATABASE test_db"
useDatabase test_db

enableFlyway false
generateDDL true

#checkLocationLine="spring.flyway.check-location = true"
#sed -i "/spring.flyway.check-location/c ${checkLocationLine}" ./src/main/resources/application.properties

./gradlew clean build
java -jar build/libs/*.jar
#java -jar build/libs/Web-JPA-Postgres-Flyway-Test-0.0.1-SNAPSHOT.jar & echo $! > ./pid.file &
#sleep 5
#ill $(cat ./pid.file)

pushd ./src/main/resources/db/migration
migra --unsafe postgresql://${userName}:${password}@localhost:5432/${productionDbName} postgresql://${userName}:${password}@localhost:5432/test_db > ${migrationFileName}
sed -i '/flyway_schema_history/d' ${migrationFileName}
sed -i '/^$/d' ${migrationFileName}
popd

# Now revert
PGPASSWORD=${password} psql ${productionDbName} -U ${userName} -h localhost -c "DROP DATABASE test_db"
useDatabase ${productionDbName}

enableFlyway true
generateDDL false
