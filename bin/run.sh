#!/bin/bash


# Fetch the latest of running container
docker ps -l

# The docker rm command is used to remove the container. The $(...) syntax is used to execute the docker ps -l -q command and pass the output (which is the container ID of the latest container) as an argument to the docker rm command.
#This approach will delete the latest running container
docker rm $(docker ps -l -q)

#To remove a Docker image forcefully
docker rmi -f java-automation

# Build the Docker image
docker build -t java-automation .

# Run a new container based on the image, and Run test case command in container
#docker run -it java-automation cd JavaRestAssure && ./gradlew test
docker run -it java-automation /bin/bash




#run all test suit
#./gradlew test

#Run specific test case
#./gradlew test --tests APITest

#to verify shell file RUN -> bin/chmod u+x run.sh