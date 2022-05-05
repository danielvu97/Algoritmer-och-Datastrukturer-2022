package Uppgift1;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {

    Key[] a;
    int size;

    public MaxPQ() {
        this.a = (Key[]) new Comparable[10];
        this.size = 0;
    }

    public MaxPQ(int max) {
        a = (Key[]) new Comparable[max];
        this.size = 0;
    }

    public MaxPQ(Key[] a) {
        this.a = (Key[]) (new Comparable[a.length + 1]);
        this.size = 0;

        for (int i = 0; i < a.length; i++) {
            this.a[i + 1] = a[i];
            size++;
        }

        for (int i = a.length / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public void insert(Key t) {
        if (size >= a.length - 1) {
            a = Arrays.copyOf(a, 2 * a.length);
        }
        a[++size] = t;
        swim(size);

    }

    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return a[1];
    }

    public Key delMax() {
        if (isEmpty()) {
            return null;
        }
        exchange(1, size);
        Key temp = a[size];
        a[size--] = null;
        if (!isEmpty()) {
            sink(1);
        }
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean less(Key i, Key j) {
        return i.compareTo(j) < 0;
    }

    private void exchange(int i, int j) {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int i = 2 * k;
            if (i < size && less(a[i], a[i + 1])) i++;
            if (less(a[i], a[k])) break;
            exchange(i, k);
            k = i;
        }
    }

    private void swim(int k) {
        while (k / 2 >= 1 && less(a[k / 2], a[k])) {
            exchange(k, k / 2);
            k /= 2;
        }
    }


    public static void main(String[] cmdLn) {
        Integer[] arr = { 5, 8, 1, 3, 4, 6 };
        MaxPQ<Integer> pq = new MaxPQ<Integer>(arr);
        /*
         * pq.insert(1); pq.insert(3); pq.insert(7); pq.insert(2);
         */
        System.out.println("mains");
        System.out.println(pq.max());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());


    }


}
