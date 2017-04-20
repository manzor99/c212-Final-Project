/**
 * Contains methods for class that handles inventory
 */
public interface Admin {
    
    public void updateQuantity(int id, int quantity);
    public void updatePrice(int id, double price);
    public void updateName(int id, String name);
    public void updateDescription(int id, String description);
}