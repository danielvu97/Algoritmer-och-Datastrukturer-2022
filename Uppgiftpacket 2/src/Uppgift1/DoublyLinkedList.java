package Uppgift1;

import java.util.Iterator;

public class DoublyLinkedList <T extends Comparable<T>> implements Iterable<T>{

    public ListNode head;
    public int size =

    public DoublyLinkedList(){
        head = null;
    }

    public void add(T t){
        ListNode newNode = new ListNode(t);
        newNode.next = head;
        newNode.previous = null;

        if(head != null){
            head.previous = newNode;
        }
        head = newNode;
    }

    public void add(int index, T t){

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
