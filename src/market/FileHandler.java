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

    public FileHandler() {  // Constructor for instantiating all files 
        buyers = new File("Buyers.csv");
        sellers = new File("Sellers.csv");
        inventory = new File("Inventory.csv");
    }

    /**
     * Method to update Sellers
     *
     * @param sellersList The list of sellers
     */
    public void updateSellers(ArrayList<Seller> sellersList) {
        try {
            writer = new FileWriter(sellers);
            writer.append("ID,Name,Email,Password,Inventory");  // Append the header
            ArrayList<Product> list;
            String toAppend;

            for (Seller s : sellersList) {
                list = s.getSellerInventory();
                toAppend = s.getIdNumber() + "," + s.getName() + "," + s.getEmail() + "," + s.getPassword() + "," + list;
                writer.append("\n" + toAppend);
            }
            writer.close();
        } catch (IOException e) {
        }
    }

    /**
     * Method to update Buyers
     *
     * @param buyersList The list of buyers
     */
    public void updateBuyers(ArrayList<Buyer> buyersList) {
        try {
            writer = new FileWriter(buyers);
            writer.append("ID,Name,Email,Password,Inventory");  // Append the header
            ArrayList<Product> list;
            String toAppend;

            for (Buyer b : buyersList) {
                list = b.getBoughtItems();
                toAppend = b.getIdNumber() + "," + b.getName() + "," + b.getEmail() + "," + b.getPassword() + "," + list;
                writer.append("\n" + toAppend);
            }
            
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Method to update Products file
     *
     * @param inventoryList The list of inventory
     */
    public void updateProducts(ArrayList<Product> inventoryList) {
        try {
            writer = new FileWriter(inventory);
            writer.append("ID,Name,Description,Price,Quantity,SellerID");  // Append the header
            String toAppend;

            for (Product p : inventoryList) {
                toAppend = "\n" + p.getIDNumber() + "," + p.getName() + "," + p.getDescription()
                        + "," + p.getPrice() + "," + p.getQuantity() + "," + p.getSellerId();
                writer.append("\n" + toAppend);
            }
            
            writer.close();
        } catch (IOException e) {
        }
    }

    /**
     * Fill ArrayList from Inventory file
     *
     * @return The ArrayList version
     */
    public ArrayList<Product> fillInventory() {
        ArrayList<Product> list = new ArrayList<>();

        try {
            scanner = new Scanner(inventory);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                list.add(new Product(Integer.valueOf(line[0]), Integer.valueOf(line[5]),
                        Integer.valueOf(line[4]), line[1], line[2], Double.valueOf(line[3])));
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * Fill ArrayList from Buyers
     *
     * @return The ArrayList version
     */
    public ArrayList<Buyer> fillBuyers() {
        ArrayList<Buyer> list = new ArrayList<>();

        try {
            scanner = new Scanner(buyers);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split(",");
                list.add(new Buyer(Integer.valueOf(line[0]), line[1], line[2], line[3],
                        stringToProduct(line[4])));
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        return list;
    }

    /**
     * Fill ArrayList from Sellers
     *
     * @return The ArrayList version
     */
    public ArrayList<Seller> fillSellers() {
        ArrayList<Seller> list = new ArrayList<>();

        try {
            scanner = new Scanner(sellers);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                String[] line = scanner.nextLine().split(",");
                list.add(new Seller(Integer.valueOf(line[0]), line[1], line[2], line[3],
                        stringToProduct(line[4])));
            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }

        return list;
    }

    /**
     * Method that parses String and turns it into ArrayList
     *
     * @param x The string
     * @return The list version
     */
    private ArrayList<Product> stringToProduct(String x) {
        ArrayList<Product> list = new ArrayList<>();
        String newString = x.trim().substring(1, x.length() - 1);
        String[] rows = newString.split(",");

        if (!"[]".equals(x)) {  // If the inventory column isn't blank
            for (String row : rows) {
                String[] line = row.split(":");
                list.add(new Product(Integer.valueOf(line[0]),
                        Integer.valueOf(line[5]), Integer.valueOf(line[4]),
                        line[1], line[2], Double.valueOf(line[3])));
            }
        }

        return list;
    }
}