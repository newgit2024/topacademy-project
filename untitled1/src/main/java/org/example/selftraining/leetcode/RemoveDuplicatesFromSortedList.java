package org.example.selftraining.leetcode;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

//83

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }
    @Data
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode removeDuplicates(ListNode head){
        //1->2->3->3
        Set<ListNode> settt = new HashSet<>();
        settt.add(head);

        ListNode next = head.getNext();

        while (next != null){
            if(!settt.add(next)){
                next = null;
            }
            next = next.next;
        }
        return next;
    }
    static ListNode removeDuplicates2True(ListNode head){
        //1->1->2->3->3
        ListNode cur = head; // cur = 1

        while (cur != null && cur.next != null){ // Node1(1) && Node2 (1) != null
             if(cur.next.val == cur.val){ // 1 == 1 -> 1 -> 2 (Node2 (1) remove
                cur.next = cur.next.next;
            } else {                      // Node1.val != Node2.val -> cur = cur.next
                cur = cur.next;
            }
        }

        return head;
    }
}
