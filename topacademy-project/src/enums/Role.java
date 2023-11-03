package enums;

public enum Role {
    GUEST ("Гость"), CLIENT ("Клиент"), MODERATOR("Модератор"), ADMIN("Админ");
    private String typeName;

    Role(String typeName) {
        this.typeName = typeName;
    }
}
