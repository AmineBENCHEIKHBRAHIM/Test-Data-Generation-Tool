<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style2.css">
<link rel="stylesheet" href="styles/styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li ><a href='index.jsp'><span>Home</span></a></li>
   <li><a href='#'><span>Liste Spec</span></a></li>
   <li class='active'><a href='#'><span>Configuration</span></a></li>
   <li ><a href='#'><span>Génération</span></a></li>
   <li><a href='#'><span>Schedular</span></a></li>
   <li class='last'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
</ul>
</div>
<h1>This is spec_update page</h1>

<%
String format = request.getParameter("format");
String media = request.getParameter("media");
String filename = request.getParameter("filename");
String filepath = request.getParameter("filepath");
%>
<p>These are the current spec parameters : </p>
Format : <%=format %><br>
Media : <%=media %><br>
Filename : <%=filename %><br>

<h1>Enter the new parameters : </h1>
<form method="post" action="http://localhost:8080/OutilTesting/UpdateSpec">
<label>Format : <input type="text" name="format"/></label><br/>
<label>Media : <input type="text" name="media"/></label><br/>
<input type="hidden" name="filepath" value="<%=filepath %>">
<input type="hidden" name="filename" value="<%=filename %>">
<input type="submit" value="Next"/>
</form>
</body>
</html>