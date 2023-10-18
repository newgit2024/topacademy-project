###
Testcontainers предоставляет удобный способ запуска контейнеров Docker во время тестирования. Чтобы использовать Testcontainers для PostgreSQL, следуйте этим шагам:

1. **Добавьте зависимость**:
   Добавьте зависимость на Testcontainers и драйвер для PostgreSQL в файл `build.gradle` (или `pom.xml`, если вы используете Maven):

   Gradle:
   ```gradle
   testImplementation 'org.testcontainers:testcontainers:1.15.2'
   testImplementation 'org.testcontainers:postgresql:1.15.2'
   ```

   Maven:
   ```xml
   <dependency>
       <groupId>org.testcontainers</groupId>
       <artifactId>testcontainers</artifactId>
       <version>1.15.2</version>
       <scope>test</scope>
   </dependency>
   <dependency>
       <groupId>org.testcontainers</groupId>
       <artifactId>postgresql</artifactId>
       <version>1.15.2</version>
       <scope>test</scope>
   </dependency>
   ```

2. **Напишите тест с использованием Testcontainers**:
   Создайте тестовый класс и используйте класс `org.testcontainers.containers.PostgreSQLContainer` для запуска контейнера PostgreSQL:

   ```java
   import org.junit.jupiter.api.Test;
   import org.testcontainers.containers.PostgreSQLContainer;
   import org.testcontainers.junit.jupiter.Container;
   import org.testcontainers.junit.jupiter.Testcontainers;

   @Testcontainers
   public class PostgreSQLTest {

       @Container
       private final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest")
               .withDatabaseName("testdb")
               .withUsername("testuser")
               .withPassword("testpass");

       @Test
       public void testSomething() {
           // Внутри этого теста вы можете использовать параметры
           // подключения к PostgreSQL из контейнера postgresContainer
           String jdbcUrl = postgresContainer.getJdbcUrl();
           String username = postgresContainer.getUsername();
           String password = postgresContainer.getPassword();
           
           // Тестирование вашей логики с использованием подключения к PostgreSQL
       }
   }
   ```

3. **Запустите тест**:
   Запустите тест, и Testcontainers автоматически запустит контейнер PostgreSQL перед выполнением теста и остановит его после выполнения.

Testcontainers обеспечивает автоматическое управление жизненным циклом контейнера, что делает интеграцию с тестами очень удобной. В примере выше, контейнер PostgreSQL будет создан и настроен с параметрами, указанными в коде теста.
###
###
###
###
###
###
###