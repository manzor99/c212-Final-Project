import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Interface {

	JFrame frame;
	JPanel panel;
	JTextField username;
	JPasswordField pass;
	JButton login;
	JButton createAcc;
	JLabel usernameLbl;
	JLabel passLbl;
	UserListener listen;
	
	JMenuBar menuBar;
	
	JMenu navigate;
		JMenuItem mLogin;
		JMenuItem mCreate;
		
	JMenu help;
	JMenu info;
	
	public Interface(){ //login page
		
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
		
		SpringLayout layout = new SpringLayout();
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
		usernameLbl = new JLabel("Username: ");
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
		
		
		
		listen = new UserListener(this);
		
		
		
		frame.add(panel);
		
		
		
		
		
		frame.setPreferredSize(new Dimension(800, 800));
		//frame.setSize(800, 800);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void loginPage(){}
	
	public void createAccPage(){}
	
	public void buyerPage(){}
	
	public void sellerPage(){}
	
	private class UserListener implements ActionListener{
		Interface face;
		
		public UserListener(Interface face){
			
			this.face = face;
			face.login.addActionListener(this);
			face.createAcc.addActionListener(this);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == face.login)
				System.out.println("login");
			else if(e.getSource() == face.createAcc)
				System.out.println("create");
		}

	}
	
	
}
