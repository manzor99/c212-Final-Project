package people;

import java.util.ArrayList;
import market.*;

/**
 * Contains methods and data for a Person in the market (buyers and sellers)
 */

public abstract class Person {
    
    private int idNumber;
    private String name, email, password;
    private ArrayList<Product> personalInv;
    private FileHandler f;
    
    // Person constructor
    public Person(int idNumber, String name, String email, String password, ArrayList<Product> personalInv) {
        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        this.password = password;
        this.personalInv = personalInv;
        f = new FileHandler();
    }
    
    /**
     * Returns the Person ID
     * @return ID number
     */
    public int getIdNumber() {
        return idNumber;
    }
    
    /**
     * Sets the Person's ID
     * @param idNumber The new ID
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    
    /**
     * Returns the Person's name
     * @return Name of the Person
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the Person
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns the Person's email
     * @return The email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the Person's email
     * @param email New email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Returns Person's password
     * @return The password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets Person's password
     * @param password New password to use
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Adds product to personalInv
     * @param p Product to add
     */
    public void addInventory(Product p) {
        personalInv.add(p);
    }
    
    /**
     * Returns Person's personalInv
     * @return Individual personalInv (bought or to sell)
     */
    public ArrayList<Product> getInventory() {
        return personalInv;
    }
}