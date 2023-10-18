###
1. **Что такое Reactor Core в проекте Reactor?**
    - Reactor Core - это библиотека для реактивного программирования на Java. Она предоставляет базовые классы и операторы для работы с реактивными последовательностями (Flux и Mono) и обеспечивает асинхронный и не блокирующий поток данных.

2. **Что такое реактивные последовательности (Flux) и одиночные значения (Mono) в Reactor?**
    - Flux - это последовательность элементов, которая может содержать ноль или более элементов.
    - Mono - это последовательность, которая содержит ноль или один элемент.

3. **Как создать Flux и Mono в Reactor?**
```java
// Создание Flux из списка элементов
Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

// Создание Mono из одного элемента
Mono<String> mono = Mono.just("Hello, Reactor!");
```

4. **Как преобразовать элементы в реактивной последовательности с помощью операторов в Reactor?**
```java
Flux<Integer> originalFlux = Flux.just(1, 2, 3, 4, 5);

// Преобразование каждого элемента в квадрат
Flux<Integer> squaredFlux = originalFlux.map(x -> x * x);

// Фильтрация элементов по условию
Flux<Integer> filteredFlux = originalFlux.filter(x -> x % 2 == 0);
```

5. **Как объединить две реактивные последовательности в Reactor?**
```java
Flux<Integer> flux1 = Flux.just(1, 2, 3);
Flux<Integer> flux2 = Flux.just(4, 5, 6);

// Объединение двух Flux
Flux<Integer> mergedFlux = Flux.merge(flux1, flux2);
```

6. **Как совместить значения из двух реактивных последовательностей в Reactor?**
```java
Flux<Integer> flux1 = Flux.just(1, 2, 3);
Flux<Integer> flux2 = Flux.just(4, 5, 6);

// Комбинирование значений из двух Flux с помощью оператора zip
Flux<Tuple2<Integer, Integer>> combinedFlux = Flux.zip(flux1, flux2);
```

7. **Как преобразовать реактивные последовательности с помощью оператора flatMap в Reactor?**
```java
Flux<Integer> flux = Flux.just(1, 2, 3);

// Преобразование каждого элемента в другой Flux и объединение результатов
Flux<String> resultFlux = flux.flatMap(x -> Flux.just("Number: " + x));
```

8. **Как объединить значения из двух реактивных последовательностей с помощью оператора zipWith в Reactor?**
```java
Flux<Integer> flux1 = Flux.just(1, 2, 3);
Flux<Integer> flux2 = Flux.just(4, 5, 6);

// Объединение значений из двух Flux с помощью оператора zipWith
Flux<Integer> resultFlux = flux1.zipWith(flux2, (x, y) -> x + y);
```

9. **Как объединить значения из двух реактивных последовательностей с помощью оператора combineLatest в Reactor?**
```java
Flux<Integer> flux1 = Flux.just(1, 2, 3);
Flux<Integer> flux2 = Flux.just(4, 5, 6);

// Объединение значений из двух Flux с помощью оператора combineLatest
Flux<Integer> resultFlux = Flux.combineLatest(flux1, flux2, (x, y) -> x + y);
```

10. **Как объединить значения из двух реактивных последовательностей с помощью оператора mergeWith в Reactor?**
```java
Flux<Integer> flux1 = Flux.just(1, 2, 3);
Flux<Integer> flux2 = Flux.just(4, 5, 6);

// Объединение значений из двух Flux с помощью оператора mergeWith
Flux<Integer> resultFlux = flux1.mergeWith(flux2);
```

11. **Как обработать ошибки в реактивных последовательностях в Reactor?**
```java
Flux<Integer> flux = Flux.just(1, 2, 3);

flux.map(x -> {
    if (x == 2) {
        throw new RuntimeException("Error occurred!");
    }
    return x;
})
.onErrorResume(e -> {
    System.out.println("Error occurred: " + e.getMessage());
    return Flux.empty();
})
.subscribe(System.out::println);
```

12. **Как выполнить операции после успешного завершения реактивной последовательности в Reactor?**
```java
Flux<Integer> flux = Flux.just(1, 2, 3);

flux.doOnComplete(() -> System.out.println("Completed successfully"))
.doOnError(e -> System.out.println("Error occurred: " + e.getMessage()))
.subscribe(System.out::println);
```

13. **Как применить операторы для преобразования и фильтра

ции элементов в Mono в Reactor?**
```java
Mono<Integer> mono = Mono.just(5);

// Преобразование элемента
Mono<String> resultMono = mono.map(x -> "Value: " + x);

// Фильтрация элемента
Mono<Integer> filteredMono = mono.filter(x -> x > 0);
```

14. **Как объединить несколько реактивных последовательностей в одно Mono в Reactor?**
```java
Mono<Integer> mono1 = Mono.just(1);
Mono<Integer> mono2 = Mono.just(2);

// Объединение нескольких Mono в одно
Mono<Tuple2<Integer, Integer>> combinedMono = Mono.zip(mono1, mono2);
```

15. **Как преобразовать Mono в реактивную последовательность (Flux) в Reactor?**
```java
Mono<Integer> mono = Mono.just(5);

// Преобразование Mono в Flux
Flux<Integer> flux = mono.flux();
```

16. **Как создать Mono из возможно пустого значения в Reactor?**
```java
Optional<String> optionalValue = Optional.of("Hello");
Optional<String> emptyValue = Optional.empty();

// Создание Mono из возможно пустого значения
Mono<String> mono1 = Mono.justOrEmpty(optionalValue);
Mono<String> mono2 = Mono.justOrEmpty(emptyValue);
```

