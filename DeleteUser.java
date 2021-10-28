package userproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteUser extends JFrame {

	private JPanel contentPane;

	
	public DeleteUser() {
		setTitle("Remove User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(157, 11, 96, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 73, 77, 27);
		contentPane.add(lblNewLabel_1);
		
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setBounds(155, 76, 155, 22);
		contentPane.add(comboBox);
		
		
		
		try {
			Connection con=DatabaseConnection.initializeDatabase();
			String sql="select * from user";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("user_name");
				comboBox.addItem(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=(String)comboBox.getSelectedItem();
			
			try {
				Connection con=DatabaseConnection.initializeDatabase();
				String sql="delete from user where user_name=?";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,name );
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null,"Successfully deleted");
			}catch(Exception exc){
				exc.printStackTrace();
				
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(164, 182, 89, 23);
		contentPane.add(btnNewButton);
			
	}
}
