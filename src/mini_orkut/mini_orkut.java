package mini_orkut;

import java.awt.EventQueue;
import java.sql.*;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mini_orkut {
	//Main Page of MINI ORKUT
	private JFrame frame;

	JFrame frame_1 = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTable table;
	
Connection con;
PreparedStatement pst;
ResultSet rs;
private JTextField textField_4;


	public void Connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//Registerring the jdbc
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/orkut","root","");
		}
		catch (ClassNotFoundException ex)
		{
		}
		catch (SQLException ex)
		{
			
		}
	}
	
	public void table_load()
	{
		//This Method is used to Print the List of Friends in the table
		try
		{
			pst = con.prepareStatement("select * from friends");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	mini_orkut(String userID){
		
		welcomeLabel.setBounds(355,19,507,35);
		welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		welcomeLabel.setText("Welcome To Mini Orkut "+userID);
		
		frame_1.getContentPane().add(welcomeLabel);
		frame_1.getContentPane().setForeground(new Color(196, 60, 185));
		frame_1.getContentPane().setBackground(new Color(196, 60, 185));
		frame_1.setBackground(new Color(196, 60, 185));
		frame_1.setForeground(new Color(196, 60, 185));
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.setSize(1161, 696);
		frame_1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(282, 11, 52, 54);
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/rsz_1rsz_orkut_logo_2.png")));
		frame_1.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enter/View Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(196, 60, 185)));
		panel.setBounds(43, 182, 379, 379);
		frame_1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(25, 31, 64, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(25, 121, 86, 29);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Intrests:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_2.setBounds(25, 207, 86, 29);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Hobbies:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_3.setBounds(25, 286, 86, 29);
		panel.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(118, 38, 231, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(118, 293, 231, 20);
		panel.add(textField_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(121, 102, 228, 78);
		panel.add(textArea);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(118, 214, 231, 20);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			// This Action is used to insert new Details to the database
			public void actionPerformed(ActionEvent e) {
				String name,intrests,address,hobbies;
				name = textField.getText();
				address = textArea.getText();
				intrests = textField_4.getText();
				hobbies = textField_1.getText();
					try {
						pst = con.prepareStatement("insert into friends(name,address,intrests,hobbies)values(?,?,?,?)");
						pst.setString(1,name);
						pst.setString(2, address);
						pst.setString(3, intrests);
						pst.setString(4, hobbies);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Information Added");
						table_load();
						textField.setText("");
						textArea.setText("");
						textField_4.setText("");
						textField_1.setText("");
						textField.requestFocus();
					}
				catch (SQLException el){
					el.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(43, 572, 89, 35);
		frame_1.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This Clears the value from the field's
				textField.setText("");
				textArea.setText("");
				textField_4.setText("");
				textField_1.setText("");
				textField.requestFocus();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(159, 572, 89, 35);
		frame_1.getContentPane().add(btnClear);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Search User:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_3_1_1.setBounds(43, 88, 117, 29);
		frame_1.getContentPane().add(lblNewLabel_1_3_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 88, 840, 35);
		frame_1.getContentPane().add(textField_3);
		
		JScrollPane table_1 = new JScrollPane();
		table_1.setBounds(490, 182, 629, 379);
		frame_1.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This Action Updates the Value from existing friends
				String name,address,intrests,hobbies,uid;
				name = textField.getText();
				address = textArea.getText();
				intrests = textField_4.getText();
				hobbies = textField_1.getText();
				uid = textField_3.getText();
					try {
						
						pst = con.prepareStatement("update friends set name =?,address =?,intrests =?,hobbies =? where id =?");
						pst.setString(1,name);
						pst.setString(2,address);
						pst.setString(3,intrests);
						pst.setString(4,hobbies);
						pst.setString(5,uid);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Changes Updated");
						table_load();
						textField.setText("");
						textArea.setText("");
						textField_4.setText("");
						textField_1.setText("");
						textField.requestFocus();
					}
				catch (SQLException el){
					el.printStackTrace();
					
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(492, 572, 89, 35);
		frame_1.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This Action remove the Friend from your list
				String uid;
				uid = textField_3.getText();
				try {
					pst = con.prepareStatement("delete from friends where id  =?");
					pst.setString(1,uid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Connection Removed");
					table_load();
					textField.setText("");
					textArea.setText("");
					textField_4.setText("");
					textField_1.setText("");
					textField.requestFocus();
				}
			catch (SQLException el){
				el.printStackTrace();
				
			}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(617, 572, 89, 35);
		frame_1.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit's from mini orkut
				JOptionPane.showMessageDialog(null,"Thanks for using mini orkut");
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(1027, 572, 89, 35);
		frame_1.getContentPane().add(btnExit);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This action searches for a friend
				try
				 {
					 String id = textField_3.getText();
					 pst = con.prepareStatement("select name,address,intrests,hobbies from friends where id = ?");
					 pst.setString(1, id);
					 ResultSet rs = pst.executeQuery();
					 if(rs.next()==true)
					 {
						 String name = rs.getString(1);
						 String address = rs.getString(2);
						 String intrests = rs.getString(3);
						 String hobbies = rs.getString(4);
						 
						 textField.setText(name);
						 textArea.setText(address);
						 textField_4.setText(intrests);
						 textField_1.setText(hobbies);
					 }
					 else
					 {
						 textField.setText("");
						 textArea.setText("");
						 textField_4.setText("");
						 textField_1.setText("");
						 
			}
				 }
				 catch (SQLException ex) {
					 
				 }
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(1013, 88, 89, 33);
		frame_1.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Connections");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_1_1.setBounds(776, 142, 117, 29);
		frame_1.getContentPane().add(lblNewLabel_1_1_1);
		frame_1.setVisible(true);
		initialize();
		Connect();
		table_load();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1244, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
