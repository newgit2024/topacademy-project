1. Microservices +/-
2. отслеживание микрос
3. коммиты в микросервисах
4. как разрешать коммиты в ребэйс - в каждом коммите
5. рэбейс сквош
6. гит стэш - чтобы задвинуть коммиты потом использовать
7. нужно ли переопределить иквэлс хэшкод в Тримэп
8. как избавится от циклической зависимости в бинах - Cyclic dependencies in Spring beans can create problems during application startup, and it's generally best to avoid them whenever possible. Here are some strategies to resolve cyclic dependencies in Spring beans:

### Cyclic DI resolving
The best way to resolve cyclic dependencies in Spring beans is to design your application in a way that avoids cyclic dependencies altogether. Here are some best practices to follow to prevent cyclic dependencies:

1. Use Constructor Injection:
    - Prefer constructor injection over field or setter injection. Constructor injection ensures that all dependencies are resolved at the time of object creation, which helps prevent cyclic dependencies.

2. Keep Bean Responsibilities Separate:
    - Ensure that each bean has a clear and specific responsibility. Avoid creating beans that are highly dependent on each other, as this can lead to cyclic dependencies.

3. Apply SOLID Principles:
    - Follow SOLID principles, especially the Single Responsibility Principle (SRP) and the Dependency Inversion Principle (DIP). These principles help to create loosely coupled components and reduce the likelihood of cyclic dependencies.

4. Use Interfaces:
    - Consider using interfaces to define dependencies instead of concrete classes. This allows you to have more flexibility in changing implementations and helps avoid tight coupling.

5. Reorganize Bean Definitions:
    - Review your bean definitions and try to reorganize them if possible to minimize or eliminate the cyclic relationships. This might involve breaking down large beans into smaller ones or grouping related functionality.

6. Avoid Circular Calls:
    - Be cautious about directly calling methods on a dependent bean from another bean. Instead, consider using events, callbacks, or observers to communicate between beans indirectly.

7. Use `@Lazy` Annotation Selectively:
    - If you must use `@Lazy` annotation, apply it selectively and only when necessary. Avoid using it as a quick fix for all circular dependencies, as it might introduce other issues.

8. Apply `@DependsOn` with Caution:
    - If you use `@DependsOn`, be careful with its usage, as it can create tight coupling between beans. Use it only when there's no alternative and be mindful of the bean initialization order.

9. Use Analytical Tools:
    - Utilize analytical tools or static code analysis tools to detect and highlight cyclic dependencies in your codebase early on.

10. Regular Code Reviews:
- Conduct regular code reviews with your team to identify and address cyclic dependencies and promote best practices for bean design.

Remember that while these strategies can help you manage and resolve cyclic dependencies, it's essential to approach your application's design thoughtfully and strive for a clean and modular architecture that promotes loose coupling and maintainability. Avoiding cyclic dependencies from the beginning will lead to a more robust and scalable codebase.

### Spring Boot Starter
Creating a Spring Boot starter involves a few steps to package and distribute reusable configurations, dependencies, and auto-configurations for specific functionalities. Here's a step-by-step guide on how to create a custom Spring Boot starter:

1. Create a New Maven or Gradle Project:
    - Start by creating a new Maven or Gradle project for your custom starter. This project will hold all the necessary configurations, dependencies, and auto-configurations.

2. Define the Starter's Core Library:
    - Create a library module in your project that will serve as the core of your starter. This module should contain the auto-configurations and other necessary classes for your starter's functionality.

3. Define Starter Properties:
    - In your core library module, define properties and configuration classes that users can use to customize the behavior of the starter. You can use `@ConfigurationProperties` to bind external properties to your configuration classes.

4. Implement Auto-Configuration:
    - Create auto-configuration classes that configure the necessary beans and components for your starter based on the defined properties.

5. Implement Starter Classes:
    - Create a starter class in your core library module. This class should be annotated with `@Configuration` and use `@Import` to import your auto-configurations.

6. Create Spring Boot Auto-Configuration File:
    - In the `META-INF/spring.factories` file of your core library module, list the fully qualified names of your starter classes. This file is used by Spring Boot to automatically enable the auto-configurations when your starter is added as a dependency.

7. Build and Package the Starter:
    - Build your custom starter using Maven or Gradle. This will create a JAR file containing your auto-configurations and necessary classes.

8. Publish the Starter (Optional):
    - If you want to distribute your custom starter publicly, you can publish it to a Maven repository (e.g., Maven Central or JCenter) or a private repository.

9. Use the Starter in Other Projects:
    - In any Spring Boot project where you want to use your custom starter, add the starter's dependency to the project's build configuration (Maven or Gradle). When you include the starter dependency, Spring Boot will automatically apply the configurations and auto-configurations defined in your starter.

Here's a simplified example of a custom Spring Boot starter directory structure:

```
my-spring-boot-starter/
  |- my-starter-core/
      |- src/
          |- main/
              |- java/
                  |- com.example.mystarter/
                      |- MyStarterProperties.java
                      |- MyStarterAutoConfiguration.java
                      |- MyStarter.java
              |- resources/
                  |- META-INF/
                      |- spring.factories
  |- my-starter-example-app/ (Sample Spring Boot application using the starter)
  |- pom.xml (or build.gradle)
```

Note: Creating a custom Spring Boot starter can be complex, especially if you want to address various use cases and provide robust configurations. Before creating a starter, consider whether it's the best approach for your particular requirements. In some cases, creating a simple library with reusable classes might be sufficient instead of a full-blown starter.