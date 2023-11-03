package records;

public class App {
    public static void main(String[] args) {
        ImmutableRecord o = new ImmutableRecord("Record", 1);
        System.out.println(o.id());
        System.out.println(o.name());
        System.out.println(o);
        ImmutableRecord o2 = new ImmutableRecord("Record", 1);
        System.out.println(o.equals(o2));
    }
}
