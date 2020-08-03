### Springboot Application that consumes spring-boot-starter Auto Configurable app.

- Adds a dependency for spring-boot-starter-score in build.gradle

- It passes a Spring Environment variable to trigger bean creation in spring-boot-starter-score project.

- It  watches the behavior when --score.filePath is passed and when it is not passed. 

- Custom implementation of Score Interface (inside starter project) can be provided to override default logic for calculation scores.
