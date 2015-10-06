package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPFunctions {
	
	FTPClient ftp= null;
	
	public  FTPFunctions(String host, int port, String username, String password) throws Exception{
		
		ftp=new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host, port);
		System.out.println("FTP URL is:"+ftp.getDefaultPort());
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			 ftp.disconnect();
			 throw new Exception("Exception in connecting to ftp server");
		}
		
		ftp.login(username, password);
		 ftp.setFileType(FTP.BINARY_FILE_TYPE);
		 ftp.enterLocalPassiveMode();  
	}
	public void uploadFTPFile(String localFileFullName, String fileName, String hostDir) throws Exception{
		
     try {
			 InputStream input = new FileInputStream(new File(localFileFullName));
			 this.ftp.storeFile(hostDir + fileName, input);
		 }
		 catch(Exception e){
			 
		 }
		
		}
	
	
	public void disconnect(){ 
		 if (this.ftp.isConnected()) { 
			try { this.ftp.logout();
			this.ftp.disconnect();
			} 
			
			catch (IOException f) {
			// do nothing as file is already saved to server
		 }
	 }
 }
	 public static void main(String[] args) { 
		try { FTPFunctions ftpobj = new FTPFunctions("127.0.0.1", 21, "admin", "admin");
		ftpobj.uploadFTPFile("c:/filesource/shuriti.txt", "Shruti.txt", "/"); 
          ftpobj.disconnect();
		
		} 
		catch (Exception e) { e.printStackTrace(); } 
		
	 }
	 
	
}
