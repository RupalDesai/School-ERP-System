package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;
import oracle.sql.DATE;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Attendance_Management extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tFID;
	private JTextField tFDate;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance_Management frame = new Attendance_Management();
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
	public Attendance_Management() {
		setTitle("Attendance Management");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 89, 525, 444);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoad = new JButton("Report");
		btnLoad.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="select * from stud_attendance_details order by stud_id,attendance_date";
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
		btnLoad.setBounds(756, 29, 130, 44);
		contentPane.add(btnLoad);
		
		final JPanel jpAbsent = new JPanel();
		jpAbsent.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Absent Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpAbsent.setBounds(33, 63, 379, 327);
		contentPane.add(jpAbsent);
		jpAbsent.setLayout(null);
		
		JLabel lblId = new JLabel("ID :- ");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(15, 62, 49, 20);
		jpAbsent.add(lblId);
		
		tFID = new JTextField();
		tFID.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tFID.setBounds(55, 60, 71, 26);
		jpAbsent.add(tFID);
		tFID.setColumns(10);
		
		JLabel lblStandard = new JLabel("Standard :-");
		lblStandard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStandard.setBounds(141, 62, 101, 20);
		jpAbsent.add(lblStandard);
		
		final JComboBox CBStandard = new JComboBox();
		CBStandard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		CBStandard.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		CBStandard.setEditable(true);
		CBStandard.setBounds(257, 60, 75, 26);
		jpAbsent.add(CBStandard);
		
		JLabel lblNewLabel = new JLabel("Division :-");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(15, 142, 100, 20);
		jpAbsent.add(lblNewLabel);
		
		final JComboBox CBDivision = new JComboBox();
		CBDivision.setFont(new Font("Times New Roman", Font.BOLD, 22));
		CBDivision.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		CBDivision.setEditable(true);
		CBDivision.setBounds(110, 140, 49, 26);
		jpAbsent.add(CBDivision);
		
		JLabel lblDate = new JLabel("Date :- ");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(174, 142, 69, 20);
		jpAbsent.add(lblDate);
		
		tFDate = new JTextField();
		tFDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tFDate.setToolTipText("Date In DD-MON-YY Format");
		tFDate.setBounds(233, 140, 131, 26);
		jpAbsent.add(tFDate);
		tFDate.setColumns(10);
//		SimpleDateFormat sdf = new SimpleDateFormat("DD-MON-YY");
//		try
//		{
//			Date date1 = (Date) sdf.parse(tFDate.getText());
//		} 
//		catch (ParseException e1) 
//		{
//			e1.printStackTrace();
//		}
//		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		System.out.println(dateFormat.format(date));
//		
		
		JButton btnAbsent = new JButton("Submit");
		btnAbsent.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(tFID.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jpAbsent, "Plz Enter ID!!");
						tFID.requestFocus();
						return;
					}
					
					if(tFDate.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jpAbsent, "Plz Enter Date IN DD-MON-YY fromat!!");
						tFDate.requestFocus();
						return;
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					
					
					String number[]=tFID.getText().toString().split(",");
					
					for(int i=0;i<number.length;i++)
					{
						CallableStatement stmt=con.prepareCall("{call trial_attend(?,?,?,?,?)}");
						stmt.setInt(1, Integer.parseInt(number[i].toString()));
						stmt.setInt(2,Integer.parseInt((String) CBStandard.getSelectedItem()));
						stmt.setString(3, (String) CBDivision.getSelectedItem());
						stmt.setString(4, "A");
						stmt.setString(5, tFDate.getText());
					
						
						stmt.executeQuery();
						con.commit();
						
					}
					con.close();
					
					JOptionPane.showMessageDialog(jpAbsent, "Absent Marked");
					
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(jpAbsent, "Attendance ERR");
					//ee.printStackTrace();
				}
				
			}
		});
		btnAbsent.setBounds(108, 230, 115, 46);
		jpAbsent.add(btnAbsent);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Set Others Present", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(43, 406, 369, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPresent = new JButton("PRESENT");
		btnPresent.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPresent.setToolTipText("Use to mark other Students --> PRESENT");
		btnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					if(tFDate.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jpAbsent, "Plz Enter Date IN DD-MON-YY fromat!!");
						tFDate.requestFocus();
						return;
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					CallableStatement stmt=con.prepareCall("{call stud_attendance_present(?)}");
					stmt.setString(1, tFDate.getText());
					
					stmt.executeQuery();
					con.commit();
					con.close();
					
					JOptionPane.showMessageDialog(jpAbsent, "Rest all Marked Present For "+tFDate.getText()+"!!");
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(jpAbsent, "Attendace ERR!!");
				}
				
			}
		});
		btnPresent.setBounds(15, 31, 328, 80);
		panel.add(btnPresent);
		
		JButton btnFilterByDate = new JButton("Filter By Date");
		btnFilterByDate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnFilterByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					if(tFDate.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jpAbsent, "Plz Enter Date IN DD-MON-YY fromat!!");
						tFDate.requestFocus();
						return;
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="select * from stud_attendance_details where attendance_date=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1,tFDate.getText());
					
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
		btnFilterByDate.setBounds(497, 29, 193, 44);
		contentPane.add(btnFilterByDate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tFID.setText("");
				CBStandard.setSelectedItem("1");
				CBDivision.setSelectedItem("A");
				tFDate.setText("");
			}
			
		});
		btnClear.setBounds(33, 18, 115, 35);
		contentPane.add(btnClear);
		
		JButton btnAudits = new JButton("Audits");
		btnAudits.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnAudits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				attendance_audit aud=new attendance_audit();
				aud.setVisible(true);
			}
		});
		btnAudits.setBounds(756, 549, 130, 56);
		contentPane.add(btnAudits);
	}
}
