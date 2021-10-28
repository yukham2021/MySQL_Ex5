package userproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JPasswordField pwd;

	
	public AddUser() {
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(147, 11, 115, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setBounds(28, 62, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setBounds(28, 98, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Address");
		lblNewLabel_3.setBounds(28, 135, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Phone");
		lblNewLabel_4.setBounds(28, 170, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		txt1 = new JTextField();
		txt1.setBounds(147, 59, 161, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(147, 132, 161, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(147, 167, 161, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(147, 95, 161, 20);
		contentPane.add(pwd);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txt1.getText();
				String password=String.valueOf(pwd.getPassword());
				String phone=txt3.getText();
				String address=txt2.getText();
				
				try {
					Connection con=DatabaseConnection.initializeDatabase();
					String sql="insert into user(user_name,password,address,phone)values(?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1,name);
					stmt.setString(2,password);
					stmt.setString(3,address);
					stmt.setString(4, phone);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Registered");
					txt1.setText("");
					txt2.setText("");
					pwd.setText("");
					txt3.setText("");
				}catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(147, 216, 109, 23);
		contentPane.add(btnRegister);
	}}

