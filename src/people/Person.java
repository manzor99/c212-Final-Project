package people;

/**
 * Contains methods and data for a Person in the market (buyers and sellers)
 */

public abstract class Person {
    
    private int idNumber;
    private String name, email, notification;
    
    // Person constructor
    public Person(int idNumber, String name, String email, String notification) {
        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        this.notification = notification;
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
     * Returns Person's notifications
     * @return Notifications
     */
    public String getNotification() {
        return notification;
    }
    
    /**
     * Sets the notifications
     * @param notification New notification
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }
}