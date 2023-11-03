package ionio.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    static String department = "factory";
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 1L;


    public Employee(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
