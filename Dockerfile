FROM gradle:5.0-jdk11-alpine AS build


# Set the working directory to the project root
WORKDIR /app

# Copy the gradle
COPY --chown=gradle:gradle . /home/gradle/src

#Run gradle
RUN gradle build --no-daemon


FROM openjdk:11-jre-slim

EXPOSE 8080

# Copy the rest of the project source code
COPY . /JavaRestAssure

# Set the default command to run when the container starts

CMD ["java", "-jar", "build/libs/JavaRestAssure.jar"]

