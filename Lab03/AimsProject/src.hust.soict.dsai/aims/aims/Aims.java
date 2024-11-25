package hust.soict.dsai.aims.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // print total cost of all items in the cart
        System.out.println("Total cost of all items in cart: " + anOrder.totalCost());
        
        // check the remove
        anOrder.removeDigitalVideoDisc(dvd2);
        
        //total cost after removing 
        System.out.println("Total cost after removing Star Wars: " +anOrder.totalCost());
        
        // Check the left
        for (int i=0; i< anOrder.getQtyOrdered();i++) {
        	System.out.println("DVD whichs still in the cart: " + anOrder.getItemsOrdered()[i].getTitle());
        }
    }
}