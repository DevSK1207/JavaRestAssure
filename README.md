**<u>Environment Setup for JAVA API Project </u>**

To install the Java Development Kit (JDK) on a Mac, you can follow these steps:

- Go to the Oracle website and download the latest version of the JDK for Mac.

- Open the downloaded .dmg file and run the installer package.
https://www.oracle.com/java/technologies/downloads/#jdk19-mac

- Follow the prompts to install the JDK on your computer.

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/gojy4r4o7ssu1zmyclyx.png)

Alternatively, you can also install **JDK** using **Homebrew** package manager by running the command
```
 brew cask install java
```
Once the installation is complete, you can verify that the JDK is installed by opening a terminal window and running the command 
```
java --version 
```
This should display the version of the JDK that is currently installed on your system.
```
java --version                                              ✔  
javac 17.0.5
Which java  
```                                               
![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/sskct5jwb5wn3facdn9z.png)

<u>After that set the Java path in .zshrc file, To follow these steps:</u>

- Open the .zshrc file by running the command This will open 
```
nano ~/.zshrc 
```
the nano text editor with your .zshrc file.

- Add the following lines to the file, replacing the path with the path to your JDK installation. To find Java path run

```
Which java 
```

> export JAVA_HOME=path-to-jdk
> export PATH=$JAVA_HOME/bin:$PATH

- Save and close the .zshrc file by pressing "CTRL+X", then "Y", and then "Enter".

- Reload the .zshrc file by running the command 
```
source .zshrc
```
- Verify the changes by running the command 
```
echo $JAVA_HOME
```
and "echo $PATH" it should display the path you have set in the above step.

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/kl41rp63dyqjsyziqbu7.png)

**<u>Create API Project </u>**

To create a new Gradle project in IntelliJ IDEA, you can follow these steps:

- Open IntelliJ IDEA and navigate to the "Welcome to IntelliJ IDEA" window.

- Click on the "Create New Project" button or choose "File" > "New" > "Project" from the main menu.

- In the "New Project" window, select the "Gradle" option from the list of available project types.

- Select the "Java" or "Kotlin" option as the project's SDK. I select Java.

- In the "Project name" field, enter a name for your project.

- In the "Project location" field, choose a location on your computer where you want to save your project.

- Click on the "Next" button to proceed.

- In the "Project Structure" window, you can configure the settings for your project such as the project SDK, language level, and project format.

- Click on the "Finish" button to create your new Gradle project.

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/yreg7aly0r5pt2siyccx.png)

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/7yk7dsz7eky1eco00r8l.png)

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/ohgbnmwg6p9qn4zd57oo.png)

**<u>Setup Project </u>**

API automation using Java involves writing code to test the functionality and performance of Application Programming Interfaces (APIs). There are several libraries and frameworks available in Java for API automation, including:

> Rest-Assured: A Java library specifically designed for testing RESTful web services. It provides a simple and clean syntax for sending HTTP requests and asserting the responses.

> JUnit: A popular unit testing framework for Java, JUnit can be used to write automated tests for APIs.

> TestNG: Another testing framework for Java, TestNG is similar to JUnit but provides additional features such as support for data-driven testing and parallel test execution.

> Apache HttpClient: A library for sending and receiving HTTP requests and responses. It can be used to send requests to an API and assert the response.

> WireMock: A library for creating HTTP-based API mocks. It can be used to simulate API responses for testing purposes.

> JSON: The JSON object library, such as Gson, provides a way to work with JSON data in Java by providing a set of classes and methods for parsing and generating JSON. Using a JSON library allows you to easily convert between JSON data and Java objects, making it more convenient to work with JSON data in a Java application.

```
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'

    //RestAssured
    testImplementation 'io.rest-assured:rest-assured:4.3.1'

    //TestNG Library
    testImplementation 'org.testng:testng:7.3.0'

    //HttpClient
    implementation 'org.apache.httpcomponents:httpclient:4.5.13'

    //WireMock
    testImplementation 'com.github.tomakehurst:wiremock-jre8:2.27.2'
    testImplementation 'com.github.tomakehurst:wiremock-standalone:2.27.2'

    //JsonObject
    implementation 'com.google.code.gson:gson:2.8.6'
}
```

**<u>Code-base </u>**
Repository link - https://github.com/DevSK1207/API_Automation_and_App_Integratio_Testing_Using_Java 
**<u>Run Test-case </u>**
I'm facing this issue while im run test case from Intellij.

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/htm82f81f19pejz3s4oy.png)
To resolve this issue -> Intellij > settings > Build, execution > 
To run a JUnit test case in Java, you can use the following command:

```
./gradlew test --tests <TestClassName>
```
Can also specify the package name and class name to run the test case

```
./gradlew test --tests packageName.TestClassName
```
Can also run all the test cases for a project by using

```
./gradlew test
```
**<u>Dockerize the Project </u>**

```
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
```
For build docker Image 

```
docker build -t java-automation .
```

Run Docker container,

```
docker run -it java-automation /bin/bash
```
