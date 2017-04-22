package market;

import java.util.ArrayList;
import people.Buyer;

public class Run {

    public static void main(String[] args) {
        FileHandler f = new FileHandler();
        Buyer p = new Buyer(0, "Andrew", "blah", new ArrayList<Product>());
        f.updatePerson(p, 1, "New Name");
    }

}
