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
    JMenuItem mLogin;
    JMenuItem mCreate;

    Person user; //user that is currently logged in
    String page; //login buyer seller or admin
    
    public Interface() { //login page
    	
    	layout = new SpringLayout();
		panel = new JPanel();
		//frame
		frame = new JFrame("Roccozon"); //its a pun on amazon
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
		mLogin = new JMenuItem("login");
		mCreate = new JMenuItem("Create Account");
		
		
		menuBar.add(navigate);
		//menuBar.add(help);
		//menuBar.add(info);
		menuBar.add(this.buyers);
		menuBar.add(this.sellers);
		
		navigate.add(mLogin);
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
		
		page = "login";
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
				
		
		//end menuBar
			
		//username
		username = new JTextField();
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
		usernameLbl = new JLabel("Email: ");
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
		pass = new JPasswordField(); 
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
		passLbl = new JLabel("Password: ");
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
		login = new JButton("Login");
		login.setPreferredSize(new Dimension(75, 30));
				
		layout.putConstraint(SpringLayout.WEST, login,
		        250,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, login,
		        50,
		        SpringLayout.NORTH, panel);
		//end login
				
				
				
		//createAcc
		createAcc = new JButton("Create");
		
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
		
	}
	
	public void buyerPage(Buyer buy){
		page = "buyer";
		
		frame.setVisible(false);
		
		usernameLbl.setText("Welcome " + buy.getName() + "!");
		usernameLbl.setPreferredSize(new Dimension(200, 100));
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 24)); //might need to change font size *****
		
		inventoryDisplay = new JTable(50, 4);
		
		//panel
		layout.putConstraint(SpringLayout.WEST, inventoryDisplay,
		        220,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, inventoryDisplay,
		        160,
		        SpringLayout.NORTH, panel);
		
		panel.add(inventoryDisplay);
		//end panel
		
		//welcome lbl
		layout.putConstraint(SpringLayout.WEST, usernameLbl,
		        300,
		        SpringLayout.WEST, panel);
				
		layout.putConstraint(SpringLayout.NORTH, usernameLbl,
		        50,
		        SpringLayout.NORTH, panel);
		//end welcome
		

		//inventory label
		passLbl.setText("Inventory");
		
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 18)); //might need to change font size *****
		
		layout.putConstraint(SpringLayout.WEST, passLbl,
		        343,
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
		frame.setVisible(true);
	}
	
	public void sellerPage(Seller sell){
		page = "seller";
		
		frame.setVisible(false);
		
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
		
		usernameLbl.setText("Welcome " + sell.getName() + "!");
		usernameLbl.setPreferredSize(new Dimension(200, 100));
		usernameLbl.setFont(new Font(usernameLbl.getFont().getName(), Font.PLAIN, 24)); //might need to change font size *****
		
		//welcome lbl
		layout.putConstraint(SpringLayout.WEST, usernameLbl,
		        300,
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
		frame.setVisible(true);
	}
	
	public boolean createAccount(){
		JOptionPane popup = new JOptionPane();
		
		if(! (username.getText().contains("@") && username.getText().contains(".")) && ! pass.getText().equals("")){
			
			popup.showMessageDialog(frame, "Invalid email");
			return false;
		}
		
		for(Buyer buy : market.getBuyers()){
			if(buy.getEmail().equals(this.username.getText())){
				popup.showMessageDialog(frame, "Email already registered");
				return false;
			}
		}
		
		for(Seller seller : market.getSellers()){
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
			user = new Seller(5, name, username.getText(),  pass.getText(), new ArrayList<Product>());
			
		}
		else{
			user = new Buyer(5, name, username.getText(),  pass.getText(), new ArrayList<Product>());
			
		}
				
		market.addPerson(user);
		
		return true;
	}

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
			face.mLogin.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
        	
            if(face.page.equals("login")){
            	
            	
            	if (e.getSource() == face.login || e.getSource() == face.mLogin) {
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
                	
                	else
                		System.out.println("its not a person or a buyer.....");//this shouldnt happen remove after bug testing
                	
                	face.user = person;
                }
            	
            	else if(e.getSource() == face.createAcc || e.getSource() == face.mCreate){
            		face.createAccount();
            	}
            
            }
            else if(page.equals("buyer")){}
            	
            else if(page.equals("seller")){}
            	            	
            else
            	System.out.println("error");//this should never occur remove after testing
             
            
        }

    }
    

}
