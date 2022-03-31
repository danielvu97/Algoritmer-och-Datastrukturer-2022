package Uppgift2;

import Uppgift1.MyArrayList;

import java.util.Collections;
import java.util.Comparator;

public class Uppgift2c {

    public static MyArrayList<Land> findMinMax(MyArrayList<Land> list){
        MyArrayList<Land> pair = new MyArrayList<Land>();

        Land min = list.get(0);
        Land max = list.get(0);


        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).compareTo(max) == 1) {
                max = list.get(i);
            }

            if(list.get(i).compareTo(min) == -1) {
                min = list.get(i);
            }
        }

        pair.add(min);
        pair.add(max);

        return pair;
    }

    public static MyArrayList<Land> findMinMax(MyArrayList<Land> list, Comparator<Land> c) {
        MyArrayList<Land> pair = new MyArrayList<Land>();

        Land max = list.get(0);
        Land min = list.get(0);

        for(int i = 0; i < list.size(); i++) {
            if(c.compare(list.get(i), max) == 1) {
                max = list.get(i);
            }
            if(c.compare(list.get(i), min) == -1) {
                min = list.get(i);
            }
        }

        pair.add(min);
        pair.add(max);

        return pair;
    }

    public static void main(String[] args) {
        Land land1 = new Land("Sverige","Stockholm",100000);
        Land land2 = new Land("Vietnam","Hanoi",64520);
        Land land3 = new Land("Korea","Seoul",99999999);
        Land land4 = new Land("Kosovo","Shiptar",500000);

        MyArrayList<Land> arrayList = new MyArrayList<Land>();
        arrayList.add(land1);
        arrayList.add(land2);
        arrayList.add(land3);
        arrayList.add(land4);



        System.out.println(land1);
    }

}
