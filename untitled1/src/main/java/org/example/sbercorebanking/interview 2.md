###
что выведется в консоль java:
    final Object obj1 = new Object();
        final Object obj2 = new Object();

        System.out.println(obj1.equals(obj2)); //false
        System.out.println(obj1 == obj2); //false

        final String str1 = new String("string");
        final String str2 = new String("string");

        System.out.println(str1.equals(str2)); true
        System.out.println(str1 == str2); false

        final String str3 = "string";
        final String str4 = "string";

        System.out.println(str3.equals(str4)); true
        System.out.println(str3 == str4); true

        final Integer i1 = new Integer(1);
        final Integer i2 = new Integer(1);

        System.out.println(i1.equals(i2)); true
        System.out.println(i1 == i2); false

        final Integer i3 = 128;
        final Integer i4 = 128;

        System.out.println(i3.equals(i4)); true
        System.out.println(i3 == i4); false


###
Вернуть список пользователей, у которых какая- либо группа начинает Apologies we're haw@Data 
class User { private int id ; private String name ; private List< Group> groups ;}@Data 
class Group { private int userId ; private String name ;} 
public class Test { 
public List< User> foo ( Stream< User> usersStream) { 
I}


var usersWithGroupStartsWithA = users.stream()
.filter(u -> u.getGroups.stream().filter(g -> g.getName.startsWith("A")))
.collect(Collectors.toList());


###
что выведется в консоль java:

                final Object obj1 = new Object(); 
        final Object obj2 = new Object();

        System.out.println(obj1.equals(obj2)); // false
        System.out.println(obj1 == obj2);           // false

        final String str1 = new String("string");
        final String str2 = new String("string");

        System.out.println(str1.equals(str2)); // true
        System.out.println(str1 == str2);           // false
        
        final String str3 = "string";
        final String str4 = "string";

        System.out.println(str3.equals(str4));  // true
        System.out.println(str3 == str4);           // true

        final Integer i1 = new Integer(1);
        final Integer i2 = new Integer(1);

        System.out.println(i1.equals(i2));      // true
        System.out.println(i1 == i2);               // false

        final Integer i3 = 128;
        final Integer i4 = 128;

        System.out.println(i3.equals(i4));  // true
        System.out.println(i3 == i4);           // false
        
        
        
        
        
         // Что будет выведено в консоль
        List<String> characters = List.of("B", "D", "R", "D", "E");
  //     characters.stream().peek(System.out::println).forEach(System.out::println);
  
   characters.stream().peek(System.out::println).sorted().forEach(System.out::println);
          




В каком варианте массив будет успешно отсортирован: (от 0 до 3 вариантов):
List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("e");
        list1.add("d");
        
        List<String> list2 = Arrays.asList("a","c","d");
        
        List<String> list3 = List.of("a","c","d");
        
        Collections.sort(list1);
        Collections.sort(list2);
        Collections.sort(list3);
  
  
  
 @RestController
  public class MyController {
    volatile int count = 0;

    @GetMapping("/getAdd")
    public void getAdd() {
        count++;
    }

