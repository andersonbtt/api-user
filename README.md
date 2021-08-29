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

## Killing concurrent processes

Case you find the following error by 
```
java.net.BindException: Address already in use
```
You can find which is the process using yout server port on LINUX by running the following command
```
sudo netstat -tulpn | grep 8080
tcp6       0      0 :::8080                 :::*                    LISTEN       3122/java   ```
```
With the given process ID (PID) you can kill it IF YOU KNOW IT SHOULD BE KILLED by running the following command replacing PID with given PID
```
sudo kill PID
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
- [Lombok with STS](https://stackoverflow.com/questions/67236498/does-lomboks-allargsconstructor-autowire-the-fields-in-spring-boot-automatical)

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

## Spring

Constructor Injection:
- [Baeldung on AllArgsConstructor vs Autowired](https://www.baeldung.com/spring-injection-lombok)
- [Daniela Morais on Dependency Injection](https://danielammorais.com/injecao-de-dependencias-com-spring.pdf)
- [Reflectorin on Constructor Injection](https://reflectoring.io/constructor-injection/)
- [Stackoverflow on Constructor Injection](https://stackoverflow.com/questions/40620000/spring-autowire-on-properties-vs-constructor/40620318)
- [Engineering@Zemoso on Constructor Injection](https://medium.com/engineering-zemoso/when-not-to-autowire-in-spring-spring-boot-93e6a01cb793)
- [Baeldung on Constructor Injection](https://www.baeldung.com/constructor-injection-in-spring)
- [DZone on Spring DI Patterns](https://dzone.com/articles/spring-di-patterns-the-good-the-bad-and-the-ugly)
- [Martin Fowler on Inversion of Control](https://martinfowler.com/bliki/InversionOfControl.html)
- [Martin Fowler on Inversion of Control Containers and DIP](https://martinfowler.com/articles/injection.html)
- [Martin Fowler on DIP](https://martinfowler.com/articles/dipInTheWild.html)
- [Spring Docs on Dependency Injection](https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch01.html)

Differences from Rest Controller to Controller:
- [Baeldung on RestController vs Controller](https://www.baeldung.com/spring-controller-vs-restcontroller)
- [Gilberto Brandao on RestController vs Controller](https://medium.com/@gcbrandao/diferen%C3%A7a-entre-restcontroller-e-controller-annotation-no-spring-mvc-e-rest-8533998a93eb)
- [JavaCodeGeeks on RestController vs Controller](https://www.javacodegeeks.com/2017/08/difference-restcontroller-controller-annotation-spring-mvc-rest.html)
- [StackOverflow on RestController vs Controller](https://stackoverflow.com/questions/25242321/difference-between-spring-controller-and-restcontroller-annotation)

RequestMapping:
- [Baeldung on RequestMapping](https://www.baeldung.com/spring-requestmapping)
- [StackOverflow on RequestMapping](https://stackoverflow.com/questions/50351590/difference-between-path-and-value-attributes-in-requestmapping-annotation)
- [SpringFramework.guru on RequestMapping](https://springframework.guru/spring-requestmapping-annotation/)
- [DevMedia on RequestMapping](https://www.devmedia.com.br/controlando-o-spring-mvc/26265)
- [DZone on RequestMapping](https://dzone.com/articles/using-the-spring-requestmapping-annotation)
- [PrgressiveCoder on RequestMapping](https://progressivecoder.com/a-guide-to-spring-boot-requestmapping-annotation/)
- [ZetCode on RequestMapping](https://zetcode.com/spring/requestmapping/)
- [LogicBig on RequestMapping](https://www.logicbig.com/examples/spring-mvc/request-mapping/empty-handler-mapping.html)
- [StackAbuse on RequestMapping](https://stackabuse.com/spring-annotations-requestmapping-and-its-variants/)

Spring Conditionals:
- [Baeldung on Conditionals](https://www.baeldung.com/spring-conditional-annotations)
- [Reflectoring on Conditionals](https://reflectoring.io/spring-boot-conditionals/)
- [Spring Docs on Conditionals](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Conditional.html)
- [JavaPapers on Conditionals](https://javapapers.com/spring/spring-conditional-annotation/)
- [JavaCodeGeeks on Conditionals](https://examples.javacodegeeks.com/spring-conditional-annotation-example/)
- [LogicBig on Conditionals](https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-conditional.html)
- [DZone on Conditionals](https://dzone.com/articles/testing-spring-boot-conditionals-the-sane-way)

Design Patterns:
- 