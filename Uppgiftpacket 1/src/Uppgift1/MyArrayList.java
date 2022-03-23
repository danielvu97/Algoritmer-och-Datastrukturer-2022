package Uppgift1;

//Daniel Vu

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    public T[] list; //creates an empty list
    private int elementCounter = 0;

    public MyArrayList() {
        list = (T[]) new Object[10];
    }

    public boolean add(T t) {
        elementCounter++;
        list.add(t);
        return true;
    }

    public void add(int index, T t) {
        elementCounter++;
        list.add(index, t);
    }

    public boolean contains(T t) {
        list.contains(t);
        return true;
    }

    public T get(int index) {
        return (T) list.get(index);
    }

    //return the index of the first t
    public int indexOf(T t) {
        return (list.indexOf(t));
    }

    public boolean remove(T t) {
        elementCounter--;
        return list.remove(t);
    }

    public T set(int index, T t) {
        T temp = (T) list.get(index);
        list.set(index, t);

        return temp;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int Size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public int size() {
        return elementCounter;
    }

    public void clear() {
        list.clear();
        elementCounter = 0;
    }

    public String toString() {
        return (list.toString());
    }

    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<String>();
        test.add("tester");
        test.add(0, "tester2");
        test.add(2, "tester3");
        test.add(0, "tester4");

        /*
        Iterator iter = test.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        */
        System.out.println(test.get(0));
    }
}
