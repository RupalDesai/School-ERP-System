package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Standard_Management extends JFrame {

	private JPanel contentPane;
	private JTextField tFCourseId;
	private JTextField tFName;
	private JTextField tFFees;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Standard_Management frame = new Standard_Management();
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
	public Standard_Management() {
		setTitle("Standard Managment");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Standards ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(56, 14, 713, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JLabel lblStandard = new JLabel("Standard :- ");
		lblStandard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblStandard.setBounds(15, 58, 113, 34);
		panel.add(lblStandard);
		
		tFCourseId = new JTextField();
		tFCourseId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tFCourseId.setBounds(151, 62, 146, 26);
		panel.add(tFCourseId);
		tFCourseId.setColumns(10);
		
		JLabel lblName = new JLabel("Name :- ");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblName.setBounds(348, 65, 94, 20);
		panel.add(lblName);
		
		tFName = new JTextField();
		tFName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tFName.setBounds(457, 62, 146, 26);
		panel.add(tFName);
		tFName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type :- ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(34, 137, 94, 23);
		panel.add(lblNewLabel);
		
		final JComboBox CBType = new JComboBox();
		CBType.setFont(new Font("Times New Roman", Font.BOLD, 22));
		CBType.setToolTipText("Under which Section the standard Comes ?");
		CBType.setMaximumRowCount(2);
		CBType.setModel(new DefaultComboBoxModel(new String[] {"Primary", "Secondary"}));
		CBType.setEditable(true);
		CBType.setBackground(Color.WHITE);
		CBType.setBounds(151, 134, 146, 26);
		panel.add(CBType);
		
		tFFees = new JTextField();
		tFFees.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tFFees.setBounds(457, 137, 146, 26);
		panel.add(tFFees);
		tFFees.setColumns(10);
		
		JLabel lblFess = new JLabel("Fess :- ");
		lblFess.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblFess.setBounds(359, 140, 69, 20);
		panel.add(lblFess);
		
		JButton btnInsert = new JButton("Insert ");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnInsert.setBounds(114, 261, 115, 29);
		contentPane.add(btnInsert);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnEdit.setBounds(279, 261, 115, 29);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnDelete.setBounds(452, 261, 115, 29);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnBack.setBounds(601, 261, 115, 29);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 351, 688, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="select * from courses_tbl order by course_id";
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
		btnLoad.setBounds(601, 306, 115, 29);
		contentPane.add(btnLoad);
		
		btnBack.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			dispose();
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			try
			{
				String s1=(String) CBType.getSelectedItem();
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			 
				CallableStatement stmt=con.prepareCall("{call edit_course_proc(?,?,?,?)}");
				
				stmt.setInt(1, Integer.parseInt(tFCourseId.getText()));
				stmt.setString(2, tFName.getText());
				stmt.setString(3, s1);
				stmt.setInt(4, Integer.parseInt(tFFees.getText()));
				
				stmt.executeQuery();
				con.close();
				
				JOptionPane.showMessageDialog(panel, "Update Successful!!");
			
			}
			catch(Exception g)
			{
				JOptionPane.showMessageDialog(panel, "Update Unsuccessful!!");
			}
				
			}
		});
		
		
		btnDelete.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(tFCourseId.getText().equals(""))
					{
						JOptionPane.showMessageDialog(panel, "Invalid Standard");
						tFCourseId.requestFocus();
						return;
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					CallableStatement stmt=con.prepareCall("{call delete_course_proc(?)}");
					
					stmt.setInt(1, Integer.parseInt(tFCourseId.getText()));
					
					
					stmt.executeQuery();
					con.commit();
					con.close();
					
					JOptionPane.showMessageDialog(panel, "Deletion Successful!!");
				
				}
				
				catch(Exception aw)
				{
					JOptionPane.showMessageDialog(panel, "Deletion Unsuccessful!!");
				}
				
			}
		});
		
		btnInsert.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(tFCourseId.getText().equals(""))
					{
						JOptionPane.showMessageDialog(panel, "Invalid Standard");
						tFCourseId.requestFocus();
						return;
					}
					
					if(tFName.getText().equals(""))
					{
						JOptionPane.showMessageDialog(panel, "Invalid Name");
						tFName.requestFocus();
						return;
					}
					if(tFFees.getText().equals(""))
					{
						JOptionPane.showMessageDialog(panel, "Invalid Fees");
						tFFees.requestFocus();
						return;
					}
					
					String s=(String) CBType.getSelectedItem();
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					CallableStatement stmt=con.prepareCall("{call insert_course_proc(?,?,?,?)}");
					
					stmt.setInt(1, Integer.parseInt(tFCourseId.getText()));
					stmt.setString(2, tFName.getText());
					stmt.setString(3, s);
					stmt.setInt(4, Integer.parseInt(tFFees.getText()));
					
					stmt.executeQuery();
					con.close();
					
					JOptionPane.showMessageDialog(panel, "Insertion Successful!!");
					
					tFCourseId.setText("");
					tFName.setText("");
					tFFees.setText("");
					CBType.setSelectedItem("Primary");
				}
				catch(Exception ar)
				{
					JOptionPane.showMessageDialog(panel, "Insertion UnSuccessful!!");
					ar.printStackTrace();
				}
				
			}
		});
		
		
	}
}
