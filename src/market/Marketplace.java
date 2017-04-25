package market;

import people.*;
import java.util.*;

/**
 * Contains methods and data for Marketplace Administrator
 */
public class Marketplace implements Admin {

    private ArrayList<Buyer> buyers;
    private ArrayList<Seller> sellers;
    private ArrayList<Product> inventory;
    private FileHandler f;

    // Marketplace constructor
    public Marketplace() {
        f = new FileHandler();
        buyers = f.fillBuyers();
        sellers = f.fillSellers();
        inventory = f.fillInventory();
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
     *
     * @param id Buyer ID number
     */
    public void displayBuyerHistory(int id) {
    }

    /**
     * Displays Seller Inventory
     *
     * @param id Seller ID Number
     */
    public void displaySellerInventory(int id) {
    }

    /**
     * Adds Buyer or Seller to proper list
     *
     * @param person Buyer or Seller to add
     */
    public void addPerson(Person person) {
        buyers = f.fillBuyers();
        sellers = f.fillSellers();
        if (person instanceof Buyer) {
            buyers.add((Buyer) person);
            f.updateBuyers(buyers);
        } else {
            sellers.add((Seller) person);
            f.updateSellers(sellers);
        }
    }

    /**
     * Removes Buyer from list
     *
     * @param id Seller ID number
     */
    public void removeBuyer(int id) {
        buyers = f.fillBuyers();
        Iterator<Buyer> iter = buyers.iterator();
        while (iter.hasNext()) {
            if (iter.next().getIdNumber() == id) {
                iter.remove();
                break;
            }
        }

        f.updateBuyers(buyers);
    }

    public void addProduct(Product p) {
        inventory = f.fillInventory();
        inventory.add(p);
        f.updateProducts(inventory);
    }

    /**
     * Removes Seller from list
     *
     * @param id Seller ID number
     */
    public void removeSeller(int id) {
        sellers = f.fillSellers();
        Iterator<Seller> iter = sellers.iterator();
        while (iter.hasNext()) {
            if (iter.next().getIdNumber() == id) {
                iter.remove();
                break;
            }
        }

        f.updateSellers(sellers);
    }

    /**
     * Updates Person name
     *
     * @param person Buyer or Seller to update
     * @param name New name
     */
    public void updateName(Person person, String name) {
        buyers = f.fillBuyers();
        sellers = f.fillSellers();
        ArrayList<Person> list;

        if (person instanceof Buyer) {
            list = new ArrayList<>(buyers);
        } else {
            list = new ArrayList<>(sellers);
        }

        for (Person p : list) {
            if (p.getIdNumber() == person.getIdNumber()) {
                p.setName(name);
            }
        }
    }

    /**
     * Updates Person email
     *
     * @param person Buyer or Seller to update
     * @param email New email
     */
    public void updateEmail(Person person, String email) {
        buyers = f.fillBuyers();
        sellers = f.fillSellers();
        ArrayList<Person> list;

        if (person instanceof Buyer) {
            list = new ArrayList<>(buyers);
        } else {
            list = new ArrayList<>(sellers);
        }

        for (Person p : list) {
            if (p.getIdNumber() == person.getIdNumber()) {
                p.setEmail(email);
            }
        }

        f.updateBuyers(buyers);
        f.updateSellers(sellers);
    }

    /**
     * Updates Person's password
     *
     * @param person Person to update
     * @param password New password
     */
    public void updatePassword(Person person, String password) {
        buyers = f.fillBuyers();
        sellers = f.fillSellers();
        ArrayList<Person> list;

        if (person instanceof Buyer) {
            list = new ArrayList<>(buyers);
        } else {
            list = new ArrayList<>(sellers);
        }

        for (Person p : list) {
            if (p.getIdNumber() == person.getIdNumber()) {
                p.setPassword(password);
            }
        }

        f.updateBuyers(buyers);
        f.updateSellers(sellers);
    }

    /**
     * Updates person's personal inventory
     *
     * @param person Person to update
     * @param product Product to add
     */
    public void updatePersonalInventory(Person person, Product product) {
        buyers = f.fillBuyers();
        sellers = f.fillSellers();
        ArrayList<Person> list;

        if (person instanceof Buyer) {
            list = new ArrayList<>(buyers);
        } else {
            list = new ArrayList<>(sellers);
        }

        for (Person p : list) {
            if (p.getIdNumber() == person.getIdNumber()) {
                p.addInventory(product);
            }
        }

        f.updateBuyers(buyers);
        f.updateSellers(sellers);
    }

    /**
     * Update quantity of Product in Marketplace inventory
     *
     * @param id Product ID
     * @param quantity New quantity
     */
    @Override
    public void updateQuantity(int id, int quantity) {
        inventory = f.fillInventory();
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setQuantity(quantity);
            }
        }
        f.updateProducts(inventory);
    }

    /**
     * Update price of Product in Marketplace inventory
     *
     * @param id Product id
     * @param price New price
     */
    @Override
    public void updatePrice(int id, double price) {
        inventory = f.fillInventory();
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setPrice(price);
            }
        }
        f.updateProducts(inventory);
    }

    /**
     * Update name of Product in Marketplace inventory
     *
     * @param id Product ID
     * @param name New name
     */
    @Override
    public void updateName(int id, String name) {
        inventory = f.fillInventory();
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setName(name);
            }
        }
        f.updateProducts(inventory);
    }

    /**
     * Update description of Product in Marketplace inventory
     *
     * @param id Product ID
     * @param description New description
     */
    @Override
    public void updateDescription(int id, String description) {
        inventory = f.fillInventory();
        for (Product p : inventory) {
            if (p.getIDNumber() == id) {
                p.setDescription(description);
            }
        }
        f.updateProducts(inventory);
    }

    /**
     * Returns the list of buyers
     *
     * @return The Buyers
     */
    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    /**
     * Returns the list of sellers
     *
     * @return The Sellers
     */
    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    /**
     * Returns all of the inventory
     *
     * @return The Inventory
     */
    public ArrayList<Product> getInventory() {
        return inventory;
    }
}