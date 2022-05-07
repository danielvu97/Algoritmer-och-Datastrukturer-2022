package Uppgift2;

public class Node<T> {
    T data;
    Node leftChild;
    Node rightChild;
    int counter;

    public Node(T t) {
        this.data = t;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
