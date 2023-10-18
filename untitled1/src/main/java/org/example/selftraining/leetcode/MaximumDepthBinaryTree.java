package org.example.selftraining.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//104
public class MaximumDepthBinaryTree {
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

    static int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int lMaxDepth = maxDepth(root.left);
        int rMaxDepth = maxDepth(root.right);

        return lMaxDepth > rMaxDepth ? lMaxDepth + 1 : rMaxDepth + 1;
    }
}
