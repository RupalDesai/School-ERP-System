package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.Queries;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;

public class Exam_Result extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblMarksObtained;
	private JTextField textField_6;
	private JLabel lblTotalMarks;
	private JTextField textField_7;
	private JLabel lblYear;
	private JLabel lblDate;
	private JTextField textField_8;
	private JTextField tFEnglish;
	private JTextField tFHindi;
	private JTextField tFMarathi;
	private JTextField tFMaths;
	private JTextField tFScience;
	private JTextField tFSS;
	private JTextField tFEnglish_total;
	private JTextField tFHindi_total;
	private JTextField tFMarathi_total;
	private JTextField tFMaths_total;
	private JTextField tFScience_total;
	private JTextField tFSS_total;
	private JTextField tFTotal;
	private JTextField tF_sub_total;
	private JTextField tFExamID;
	private JTextField tFExamYear;
	private JTextField tFExamDate;
	private JTextField tFCommon_total;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam_Result frame = new Exam_Result();
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
	public Exam_Result() {
		setTitle("Exam Results");
		getContentPane().setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1462, 853);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel jpanel_marksDetails = new JPanel();
		jpanel_marksDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Exam Details ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpanel_marksDetails.setBounds(15, 16, 1372, 410);
		contentPane.add(jpanel_marksDetails);
		jpanel_marksDetails.setLayout(null);
		
		final JPanel jpanel_subjects = new JPanel();
		jpanel_subjects.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Subject Marks", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanel_subjects.setBounds(523, 16, 811, 378);
		jpanel_marksDetails.add(jpanel_subjects);
		jpanel_subjects.setLayout(null);
		
		JLabel lblEnglish = new JLabel("ENGLISH:- ");
		lblEnglish.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEnglish.setBounds(15, 34, 120, 26);
		jpanel_subjects.add(lblEnglish);
		
		JLabel lblHindi = new JLabel("HINDI :- ");
		lblHindi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHindi.setBounds(15, 95, 120, 26);
		jpanel_subjects.add(lblHindi);
		
		JLabel lblMarathi = new JLabel("MARATHI:- ");
		lblMarathi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMarathi.setBounds(15, 154, 120, 26);
		jpanel_subjects.add(lblMarathi);
		
		tFEnglish = new JTextField();
		tFEnglish.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFEnglish.setColumns(10);
		tFEnglish.setBounds(139, 34, 86, 23);
		jpanel_subjects.add(tFEnglish);
		
		tFHindi = new JTextField();
		tFHindi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFHindi.setColumns(10);
		tFHindi.setBounds(139, 95, 86, 23);
		jpanel_subjects.add(tFHindi);
		
		tFMarathi = new JTextField();
		tFMarathi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFMarathi.setColumns(10);
		tFMarathi.setBounds(139, 154, 86, 23);
		jpanel_subjects.add(tFMarathi);
		
		JLabel lblMaths = new JLabel("MATHS:- ");
		lblMaths.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaths.setBounds(385, 34, 112, 26);
		jpanel_subjects.add(lblMaths);
		
		JLabel lblScience = new JLabel("SCIENCE:- ");
		lblScience.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblScience.setBounds(385, 95, 112, 26);
		jpanel_subjects.add(lblScience);
		
		JLabel lblSocialStudies = new JLabel("SOCIAL STUDIES:- ");
		lblSocialStudies.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSocialStudies.setBounds(343, 154, 191, 26);
		jpanel_subjects.add(lblSocialStudies);
		
		tFMaths = new JTextField();
		tFMaths.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFMaths.setColumns(10);
		tFMaths.setBounds(523, 31, 86, 23);
		jpanel_subjects.add(tFMaths);
		
		tFScience = new JTextField();
		tFScience.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFScience.setColumns(10);
		tFScience.setBounds(523, 95, 86, 23);
		jpanel_subjects.add(tFScience);
		
		tFSS = new JTextField();
		tFSS.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFSS.setColumns(10);
		tFSS.setBounds(523, 154, 86, 23);
		jpanel_subjects.add(tFSS);
		
		JLabel label = new JLabel("/");
		label.setBounds(228, 34, 16, 26);
		jpanel_subjects.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(228, 95, 16, 26);
		jpanel_subjects.add(label_1);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(228, 154, 16, 26);
		jpanel_subjects.add(label_2);
		
		JLabel label_3 = new JLabel("/");
		label_3.setBounds(612, 31, 16, 26);
		jpanel_subjects.add(label_3);
		
		JLabel label_4 = new JLabel("/");
		label_4.setBounds(612, 95, 16, 26);
		jpanel_subjects.add(label_4);
		
		JLabel label_5 = new JLabel("/");
		label_5.setBounds(612, 154, 16, 26);
		jpanel_subjects.add(label_5);
		
		tFEnglish_total = new JTextField();
		tFEnglish_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFEnglish_total.setColumns(10);
		tFEnglish_total.setBounds(240, 34, 86, 23);
		jpanel_subjects.add(tFEnglish_total);
		
		tFHindi_total = new JTextField();
		tFHindi_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFHindi_total.setColumns(10);
		tFHindi_total.setBounds(242, 95, 86, 23);
		jpanel_subjects.add(tFHindi_total);
		
		tFMarathi_total = new JTextField();
		tFMarathi_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFMarathi_total.setColumns(10);
		tFMarathi_total.setBounds(242, 154, 86, 23);
		jpanel_subjects.add(tFMarathi_total);
		
		tFMaths_total = new JTextField();
		tFMaths_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFMaths_total.setColumns(10);
		tFMaths_total.setBounds(624, 34, 86, 23);
		jpanel_subjects.add(tFMaths_total);
		
		tFScience_total = new JTextField();
		tFScience_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFScience_total.setColumns(10);
		tFScience_total.setBounds(624, 95, 86, 23);
		jpanel_subjects.add(tFScience_total);
		
		tFSS_total = new JTextField();
		tFSS_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFSS_total.setColumns(10);
		tFSS_total.setBounds(624, 154, 86, 23);
		jpanel_subjects.add(tFSS_total);
		
		JLabel lblTotal = new JLabel("Total :- ");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTotal.setBounds(147, 225, 86, 26);
		jpanel_subjects.add(lblTotal);
		
		tFTotal = new JTextField();
		tFTotal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFTotal.setColumns(10);
		tFTotal.setBounds(223, 225, 86, 23);
		jpanel_subjects.add(tFTotal);
		
		JLabel label_6 = new JLabel("/");
		label_6.setBounds(312, 225, 16, 26);
		jpanel_subjects.add(label_6);
		
		tF_sub_total = new JTextField();
		tF_sub_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tF_sub_total.setColumns(10);
		tF_sub_total.setBounds(326, 225, 86, 23);
		jpanel_subjects.add(tF_sub_total);
		
		
		JLabel lblStudentsId = new JLabel("Student's ID:- ");
		lblStudentsId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStudentsId.setBounds(15, 44, 124, 26);
		jpanel_marksDetails.add(lblStudentsId);
		
		JLabel lblStandard = new JLabel("Standard :- ");
		lblStandard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStandard.setBounds(242, 44, 123, 26);
		jpanel_marksDetails.add(lblStandard);
		
		final JComboBox CBStandard = new JComboBox();
		CBStandard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		CBStandard.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		CBStandard.setEditable(true);
		CBStandard.setBounds(380, 45, 79, 26);
		jpanel_marksDetails.add(CBStandard);
		
		JLabel lblDivision = new JLabel("Division :-");
		lblDivision.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDivision.setBounds(129, 112, 104, 26);
		jpanel_marksDetails.add(lblDivision);
		
		final JComboBox CBDivision = new JComboBox();
		CBDivision.setFont(new Font("Times New Roman", Font.BOLD, 22));
		CBDivision.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		CBDivision.setEditable(true);
		CBDivision.setBounds(242, 113, 79, 26);
		jpanel_marksDetails.add(CBDivision);
		
		JLabel lblExamId = new JLabel("Exam ID :-");
		lblExamId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExamId.setBounds(15, 206, 96, 26);
		jpanel_marksDetails.add(lblExamId);
		
		JLabel lblExamYear = new JLabel("Exam Year :- ");
		lblExamYear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExamYear.setBounds(241, 206, 124, 26);
		jpanel_marksDetails.add(lblExamYear);
		
		JLabel lblExamDate = new JLabel("Exam Date :- ");
		lblExamDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExamDate.setBounds(98, 295, 122, 26);
		jpanel_marksDetails.add(lblExamDate);
		
		tFExamID = new JTextField();
		tFExamID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFExamID.setColumns(10);
		tFExamID.setBounds(126, 208, 86, 23);
		jpanel_marksDetails.add(tFExamID);
		
		tFExamYear = new JTextField();
		tFExamYear.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFExamYear.setColumns(10);
		tFExamYear.setBounds(373, 208, 86, 23);
		jpanel_marksDetails.add(tFExamYear);
		
		tFExamDate = new JTextField();
		tFExamDate.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFExamDate.setColumns(10);
		tFExamDate.setBounds(235, 297, 130, 23);
		jpanel_marksDetails.add(tFExamDate);
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Marks --> Textfields 
				
				if(tFEnglish.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> English!!");
					tFEnglish.requestFocus();
					return;
				}
				
				if(tFHindi.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Hindi!!");
					tFHindi.requestFocus();
					return;
				}
				
				if(tFMarathi.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Marathi!!");
					tFMarathi.requestFocus();
					return;
				}
				
				if(tFMaths.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Maths!!");
					tFMaths.requestFocus();
					return;
				}
				
				if(tFScience.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> science!!");
					tFScience.requestFocus();
					return;
				}
				
				if(tFSS.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Social Studies!!");
					tFSS.requestFocus();
					return;
				}
				
				//Marks Total --> Textfields 
				
				if(tFEnglish_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> English_TOTAL!!");
					tFEnglish.requestFocus();
					return;
				}
				
				if(tFHindi_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Hindi_TOTAL!!");
					tFHindi_total.requestFocus();
					return;
				}
				
				if(tFMarathi_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Marathi_TOTAL!!");
					tFMarathi_total.requestFocus();
					return;
				}
				
				if(tFMaths_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Maths_TOTAL!!");
					tFMaths_total.requestFocus();
					return;
				}
				
				if(tFScience_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Science_TOTAL!!");
					tFScience_total.requestFocus();
					return;
				}
				
				if(tFSS_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Social Studies_TOTAL!!");
					tFSS_total.requestFocus();
					return;
				}
				
				Integer total=(Integer.parseInt(tFEnglish.getText())+Integer.parseInt(tFHindi.getText())+Integer.parseInt(tFMarathi.getText())+Integer.parseInt(tFMaths.getText())+Integer.parseInt(tFScience.getText())+Integer.parseInt(tFSS.getText()));
				String total_marks=total.toString();
				tFTotal.setText(total_marks);
				
				
				Integer total_sub=(Integer.parseInt(tFEnglish_total.getText())+Integer.parseInt(tFHindi_total.getText())+Integer.parseInt(tFMarathi_total.getText())+Integer.parseInt(tFMaths_total.getText())+Integer.parseInt(tFScience_total.getText())+Integer.parseInt(tFSS_total.getText()));
				String total_sub_marks=total_sub.toString();
				tF_sub_total.setText(total_sub_marks);
				
			}
		});
		btnCalculate.setBounds(215, 267, 165, 40);
		jpanel_subjects.add(btnCalculate);
		
		JLabel lblSetForCommon = new JLabel("Set For Common Totals:- ");
		lblSetForCommon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSetForCommon.setBounds(240, 322, 238, 26);
		jpanel_subjects.add(lblSetForCommon);
		
		tFCommon_total = new JTextField();
		tFCommon_total.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tFCommon_total.setColumns(10);
		tFCommon_total.setBounds(466, 323, 86, 23);
		jpanel_subjects.add(tFCommon_total);
		
		JButton btnSet = new JButton("Set");
		btnSet.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnSet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				if(tFCommon_total.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jpanel_subjects, "Plz Enter Valid Marks --> Common_TOTAL!!");
					tFCommon_total.requestFocus();
					return;
				}
			
				String marks=tFCommon_total.getText();// --> Marks to set 
				
				tFEnglish_total.setText(marks);
				tFHindi_total.setText(marks);
				tFMarathi_total.setText(marks);
				tFMaths_total.setText(marks);
				tFScience_total.setText(marks);
				tFSS_total.setText(marks);
				
			}
		});
		btnSet.setBounds(558, 321, 88, 29);
		jpanel_subjects.add(btnSet);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// subject Marks --> Clear
				
				tFEnglish.setText("");
				tFHindi.setText("");
				tFMarathi.setText("");
				tFMaths.setText("");
				tFScience.setText("");
				tFSS.setText("");
				
				// Subject Marks Total --> Clear 
				
				tFEnglish_total.setText("");
				tFHindi_total.setText("");
				tFMarathi_total.setText("");
				tFMaths_total.setText("");
				tFScience_total.setText("");
				tFSS_total.setText("");
				
			}
		});
		btnClear.setBounds(15, 310, 115, 40);
		jpanel_subjects.add(btnClear);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnInsert.setBounds(15, 354, 115, 40);
		jpanel_marksDetails.add(btnInsert);
		
		ArrayList<Integer> id=new Queries().getId();
		final JComboBox CBID = new JComboBox(id.toArray());
		CBID.setFont(new Font("Times New Roman", Font.BOLD, 22));
		CBID.setEditable(true);
		CBID.setBounds(139, 45, 73, 26);
		jpanel_marksDetails.add(CBID);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					 
					CallableStatement stmt=con.prepareCall("{call exam_insert(?,?,?,?,?,?,?,?)}");
					stmt.setString(1, (String) (CBID.getSelectedItem().toString()));
					stmt.setInt(2, (Integer.parseInt((String)CBStandard.getSelectedItem().toString())));
					stmt.setString(3, (String)CBDivision.getSelectedItem());
					stmt.setInt(4, Integer.parseInt(tFTotal.getText())) ;
					stmt.setInt(5, Integer.parseInt(tF_sub_total.getText()));
					stmt.setInt(6, Integer.parseInt(tFExamID.getText()));
					stmt.setString(7, tFExamYear.getText());
					stmt.setString(8, tFExamDate.getText());
					
					stmt.executeQuery();			// Own Addition
					
					con.commit();
					con.close();
					JOptionPane.showMessageDialog(jpanel_marksDetails, "Addition Successful!!");
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
					JOptionPane.showMessageDialog(jpanel_marksDetails, "Addition YUNSuccessful!!");
				}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 500, 477, 264);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="select * from stud_exam_details order by stud_div";
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
		btnView.setBounds(46, 444, 115, 40);
		contentPane.add(btnView);
		
		JButton btnShowRankings = new JButton("Show Rankings");
		btnShowRankings.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnShowRankings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
				 
					String query="SELECT stud_course_id, stud_div, stud_id, stud_sub_marks,sub_total_marks,RANK() OVER (PARTITION BY stud_course_id ORDER BY stud_sub_marks DESC) Standard_Rank,RANK() OVER (PARTITION BY stud_course_id,stud_div ORDER BY stud_sub_marks DESC) Div_Rank,((stud_sub_marks/sub_total_marks)*100)Percentage FROM stud_exam_details order by stud_course_id";
					PreparedStatement pst=con.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					
					con.commit();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					table_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(contentPane, "Loading ERR!!");
				}
			
				
				
			}
		});
		btnShowRankings.setBounds(539, 442, 210, 40);
		contentPane.add(btnShowRankings);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(541, 501, 884, 263);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnProjections = new JButton("Graph");
		btnProjections.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnProjections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//LineChartSample lcs=new LineChartSample();
				 javafx.application.Application.launch(LineChartSample.class);
			}
		});
		btnProjections.setBounds(1221, 442, 115, 42);
		contentPane.add(btnProjections);
		
		
	}
}

