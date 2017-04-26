package people;

import java.util.ArrayList;
import market.*;

/**
 * Contains methods and data for Person who sells Products on Marketplace
 */
public class Seller extends Person implements Admin {
    
    private FileHandler f;

    // Seller constructor
    public Seller(int idNumber, String name, String email, String password, ArrayList<Product> inventory) {
        super(idNumber, name, email, password, inventory);
        f = new FileHandler();
    }

    /**
     * Updates quantity of Product in Seller Inventory
     *
     * @param id The Product ID
     * @param quantity The new quantity
     */
    @Override
    public void updateQuantity(int id, int quantity) {
        System.out.println("hello");
        for (Product p : getInventory()) {
            if (p.getIDNumber() == id) {
                p.setQuantity(quantity);
            }
        }
        f.updateSellers(new Marketplace().getSellers());
        new Marketplace().updateQuantity(id, quantity);
    }

    /**
     * Updates price of Product in Seller Inventory
     *
     * @param id The Product ID
     * @param price The new price
     */
    @Override
    public void updatePrice(int id, double price) {
        for (Product p : getInventory()) {
            if (p.getIDNumber() == id) {
                p.setPrice(price);
            }
        }
        new Marketplace().updatePrice(id, price);
    }

    /**
     * Updates name of Product in Seller Inventory
     *
     * @param id The Product ID
     * @param name The new name
     */
    @Override
    public void updateName(int id, String name) {
        for (Product p : getInventory()) {
            if (p.getIDNumber() == id) {
                p.setName(name);
            }
        }
        new Marketplace().updateName(id, name);
    }

    /**
     * Updates description of Product in Seller Inventory
     *
     * @param id The Product ID
     * @param description The new description
     */
    @Override
    public void updateDescription(int id, String description) {
        for (Product p : getInventory()) {
            if (p.getIDNumber() == id) {
                p.setDescription(description);
            }
        }
        new Marketplace().updateDescription(id, description);
    }

    public void addToInvetory(Product item){
    	this.addInventory(item);
    }
}