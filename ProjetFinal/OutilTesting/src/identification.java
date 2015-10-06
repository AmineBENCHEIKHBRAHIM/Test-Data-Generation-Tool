

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

/**
 * Servlet implementation class identification
 */
@WebServlet("/identification")
public class identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	ResultSet res;
	Statement stmt;
	String username,password,query;
	int has = 0;
	DatabaseConnection dbconn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public identification() {
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
		
		String login = request.getParameter("login");
		String passe = request.getParameter("passe");
		query = "select * from users where login='"+login+"' and password='"+passe+"'";
		dbconn = new DatabaseConnection();
		conn = dbconn.setConnection();
		res = dbconn.getResult(query, conn);
	
		
	try {
		if(res.next())
{
					
						HttpSession session = request.getSession(true);
						session.setAttribute("login", login);
						ServletContext sc = getServletConfig().getServletContext();
						 RequestDispatcher rd = sc.getRequestDispatcher("/upload.jsp");
						 rd.forward(request, response);
					
					
}
		else
		{
			ServletContext sc = getServletConfig().getServletContext();
			 RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
			 rd.forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
		}
		
	}

