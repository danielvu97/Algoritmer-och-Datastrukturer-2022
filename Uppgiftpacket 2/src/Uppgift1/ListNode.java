package Uppgift1;

public class ListNode <T> {

    public T data;
    public ListNode prev;
    public ListNode next;

    public ListNode(T data){
        this.data = data;
    }

    public ListNode(T data, ListNode prev, ListNode next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

}
