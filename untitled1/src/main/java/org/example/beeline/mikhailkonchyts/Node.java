package org.example.beeline.mikhailkonchyts;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    // prev cur  next
    //      N1 -> N2 -> N3 -> N4...
    // null head  null
    //            N2
    //            null(prev)
    //  N1
    //      N2
    //      N3 -> N2 -> N1 -> N6
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // next = N1.next     N1 = N2
            current.next = prev; // N1.next = prev.N1     N2 = N0 (null)
            prev = current; // prev.N1 = N1     N0 (null) =
            current = next; // N1 = N1.next
        }

        head = prev;
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Исходный список:");
        list.print();

        list.reverse();
        System.out.println("Развернутый список:");
        list.print();
    }
}


/*
Для разворота односвязного списка (связанного списка) вы можете использовать следующий алгоритм. Предположим, что у вас есть класс `ListNode`, представляющий узлы списка:

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
```

Теперь, чтобы развернуть односвязный список, вы можете использовать следующий Java-код:

```java
public ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

//  1 2 3 -> 3 2 1
    while (current != null) {
        ListNode nextTemp = current.next; // Сохраняем следующий узел 3

        // Разворачиваем указатель на следующий узел 3 -> 1
        current.next = prev;

        // Переходим к следующему узлу 1 -> 2
        prev = current;
        current = nextTemp; 2 -> 3
    }

    // После завершения цикла prev будет указывать на новую голову развернутого списка
    return prev;

}

public ListNode reverseLinkedList2(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

//  1 2 3 -> 3 2 1
    while (current != null) {
       ListNode tempNext = current.next; // tempNext = new ListNode(2);
       current.next = prev; // head.next = null -> ListNode(1), null
       prev = current; // 
       current = tempNext;
    }

    // После завершения цикла prev будет указывать на новую голову развернутого списка
    return prev;

}
```

Используйте этот метод, передавая ему голову вашего односвязного списка. Этот код изменяет указатели узлов таким образом, что список разворачивается в обратном порядке.
 */



