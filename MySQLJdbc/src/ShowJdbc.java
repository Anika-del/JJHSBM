import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

	public class ShowJdbc {

		public static void main(String[] args) throws Exception {
			
			System.out.println("Show data here ...");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "btech6");
	       
	    	 Statement s = con.createStatement();
	         
	         ResultSet result1 = s.executeQuery("select * from emp102");
	         
	         while (result1.next()) {
	             System.out.println(result1.getString("name") + " = " + result1.getString(2));
	         }

	         
	         s.close();
		}

	}
