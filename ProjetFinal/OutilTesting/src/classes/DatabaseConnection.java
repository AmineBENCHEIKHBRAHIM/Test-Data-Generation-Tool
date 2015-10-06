package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

	public Statement stmt;
	public ResultSet res;
	public Connection conn;
	
	public DatabaseConnection(){
		
	}
	
	public Connection setConnection(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/pfe","root","");
		}
		catch(Exception e){e.printStackTrace();}
		return conn;
	}
	
	public ResultSet getResult(String query,Connection conn){
		this.conn = conn ;
		try
		{
			stmt=conn.createStatement();
			res=stmt.executeQuery(query);
		}
		catch(Exception e){}
		return res;
	}
}
