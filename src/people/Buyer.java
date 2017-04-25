package people;

import market.*;
import java.util.*;

/**
 * Methods and data for Person who buys Products on Marketplace
 */
public class Buyer extends Person {
    
    private FileHandler f;

    // Buyer constructor
    public Buyer(int idNumber, String name, String email, String password, ArrayList<Product> inventory) {
        super(idNumber, name, email, password, inventory);
        f = new FileHandler();
    }

    /**
     * Buys Product from Marketplace (if available) and returns the message for
     * the Buyer
     *
     * @param id Number of Product
     * @return The confirmation or error message for the user
     */
    public String buyProduct(int id) {
        ArrayList<Product> inv = f.fillInventory();
        for (Product p : inv) {
            if (p.getIDNumber() == id && p.getQuantity() > 0) {
                p.setQuantity(p.getQuantity() - 1);
                f.updateProducts(inv);
                return "You have purchased " + p.getName() + " for " + p.getPrice();
            }
        }

        return "Requested product is out of stock, or the id is invalid.";
    }

    /**
     * Returns Product that is found in ID search
     *
     * @param id Number of product
     * @return Product that is found
     */
    public Product searchProduct(int id) {
        for (Product p : f.fillInventory()) {
            if (p.getIDNumber() == id) {
                return p;
            }
        }

        return null;
    }

    /**
     * Product(s) that is/are found in String search
     *
     * @param name Key term
     * @return Products that are found in search
     */
    public ArrayList<Product> searchProduct(String name) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product p : f.fillInventory()) {
            if (p.getName().contains(name)) {
                products.add(p);
            }
        }

        return products;
    }
}