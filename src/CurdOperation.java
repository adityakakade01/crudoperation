import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CurdOperation {

	//database connection 
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studentdb",
				"root",
				"Aditya@123"
				);
	}
	
	//insert
	public static void insertStudent() {
		try (Connection con = getConnection()){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			
			System.out.println("Enter age: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name:  ");
			String name = sc.nextLine();
			
			
			
			String sql = "INSERT INTO student(id, name, age) VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			
			ps.executeUpdate();
			System.out.println("Student Insert Succsufully...");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateStudent() {
		try {Connection con = getConnection();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the id no to update::");
			int id = sc.nextInt();
			
			System.out.println("Enter age to update:: ");
			int age = sc.nextInt();
			
			String sql = "UPDATE student SET age=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, age);
			ps.setInt(2, id);
		
			ps.executeUpdate();
			System.out.println("Update successfully!!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
		
	}
	
	//delete
	public static void deleteStudent() {
		try {
			Connection con = getConnection();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter id::");
			int id = sc.nextInt();
			
			String sql = "DELETE FROM student WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			System.out.println("Deleted Successfuly...");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n *****Student Crud Menu*****");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Exit");
			System.out.println("Choose Option");
			
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				insertStudent();
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				System.out.println("Exiting...");
				System.exit(0);
				default:
					System.out.println("Invalid...");
			}
		}
		
	}
	
	
	
	
}
