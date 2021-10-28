package userproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDetail extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	
	public UpdateDetail(String name) {
		setTitle("Detail Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Information");
		lblNewLabel.setBounds(165, 11, 95, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(31, 62, 88, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(31, 107, 88, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setBounds(29, 153, 90, 23);
		contentPane.add(lblNewLabel_3);
		
		txt1 = new JTextField();
		txt1.setBounds(127, 63, 160, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(129, 108, 158, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(129, 154, 158, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txt1.getText();
				String address=txt2.getText();
				String phone=txt3.getText();
				
				try {
					Connection con=DatabaseConnection.initializeDatabase();
					String sql="Update user set user_name=?,address=?,phone=? where user_name=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, username);
					stmt.setString(2, address);
					stmt.setString(3,phone);
					stmt.setString(4,name);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Updated");
				}catch (Exception exc) {
					exc.printStackTrace();
				}
				}
		});
		btnUpdate.setBounds(142, 210, 101, 23);
		contentPane.add(btnUpdate);
		
		try {
			Connection con=DatabaseConnection.initializeDatabase();
			String sql="select * from user where user_name=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()) {
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				txt1.setText(name);
				txt2.setText(address);
				txt3.setText(phone);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
