package Uppgift2;

import java.util.Comparator;

public class ComparatorCapital implements Comparator<Land> {

    @Override
    public int compare(Land o1, Land o2) {
        if(o1.getCapital().compareTo(o2.getCapital()) > 0){
            return  1;
        }
        else if(o1.getCapital().compareTo(o2.getCapital()) < 0){
            return -1;
        }
        return 0;
    }
}
