package userproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Update1 extends JFrame {

	private JPanel contentPane;

	
	 public Update1() {
	 	setTitle("User List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 22, 83, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Select User:");
		lblNewLabel_1.setBounds(33, 81, 83, 24);
		contentPane.add(lblNewLabel_1);
		
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setBounds(169, 82, 156, 22);
		contentPane.add(comboBox);
		
		try {
			Connection conn=DatabaseConnection.initializeDatabase();
			String sql="select * from user";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				String name=rs.getString("user_name");
				comboBox.addItem(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JButton btnedit = new JButton("Edit");
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=(String)comboBox.getSelectedItem();
				UpdateDetail detail=new UpdateDetail(name);
				detail.setVisible(true);
			}
		});
		btnedit.setBounds(164, 175, 89, 23);
		contentPane.add(btnedit);
	}
}
