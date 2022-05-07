package Uppgift2;

import java.util.Iterator;
import java.util.Stack;

public class TreeSetCounterIterator implements Iterator {
    private Stack<Node> stack;

    public TreeSetCounterIterator(Node root) {
        stack = new Stack<Node>();
        moveLeft(root);

    }

    private void moveLeft(Node current) {
        while (current != null) {
            stack.push(current);
            current = current.leftChild;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        Node current = stack.pop();

        if (current.rightChild != null)
            moveLeft(current.rightChild);

        return current;
    }
}
