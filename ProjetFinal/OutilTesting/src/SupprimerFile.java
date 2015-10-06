

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.DatabaseConnection;

/**
 * Servlet implementation class SupprimerFile
 */
@WebServlet("/SupprimerFile")
public class SupprimerFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String filepath;
	String filename;
	int id;
	
	Connection conn;
	Statement stmt;
	ResultSet res;
	String query;
	
	DatabaseConnection dbconn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("id"));
		dbconn = new DatabaseConnection();
		conn = dbconn.setConnection();
		try {
			stmt = conn.createStatement();
			query = "delete from configuration where id="+id+";";
																						
			int i = stmt.executeUpdate(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
		rd.forward(request,response);
		
		
		
		
		
		
		
		
		
		
	}

}
