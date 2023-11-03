package threads.synchro;

public class App {
    public static void main(String[] args) {
        Card card = new Card(1000);
        Human ivan = new Human(card, "Ivan");
        Human mariya = new Human(card, "Mariya");

        ivan.start();
        mariya.start();
    }
}
