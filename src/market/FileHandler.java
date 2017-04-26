package market;

import java.io.*;
import java.util.*;
import people.*;

/*
 * Class for handling Files (reading and updating)
 */
public class FileHandler {

    private File buyers, sellers;
    private Scanner scanner;
    private FileWriter writer;

    public FileHandler() {  // Constructor for instantiating all files 
        buyers = new File("Buyers.csv");
        sellers = new File("Sellers.csv");
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
                list = s.getInventory();
                String form = list.toString().replace(",", ";");
                toAppend = s.getIdNumber() + "," + s.getName() + "," + s.getEmail() + "," + s.getPassword() + "," + form;
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
                list = b.getInventory();
                String form = list.toString().replace(",", ";");
                toAppend = b.getIdNumber() + "," + b.getName() + "," + b.getEmail() + "," + b.getPassword() + "," + form;
                writer.append("\n" + toAppend);
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Fill ArrayList from Sellers file
     *
     * @return The ArrayList version
     */
    public ArrayList<Product> fillInventory() {
        ArrayList<Product> list = new ArrayList<>();

        try {
            scanner = new Scanner(sellers);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().trim().split(",");
                    String[] inventory = line[4].split(":");

                    if (!inventory.equals("[]")) {
                        for (String s : inventory) {
                            list.add(stringToProduct(s));
                        }
                    }
                }
            }
            
        } catch (FileNotFoundException | NumberFormatException e) {
        }
        
        scanner.close();
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
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().trim().split(",");
                    list.add(new Buyer(Integer.valueOf(line[0]), line[1], line[2], line[3],
                            stringToArrayList(line[4])));
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }
        
        scanner.close();

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
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().trim().split(",");
                    list.add(new Seller(Integer.valueOf(line[0]), line[1], line[2], line[3],
                            stringToArrayList(line[4])));
                }
            }

        } catch (FileNotFoundException | NumberFormatException e) {
        }
        
        scanner.close();
        return list;
    }

    /**
     * Method that parses String and turns it into ArrayList
     *
     * @param x The string
     * @return The list version
     */
    private ArrayList<Product> stringToArrayList(String x) {
        ArrayList<Product> list = new ArrayList<>();
        String newString = x.trim().substring(1, x.length() - 1);
        String[] rows = newString.split(";");

        if (!"[]".equals(x)) {  // If the inventory column isn't blank
            for (String row : rows) {
                String[] line = row.split(":");
                list.add(new Product(Integer.valueOf(line[0].trim()),
                        Integer.valueOf(line[5].trim()), Integer.valueOf(line[4].trim()),
                        line[1].trim(), line[2].trim(), Double.valueOf(line[3].trim())));
            }
        }

        return list;
    }

    /**
     * Method that parses String and turns it into Product
     *
     * @param x The string to parse
     * @return Product version of String
     */
    private Product stringToProduct(String x) {
        String newString = x.trim().substring(1, x.length() - 1);
        String[] line = newString.split(":");

        Product p = new Product(Integer.valueOf(line[0].trim()),
                Integer.valueOf(line[5].trim()), Integer.valueOf(line[4].trim()),
                line[1].trim(), line[2].trim(), Double.valueOf(line[3].trim()));

        return p;
    }
}