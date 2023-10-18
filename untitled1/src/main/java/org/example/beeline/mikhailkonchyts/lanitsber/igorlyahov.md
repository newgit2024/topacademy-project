###
По-видимому, вы интересуетесь методами класса `Object`. Класс `Object` является корневым классом для всех классов в Java, и он предоставляет некоторые базовые методы, которые могут быть переопределены в других классах. Вот некоторые из наиболее используемых методов класса `Object`:

1. **`toString()`**: Метод возвращает строковое представление объекта. Обычно этот метод переопределяется в пользовательских классах для возврата информативной строки. Например:

```java
@Override
public String toString() {
    return "MyObject with value: " + value;
}
```

2. **`equals(Object obj)`**: Метод сравнивает текущий объект с переданным объектом на равенство. По умолчанию он сравнивает ссылки на объекты, но его также рекомендуется переопределить для сравнения содержимого объектов.

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    MyObject other = (MyObject) obj;
    return value == other.value;
}
```

3. **`hashCode()`**: Метод возвращает хэш-код объекта. Хэш-код используется, например, для хранения объектов в хэш-коллекциях. Если переопределен `equals()`, обычно также переопределяется `hashCode()`.

```java
@Override
public int hashCode() {
    return Objects.hash(value);
}
```

4. **`clone()`**: Метод создает и возвращает копию объекта. Он работает, только если класс поддерживает клонирование. При использовании его следует аккуратно обрабатывать состояние объекта.

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    return super.clone();
}
```

5. **`finalize()`**: Этот метод вызывается перед тем, как объект будет собран сборщиком мусора. Он может быть переопределен, если объекту нужно выполнить некоторые действия перед уничтожением.

```java
@Override
protected void finalize() throws Throwable {
    // Код завершающих действий перед уничтожением объекта
    super.finalize();
}
```

Это лишь небольшой набор методов из класса `Object`. Помните, что эти методы могут быть переопределены в пользовательских классах для адаптации поведения под конкретные требования.
###
В Java для клонирования объектов существует два подхода: поверхностное (обычное) клонирование и глубокое клонирование. Давайте разберемся, как реализовать оба этих типа клонирования.

### 1. Обычное (поверхностное) клонирование:

При обычном клонировании создается новый объект, и его поля копируются из исходного объекта. Однако, если поля содержат ссылки на другие объекты, новые объекты не создаются - они будут ссылаются на те же объекты, на которые ссылается исходный объект.

Для реализации обычного клонирования, класс должен реализовать интерфейс `Cloneable` и переопределить метод `clone()`:

```java
public class MyClass implements Cloneable {
    private int value;
    private OtherClass other;

    public MyClass(int value, OtherClass other) {
        this.value = value;
        this.other = other;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

### 2. Глубокое клонирование:

Глубокое клонирование включает в себя создание новых объектов для всех полей (и вложенных объектов), чтобы избежать разделения ссылок между исходным и клонированным объектами.

Для реализации глубокого клонирования, вы можете вручную клонировать каждое поле, включая вложенные объекты:

```java
public class MyClass implements Cloneable {
    private int value;
    private OtherClass other;

    public MyClass(int value, OtherClass other) {
        this.value = value;
        this.other = other;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyClass cloned = (MyClass) super.clone();
        cloned.other = (OtherClass) other.clone(); // Глубокое клонирование вложенного объекта
        return cloned;
    }
}
```

Обратите внимание, что для успешного глубокого клонирования класс `OtherClass` также должен реализовать интерфейс `Cloneable` и иметь свой собственный метод `clone()`.

Пожалуйста, обратите внимание, что клонирование может быть сложным процессом, особенно при наличии сложной иерархии классов и взаимосвязанных объектов. Гарантировать корректное клонирование во всех ситуациях может потребовать глубокого понимания структуры классов и данных.
###
Иммутабельные (неизменяемые) коллекции в Java представляют собой коллекции, которые нельзя изменять после создания. Это означает, что после создания такой коллекции нельзя добавлять, изменять или удалять элементы. Иммутабельные коллекции полезны в ситуациях, когда вам нужно обеспечить надежность и предсказуемость данных, а также избежать потенциальных проблем с синхронизацией.

В Java иммутабельные коллекции представлены в пакете `java.util` начиная с версии Java 9. Они обычно реализуются через интерфейсы, которые наследуют соответствующие интерфейсы изменяемых коллекций. Например:

1. **`java.util.ImmutableList`**: Иммутабельный аналог `java.util.List`.

2. **`java.util.ImmutableSet`**: Иммутабельный аналог `java.util.Set`.

3. **`java.util.ImmutableMap`**: Иммутабельный аналог `java.util.Map`.

4. **`java.util.ImmutableQueue`**: Иммутабельный аналог `java.util.Queue`.

5. **`java.util.ImmutableDeque`**: Иммутабельный аналог `java.util.Deque`.

6. **`java.util.ImmutableSortedSet`**: Иммутабельный аналог отсортированного `Set`.

7. **`java.util.ImmutableSortedMap`**: Иммутабельный аналог отсортированной `Map`.

Пример создания иммутабельной коллекции:

```java
import java.util.ImmutableList;

