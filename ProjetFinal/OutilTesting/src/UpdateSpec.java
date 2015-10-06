

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateSpec
 */
@WebServlet("/UpdateSpec")
public class UpdateSpec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSpec() {
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
		
		String format = request.getParameter("format");
		String media = request.getParameter("media");
		String filename = request.getParameter("filename");
		String filepath = request.getParameter("filepath");
		request.setAttribute("format", format);
		request.setAttribute("media", media);
		request.setAttribute("filename", filename);
		request.setAttribute("filepath", filepath);
		
		RequestDispatcher rd = request.getRequestDispatcher("spec_validate_update.jsp");
		rd.forward(request,response);
		
	}

}
