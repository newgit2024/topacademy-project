package enums;

public class App {
    public static void main(String[] args) {
        Role role = Role.valueOf("Admin".toUpperCase());
        for (Role value:Role.values()) {
            System.out.println(value);
        }

        switch (role) {
            case GUEST :
                System.out.println("lowest access");
            case CLIENT:
                System.out.println("low access");
            case MODERATOR:
                System.out.println("medium access");
            case ADMIN:
                System.out.println("high access");
            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
    }
}
