Конечно! Вот 20 задач с примерами кода, которые нуждаются в рефакторинге, а также их решения с применением различных паттернов и хороших практик программирования:

1. Задача: Длинный метод с повторяющимися участками кода.

```java
public void processUserData(User user) {
    // Часть 1: код для обработки данных пользователя
    // ...
    // Часть 2: код для проверки и обработки возраста пользователя
    // ...
    // Часть 3: код для отправки уведомления пользователю
    // ...
}
```

Решение: Разделить метод на несколько мелких методов с четко определенной ответственностью.

```java
public void processUserData(User user) {
    processUser(user);
    checkUserAge(user);
    sendNotification(user);
}

private void processUser(User user) {
    // код для обработки данных пользователя
    // ...
}

private void checkUserAge(User user) {
    // код для проверки и обработки возраста пользователя
    // ...
}

private void sendNotification(User user) {
    // код для отправки уведомления пользователю
    // ...
}
```

2. Задача: Использование магических чисел без объяснения.

```java
public double calculateCircleArea(double radius) {
    return 3.14 * radius * radius;
}
```

Решение: Заменить магическое число на константу с понятным именем.

```java
private static final double PI = 3.14;

public double calculateCircleArea(double radius) {
    return PI * radius * radius;
}
```

3. Задача: Переключатель с множеством кейсов.

```java
public String getDayOfWeek(int day) {
    switch (day) {
        case 1:
            return "Monday";
        case 2:
            return "Tuesday";
        // ... Код для остальных дней недели ...
        default:
            return "Invalid day";
    }
}
```

Решение: Использовать маппинг или Enum для замены переключателя.

```java
public String getDayOfWeek(int day) {
    Map<Integer, String> daysMap = Map.of(
        1, "Monday",
        2, "Tuesday",
        // ... Маппинг для остальных дней недели ...
    );

    return daysMap.getOrDefault(day, "Invalid day");
}
```

или

```java
public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    // ... Перечисление для остальных дней недели ...

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public String getDayOfWeek(int day) {
    try {
        return DayOfWeek.values()[day - 1].getName();
    } catch (ArrayIndexOutOfBoundsException e) {
        return "Invalid day";
    }
}
```

4. Задача: Метод с множеством вложенных условий.

```java
public String getWeatherAdvice(int temperature, boolean isRaining) {
    if (temperature < 10) {
        if (isRaining) {
            return "Wear a warm coat and take an umbrella.";
        } else {
            return "Wear a warm coat.";
        }
    } else if (temperature >= 10 && temperature < 20) {
        if (isRaining) {
            return "Wear a light jacket and take an umbrella.";
        } else {
            return "Wear a light jacket.";
        }
    } else {
        return "Wear light clothing.";
    }
}
```

Решение: Применить паттерн "Цепочка обязанностей" для уменьшения вложенности условий.

```java
public interface WeatherAdvice {
    String getAdvice(int temperature, boolean isRaining);
}

public class ColdWeatherAdvice implements WeatherAdvice {
    @Override
    public String getAdvice(int temperature, boolean isRaining) {
        if (isRaining) {
            return "Wear a warm coat and take an umbrella.";
        } else {
            return "Wear a warm coat.";
        }
    }
}

public class ModerateWeatherAdvice implements WeatherAdvice {
    @Override
    public String getAdvice(int temperature, boolean isRaining) {
        if (isRaining) {
            return "Wear a light jacket and take an umbrella.";
        } else {
            return "Wear a light jacket.";
        }
    }
}

public class HotWeatherAdvice implements WeatherAdvice {
    @Override
    public String getAdvice(int temperature, boolean isRaining) {
        return "Wear light clothing.";
    }
}

public String getWeatherAdvice(int temperature, boolean isRaining) {
    WeatherAdvice coldWeatherAdvice = new ColdWeatherAdvice();
    WeatherAdvice moderateWeatherAdvice = new ModerateWeatherAdvice();
    WeatherAdvice hotWeatherAdvice = new HotWeatherAdvice();

    if (temperature < 10) {
        return coldWeatherAdvice.getAdvice(temperature, isRaining);
    } else if (temperature >= 10 && temperature < 20) {
        return moderateWeatherAdvice.getAdvice(temperature, isRaining);
    } else {
        return hotWeatherAdvice.getAdvice(temperature, isRaining);
    }
}
```

