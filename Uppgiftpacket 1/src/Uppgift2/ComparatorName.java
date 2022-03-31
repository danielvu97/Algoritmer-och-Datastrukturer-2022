package Uppgift2;

import java.util.Comparator;

public class ComparatorName implements Comparator <Land>{

    @Override
    public int compare(Land o1, Land o2) {
        if(o1.getName().compareTo(o2.getName()) > 0){
            return  1;
        }
        else if(o1.getName().compareTo(o2.getName()) < 0){
            return -1;
        }
        return 0;
    }
}
