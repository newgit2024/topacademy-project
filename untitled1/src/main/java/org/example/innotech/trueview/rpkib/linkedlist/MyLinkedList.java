package org.example.innotech.trueview.rpkib.linkedlist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void remove(T data) {
        if (head == null) {
            return; // Список пуст, ничего не удаляем
        }

        if (head.getData().equals(data)) {
            head = head.getNext(); // Удаление из начала списка
            size--;
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext()); // Удаление из середины списка
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void reverse2(){
        Node<T> cur = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (cur != null){
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
    }

    public void reverse() {
        // prev -> cur -> next => prev <- cur <- next
        // prev = null -> N1 -> N1.next = N2
        //                        prev => prev <- cur <- next
        //
        // bufCurNext = N1.next = N2
        // N1.next = prev
        // prev = cur
        // cur = next
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (current != null) {
            next = current.getNext(); // Сохраняем ссылку на следующий узел
            current.setNext(prev);    // Меняем направление ссылки на предыдущий узел
            prev = current;           // Переходим к следующему узлу
            current = next;           // Переходим к следующему узлу
        }

        head = prev; // Новый головной узел становится предыдущим
    }
    public void reverse3() {
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> tmp = null;

        while (current != null) {
            tmp = current.getNext(); // Сохраняем ссылку на следующий узел
            current.setNext(prev);    // Меняем направление ссылки на предыдущий узел
            prev = current;           // Переходим к следующему узлу
            current = tmp;           // Переходим к следующему узлу
        }

        head = prev; // Новый головной узел становится предыдущим
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }




    public void reverse4(){
        Node current = head;
        Node prev = null;
        Node tmp = null;
        if (head == null){
            throw new NoSuchElementException();
        }
        if (head.getNext() == null){
            System.out.println(head);
        }

        while (current != null) {
            tmp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = tmp;
        }
        System.out.println(current);

    }

    public Node reverse5(){
        Node current = head;
        if (head == null){
            throw new NoSuchElementException();
        }
        if (head.getNext() == null){
            return head;
        }
        Node next = current.getNext();
        Node rest = reverse5();
        next.setNext(head);
        return rest;



    }
}
