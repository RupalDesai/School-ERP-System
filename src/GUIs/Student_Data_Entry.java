package GUIs;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.*;


import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Student_Data_Entry extends JFrame {
	private JTextField textFieldStudentName;
	private JTextField textFieldContactNumber;
	private JTextField textFieldParrentGaurdianName;
	private JTextField textFieldPContactNumber;
	private JTextField textFieldPMobileNumber;
	private JTextField textFieldPEmailID;
	String div;
	String s;
	Student_Data_Entry frame_student_data_entry;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
					Student_Data_Entry frame_student_data_entry = new Student_Data_Entry();
					frame_student_data_entry .setVisible(true);
	}*/

	/**
	 * Create the frame.
	 */
	public Student_Data_Entry() {
		
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setTitle("Student Data Entry");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1307, 750);
		getContentPane().setLayout(null);
		
		//Student ID Label
		JLabel lblSutdentId = new JLabel(" PID :- ");
		lblSutdentId.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSutdentId.setBounds(809, 31, 96, 36);
		getContentPane().add(lblSutdentId);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		TitledBorder title,title1,title2,title3;
		title = BorderFactory.createTitledBorder(blackline, "PERSONAL DETAILS:-");
		title1= BorderFactory.createTitledBorder(blackline,"STUDENT DETAILS:-");
		title2= BorderFactory.createTitledBorder(blackline,"PARENT DETAILS:-");
		title3= BorderFactory.createTitledBorder(blackline,"ADMISSION DETAILS:-");
		title.setTitleJustification(TitledBorder.CENTER);
		
		//Buttons JPanel jp3
		JPanel jp5 = new JPanel();
		jp5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jp5.setBounds(100, 578, 1151, 100);
		getContentPane().add(jp5);
		jp5.setLayout(null);
		
		final JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnAdd.setBounds(44, 16, 115, 54);
		jp5.add(btnAdd);
		
		final JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnEdit.setBounds(212, 16, 115, 54);
		jp5.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnDelete.setBounds(375, 16, 140, 54);
		jp5.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnBack.setBounds(568, 16, 115, 54);
		jp5.add(btnBack);
		
		JButton btnViewData = new JButton("View Data");
		btnViewData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnViewData.setBounds(709, 16, 155, 54);
		jp5.add(btnViewData);
		
		JButton btnViewBKP = new JButton("View Backup Data");
		btnViewBKP.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnViewBKP.setBounds(879, 16, 257, 54);
		jp5.add(btnViewBKP);
		
		//Personal Details JPanel jp1
		final JPanel jp1 = new JPanel();
		jp1.setBounds(15, 83, 1224, 361);
		getContentPane().add(jp1);
		jp1.setLayout(null);
		jp1.setBorder(title);
		
		//Student Details JPanel jp2
		final JPanel jp2 = new JPanel();
		jp2.setBounds(15, 30, 589, 315);
		jp1.add(jp2);
		jp2.setBorder(title1);
		jp2.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name :- ");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblStudentName.setBounds(35, 34, 194, 20);
		jp2.add(lblStudentName);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textFieldStudentName.setBounds(244, 31, 228, 26);
		jp2.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		JLabel lblResidentialAddress = new JLabel("Residential Address :-");
		lblResidentialAddress.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblResidentialAddress.setBounds(15, 92, 228, 20);
		jp2.add(lblResidentialAddress);
		
		JLabel lblContactNumber = new JLabel("Contact Number:-");
		lblContactNumber.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblContactNumber.setBounds(15, 214, 234, 20);
		jp2.add(lblContactNumber);
		
		textFieldContactNumber = new JTextField();
		textFieldContactNumber.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textFieldContactNumber.setToolTipText("");
		textFieldContactNumber.setBounds(244, 211, 228, 26);
		jp2.add(textFieldContactNumber);
		textFieldContactNumber.setColumns(10);
		
		final JTextArea textAreaResidentailAddress = new JTextArea();
		textAreaResidentailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textAreaResidentailAddress.setBounds(244, 92, 228, 103);
		jp2.add(textAreaResidentailAddress);
		
		final JPanel jp3 = new JPanel();
		jp3.setBounds(614, 30, 560, 315);
		jp1.add(jp3);
		jp3.setBorder(title2);
		jp3.setLayout(null);
		
		JLabel lblParentgaudianName = new JLabel("Parent/Guardian Name:-");
		lblParentgaudianName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblParentgaudianName.setBounds(15, 34, 257, 20);
		jp3.add(lblParentgaudianName);
		
		textFieldParrentGaurdianName = new JTextField();
		textFieldParrentGaurdianName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textFieldParrentGaurdianName.setBounds(287, 31, 225, 26);
		jp3.add(textFieldParrentGaurdianName);
		textFieldParrentGaurdianName.setColumns(10);
		
		JLabel lblOfficeAddress = new JLabel("Office Address:- ");
		lblOfficeAddress.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblOfficeAddress.setBounds(70, 83, 179, 20);
		jp3.add(lblOfficeAddress);
		
		JLabel lblContactNumber_1 = new JLabel("Contact Number:-");
		lblContactNumber_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblContactNumber_1.setBounds(62, 199, 187, 20);
		jp3.add(lblContactNumber_1);
		
		textFieldPContactNumber = new JTextField();
		textFieldPContactNumber.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textFieldPContactNumber.setBounds(287, 196, 225, 26);
		jp3.add(textFieldPContactNumber);
		textFieldPContactNumber.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:-");
		lblMobileNumber.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblMobileNumber.setBounds(70, 235, 179, 20);
		jp3.add(lblMobileNumber);
		
		textFieldPMobileNumber = new JTextField();
		textFieldPMobileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textFieldPMobileNumber.setBounds(287, 232, 225, 26);
		jp3.add(textFieldPMobileNumber);
		textFieldPMobileNumber.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID:-");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblEmailId.setBounds(129, 271, 120, 20);
		jp3.add(lblEmailId);
		
		textFieldPEmailID = new JTextField();
		textFieldPEmailID.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textFieldPEmailID.setBounds(287, 268, 225, 26);
		jp3.add(textFieldPEmailID);
		textFieldPEmailID.setColumns(10);
		
		final JTextArea textAreaOficeAddress = new JTextArea();
		textAreaOficeAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textAreaOficeAddress.setBounds(287, 83, 225, 97);
		jp3.add(textAreaOficeAddress);
		
		//Search Button
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnSearch.setBounds(1084, 16, 139, 51);
		getContentPane().add(btnSearch);
		
		JPanel jp4 = new JPanel();
		jp4.setBounds(50, 449, 1189, 113);
		getContentPane().add(jp4);
		jp4.setBorder(title3);
		jp4.setLayout(null);
		
		JLabel lblStandard = new JLabel("Standard:- ");
		lblStandard.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblStandard.setBounds(15, 37, 132, 20);
		jp4.add(lblStandard);
		
		final JComboBox comboBoxStandard = new JComboBox();
		comboBoxStandard.setFont(new Font("Times New Roman", Font.BOLD, 24));
		comboBoxStandard.setMaximumRowCount(5);
		comboBoxStandard.setEditable(true);
		comboBoxStandard.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxStandard.setSelectedIndex(0);
		comboBoxStandard.setBounds(171, 34, 93, 26);
		jp4.add(comboBoxStandard);
		
		JLabel lblDivision = new JLabel("Division :-");
		lblDivision.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblDivision.setBounds(360, 37, 105, 20);
		jp4.add(lblDivision);
		
		ButtonGroup bg;
		
		final JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setFont(new Font("Times New Roman", Font.BOLD, 24));
		rdbtnA.setBounds(483, 33, 52, 29);
		jp4.add(rdbtnA);
		
		final JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setFont(new Font("Times New Roman", Font.BOLD, 24));
		rdbtnB.setBounds(542, 33, 52, 29);
		rdbtnB.setSelected(true);
		jp4.add(rdbtnB);
		
		bg=new ButtonGroup();
		bg.add(rdbtnA);
		bg.add(rdbtnB);
		
		JButton btnClear = new JButton("Clear Data");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnClear.setBounds(52, 16, 160, 41);
		getContentPane().add(btnClear);
		
		ArrayList<Integer> id=new Queries().getId();
		final JComboBox comboBoxID=new JComboBox(id.toArray());
		comboBoxID.setFont(new Font("Times New Roman", Font.BOLD, 24));
		comboBoxID.setEditable(true);
		comboBoxID.setBounds(920, 36, 107, 26);
		getContentPane().add(comboBoxID);
		
		
		
		// Event Handling 
		
		btnBack.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			dispose();
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				Queries q=new Queries();
				
				try
				{
					if(textFieldStudentName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Name");
						textFieldStudentName.requestFocus();
						return;
					}
				
					if(textAreaResidentailAddress.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Residential Address !");
						textAreaResidentailAddress.requestFocus();
						return;
					}
				
					if(textFieldContactNumber.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Contact Number");
						textFieldContactNumber.requestFocus();
						return;
					}
				
					if(textFieldParrentGaurdianName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Parent Name");
						textFieldParrentGaurdianName.requestFocus();
						return;
					}
				
					if(textAreaOficeAddress.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Office Address");
						textAreaOficeAddress.requestFocus();
						return;
					}
					
					if(textFieldPContactNumber.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Contact Number");
						textFieldPContactNumber.requestFocus();
						return;
					}
				
					if(textFieldPMobileNumber.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Mobile Number");
						textFieldPMobileNumber.requestFocus();
						return;
					}
				
					if(textFieldPEmailID.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Email Address !");
						textFieldPEmailID.requestFocus();
						return;
					}
					
					/*String email=textFieldPEmailID.getText().toString();
					boolean status=false;
					
					for(int i=0;i<=email.length();i++)
					{
						if(email.charAt(i)=='@')
						{
							status=true;
						}
					}
					
					if(status!=true)
					{
						JOptionPane.showMessageDialog(jp3, "Email Address Must Contain @ !");
						textFieldPEmailID.requestFocus();
						return;
					}*/
		
			
					s=(String) comboBoxStandard.getSelectedItem();
				
					if(e.getSource()==btnAdd)
					{
						if(rdbtnA.isSelected())
						{
						 div="A";
						}
						else
						{
							div="B";
						}
					}
				
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					CallableStatement stmt=con.prepareCall("{call add_proc(?,?,?,?,?,?,?,?,?,?)}");
					stmt.setString(1, textFieldStudentName.getText());
					stmt.setString(2, textAreaResidentailAddress.getText());
					stmt.setString(3,textFieldContactNumber.getText());
					stmt.setString(4,s) ;
					stmt.setString(5, div);
					stmt.setString(6, textFieldParrentGaurdianName.getText());
					stmt.setString(7, textFieldPContactNumber.getText());
					stmt.setString(8, textAreaOficeAddress.getText());
					stmt.setString(9,textFieldPMobileNumber.getText());
					stmt.setString(10,textFieldPEmailID.getText());
					
					String display="Name:\t"+textFieldStudentName.getText()+"\n\n"+
								    "Residential Address:\t"+textAreaResidentailAddress.getText()+"\n\n"+
									"Contact Number:\t"+textFieldContactNumber.getText()+"\n\n"+
								    "Standard:\t"+s+"\n\n"+
									"Division:\t"+div+"\n\n"+
								    "Parent Name:\t"+textFieldParrentGaurdianName.getText()+"\n\n"+
									"Parent Contact:\t"+textFieldParrentGaurdianName.getText()+"\n\n"+
								    "Office Address:\t"+textAreaOficeAddress.getText()+"\n\n"+
									"Mobile Address:t"+textFieldPMobileNumber.getText()+"\n\n"+
								    "Email Address:\t"+textFieldPEmailID.getText();
					
					stmt.executeQuery();			// Own Addition
					con.close();
				JOptionPane.showMessageDialog(jp1, "Addition Successful!!"+"\n\n"+display);
				}
				catch(Exception w)
				{
					JOptionPane.showMessageDialog(jp1, "Addition Unsuccessful!!");
					w.printStackTrace();
				}
			}
		});
		
		
		btnViewData.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				StudentDataView d1=new StudentDataView();

			}
		});
		
		btnViewBKP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				StudentDataViewBKP d1=new StudentDataViewBKP();

			}
		});

		
		
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					 CallableStatement stmt=con.prepareCall("{call search_proc(?,?,?,?,?,?,?,?,?,?,?)}");
					 
					 stmt.setString(1, comboBoxID.getSelectedItem().toString());
					 
					 stmt.registerOutParameter(2, Types.VARCHAR);
					 stmt.registerOutParameter(3, Types.VARCHAR);
					 stmt.registerOutParameter(4, Types.VARCHAR);
					 stmt.registerOutParameter(5, Types.VARCHAR);
					 stmt.registerOutParameter(6, Types.VARCHAR);
					 stmt.registerOutParameter(7, Types.VARCHAR);
					 stmt.registerOutParameter(8, Types.VARCHAR);
					 stmt.registerOutParameter(9, Types.VARCHAR);
					 stmt.registerOutParameter(10, Types.VARCHAR);
					 stmt.registerOutParameter(11, Types.VARCHAR);
					 
					 stmt.executeQuery();
					 
					 String studname=stmt.getString(2);
					 textFieldStudentName.setText(studname);
					 
					 
					 String studAddress=stmt.getString(3);
					 textAreaResidentailAddress.setText(studAddress);
					 
					 
					 String studContact=stmt.getString(4);
					 textFieldContactNumber.setText(studContact);
					 
					 
					 String standid=stmt.getString(5);
					 comboBoxStandard.setSelectedItem(standid);
					 
					 
					 
					 String studdiv=stmt.getString(6);
					 if(studdiv.equals("A"))
					 {
						 rdbtnA.setSelected(true);
					 }
					 else
					 {
						 rdbtnB.setSelected(true);
					 }
					 
					 
					 
					 String parentname=stmt.getString(7);
					 textFieldParrentGaurdianName.setText(parentname);
					 
					 
					 String pcontact=stmt.getString(8);
					 textFieldPContactNumber.setText(pcontact);
					 
					 
					 String officeAdd=stmt.getString(9);
					 textAreaOficeAddress.setText(officeAdd);
					 
					 
					 String pmobile=stmt.getString(10);
					 textFieldPMobileNumber.setText(pmobile);
					 
					 
					 String pemail=stmt.getString(11);
					 textFieldPEmailID.setText(pemail); 
					 
					String messageshow= "Student Name:"+studname+"\n"
					+"Address:"+studAddress+"\n"+"Contact:"+studContact+"\n"
					+"Standard:"+standid+"\n"+"Division:"+studdiv+"\n"
					+"Parent Name:"+parentname+"\n"+"Parent Contact:"+pcontact+"\n"
					+"Office Address:"+officeAdd+"\n"+"Parent Mobile:"+pmobile+"\n"
					+"Parent Email:"+pemail;
					
					
					JOptionPane.showMessageDialog(jp1, messageshow);
					
					
				}
				catch(Exception w)
				{
					JOptionPane.showMessageDialog(jp1, "Search Unsuccessful!!");
				}
				
							
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					/*if(textField.getText().toString().equals(""))
					{
						JOptionPane.showMessageDialog(jp1, "Invalid ID!!");
						return;
						
					}*/
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					 CallableStatement stmt=con.prepareCall("{call delete_proc(?)}");
					 
					 stmt.setInt(1, Integer.parseInt(comboBoxID.getSelectedItem().toString()));
					 
					 stmt.executeQuery();
					 
					 con.close();
					 
					 JOptionPane.showMessageDialog(jp1, "Deletion Successful!!");
					 
					 ArrayList<Integer> id=new Queries().getId();
						final JComboBox comboBoxID=new JComboBox(id.toArray());
						
				}
				catch(Exception a)
				{
					a.printStackTrace();
				}
				
			}
		});
		
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				textFieldStudentName.setText("");
				textAreaResidentailAddress.setText("");
				textFieldContactNumber.setText("");
				rdbtnB.setSelected(true);
				comboBoxStandard.setSelectedItem("1");
				textFieldParrentGaurdianName.setText("");
				textFieldPContactNumber.setText("");
				textAreaOficeAddress.setText("");
				textFieldPMobileNumber.setText("");
				textFieldPEmailID.setText("");
			}
		});	
		
		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(textFieldStudentName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Name");
						textFieldStudentName.requestFocus();
						return;
					}
				
					if(textAreaResidentailAddress.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Residential Address !");
						textAreaResidentailAddress.requestFocus();
						return;
					}
				
					if(textFieldContactNumber.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp2, "Invalid Contact Number");
						textFieldContactNumber.requestFocus();
						return;
					}
				
					if(textFieldParrentGaurdianName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Parent Name");
						textFieldParrentGaurdianName.requestFocus();
						return;
					}
				
					if(textAreaOficeAddress.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Office Address");
						textAreaOficeAddress.requestFocus();
						return;
					}
					
					if(textFieldPContactNumber.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Contact Number");
						textFieldPContactNumber.requestFocus();
						return;
					}
				
					if(textFieldPMobileNumber.getText().toString().length()<10)
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Mobile Number");
						textFieldPMobileNumber.requestFocus();
						return;
					}
				
					if(textFieldPEmailID.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jp3, "Invalid Email Address !!");
					}
		
			
					s=(String) comboBoxStandard.getSelectedItem();
				
					if(e.getSource()==btnEdit)
					{
						if(rdbtnA.isSelected())
						{
						 div="A";
						}
						else
						{
							div="B";
						}
					}
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					 CallableStatement stmt=con.prepareCall("{call edit_proc(?,?,?,?,?,?,?,?,?,?,?)}");
					 
					 	stmt.setString(1, comboBoxID.getSelectedItem().toString());
					 	stmt.setString(2, textFieldStudentName.getText());
						stmt.setString(3, textAreaResidentailAddress.getText());
						stmt.setString(4,textFieldContactNumber.getText());
						stmt.setString(5,s) ;
						stmt.setString(6, div);
						stmt.setString(7, textFieldParrentGaurdianName.getText());
						stmt.setString(8, textFieldPContactNumber.getText());
						stmt.setString(9, textAreaOficeAddress.getText());
						stmt.setString(10,textFieldPMobileNumber.getText());
						stmt.setString(11,textFieldPEmailID.getText());
				
						
						stmt.executeQuery();
						con.commit();
						
						JOptionPane.showMessageDialog(jp1, "Updation Successful!!");	
				}
				catch(Exception c)
				{
					c.printStackTrace();
				}

			}
		});
	}
}