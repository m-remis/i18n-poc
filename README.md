![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven%20-8A2BE2)
![Spring](https://img.shields.io/badge/Spring_Boot%20-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL%20-blue)
![Docker](https://img.shields.io/badge/Docker%20-aqua)
![Flyway](https://img.shields.io/badge/Flyway%20-red)

### i18n Service

#### Simple example application - STILL WORK IN PROGRESS

Purpose of service is to allow clients to consume dynamic resources for multiple 
languages and modules.

The idea behind this is to have centralized place with default resources that can be individually overridden.

Let's say you have resources A, B, C and you are mostly satisfied with them, and only want to override B with B+1 value.

All you have to do is override it, call the service with your id (optional) and you will receive resources A, B+1, C

### Format of the i18n resource

| Name          | Type                     |
|---------------|--------------------------|
| id            | varchar(36)              |
| customer_id   | varchar(36)              |
| locale        | varchar(100)             |
| module        | varchar(100)             |
| key           | varchar(255)             |
| message       | varchar(255)             |
| creation_ts   | timestamp without time zone |
| update_ts     | timestamp without time zone |


### Make sure to have installed

* [Git](https://git-scm.com/downloads)

* [JDK 17 or later](https://adoptium.net)

* [Maven 3.8.8 or later](https://maven.apache.org/download.cgi)

* [Docker](https://www.docker.com/)

### DB Structure

Flyway is used for automatic DB migration on application start.

* [Flyway DB Migration scripts](src/main/resources/db/migration)

### Build & Test:

```
mvn clean install
```

### Swagger UI:

This project uses OpenAPI for documentation

Swagger UI can be found under

```
{server-url}/api/i18n-service/swagger-ui/index.html
```

#### For local testing, click [here](http://localhost:8080/api/i18n-service/swagger-ui/index.html) after running the application to redirect to Swagger UI

### YAML API Specification:

Specification can be downloaded under

```
{server-url}/api/i18n-service/v3/api-docs.yaml
```

#### For local testing, click [here](http://localhost:8080/api/i18n-service/v3/api-docs.yaml) after running the application to download the file