package market;

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
import javax.swing.table.DefaultTableModel; //idk why i need this import but it gives an error without it

import people.Buyer;
import people.Person;
import people.Seller;

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
    UserListener listen;
    JTable inventoryDisplay;
    SpringLayout layout;

    JMenuBar menuBar;
    
	JMenu buyers;
		JMenuItem purchaseHistory;
		JMenuItem shop;
		
	JMenu sellers;
		JMenuItem yourInventory;
		JMenu addItem;
			JMenuItem existingItem;
			JMenuItem newItem;
		JMenuItem removeItem;
	
    JMenu navigate;
    JMenuItem mLogout;
    JMenuItem mCreate;

    Person user; //user that is currently logged in
    
    //remove popup variable and use static method instead************** 
    
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
			purchaseHistory = new JMenuItem("Purchase History");
			shop = new JMenuItem("Shop");
			buyers.add(purchaseHistory);
			buyers.add(shop);			
			
		sellers = new JMenu("Sellers");
			yourInventory = new JMenuItem("Your Inventory");
			addItem = new JMenu("Add Items");
				existingItem = new JMenuItem("Existing Item");
				newItem = new JMenuItem("New Item");
			removeItem = new JMenuItem("Remove Item");
			
		
		sellers.add(yourInventory);
		sellers.add(addItem);
		addItem.add(existingItem);
		addItem.add(newItem);
		sellers.add(removeItem);
		
		navigate = new JMenu("Navigate");
		mLogout = new JMenuItem("logout");
		mCreate = new JMenuItem("Create Account");
		
		
		menuBar.add(navigate);
		//menuBar.add(help);
		//menuBar.add(info);
		menuBar.add(this.buyers);
		menuBar.add(this.sellers);
		
		navigate.add(mLogout);
		navigate.add(mCreate);
		
		
		/*
		help = new JMenu("Help");
			helpItem = new JMenuItem("Help");
			help.add(helpItem);
			
		info = new JMenu("Info");
			aboutUs = new JMenuItem("About Us");
			info.add(aboutUs);
			*/
		
			
			
		menuBar.setVisible(true);
		frame.setJMenuBar(menuBar);
    	
        loginPage();
        
        listen = new UserListener(this);
        market = new Marketplace();
        
    }

    /*
    public void frameSetup(){
    	layout = new SpringLayout();
		panel = new JPanel();
		usernameLbl = new JLabel("Email: ");
		username = new JTextField();
		pass = new JPasswordField();
		passLbl = new JLabel("Password: ");
		login = new JButton("Login");
		createAcc = new JButton("Create");
		//frame
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//end frame
		
		//menuBar
		menuBar = new JMenuBar();
		

		buyers = new JMenu("Buyers");
			purchaseHistory = new JMenuItem("Purchase History");
			shop = new JMenuItem("Shop");
			buyers.add(purchaseHistory);
			buyers.add(shop);			
			
		sellers = new JMenu("Sellers");
			yourInventory = new JMenuItem("Your Inventory");
			addItem = new JMenu("Add Items");
				existingItem = new JMenuItem("Existing Item");
				newItem = new JMenuItem("New Item");
			removeItem = new JMenuItem("Remove Item");
			
		
		sellers.add(yourInventory);
		sellers.add(addItem);
		addItem.add(existingItem);
		addItem.add(newItem);
		sellers.add(removeItem);
		
		navigate = new JMenu("Navigate");
		mLogout = new JMenuItem("logout");
		mCreate = new JMenuItem("Create Account");
		
		
		menuBar.add(navigate);
		//menuBar.add(help);
		//menuBar.add(info);
		menuBar.add(this.buyers);
		menuBar.add(this.sellers);
		
		navigate.add(mLogout);
		navigate.add(mCreate);
			
		menuBar.setVisible(true);
		frame.setJMenuBar(menuBar);
    	
    }
    */
    
	public boolean loginAttempt(String email, String password){ //true if the username and pass match
		if(userLookup(email, password) == null){
			return false;
		}
		else
			return true;
	}
	
	public Person userLookup(String email, String password){
		
		for(Buyer buy : market.getBuyers()){
			if(buy.getEmail().equals(email) && buy.getPassword().equals(password))
				return buy;
		}
		
		for(Seller sell : market.getSellers()){
			if(sell.getEmail().equals(email) && sell.getPassword().equals(password))
				return sell;
		}
		
		return null;
	}
	
	public void loginPage(){
		
		user = null;
		usernameLbl.setVisible(false);
		passLbl.setVisible(false);
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
				
		
		//end menuBar
			
		//username
		
		//username.setLocation(100, 100);
		username.setSize(new Dimension(100, 30));
		layout.putConstraint(SpringLayout.WEST, username,
		              100,
		              SpringLayout.WEST, panel);
		
		layout.putConstraint(SpringLayout.NORTH, username,
		              50,
		              SpringLayout.NORTH, panel);
		//end username
		
		//usernameLbl
		
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
		panel.add(passLbl);
		panel.add(usernameLbl);
		panel.add(login);
		panel.add(createAcc);
						
		//end panel
				
		frame.add(panel);
		
		frame.setPreferredSize(new Dimension(800, 500));
		frame.pack();
		frame.setVisible(true);

		frame.repaint();
		
	}
	
	public void buyerPage(Buyer buy){
		
		user = buy;
		frame.setVisible(false);
		
		String[] colNames = {"Name", "Price", "Quantity", "Decription"};
		
		String[][] items = new String[market.getInventory().size()][4];
		//the market doesn't load the inventory*************
		for(int i = 0; i < items.length; i++){
			
			items[i][0] = market.getInventory().get(i).getName();
			items[i][1] = "$" + Double.toString(market.getInventory().get(i).getPrice());
			items[i][2] = Integer.toString(market.getInventory().get(i).getQuantity());
			items[i][3] = market.getInventory().get(i).getDescription();
			
		}
		
		inventoryDisplay = new JTable(market.getInventory().size(), 4);
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
		//panel.add(inventoryDisplay);
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
		passLbl.setText("Items being sold");
		
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
		
		usernameLbl.setVisible(true);
		passLbl.setVisible(true);
		
		frame.pack();
		frame.setVisible(true);
		panel.repaint();
		frame.repaint();
	}
	
	//do these two methods really need the argument??V^
	public void sellerPage(Seller sell){
		
		user = sell;
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
		//panel.add(inventoryDisplay);
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
	
	public boolean createAccount(){
		JOptionPane popup = new JOptionPane();
		int largestID = 0; //nobody will have a negative ID
		
		if(username.getText() == null || ! (username.getText().contains("@") && username.getText().contains(".")) && pass.getText() == null){
			
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
		//int response = 
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
	
	public void loadSellerInventory() {
		if(user == null || !(user instanceof Seller)){
			JOptionPane popup = new JOptionPane("Invalid User");
    		popup.showMessageDialog(frame, "Must be logged in as a seller to do that.");
    		return;
		}
		else{
			
			this.sellerPage((Seller) user);
			
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
				quantity = Integer.parseInt((String)JOptionPane.showInputDialog(frame, "How many of this item would you like to add?", ""));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Invalid quantity");
				return;
			}
			
			for (Product p : user.getInventory()) {
				if(itemName.equals(p.getName())){
					item = p;
					break;
				}
					
			}
			
			((Seller) user).updateQuantity(item.getIDNumber(), item.getQuantity() + quantity);
			sellerPage((Seller) user);
		}
		
		
		
	}
	
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
		sellerPage((Seller) user);
	}
	
	public void loadItemsToBuy() {

		if(user == null || !(user instanceof Buyer)){
			JOptionPane.showMessageDialog(frame, "Must be logged in as a buyer to do that.");
    		return;
    		
		}
		
		String[] colNames = {"Name", "Price", "Quantity", "Decription"};
		
		String[][] items = new String[market.getInventory().size()][4];
		//the market doesn't load the inventory*************
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

	//needs to be testedVVVVVVVV*************
	public void loadPurchaseHistory() {

		if(user == null || !(user instanceof Buyer)){
			JOptionPane popup = new JOptionPane("Invalid User");
    		popup.showMessageDialog(frame, "Must be logged in as a buyer to do that.");
    		return;
		}
		else{
			
			this.buyerPage((Buyer) user);
			
			panel.remove(inventoryDisplay);
			
			String[] colNames = {"Name", "Price", "Quantity", "Decription"};
			String[][] items = new String[user.getInventory().size()][4];
			
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
	
	//*******^^^^^^^^^^^^^^^^^^^^^^^^^^*************
    private class UserListener implements ActionListener {

        Interface face;

        public UserListener(Interface face) {

            this.face = face;
            face.login.addActionListener(this);
            face.createAcc.addActionListener(this);
            face.yourInventory.addActionListener(this);
            face.existingItem.addActionListener(this);
            face.newItem.addActionListener(this);
            face.removeItem.addActionListener(this);
            face.purchaseHistory.addActionListener(this);
			face.shop.addActionListener(this);
			face.mCreate.addActionListener(this);
			face.mLogout.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
        	
            	if (e.getSource() == face.login) {
                	Person person = userLookup(username.getText(), pass.getText());
                	
                	if(person == null){
                		JOptionPane popup = new JOptionPane("Invalid login");
                		popup.showMessageDialog(face.frame, "Invalid Login Information");
                			
                	}
                	
                	else if(person instanceof Seller){
                		face.sellerPage((Seller) person);
                	}
                	
                	else if(person instanceof Buyer){
                		face.buyerPage((Buyer) person);
                	}
                	
                	face.user = person;
                }
            	else if(e.getSource() == face.createAcc){
            		face.createAccount();
            	}
            	else if(e.getSource() == face.mCreate){
            		face.loginPage();
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
            	
            	else if(e.getSource() == face.purchaseHistory){
            		face.loadPurchaseHistory();
            	}
            	
            	else if(e.getSource() == face.shop){
            		face.loadItemsToBuy();
            	}
            	
            	else if(e.getSource() == face.mCreate){
            		face.loginPage();
            	}
            	
            	else if(e.getSource() == face.mLogout){
            		System.exit(0);
            	}
           
        }

    }
	


}