public class ImmutableCollectionExample {
    public static void main(String[] args) {
        ImmutableList<Integer> immutableList = ImmutableList.of(1, 2, 3);
        System.out.println(immutableList);

        // Попытка изменения вызовет UnsupportedOperationException
        // immutableList.add(4);
    }
}
```

Заметьте, что методы изменения коллекции (например, `add`, `remove` и другие) в иммутабельных коллекциях вызывают `UnsupportedOperationException`, так как эти коллекции предназначены только для чтения.

Иммутабельные коллекции удобны для использования в многопоточных средах, так как их состояние не может быть изменено, и это устраняет необходимость синхронизации. Однако, имейте в виду, что создание новой версии коллекции при каждой операции может вызвать некоторые затраты по памяти и производительности.
###
В Java API существует различные методы, которые используют `Optional` и `OptionalInt`, `OptionalLong` и `OptionalDouble` (коллективно называемые "Optional" типы) из пакета `java.util`. Эти типы были введены для улучшения обработки возможных отсутствующих (null) значений и облегчения кода.

`Optional` предоставляет способ обернуть значение, которое может быть присутствующим или отсутствующим. Он может быть использован в методах, чтобы явно указать, что возвращаемое значение может быть пустым (отсутствующим).

**Методы, использующие `Optional`**:

1. **`Optional.of(T value)`**: Создает `Optional` объект, содержащий заданное значение. Если переданное значение равно `null`, будет выброшено исключение `NullPointerException`.

2. **`Optional.ofNullable(T value)`**: Создает `Optional` объект, содержащий заданное значение. Если переданное значение равно `null`, будет создан пустой `Optional`.

3. **`Optional.empty()`**: Создает пустой `Optional` объект.

4. **`Optional.orElse(T other)`**: Возвращает содержимое `Optional`, если оно присутствует. Если содержимое отсутствует, возвращается переданное значение.

5. **`Optional.orElseGet(Supplier<? extends T> other)`**: Так же как `orElse`, но вместо значения используется поставщик (Supplier) для получения значения.

6. **`Optional.orElseThrow(Supplier<? extends X> exceptionSupplier)`**: Возвращает содержимое `Optional`, если оно присутствует. Если содержимое отсутствует, выбрасывается исключение, созданное с использованием поставщика исключения.

**Методы, использующие `OptionalInt`, `OptionalLong`, `OptionalDouble`**:

Аналогичные методы есть и для `OptionalInt`, `OptionalLong` и `OptionalDouble`, предназначенные для соответствующих примитивных типов.

**Методы, использующие `Optional.ofNullable(T value)` вместе с `ifPresent`**:

Метод `ifPresent(Consumer<? super T> consumer)` позволяет выполнить определенное действие только в случае, если `Optional` содержит значение. Это часто используется для безопасного извлечения и использования значения из `Optional`.

```java
Optional<String> optionalValue = Optional.ofNullable(getValue());
optionalValue.ifPresent(val -> System.out.println("Value is present: " + val));
```

**Методы, использующие `Optional.ofNullable(T value)` с `map` и `flatMap`**:

Методы `map` и `flatMap` позволяют применять функции к содержимому `Optional`, возвращая другой `Optional`. Они позволяют чейнить операции над значениями, при этом учитывая возможное отсутствие значения.

```java
Optional<String> optionalValue = Optional.ofNullable(getValue());
Optional<Integer> lengthOptional = optionalValue.map(String::length);
```

**Методы, использующие `Optional.of(T value)` с `filter`**:

Метод `filter` позволяет проверить значение внутри `Optional` и вернуть пустой `Optional`, если значение не соответствует заданному условию.

```java
Optional<Integer> optionalValue = Optional.of(42);
Optional<Integer> filteredOptional = optionalValue.filter(val -> val > 50);
```

**Методы, использующие `Optional.ofNullable(T value)` с `orElseThrow`**:

Метод `orElseThrow` используется для выбрасывания исключения, если значение отсутствует.

```java
Optional<String> optionalValue = Optional.ofNullable(getValue());
String value = optionalValue.orElseThrow(() -> new NoSuchElementException("Value is not present"));
```

Примеры, приведенные выше, демонстрируют различные способы использования `Optional` и его производных типов. Они способствуют более четкому коду, обработке возможных отсутствующих значений и улучшению безопасности работы с данными.
###
https://howtodoinjava.com/kafka/apache-kafka-tutorial/
###
Apache Kafka Tutorial for Beginners
Lokesh Gupta

June 15, 2023
Kafka

Apache Kafka, Java Message Queue
This Apache Kafka tutorial discusses the architecture, core components inside a cluster and other advanced concepts related to data retention and replication. This tutorial is for absolute beginners to offer them some tips while learning Kafka in the longer run.

1. Introduction to Apache Kafka
   Apache Kafka is an open-source distributed event streaming service used for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications. It is based on publish/subscribe messaging system and is often referred to as “distributed commit log“.


Kafka possesses three key capabilities:

It enables applications to publish or subscribe to data or event streams.
Ensures accurate storage of records, in a fault-tolerant and durable manner.
Real-time processing of records.
Apache Kafka provides major upgrades from the traditional messaging system. Below are the differences between a traditional messaging system (like RabbitMQ, ActiveMQ, etc.) and Kafka.

Traditional Messaging System	Kafka Streaming Platform
The broker is responsible for keeping track of consumed messages and removing them when messages are read.	It is a distributed streaming system, so by adding more partitions, we can scale horizontally.
Targets a specific Consumer.	Any consumer can access a message from the broker.
Not a distributed system, so it is not possible to scale horizontally.	It is a distributed streaming system, so by adding more partitions, we can scale horizontally.
Does not offer Message Persistence, meaning once the messages are read, they will be removed from the broker	Does not offer Message Persistence, meaning once the messages are read, they will be removed from the broker
Play

Next
Unmute
Current Time
0:00
/
Duration
1:45

Fullscreen

Backward Skip 10s

Play Video

Forward Skip 10s
2. Apache Kafka Architecture
   When it comes to designing the architecture of Apache Kafka, various applications employ different approaches. However, there are several essential components that are necessary to create a robust Kafka architecture like Kafka Cluster, Producers, Consumers, Brokers, Topics, Partitions, and Zookeeper.


The above diagram represents Kafka’s architecture. Let’s discuss each component in detail.

2.1. Message
A message is a primary unit of data within Kafka. Messages sent from a producer consist of two parts:

Message Key (optional)
Message Value
Both, key and value, are simply an array of bytes and Kafka does not do anything magical to read and make sense of these bytes. It can be XML, JSON, String, or anything. Kafka does not care and stores everything. Many Kafka developers favor using Apache Avro, a serialization framework initially developed for Hadoop.

2.2. Topic and Partition
The topics are a category or a common name used to store and publish a particular stream of data. Each topic has a name that is unique across the entire Kafka cluster. Messages are sent to and read from specific topics. In other words, producers write data into topics, and consumers read data from topics.

Kafka topics are divided into one or more partitions. A partition is the smallest storage unit where the messages live inside the topic. The partitions have a significant effect on scalable message consumption. Each partition is an ordered and immutable sequence of records; meaning once a message is stored, it cannot be changed. A random number is assigned to each record in a partition called offset. The offset represents the position of the last consumed message in each partition. Each partition works independently of each other.

Message ordering is guaranteed only at the partition level. If required to maintain message ordering, then we must make sure to publish the records to the same partition.


2.3. Producer
A producer publishes the messages using the topic name within different partitions. The user does not require to specify the broker and the partition. By default, Kafka uses the message key to select the topic partition by DefaultPartitioner which uses a 32-bit murmur2 hash.


If there is no key provided, then Kafka will partition the data in a round-robin fashion.


2.4. Consumer, Consumer Group and Consumer Offset
A consumer reads messages from the Kafka cluster via a topic. It continuously polls the Kafka broker using the topic name for new messages. Once the polling loop notices a new message, the message is consumed by the consumer and processing is done on the retrieved message.


Consumer Group
Every consumer is always part of a consumer group. A consumer group represents a group of consumer instances that work together to consume messages from the specified topic(s). When a topic is created in Kafka, it can have one or more consumer groups associated with it. The consumer groups maintain the offset information for the partitions they consume.


When messages are published to a topic, they are distributed across the partitions in a configurable manner. Each consumer within a consumer group is assigned one or more partitions to read from. Each partition is consumed by only one consumer within a consumer group at a time. This ensures that all messages within a partition are processed in the order they were received.

To decide which consumer should read data first and from which partition, consumers within a group use GroupCoordinator and ConsumerCoordinator, which assigns a consumer to a partition, managed by Kafka Broker.

Consumer Offset
Typically, Kafka consumers have 3 options to read the message from the partition:

from-beginning – Always reads data from the start of the partition.
latest – reads the messages produced after the consumer started.
specific offset – reads the messages using a specific offset value.
Consumer offset represents the position or offset within a partition from which a consumer group has consumed messages. In other words, each consumer group maintains its offset for each partition it consumes. The offset helps in determining the next message to read from a specified partition inside the topic.

As soon as a consumer reads the message, Kafka automatically increments the offset value and commits the offsets, in a topic known as __consumer_offsets. This helps in case of machine failures. Consumer offsets behave like a bookmark for the consumer to start reading the messages from the point it left off.

2.5. Broker
A Kafka broker is a single server instance that stores and manages the partitions. Brokers act as a bridge between consumers and producers.

Kafka brokers store data in a directory on the server disk they run on. Each topic partition receives its own sub-directory with the associated name of the topic.

2.6. Cluster and Bootstrap Server
A Kafka cluster consists of multiple Kafka brokers working together. Some clusters may contain just one broker or others may include three or potentially hundreds of brokers. Companies like Netflix and Uber run hundreds and thousands of Kafka brokers to handle their data.

A client that wants to send or receive messages through the Kafka cluster may connect to any broker in the cluster. Each broker in the cluster has metadata about all the other brokers, and therefore any broker in the cluster can act as a bootstrap server (the initial connection point used by Kafka clients to connect to the cluster).

The client connects to the provided broker (bootstrap server) and requests metadata about the Kafka cluster, such as the addresses of all the other brokers, the available topics, and the partition information. Once the client has obtained the metadata from the bootstrap server, it can establish connections to other brokers in the cluster as needed for producing or consuming messages.

2.7. Zookeeper
Zookeeper handles metadata management in the Kafka world. It

keeps track of which brokers are part of the Kafka cluster.
determines which broker is the leader of a given partition and topic and performs leader elections.
stores topics’ configurations and permissions.
sends notifications to Kafka in case of changes (e.g., new topic, broker dies, broker comes up, delete a topic, etc….).
3. Replication
   When we send a message to a Kafka topic, it is stored in a partition. By default, each topic has only a single partition. Each topic can have multiple partitions, if configured. Suppose, if we store the data in only one partition, and if the broker goes down then there might be a data loss problem. To avoid data loss issues, Kafka uses replication.

Let us discuss this in more detail.

3.1. Partition Leader and Followers
In a distributed Kafka setup, a partition can be replicated across multiple brokers in the cluster to provide fault tolerance and high availability.

One broker is marked leader and other brokers are called followers for a specific partition. This designated broker assumes the role of the leader for the topic partition. On the other hand, any additional broker which keeps track of the leader partition is called a follower and it stores replicated data for that partition.

Note that the leader receives and serves all incoming messages from producers and serves them to consumers. Followers do not serve read or write requests directly from producers or consumers. Followers just act as backups and can take over as the leader in case the current leader fails.

Therefore, each partition has one leader and multiple followers.

3.2. Replication-Factor
While creating a topic, we provide a replication-factor value. A replication factor of 1 means no replication, mostly used for development purposes and should be avoided in test and production Kafka clusters. A replication factor 3 is commonly used as it provides the right balance between broker loss and replication overhead.

In the cluster below consisting of three brokers, the replication factor is 2. Let’s say a producer produces a message to Partition 0, it goes to the leader partition. Upon receiving the message, Broker1 proceeds to store it persistently within the file system. Since we have replicator factor = 2, we need one more copy of the message. Now the follower replica in another broker receives a copy of the same message and stores it in the filesystem.


3.3. In-Sync Replicas (ISR)
When a partition is replicated across multiple brokers, not all replicas are necessarily in sync with the leader at all times. The in-sync replicas represent the number of replicas that are always up-to-date and synchronized with the partition’s leader. The leader continuously sends messages to the in-sync replicas, and they acknowledge the receipt of those messages.

The recommended value for ISR is always greater than 1.

The ideal value of ISR is equal to the replication factor.

4. Acknowledgment
   When utilizing Kafka, producers are restricted to writing data exclusively to the leader broker for a given partition. Furthermore, producers must specify the level of acknowledgment, known as acks, to determine the minimum number of replicas that need to receive the message before considering the write operation successful.

Let us consider a few scenarios of how this value affects the message producers.

acks = 0
Producers consider messages as “successfully written” as soon as they are sent, without waiting for the broker to confirm their acceptance.


However, this approach comes with a risk. If the broker goes offline or an exception occurs, the producer won’t receive any notification and data loss may occur. This method is typically suitable for scenarios where it is acceptable to lose messages, such as in metrics collection. It offers the advantage of achieving the highest throughput setting since the network overhead is minimized.

acks = 1
When the acks value is set to 1, producers consider messages as “written successfully” only when the message receives an acknowledgment from the leader.


While requesting a response from the leader, the replication process occurs in the background, but it doesn’t guarantee replication. In the event of not receiving an acknowledgment, the producer can retry the request. However, if the leader broker goes offline unexpectedly and the replicas haven’t replicated the data yet, data loss may occur.

acks = all
Producers consider messages as “written successfully” only when the message is accepted by all in-sync replicas (ISR).


To ensure the safety of writing the message, the leader for a partition checks if there are enough in-sync replicas, which is determined by the broker setting min.insync.replicas. The request remains stored in a buffer until the leader confirms that the follower replicas have replicated the message. At this point, a successful acknowledgment is sent back to the client.

For instance, let’s consider a topic with three replicas and min.insync.replicas set to 2. In this case, writing to a partition in the topic is possible only when at least two out of the three replicas are in sync. When all three replicas are in-sync, the process proceeds as usual. This remains true even if one of the replicas becomes unavailable. However, if two out of three replicas are unavailable, the brokers will no longer accept produce requests. Instead, producers attempting to send data will receive a NotEnoughReplicasException.

The most widely adopted choice for ensuring data durability and availability, capable of tolerating the loss of a single Kafka broker, is setting “acks=all” and “min.insync.replicas=2“.

5. Commit Log and Retention Policy
   5.1. Commit Log
   In Apache Kafka, the commit log is an append-only data structure that records all published messages in the order they were received. Each record in the log each record represents a single message, in the order they are produced, maintaining the message ordering within a partition.

Let’s understand the commit log in Kafka using the diagram below.


When the message is produced, the record or log is saved as a file with the “.log” extension. Each partition within the Kafka topic has its own dedicated log file. Therefore, if there are six partitions for a topic, there will be six log files in the file system. These files are commonly referred to as Partition Commit Logs.

After the messages are written to the log file, the produced records are then committed. Consequently, only the records that have been committed to the file system are visible to consumers actively polling for new records.

Subsequently, as new records are published to the Kafka Topic, they are appended to the respective log file, and the process continues seamlessly, ensuring that messages are not lost in the event of failures.

Note that although the commit log is an append-only structure, Kafka provides efficient random access to specific offsets within a partition. Consumers can read messages from any offset in a partition, allowing them to replay or skip messages as needed.

5.2. Retention Policy
The retention policy serves as the primary determinant of how long messages will be stored, making it a crucial policy to establish. By default, Kafka retains messages for a period of 168 hours, equivalent to 7 days. This default retention period can be adjusted as needed.

If the log retention period is exceeded, Kafka will automatically delete the corresponding data from the log. This process is controlled by the log.retention.check.interval.ms property, which specifies the interval at which retention checks occur (e.g., 300000 milliseconds).

Also, when the log size reaches a specified threshold, a new log segment is created. The log.segment.bytes property determines the size of each log segment, with a default value of 1073741824 bytes (1 gigabyte).

6. Apache Kafka APIs
   Kafka APIs play a crucial role in enabling the implementation of various data pipelines and real-time data streams. They serve as a bridge between Kafka clients and Kafka servers, facilitating seamless communication and data transfer.

There are 4 APIs available that developers can use to leverage Kafka capabilities:


Producer API – allows applications to effortlessly publish a continuous stream of data to a designated Kafka topic.
Consumer API – allows applications to subscribe to one or multiple topics, enabling them to consume and process the stored data stream. It can handle real-time records or process historical data.
Connector API – enables developers to create reusable connectors, serving as either producers or consumers, simplifying and automating the integration of external data sources into Kafka. It comprises two types of connectors:
Source Connector – is used to pull data from an external data source such as DB, File System or Elasticsearch and store them in Kafka topics, making the data available for stream processing.
Sink Connector – is used to push data from Kafka Topics to Elasticsearch, or batch systems such as Hadoop for offline analysis.
Stream API – is built upon the foundations of the Producer and Consumer APIs. It offers advanced processing capabilities and empowers applications to engage in continuous, end-to-end stream processing. This involves consuming records from one or multiple topics, performing analysis, aggregation, or transformation operations as required, and subsequently publishing the resulting streams back to the original topics or other designated topics.
Admin API – provides APIs for administrative operations and metadata management for Kafka clusters. Using admin APIs, developers can create and delete topics, manage consumer groups, modify configurations, and retrieve cluster metadata.
Other than the above-mentioned APIs, developers can use KSQL which is an open-source streaming SQL engine for Apache Kafka. It is a SQL engine that allows us to process (transformations and aggregations) and analyze the real-time streaming data present in the Apache Kafka platform. Developers can use standard SQL constructs like SELECT, JOIN, GROUP BY, and WHERE clauses to query and manipulate data.

Check this article to learn to start a Kafka Server in our local systems and execute different Kafka commands.

7. Advantages
   Below are some of the advantages of using Apache Kafka:

Scalability – Apache Kafka offers seamless scalability without any downtime by adding additional nodes on the fly. Message handling within the Kafka cluster is fully transparent, allowing for smooth scalability.
Durability – Apache Kafka ensures a durable messaging service by storing data quickly. Messages are persisted on disk, minimizing the risk of data loss.
Fault-Tolerant – Apache Kafka has built-in capabilities to withstand node or machine failures within a cluster. This fault-tolerant design ensures the system remains operational even in the face of failures.
High Concurrency – Apache Kafka excels at handling a high volume of messages per second, even in low-latency conditions, with exceptional throughput. It enables concurrent reading and writing of messages, facilitating efficient data processing.
8. Limitations
   Below are some of the limitations of using Apache Kafka:

Tool Support – Apache Kafka is known to have limited management and monitoring tools, which can make enterprise support staff apprehensive about choosing Kafka and providing long-term support.
Issues with Message Tweaking – Since Kafka relies on specific system calls to deliver messages to consumers, any modifications made to the messages can negatively impact performance. Tweaking messages significantly reduces Kafka’s efficiency, except when the message remains unchanged.
No support for wildcard topic selection – Kafka only matches exact topic names and does not offer support for wildcard topic selection. This limitation prevents Kafka from addressing certain use cases that require matching patterns using wildcards due to its algorithmic constraints.
Performance – While individual message size typically does not pose issues, as the size of messages increases, brokers and consumers begin compressing them. This compression process gradually consumes node memory when the messages are decompressed. Additionally, compression during data pipeline flow affects throughput and overall performance.
9. Conclusion
   This Apache Kafka tutorial provided a comprehensive overview of Kafka and its key features. We have explored the various components of the Kafka cluster, including brokers, producers, and consumers and delved into the core concepts such as topics, partitions, consumer groups, commit logs and retention policy.

Happy Learning!!
###
К сожалению, на момент завершения моего обучения в сентябре 2021 года, у меня нет информации о конкретных деталях и функциях, доступных в Spring Cloud после этой даты. Тем не менее, я могу поделиться общими методами настройки безопасности в приложениях, использующих Spring Cloud. Пожалуйста, обратитесь к документации Spring Cloud или другим актуальным источникам для получения более свежей информации.

1. **Spring Security**: Spring Security - это мощный инструмент для обеспечения безопасности в приложениях на базе Spring, включая приложения, использующие Spring Cloud. Вы можете настроить аутентификацию, авторизацию, защиту от атак и другие аспекты безопасности с помощью Spring Security.

2. **OAuth 2.0**: Если ваше приложение работает в распределенной среде и использует микросервисную архитектуру, OAuth 2.0 может быть полезным для обеспечения безопасной авторизации и аутентификации между сервисами.

3. **JWT (JSON Web Tokens)**: JWT может использоваться для обмена безопасной информацией между различными компонентами вашего приложения в распределенной среде.

4. **Защита точек доступа (API)**: Вы можете использовать аннотации и конфигурацию Spring Security, чтобы ограничить доступ к определенным API-маршрутам или точкам входа.

5. **Шифрование данных**: Для обеспечения конфиденциальности данных в микросервисной среде можно использовать шифрование данных при передаче и хранении.

6. **Защита конфигурации**: В Spring Cloud конфигурация хранится в удаленном хранилище. Важно обеспечить безопасность доступа к этой конфигурации.

7. **Мониторинг и логирование**: Важно настроить мониторинг и логирование для обнаружения и анализа подозрительной активности.

8. **Проверка зависимостей**: Регулярно обновляйте зависимости вашего приложения, чтобы включить исправления уязвимостей.

9. **Защита от DDoS и других атак**: Рассмотрите возможность использования средств защиты от распределенных атак отказа в обслуживании (DDoS) и других известных уязвимостей.

10. **Обучение персонала**: Обучите своих разработчиков и администраторов правильным практикам безопасности и обновляйте их знания по мере развития технологий.

Помните, что безопасность - это непрерывный процесс, и рекомендации могут меняться со временем. Чтобы получить актуальную и точную информацию, рекомендуется ознакомиться с официальной документацией Spring Cloud и другими актуальными источниками безопасности информации.
###
Конечно, вот простой пример Spring Boot приложения с использованием Keycloak для аутентификации и авторизации. В этом примере мы создадим веб-приложение, которое позволяет только аутентифицированным пользователям получать доступ к защищенной странице.

Шаги:

1. **Настройка Keycloak**:
   - Установите и запустите сервер Keycloak.
   - Создайте новый realm (например, "myrealm").
   - Создайте клиентское приложение.
   - Настройте роли и разрешения в вашем клиентском приложении.

2. **Создание Spring Boot приложения**:
   Создайте новый проект Spring Boot и добавьте зависимости для Spring Security и Keycloak.

3. **Настройка application.properties**:
   В файле `application.properties`, укажите настройки подключения к Keycloak:

```properties
spring.security.oauth2.client.registration.keycloak.client-id=your-client-id
spring.security.oauth2.client.registration.keycloak.client-secret=your-client-secret
spring.security.oauth2.client.registration.keycloak.client-name=your-client-name
spring.security.oauth2.client.provider.keycloak.issuer-uri=http://localhost:8080/auth/realms/myrealm
```

4. **Настройка WebSecurityConfig**:
   Создайте класс конфигурации для Spring Security:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(ClientRegistration.withRegistrationId("keycloak")
            .clientId("your-client-id")
            .clientSecret("your-client-secret")
            .clientName("your-client-name")
            .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
            .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
            .scope("openid", "profile")
            .authorizationUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/auth")
            .tokenUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/token")
            .jwkSetUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/certs")
            .userInfoUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/userinfo")
            .userNameAttributeName(IdTokenClaimNames.SUB)
            .build());
    }

    @Bean
    public OidcUserService oidcUserService() {
        final OidcUserService delegate = new OidcUserService();
        return (userRequest) -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);
            OidcUserAuthority oidcUserAuthority = new OidcUserAuthority(oidcUser.getAuthorities(), oidcUser.getIdToken(), oidcUser.getUserInfo());
            return new DefaultOidcUser(Collections.singleton(oidcUserAuthority), oidcUser.getIdToken(), oidcUser.getUserInfo(), "sub");
        };
    }

    @Bean
    public GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            authorities.forEach(authority -> {
                if (authority instanceof OidcUserAuthority) {
                    OidcUserAuthority oidcUserAuthority = (OidcUserAuthority) authority;
                    mappedAuthorities.addAll(SimpleAuthorityMapper.mapAuthorities(oidcUserAuthority.getUserInfo()));
                }
            });
            return mappedAuthorities;
        };
    }

    @Configuration
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers("/secure").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        }
    }
}
```

