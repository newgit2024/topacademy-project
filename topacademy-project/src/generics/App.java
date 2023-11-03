package generics;

public class App {
    public static void main(String[] args) {
        Post<Short, String> text = new Post<>();
        Post<Double, Integer> number = new Post<>();

        // text = number;

        System.out.println("----------");

        Message<Integer> o1 = new Message<>();
        o1.setValue(1);
        int v1 = o1.getValue();
        System.out.println(v1);

        Message<String> o2 = new Message<>("Hello");
        System.out.println(o2.getValue());

       // o1 = o2;
        /*
        Message2 o11 = new Message2();
        o11.setValue(1);
        System.out.println(o11.getValue());

        Message2 o22 = new Message2("Hello");
        System.out.println(o2.getValue());
        o11 = o22;

         */

        // Message o3 = new Message();
        // o3 = o1;

        System.out.println("----------");

        Task<Double> task1 = new Task<>("task1",89.52d);
        Task<Double> task2 = new Task<>("task2",72.67d);
        System.out.println(task1.equalsToMark(task2));
        Task<Integer> task3 = new Task<>("task3", 45);
        System.out.println(task1.equalsToMark(task3));


    }
}
