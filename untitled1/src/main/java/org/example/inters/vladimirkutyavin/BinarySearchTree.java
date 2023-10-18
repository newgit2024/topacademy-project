package org.example.inters.vladimirkutyavin;

class BinaryTreeNode {
    int key;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private BinaryTreeNode root;

    // Конструктор
    public BinarySearchTree() {
        root = null;
    }

    // Вставка нового ключа в дерево
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Метод для суммирования всех элементов в дереве
    public int sum() {
        return sumRec(root);
    }

    // Вспомогательный метод для суммирования элементов в дереве
    private int sumRec(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        // Суммируем значение текущего узла со значениями левого и правого поддеревьев
        int sumLeft = sumRec(node.left);
        int sumRight = sumRec(node.right);

        return node.key + sumLeft + sumRight;
    }


    // Вспомогательный метод для вставки узла в дерево
    private BinaryTreeNode insertRec(BinaryTreeNode node, int key) {
        if (node == null) {
            return new BinaryTreeNode(key);
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }

        return node;
    }

    // Поиск узла по ключу
    public BinaryTreeNode search(int key) {
        return searchRec(root, key);
    }

    // Вспомогательный метод для поиска узла по ключу
    private BinaryTreeNode searchRec(BinaryTreeNode node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return searchRec(node.left, key);
        } else {
            return searchRec(node.right, key);
        }
    }

    // Удаление узла по ключу
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Вспомогательный метод для удаления узла по ключу
    private BinaryTreeNode deleteRec(BinaryTreeNode node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key);
        }

        return node;
    }

    // Нахождение минимального значения в дереве
    private int minValue(BinaryTreeNode node) {
        int minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }

    // TODO: Добавьте другие методы для обхода дерева и других операций.
}

