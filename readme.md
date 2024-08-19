# Understanding spring security By example
<!-- TOC -->
* [Understanding spring security By example](#understanding-spring-security-by-example)
  * [Learning](#learning-)
  * [Data Setup](#data-setup-)
<!-- TOC -->
## Learning 

1. By default, when we add spring security to our project,
    It adds a user with username as `user` and password would be printed as **default password**  in console when application starts
   **Note**: to see the default password on console you need to set log level in application.yaml 
   for below spring package`logging.level.org.springframework.security: INFO`
2. Add username and password to `application.yml` and add `.httpBasic(Customizer.withDefaults())` in `SecurityFilterChain` bean. 
   With this change you will be able to `login` with `username/password` provided in `application.yml`
3. Added `oAuth2 client` support with `Keycloak` using reference [here](https://developers.redhat.com/articles/2023/07/24/how-integrate-spring-boot-3-spring-security-and-keycloak)
4. Added `Jwt based authentication`g for `/greet` api present in Postman collection using `KeyCloak` as resource server used reference [here](https://www.baeldung.com/spring-boot-keycloak)



## Data Setup 
1. Import realm in `/setup` folder in keycloak
2. Create user in realm imported in step-1