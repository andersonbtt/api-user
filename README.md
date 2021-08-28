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

## Spring Security Configuration

For UserDetail interface, checkout:
- [Spring API](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/UserDetails.html)
- [Spring Doc](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [Baeldung Reference](https://www.baeldung.com/spring-security-authentication-with-a-database)

## Lombok

For Lombok annotation guide, visit:
- [Baeldung Introduction](https://www.baeldung.com/intro-to-project-lombok)
- [Lombok features](https://projectlombok.org/features/all)
- [Getter and Setter](https://projectlombok.org/features/GetterSetter)
- [EqualsAndHashCode](https://projectlombok.org/features/EqualsAndHashCode)
- [NoArgsConstructor](https://projectlombok.org/features/constructor)

## JPA Reference

Basics:
- [Baeldung on Defining JPA Entities](https://www.baeldung.com/jpa-entities)
- [Spring Docs on Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Hibernate Docs on Mapping Entities](https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html)
- [Oracle Docs on Mapping Entities](https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/cmp30cfg001.htm)

On Identifiers:
- [DevMedia sobre Generated Values](https://www.devmedia.com.br/jpa-como-usar-a-anotacao-generatedvalue/38592)
- [Baeldung on Hibernate Identifiers](https://www.baeldung.com/hibernate-identifiers)
- [Vlad Mihalcea on Identifiers](https://vladmihalcea.com/jpa-entity-identifier-sequence/)
- [Thorben Janssen on Identifiers](https://thorben-janssen.com/jpa-generate-primary-keys/)

Transactional:
- [DZone on Transactional](https://dzone.com/articles/how-does-spring-transactional)
- [DevMedia on Transactional](https://www.devmedia.com.br/conheca-o-spring-transactional-annotations/32472)
- [Baeldung on Transactional](https://www.baeldung.com/transaction-configuration-with-jpa-and-spring)
- [Marco Behler on Transactional](https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth)
- [Spring Docs on Transaction Management](https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/transaction.html)
- [DecodeJava on Transactional](https://www.decodejava.com/spring-with-hibernate-transaction-by-annotation.htm)
- [JavaCodeGeeks on Transactional](https://www.javacodegeeks.com/2016/05/understanding-transactional-annotation-spring.html)
- [JournalDev on Transaction](https://www.journaldev.com/7655/spring-orm-example-jpa-hibernate-transaction)
- [StackOverflow](https://pt.stackoverflow.com/questions/96778/qual-a-finalidade-da-anota%C3%A7%C3%A3o-transactionalreadonly-false)
- [DevMedia on Transaction Management](https://www.devmedia.com.br/spring-framework-controle-de-transacoes-usando-anotacoes/28916)



