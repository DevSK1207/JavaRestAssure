FROM openjdk:8-jdk-alpine

# Copy the rest of the project source code
COPY . /JavaRestAssure

# Set the working directory to the project root
WORKDIR /app

#RUN chmod +x gradlew

#RUN gradlew clean build

# Set the default command to run when the container starts
CMD ["java", "-jar", "build/libs/JavaRestAssure.jar"]
