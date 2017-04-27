package market;

//wont let me use the * notation
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel; 

import people.Buyer;
import people.Person;
import people.Seller;

/**
 * @author Rocco
 *
 */
public class Interface {
    
	Marketplace market;
    JFrame frame;
    JPanel panel;
    JTextField username;
    JPasswordField pass;
    JButton login;
    JButton createAcc;
    JLabel usernameLbl;
    JLabel passLbl;
    JLabel inventory;
    JLabel buyersLbl;
    JLabel sellersLbl;
    JLabel historyLbl;
    UserListener listen;
    JTable inventoryDisplay;
    JTable history;
    SpringLayout layout;
 
    JMenuBar menuBar;
    
	JMenu buyers;
		JMenuItem purchase;
		
	JMenu sellers;
		JMenuItem yourInventory;
		JMenu addItem;
			JMenuItem existingItem;
			JMenuItem newItem;
	
    JMenu navigate;
    	JMenuItem mLogout;

    Person user; //user that is currently logged in
    
    /*
     * Creates an instance of the Interface class 
     */
    public Interface() { //login page
    	
    	layout = new SpringLayout();
		panel = new JPanel();
		//frame
		frame = new JFrame("Roccozon"); //its a pun on amazon
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		username = new JTextField();
		pass = new JPasswordField(); 
		passLbl = new JLabel("Password: ");
		usernameLbl = new JLabel("Email: ");
		createAcc = new JButton("Create"); 
		login = new JButton("Login");
		//end frame
		
		//menuBar
		menuBar = new JMenuBar();
		

		buyers = new JMenu("Buyers");
			
			purchase = new JMenuItem("Purchase");
			buyers.add(purchase);
			
		sellers = new JMenu("Sellers");
			yourInventory = new JMenuItem("Your Inventory");
			addItem = new JMenu("Add Items");
				existingItem = new JMenuItem("Change Quantity of Existing Item");
				newItem = new JMenuItem("New Item");
			
		
		sellers.add(yourInventory);
		sellers.add(addItem);
		addItem.add(existingItem);
		addItem.add(newItem);
		
		navigate = new JMenu("Navigate");
		mLogout = new JMenuItem("logout");
		
		
		menuBar.add(navigate);
		menuBar.add(this.buyers);
		menuBar.add(this.sellers);
		
		navigate.add(mLogout);
			
		menuBar.setVisible(true);
		frame.setJMenuBar(menuBar);
    	
        loginPage();
        
        listen = new UserListener(this);
        market = new Marketplace();
        
    }

    
	/**
	 * processes a login attempt
	 * @param email
	 * @param password
	 * @return boolean based on if the login attempt was successful or not
	 */
	public boolean loginAttempt(String email, String password){ //true if the username and pass match
		
		if(email.equals("admin@roccozon.com") && password.equals("admin")){
			user = null; //idk what to make this equal to *******************
			adminPage();
			return true;
		}
		
		if(userLookup(email, password) == null){
			return false;
		}
		else
			return true;
	}
	
	/**
	 * looks up a user in the marketplace to see if they exist
	 * @param email
	 * @param password
	 * @return the person that logged in
	 */
	public Person userLookup(String email, String password){
		
		for(Buyer buy : market.getBuyers()){
			if(buy.getEmail().equals(email) && buy.getPassword().equals(password)){
				user = buy;
				return buy;
			}
		}
		
		for(Seller sell : market.getSellers()){
			if(sell.getEmail().equals(email) && sell.getPassword().equals(password)){
				user = sell;
				return sell;
			}
		}
		JOptionPane.showMessageDialog(frame, "Invalid username or password.");
		return null;
	}
	
