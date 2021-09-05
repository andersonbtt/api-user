# User API

## Spring Project

Generated from [Spring Initializr](start.spring.io) boilerplate with given link:
@ [Project Boilerplate](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.4&packaging=jar&jvmVersion=11&groupId=co.bittclouds&artifactId=api-user&name=api-user&description=User%20microservice&packageName=co.bittclouds.api-user&dependencies=lombok,web,security,postgresql,data-jpa,mail)

## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-email)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

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

## Database use

- For manual database creation run following commands using psql
```
CREATE DATABASE REGISTRATION;
\l 
```

- For database objects listing run the following command:
```
\d
\d object_name
```

## SMTP Server

- For further information, checkout [maildev](https://github.com/maildev/maildev) repo
  
- For setting up test SMTP server, run the following command:
```
$ npm install -g maildev
$ maildev
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

Spring Beans:
- [Baeldung on Spring Bean Annotations](https://www.baeldung.com/spring-bean-annotations)
- [SpringDocs on Bean Annotation](https://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch02s02.html)
- [SpringDocs on Bean Definition](https://docs.spring.io/spring-javaconfig/docs/1.0.0.m3/reference/html/creating-bean-definitions.html)
- [SpringDocs on IoC and Beans](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
- [Spring Bean API](https://docs.spring.io/spring-framework/docs/3.2.0.M1_to_3.2.0.M2/Spring%20Framework%203.2.0.M2/org/springframework/context/annotation/Bean.html)
- [SpringDocs on IoC Container](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html)
- [JournalDev on Spring Bean Annotation](https://www.journaldev.com/21577/spring-bean-annotation)
- [ZetCode on Spring Boot Bean](https://zetcode.com/springboot/bean/)
- [Baeldung on Spring Component, Repository and Service Anotations](https://www.baeldung.com/spring-component-repository-service)
- [Baeldung on Spring Service Annotation Placement](https://www.baeldung.com/spring-service-annotation-placement)
- [SpringDocs Service API](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html)
- [JournalDev on Spring Service Annotation](https://www.journaldev.com/21435/spring-service-annotation)
- [StackOverflow on Spring Service Annotation](https://stackoverflow.com/questions/47668871/what-is-a-spring-service-annotation)
- [DevMedia on Spring Annotations](https://www.devmedia.com.br/introducao-pratica-ao-spring-framework-com-uso-de-anotacoes/27859)
- [TutorialsPoint on Spring Boot Service Components](https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm)
-

Design Patterns:
- []()

Pageable:
- []()

Aspect:
- []()

HTTP Codes:
- []()

Stream API:
- []()

Java 8/11:
- []()

RestTemplate vs WebClient vs Feign:
- []()

Jaeger:
- []()

Docker:
- []()

Kubernetes:
- []()

Rabbit:
- []()

EFK (Elastic, Fluentd and Kibana:
- []()

Kafka:
- []()

##

## Java

Predicates:
- [Java 11 Predicate API](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html)
- [ZetCode on Predicate](https://zetcode.com/java/predicate/)
- [Baeldung on Predicate Chain](https://www.baeldung.com/java-predicate-chain)
- [HowToDoInJava on Predicate Filter](https://howtodoinjava.com/java8/how-to-use-predicate-in-java-8/)
- [GeeksForGeeks on Java 8 Predicate](https://www.geeksforgeeks.org/java-8-predicate-with-examples/)
- [MKYokng on Java 8 Predicates](https://mkyong.com/java8/java-8-predicate-examples/)

## Git

- [Remove tracked files from repository](https://stackoverflow.com/questions/7927230/remove-directory-from-remote-repository-after-adding-them-to-gitignore)
- [Git Docs on .gitignore](https://git-scm.com/docs/gitignore)