package market;

/**
 * Stores information about product in inventory
 */
public class Product {

    private int idNumber, sellerId, quantity;
    private String name, description;
    private double price;

    // Product constructor
    public Product(int idNumber, int sellerId, int quantity, String name, String description, double price) {
        this.idNumber = idNumber;
        this.sellerId = sellerId;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Returns the product ID
     *
     * @return ID number
     */
    public int getIDNumber() {
        return idNumber;
    }

    /**
     * Sets the ID Number
     *
     * @param idNumber New ID
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Returns the ID of the product's seller
     *
     * @return The seller ID
     */
    public int getSellerId() {
        return sellerId;
    }

    /**
     * Returns the current quantity
     *
     * @return The quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity
     *
     * @param quantity The new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the Product name
     *
     * @return Name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Product name
     *
     * @param name The new Product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Product description
     *
     * @return Description of Product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Product description
     *
     * @param description New Product description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the Product price
     *
     * @return The price of the Product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price
     *
     * @param price The new Product price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return getName() + ": " + "\nID: " + getIDNumber() 
                + "\nDescription: " + getDescription() + "\nPrice: " 
                + "\nQuantity: " + getQuantity();
    }
}