package GUIs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.sql.*;
import java.util.*;
import java.sql.Connection; 
 
public class LineChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Roll Numbers");
		yAxis.setLabel("Obtained Marks");
		//System.out.println("LINE GRAPH");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Exam Results");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
		try
			{
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			
				Statement stmt=con.createStatement();
				String sql="Select stud_sub_marks from stud_exam_details where stud_course_id=1";
				ResultSet rs=stmt.executeQuery(sql);
				
				ArrayList<Integer> marks=new ArrayList<Integer>(); 
				
				while(rs.next())
				{
					marks.add(rs.getInt(1));
				}
				
				for(int i=1,j=0;i<=marks.size();i++,j++)
				{
					series.getData().add(new XYChart.Data(i, marks.get(j)));			
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		
		
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
        
    }
 
    
    public static void main(String[] args) {
        launch(args);
    }
}
