package Uppgift2;

import Uppgift1.DoublyLinkedList;

import java.util.Iterator;

public class MyStack<T extends Comparable<T>> implements Iterable<T>{

    public DoublyLinkedList<T> stack;

    public MyStack(){
        stack = new DoublyLinkedList<T>();
    }

    public void push(T t) {
        stack.add(t);
    }

    public T peek() {
        return stack.getLast();
    }

    public boolean isEmpty(){
        return(stack.isEmpty());
    }

    public T pop() {
        return stack.removeLast();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
