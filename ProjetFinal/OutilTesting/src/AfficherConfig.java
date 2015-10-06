import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.DatabaseConnection;



@WebServlet("/AfficherConfig")
public class AfficherConfig extends HttpServlet  {
	
	
	String filepath;
	String filename;
	int id;
	
	Connection conn;
	Statement stmt;
	ResultSet res;
	
	
	DatabaseConnection dbconn;
	
	
	String format,inout,realtimebatch,timesofday,volume,checksum,encoding,media;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		filepath = request.getParameter("path");
		filename = request.getParameter("filename");
		id = Integer.parseInt(request.getParameter("id"));
		int num;
		int bool = Integer.parseInt(request.getParameter("bool"));
		String query;
		System.out.println(id);
		System.out.println(filename);
		System.out.println(filepath);
		System.out.println("bool"+bool);
		
        //FileInputStream fis = new FileInputStream("C://project.xlsx");
		FileInputStream fis = new FileInputStream(filepath);
        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
       
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();
        
       
    
        
        
        
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
num = row.getRowNum();
if(num>8){break;}

System.out.print(num+" : ");
            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            int cellnum=0;
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                cellnum = cell.getColumnIndex();
    if(cellnum==1){       
    		switch(num){
    		case 1:
    			format=cell.getStringCellValue();
    			System.out.print(format);
    			break;
    		case 2:
    			inout=cell.getStringCellValue();
    			System.out.print(inout);
    			break;
    		case 3:
    			realtimebatch=cell.getStringCellValue();
    			System.out.print(realtimebatch);
    			break;
    		case 4:
    			timesofday=cell.getStringCellValue();
    			System.out.print(timesofday);
    			break;
    		case 5:
    			volume=cell.getStringCellValue();
    			System.out.print(volume);
    			break;
    		case 6:
    			checksum=cell.getStringCellValue();
    			System.out.print(checksum);
    			break;
    		case 7:
    			encoding=cell.getStringCellValue();
    			System.out.print(encoding);
    			break;
    		case 8:
    			media=cell.getStringCellValue();
    			System.out.print(media);
    			break;
    		default :
    		}
    	
    			/*
                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t");
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t");
                    break;
                default :
             
                }
                */
    }
            }
            System.out.println("");
        }
        
        
       if(bool==0){
        dbconn = new DatabaseConnection();
		conn = dbconn.setConnection();
		try {
			stmt = conn.createStatement();
			query = "insert into configuration (id,format,inorout,realtimebatch,timesofday,volume,checksum,encoding,media) values ("+id+",'"+format+"','"+inout+"','"+realtimebatch+"','"+timesofday+"','"+volume+"','"+checksum+"','"+encoding+"','"+media+"')";
																						
			int i = stmt.executeUpdate(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       }	
		
       
		
				
		request.setAttribute("format", format);
		request.setAttribute("inout", inout);
		request.setAttribute("realtimebatch", realtimebatch);
		request.setAttribute("timesofday", timesofday);
		request.setAttribute("volume", volume);
		request.setAttribute("checksum", checksum);
		request.setAttribute("encoding", encoding);
		request.setAttribute("media", media);
		
		request.setAttribute("id", id);
		request.setAttribute("filename", filename);
		request.setAttribute("filepath", filepath);
		
		
		
	
		if(media.equalsIgnoreCase("queue"))
		{
			//RequestDispatcher rd = request.getRequestDispatcher("queue.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("spec_validate_update.jsp");
			rd.forward(request,response);
		}
		else
		{
			
			if(media.equalsIgnoreCase("ftp"))
			{
				//RequestDispatcher rd = request.getRequestDispatcher("ftp.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("spec_validate_update.jsp");
				rd.forward(request,response);
			}
			else 
			{
				if(media.equalsIgnoreCase("inputdevice"))
				{
					//RequestDispatcher rd = request.getRequestDispatcher("generer.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("spec_validate_update.jsp");
					rd.forward(request,response);
				}
				else{
				//RequestDispatcher rd = request.getRequestDispatcher("configuration.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("spec_validate_update.jsp");
				rd.forward(request,response);
				}
			}
				
				
			
		}
			
        
	}


}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	