	/**
	 * loads the login page
	 */
	public void loginPage(){
		
		user = null;
		usernameLbl.setVisible(false);
		passLbl.setVisible(false);
		//end menuBar
			
		//username
		
		username.setSize(new Dimension(100, 30));
		layout.putConstraint(SpringLayout.WEST, username,
		              100,
		              SpringLayout.WEST, panel);
		
		layout.putConstraint(SpringLayout.NORTH, username,
		              50,
		              SpringLayout.NORTH, panel);
		//end username
		
		//usernameLbl
		usernameLbl.setVisible(true);
		panel.add(usernameLbl);
		username.setPreferredSize(new Dimension(100, 30)); //rearrange to look nicer
		usernameLbl.setPreferredSize(new Dimension(100, 30));
					
		layout.putConstraint(SpringLayout.WEST, usernameLbl,
		        30,
		        SpringLayout.WEST, panel);
						
		layout.putConstraint(SpringLayout.NORTH, usernameLbl,
		        50,
		        SpringLayout.NORTH, panel);
		//end usernameLbl
				
		//pass
		
		pass.setSize(new Dimension(100, 30));
		pass.setPreferredSize(new Dimension(100, 30));
				
		layout.putConstraint(SpringLayout.WEST, pass,
		        100,
		        SpringLayout.WEST, panel);
						
		layout.putConstraint(SpringLayout.NORTH, pass,
		        100,
		        SpringLayout.NORTH, panel);
				
		//end pass
		
		//passLbl
		passLbl.setVisible(true);
		panel.add(passLbl);
		passLbl.setLocation(0, 40);
		passLbl.setPreferredSize(new Dimension(100, 30));
				
		layout.putConstraint(SpringLayout.WEST, passLbl,
		        30,
		        SpringLayout.WEST, panel);
						
		layout.putConstraint(SpringLayout.NORTH, passLbl,
		        100,
		        SpringLayout.NORTH, panel);
		//end passLbl
				
		//login
		
		login.setPreferredSize(new Dimension(75, 30));
				
		layout.putConstraint(SpringLayout.WEST, login,
		        250,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, login,
		        50,
		        SpringLayout.NORTH, panel);
		//end login
				
				
				
		//createAcc
		
		
		createAcc.setPreferredSize(new Dimension(75, 30));
			
		layout.putConstraint(SpringLayout.WEST, createAcc,
		        250,
		        SpringLayout.WEST, panel);
						
		layout.putConstraint(SpringLayout.NORTH, createAcc,
		        100,
		        SpringLayout.NORTH, panel);
		//end createAcc
				
				
				
		//panel
				
		panel.setLayout(layout);
		panel.add(username);
		panel.add(pass);
		panel.add(login);
		panel.add(createAcc);
						
		//end panel
				
		frame.add(panel);
		
		frame.setPreferredSize(new Dimension(800, 500));
		frame.pack();
		frame.setVisible(true);

		frame.repaint();
		
	}
	
