
# Adder Application

This is a Spring Boot application that provides a service to generate sum questions and validate the answers provided by clients. The service is configured to run on port 8080 by default.

## Prerequisites

Make sure you have the following software installed:

- [Java 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

## Clone the Repository

To clone the repository, run the following command in the terminal:

```sh
git clone git@github.com:jerrymagal/challenge.git
cd challenge
```

## Building and Running the Application

### Step 1: Build the Project

To build the project and generate the JAR file, run the following command:

```sh
./mvnw clean package -DskipTests
```

### Step 2: Run the Application

To run the application, use the following command:

```sh
java -jar target/challenge-0.0.1-SNAPSHOT.jar
```

The application will be running on port 8080.

## Running Tests

To run all tests (unit and integration), use the following command:

```sh
./mvnw test
```

## Changing the Server Port

By default, the application is configured to run on port 8080. To change the port, edit the file `src/main/resources/application.yml`:

```yaml
spring:
  application:
    name: challenge
  server:
    port: 8080
```

Change the `port` value to the desired port.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── smartequip
│   │           └── challenge
│   │               ├── ChallengeApplication.java
│   │               ├── controller
│   │               │   └── AdderController.java
│   │               ├── model
│   │               │   └── SumRequest.java
│   │               └── service
│   │                   └── AdderService.java
│   └── resources
│       └── application.yml
└── test
    └── java
        └── com
            └── smartequip
                └── challenge
                    ├── ChallengeApplicationTests.java
                    ├── controller
                    │   └── AdderControllerTest.java
                    └── service
                        └── AdderServiceTest.java
```

## Contact

If you have any questions or issues, feel free to open an issue or get in touch.
