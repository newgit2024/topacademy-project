package org.example.innotech.trueview.vtbconf;

public class InvertTreeNode {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Рекурсивно инвертируем левое и правое поддерево
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Рекурсивно вызываем метод для левого и правого поддерева
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;

        invertTree2(root.left);
        invertTree2(root.right);





        return root;


    }
}
