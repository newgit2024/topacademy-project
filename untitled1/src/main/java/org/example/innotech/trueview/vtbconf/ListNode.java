package org.example.innotech.trueview.vtbconf;

public class ListNode {
    Node head;

    int count;
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }


    }


    void add(int v){
        if (head.next == null){
            head.next = new Node(v);
        }
        head.next.value = v;
        count++;
    }


    void remove(){
        if (head.next != null){
            head.next = null;
            count--;
        }

    }

    int size(){
        return count;
    }

    Node getByIndex(int index){
        Node cur = head;
        int i = 0;
        while(i < index && cur != null){
            cur = cur.next;
            i++;
        }
        return cur;
    }


    /*Node getByIndexRecursion(int index){
        if (index == 0){
            return this.head;
        }

        if (this.head.next == null){
            throw new IllegalArgumentException();
        }
        return this.head.next.getByIndexRecursion(--index);
    }*/
    public Node getNodeByIndex(int index) {
        if (head == null || index < 0) {
            return null; // Возвращаем null для некорректных значений
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current; // Нашли узел с нужным индексом
            }

            current = current.next;
            currentIndex++;
        }

        return null; // Индекс выходит за пределы списка
    }

    // Вспомогательный метод для рекурсивного поиска узла по индексу
    private Node getNodeByIndexRecursive2(Node current, int index, int currentIndex) {
        if (current == null) {
            return null; // Дошли до конца списка, узел не найден
        }

        if (currentIndex == index) {
            return current; // Нашли узел с нужным индексом
        }

        return getNodeByIndexRecursive2(current.next, index, currentIndex + 1);
    }

    // Метод для вызова извне, начинает рекурсивный поиск с головы списка
    public Node getNodeByIndex2(int index) {
        if (index < 0) {
            return null; // Возвращаем null для некорректных значений
        }

        return getNodeByIndexRecursive2(head, index, 0);
    }

    Node reverseNodeList(){
        Node prev = null;
        Node next = null;
        Node cur = head;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        return prev;
    }
}
