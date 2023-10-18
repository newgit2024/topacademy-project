package org.example.selftraining.leetcode;


import lombok.Data;

@Data
class MinStack {

    public static void main(String[] args) {
        var stack = new MinStack();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack);
    }
    @Data
    class Node {
        int value;
        int min;
        Node next;

        Node(int x, int min){
            this.value=x;
            this.min=min;
            next = null;
        }
    }
    Node head;
    public void push(int x) {
        if(null==head){
            head = new Node(x,x);
        }else{
            Node n = new Node(x, Math.min(x,head.min));
            n.next=head;
            head=n;
        }
    }

    public void pop() {
        if(head!=null)
            head =head.next;
    }

    public int top() {
        if(head!=null)
            return head.value;
        return -1;
    }

    public int getMin() {
        if(null!=head)
            return head.min;
        return -1;
    }
}


