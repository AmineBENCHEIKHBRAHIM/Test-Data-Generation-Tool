<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" href="styles/style2.css">
<link rel="stylesheet" href="styles/styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="js/script.js"></script>
</head>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@page import="classes.DatabaseConnection" %>

<body>
<div id='cssmenu'>
<ul>
   <li><a href='index.jsp'><span>Home</span></a></li>
   <li class='active'><a href='#'><span>Liste Spec</span></a></li>
   <li><a href='#'><span>Configuration</span></a></li>
   <li ><a href='#'><span>Génération</span></a></li>
   <li><a href='#'><span>Schedular</span></a></li>
   <li class='last'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
</ul>
</div>

<!-- ####################################################################################################### -->


      <div id="comments"> 
        <ul class="commentlist">
		  <h2>Liste des spécifications</h2>
	<% 
	
	ResultSet resultat = (java.sql.ResultSet)request.getAttribute("filelist");
	//ResultSet resultat2 = (java.sql.ResultSet)request.getAttribute("idlist");
	//response.sendRedirect("index2.jsp");
	while(resultat.next()){
		int idfile = resultat.getInt(1);
		String nom = resultat.getString(2);
		String path = resultat.getString(3);
		int row = resultat.getRow();
		int bool = 0;
		//request.setAttribute("path", path);
		//request.setAttribute("nomfile", nom);
		
			String query2 = "select id from configuration where id="+idfile+";";
			DatabaseConnection dbconn = new DatabaseConnection();
			Connection conn = dbconn.setConnection();
			ResultSet res = dbconn.getResult(query2, conn);
			while(res.next()){
				bool=1;
			}
		
		
		
		%>
	<div style="background-color:#E5E4E2; text-align: left; border: 1px solid #D1D0CE; opacity:0.7;">
		
		<li class="comment_odd">
            <div class="author"><span class="name"><a href="#"><%=nom %></a></span> </div>
            
           
            <strong>
					<form action="SupprimerFile" method="post">
					<input type="hidden" id="id" name="id" value="<%=idfile%>">
					<input type="hidden" id="path" name="path" value="<%=path%>">
					<input type="hidden" id="filename" name="filename" value="<%=nom%>">
					<input type="submit" value="Supprimer ">
<br>
<br>
	</form>
			</strong>
			<form action="AfficherConfig" method="post">
			<input type="hidden" id="id" name="id" value="<%=idfile%>">
			<input type="hidden" id="path" name="path" value="<%=path%>">
			<input type="hidden" id="filename" name="filename" value="<%=nom%>">
			<input type="hidden" id="bool" name="bool" value="<%=bool %>">
			<%if(bool==0){ %>
	      <input type="submit" value="Configuration">
	      <%} else{ %>
	    
	      <input type="submit" value="Afficher Configuration déjà définie">
	      
	      <%bool=0;} %>
	             </form>
         </li>
         </div>
         <br>
		<%}
	//response.sendRedirect("index2.jsp");
	%>

	
        </ul>
      </div>
</body>
</html>