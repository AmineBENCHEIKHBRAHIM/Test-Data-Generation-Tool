import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import classes.DatabaseConnection;



	@WebServlet("/UploadFile")
	public class UploadFile extends HttpServlet {
		private static final long serialVersionUID = 1L;
		String saveFile = "C:/upload/";
		Connection conn;
		Statement stmt;
		ResultSet res;
		
		String username,password,nom,prenom,query;
		
		
		DatabaseConnection dbconn;  
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UploadFile() {
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
			boolean ismultipart = ServletFileUpload.isMultipartContent(request);
			if(!ismultipart)
			{
				
			}
			else 
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = null;
				try
				{
					items = upload.parseRequest(request);
				}
				catch(Exception e){}
				Iterator itr = items.iterator();
				while(itr.hasNext())
				{
					FileItem item = (FileItem) itr.next();
					if(item.isFormField())
					{
						
					}
					else {
						String itemname = item.getName();
						if((itemname==null)||itemname.equals(""))
								{
							continue;
								}
						String filename = FilenameUtils.getName(itemname);
						File f = checkExist(filename);
						item.write(f);
						dbconn = new DatabaseConnection();
						conn = dbconn.setConnection();
						try {
							stmt = conn.createStatement();
							query = "insert into file (name,path) values('"+filename+"','"+saveFile+filename+"')";
							int i = stmt.executeUpdate(query);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
						rd.forward(request,response);
					}
				}
			}
			}
			catch (Exception e){}
		}

		private File checkExist(String fileName) {
			File f = new File(saveFile+"/"+fileName);
			if(f.exists())
			{
				StringBuffer sb = new StringBuffer(fileName);
				sb.insert(sb.lastIndexOf("."), "-"+new Date().getTime());
				f = new File(saveFile+"/"+sb.toString());
			}
			return f;
		}


	}