    @GetMapping("/get")
     public int get() {
        return count;
    }
}



### REST (Representational State Transfer) - это архитектурный стиль для разработки распределенных систем, основанный на принципах, учитывающих ограничения и требования сети. Вот основные принципы REST архитектуры:

1. **Ресурсы (Resources)**: Вся информация в системе представляется как ресурсы, например, документы, изображения, видео, пользователи, и т.д. Каждый ресурс имеет свой уникальный идентификатор (URI).

2. **Ограниченность (Stateless)**: Каждый запрос от клиента к серверу должен содержать всю необходимую информацию для понимания запроса. Сервер не должен хранить состояние о клиенте между запросами. Это упрощает масштабирование системы.

3. **Клиент-серверная архитектура (Client-Server)**: Клиент и сервер являются отдельными компонентами, которые могут развиваться независимо друг от друга. Это позволяет легко масштабировать и обновлять как клиентскую, так и серверную части.

4. **Кэширование (Caching)**: Ответы от сервера могут быть кэшированы на стороне клиента для улучшения производительности. Для ресурсов сервер может указать, можно ли их кэшировать или нет.

5. **Единообразие интерфейса (Uniform Interface)**: Все сервисы в системе должны предоставлять единообразный интерфейс. Это упрощает взаимодействие между компонентами системы. Основные архитектурные элементы в REST включают HTTP методы (GET, POST, PUT, DELETE), ресурсы, URI и представления.

6. **Многоуровневая система (Layered System)**: Архитектура может состоять из нескольких уровней, где каждый уровень может выполнять определенные функции. Это увеличивает масштабируемость и безопасность.

7. **Код по требованию (Code on Demand)**: Этот принцип не обязателен, но REST позволяет передавать код на выполнение клиенту, например, сценарии JavaScript.

RESTful API - это интерфейс, который соответствует REST-принципам, и который позволяет клиенту выполнять операции с ресурсами, используя стандартные HTTP методы. RESTful API часто используется в веб-сервисах и веб-приложениях для взаимодействия с сервером.

### Fluentd, Fluent Bit и Logstash - это три различных инструмента для сбора, агрегации и передачи журналов (логов) в средах с большим количеством данных и микросервисной архитектурой. Каждый из них имеет свои особенности, преимущества и недостатки, и выбор между ними зависит от конкретных потребностей и контекста.

Вот краткое сравнение Fluentd, Fluent Bit и Logstash:

1. **Fluentd**:
   - Fluentd - это полноценный агент для сбора и пересылки данных, разработанный на Ruby.
   - Он предоставляет богатый набор плагинов для сбора данных из различных источников и отправки их в различные цели.
   - Fluentd может работать с структурированными и неструктурированными данными.
   - Он легко настраивается и позволяет централизованно управлять конфигурацией.

2. **Fluent Bit**:
   - Fluent Bit - это более легковесный агент, написанный на языке C, и разработанный для оптимизации производительности.
   - Он хорошо подходит для сбора и передачи журналов из контейнеров и других сред, где важна производительность и низкий потребляемый объем ресурсов.
   - Fluent Bit также поддерживает множество плагинов и интеграцию с различными системами.

3. **Logstash**:
   - Logstash - это часть стека ELK (Elasticsearch, Logstash, Kibana), разработанного для агрегации и обработки журналов.
   - Logstash предоставляет широкие возможности для обработки и обогащения данных перед их отправкой в Elasticsearch для хранения и анализа.
   - Он также имеет множество плагинов и фильтров для различных типов данных и источников.

Выбор между этими инструментами зависит от следующих факторов:

- **Масштаб и производительность**: Если вам нужно обрабатывать большие объемы данных с низкой задержкой, Fluent Bit может быть хорошим выбором.
- **Сложность и гибкость**: Fluentd предоставляет более широкие возможности для сложной обработки и агрегации данных.
- **Интеграция с другими системами**: Logstash может быть предпочтителен, если вы уже используете стек ELK.

Общим для всех трех инструментов является то, что они помогают централизованно управлять и анализировать журналы, что особенно важно в микросервисных средах.


Давайте создадим сравнительную таблицу для Fluentd, Fluent Bit и Logstash, учитывая их основные характеристики и особенности:

| Характеристика            | Fluentd             | Fluent Bit        | Logstash              |
|---------------------------|---------------------|-------------------|-----------------------|
| Язык программирования     | Ruby                | C                 | Ruby                  |
| Производительность        | Средняя             | Очень высокая    | Средняя               |
| Поддержка плагинов        | Обширная            | Обширная          | Обширная              |
| Легковесность             | Нет                 | Да                | Нет                   |
| Структурированные данные   | Да                  | Да                | Да                    |
| Неструктурированные данные | Да                  | Да                | Да                    |
| Управление конфигурацией  | Централизованное     | Централизованное  | Централизованное       |
| Интеграция с ELK          | Да                  | Да                | Да                    |
| Простота настройки        | Да                  | Да                | Да                    |
| Потребление ресурсов      | Среднее             | Низкое            | Среднее               |

Это общее сравнение, и выбор между этими инструментами должен быть сделан на основе ваших конкретных потребностей, объема данных и архитектуры системы.