###
Конечно, вот пример реализации структуры данных "очередь" на основе массива в отдельном классе:

```java
public class ArrayQueue<T> {
    private int maxSize;
    private Object[] array;
    private int front; // Индекс начала очереди
    private int rear; // Индекс конца очереди
    private int size; // Текущий размер очереди

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % maxSize;
        array[rear] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) array[front];
        front = (front + 1) % maxSize;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }
}
```

Вы можете использовать этот класс для создания объектов очереди на основе массива. Пример использования:

```java
public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(5);

        queue.enqueue("Item 1");
        queue.enqueue("Item 2");
        queue.enqueue("Item 3");

        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Peeked item: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("Is the queue full? " + queue.isFull());
    }
}
```

Обратите внимание, что в этой реализации, когда мы достигаем конца массива, мы "зацикливаем" индекс с помощью операции `% maxSize`, чтобы вернуться к началу массива. Это позволяет обойти ограничения массива и создать циклическую структуру.
###
