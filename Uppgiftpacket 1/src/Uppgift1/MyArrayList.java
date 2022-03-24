package Uppgift1;

//Daniel Vu

import java.util.Iterator;
import java.util.Arrays;

public class MyArrayList<T> implements Iterable<T> {

    private T[] list; //creates an empty list
    private int elementCounter = 0;

    public MyArrayList() {
        list = (T[]) new Object[5];
    }

    //if array gets full, doubles it
    public void doublesize() {
        T[] list2 = (T[]) new Object[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            list2[i] = list[i];
        }
        list = list2;

    }

    public boolean add(T t) {
        //double size of array if it gets full;
        if (elementCounter == list.length-1) {
            doublesize();
        }
        list[elementCounter] = t;
        elementCounter++;
        System.out.println("added " + t);
        return true;
    }


    public void add(int index, T t) {
        if (index >= elementCounter || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (elementCounter == list.length-1) {
                doublesize();
            }
            for (int i = elementCounter; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = t;
            elementCounter++;
        }
    }

    public boolean contains(T t) {
        for (int i = 0; i < elementCounter; i++) {
            if (list[i] == t) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index >= elementCounter || index < 0) {
            return null;
        }
        return list[index];
    }

    //return the index of the first t
    public int indexOf(T t) {
        for (int i = 0; i < elementCounter; i++) {
            if (list[i] == t) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index >= elementCounter || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T temp = list[index];
        for (int i = index; i < elementCounter; i++) {
            list[i] = list[i + 1];
            list[i + 1] = null;
        }
        elementCounter--;
        return temp;
    }

    public boolean remove(T t) {
        if (contains(t)) {
            for (int i = indexOf(t); i < elementCounter; i++) {
                list[i] = list[i + 1];
                list[i + 1] = null;
            }
            elementCounter--;
            return true;
        }
        return false;
    }

    public T set(int index, T t) {
        T temp = list[index];
        list[index] = t;

        return temp;
    }

    public boolean isEmpty() {
        if (elementCounter == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return list.length;
    }

    public Iterator<T> iterator() {
        T[] copy = Arrays.copyOf(list, elementCounter);
        return Arrays.asList(copy).iterator();
    }


    public void clear() {
        T[] list2 = (T[]) new Object[5];
        list = list2;
        elementCounter = 0;
    }

    public String toString() {
        return (list.toString());
    }


    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<String>();
        test.add("tester");
        test.add("tester2");
        test.add("tester3");
        test.add("tester4");
        test.add("tester5");
       // test.add("tester6");
        //test.add("tester7");
        test.remove(4);


        System.out.println(Arrays.toString(test.list));



        /*

        Iterator iter = test.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        */

        //System.out.println(test.get(0));
    }

}
