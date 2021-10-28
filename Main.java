package userproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("\t\t\t\t\t\t\tUser Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Phone", "Address", "Name"
			}
		));
		
		
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update1 update=new Update1();
				update.setVisible(true);
				
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\SAW THET NAING OO\\Downloads\\avatar.png"));
		btnNewButton_2.setBounds(10, 178, 118, 23);
		contentPane.add(btnNewButton_2);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 58, 260, 194);
		contentPane.add(scrollPane);
		
		
		
		JButton btnNewButton_4 = new JButton("View User");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DatabaseConnection.initializeDatabase();
					String sql="select * from user";
					PreparedStatement stmt=con.prepareStatement(sql);
					ResultSet rs=stmt.executeQuery();
					
					while (rs.next()) {
						String name=rs.getString("user_name");
						String phone=rs.getString("phone");
						String address=rs.getString("address");
						((DefaultTableModel)table.getModel()).addRow(new Object[] {name,phone,address});
					}
				con.close();	
				}catch (Exception exc) {
					exc.printStackTrace();
				}	
			}
		});
		scrollPane.setViewportView(table);
btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\SAW THET NAING OO\\Downloads\\avatar.png"));
btnNewButton_4.setBounds(10, 81, 118, 23);
contentPane.add(btnNewButton_4);

JButton btnNewButton = new JButton("Add User");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		AddUser user=new AddUser();
		user.setVisible(true);
	}
});
btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
btnNewButton.setIcon(new ImageIcon("C:\\Users\\SAW THET NAING OO\\Downloads\\avatar.png"));
btnNewButton.setBounds(10, 133, 118, 23);
contentPane.add(btnNewButton);


JButton btnNewButton_3 = new JButton("Remove User");
btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		DeleteUser delete=new DeleteUser();
		delete.setVisible(true);}
});

btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\SAW THET NAING OO\\Downloads\\avatar.png"));
btnNewButton_3.setBounds(10, 229, 118, 23);
contentPane.add(btnNewButton_3);}}
			
		
	

