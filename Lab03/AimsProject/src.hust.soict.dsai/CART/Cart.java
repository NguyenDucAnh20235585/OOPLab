package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {    
    public static final int MAX_NUMBERS_ORDERED = 20;    
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];    
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {        
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {            
            System.out.println("The cart is full");        
        } else {            
            itemsOrdered[qtyOrdered++] = disc;            
            System.out.println("The disc has been added");        
        }    
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full.");
                break; 
            }
            itemsOrdered[qtyOrdered++] = dvd;
            System.out.println("The disc has been added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add: " + dvd1.getTitle() + " and " + dvd2.getTitle());
            return;
        }
        
        // Add the first DVD
        itemsOrdered[qtyOrdered++] = dvd1;
        System.out.println("The disc has been added");
        
        // Check capacity before adding the second DVD
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add");
            return;
        }
        
        // Add the second DVD
        itemsOrdered[qtyOrdered++] = dvd2;
        System.out.println("The disc has been added");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {        
        for (int i = 0; i < qtyOrdered; i++) {            
            if (itemsOrdered[i].equals(disc)) {                
                for (int j = i; j < qtyOrdered - 1; j++) {                    
                    itemsOrdered[j] = itemsOrdered[j + 1];                
                }                
                itemsOrdered[--qtyOrdered] = null;                
                System.out.println("The disc has been removed");                
                break;            
            }        
        }    
    }

    public float totalCost() {        
        float cost = 0;        
        for (int i = 0; i < qtyOrdered; i++) {            
            if (itemsOrdered[i] != null) {                
                cost += itemsOrdered[i].getCost();            
            }        
        }        
        return cost;    
    }
    
    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    // 1. Print Cart Details
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) {
                System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
                totalCost += itemsOrdered[i].getCost();
            }
        }

        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }

    // 2. Search DVD by ID
    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getId() == id) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("No DVD with ID " + id + " found.");
    }

    // 3. Search DVD by Title
    public void searchByTitle(String title) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].isMatch(title)) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No DVD with title matching \"" + title + "\" found.");
        }
    }
}
