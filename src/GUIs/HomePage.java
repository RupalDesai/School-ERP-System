package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {

	private JPanel contentPane;

	HomePage frame;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
					HomePage frame = new HomePage();
					frame.setVisible(true);

			}*/

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setTitle("Welcome ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 844);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMangubhaiDattaniVidyalaya = new JLabel("Mangubhai Dattani Vidyalaya");
		lblMangubhaiDattaniVidyalaya.setVerticalAlignment(SwingConstants.TOP);
		lblMangubhaiDattaniVidyalaya.setForeground(Color.BLUE);
		lblMangubhaiDattaniVidyalaya.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblMangubhaiDattaniVidyalaya.setBounds(229, 16, 519, 62);
		contentPane.add(lblMangubhaiDattaniVidyalaya);
		
		JLabel lblNewLabel = new JLabel(" \"Our mission is to develop children with active and creative minds,\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(373, 300, 563, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setBounds(31, 219, 953, 2);
		contentPane.add(separator);
		
		JLabel lblMission = new JLabel("Mission :");
		lblMission.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblMission.setBounds(383, 257, 133, 54);
		contentPane.add(lblMission);
		
		JLabel lblASenseOf = new JLabel("  a sense of understanding and compassion for others,");
		lblASenseOf.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblASenseOf.setBounds(383, 327, 458, 35);
		contentPane.add(lblASenseOf);
		
		JLabel lblVission = new JLabel("Vision :");
		lblVission.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblVission.setBounds(383, 378, 133, 54);
		contentPane.add(lblVission);
		
		JLabel lblWeWillBe = new JLabel("\"We will be the preeminent intellectual and");
		lblWeWillBe.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblWeWillBe.setBounds(386, 422, 387, 35);
		contentPane.add(lblWeWillBe);
		
		JLabel lblInAWorld = new JLabel("   in a world that increasingly demands  to meet social needs.\"");
		lblInAWorld.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblInAWorld.setBounds(373, 473, 730, 35);
		contentPane.add(lblInAWorld);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contact Us", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(42, 571, 966, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGeneralArunKumar = new JLabel("General Arun Kumar Vaidya Nagar,  Borivali East, Mumbai - 400066,");
		lblGeneralArunKumar.setBounds(15, 81, 655, 35);
		panel_1.add(lblGeneralArunKumar);
		lblGeneralArunKumar.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		
		JLabel lblNearTataPower = new JLabel(" Near Tata Power House, Near Magathane Depot Devipada");
		lblNearTataPower.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblNearTataPower.setBounds(15, 109, 655, 35);
		panel_1.add(lblNearTataPower);
		
		JLabel lblContactNos = new JLabel("Contact Nos.\r\n");
		lblContactNos.setBounds(711, 40, 124, 35);
		panel_1.add(lblContactNos);
		lblContactNos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		
		JLabel label = new JLabel(" +(91)-22-28860244");
		label.setBounds(695, 81, 226, 35);
		panel_1.add(label);
		label.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		
		JLabel lblAddress = new JLabel("Address\r\n");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddress.setBounds(15, 40, 124, 35);
		panel_1.add(lblAddress);
		
		JLabel label_1 = new JLabel(" +(91)-22-28868765");
		label_1.setBounds(695, 109, 226, 35);
		panel_1.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		
		JPanel panel_tab = new JPanel();
		panel_tab.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_tab.setBounds(31, 65, 966, 133);
		contentPane.add(panel_tab);
		panel_tab.setLayout(null);
		
		JButton btnEnroll = new JButton("Student Info.");
		btnEnroll.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnEnroll.setBounds(31, 26, 151, 37);
		panel_tab.add(btnEnroll);
		
		JButton btnAttendance = new JButton("Student Attendance");
		btnAttendance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnAttendance.setBounds(362, 26, 207, 37);
		panel_tab.add(btnAttendance);
		
		JButton btnExamDetails = new JButton("Exam Details");
		btnExamDetails.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnExamDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Exam_Result ER=new Exam_Result();
				ER.setVisible(true);
			}
		});
		btnExamDetails.setBounds(606, 26, 162, 37);
		panel_tab.add(btnExamDetails);
		
		JButton btnStudentFees = new JButton("Student Fees");
		btnStudentFees.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnStudentFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fees_stud fs=new Fees_stud();
				fs.setVisible(true);
			}
		});
		btnStudentFees.setBounds(800, 26, 151, 37);
		panel_tab.add(btnStudentFees);
		
		JButton btnStandards = new JButton("Standards");
		btnStandards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Standard_Management smg=new Standard_Management();
				smg.setVisible(true);
				
			}
		});
		btnStandards.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnStandards.setBounds(197, 26, 135, 34);
		panel_tab.add(btnStandards);
		
		JButton btnStaffInfo = new JButton("Staff Info.");
		btnStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Staff_Data_Entry sdef=new Staff_Data_Entry();
				sdef.setVisible(true);
			}
		});
		btnStaffInfo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnStaffInfo.setBounds(31, 79, 151, 37);
		panel_tab.add(btnStaffInfo);
		
		JLabel lblAndTheCourage = new JLabel("and the courage to act on their beliefs.\"");
		lblAndTheCourage.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblAndTheCourage.setBounds(393, 357, 342, 35);
		contentPane.add(lblAndTheCourage);
		
		JLabel lblCreativeCenterFor = new JLabel(" creative center for effective engagement");
		lblCreativeCenterFor.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCreativeCenterFor.setBounds(383, 448, 730, 35);
		contentPane.add(lblCreativeCenterFor);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anup Mulay\\workspace\\School ERP System\\resources\\181505_198114153538193_5001483_n.jpg"));
		lblNewLabel_1.setBounds(31, 256, 330, 280);
		contentPane.add(lblNewLabel_1);
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Attendance_Management am=new Attendance_Management();
				am.setVisible(true);
				
			}
		});
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame.dispose();
				
				//LoginPage lp1=new LoginPage();
				//lp1.setVisible(true);
				
				Student_Data_Entry frame_student_data_entry=new Student_Data_Entry();
				frame_student_data_entry.setVisible(true);
					
			}
		});
		
	}
}
