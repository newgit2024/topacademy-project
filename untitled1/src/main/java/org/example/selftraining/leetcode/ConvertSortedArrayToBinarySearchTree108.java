package org.example.selftraining.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//108
public class ConvertSortedArrayToBinarySearchTree108 {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode sortedArrayToBST(int[] arr){
        TreeNode root = new TreeNode(arr[arr.length/2]);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > root.val){
                root.right = new TreeNode(arr[i]);
            } else {
                root.left = new TreeNode(arr[i]);
            }
        }
        return root;
    }

    static TreeNode sortedArrayToBSTTrue(int[] arr){
        TreeNode rootNode = buildSubTree(arr, 0, arr.length);
        return rootNode;
    }
    private static TreeNode buildSubTree(int[]arr, int start, int end){
        if (start > end){
            return null;
        }
        int mid = (end - start) / 2;
        TreeNode midNode = new TreeNode(mid);
        midNode.left = buildSubTree(arr, start, mid - 1);
        midNode.right = buildSubTree(arr, mid + 1, start);
        return midNode;
    }
}
