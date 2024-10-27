package main;

import java.util.ArrayList;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        if (itemsOrdered.size() <20) {
            itemsOrdered.add(disc);
            System.out.println("The disc has been added");
        }
        else if (itemsOrdered.size() == 20){
            System.out.println("The cart is full");
        }
    }
    public void removeDigitalVideoDisc (DigitalVideoDisc disc){
        for (DigitalVideoDisc d : itemsOrdered){
            if (d.getTitle() == disc.getTitle()){
                itemsOrdered.remove(disc);
            }
        }
        System.out.println("The disc has been removed");
    }
    public float totalCost(){
        float sum = 0;
        for (DigitalVideoDisc d : itemsOrdered){
            sum += d.getCost();
        }
        return sum;
    }
    public ArrayList<String> getItemsOrdered (){
        ArrayList<String> cart = new ArrayList<>();
        for (DigitalVideoDisc d : itemsOrdered){
            String title = d.getTitle();
            String category = d.getCategory();
            String directory = d.getDirectory();
            int length = d.getLength();
            float cost = d.getCost();
            String display = "TITLE: " + title + "  CATEGORY: " + category + "  DIRECTORY: " + directory + "  LENGTH: " + length +"  COST: " + cost;
            cart.add(display);
        }
        return cart;
    }
}
