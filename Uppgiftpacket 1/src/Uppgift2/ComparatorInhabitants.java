package Uppgift2;

import java.util.Comparator;

public class ComparatorInhabitants implements Comparator<Land> {

    @Override
    public int compare(Land o1, Land o2) {
        return (o1.getInhabitants() - o2.getInhabitants());
    }
}
