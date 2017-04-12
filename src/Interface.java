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
		
		frame = new JFrame("Roccozon"); //its a pun on amazon
		panel = new JPanel();
		
		navigate = new JMenu("Navigate");
		menuBar = new JMenuBar();
		
		menuBar.add(navigate);
		
		menuBar.setVisible(true);
		frame.setJMenuBar(menuBar);
		frame.add(menuBar);
		navigate = new JMenu();
		
		username = new JTextField();
		pass = new JPasswordField(); 
		login = new JButton("Login");
		createAcc = new JButton("Create Account");
		usernameLbl = new JLabel("Username: ");
		passLbl = new JLabel("Password: ");
		
		//frame.setLayout(null);
		//panel.setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		listen = new UserListener(this);
		
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
