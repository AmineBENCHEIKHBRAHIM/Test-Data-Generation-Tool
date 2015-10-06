

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.DatabaseConnection;
import classes.FTPFunctions;

/**
 * Servlet implementation class FTPParameters
 */
@WebServlet("/FTPParameters")
public class FTPParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	ResultSet res;
	Statement stmt;
	String host;
	int port;
	String username,password,query;
	int has = 0;
	DatabaseConnection dbconn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FTPParameters() {
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
		host = request.getParameter("host");
		port = 21;
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		String media = (String) request.getParameter("media");
		String format = (String)request.getParameter("format");
		String filepath = (String)request.getParameter("generatedfilepath");
		String outputfile = (String) request.getParameter("outputfile");

		String secondes = (String)request.getParameter("secondes");
		String minutes = (String)request.getParameter("minutes");
		String heures = (String)request.getParameter("heures");
		String jour = (String)request.getParameter("jour");
		String mois = (String)request.getParameter("mois");
		String annee = (String)request.getParameter("annee");
		
		
		dbconn = new DatabaseConnection();
		conn = dbconn.setConnection();
		try {
			stmt = conn.createStatement();
			query = "insert into ftp (host,port,username,password) values ("+host+",'"+port+"','"+username+"','"+password+"')";
																						
			int i = stmt.executeUpdate(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		try { FTPFunctions ftpobj = new FTPFunctions(host, port, username, password);
		//ftpobj.uploadFTPFile("c:/filesource/shuriti.txt", "Shruti.txt", "/"); 
		ftpobj.uploadFTPFile(filepath, outputfile, "/"); 
		ftpobj.disconnect();

		} 
		catch (Exception e) { e.printStackTrace(); }
		System.out.println("****************FTP Transfer succeeded***************");
		RequestDispatcher rd = request.getRequestDispatcher("/FTPmerci.jsp");
		rd.forward(request, response);
		
	}

}
