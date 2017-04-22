package market;

import java.io.*;
import java.util.*;
import people.*;

/*
 * Class for handling Files (reading and updating)
 */
public class FileHandler {

    private File buyers, sellers, inventory;
    private Scanner scanner;
    private FileWriter writer;

    public FileHandler() {
        buyers = new File("Buyers.csv");
        sellers = new File("Sellers.csv");
        inventory = new File("Inventory.csv");
    }

    /**
     * Inserts Person into Buyer or Seller file
     *
     * @param p The person to insert
     */
    public void insertPerson(Person p) {
        ArrayList<Product> list;

        try {
            if (p instanceof Buyer) {
                writer = new FileWriter(buyers, true);
                list = ((Buyer) p).getBoughtItems();
            } else {
                writer = new FileWriter(sellers, true);
                list = ((Seller) p).getSellerInventory();
            }

            writer.append(p.getIdNumber() + "," + p.getName() + "," + p.getEmail() + "," + list + "\n");
            writer.close();
        } catch (IOException e) {
        }
    }

    /**
     * Inserts product into Inventory file
     *
     * @param p The product to insert
     */
    public void insertProduct(Product p) {
        try {
            writer = new FileWriter(inventory, true);
            writer.append(p.getIDNumber() + "," + p.getName() + "," + p.getDescription()
            + "," + p.getPrice() + "," + p.getQuantity() + "," + p.getSellerId());
        } catch (IOException e) {
        }
    }

    /**
     * Updates Person in Buyer or Seller file
     *
     * @param p The Person to update
     * @param fieldNum The field to update
     * @param newValue The new value
     */
    public void updatePerson(Person p, int fieldNum, String newValue) {
        try {
            String line;
            
            if (p instanceof Buyer) {
                scanner = new Scanner(buyers);
            } else {
                scanner = new Scanner(sellers);
            }
            
            while (scanner.nextLine() != null) {
                line = scanner.nextLine();
                System.out.println(line);
                String[] row = line.split(",");
                if (Integer.valueOf(row[0]) == p.getIdNumber()) {
                    row[fieldNum] = newValue;
                } else {
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
        }
    }

    /**
     * Updates Product in Inventory file
     *
     * @param p The product to update
     * @param fieldNum The field to update
     */
    public void updateProduct(Person p, int fieldNum) {
        
    }

    public ArrayList<Product> fillInventory() {
        return null;
    }

    public ArrayList<Buyer> fillBuyers() {
        return null;
    }

    public ArrayList<Seller> fillSellers() {
        return null;
    }
}
