package market;

import people.Admin;
import people.Buyer;
import people.Seller;
import people.Person;
import java.util.ArrayList;

/**
 * Contains methods and data for Marketplace Administrator
 */
public class Marketplace implements Admin {
    
    private ArrayList<Buyer> buyers;
    private ArrayList<Seller> sellers;
    private ArrayList<Product> inventory;
    
    // Marketplace constructor
    public Marketplace() {
        buyers = new ArrayList();
        sellers = new ArrayList();
        inventory = new ArrayList();
    }
    
    /**
     * Displays Buyers on Marketplace
     */
    public void displayBuyers() {
    }
    
    /**
     * Displays Sellers on Marketplace
     */
    public void displaySellers() {
    }
    
    /**
     * Displays Buyer purchase history
     * @param id Buyer ID number
     */
    public void displayBuyerHistory(int id) {
    }
    
    /**
     * Displays Seller Inventory
     * @param id Seller ID Number
     */
    public void displaySellerInventory(int id) {   
    }
    
    /**
     * Adds Buyer or Seller to proper list
     * @param person Buyer or Seller to add
     */
    public void addPerson(Person person) {
    }
    
    /**
     * Removes Buyer from list
     * @param id Seller ID number
     */
    public void removeBuyer(int id) {
    }
    
    /**
     * Removes Seller from list
     * @param id Seller ID number
     */
    public void removeSeller(int id) {   
    }
    
    /**
     * Updates Person name
     * @param person Buyer or Seller to update
     * @param name New name
     */
    public void updateName(Person person, String name) {
    }
    
    /**
     * Updates Person email
     * @param person Buyer or Seller to update
     * @param email New email
     */
    public void updateEmail(Person person, String email) {
    }
    
    /**
     * Updates Seller password
     * @param seller Seller to update
     * @param password New password
     */
    public void updatePassword(Seller seller, String password) {
    }
    
    /**
     * Update quantity of Product in Marketplace inventory
     * @param id Product ID
     * @param quantity New quantity
     */
    @Override
    public void updateQuantity(int id, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Update price of Product in Marketplace inventory
     * @param id Product id
     * @param price New price
     */
    @Override
    public void updatePrice(int id, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Update name of Product in Marketplace inventory
     * @param id Product ID
     * @param name New name
     */
    @Override
    public void updateName(int id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Update description of Product in Marketplace inventory
     * @param id Product ID
     * @param description New description
     */
    @Override
    public void updateDescription(int id, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}