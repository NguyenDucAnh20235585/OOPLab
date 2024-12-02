package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle", "Adventure", "Jon Favreau", 120, 20.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", "Animation", "Disney", 90, 15.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Disney", 100, 18.0f);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Print the store's items
        store.printStore();

        // Remove a DVD from the store
        store.removeDVD(dvd2);

        // Print the store's items after removal
        store.printStore();

        // Attempt to remove a DVD not in the store
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", "Disney", 95, 16.0f);
        store.removeDVD(dvd4);

        // Print the final store state
        store.printStore();
    }
}