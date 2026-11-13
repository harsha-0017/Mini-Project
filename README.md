# CareConnect

CareConnect is a Java 21 Spring Boot application that helps people find free health camps in Karnataka.

## Features

- Search upcoming camps by city and category.
- Camp details with venue, date, organizer, capacity, and contact.
- Responsive Thymeleaf UI with sample camps for Bengaluru, Mysuru, Mangaluru, and Hubballi.
- Organizer login and validated camp publishing form.
- H2 for local development; change the datasource properties for PostgreSQL deployment.

## Run locally

Install Java 21 and Maven, then run:

```bash
mvn spring-boot:run
```

Open http://localhost:8080. The demo organizer account is `organizer` / `careconnect`.