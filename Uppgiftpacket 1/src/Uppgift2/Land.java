package Uppgift2;

public class Land implements Comparable<Land>  {

    private String name;
    private String capital;
    private int inhabitants;

    public Land(String n, String c, int i){
        this.name = n;
        this.capital = c;
        this.inhabitants = i;
    }

    @Override
    public String toString() {
        return "Land{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", inhabitants=" + inhabitants +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public int compareTo(Land o) {
        if(this.inhabitants < o.inhabitants){
            return -1;
        }
        if(this.inhabitants > o.inhabitants){
            return 1;
        }
        return 0;
    }
}
