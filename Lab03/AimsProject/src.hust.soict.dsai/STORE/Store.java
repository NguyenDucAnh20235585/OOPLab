package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.List;
import java.util.ArrayList;

public class Store {

    private List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println(dvd.getTitle() + " has been added to the store.");
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean removed = itemsInStore.remove(dvd);
        if (removed) {
            System.out.println(dvd.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(dvd.getTitle() + " is not found in the store.");
        }
    }

    public void printStore() {
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(i+1 + ". " + itemsInStore.get(i));
        }
    }
}