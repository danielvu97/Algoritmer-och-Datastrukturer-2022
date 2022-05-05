package Uppgift2;

import java.util.Iterator;

public class TreeSetCounter<T extends Comparable<T>> implements Iterable<T> {

    Node root;
    int size;

    public TreeSetCounter(Node root) {
        this.size = 0;
    }

    public void add(T t){

    }

    public void clear(){

    }

    public int getMaxFrequency(){
        return 0;
    }

    public boolean contains (T t){
        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int counter(T t){
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
