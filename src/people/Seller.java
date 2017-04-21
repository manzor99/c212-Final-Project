package people;


import java.util.ArrayList;
import market.Product;
/**
 * Contains methods and data for Person who sells Products on Marketplace
 */
public class Seller extends Person implements Admin {
    
    private ArrayList<Product> sellerInventory, inventory;
    private String password;
    
    // Seller constructor
    public Seller(int idNumber, String name, String email, String notification, String password, ArrayList<Product> inventory) {
        super(idNumber, name, email, notification);
        sellerInventory = new ArrayList();
        this.password = password;
        this.inventory = inventory;
    }
    
    /**
     * Returns all Products in Seller Inventory
     * @return 
     */
    public ArrayList<Product> getSellerInventory() {
        return sellerInventory;
    }
    
    /**
     * Sets the password
     * @param password New password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Returns Seller password
     * @return Seller password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Updates quantity of Product in Seller Inventory
     * @param id The Product ID
     * @param quantity The new quantity
     */
    @Override
    public void updateQuantity(int id, int quantity) {
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setQuantity(quantity);
            }
        }
    }
    
    /**
     * Updates price of Product in Seller Inventory
     * @param id The Product ID
     * @param price The new price
     */
    @Override
    public void updatePrice(int id, double price) {
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setPrice(price);
            }
        }
    }
    
    /**
     * Updates name of Product in Seller Inventory
     * @param id The Product ID
     * @param name The new name
     */
    @Override
    public void updateName(int id, String name) {
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setName(name);
            }
        }
    }
    
    /**
     * Updates description of Product in Seller Inventory
     * @param id The Product ID
     * @param description The new description
     */
    @Override
    public void updateDescription(int id, String description) {
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setDescription(description);
            }
        }
    }
}