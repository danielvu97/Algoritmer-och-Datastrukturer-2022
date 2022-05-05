package Uppgift2;

public class Node<T> {

    public T data;
    public Node leftChild;
    public Node rightChild;
    public int counter;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
