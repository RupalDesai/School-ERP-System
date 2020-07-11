package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class attendance_audit extends JFrame {

	private JPanel contentPane;
	private JTable table_audit;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance_audit frame = new attendance_audit();
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
	public attendance_audit() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Audit Trails");
		setBounds(100, 100, 1064, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 41, 831, 324);
		contentPane.add(scrollPane);
		
		table_audit = new JTable();
		scrollPane.setViewportView(table_audit);
		
		JButton btnGenerateAuditLogs = new JButton("Generate Audit Logs ");
		btnGenerateAuditLogs.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnGenerateAuditLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="select * from audit_stud_attendance_details";
					PreparedStatement pst=con.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					
					con.commit();
					table_audit.setModel(DbUtils.resultSetToTableModel(rs));
					table_audit.setFont(new Font("Times New Roman", Font.BOLD, 18));
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(contentPane, "Loading ERR!!");
				}
			
		
				
			}
		});
		btnGenerateAuditLogs.setBounds(271, 396, 242, 59);
		contentPane.add(btnGenerateAuditLogs);
		
		JLabel label = new JLabel("Audit Results :- ");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(119, 400, 394, 20);
		contentPane.add(label);
	}
}
