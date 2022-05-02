package Uppgift1;

import java.util.Iterator;

public class DataBufferIterator<T> implements Iterator<T> {

    int front;
    int back;
    int size;
    int counter;
    T[] data;

    public DataBufferIterator(DataBuffer list) {
        this.front = list.front;
        this.back = list.back;
        this.size = list.bufferSize();
        data = (T[]) list.list;
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        if(counter == size){
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        T temp = data[front];
        front = (front + 1) % size;
        counter++;
        return temp;
    }
}
