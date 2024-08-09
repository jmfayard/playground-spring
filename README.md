## What ?
This repository contains a simple CRUD server dealing with insurence policies


## Usage
You need to have **Java 21** installed, [for example with IntelliJ](https://www.jetbrains.com/guide/java/tips/download-jdk/)

Run tests
- `./gradlew test`

Start the server
- `./gradlew test bootRun`


## Try the API

The file `API.http` documents the API exposed by this server

The requests inside `API.md` can be directly run by IntelliJ Ultimate and [VS Code's REST client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)

## Librairies:

- https://start.spring.io/ to scaffold the projet
- Java 21
- Spring Boot
- Spring Web
- Gradle Kotlin for the build system
- Spring JPA / Hibernate
- Jackson to handle JSON
- An in-memory H2 database
- Junit5, mockito and RestAssured for the tests


## Maybe/Later

- Create a `kotlin` branch and convert all the code
- Add GraphQL support  with [Netflix's DGS framework](https://netflix.github.io/dgs/)
- Dockerize and host on https://fly.io/


## Should I use it on production?

No

