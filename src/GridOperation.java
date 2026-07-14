import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;
import com.mysql.cj.xdevapi.Statement;

public class GridOperation {
	
	private static final Object[] String = null;
	JFrame frame;
	JTable table;
	DefaultTableModel model;
	
	public GridOperation()
	{
		frame = new JFrame("Student Records");
		
		//column names
		String[] column = {"Student I'd","Student Name", "Student Age"};
		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		loadData();
		
		JScrollPane sp = new JScrollPane(table);
		frame.add(sp);
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//method to fetch data from database

	 void loadData() {
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Connection con = DriverManager.getConnection(
						
						"jdbc:mysql://localhost:3306/studentdb",
						"root", 
						"Aditya@123");
				
				java.sql.Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM student");
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					
					model.addRow(new Object[] {id, name, age});
				}
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
	}
	 public static void main(String[] args) {
		 new GridOperation();
		
	}


}