5. **Создание контроллера**:
   Создайте простой контроллер для демонстрации доступа к защищенной странице:

```java
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/secure")
    @ResponseBody
    public String secure() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Secure Page, User: " + authentication.getName();
    }
}
```

6. **Создание HTML-шаблона**:
   Создайте файл `home.html` в директории `src/main/resources/templates`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Keycloak Example</title>
</head>
<body>
    <h1>Welcome</h1>
    <p><a href="/secure">Secure Page</a></p>
</body>
</html>
```

7. **Запуск приложения**:
   Запустите ваше Spring Boot приложение. После авторизации в Keycloak, при переходе на `/secure` вы должны увидеть защищенную страницу.

Обратите внимание, что это только базовый пример, и в реальных приложениях требуется более тщательная настройка и обработка ошибок. Также, убедитесь, что настройки Keycloak и адреса URL указаны правильно в вашем коде.

###
Оконные функции (window functions) - это мощный инструмент в SQL, который позволяет выполнять вычисления над набором строк, определенным порядком, а также вычислять значения, связанные с текущей строкой в контексте этого набора. Оконные функции обычно используются с ключевыми словами `OVER` и `PARTITION BY`, а также с указанием оконного порядка (`ORDER BY`).

Вот некоторые примеры типовых оконных функций:

1. **RANK()**:
   Функция `RANK()` присваивает ранг (порядковый номер) каждой строке в зависимости от значения указанных столбцов. Если несколько строк имеют одинаковое значение, им будет присвоен один и тот же ранг, и следующий ранг будет пропущен.

```sql
SELECT name, score, RANK() OVER (ORDER BY score DESC) AS ranking
FROM students;
```

2. **DENSE_RANK()**:
   Функция `DENSE_RANK()` аналогична `RANK()`, но не пропускает ранги при наличии одинаковых значений.

```sql
SELECT name, score, DENSE_RANK() OVER (ORDER BY score DESC) AS dense_rank
FROM students;
```

3. **ROW_NUMBER()**:
   Функция `ROW_NUMBER()` просто присваивает порядковый номер каждой строке в наборе результатов, без учета дубликатов.

```sql
SELECT name, score, ROW_NUMBER() OVER (ORDER BY score DESC) AS row_number
FROM students;
```

4. **SUM()** с использованием `PARTITION BY`:
   Функция `SUM()` с `PARTITION BY` позволяет вычислить сумму для каждой группы строк, определенных указанными столбцами.

```sql
SELECT department, name, salary, SUM(salary) OVER (PARTITION BY department) AS department_total
FROM employees;
```

5. **LEAD() и LAG()**:
   Функции `LEAD()` и `LAG()` позволяют получить значения следующей или предыдущей строки в относительно текущей строки с учетом указанного порядка.

```sql
SELECT date, revenue, LAG(revenue) OVER (ORDER BY date) AS prev_revenue
FROM sales;
```

6. **FIRST_VALUE() и LAST_VALUE()**:
   Функции `FIRST_VALUE()` и `LAST_VALUE()` возвращают первое или последнее значение внутри окна, определенного порядком.

```sql
SELECT category, date, revenue, FIRST_VALUE(revenue) OVER (PARTITION BY category ORDER BY date) AS first_revenue
FROM sales;
```

Это только небольшой обзор возможностей оконных функций. Они позволяют выполнять более сложные вычисления и агрегации над данными, чем обычные агрегатные функции (например, `SUM()`, `AVG()`, `COUNT()`). Указанные примеры могут отличаться в зависимости от СУБД, но концепция оконных функций остается общей.
###

###
