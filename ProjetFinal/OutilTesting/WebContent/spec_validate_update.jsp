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
   <li ><a href='#'><span>G�n�ration</span></a></li>
   <li><a href='#'><span>Schedular</span></a></li>
   <li class='last'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>D�connexion</span></a></li>
</ul>
</div>

<p>
<%
String format = (String) request.getAttribute("format");
/*String inout = (String) request.getAttribute("inout");
String realtimebatch = (String) request.getAttribute("realtimebatch");
String timesofday = (String) request.getAttribute("timesofday");
String volume = (String) request.getAttribute("volume");
String checksum = (String) request.getAttribute("checksum");
String encoding = (String) request.getAttribute("encoding");*/
String media = (String) request.getAttribute("media");

String filename = (String) request.getAttribute("filename");
String filepath = (String) request.getAttribute("filepath");

/*String id = request.getAttribute("id").toString();
int idint = Integer.parseInt(id);*/
request.setAttribute("format", format);
request.setAttribute("media", media);
request.setAttribute("filename", filename);
request.setAttribute("filepath", filepath);
%>
<h1><center>Param�tres de sp�cification de <%=filename %></center></h1>
<Strong>Filename : </Strong><%=filename %> <br>

<Strong>format :</Strong> <%=format %><br>

<Strong>media :</Strong> <%=media %><br>

<Strong>Filepath :</Strong> <%=filepath %><br>

</p>

<form method="post" action="http://localhost:8080/OutilTesting/generer.jsp">
<input type="hidden" name="filename" value="<%=filename %>">
<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="filepath" value="<%=filepath %>">
<input type="submit" value="Validate"/>

</form>

<form method="post" action="http://localhost:8080/OutilTesting/spec_update.jsp">
<input type="hidden" name="filename" value="<%=filename %>">
<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="filepath" value="<%=filepath %>">
<input type="submit" value="Update"/>
</form>





</body>
</html>