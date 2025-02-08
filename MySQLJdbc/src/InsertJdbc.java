import java.sql.*;

	public class InsertJdbc {

		public static void main(String[] args) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "btech6");
	       
	    	 Statement s = con.createStatement();
	         s.executeUpdate("insert into emp102 values('gulu', 15000)" );
	         s.close();

	         System.out.println("Insert data secussefully ...");


		}

	}

