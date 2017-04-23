package market;

import java.util.ArrayList;
import java.util.logging.FileHandler;

import people.Buyer;
import people.Seller;

public class Run {

    public static void main(String[] args) {
        Interface face = new Interface();
        face.sellerPage(new Seller(1, "Rocco", "email", "asgd", "pass", null));
    }

}
