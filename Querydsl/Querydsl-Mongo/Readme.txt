We do not need to create a db initially. It will be auto created once it needs to be accessed.

docker run -d --rm --name mongo-docker -p 27017:27017 -e MONGO_INITDB_DATABASE=testDB -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=1234 mongo:latest --auth

docker run -d --rm --name mongo-docker -p 27017:27017 -e MONGO_INITDB_DATABASE=testDB -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=1234 -v $HOME/docker/volumes/mongodb:/data/db mongo:latest --auth
