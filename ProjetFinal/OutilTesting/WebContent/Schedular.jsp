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
   <li ><a href='#'><span>Configuration</span></a></li>
   <li ><a href='#'><span>Génération</span></a></li>
   <li class='active'><a href='#'><span>Schedular</span></a></li>
   <li class='last'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
</ul>
</div>
<br><br><br>
<%
String media = (String)request.getAttribute("media");
String format = (String)request.getAttribute("format");
String filepath =(String) request.getAttribute("generatedfilepath");
String outputfile = (String) request.getAttribute("outputfile");

request.setAttribute("media",media);
request.setAttribute("format",format);
request.setAttribute("generatedfilepath",filepath);
request.setAttribute("outputfile",outputfile);

%>

<center>
<form method="post" action="http://localhost:8080/OutilTesting/SchedularRedirect">
<label>Secondes: </label><input type="text" name="secondes" maxlength="2" size="2"/>
<label>Minutes: </label><input type="text" name="minutes" maxlength="2" size="2"/>
<label>Heures: </label><input type="text" name="heures" maxlength="2" size="2"/><br/><br><br>
<label>Jour: </label><input type="text" name="jour" maxlength="2" size="2"/>
<label>Mois: </label><input type="text" name="mois" maxlength="2" size="2"/>
<label>Année: </label><input type="text" name="annee" maxlength="4" size="4"/><br/><br><br>
<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="generatedfilepath" value="<%=filepath %>">
<input type="hidden" name="outputfile" value="<%=outputfile %>">
<input type="submit" value="Envoyer plus tard"/>
</form>
<br>
<form method="post" action="http://localhost:8080/OutilTesting/SchedularRedirect">

<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="generatedfilepath" value="<%=filepath %>">
<input type="hidden" name="outputfile" value="<%=outputfile %>">
<input type="submit" value="Envoyer maintenant"/>
</form>

</center>
</body>
</html>