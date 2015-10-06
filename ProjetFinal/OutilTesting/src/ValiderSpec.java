

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.RandomStringGenerator;

/**
 * Servlet implementation class ValiderSpec
 */
@WebServlet("/ValiderSpec")
public class ValiderSpec extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String filepath;
	int id;
	
	
	
	//String format,inout,realtimebatch,timesofday,volume,checksum,encoding,media;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderSpec() {
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
		
		
		filepath = request.getParameter("path");
		//filename = request.getParameter("filename");
		//id = Integer.parseInt(request.getParameter("id"));
		int num;
		//String query;
		//System.out.println(id);
		System.out.print("Format : ");
		System.out.println(format);
		System.out.print("Media : ");
		System.out.println(media);
		System.out.print("Filename : ");
		System.out.println(filename);
		System.out.print("Filepath : ");
		System.out.println(filepath);
		
		request.setAttribute("media", media);
		request.setAttribute("format", format);
		request.setAttribute("outputfile", filename+"."+format);
		//FileInputStream fis = new FileInputStream("C://project.xlsx");
				FileInputStream fis = new FileInputStream(filepath);
		        // Finds the workbook instance for XLSX file
		        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		       
		        // Return first sheet from the XLSX workbook
		        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		        
		        Iterator<Row> rowIterator = mySheet.iterator();
		        int cellnum=0;
		     // Traversing over each row of XLSX file
		        while (rowIterator.hasNext()) {
		            Row row = rowIterator.next();
		num = row.getRowNum();
		if(num>15){break;}

		System.out.print(num+" : ");
		            // For each row, iterate through each columns
		            Iterator<Cell> cellIterator = row.cellIterator();
		            
		            while (cellIterator.hasNext()) {

		                Cell cell = cellIterator.next();
		                cellnum = cell.getColumnIndex();
		                System.out.println(cellnum);
		    
		        }
		        }  
		        
		        
		        
		        
		        //Map for memorizing values to compare for logic validation
		        Map<String, String> v1 = new HashMap<String, String>();
		        //map.put("name", "demo");
		        //map.put("fname", "fdemo");
		        
		        //Vector<String> v1=new Vector<String>();
		        String tempwriter;
		        
		        
		      //FileInputStream fis = new FileInputStream("C://project.xlsx");
		        fis = new FileInputStream(filepath);
		        // Finds the workbook instance for XLSX file
		        myWorkBook = new XSSFWorkbook (fis);
		       
		        // Return first sheet from the XLSX workbook
		        mySheet = myWorkBook.getSheetAt(0);
		        System.out.println("The second table :");
		        
		        File ff=new File("C:\\filetest\\resultat"+filename+"."+format); // définir l'arborescence
            	request.setAttribute("generatedfilepath", "C:\\filetest\\resultat"+filename+"."+format);
		        ff.createNewFile();
            	FileWriter ffw=new FileWriter(ff);
  for(int k=0;k<20;k++){//Générer 20 lignes           	
		     for(int i=1;i<cellnum+1;i++) {
		    	 System.out.print("Column : ");System.out.println(i+1);
		    	 String fieldname = null,required = null,datatype = null,internaltype = null,placeholder = null,fixedvalue = null,length = null,datavalidation = null,logicvalidation = null;
		        // Get iterator to all the rows in current sheet
		        //Iterator<Row> rowIterator = mySheet.iterator();
		    	 rowIterator = mySheet.iterator();
		        for (int j=0; j< mySheet.getLastRowNum() + 1; j++) {
		            Row row = mySheet.getRow(j);
		            if(j>10 && j<20){
		            Cell cell = row.getCell(i); //get first cell
		            // Printing Stuff
		            if(j==11){fieldname=cell.getStringCellValue();System.out.print(j+"fieldname : ");System.out.println(fieldname);}
		            if(j==12){required=cell.getStringCellValue();System.out.print(j+"required : ");System.out.println(required);}
		            if(j==13){datatype=cell.getStringCellValue();System.out.print(j+"datatype : ");System.out.println(datatype);}
		            if(j==14){internaltype=cell.getStringCellValue();System.out.print(j+"internaltype : ");System.out.println(internaltype);}
		            if(j==15){placeholder=cell.getStringCellValue();System.out.print(j+"placeholder : ");System.out.println(placeholder);}
		            if(j==16){fixedvalue=cell.getStringCellValue();System.out.print(j+"fixedvalue : ");System.out.println(fixedvalue);}
		            if(j==17){length=cell.getStringCellValue();System.out.print(j+"length : ");System.out.println(length);}
		            if(j==18){datavalidation=cell.getStringCellValue();System.out.print(j+"datavalidation : ");System.out.println(datavalidation);}
		            if(j==19){logicvalidation=cell.getStringCellValue();System.out.print(j+"logicvalidation : ");System.out.println(logicvalidation);}
		            
		            }
		            
		            //System.out.print("before");System.out.println(fixedvalue);
		        }
		        //ffw.write(fieldname+" "+required+" "+datatype+" "+internaltype+" "+placeholder+" "+fixedvalue+" "+length+" "+datavalidation+" "+logicvalidation);  // écrire une ligne dans le fichier resultat.txt
		        if(fixedvalue!=null && fixedvalue!="" && !fixedvalue.equals(""))
		        {
		        	System.out.println(fixedvalue);
		        	int x=fixedvalue.length();
		        	System.out.println(fixedvalue.substring(1,x-1));
		        	ffw.write(fixedvalue.substring(1,x-1));
		        }
		        else
		        {	
		        	switch(required){
		    		case "M":	   
		    			System.out.println(length.split(":")[0].trim());System.out.println("****");
		    			System.out.println(length.split(":")[1].trim());System.out.println("****");
		    			int min = Integer.parseInt(length.split(":")[0].trim());
		    			int max = Integer.parseInt(length.split(":")[1].trim());
		    			System.out.print("min:");System.out.println(min);
		    			System.out.print("max:");System.out.println(max);
		    			Random random = new Random();
		    			int randomInt = random.nextInt(max-min+1) + min;
		    			System.out.println("random :"+randomInt);
		    			if(datatype.equalsIgnoreCase("alphanumeric") || datatype=="alphanumeric")
		    			{
		    					try {
		    					tempwriter=RandomStringGenerator.generateRandomString(randomInt,RandomStringGenerator.Mode.ALPHANUMERIC);
		    					v1.put(fieldname,tempwriter);
		    					ffw.write(tempwriter);
					        	//////////////////
					        	} catch (Exception e) {e.printStackTrace();}
		    			}
		    			else
		    			{
		    				if(datatype.equalsIgnoreCase("alpha")||datatype=="alpha"||datatype.equalsIgnoreCase("free text")||datatype=="Free text")
		    				{
		    					try {
		    						tempwriter=RandomStringGenerator.generateRandomString(randomInt,RandomStringGenerator.Mode.ALPHA);
						        	ffw.write(tempwriter);
						        	v1.put(fieldname,tempwriter);
					        	} catch (Exception e) {e.printStackTrace();}
		    				}
		    				else
		    				{
		    					if(datatype.equalsIgnoreCase("numeric")||datatype=="Numeric")
		    					{
		    						if(datavalidation==null||datavalidation.equals("")||datavalidation==""||datavalidation==" ")
		    						{
		    								try {
		    									tempwriter=RandomStringGenerator.generateRandomString(randomInt,RandomStringGenerator.Mode.NUMERIC);
		    						        	ffw.write(tempwriter);
		    						        	v1.put(fieldname,tempwriter);
		    					        	
		    					        	} catch (Exception e) {e.printStackTrace();}
		    						}
		    						else 
		    						{
		    							if(datavalidation!=null)
		    							{
		    								String temp=datavalidation;
		    								while(temp.indexOf("#")>=0)
		    								{
		    									System.out.println("********************"+temp);
		    								try {
												temp = temp.replaceFirst("#",RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC));
											} catch (Exception e) {e.printStackTrace();}
		    								}
		    								
		    							ffw.write(temp);
		    							v1.put(fieldname,temp);
		    							
		    							}
		    						}
		    					}
		    					else
		    					{
		    						if(datatype.equalsIgnoreCase("date")||datatype=="Date")
		    						{
		    							if(datavalidation==null||datavalidation.equals("")||datavalidation==""||datavalidation==" ")
			    						{
			    								try {
			    								String a1,a2,a3;
			    								a1="201"+RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC)+"/";
			    					        	ffw.write(a1);
			    					        	Random randommois = new Random();
			    				    			int randomIntmois = randommois.nextInt(12-1+1) + 1;
			    				    			if(randomIntmois>=10) {a2=randomIntmois+"/";ffw.write(a2);}
			    				    			else {a2="0"+randomIntmois+"/";ffw.write(a2);}
			    					        	Random randomday = new Random();
			    				    			int randomIntday = randomday.nextInt(28-1+1) + 1;
			    				    			if(randomIntday>=10) {a3=randomIntday+"/";ffw.write(a3);}
			    				    			else {a3="0"+randomIntday;ffw.write(a3);}
			    				    			v1.put(fieldname,a1+a2+a3);
			    				    			
			    					        	} catch (Exception e) {e.printStackTrace();}
			    						}
		    							else
		    							{
		    								try {
		    									String a1,a2,a3;
			    								a1="201"+RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC)+"/";
			    					        	ffw.write(a1);
			    					        	Random randommois = new Random();
			    				    			int randomIntmois = randommois.nextInt(12-1+1) + 1;
			    				    			if(randomIntmois>=10) {a2=randomIntmois+"/";ffw.write(a2);}
			    				    			else {a2="0"+randomIntmois+"/";ffw.write(a2);}
			    					        	Random randomday = new Random();
			    				    			int randomIntday = randomday.nextInt(28-1+1) + 1;
			    				    			if(randomIntday>=10) {a3=randomIntday+"/";ffw.write(a3);}
			    				    			else {a3="0"+randomIntday;ffw.write(a3);}////////////////
			    				    			v1.put(fieldname,a1+a2+a3);
			    				    			
			    					        	} catch (Exception e) {e.printStackTrace();}
		    							}
		    							
		    						}
		    					}
		    				}
		    			}
		  
		    			break;
		    		case "O":
		    			System.out.println(length.split(":")[0].trim());System.out.println("****");
		    			System.out.println(length.split(":")[1].trim());System.out.println("****");
		    			int mino = Integer.parseInt(length.split(":")[0].trim());
		    			int maxo = Integer.parseInt(length.split(":")[1].trim());
		    			System.out.print("min:");System.out.println(mino);
		    			System.out.print("max:");System.out.println(maxo);
		    			Random random2 = new Random();
		    			int randomInt2 = random2.nextInt(maxo-mino+1) + mino;
		    			System.out.println("random :"+randomInt2);
		    			if(datatype.equalsIgnoreCase("alphanumeric") || datatype=="alphanumeric")
		    			{
		    					try {
		    						tempwriter=RandomStringGenerator.generateRandomString(randomInt2,RandomStringGenerator.Mode.ALPHANUMERIC);
						        	ffw.write(tempwriter);
						        	v1.put(fieldname,tempwriter);
						        	
		    					
					        	} catch (Exception e) {e.printStackTrace();}
		    			}
		    			else
		    			{
		    				if(datatype.equalsIgnoreCase("alpha")||datatype=="alpha"||datatype.equalsIgnoreCase("free text")||datatype=="Free text")
		    				{
		    					try {
		    						tempwriter=RandomStringGenerator.generateRandomString(randomInt2,RandomStringGenerator.Mode.ALPHA);
						        	ffw.write(tempwriter);
						        	v1.put(fieldname,tempwriter);
						        	
		    					
					        	} catch (Exception e) {e.printStackTrace();}
		    				}
		    				else
		    				{
		    					if(datatype.equalsIgnoreCase("numeric")||datatype=="Numeric")
		    					{
		    						if(datavalidation==null||datavalidation.equals("")||datavalidation==""||datavalidation==" ")
		    						{
		    								try {
		    									tempwriter=RandomStringGenerator.generateRandomString(randomInt2,RandomStringGenerator.Mode.NUMERIC);
		    						        	ffw.write(tempwriter);
		    						        	v1.put(fieldname,tempwriter);
		    						        	
		    								
		    					        	} catch (Exception e) {e.printStackTrace();}
		    						}
		    						else 
		    						{
		    							if(datavalidation!=null)
		    							{
		    								String temp=datavalidation;
		    								while(temp.indexOf("#")>=0)
		    								{
		    									System.out.println("********************"+temp);
		    								try {
												temp = temp.replaceFirst("#",RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC));
											} catch (Exception e) {e.printStackTrace();}
		    								}
		    							ffw.write(temp);
		    							v1.put(fieldname,temp);
		    							
		    							}
		    						}
		    					}
		    					else
		    					{
		    						if(datatype.equalsIgnoreCase("date")||datatype=="Date")
		    						{
		    							if(datavalidation==null||datavalidation.equals("")||datavalidation==""||datavalidation==" ")
			    						{
			    								try {
			    									String a1,a2,a3;
				    								a1="201"+RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC)+"/";
				    					        	ffw.write(a1);
				    					        	Random randommois = new Random();
				    				    			int randomIntmois = randommois.nextInt(12-1+1) + 1;
				    				    			if(randomIntmois>=10) {a2=randomIntmois+"/";ffw.write(a2);}
				    				    			else {a2="0"+randomIntmois+"/";ffw.write(a2);}
				    					        	Random randomday = new Random();
				    				    			int randomIntday = randomday.nextInt(28-1+1) + 1;
				    				    			if(randomIntday>=10) {a3=randomIntday+"/";ffw.write(a3);}
				    				    			else {a3="0"+randomIntday;ffw.write(a3);}
				    				    			v1.put(fieldname,a1+a2+a3);
				    				    				
			    								
			    					        	} catch (Exception e) {e.printStackTrace();}
			    						}
		    							else
		    							{
		    								try {
		    									String a1,a2,a3;
			    								a1="201"+RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC)+"/";
			    					        	ffw.write(a1);
			    					        	Random randommois = new Random();
			    				    			int randomIntmois = randommois.nextInt(12-1+1) + 1;
			    				    			if(randomIntmois>=10) {a2=randomIntmois+"/";ffw.write(a2);}
			    				    			else {a2="0"+randomIntmois+"/";ffw.write(a2);}
			    					        	Random randomday = new Random();
			    				    			int randomIntday = randomday.nextInt(28-1+1) + 1;
			    				    			if(randomIntday>=10) {a3=randomIntday+"/";ffw.write(a3);}
			    				    			else {a3="0"+randomIntday;ffw.write(a3);}
			    				    			v1.put(fieldname,a1+a2+a3);
			    				    			
			    					        	} catch (Exception e) {e.printStackTrace();}
		    							}
		    							
		    						}
		    					}
		    				}
		    			}
		    			break;
		    		case "C":
		    			if(logicvalidation.trim()!=null && logicvalidation.indexOf("then")>=0)
		    			{
		    				String[] x=logicvalidation.split(" ");
		    				System.out.println("logicvalidation"+logicvalidation+"***");
		    				//System.out.println("tostrinnnnnnnnnnnnng"+x.toString());
		    				for(int j=0;j<x.length;j++)
		    				{
		    					System.out.println("+++++"+x[j]);
		    				}
		    				
		    				if(x[1].indexOf("!=")>=0)
		    				{
		    						String col=x[1].substring(0, x[1].indexOf("!="));
		    						System.out.print("opppppppppppppp1"+col);
		    						String val=x[1].substring(x[1].indexOf("!=")+2);
		    						System.out.print("opppppppppppppp2"+val);
		    						if(val.equalsIgnoreCase("null")||val==null)
		    						{
		    							if(v1.get(col)!=null)
		    							{ 
		    								ffw.write(x[3]);
		    								v1.put(fieldname,x[3]); 
		    							}
		    						}
		    						else
		    						{
		    							if(v1.get(col).replaceAll(",",".")!=val.replaceAll(",","."))
		    							{ 
		    								ffw.write(x[3]);
		    								v1.put(fieldname,x[3]); 
		    							}
		    						}
		    				}
		    				else
		    				{
		    					if(x[1].indexOf(">")>=0)
			    				{
			    						String col=x[1].substring(0, x[1].indexOf(">"));
			    						System.out.print("opppppppppppppp1"+col);
			    						String val=x[1].substring(x[1].indexOf(">")+1);
			    						System.out.print("opppppppppppppp2"+val);
			    						
			    						if(Float.parseFloat(v1.get(col).replaceAll(",","."))>Float.parseFloat(val.replaceAll(",",".")))
		    							{ 
		    								ffw.write(x[3]);
		    								v1.put(fieldname,x[3]); 
		    							}
			    				
			    				}
		    					else
		    					{
		    						if(x[1].indexOf("<")>=0)
				    				{
				    						String col=x[1].substring(0, x[1].indexOf("<"));
				    						System.out.print("opppppppppppppp1"+col);
				    						String val=x[1].substring(x[1].indexOf("<")+1);
				    						System.out.print("opppppppppppppp2"+val);
				    						
				    						if(Float.parseFloat(v1.get(col).replaceAll(",","."))<Float.parseFloat(val.replaceAll(",",".")))
			    							{ 
			    								ffw.write(x[3]);
			    								v1.put(fieldname,x[3]); 
			    							}
				    				
				    				}
		    						else
		    						{
		    							if(x[1].indexOf(">=")>=0)
					    				{
					    						String col=x[1].substring(0, x[1].indexOf(">="));
					    						System.out.print("opppppppppppppp1"+col);
					    						String val=x[1].substring(x[1].indexOf(">=")+2);
					    						System.out.print("opppppppppppppp2"+val);
					    						
					    						if(Float.parseFloat(v1.get(col).replaceAll(",","."))>=Float.parseFloat(val.replaceAll(",",".")))
				    							{ 
				    								ffw.write(x[3]);
				    								v1.put(fieldname,x[3]); 
				    							}
					    				
					    				}
		    							else
		    							{
		    								if(x[1].indexOf("<=")>=0)
		    			    				{
		    			    						String col=x[1].substring(0, x[1].indexOf("<="));
		    			    						System.out.print("opppppppppppppp1"+col);
		    			    						String val=x[1].substring(x[1].indexOf("<=")+2);
		    			    						System.out.print("opppppppppppppp2"+val);
		    			    						
		    			    						if(Float.parseFloat(v1.get(col).replaceAll(",","."))<=Float.parseFloat(val.replaceAll(",",".")))
		    		    							{ 
		    		    								ffw.write(x[3]);
		    		    								v1.put(fieldname,x[3]); 
		    		    							}
		    			    				
		    			    				}
		    								else
		    								{
		    									if(x[1].indexOf("==")>=0)
		    				    				{
		    				    						String col=x[1].substring(0, x[1].indexOf("=="));
		    				    						System.out.print("opppppppppppppp1"+col);
		    				    						String val=x[1].substring(x[1].indexOf("==")+2);
		    				    						System.out.print("opppppppppppppp2"+val);
		    				    						
		    				    						if(Float.parseFloat(v1.get(col).replaceAll(",","."))==Float.parseFloat(val.replaceAll(",",".")))
		    			    							{ 
		    			    								ffw.write(x[3]);
		    			    								v1.put(fieldname,x[3]); 
		    			    							}
		    				    				
		    				    				}
		    									
		    								}
		    							}
		    						}
		    					}
		    				}
		    			
		    				
		    				
		    				
		    				
		    				
		    				
		    			}
		    			else
		    			{
		    				System.out.println(length.split(":")[0].trim());System.out.println("****");
			    			System.out.println(length.split(":")[1].trim());System.out.println("****");
			    			int minc = Integer.parseInt(length.split(":")[0].trim());
			    			int maxc = Integer.parseInt(length.split(":")[1].trim());
			    			System.out.print("min:");System.out.println(minc);
			    			System.out.print("max:");System.out.println(maxc);
			    			Random random3 = new Random();
			    			int randomInt3 = random3.nextInt(maxc-minc+1) + minc;
			    			System.out.println("random :"+randomInt3);
			    			if(datatype.equalsIgnoreCase("alphanumeric") || datatype=="alphanumeric")
			    			{
			    					try {
			    						tempwriter=RandomStringGenerator.generateRandomString(randomInt3,RandomStringGenerator.Mode.ALPHANUMERIC);
							        	ffw.write(tempwriter);
							        	v1.put(fieldname,tempwriter);
							        	
			    					
						        	} catch (Exception e) {e.printStackTrace();}
			    			}
			    			else
			    			{
			    				if(datatype.equalsIgnoreCase("alpha")||datatype=="alpha"||datatype.equalsIgnoreCase("free text")||datatype=="Free text")
			    				{
			    					try {
			    						tempwriter=RandomStringGenerator.generateRandomString(randomInt3,RandomStringGenerator.Mode.ALPHA);
							        	ffw.write(tempwriter);
							        	v1.put(fieldname,tempwriter);
							        	
			    					
						        	} catch (Exception e) {e.printStackTrace();}
			    				}
			    				else
			    				{
			    					if(datatype.equalsIgnoreCase("numeric")||datatype=="Numeric")
			    					{
			    						if(datavalidation==null||datavalidation.equals("")||datavalidation==""||datavalidation==" ")
			    						{
			    								try {
			    									tempwriter=RandomStringGenerator.generateRandomString(randomInt3,RandomStringGenerator.Mode.NUMERIC);
			    						        	ffw.write(tempwriter);
			    						        	v1.put(fieldname,tempwriter);
			    						        	
			    								
			    					        	} catch (Exception e) {e.printStackTrace();}
			    						}
			    						else 
			    						{
			    							if(datavalidation!=null)
			    							{
			    								String temp=datavalidation;
			    								while(temp.indexOf("#")>=0)
			    								{
			    									System.out.println("********************"+temp);
			    								try {
													temp = temp.replaceFirst("#",RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC));
												} catch (Exception e) {e.printStackTrace();}
			    								}
			    							ffw.write(temp);
			    							v1.put(fieldname,temp);
			    							
			    							}
			    						}
			    					}
			    					else
			    					{
			    						if(datatype.equalsIgnoreCase("date")||datatype=="Date")
			    						{
			    							if(datavalidation==null||datavalidation.equals("")||datavalidation==""||datavalidation==" ")
				    						{
				    								try {
				    									String a1,a2,a3;
					    								a1="201"+RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC)+"/";
					    					        	ffw.write(a1);
					    					        	Random randommois = new Random();
					    				    			int randomIntmois = randommois.nextInt(12-1+1) + 1;
					    				    			if(randomIntmois>=10) {a2=randomIntmois+"/";ffw.write(a2);}
					    				    			else {a2="0"+randomIntmois+"/";ffw.write(a2);}
					    					        	Random randomday = new Random();
					    				    			int randomIntday = randomday.nextInt(28-1+1) + 1;
					    				    			if(randomIntday>=10) {a3=randomIntday+"/";ffw.write(a3);}
					    				    			else {a3="0"+randomIntday;ffw.write(a3);}
					    				    			v1.put(fieldname,a1+a2+a3);
					    				    				
				    								
				    					        	} catch (Exception e) {e.printStackTrace();}
				    						}
			    							else
			    							{
			    								try {
			    									String a1,a2,a3;
				    								a1="201"+RandomStringGenerator.generateRandomString(1,RandomStringGenerator.Mode.NUMERIC)+"/";
				    					        	ffw.write(a1);
				    					        	Random randommois = new Random();
				    				    			int randomIntmois = randommois.nextInt(12-1+1) + 1;
				    				    			if(randomIntmois>=10) {a2=randomIntmois+"/";ffw.write(a2);}
				    				    			else {a2="0"+randomIntmois+"/";ffw.write(a2);}
				    					        	Random randomday = new Random();
				    				    			int randomIntday = randomday.nextInt(28-1+1) + 1;
				    				    			if(randomIntday>=10) {a3=randomIntday+"/";ffw.write(a3);}
				    				    			else {a3="0"+randomIntday;ffw.write(a3);}
				    				    			v1.put(fieldname,a1+a2+a3);
				    				    			
				    					        	} catch (Exception e) {e.printStackTrace();}
			    							}
			    							
			    						}
			    					}
			    				}
			    			}
		    			}
		    			
		    			
		    			break;
		    		
		    		default :
		    		}
		        	/////////////////////////////////////////////
		        	/*try {
		        	ffw.write(RandomStringGenerator.generateRandomString(10,RandomStringGenerator.Mode.ALPHANUMERIC));
		        	} catch (Exception e) {e.printStackTrace();}*/
		        	/////////////////////////////////////////////
		        
		        }
		        
		        if(format.equalsIgnoreCase("csv"))
		        {
		        	ffw.write(";");
		        }
		        else
		        ffw.write(" ");
		     }
		    
		     ffw.write("\r\n");
		     //ffw.write("\n");// forcer le passage à la ligne
  }//fin générer 20 lignes
		     
         	ffw.close(); // fermer le fichier à la fin des traitements    
		  
         System.out.println("this is it********"+v1.toString());	
         
         
         //download au cas où c'est input device
        if(media.equalsIgnoreCase("input device")||(media.equalsIgnoreCase("inputdevice")))
        {
        	
     			RequestDispatcher rd = request.getRequestDispatcher("/DownloadFile");
    			rd.forward(request, response);
     	}
     		
        else
        {
        	RequestDispatcher rd = request.getRequestDispatcher("/Schedular.jsp");
			rd.forward(request, response);
        }
         
         
        
         
         
         
         
         
         
         
         
         
         
         
         	
	}

}
