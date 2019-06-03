# Issues Dashboard

This project is from [Brain Clozel's](https://spring.io/team/bclozel) tech-talk [From Zero to Hero with Spring Boot](https://www.youtube.com/watch?v=aA4tfBGY6jY).

Main repository [here](https://github.com/bclozel/issues-dashboard).

<br>

[![From Zero to Hero with Spring Boot](https://img.youtube.com/vi/aA4tfBGY6jY/0.jpg)](https://www.youtube.com/watch?v=aA4tfBGY6jY)

<br>

### Relevant Code changes

 - Added 2 new Type in RepositoryEvent class: **base_ref_force_pushed** and **head_ref_force_pushed**.
 - application.properties:
    ```
    management.endpoints.web.expose=*
    management.endpoint.health.show-details=true
    ```
    changed to:
    
    ```
    management.endpoints.web.exposure.include=*
    management.endpoint.health.show-details=always
    ```
 - _User.withDefaultPasswordEncoder_ is deprecated
 - _StaticResourceRequest.toCommonsLocations()_ is changed to _PathRequest.toStaticResources().atCommonLocations()_.
 - _NoOpPasswordEncoder_ is deprecated so _BCryptPasswordEncoder_ is provided.
 
 
  