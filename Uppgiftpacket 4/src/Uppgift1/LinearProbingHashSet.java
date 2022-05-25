package Uppgift1;

public class LinearProbingHashSet<Key> {
    Key[] list;

    public LinearProbingHashSet(int m) {
        this.list = (Key[]) new Object[m];
    }

    public LinearProbingHashSet(){
        this.list = (Key[]) new Object[10];
    }

}
