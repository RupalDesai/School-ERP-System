package GUIs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.Queries;



public class StudentDataView extends JFrame{
	
	JScrollPane jsc;
	JTable table;
	
	Object data[][]=null;
	
	String heading[] = { "Student ID", "Student Name", "Student Address", "Contact Number", "Standard", "Division", "Parent Name", "Parent Contact", "Office Address", "Mobile Number", "Email Address"};
	
	StudentDataView() 
	{
		
		super("View Student Data");
		setSize(1400, 700);

		Queries q = new Queries();
		
		data = q.selectAsArray();

		table = new JTable(data, heading);
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		table.setEnabled(false);
					
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
		
		// Event Handling
		
		/*addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we) 
			{
				Student_Data_Entry sde=new Student_Data_Entry();
				dispose();
			}
		});*/
		
		
		
	}
			


}
