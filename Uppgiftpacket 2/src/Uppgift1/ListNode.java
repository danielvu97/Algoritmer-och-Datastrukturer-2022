package Uppgift1;

public class ListNode <T> {

    public T data;
    public ListNode previous;
    public ListNode next;

    public ListNode(T data){
        this.data = data;
    }

    public ListNode(T data, ListNode prev, ListNode next){
        this.data = data;
        this.previous = prev;
        this.next = next;
    }

}
