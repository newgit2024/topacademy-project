package ionio.serialization;

import java.io.*;

public class App {
    public static void main(String[] args) {
        //serializeEmployee();
        String dep = "HR";
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("storage/employee.txt"))){
            Employee o = (Employee) input.readObject();
            System.out.println(o);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serializeEmployee() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("storage\\employee.txt"))){
            Employee employee = new Employee("Ivanov", 1, "abcdef");
            System.out.println(employee);
            outputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
