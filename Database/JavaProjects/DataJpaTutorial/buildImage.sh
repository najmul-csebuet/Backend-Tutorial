#!/bin/bash

./startDb.sh
./gradlew build
docker build . -t onetoone