17. **Как создать Mono с пустым значением или использовать значение по умолчанию в Reactor?**
```java
Optional<String> optionalValue = Optional.empty();

// Создание Mono с пустым значением или использование значения по умолчанию
Mono<String> mono = Mono.justOrEmpty(optionalValue).switchIfEmpty(Mono.just("Default Value"));
```

18. **Как объединить значения из нескольких реактивных последовательностей в одно Mono с помощью оператора zipWith в Reactor?**
```java
Mono<Integer> mono1 = Mono.just(1);
Mono<Integer> mono2 = Mono.just(2);

// Объединение значений из нескольких Mono с помощью оператора zipWith
Mono<Integer> resultMono = mono1.zipWith(mono2, (x, y) -> x + y);
```

19. **Как выполнить действие после успешного завершения Mono в Reactor?**
```java
Mono<Integer> mono = Mono.just(5);

mono.doOnSuccess(x -> System.out.println("Success: " + x))
.doOnError(e -> System.out.println("Error occurred: " + e.getMessage()))
.subscribe();
```

20. **Как выполнить асинхронные операции с помощью реактивных последовательностей в Reactor?**
```java
Flux<Integer> flux = Flux.just(1, 2, 3);

flux.flatMap(x -> Mono.fromCallable(() -> {
    // Асинхронные операции
    return x * x;
}))
.subscribe(result -> System.out.println("Result: " + result));
```

###
1. **Что такое Spring WebFlux?**
    - Spring WebFlux - это модуль в Spring Framework, предоставляющий поддержку реактивного программирования для веб-приложений. Он основан на реактивном стеке Reactor и позволяет создавать асинхронные и не блокирующие веб-приложения.

2. **Какие основные компоненты входят в Spring WebFlux?**
    - В Spring WebFlux основными компонентами являются `WebFlux` и `WebClient`.

3. **Какой тип сервера поддерживается в Spring WebFlux?**
    - Spring WebFlux поддерживает два типа серверов: реактивный сервер Netty и сервлет-контейнер, такой как Tomcat или Jetty.

4. **Что такое реактивный контроллер в Spring WebFlux?**
    - Реактивный контроллер в Spring WebFlux - это компонент, который обрабатывает входящие запросы и генерирует реактивные ответы. Он использует аннотации, такие как `@RestController` и `@RequestMapping`, для определения обработчиков запросов.

5. **Как создать реактивный контроллер в Spring WebFlux?**
```java
@RestController
public class MyController {

    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello, World!");
    }
}
```

6. **Что такое `Mono` и `Flux` в Spring WebFlux?**
    - `Mono` представляет реактивный объект, который содержит ноль или одно значение.
    - `Flux` представляет реактивный объект, который содержит ноль или более значений.

7. **Как обработать запросы POST и другие методы в реактивных контроллерах?**
```java
@RestController
public class MyController {

    @PostMapping("/create")
    public Mono<MyObject> createObject(@RequestBody MyObject object) {
        // Обработка запроса POST и создание объекта
        return Mono.just(object);
    }
}
```

8. **Как использовать аннотацию `@PathVariable` в реактивных контроллерах?**
```java
@RestController
public class MyController {

    @GetMapping("/hello/{name}")
    public Mono<String> sayHello(@PathVariable String name) {
        return Mono.just("Hello, " + name + "!");
    }
}
```

9. **Как обработать ошибки в реактивных контроллерах в Spring WebFlux?**
```java
@RestController
public class MyController {

    @GetMapping("/divide/{a}/{b}")
    public Mono<Integer> divide(@PathVariable int a, @PathVariable int b) {
        if (b == 0) {
            return Mono.error(new IllegalArgumentException("Division by zero is not allowed."));
        }
        return Mono.just(a / b);
    }

    @ExceptionHandler
    public Mono<ResponseEntity<String>> handleException(IllegalArgumentException ex) {
        return Mono.just(ResponseEntity.badRequest().body(ex.getMessage()));
    }
}
```

10. **Как использовать операторы для преобразования и фильтрации элементов в реактивных последовательностях в Spring WebFlux?**
```java
@GetMapping("/numbers")
public Flux<Integer> getNumbers() {
    return Flux.just(1, 2, 3, 4, 5)
            .map(x -> x * 2)
            .filter(x -> x % 3 == 0);
}
```

11. **Как отправить реактивный ответ из контроллера в Spring WebFlux?**
```java
@GetMapping("/data")
public Flux<MyObject> getData() {
    List<MyObject> dataList = // ... retrieve data from database or elsewhere
    return Flux.fromIterable(dataList);
}
```

12. **Как использовать операторы для объединения реактивных последовательностей в Spring WebFlux?**
```java
@GetMapping("/combine")
public Flux<String> combineData() {
    Flux<String> flux1 = Flux.just("Hello", "World");
    Flux<String> flux2 = Flux.just("Reactive", "Programming");
    
    return flux1.zipWith(flux2, (s1, s2) -> s1 + " " + s2);
}
```

13. **Как обработать запросы с помощью реактивной базы данных в Spring WebFlux?**
```java
@Autowired
private MyReactiveRepository repository;

@GetMapping("/users")
public Flux<User> getUsers() {
    return repository.findAll();
}
```

14. **Как использовать WebClient для выполнения HTTP-запросов в Spring WebFlux?**
```java
@Autowired
private WebClient.Builder webClientBuilder;

@GetMapping("/external-data")
public Mono<String> getExternalData() {
    WebClient webClient = webClientBuilder.baseUrl("https://


