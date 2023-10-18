package org.example.selftraining.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//1038
public class DeepestLeavesSum1302 {
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

    static TreeNode deepestLeavesSum(TreeNode root){
        int maxDepthSum = 0;
        int maxDepth = 0;
        int currentDepth = 0;

        return root;
    }

}