5. Задача: Класс с большим числом методов и обязанностей.

```java
public class Product {
    public void createProduct() {
        // Код для создания продукта
    }

    public void updateProduct() {
        // Код для обновления продукта
    }

    public void deleteProduct() {
        // Код для удаления продукта
    }

    public void getProductDetails() {
        // Код для получения деталей продукта
    }

    // ... Много других методов ...
}
```

Решение: Разделить класс на несколько более мелких классов с единственной ответственностью.

```java
public class ProductService {
    public void createProduct() {
        // Код для создания продукта
    }

    public void updateProduct() {
        // Код для обновления продукта
    }

    public void deleteProduct() {
        // Код для удаления продукта
    }
}

public class ProductDetails {
    public void getProductDetails() {
        // Код для получения деталей продукта
    }
}

// ... Другие классы для других метод

ов ...
```

6. Задача: Дублирование кода в различных классах.

```java
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }
}

public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return 3.14 * side * side;
    }
}
```

Решение: Создать родительский класс с общим методом.

```java
public abstract class Shape {
    public abstract double getArea();
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }
}

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
```

7. Задача: Множество методов с дублирующимися параметрами.

```java
public class Employee {
    public void updateName(String name) {
        // Код для обновления имени
    }

    public void updateSalary(double salary) {
        // Код для обновления зарплаты
    }

    public void updateAddress(String address) {
        // Код для обновления адреса
    }

    // ... Много других методов с параметрами ...
}
```

Решение: Создать класс с общими параметрами и методами.

```java
public class Employee {
    private String name;
    private double salary;
    private String address;

    // Геттеры и сеттеры для полей name, salary, address

    public void updateName(String name) {
        this.name = name;
        // Код для обновления имени
    }

    public void updateSalary(double salary) {
        this.salary = salary;
        // Код для обновления зарплаты
    }

    public void updateAddress(String address) {
        this.address = address;
        // Код для обновления адреса
    }
}
```

8. Задача: Длинные цепочки вызовов методов.

```java
public void processOrder(Order order) {
    order.calculateTotalPrice();
    order.applyDiscount();
    order.verifyStockAvailability();
    order.confirmPayment();
    // ... Много других методов ...
}
```

Решение: Применить паттерн "Цепочка вызовов" для упрощения кода.

```java
public class Order {
    private double totalPrice;
    private boolean isDiscountApplied;
    private boolean isStockAvailable;
    private boolean isPaymentConfirmed;

    // Геттеры и сеттеры для полей

    public Order calculateTotalPrice() {
        // Код для расчета общей стоимости
        return this;
    }

    public Order applyDiscount() {
        // Код для применения скидки
        return this;
    }

    public Order verifyStockAvailability() {
        // Код для проверки наличия товара на складе
        return this;
    }

    public Order confirmPayment() {
        // Код для подтверждения оплаты
        return this;
    }
}
```

9. Задача: Метод с большим числом параметров.

```java
public double calculateTotalPrice(double price, double tax, double discount, boolean isShippingFree) {
    // Код для расчета общей стоимости
    // ...
}
```

Решение: Использовать объект для передачи параметров.

```java
public class PriceCalculationParams {
    private double price;
    private double tax;
    private double discount;
    private boolean isShippingFree;

    // Геттеры и сеттеры для полей
}

public double calculateTotalPrice(PriceCalculationParams params) {
    // Код для расчета общей стоимости с использованием параметров из объекта params
    // ...
}
```

10. Задача: Использование сильной связности между классами.

```java
public class Order {
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void processOrder() {
        // Код для обработки заказа, использующий данные из класса Customer
    }
}

public class Customer {
    private String name;
    private String address;

    // Геттеры и сеттеры для полей
}
```

Решение: Использовать интерфейс для уменьшения связности.

```java
public interface Customer {
    String getName();
    String getAddress();
}

public class DefaultCustomer implements Customer {
    private String name;
    private String address;

    // Реализация геттеров и сеттеров для полей name и address

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }
}

public class Order {
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void processOrder() {
        // Код для обработки заказа, использующий методы из интерфейса Customer
        String name = customer.getName();
        String address = customer.getAddress();
        // ...
    }
}
```

11. Задача: Использование публичных полей вместо геттеров и сеттеров.

