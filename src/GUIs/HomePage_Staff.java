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

public class HomePage_Staff extends JFrame {

	private JPanel contentPane;

	HomePage_Staff frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					HomePage_Staff frame = new HomePage_Staff();
					frame.setVisible(true);

			}

	/**
	 * Create the frame.
	 */
	public HomePage_Staff() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 717);
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
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setBounds(29, 141, 953, 2);
		contentPane.add(separator);
		
		JPanel panel_tab = new JPanel();
		panel_tab.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tabs", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_tab.setBounds(31, 58, 966, 79);
		contentPane.add(panel_tab);
		panel_tab.setLayout(null);
		
		JButton btnEnroll = new JButton("Staff Info.");
		btnEnroll.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnEnroll.setBounds(31, 26, 151, 37);
		panel_tab.add(btnEnroll);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contact Us", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(31, 465, 966, 180);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("General Arun Kumar Vaidya Nagar,  Borivali East, Mumbai - 400066,");
		label.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		label.setBounds(15, 81, 655, 35);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel(" Near Tata Power House, Near Magathane Depot Devipada");
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		label_1.setBounds(15, 109, 655, 35);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Contact Nos.\r\n");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		label_2.setBounds(711, 40, 124, 35);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel(" +(91)-22-28860244");
		label_3.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		label_3.setBounds(695, 81, 226, 35);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Address\r\n");
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		label_4.setBounds(15, 40, 124, 35);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel(" +(91)-22-28868765");
		label_5.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		label_5.setBounds(695, 109, 226, 35);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Mission :");
		label_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		label_6.setBounds(382, 172, 133, 54);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(" \"Our mission is to develop children with active and creative minds,\r\n");
		label_7.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label_7.setBounds(372, 215, 563, 35);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("  a sense of understanding and compassion for others,");
		label_8.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label_8.setBounds(382, 242, 458, 35);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("and the courage to act on their beliefs.\"");
		label_9.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label_9.setBounds(392, 272, 342, 35);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Vision :");
		label_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		label_10.setBounds(382, 293, 133, 54);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("\"We will be the preeminent intellectual and");
		label_11.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label_11.setBounds(385, 337, 387, 35);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel(" creative center for effective engagement");
		label_12.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label_12.setBounds(382, 363, 730, 35);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("   in a world that increasingly demands  to meet social needs.\"");
		label_13.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label_13.setBounds(372, 388, 730, 35);
		contentPane.add(label_13);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anup Mulay\\workspace\\School ERP System\\resources\\181505_198114153538193_5001483_n.jpg"));
		lblNewLabel.setBounds(15, 172, 352, 250);
		contentPane.add(lblNewLabel);
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Staff_Data_Entry sde=new Staff_Data_Entry();
				sde.setVisible(true);
						
			}
		});
		
	}
}
