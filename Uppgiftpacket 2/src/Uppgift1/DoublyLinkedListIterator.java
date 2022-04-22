package Uppgift1;

import java.util.Iterator;

public class DoublyLinkedListIterator <T> implements Iterator <T> {
    public ListNode<T> temp;

    public DoublyLinkedListIterator(DoublyLinkedList list){
        temp = list.head;
    }

    @Override
    public boolean hasNext() {
        return temp != null;
    }

    @Override
    public T next() {
        T value = temp.data;
        temp = temp.next;
        return value;
    }
}
