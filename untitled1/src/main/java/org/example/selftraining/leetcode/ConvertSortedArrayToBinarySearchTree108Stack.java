package org.example.selftraining.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//108


import java.util.LinkedList;

public class ConvertSortedArrayToBinarySearchTree108Stack {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(0); // Create a dummy root
        TreeNode current = root;
        LinkedList<MyNode> stack = new LinkedList<>();
        stack.push(new MyNode(current, 0, nums.length - 1));

        while (!stack.isEmpty()) {
            MyNode myNode = stack.pop();
            current = myNode.node;

            int left = myNode.left;
            int right = myNode.right;
            int mid = left + (right - left) / 2;

            current.val = nums[mid];

            if (mid < right) {
                current.right = new TreeNode(0);
                stack.push(new MyNode(current.right, mid + 1, right));
            }

            if (left < mid) {
                current.left = new TreeNode(0);
                stack.push(new MyNode(current.left, left, mid - 1));
            }
        }

        return root;
    }

    static class MyNode {
        TreeNode node;
        int left;
        int right;

        MyNode(TreeNode node, int left, int right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        printInOrder(root);
    }

    static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
