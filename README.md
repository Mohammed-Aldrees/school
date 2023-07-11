# School Management System

School Management System is a Spring Boot application designed to manage the daily administrative tasks of a school. The application allows the management of teachers, students, books, and courses.

## Features

- Manage teachers: Add, update, delete and view teacher details.
- Manage students: Add, update, delete and view student details.
- Manage books: Add, update, delete and view book details.
- Manage courses: Add, update, delete and view course details.

## Prerequisites

- Java 17 or later
- Maven 3.2+
- PostgreSQL 9.6+

## Installation

First, clone the repository to your local machine:

```
git clone https://github.com/Mohammed-Aldrees/school
```

Navigate to the project directory:

```
cd school 
```

Then, build the project using Maven:

```
mvn clean install
```

## Configuration

This project uses a PostgreSQL database. Before you run the application, make sure to update `src/main/resources/application.properties` file with your own PostgreSQL configurations:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/school
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

## Running the Application

You can run the application from the command line with Maven. Navigate to the root of the project and type:

```
mvn spring-boot:run
```

The application will start running at http://localhost:8080.

## Usage

Once the application is running, you can access the following endpoints:

- `/teachers` - manage teacher information
- `/students` - manage student information
- `/books` - manage book information
- `/courses` - manage course information

## Contributing

Contributions are welcome! For major changes, please open an issue first to discuss what you would like to change.


