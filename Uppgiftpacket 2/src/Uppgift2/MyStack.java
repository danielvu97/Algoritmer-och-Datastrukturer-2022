package Uppgift2;

import java.util.Iterator;

public class MyStack<T extends Comparable<T>> implements Iterable<T>{

    public int counter;

    public MyStack(){
        this.counter = 0;
    }

    public boolean isEmpty(){
        if(counter == 0){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
