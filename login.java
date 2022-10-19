package mysql;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginPage;
	private JTextField User;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLoginPage = new JTextField();
		txtLoginPage.setFont(new Font("Castellar", Font.BOLD, 18));
		txtLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginPage.setText("Login Page");
		txtLoginPage.setBounds(34, 38, 350, 42);
		contentPane.add(txtLoginPage);
		txtLoginPage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(44, 98, 72, 14);
		contentPane.add(lblNewLabel);
		
		User = new JTextField();
		User.setBounds(196, 95, 92, 20);
		contentPane.add(User);
		User.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(44, 152, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(196, 149, 92, 20);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnecion("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from tblogin where Username='"+user.getText()+"' and Password='"+pass.getText().toString+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Login Successfully...");
					else
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password...");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(171, 205, 89, 23);
		contentPane.add(btnNewButton);
	}
}
