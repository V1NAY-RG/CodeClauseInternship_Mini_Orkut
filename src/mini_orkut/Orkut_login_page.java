package mini_orkut;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JFrame;

public class Orkut_login_page extends JFrame implements ActionListener {

	
	//This is completely The front-end code for Login Page
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("USER ID:");
	JLabel userPasswordLabel = new JLabel("PASSWORD:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	private final JLabel lblNewLabel_1 = new JLabel("");
	
	
	Orkut_login_page(HashMap<String,String> loginInfoOriginal){
		
		setTitle("CodeClause");
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		messageLabel.setText("Welcome to mini orkut");
		
		messageLabel.setBounds(100,264,250,35);
		messageLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLabel);
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.getContentPane().setBackground(new Color(196, 60, 185));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,386);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MINI ORKUT");
		lblNewLabel.setBounds(114, 24, 219, 35);
		lblNewLabel.setFont(new Font(null,Font.BOLD,35));
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setBounds(46, 11, 62, 67);
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/rsz_1rsz_orkut_logo_2.png")));
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successfull");
					frame.dispose();
					mini_orkut welcomePage = new mini_orkut(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText(" Username is not found");
			}
		
	}
	}
}
