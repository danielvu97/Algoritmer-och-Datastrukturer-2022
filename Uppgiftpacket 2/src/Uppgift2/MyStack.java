package Uppgift2;

import Uppgift1.DoublyLinkedList;
import Uppgift1.DoublyLinkedListIterator;

import java.util.Iterator;

public class MyStack<T extends Comparable<T>> implements Iterable<T> {

    public DoublyLinkedList<T> stack;

    public MyStack() {
        stack = new DoublyLinkedList<T>();
    }

    public boolean isEmpty() {
        return (stack.isEmpty());
    }

    public T peek() {
        return stack.getLast();
    }

    public T pop() {
        return stack.removeLast();
    }

    public void push(T t) {
        stack.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator(stack);
    }

    public static void main(String[] args) {
        MyStack test = new MyStack();
        test.push("Daniel");
        test.push("Kalle");
        test.push("Erik");

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.isEmpty());
        //System.out.println(test.peek());

        Iterator iter = test.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}
