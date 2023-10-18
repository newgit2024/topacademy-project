package org.example.inters.evgenyd;

import java.util.Stack;

public class MaxValueStack<T extends Comparable<T>> {

    private Stack<T> mainStack;
    private Stack<T> maxStack;

    public MaxValueStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(T item) {
        mainStack.push(item);

        if (maxStack.isEmpty() || item.compareTo(maxStack.peek()) >= 0) {
            maxStack.push(item);
        }
    }

    public T pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        T poppedItem = mainStack.pop();

        if (poppedItem.equals(maxStack.peek())) {
            maxStack.pop();
        }

        return poppedItem;
    }

    public T peek() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return mainStack.peek();
    }

    public T getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return maxStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }
}
