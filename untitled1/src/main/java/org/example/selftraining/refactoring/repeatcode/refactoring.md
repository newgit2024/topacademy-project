Конечно! Ниже представлены примеры кода, которые нуждаются в рефакторинге, а также их решения с применением различных паттернов.

1. Пример кода с повторяющимся куском:

```java
public void processUserData(User user) {
    if (user.isAdmin()) {
        // код для обработки данных администратора
        log.info("Processing admin data");
        // ...
    } else {
        // код для обработки данных обычного пользователя
        log.info("Processing regular user data");
        // ...
    }
}
```

Решение: Вынесем повторяющийся код в отдельные методы с понятными именами.

```java
public void processUserData(User user) {
    if (user.isAdmin()) {
        processAdminData(user);
    } else {
        processRegularUserData(user);
    }
}

private void processAdminData(User user) {
    log.info("Processing admin data");
    // ...
}

private void processRegularUserData(User user) {
    log.info("Processing regular user data");
    // ...
}
```

2. Пример кода с магическим числом:

```java
public double calculateCircleArea(double radius) {
    return 3.14 * radius * radius;
}
```

Решение: Заменим магическое число на константу с понятным именем.

```java
private static final double PI = 3.14;

public double calculateCircleArea(double radius) {
    return PI * radius * radius;
}
```

3. Пример кода с длинной цепочкой вызовов методов:

```java
public String formatFullName(String firstName, String middleName, String lastName) {
    return firstName.trim() + " " + middleName.trim() + " " + lastName.trim();
}
```

Решение: Применим паттерн "Цепочка вызовов" для упрощения кода.

```java
public String formatFullName(String firstName, String middleName, String lastName) {
    return new StringBuilder()
            .append(firstName.trim())
            .append(" ")
            .append(middleName.trim())
            .append(" ")
            .append(lastName.trim())
            .toString();
}
```

4. Пример кода с длинной цепочкой if-else операторов:

```java
public String getGrade(int score) {
    if (score >= 90) {
        return "A";
    } else if (score >= 80) {
        return "B";
    } else if (score >= 70) {
        return "C";
    } else if (score >= 60) {
        return "D";
    } else {
        return "F";
    }
}
```

Решение: Применим паттерн "Состояние" для упрощения кода.

```java
public interface Grade {
    String getGrade(int score);
}

public class AGrade implements Grade {
    @Override
    public String getGrade(int score) {
        return "A";
    }
}

public class BGrade implements Grade {
    @Override
    public String getGrade(int score) {
        return "B";
    }
}

// Аналогично классы для остальных оценок C, D, F.

public class GradeCalculator {
    private Grade grade;

    public GradeCalculator(int score) {
        if (score >= 90) {
            grade = new AGrade();
        } else if (score >= 80) {
            grade = new BGrade();
        } else if (score >= 70) {
            grade = new CGrade();
        } else if (score >= 60) {
            grade = new DGrade();
        } else {
            grade = new FGrade();
        }
    }

    public String getGrade() {
        return grade.getGrade();
    }
}
```

5. Пример кода с длинными методами и множеством обязанностей:

```java
public class Order {
    public void processOrder(String paymentMethod, boolean isGift, boolean isExpress) {
        // обработка заказа
        if (isGift) {
            // обработка подарка
        }
        if (isExpress) {
            // обработка экспресс-доставки
        }
        if (paymentMethod.equals("creditCard")) {
            // обработка оплаты кредитной картой
        } else if (paymentMethod.equals("paypal")) {
            // обработка оплаты через PayPal
        } else {
            // обработка других методов оплаты
        }
        // ...
    }
}
```

Решение: Разделим методы на более мелкие методы с единственной ответственностью.

```java
public class Order {
    public void processOrder(String paymentMethod, boolean isGift, boolean isExpress) {
        // обработка заказа
        processGift(isGift);
        processExpressDelivery(isExpress);
        processPayment(paymentMethod);
        // ...
    }

    private void processGift(boolean isGift) {
        if (isGift) {
            // обработка подарка
        }
    }

    private void processExpressDelivery(boolean isExpress) {
        if (isExpress) {
            // обработка экспресс-доставки
        }
    }

    private void processPayment(String paymentMethod) {
        if (paymentMethod.equals("creditCard")) {
            // обработка оплаты кредитной картой
        } else if (paymentMethod.equals("paypal")) {
            // обработка оплаты через PayPal
        } else {
            // обработка других методов оплаты
        }
    }
}
```

Эти примеры помогут вам понять, как применить различные паттерны и улучшить структуру и читаемость кода.