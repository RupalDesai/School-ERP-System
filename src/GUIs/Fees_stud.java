package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.Queries;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Fees_stud extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_amt;
	private JTextField textField_pay_date;
	String s1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fees_stud frame = new Fees_stud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Fees_stud() {
		setTitle("Fees Module");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel jpFees = new JPanel();
		jpFees.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Fees Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpFees.setBounds(97, 37, 728, 206);
		contentPane.add(jpFees);
		jpFees.setLayout(null);
		ArrayList<Integer> id1=new Queries().getId_fees();
		final JComboBox comboBox_id = new JComboBox(id1.toArray());
		comboBox_id.setFont(new Font("Times New Roman", Font.BOLD, 22));
		comboBox_id.setBounds(364, 32, 112, 26);
		jpFees.add(comboBox_id);
		
		JLabel lblStudentId = new JLabel("Student ID:- ");
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblStudentId.setBounds(215, 35, 139, 23);
		jpFees.add(lblStudentId);
		
		textField_amt = new JTextField();
		textField_amt.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_amt.setBounds(178, 109, 146, 26);
		jpFees.add(textField_amt);
		textField_amt.setColumns(10);
		
		JLabel lblFeesAmount = new JLabel("Fees Amount:- ");
		lblFeesAmount.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblFeesAmount.setBounds(15, 112, 148, 23);
		jpFees.add(lblFeesAmount);
		
		JLabel lblPaymentDate = new JLabel("Payment Date:- ");
		lblPaymentDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPaymentDate.setBounds(339, 112, 154, 23);
		jpFees.add(lblPaymentDate);
		
		textField_pay_date = new JTextField();
		textField_pay_date.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_pay_date.setToolTipText("Date in :- DD-MON-YYYY");
		textField_pay_date.setColumns(10);
		textField_pay_date.setBounds(508, 109, 146, 26);
		jpFees.add(textField_pay_date);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(textField_amt.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jpFees, "Enter Pay Amount");
						textField_amt.requestFocus();
						return;
					}
				
					if(textField_pay_date.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jpFees, "Invalid Date !!");
						textField_pay_date.requestFocus();
						return;
					}
					
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					CallableStatement stmt=con.prepareCall("{call update_fees_pay(?,?,?)}");
					stmt.setString(1, (String) comboBox_id.getSelectedItem().toString());
					stmt.setInt(2, Integer.parseInt(textField_amt.getText()));
					stmt.setString(3,textField_pay_date.getText());
					
					stmt.executeQuery();
					
					JOptionPane.showMessageDialog(jpFees, "Fees Paid For:- "+comboBox_id.getSelectedItem());
					con.commit();
					con.close();
				
				}
				catch(Exception ecp)
				{
					ecp.printStackTrace();
				}
				
				
			}
		});
		btnSubmit.setBounds(518, 151, 115, 39);
		jpFees.add(btnSubmit);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 314, 713, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnReport = new JButton("Report");
		btnReport.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="select * from stud_fees_details order by stud_id";
					PreparedStatement pst=con.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					
					con.commit();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setFont(new Font("Times New Roman", Font.BOLD, 18));
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(contentPane, "Loading ERR!!");
				}
				
			}
		});
		btnReport.setBounds(631, 259, 123, 39);
		contentPane.add(btnReport);
	}
}
