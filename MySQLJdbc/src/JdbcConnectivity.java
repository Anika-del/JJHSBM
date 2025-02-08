import java.sql.*;
import java.io.*;

	public class JdbcConnectivity {

	    public static void main(String[] args) throws Exception {
	    	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "btech6");
	           
	        	 Statement s = con.createStatement();
	             s.executeUpdate("create table emp102(name varchar(20), salary int)" );
	             s.close();

	             System.out.println("Table create secussefully ...");

	      
	    }
	}

