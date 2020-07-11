package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBackground(new Color(102, 102, 102));
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblLogin.setBounds(359, 0, 127, 71);
		contentPane.add(lblLogin);
		
		JPanel jpLogin = new JPanel();
		jpLogin.setBackground(new Color(152, 251, 152));
		jpLogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jpLogin.setBounds(481, 74, 341, 326);
		contentPane.add(jpLogin);
		jpLogin.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :- ");
		lblUsername.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblUsername.setBounds(32, 70, 121, 46);
		jpLogin.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :- ");
		lblPassword.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblPassword.setBounds(32, 152, 121, 46);
		jpLogin.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(161, 81, 146, 26);
		jpLogin.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText().toString();
				String password=passwordField.getText().toString();
				
				if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123"))
				{
					dispose();
					
					HomePage hp1=new HomePage();
					hp1.setVisible(true);
					
					//Student_Data_Entry frame_student_data_entry=new Student_Data_Entry();
					//frame_student_data_entry.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Access Denied!!");
				}
			}
		});
		btnSubmit.setBounds(95, 240, 146, 51);
		jpLogin.add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 164, 146, 26);
		jpLogin.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Anup Mulay\\Desktop\\login.jpg"));
		label.setBounds(97, 134, 236, 255);
		contentPane.add(label);
	}
}
