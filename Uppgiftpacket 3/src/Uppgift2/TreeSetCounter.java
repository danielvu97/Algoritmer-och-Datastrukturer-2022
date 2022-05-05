package Uppgift2;

import java.util.Iterator;

public class TreeSetCounter <T extends Comparable<T>> implements Iterable<T>{
    Node root;
    int size;

    public TreeSetCounter(){
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