```java
public class Person {
    public String name;
    public int age;
    // ...
}
```

Решение: Использовать приватные поля и геттеры/сеттеры для доступа к данным.

```java
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

12. Задача: Использование геттеров и сеттеров для бизнес-логики.

```java
public class Product {
    private double price;

    public double getPrice() {
        if (discountAvailable) {
            return price * 0.9; // Применяем скидку 10%
        } else {
            return price;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscountAvailable

() {
        return discountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        this.discountAvailable = discountAvailable;
    }
}
```

Решение: Вынести бизнес-логику из геттера в отдельный метод.

```java
public class Product {
    private double price;
    private boolean discountAvailable;

    public double getPrice() {
        if (discountAvailable) {
            return applyDiscount(price);
        } else {
            return price;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        this.discountAvailable = discountAvailable;
    }

    private double applyDiscount(double price) {
        return price * 0.9; // Применяем скидку 10%
    }
}
```

13. Задача: Использование вложенных блоков с условиями.

```java
public void processOrder(Order order) {
    if (order != null) {
        if (order.isPaid()) {
            if (order.isInStock()) {
                // Обработка заказа
                // ...
            } else {
                // Обработка случая, когда товара нет в наличии
                // ...
            }
        } else {
            // Обработка случая, когда заказ не оплачен
            // ...
        }
    }
}
```

Решение: Использовать ранний выход и избежать вложенных блоков.

```java
public void processOrder(Order order) {
    if (order == null) {
        return;
    }

    if (!order.isPaid()) {
        // Обработка случая, когда заказ не оплачен
        // ...
        return;
    }

    if (!order.isInStock()) {
        // Обработка случая, когда товара нет в наличии
        // ...
        return;
    }

    // Обработка заказа
    // ...
}
```

14. Задача: Использование дублирующегося кода в разных методах.

```java
public void processOrder(Order order) {
    // Код для обработки заказа
    // ...
    logAudit("Order processed");
}

public void cancelOrder(Order order) {
    // Код для отмены заказа
    // ...
    logAudit("Order cancelled");
}

private void logAudit(String message) {
    // Код для записи аудита в лог
    // ...
}
```

Решение: Вынести дублирующийся код в отдельный приватный метод.

```java
public void processOrder(Order order) {
    // Код для обработки заказа
    // ...
    logAudit("Order processed");
}

public void cancelOrder(Order order) {
    // Код для отмены заказа
    // ...
    logAudit("Order cancelled");
}

private void logAudit(String message) {
    // Код для записи аудита в лог
    // ...
}
```

15. Задача: Использование длинных списков аргументов для методов.

```java
public void createUser(String username, String password, String email, String fullName, int age, String address) {
    // Код для создания пользователя
    // ...
}
```

Решение: Использовать объект или билдер для передачи параметров.

```java
public class User {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private int age;
    private String address;

    // Геттеры и сеттеры для полей
}

public void createUser(User user) {
    // Код для создания пользователя с использованием параметров из объекта user
    // ...
}
```

или

```java
public class UserBuilder {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private int age;
    private String address;

    // Методы для установки значений полей

    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setAge(age);
        user.setAddress(address);
        return user;
    }
}

public void createUser(String username, String password, String email, String fullName, int age, String address) {
    User user = new UserBuilder()
        .username(username)
        .password(password)
        .email(email)
        .fullName(fullName)
        .age(age)
        .address(address)
        .build();

    // Код для создания пользователя с использованием объекта user
    // ...
}
```

16. Задача: Использование методов с сильной связностью.

```java
public class Order {
    public void processPayment(String paymentMethod) {
        if (paymentMethod.equals("creditCard")) {
            processCreditCardPayment();
        } else if (paymentMethod.equals("paypal")) {
            processPaypalPayment();
        } else {
            // Обработка других методов оплаты
        }
    }

    private void processCreditCardPayment() {
        // Код для обработки оплаты кредитной картой
    }

    private void processPaypalPayment() {
        // Код для обработки оплаты через PayPal
    }

    // ... Много других методов ...
}
```

Решение: Использовать паттерн "Стратегия" для уменьшения связности.

```java
public interface PaymentProcessor {
    void processPayment();
}

public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        // Код для обработки оплаты кредитной картой
    }
}