	/**
	 * loads the buyer page
	 */
	public void buyerPage(){
		
		frame.setVisible(false);
		
		historyLbl = new JLabel("History");
		historyLbl.setVisible(true);
		panel.add(historyLbl);
		
		String[] colNames = {"Name", "Price", "Quantity", "Decription"};
		
		String[][] items = new String[market.getInventory().size()][4];
		String[][] inventory = new String[user.getInventory().size()][4];
		
		//JTable history
	    //JLabel inventory;
		
		for(int i = 0; i < items.length; i++){
			
			items[i][0] = market.getInventory().get(i).getName();
			items[i][1] = "$" + Double.toString(market.getInventory().get(i).getPrice());
			items[i][2] = Integer.toString(market.getInventory().get(i).getQuantity());
			items[i][3] = market.getInventory().get(i).getDescription();
			
		}
		
		for (int i = 0; i < inventory.length; i++) {
			inventory[i][0] = user.getInventory().get(i).getName();
			inventory[i][1] = "$" + Double.toString(user.getInventory().get(i).getPrice());
			inventory[i][2] = Integer.toString(user.getInventory().get(i).getQuantity());
			inventory[i][3] = user.getInventory().get(i).getDescription();
		}
		
		inventoryDisplay = new JTable(market.getInventory().size(), 4);
		DefaultTableModel dtm = new DefaultTableModel(items, colNames);
		DefaultTableModel dtm1 = new DefaultTableModel(inventory  , colNames);
		history = new JTable(user.getInventory().size(), 4);
		history.setModel(dtm1);
		inventoryDisplay.setModel(dtm);
		history.setModel(dtm1);
		
		JScrollPane pane = new JScrollPane(inventoryDisplay);
		pane.setPreferredSize(new Dimension(300, 200));
		
		JScrollPane historyPane = new JScrollPane(history);
		historyPane.setPreferredSize(new Dimension(300, 200));
		historyPane.setVisible(true);
		panel.add(historyPane);
		
		
		layout.putConstraint(SpringLayout.WEST, historyPane,
		        60,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, historyPane,
		        160,
		        SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, historyLbl,
		        190,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, historyLbl,
		        125,
		        SpringLayout.NORTH, panel);
		
		//scroll pane
		
		layout.putConstraint(SpringLayout.WEST, pane,
		        415,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, pane,
		        160,
		        SpringLayout.NORTH, panel);

		
		//end scroll
		
		
		//panel
		layout.putConstraint(SpringLayout.WEST, inventoryDisplay,
		        415,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, inventoryDisplay,
		        160,
		        SpringLayout.NORTH, panel);
		
		panel.add(pane);
		//end panel
		
		usernameLbl.setText("Welcome " + user.getName() + "!");
		usernameLbl.setPreferredSize(new Dimension(200, 100));
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 24)); //might need to change font size *****
		
		//welcome lbl
		layout.putConstraint(SpringLayout.WEST, usernameLbl,
		        325,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, usernameLbl,
		        50,
		        SpringLayout.NORTH, panel);
		//end welcome
		

		//inventory label
		passLbl.setText("Items being sold");
		
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 18)); //might need to change font size *****
		
		layout.putConstraint(SpringLayout.WEST, passLbl,
		        517, 
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, passLbl,
		        125,
		        SpringLayout.NORTH, panel);
		//end inventory
		
		pass.setVisible(false);
		login.setVisible(false);
		username.setVisible(false);
		createAcc.setVisible(false);
		
		usernameLbl.setVisible(true);
		passLbl.setVisible(true);
		
		frame.setVisible(true);
		panel.repaint();
		frame.repaint();
	}

	/**
	 * loads the admin page
	 */
	public void adminPage(){
		
		frame.setVisible(false);
				
		//buyers/sellers lbls
			buyersLbl = new JLabel("Buyers");
			sellersLbl = new JLabel("Sellers");
					
			layout.putConstraint(SpringLayout.WEST, buyersLbl,
			        115, 
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, buyersLbl,
			        125,
			        SpringLayout.NORTH, panel);
				
			layout.putConstraint(SpringLayout.WEST, sellersLbl,
			        375, 
			        SpringLayout.WEST, panel);
						
			layout.putConstraint(SpringLayout.NORTH, sellersLbl,
			        125,
			        SpringLayout.NORTH, panel);
	
			panel.add(buyersLbl);
			panel.add(sellersLbl);
		//buyers/sellers lbls
		
		
				
		//welcome lbl
			panel.add(usernameLbl);
			usernameLbl.setText("Welcome Admin!");
			usernameLbl.setPreferredSize(new Dimension(200, 100));
			usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 24)); //might need to change font size *****
			layout.putConstraint(SpringLayout.WEST, usernameLbl,
			        295,
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, usernameLbl,
			        25,
			        SpringLayout.NORTH, panel);
			usernameLbl.setVisible(true);
			
			
		//end welcome		
		
			
		//passlbl aka inventory
			
			passLbl.setText("Items");
			
			layout.putConstraint(SpringLayout.WEST, passLbl, 637, SpringLayout.WEST, panel);
			layout.putConstraint(SpringLayout.NORTH, passLbl, 125, SpringLayout.NORTH, panel);
			
		//end passlbl
			
			
			
		//market inventory table aka pane
			String[] colNames = {"Name", "Price", "Quantity", "Decription"};
			String[][] items = new String[market.getInventory().size()][4];
			for(int i = 0; i < items.length; i++){
				items[i][0] = market.getInventory().get(i).getName();
				items[i][1] = "$" + Double.toString(market.getInventory().get(i).getPrice());
				items[i][2] = Integer.toString(market.getInventory().get(i).getQuantity());
				items[i][3] = market.getInventory().get(i).getDescription();
			}
			
			inventoryDisplay = new JTable(market.getInventory().size(), 4); //sorry for the magic number but its the number of attributes we need to display from the product class
			DefaultTableModel dtm = new DefaultTableModel(items, colNames);
			inventoryDisplay.setModel(dtm);
			
			
			JScrollPane pane = new JScrollPane(inventoryDisplay);
			pane.setPreferredSize(new Dimension(250, 200));
			
			pane.setVisible(true);
			panel.add(pane);
			
			
			layout.putConstraint(SpringLayout.WEST, pane,
			        530, 
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, pane,
			        160,
			        SpringLayout.NORTH, panel);

		//market inventory table
		
			
			
			
		//seller table
			
			String[] sellerColNames = {"Name", "ID", "Email"};
			String[][] sellers = new String[market.getSellers().size()][3];
			
			for(int i = 0; i < sellers.length; i++){
				sellers[i][0] = market.getSellers().get(i).getName();
				sellers[i][1] = Integer.toString(market.getSellers().get(i).getIdNumber());
				sellers[i][2] = market.getSellers().get(i).getEmail();
			}
			
			JTable sellerDisplay = new JTable(market.getSellers().size(), 3); 
			DefaultTableModel sellerdtm = new DefaultTableModel(sellers, sellerColNames);
			sellerDisplay.setModel(sellerdtm);
			
			
			JScrollPane sellerPane = new JScrollPane(sellerDisplay);
			sellerPane.setPreferredSize(new Dimension(250, 200));
			
			sellerPane.setVisible(true);
			panel.add(sellerPane);
			
			
			layout.putConstraint(SpringLayout.WEST, sellerPane,
			        270, 
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, sellerPane,
			        160,
			        SpringLayout.NORTH, panel);
			
		//seller table
			
			//buyer table

			String[] buyerColNames = {"Name", "ID", "Email"};
			String[][] buyers = new String[market.getBuyers().size()][3];
			for(int i = 0; i < buyers.length; i++){
				buyers[i][0] = market.getBuyers().get(i).getName();
				buyers[i][1] = Integer.toString(market.getBuyers().get(i).getIdNumber());
				buyers[i][2] = market.getBuyers().get(i).getEmail();
			}

			JTable buyerDisplay = new JTable(market.getBuyers().size(), 3); 
			DefaultTableModel buyerdtm = new DefaultTableModel(buyers, buyerColNames);
			buyerDisplay.setModel(buyerdtm);


			JScrollPane buyerPane = new JScrollPane(buyerDisplay);
			buyerPane.setPreferredSize(new Dimension(250, 200));

			buyerPane.setVisible(true);
			panel.add(buyerPane);


			layout.putConstraint(SpringLayout.WEST, buyerPane,
			        10, 
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, buyerPane,
			        160,
			        SpringLayout.NORTH, panel);

			//buyer table
			
		pass.setVisible(false);
		username.setVisible(false);
		login.setVisible(false);
		createAcc.setVisible(false);
			
		panel.repaint();
		frame.setVisible(true);
		
	}
	
	
	/**
	 * loads the seller page
	 */
	public void sellerPage(){
		
		frame.setVisible(false);
		
		String[] colNames = {"Name", "Price", "Quantity", "Decription"};
		
		String[][] items = new String[user.getInventory().size()][4];
		for(int i = 0; i < items.length; i++){
			items[i][0] = user.getInventory().get(i).getName();
			items[i][1] = "$" + Double.toString(user.getInventory().get(i).getPrice());
			items[i][2] = Integer.toString(user.getInventory().get(i).getQuantity());
			items[i][3] = user.getInventory().get(i).getDescription();
		}
		
		inventoryDisplay = new JTable(market.getInventory().size(), 4); //sorry for the magic number but its the number of attributes we need to display from the product class
		DefaultTableModel dtm = new DefaultTableModel(items, colNames);
		inventoryDisplay.setModel(dtm);
		
		
		JScrollPane pane = new JScrollPane(inventoryDisplay);
		pane.setPreferredSize(new Dimension(300, 200));
		
		//scroll pane
		
		layout.putConstraint(SpringLayout.WEST, pane,
		        220,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, pane,
		        160,
		        SpringLayout.NORTH, panel);

		
		//end scroll
		
		
		//panel
		layout.putConstraint(SpringLayout.WEST, inventoryDisplay,
		        220,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, inventoryDisplay,
		        160,
		        SpringLayout.NORTH, panel);
		
		panel.add(pane);
		//end panel
		
		usernameLbl.setText("Welcome " + user.getName() + "!");
		usernameLbl.setPreferredSize(new Dimension(200, 100));
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 24)); //might need to change font size *****
		
		//welcome lbl
		layout.putConstraint(SpringLayout.WEST, usernameLbl,
		        305,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, usernameLbl,
		        50,
		        SpringLayout.NORTH, panel);
		//end welcome
		

		//inventory label
		passLbl.setText("Your inventory");
		
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 18)); //might need to change font size *****
		
		layout.putConstraint(SpringLayout.WEST, passLbl,
		        327,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, passLbl,
		        125,
		        SpringLayout.NORTH, panel);
		//end inventory
		
		pass.setVisible(false);
		login.setVisible(false);
		username.setVisible(false);
		createAcc.setVisible(false);
		
		frame.pack();
		usernameLbl.setVisible(true);
		passLbl.setVisible(true);
		frame.setVisible(true);
	}
	
	
	/**
	 * tries to create an account with the values in the text boxes
	 * @return boolean based on if the accounts creation was successful or not
	 */
	public boolean createAccount(){
		JOptionPane popup = new JOptionPane();
		int largestID = 0; //nobody will have a negative ID
		
		if(username.getText() == null || ! (username.getText().contains("@") && username.getText().contains(".")) && pass.getText() == null && ! username.getText().equals("admin@roccozon.com")){
			popup.showMessageDialog(frame, "Invalid email");
			return false;
		}
		
		for(Buyer buy : market.getBuyers()){
			if(buy.getIdNumber() > largestID)
				largestID = buy.getIdNumber();
			
			if(buy.getEmail().equals(this.username.getText())){
				popup.showMessageDialog(frame, "Email already registered");
				return false;
			}
		}
		
		for(Seller seller : market.getSellers()){
			if(seller.getIdNumber() > largestID)
				largestID = seller.getIdNumber();
			
			if(seller.getEmail().equals(this.username.getText())){
				popup.showMessageDialog(frame, "Email already registered");
				return false;
			}
		}
		
		//add the create an account stuff
		Object[] options = {"Buyer", "Seller"};
		int choice = JOptionPane.showOptionDialog(//0 is buyer 1 is seller
				frame, 
			    "Are you a buyer or a seller?",
			    "Account Type",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,     
			    options,  
			    options[0]); 
		
		String name = (String)JOptionPane.showInputDialog(
                frame, "Enter your name:", "");
		
		if(choice == 1){
			user = new Seller(largestID + 1, name, username.getText(),  pass.getText(), new ArrayList<Product>());
			
		}
		
		else{
			user = new Buyer(largestID + 1, name, username.getText(),  pass.getText(), new ArrayList<Product>());
			
		}
				
		market.addPerson(user);
		
		return true;
	}
	
	//**********VVVVVVVVVVVVVVVVVVVVVV*************
	
	/**
	 * loads the seller's inventory in a JTable
	 */
	public void loadSellerInventory() {
		if(user == null || !(user instanceof Seller)){
			JOptionPane popup = new JOptionPane("Invalid User");
    		popup.showMessageDialog(frame, "Must be logged in as a seller to do that.");
    		return;
		}
		else{
			
			this.sellerPage();
			
			String[] colNames = {"Name", "Price", "Quantity", "Decription"};
			String[][] items = new String[market.getInventory().size()][4];
			
			for(int i = 0; i < items.length; i++){
				items[i][0] = user.getInventory().get(i).getName();
				items[i][1] = "$" + Double.toString(user.getInventory().get(i).getPrice());
				items[i][2] = Integer.toString(user.getInventory().get(i).getQuantity());
				items[i][3] = user.getInventory().get(i).getDescription();
				
			}
			if(inventoryDisplay != null){
				inventoryDisplay.setVisible(false);
				panel.remove(inventoryDisplay);
			}
				
			inventoryDisplay = new JTable(market.getInventory().size(), 4); //sorry for the magic number but its the number of attributes we need to display from the product class
			DefaultTableModel dtm = new DefaultTableModel(items, colNames);
			inventoryDisplay.setModel(dtm);
			
			layout.putConstraint(SpringLayout.WEST, inventoryDisplay,
			        220,
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, inventoryDisplay,
			        160,
			        SpringLayout.NORTH, panel);
			
			inventoryDisplay.setVisible(true);
			inventoryDisplay.repaint();
			panel.add(inventoryDisplay);
			panel.repaint();
			frame.repaint();
	
		}
	
	}
	
	/**
	 * lets a seller change the quantity of an item they are selling
	 */
	public void addExistingItem() {
		
		if(user == null || !(user instanceof Seller)){
			JOptionPane.showMessageDialog(frame, "Must be logged in as a seller to do that.");
    		return;
		}
		
		Object[] items = new Object[user.getInventory().size()];
		int quantity;
		Product item = null;
		
		for (int i = 0; i < items.length; i++) {
			items[i] = user.getInventory().get(i).getName();
		}
		
		String itemName = (String) JOptionPane.showInputDialog(frame, "Which item would you like to add more of?",
		        "Items", JOptionPane.QUESTION_MESSAGE, null,                                       
		        items,
		        items[0]);
		
		
		
		if(itemName == null)
			return;
		else{
			
			try {
				quantity = Integer.parseInt((String)JOptionPane.showInputDialog(frame, "How many of this item are you selling?", ""));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Invalid quantity");
				return;
			}
			
			if(quantity < 0){
				JOptionPane.showMessageDialog(frame, "Invalid quantity");
				return;
			}
			
			for (Product p : user.getInventory()) {
				if(itemName.equals(p.getName())){
					item = p;
					break;
				}
					
			}
			
			((Seller) user).updateQuantity(item.getIDNumber(), quantity);
			sellerPage();
		}
		
		
		
	}
	
	/**
	 * allows a seller to add a new item they are selling
	 */
	public void addNewItem() {
		
		if(user == null || ! (user instanceof Seller)){
			JOptionPane.showMessageDialog(frame, "Must be logged in as a seller to do that.");
    		return;
		}
			
		
		String name = (String)JOptionPane.showInputDialog(frame, "Enter the item's name:", "");
		String description = (String)JOptionPane.showInputDialog(frame, "Enter the item's description:", "");
		double price;
		int quantity;
		
		try {
			price = Double.parseDouble((String)JOptionPane.showInputDialog(frame, "Enter the price of the item:", ""));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Invalid price");
			return;
		}
		
		try {
			quantity = Integer.parseInt((String)JOptionPane.showInputDialog(frame, "Enter the quantity of the item:", ""));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Invalid quantity");
			return;
		}
		
		int idNumber = 0;
		
		for(Product item : market.getInventory()){
			if(item.getIDNumber() >= idNumber){
				idNumber = item.getIDNumber() + 1;
			}
		}
		
		Product item = new Product(idNumber, user.getIdNumber(), quantity, name, description, price);
		((Seller) user).addToInvetory(item);
		market.updatePersonalInventory(user, item);
		market.addProduct(item); //remove when andrew implements the stuff************
		sellerPage();
	}
	
	/**
	 * loads a JTable with items currently being sold on the market
	 */
	public void loadItemsToBuy() {

		if(user == null || !(user instanceof Buyer)){
			JOptionPane.showMessageDialog(frame, "Must be logged in as a buyer to do that.");
    		return;
    		
		}
		
		String[] colNames = {"Name", "Price", "Quantity", "Decription"};
		
		String[][] items = new String[market.getInventory().size()][4];
		for(int i = 0; i < items.length; i++){
			
			items[i][0] = market.getInventory().get(i).getName();
			items[i][1] = "$" + Double.toString(market.getInventory().get(i).getPrice());
			items[i][2] = Integer.toString(market.getInventory().get(i).getQuantity());
			items[i][3] = market.getInventory().get(i).getDescription();
			
		}
		
		inventoryDisplay = new JTable(market.getInventory().size(), 4);
		DefaultTableModel dtm = new DefaultTableModel(items, colNames);
		inventoryDisplay.setModel(dtm);
		
	}

	
	/**
	 * called when a user tries to buy an item
	 */
	public void buyItem() {
		
		if(user == null || !(user instanceof Buyer)){
			JOptionPane.showMessageDialog(frame, "Must be logged in as a buyer to do that.");
    		return;
		}
		
		Object[] items = new Object[market.getInventory().size()];
		
		int quantity;
		Product item = null;
		
		for (int i = 0; i < items.length; i++) {
			items[i] = market.getInventory().get(i).getName();
		}
		
		String itemName = (String) JOptionPane.showInputDialog(frame, "Which item would you like to purchase?",
		        "Items", JOptionPane.QUESTION_MESSAGE, null,                                       
		        items,
		        items[0]);
		
		
		
		if(itemName == null)
			return;
		else{
			
			try {
				quantity = Integer.parseInt((String)JOptionPane.showInputDialog(frame, "How many of this item would you like to purchase?", ""));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Invalid quantity");
				return;
			}
			
			for (Product p : market.getInventory()) {
				if(itemName.equals(p.getName())){
					item = p;
					break;
				}
					
			}
			
			if(quantity > item.getQuantity()){
				JOptionPane.showMessageDialog(frame, "Invalid quantity");
				return;
			}
			
			
			
			
			for (int i = 0; i < quantity; i++) {
				((Buyer)user).buyProduct(item.getIDNumber());
				((Buyer)user).buyProduct(item.getIDNumber());
			}
			
		}
		
		market.getFileHandler().updateBuyers(market.getBuyers());
		market.getFileHandler().updateSellers(market.getSellers());
		
	}
	
	/**
	 * loads a buyer's purchase history
	 */
	public void loadPurchaseHistory() {

		if(user == null || !(user instanceof Buyer)){
			JOptionPane popup = new JOptionPane("Invalid User");
    		popup.showMessageDialog(frame, "Must be logged in as a buyer to do that.");
    		return;
		}
		else{
			
			this.buyerPage();
			
			panel.remove(inventoryDisplay);
			
			String[] colNames = {"Name", "Price", "Quantity", "Decription"};
			String[][] items = new String[user.getInventory().size()][4];
			
			DefaultTableModel model = (DefaultTableModel) inventoryDisplay.getModel();
			model.getDataVector().removeAllElements();
			
			for(int i = 0; i < items.length; i++){
				items[i][0] = user.getInventory().get(i).getName();
				items[i][1] = "$" + Double.toString(user.getInventory().get(i).getPrice());
				items[i][2] = Integer.toString(user.getInventory().get(i).getQuantity());
				items[i][3] = user.getInventory().get(i).getDescription();
				
			}
			if(inventoryDisplay != null){
				inventoryDisplay.setVisible(false);
				panel.remove(inventoryDisplay);
			}
				
			inventoryDisplay = new JTable(user.getInventory().size(), 4); //sorry for the magic number but its the number of attributes we need to display from the product class
			DefaultTableModel dtm = new DefaultTableModel(items, colNames);
			inventoryDisplay.setModel(dtm);
			
			layout.putConstraint(SpringLayout.WEST, inventoryDisplay,
			        220,
			        SpringLayout.WEST, panel);
					
			layout.putConstraint(SpringLayout.NORTH, inventoryDisplay,
			        160,
			        SpringLayout.NORTH, panel);
			
			inventoryDisplay.setVisible(true);
			inventoryDisplay.repaint();
			panel.add(inventoryDisplay);
			panel.repaint();
			//frame.repaint();
		
		}
	}
	
    private class UserListener implements ActionListener {

        Interface face;

        /**
         * creates an instance of UserListener that listens to all objects on the given interface
         * @param face
         */
        public UserListener(Interface face) {

            this.face = face;
            face.login.addActionListener(this);
            face.createAcc.addActionListener(this);
            face.yourInventory.addActionListener(this);
            face.existingItem.addActionListener(this);
            face.newItem.addActionListener(this);
			face.mLogout.addActionListener(this);
			face.purchase.addActionListener(this);

        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            	if (e.getSource() == face.login) {
                	loginAttempt(username.getText(), pass.getText());
                	                	
                	if(face.user instanceof Seller){
                		//face.user = person;
                		face.sellerPage();
                	}
                	
                	if(face.user instanceof Buyer){
                		//face.user = person;
                		face.buyerPage();
                	}
                	
                }
            	else if(e.getSource() == face.createAcc){
            		face.createAccount();
            	}
            	
            	else if(e.getSource() == face.yourInventory){
            		face.loadSellerInventory();
            	}
            	
            	else if(e.getSource() == face.existingItem){
            		face.addExistingItem();
            	}
            	
            	else if(e.getSource() == face.newItem){
            		face.addNewItem();
            	}
            	            	
            	else if(e.getSource() == face.purchase){
            		face.buyItem();
            	}
            	
            	else if(e.getSource() == face.mLogout){
            		System.exit(0);
            	}
            	
            	
           
        }

    }

}
