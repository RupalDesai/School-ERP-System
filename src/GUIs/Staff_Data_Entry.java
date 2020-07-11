package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.Queries;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Staff_Data_Entry extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldContact;
	private JTextField textFieldEmailID;
	String staffType;
	String designation;

	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Data_Entry frame = new Staff_Data_Entry();
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
	public Staff_Data_Entry() {
		setTitle("Staff Data Entry");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1285, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		TitledBorder title,title1,title2;
		title = BorderFactory.createTitledBorder(blackline, "STAFF DETAILS:-");
		title1= BorderFactory.createTitledBorder(blackline,"PERSONAL DETAILS:-");
		title2= BorderFactory.createTitledBorder(blackline,"WORK DETAILS:-");
		contentPane.setLayout(null);
		
		final JPanel jp1 = new JPanel();
		jp1.setBounds(25, 83, 1201, 417);
		contentPane.add(jp1);
		jp1.setBorder(title);
		jp1.setLayout(null);
		
		final JPanel jp2 = new JPanel();
		jp2.setBounds(25, 36, 1138, 186);
		jp1.add(jp2);
		jp2.setBorder(title1);
		jp2.setLayout(null);
		
		JPanel jp3 = new JPanel();
		jp3.setBounds(35, 278, 1128, 96);
		jp1.add(jp3);
		jp3.setBorder(title2);
		jp3.setLayout(null);
		
		JLabel lblStaffId = new JLabel("Staff ID :- ");
		lblStaffId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStaffId.setBounds(814, 31, 92, 36);
		contentPane.add(lblStaffId);
		
		ArrayList<Integer> id=new Queries().getId_staff();
		final JComboBox comboBoxStaffID = new JComboBox(id.toArray());
		comboBoxStaffID.setFont(new Font("Times New Roman", Font.BOLD, 22));
		comboBoxStaffID.setEditable(true);
		comboBoxStaffID.setBounds(919, 36, 72, 26);
		contentPane.add(comboBoxStaffID);
		
		final JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textAreaAddress.setBounds(130, 70, 217, 100);
		jp2.add(textAreaAddress);
		
		final JComboBox comboDesig = new JComboBox();
		comboDesig.setFont(new Font("Times New Roman", Font.BOLD, 22));
		comboDesig.setEditable(true);
		comboDesig.setModel(new DefaultComboBoxModel(new String[] {"Assistant Teacher", "Associate Teacher", "Assistant Clerk", "Associate Clerk"}));
		comboDesig.setBounds(141, 38, 217, 26);
		jp3.add(comboDesig);
		
		ButtonGroup bg;
		
		final JRadioButton rdbtnTeaching = new JRadioButton("Teaching");
		rdbtnTeaching.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnTeaching.setBounds(559, 36, 118, 29);
		jp3.add(rdbtnTeaching);
		
		final JRadioButton rdbtnNonTeaching = new JRadioButton("Non - Teaching");
		rdbtnNonTeaching.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNonTeaching.setBounds(685, 36, 183, 29);
		jp3.add(rdbtnNonTeaching);
		
		bg=new ButtonGroup();
		bg.add(rdbtnTeaching);
		bg.add(rdbtnNonTeaching);
		
		JLabel lblQualification = new JLabel("Qualification :-");
		lblQualification.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQualification.setBounds(414, 103, 128, 20);
		jp2.add(lblQualification);
		
		final JTextArea textAreaQualification = new JTextArea();
		textAreaQualification.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textAreaQualification.setBounds(588, 109, 191, 61);
		jp2.add(textAreaQualification);
		
		
		
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					 CallableStatement stmt=con.prepareCall("{call search_staff(?,?,?,?,?,?,?,?)}");
					 
					 stmt.setString(1, comboBoxStaffID.getSelectedItem().toString());
					 
					 stmt.registerOutParameter(2, Types.VARCHAR);
					 stmt.registerOutParameter(3, Types.VARCHAR);
					 stmt.registerOutParameter(4, Types.VARCHAR);
					 stmt.registerOutParameter(5, Types.VARCHAR);
					 stmt.registerOutParameter(6, Types.VARCHAR);
					 stmt.registerOutParameter(7, Types.VARCHAR);
					 stmt.registerOutParameter(8, Types.VARCHAR);
					 
					 stmt.executeQuery();
					 
					 String staffname=stmt.getString(2);
					 textFieldName.setText(staffname);
					 
					 String staffAddress=stmt.getString(3);
					 textAreaAddress.setText(staffAddress);
					 
					 String staffContact=stmt.getString(4);
					 textFieldContact.setText(staffContact);
					 
					 String staffemail=stmt.getString(5);
					 textFieldEmailID.setText(staffemail);
					 
					 String staffDesig=stmt.getString(6);
					 comboDesig.setSelectedItem(staffDesig);
					 
					 String stType=stmt.getString(7);
					 if(stType=="Teaching")
					 {
						 rdbtnTeaching.setSelected(true);
					 }
					 else
					 {
						 rdbtnNonTeaching.setSelected(true);
					 }
					 
					 String staffQuali=stmt.getString(8);
					 textAreaQualification.setText(staffQuali);
					 
					 String message="Search Successful !!"+"\n\n"+"Name:\t\t"+staffname+"\n\n"+
							    "Residential Address:\t\t"+staffAddress+"\n\n"+
								"Contact Number:\t\t"+staffContact+"\n\n"+
							    "Email Address:\t\t"+staffemail+"\n\n"+
								"Designation:\t\t"+staffDesig+"\n\n"+
							    "Type:\t\t"+stType+"\n\n"+
								"Qualification:\t\t"+staffQuali;
						
					 JOptionPane.showMessageDialog(jp1, message);
					 
				}
				catch(Exception w)
				{
					JOptionPane.showMessageDialog(jp1, "Search Unsuccessful !!");
				}
			}
		});
		btnSearch.setBounds(1018, 24, 146, 51);
		contentPane.add(btnSearch);
		
		
		JLabel lblName = new JLabel("Name :-");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBounds(47, 31, 69, 20);
		jp2.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textFieldName.setBounds(130, 28, 217, 26);
		jp2.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :-");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddress.setBounds(15, 67, 101, 20);
		jp2.add(lblAddress);
		
		
		
		JLabel lblContact = new JLabel("Contact :-");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContact.setBounds(456, 31, 86, 20);
		jp2.add(lblContact);
		
		textFieldContact = new JTextField();
		textFieldContact.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textFieldContact.setBounds(588, 28, 185, 26);
		jp2.add(textFieldContact);
		textFieldContact.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID:-");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmailId.setBounds(456, 67, 88, 20);
		jp2.add(lblEmailId);
		
		textFieldEmailID = new JTextField();
		textFieldEmailID.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textFieldEmailID.setBounds(588, 67, 185, 26);
		jp2.add(textFieldEmailID);
		textFieldEmailID.setColumns(10);
		
		
		
		JLabel lblDesignation = new JLabel("Designation :-");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDesignation.setBounds(15, 36, 129, 20);
		jp3.add(lblDesignation);
		
		JLabel lblStaffType = new JLabel("Staff Type :-");
		lblStaffType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStaffType.setBounds(416, 40, 118, 20);
		jp3.add(lblStaffType);
		
		
		
		JPanel jp4 = new JPanel();
		jp4.setLayout(null);
		jp4.setBounds(36, 515, 1187, 85);
		contentPane.add(jp4);
		
		final JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(textFieldName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Name");
						textFieldName.requestFocus();
						return;
					}
					
					if(textAreaAddress.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Address");
						textAreaAddress.requestFocus();
						return;
					}
					
					if(textFieldContact.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Contact Number");
						textFieldContact.requestFocus();
						return;
					}
					
					if(textFieldEmailID.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Email Address !");
						textFieldEmailID.requestFocus();
						return;
					}
					
					if(textAreaQualification.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Qualification");
						textAreaQualification.requestFocus();
						return;
					}
					
					designation=(String) comboDesig.getSelectedItem();
					
					if(e.getSource()==btnAdd)
					{
						if(rdbtnTeaching.isSelected())
						{
							staffType="Teaching";
						}
						else
						{
							staffType="Non-Teaching";
						}
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					CallableStatement stmt=con.prepareCall("{call add_staff(?,?,?,?,?,?,?)}");
					stmt.setString(1, textFieldName.getText());
					stmt.setString(2, textAreaAddress.getText());
					stmt.setString(3, textFieldContact.getText());
					stmt.setString(4, textFieldEmailID.getText()) ;
					stmt.setString(5, designation);
					stmt.setString(6, staffType);
					stmt.setString(7, textAreaQualification.getText());
					
					String display="Name:\t"+textFieldName.getText()+"\n\n"+
						    "Residential Address:\t"+textAreaAddress.getText()+"\n\n"+
							"Contact Number:\t"+textFieldContact.getText()+"\n\n"+
						    "Email Address:\t"+textFieldEmailID.getText()+"\n\n"+
							"Designation:\t"+designation+"\n\n"+
						    "Type:\t"+staffType+"\n\n"+
							"Qualification:\t"+textAreaQualification.getText();
					
					stmt.executeQuery();			// Own Addition
					con.commit();
					con.close();
				JOptionPane.showMessageDialog(jp1, "Addition Successful!!"+"\n\n"+display);
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(jp1, "Addition Unsuccessful!!");
					ee.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(44, 16, 115, 54);
		jp4.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
					if(textFieldName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Name");
						textFieldName.requestFocus();
						return;
					}
					
					if(textAreaAddress.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Address");
						textAreaAddress.requestFocus();
						return;
					}
					
					if(textFieldContact.getText().toString().length()!=10)
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Contact Number");
						textFieldContact.requestFocus();
						return;
					}
					
					if(textFieldEmailID.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Email Address !");
						textFieldEmailID.requestFocus();
						return;
					}
					
					if(textAreaQualification.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Qualification");
						textAreaQualification.requestFocus();
						return;
					}
					
					designation=(String) comboDesig.getSelectedItem();
					
					if(e.getSource()==btnAdd)
					{
						if(rdbtnTeaching.isSelected())
						{
							staffType="Teaching";
						}
						else
						{
							staffType="Non-Teaching";
						}
					}
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					CallableStatement stmt=con.prepareCall("{call edit_staff(?,?,?,?,?,?,?,?)}");
					stmt.setInt(1, (Integer)comboBoxStaffID.getSelectedItem());
					stmt.setString(2, textFieldName.getText());
					stmt.setString(3, textAreaAddress.getText());
					stmt.setString(4, textFieldContact.getText());
					stmt.setString(5, textFieldEmailID.getText()) ;
					stmt.setString(6, designation);
					stmt.setString(7, staffType);
					stmt.setString(8, textAreaQualification.getText());
							
					stmt.executeQuery();			// Own Addition
					con.commit();
					con.close();
				JOptionPane.showMessageDialog(jp1, "Updation Successful!!");
					
				}
				catch(Exception wer)
				{
					wer.printStackTrace();
					JOptionPane.showMessageDialog(jp1, "Updation Unsuccessful!!");
				}
			}
		});
		btnEdit.setBounds(212, 16, 115, 54);
		jp4.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					 CallableStatement stmt=con.prepareCall("{call staff_delete(?)}");
					 
					 stmt.setInt(1, Integer.parseInt(comboBoxStaffID.getSelectedItem().toString()));
					 
					 stmt.executeQuery();
					 
					 con.close();
					 
					 JOptionPane.showMessageDialog(jp1, "Deletion Successful!!");
					
					 ArrayList<Integer> id=new Queries().getId_staff();
						final JComboBox comboBoxID=new JComboBox(id.toArray());
					
				}
				catch(Exception we)
				{
					we.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(384, 16, 133, 54);
		jp4.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			dispose();
			}
		});
		btnBack.setBounds(568, 16, 115, 54);
		jp4.add(btnBack);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Staff_Data_View view=new Staff_Data_View();
			}
		});
		btnView.setBounds(711, 17, 115, 53);
		jp4.add(btnView);
		
		JButton btnBkpView = new JButton("BKP View ");
		btnBkpView.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnBkpView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staff_Data_View_BKP sdvb=new staff_Data_View_BKP();
			}
		});
		btnBkpView.setBounds(867, 16, 155, 54);
		jp4.add(btnBkpView);
		
		JButton btnHistView = new JButton("Hist View");
		btnHistView.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnHistView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staff_Data_View_HIST sdvh=new staff_Data_View_HIST();
			}
		});
		btnHistView.setBounds(1045, 16, 127, 54);
		jp4.add(btnHistView);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldName.setText("");
				textAreaAddress.setText("");
				textFieldContact.setText("");
				textFieldEmailID.setText("");
				comboDesig.setSelectedItem("");
				rdbtnTeaching.setSelected(true);
				textAreaQualification.setText("");
				
			}
		});
		btnClear.setBounds(61, 24, 115, 42);
		contentPane.add(btnClear);
		
		
		
	}
}
