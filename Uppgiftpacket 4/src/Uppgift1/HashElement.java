package Uppgift1;

public class HashElement<Key> implements Comparable<HashElement<Key>> {

    Key key;
    int counter;

    public HashElement(Key key){
        this.key = key;
        this.counter = 1;
    }

    public HashElement(Key key, int counter){
        this.key = key;
        this.counter = counter;
    }

    public void increment(){
        this.counter++;
    }

    public void decrement(){
        this.counter--;
    }

    public int getFrequencey(){
        return counter;
    }

    public Key getKey(){
        return key;
    }

    public void setKey(Key key){
        this.key = key;
    }

    @Override
    public int compareTo(HashElement<Key> o) {
        if(this.counter < o.counter){
            return -1;
        }
        if(this.counter > o.counter){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ",c=" + counter +
                '}';
    }
}
