package Uppgift1;

import java.util.Iterator;

public class DataBuffer<T> implements Iterable<T> {

    public T[] list;
    int front;
    int back;
    int counter;

    public DataBuffer(int bufferSize) {
        if (bufferSize < 1) {
            new IndexOutOfBoundsException();
        } else {
            list = (T[]) new Object[bufferSize];
            this.front = 0;
            this.back = -1;
            this.counter = 0;
        }
    }

    public void enqueue(T t) throws Exception {
        if (isFull()) {
            throw new Exception("Circular Queue is full");
        } else {
            back = (back + 1) % list.length;
            list[back] = t;
            counter++;
        }
    }

    public T dequeue() throws Exception {
        T object = null;
        if (isEmpty()) {
           throw  new Exception("Circular Queue is Empty");
        } else {
            object = list[front];
            list[front] = null;
            front = (front + 1) % list.length;
            counter--;

            if (counter == 0) {
                front = 0;
                back = -1;
            }
        }
        return object;
    }

    public boolean isFull() {
        if (counter == list.length) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        }
        return false;
    }

    public int bufferSize() {
        return list.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new DataBufferIterator<T>(this);
    }

    public static void main(String[] args) throws Exception {
        DataBuffer<String> tester = new DataBuffer<>(5);
        tester.enqueue("Daniel");
        tester.enqueue("Kalle");
        tester.enqueue("Pelle");

        tester.dequeue();
        tester.dequeue();

        tester.enqueue("Sandra");
        tester.enqueue("Ebba");
        tester.enqueue("Sandra");

        /*
        System.out.println(tester.front);
        System.out.println(tester.back);
        System.out.println(tester.isFull());
        System.out.println(tester.isEmpty());

         */

        Iterator iter = tester.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}