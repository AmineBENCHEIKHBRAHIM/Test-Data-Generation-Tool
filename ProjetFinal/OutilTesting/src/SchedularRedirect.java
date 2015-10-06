

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SchedularRedirect
 */
@WebServlet("/SchedularRedirect")
public class SchedularRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String media,format,filepath,secondes,minutes,heures,jour,mois,annee,outputfile;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedularRedirect() {
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
		media = (String) request.getParameter("media");
		format = (String) request.getParameter("format");
		filepath = (String) request.getParameter("generatedfilepath");
		outputfile = (String) request.getParameter("outputfile");

		request.setAttribute("media",media);
		request.setAttribute("format",format);
		request.setAttribute("generatedfilepath",filepath);
		request.setAttribute("outputfile",outputfile);
		
		
		secondes = request.getParameter("secondes");
		minutes = request.getParameter("minutes");
		heures = request.getParameter("heures");
		jour = request.getParameter("jour");
		mois = request.getParameter("mois");
		annee = request.getParameter("annee");
		
		request.setAttribute("secondes",secondes);
		request.setAttribute("minutes",minutes);
		request.setAttribute("heures",heures);
		request.setAttribute("jour",jour);
		request.setAttribute("mois",mois);
		request.setAttribute("annee",annee);
		
		System.out.println("***********"+media);
		if(media.equalsIgnoreCase("ftp")||media.equals("ftp"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/ftp.jsp");
			rd.forward(request, response);
		}
		else
		{
			if(media.equalsIgnoreCase("queue")||media.equals("Queue"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/queue.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
