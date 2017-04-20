package people;

import market.Product;
import java.util.ArrayList;

/**
 * Methods and data for Person who buys Products on Marketplace
 */
public class Buyer extends Person {

    private ArrayList<Product> boughtItems;
    
    // Buyer constructor
    public Buyer(int idNumber, String name, String email, String notification) {
        super(idNumber, name, email, notification);
        boughtItems = new ArrayList();
    }
    
    /**
     * Buys Product from Marketplace (if available)
     * @param id Number of Product
     */
    public void buyProduct(int id) {
    }
    
    /**
     * Returns Product that is found in ID search
     * @param id Number of product
     * @return Product that is found
     */
    public Product searchProduct(int id) {
        return null;
    }
    
    /**
     * Product(s) that is/are found in String search
     * @param name Key term
     * @return Products that are found in search
     */
    public ArrayList<Product> searchProduct(String name) {
        return null;
    }
    
    /**
     * List of all Products Buyer has bought
     * @return Product history
     */
    public ArrayList<Product> getBoughtItems() {
        return boughtItems;
    }
    
    /**
     * Prints out all Products in Inventory
     */
    public void displayBoughtItems() {   
    }
}