public class PaypalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        // Код для обработки оплаты через PayPal
    }
}

public class Order {
    private PaymentProcessor paymentProcessor;

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment() {
        paymentProcessor.processPayment();
    }
}
```

17. Задача: Наличие длинных методов в контроллерах или сервисах.

```java
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String getProducts(Model model) {
        // Код для получения списка продуктов
        // ...
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/products/{id}")
    public String getProductDetails(@PathVariable int id, Model model) {
        // Код для получения деталей

 продукта по его идентификатору
        // ...
        model.addAttribute("product", product);
        return "product_details";
    }

    // ... Много других методов ...
}
```

Решение: Разделить длинные методы на более мелкие и вынести бизнес-логику в сервисы.

```java
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/products/{id}")
    public String getProductDetails(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_details";
    }
}

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        // Код для получения списка продуктов
        // ...
    }

    public Product getProductById(int id) {
        // Код для получения деталей продукта по его идентификатору
        // ...
    }
}
```

18. Задача: Использование дублирующихся SQL-запросов в DAO классах.

```java
public class ProductDao {
    public Product getProductById(int id) {
        String query = "SELECT * FROM products WHERE id = " + id;
        // Код для выполнения SQL-запроса и получения продукта по его идентификатору
        // ...
    }

    public List<Product> getProductsByCategory(String category) {
        String query = "SELECT * FROM products WHERE category = '" + category + "'";
        // Код для выполнения SQL-запроса и получения списка продуктов по категории
        // ...
    }

    // ... Много других методов ...
}
```

Решение: Вынести SQL-запросы в константы и использовать параметризованные запросы.

```java
public class ProductDao {
    private static final String SELECT_PRODUCT_BY_ID_QUERY = "SELECT * FROM products WHERE id = ?";
    private static final String SELECT_PRODUCTS_BY_CATEGORY_QUERY = "SELECT * FROM products WHERE category = ?";

    public Product getProductById(int id) {
        // Код для выполнения параметризованного SQL-запроса и получения продукта по его идентификатору
        // ...
    }

    public List<Product> getProductsByCategory(String category) {
        // Код для выполнения параметризованного SQL-запроса и получения списка продуктов по категории
        // ...
    }
}
```

19. Задача: Метод с большим числом условий и обработки исключений.

```java
public void processOrder(Order order) {
    if (order != null) {
        if (order.isPaid()) {
            try {
                order.processPayment();
                order.shipOrder();
            } catch (PaymentException e) {
                // Обработка исключения при оплате заказа
                // ...
            } catch (ShippingException e) {
                // Обработка исключения при доставке заказа
                // ...
            }
        } else {
            // Обработка случая, когда заказ не оплачен
            // ...
        }
    }
}
```

Решение: Вынести обработку условий и исключений в отдельные методы.

```java
public void processOrder(Order order) {
    if (order == null) {
        return;
    }

    if (!order.isPaid()) {
        handleUnpaidOrder();
        return;
    }

    try {
        processPaidOrder(order);
    } catch (PaymentException e) {
        handlePaymentException(e);
    } catch (ShippingException e) {
        handleShippingException(e);
    }
}

private void handleUnpaidOrder() {
    // Обработка случая, когда заказ не оплачен
    // ...
}

private void processPaidOrder(Order order) throws PaymentException, ShippingException {
    order.processPayment();
    order.shipOrder();
}

private void handlePaymentException(PaymentException e) {
    // Обработка исключения при оплате заказа
    // ...
}

private void handleShippingException(ShippingException e) {
    // Обработка исключения при доставке заказа
    // ...
}
```

20. Задача: Использование "грязного" кода с ненужными комментариями и закомментированными участками.

```java
public class OrderProcessor {
    // ... Куча закомментированного кода ...

    /**
     * Метод для обработки заказа.
     * @param order Заказ для обработки.
     */
    public void processOrder(Order order) {
        // Код для обработки заказа
        // ...
    }

    // ... Еще больше закомментированного кода ...
}
```

Решение: Удалить закомментированный код и лишние комментарии.

```java
public class OrderProcessor {
    public void processOrder(Order order) {
        // Код для обработки заказа
        // ...
    }
}
```

Такие примеры кода требуют рефакторинга для повышения его качества, улучшения читаемости, уменьшения дублирования и связности, а также снижения сложности.