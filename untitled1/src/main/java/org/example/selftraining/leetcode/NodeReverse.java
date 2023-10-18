package org.example.selftraining.leetcode;

import lombok.Data;

public class NodeReverse {
    public static void main(String[] args) {

    }


}

@Data
class NodeList {
    private Node head;
    private Node next;
    private int count;


    public NodeList(Node next) {
        this.next = next;
        this.count = 0;
    }

    @Data
    class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public void add (int val){
        if (head == null){
            head = new Node(val);
        } else {
            next = new Node(val);
        }
        count++;
    }

    public Node reverseList(Node head){
        Node prev = null;
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        return prev;
    }


}
