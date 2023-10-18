package org.example.selftraining.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//1038
public class BSTtoGreaterSumTree {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int sum = 0;

    static TreeNode bstToGst(TreeNode root){
        calculateSum(root);

        return root;
    }


    private static void calculateSum(TreeNode currentNode){
        if(currentNode == null){
            return;
        }
        calculateSum(currentNode.right);
        sum += currentNode.val;
        currentNode.val =sum;
        calculateSum(currentNode.left);
    }
}
