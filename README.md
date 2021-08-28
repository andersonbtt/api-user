# User API

## Spring Project
Generated from [Spring Initializr](start.spring.io) boilerplate with given link:
@ [Project Boilerplate](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.4&packaging=jar&jvmVersion=11&groupId=co.bittclouds&artifactId=api-user&name=api-user&description=User%20microservice&packageName=co.bittclouds.api-user&dependencies=lombok,web,security,postgresql,data-jpa,mail)

## Database Setup
- For development purpose, run the following command with docker:
```
docker run --name postgres -e POSTGRES_PASSWORD=registration -e POSTGRES_DB=registration -e POSTGRES_USER=registration -d -p 5432:5432 postgres:alpine
```

- For running commands inside your container run:
```
docker exec -it postgres bash
```

- Since it's not possible to exec psql as root, or accessing your database by PSQL, use the following command:
```
psql -U registration -d registration -W registration -h localhost -p 5432
```

- For manual database creation run following commands using psql
```
CREATE DATABASE REGISTRATION;
\l 

```

### References
- Visit [Docker Hub](https://hub.docker.com/_/postgres/) for further info
- And watch [Amigos Code](https://www.youtube.com/watch?v=aHbE3pTyG-Q) Tutorial
- run psl --help for instructions


## JPA Configuration

For ddl-auto configuration read:
- [Vlad Mihalcea article on ddl auto](https://vladmihalcea.com/hibernate-hbm2ddl-auto-schema/)
- [Spring Documentation on database initialization](https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html)

For dialect configuration read:
- [Hibernate ORM documentation](https://hibernate.org/orm/documentation/5.5/)
- [Dialect list @ RedHat Doc](https://access.redhat.com/documentation/en-us/jboss_enterprise_application_platform/6.3/html/development_guide/hibernate_sql_dialects1)

