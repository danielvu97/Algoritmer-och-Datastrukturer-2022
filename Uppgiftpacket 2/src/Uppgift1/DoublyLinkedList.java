package Uppgift1;

import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {

    public ListNode<T> head;
    public ListNode<T> tail;
    public int counter;

    public DoublyLinkedList() {
        this.counter = 0;
    }

    public void add(T t) {
        ListNode<T> newNode = new ListNode<T>(t);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        counter++;
    }

    public void add(int index, T t) {
        if (index > counter || index < 0) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }

        ListNode<T> newNode = new ListNode<T>(t);

        if (index == 0) {
            if (head == null) {
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;

        } else if (index == counter) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else {
            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;

        }
        counter++;
    }

    public T get(int index) {
        ListNode<T> temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public int remove(T t) {

        int deleted = 0;
        ListNode<T> temp = head;

        while(temp != null){
            if(temp.data == t){
                if(temp == head){
                    head = head.next;
                    if(head == null){
                        tail = null;
                    }
                    else{
                        head.prev = null;
                    }
                }
                else {
                    temp.prev.next = temp.next;
                    if(temp.next == null){
                        tail = temp.prev;
                    }
                    else
                    {
                        temp.next.prev = temp.prev;
                    }
                }
                deleted++;
            }
            temp = temp.next;
        }

        return deleted;
    }

    public T remove(int index) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }

        if (index == counter - 1) {
            T data = tail.data;
            tail = tail.prev;
            tail.next = null;
            counter--;
            return data;

        } else if (index == 0) {
            T value = head.data;
            head = head.next;
            head.prev = null;
            counter--;
            return value;
        }

        ListNode<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        counter--;

        return temp.data;
    }

    public T removeLast() {
        if (counter == 0) {
            throw new IndexOutOfBoundsException("Empty List");
        }

        ListNode<T> temp = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        counter--;
        return temp.data;
    }

    public T removeFirst() {
        if (counter == 0) {
            throw new IndexOutOfBoundsException("Empty List");
        }

        ListNode<T> temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }

        counter--;
        return temp.data;
    }

    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void clear(){
        counter = 0;
        head = null;
        tail = null;
    }

    public String toString() {
        ListNode<T> temp = head;
        String val = "";
        while (temp != null) {
            val += "[" + temp.data + "]";
            temp = temp.next;
        }
        return val;
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.add("Daniel");
        myList.add("Kalle");
        myList.add("Erik");
        myList.add("Daniel");
        myList.add("Man");
        myList.add("Daniel");
        //myList.add(1,"Sara");
        System.out.println(myList);

        System.out.println(myList.remove("Daniel"));

        System.out.println(myList);
    }

}
