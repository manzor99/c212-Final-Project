import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	
	public Interface(){ //login page
		
		frame = new JFrame("Roccozon"); //its a pun on amazon
		panel = new JPanel();
		username = new JTextField();
		pass = new JPasswordField(); 
		login = new JButton("Login");
		createAcc = new JButton("Create Account");
		
		frame.setLayout(null);
		panel.setLayout(null);
		panel.setLocation(new Point(0, 0));
		panel.setToolTipText("panel");
		panel.setPreferredSize(new Dimension(800,800));
		panel.setSize(new Dimension(800,800));
		
		pass.setLocation(100, 40);
		username.setLocation(100, 0);
		username.setPreferredSize(new Dimension(100, 30));
		pass.setPreferredSize(new Dimension(100, 30));
		username.setSize(new Dimension(100, 30));
		pass.setSize(new Dimension(100, 30));
		
		
		panel.add(username);
		panel.add(pass);
		frame.add(panel);
		
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setSize(800, 800);
		
		frame.setVisible(true);
	}
	
	public void loginPage(){}
	
	public void createAccPage(){}
	
	public void buyerPage(){}
	
	public void sellerPage(){}
	
	
	public static void main(String[] args) {
		
		Interface face = new Interface();
		
	}
	
}
