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
   <li ><a href='#'><span>Schedular</span></a></li>
   <li class='active'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
</ul>
</div>
<br><br>
<%
String media = (String) request.getAttribute("media");
String format = (String)request.getAttribute("format");
String filepath = (String)request.getAttribute("generatedfilepath");
String outputfile = (String) request.getAttribute("outputfile");

String secondes = (String)request.getAttribute("secondes");
String minutes = (String)request.getAttribute("minutes");
String heures = (String)request.getAttribute("heures");
String jour = (String)request.getAttribute("jour");
String mois = (String)request.getAttribute("mois");
String annee = (String)request.getAttribute("annee");



%>
<center>
<form method="post" action="http://localhost:8080/OutilTesting/QueueParameters">
<label>Host :    <input type="text" name="host"/></label><br/><br>
<label>Username : <input type="text" name="username"/></label><br/><br>
<label>Password : <input type="password" name="password"/></label><br/><br>
<label>Queue-Name: <input type="text" name="port"/></label><br/><br>
<input type="hidden" name="media" value="<%=media %>">
<input type="hidden" name="format" value="<%=format %>">
<input type="hidden" name="generatedfilepath" value="<%=filepath %>">
<input type="hidden" name="outputfile" value="<%=outputfile %>">
<input type="hidden" name="secondes" value="<%=secondes %>">
<input type="hidden" name="minutes" value="<%=minutes %>">
<input type="hidden" name="heures" value="<%=heures %>">
<input type="hidden" name="jour" value="<%=jour %>">
<input type="hidden" name="mois" value="<%=mois %>">
<input type="hidden" name="annee" value="<%=annee %>">
<input type="submit" value="Envoyer"/>
</form>
</center>
</body>
</html>