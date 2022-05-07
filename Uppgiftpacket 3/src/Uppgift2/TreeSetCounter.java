package Uppgift2;

import java.util.Iterator;

public class TreeSetCounter<T extends Comparable<T>> implements Iterable<T> {
    Node root;
    int size;

    public TreeSetCounter() {
        size = 0;
    }

    public void add(T t) {
        root = addReccursive(t, root);
        size++;
    }

    private Node addReccursive(T t, Node current) {
        if (current == null) {
            current = new Node(t);
            current.counter++;
            return current;
        }

        if (t.compareTo((T) current.data) < 0) {
            current.leftChild = addReccursive(t, current.leftChild);
        }
        if (t.compareTo((T) current.data) > 0) {
            current.rightChild = addReccursive(t, current.rightChild);
        }
        if (t.compareTo((T) current.data) == 0) {
            current.counter++;
            size--;
        }

        return current;
    }

    public void clear() {
        this.root = null;
    }

    public int getMaxFrequency() {
        return searchFreq(root);
    }

    private int searchFreq(Node current) {
        int right = -1;
        int left = -1;

        if (current.rightChild == null && current.leftChild == null) {
            return current.counter;
        }

        if (current.rightChild != null) {
            right = searchFreq(current.rightChild);
        }

        if (current.leftChild != null) {
            left = searchFreq(current.leftChild);
        }

        return Math.max(Math.max(left, right), current.counter);
    }


    public boolean contains(T t) {
        Node temp = containsReccursive(t, root);
        if (temp == null) {
            return false;
        }
        return true;
    }

    private Node containsReccursive(T t, Node current) {

        if (current == null) {
            return null;
        }
        if (t.compareTo((T) current.data) < 0) {
            return containsReccursive(t, current.leftChild);
        }
        if (t.compareTo((T) current.data) > 0) {
            return containsReccursive(t, current.rightChild);
        }
        return current;
    }


    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }


    public int counter(T t) {
        Node temp = containsReccursive(t, root);
        if (temp != null) {
            return containsReccursive(t, root).counter;
        }
        return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new TreeSetCounterIterator(root);
    }

    public static void main(String[] args) {

        TreeSetCounter<Integer> TSC = new TreeSetCounter<>();

        TSC.add(5);
        TSC.add(6);
        TSC.add(2);
        TSC.add(3);
        TSC.add(3);
        TSC.add(3);
        TSC.add(2);
        TSC.add(1);

        //TSC.contains(5);
        //System.out.println(TSC.contains(5));
        //System.out.println(TSC.getMaxFrequency());
        // System.out.println(TSC.counter(9));

        Iterator iter = new TreeSetCounterIterator(TSC.root);
        while (iter.hasNext()) {

            System.out.println(iter.next());

        }
    }

}
