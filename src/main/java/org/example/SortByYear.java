package org.example;
import java.util.Comparator;
class SortByYear implements Comparator {
    public int compare(Object obj1, Object obj2) {
        Car a = (Car) obj1;
        Car b = (Car) obj2;

        if (a.year < b.year) return -1; // La première voiture a une année inférieure
        if (a.year > b.year) return 1;  // La première voiture a une année supérieure
        return 0;                       // Les deux voitures ont la même année
    }
}
