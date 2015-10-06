import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.DatabaseConnection;

@WebServlet("/DisplayData")
public class DisplayData  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Connection conn;
	Statement stmt;
	ResultSet res;

	String query,query2;
	
	DatabaseConnection dbconn;
	
	List lst = new ArrayList();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayData() {
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
		try
		{
			
			query = "select * from file";
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			res = dbconn.getResult(query, conn);
			
			request.setAttribute("filelist",res);
			
			query2 = "select id from configuration";
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			res = dbconn.getResult(query2, conn);
			
			request.setAttribute("idlist",res);
			
			
			
			
		
				RequestDispatcher rd = request.getRequestDispatcher("/download.jsp");
				rd.forward(request, response);
			
			   // response.sendRedirect("index2.jsp");
		}
		catch(Exception e){}
	}
	
	
	
	
	
	
	

}
