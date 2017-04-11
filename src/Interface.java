import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	
	public Interface(){ //login page
		
		listen = new UserListener();
		frame = new JFrame("Roccozon"); //its a pun on amazon
		panel = new JPanel();
		username = new JTextField();
		pass = new JPasswordField(); 
		login = new JButton("Login");
		createAcc = new JButton("Create Account");
		usernameLbl = new JLabel("Username: ");
		passLbl = new JLabel("Password: ");
		
		//frame.setLayout(null);
		//panel.setLayout(null);
		panel.setLocation(new Point(0, 0));
		panel.setPreferredSize(new Dimension(800,800));
		panel.setSize(new Dimension(800,800));
		
		pass.setLocation(100, 40);
		username.setLocation(100, 0);
		//passLbl.setLocation(0, 40);
		//usernameLbl.setLocation(0, 0);
		username.setPreferredSize(new Dimension(100, 30)); //rearrange to look nicer
		pass.setPreferredSize(new Dimension(100, 30));
		username.setSize(new Dimension(100, 30));
		pass.setSize(new Dimension(100, 30));
		//passLbl.setLocation(new Point(100, 100));
		//usernameLbl.setLocation(new Point(0, 0));
		passLbl.setPreferredSize(new Dimension(100, 30));
		usernameLbl.setPreferredSize(new Dimension(100, 30));
		
		
		
		panel.add(username);
		panel.add(pass);
		panel.add(passLbl);
		panel.add(usernameLbl);
		panel.add(login);
		panel.add(createAcc);
		frame.add(panel);
		
		//panel.validate(); //use when changing the frame
		//panel.repaint();
		
		
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setSize(800, 800);
		
		frame.setVisible(true);
	}
	
	public void loginPage(){}
	
	public void createAccPage(){}
	
	public void buyerPage(){}
	
	public void sellerPage(){}
	
	
	
	
}
