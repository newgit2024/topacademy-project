package org.example.selftraining.leetcode;

//100

import java.util.Stack;

public class SameTree {
    public static void main(String[] args) {
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

   /* static boolean isSameTree(TreeNode p, TreeNode q) {
        while (p.left != null && p.right != null && q.left != null && q.right != null) {
            if (p == p && q == q && p.left == q.left & q.left == q.right) {
                return true;
            }
        }
        return false;

    }*/

    static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);

    }

    static boolean isSameTree2Improve(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree2Improve(p.left, q.left) && isSameTree2Improve(p.right, q.right);
    }

    static boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val != q.val &&
                isSameTree3(p.left, q.left) &&
                isSameTree3(p.right, q.right);

    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        stackP.push(p);
        stackQ.push(q);

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();

            if (nodeP == null && nodeQ == null) {
                continue;
            }
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }

            stackP.push(nodeP.left);
            stackP.push(nodeP.right);
            stackQ.push(nodeQ.left);
            stackQ.push(nodeQ.right);
        }

        return stackP.isEmpty() && stackQ.isEmpty();
    }
}
