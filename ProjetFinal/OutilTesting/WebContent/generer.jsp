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
   <li><a href='#'><span>Configuration</span></a></li>
   <li  class='active'><a href='#'><span>Génération</span></a></li>
   <li><a href='#'><span>Schedular</span></a></li>
   <li class='last'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
</ul>
</div>
<p>
<%
/*String format = (String) request.getAttribute("format");
String inout = (String) request.getAttribute("inout");
String realtimebatch = (String) request.getAttribute("realtimebatch");
String timesofday = (String) request.getAttribute("timesofday");
String volume = (String) request.getAttribute("volume");
String checksum = (String) request.getAttribute("checksum");
String encoding = (String) request.getAttribute("encoding");
String media = (String) request.getAttribute("media");

String filename = (String) request.getAttribute("filename");
String filepath = (String) request.getAttribute("filepath");

String id = request.getAttribute("id").toString();
int idint = Integer.parseInt(id);*/
%>
<%
String format = (String) request.getParameter("format");
/*String inout = (String) request.getAttribute("inout");
String realtimebatch = (String) request.getAttribute("realtimebatch");
String timesofday = (String) request.getAttribute("timesofday");
String volume = (String) request.getAttribute("volume");
String checksum = (String) request.getAttribute("checksum");
String encoding = (String) request.getAttribute("encoding");*/
String media = (String) request.getParameter("media");

String filename = (String) request.getParameter("filename");
String filepath = (String) request.getParameter("filepath");

/*String id = request.getAttribute("id").toString();
int idint = Integer.parseInt(id);*/
request.setAttribute("format", format);
request.setAttribute("media", media);
request.setAttribute("filename", filename);
request.setAttribute("filepath", filepath);
%>


</p>
<br><br><br><br>
<center>

<p>
   <input type="checkbox" id="test1">
   <label for="test1">Envoyer mail de notification</label>
</p>
<br>
<p>
   <input type="checkbox" id="test1">
   <label for="test1">Envoyer par batch</label>
</p>
<br><br><br>

<form method="post" action="http://localhost:8080/OutilTesting/ValiderSpec">
<input type="hidden" name="filename" value="<%=filename %>">
<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="path" value="<%=filepath %>">
<input type="submit" value="Générer fichier test"/>

</form>

<%
if(media.equalsIgnoreCase("inputdevice")||media.equalsIgnoreCase("input device"))
{
%>
<form method="post" action="http://localhost:8080/OutilTesting/Deconnexion">
<input type="hidden" name="filename" value="<%=filename %>">
<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="path" value="<%=filepath %>">
<input type="submit" value="Quitter"/>

</form>
<%
}
%>





</center>
</body>
</html>