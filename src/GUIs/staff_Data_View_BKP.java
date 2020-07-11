package GUIs;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.Queries;

public class staff_Data_View_BKP extends JFrame{
	
	JScrollPane jsc;
	JTable table;
	
	Object data[][]=null;
	
	String heading[] = { "Staff ID", "Staff Name", "Staff Address", "Contact Number", "Email", "Designation", "Type", "Qualification"};
	
	staff_Data_View_BKP() 
	{
		
		super("View Staff Data --> Backup Data");
		setSize(1400, 700);

		Queries q = new Queries();
		
		data = q.selectAsArrayStaff_BKP();

		table = new JTable(data, heading);
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
					
		jsc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					
		for (int i = 0; i < data.length; i++)
		{
						
			for (int j = 0; j < data[0].length; j++) 
			{
							
				table.setValueAt(data[i][j], i, j);// V.V.imp !!
						
			}	
		}
					
		add(jsc);
		setLocation(290, 200);
		Color c1 = new Color(225, 175, 120);
		table.setBackground(c1);

		setVisible(true);
			}
	
	/*public static void main(String args[])
	{
		Staff_Data_View view=new Staff_Data_View();
	}*/


}
