package Uppgift2;

import java.util.Comparator;

public class ComparatorName implements Comparator <Land>{

    @Override
    public int compare(Land o1, Land o2) {
        return (o1.getName().compareTo(o2.getName()));
    }
}
