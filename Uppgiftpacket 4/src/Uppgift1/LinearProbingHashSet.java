package Uppgift1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class LinearProbingHashSet<Key> {
    HashElement<Key>[] a;
    int m; //storlek på array
    int n; //antal sparade element

    public LinearProbingHashSet(int m) {
        this.m = m;
        this.a = new HashElement[m];
        this.n = 0;
    }

    public LinearProbingHashSet() {
        this.m = 10;
        this.a = new HashElement[10];
        this.n = 0;

    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int getCapacity() {
        return m;
    }

    public void insert(Key key) {
        if (loadFactor() >= 0.5) { //om loadfactor är större eller lika med 0.5 dubbla array vid insert
            doubleArray();
        }
        int hashValue = hash(key);
        int counter = 0;

        //if position is not null and key is not equal to the position.
        while (a[hashValue] != null && !(a[hashValue].getKey().equals(key)) && counter != m) {
            hashValue = (hashValue + 1) % m;
            counter++;
        }

        if (a[hashValue] == null) {
            a[hashValue] = new HashElement<Key>(key);
            n++;
        } else if (a[hashValue].getKey().equals(key)) {
            a[hashValue].increment();
        }
        //maybe add more?

    }

    public boolean contains(Key key) {
        int hashValue = hash(key);
        int counter = 0;
        while (a[hashValue] != null && counter != m) {
            if (a[hashValue].getKey().equals(key)) {
                return true;
            } else {
                hashValue = (hashValue + 1) % m;
                counter++;
            }
        }
        return false;
    }

    public void decrease(Key key) {
        int hashValue = hash(key);
        int counter = 0;
        while (counter != m) {
            if (a[hashValue] != null && a[hashValue].getKey().equals(key)) {
                a[hashValue].decrement();
                if (a[hashValue].getFrequencey() == 0) {
                    delete(key);
                }
                break;
            } else {
                hashValue = (hashValue + 1) % m;
                counter++;
            }
        }

    }

    public void delete(Key key) {
        if (loadFactor() <= (1.0 / 8)) {
            halfArray();
        }
        int hashValue = hash(key);
        int counter = 0;

        while (counter != m) {
            if (a[hashValue] != null && a[hashValue].getKey().equals(key)) {
                a[hashValue] = null;
                n--;
                break;
            } else {
                hashValue = (hashValue + 1) % m;
                counter++;
            }
        }

        if (counter == m) {
            System.out.println("Key does not exist");
        }

    }

    public Iterable<Key> keys() {
        ArrayList<HashElement> list = new ArrayList<>();
        ArrayList<Key> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (a[i] != null) {
                list.add(a[i]);
            }
        }
        Collections.sort(list);

        for (HashElement a : list) {
            list2.add((Key) a.getKey());
        }
        return list2;
    }

    private double loadFactor() {
        return ((double) n / m);
    }

    private void doubleArray() {
        m = a.length * 2;
        HashElement<Key>[] temp = new HashElement[m];

        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {

            } else {
                //because we got new size, rehashing the elements.
                int counter = 0;
                HashElement<Key> element = a[i];
                int hashValue = hash(element.getKey());

                while (temp[hashValue] != null && counter != m) {
                    hashValue = (hashValue + 1) % m;
                    counter++;
                }
                temp[hashValue] = element;
            }
        }
        a = temp;

    }

    private void halfArray() {
        m = (a.length / 2);
        HashElement<Key>[] temp = new HashElement[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {

            } else {
                int counter = 0;
                HashElement<Key> element = a[i];
                int hashValue = hash(element.getKey());

                while (temp[hashValue] != null && counter != m) {
                    hashValue = (hashValue + 1) % m;
                    counter++;
                }
                temp[hashValue] = element;
            }
        }
        a = temp;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < m; i++) {
            s += a[i] + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        LinearProbingHashSet<Object> myHashList = new LinearProbingHashSet<>(10);

        myHashList.insert((1));
        myHashList.insert((1));
        myHashList.insert((500));
        //myHashList.insert((1));
        myHashList.insert((101));
        myHashList.insert((101));
        myHashList.decrease(1);
        myHashList.decrease(1);
        myHashList.decrease(101);
        myHashList.decrease(101);
        //myHashList.insert((150));

        //myHashList.decrease(1);
        //myHashList.delete((2));
        myHashList.insert(("a"));
        myHashList.insert(("a"));
        myHashList.insert(("a"));
        myHashList.insert(("a"));
        myHashList.insert(("a"));
        myHashList.insert(("b"));
        //myHashList.insert(("c"));
        System.out.println(myHashList);


        System.out.println();
        //myHashList.delete((1));
        //myHashList.delete((101));
        //myHashList.delete((999999));
        //myHashList.delete("a");
        //myHashList.delete("b");
        //myHashList.delete("c");
        //myHashList.decrease(1);
        //myHashList.decrease(1);
        //myHashList.decrease(1);
        //System.out.println(myHashList);

        //System.out.println(myHashList.contains((6)));
        //System.out.println(myHashList.contains((7)));
        //System.out.println(myHashList.contains((7)));

        Iterator<Object> iter = myHashList.keys().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }

}
