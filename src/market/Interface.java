package market;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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

    JMenu navigate;
    JMenuItem mLogin;
    JMenuItem mCreate;

    JMenu help;
    JMenu info;

    public Interface() { //login page

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
		
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
				//https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
				
				layout = new SpringLayout();
				panel = new JPanel();
				//frame
				frame = new JFrame("Roccozon"); //its a pun on amazon
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//end frame
				
				//menuBar
				navigate = new JMenu("Navigate");
				menuBar = new JMenuBar();
				
				menuBar.add(navigate);
				
				menuBar.setVisible(true);
				frame.setJMenuBar(menuBar);
				frame.add(menuBar);
				navigate = new JMenu();
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
	
	public void createAccPage(){}
	
	public void buyerPage(Buyer buy){
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
	

    private class UserListener implements ActionListener {

        Interface face;

        public UserListener(Interface face) {

            this.face = face;
            face.login.addActionListener(this);
            face.createAcc.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == face.login) {
                System.out.println("login");
            } else if (e.getSource() == face.createAcc) {
                System.out.println("create");
            }
        }

    }
}
