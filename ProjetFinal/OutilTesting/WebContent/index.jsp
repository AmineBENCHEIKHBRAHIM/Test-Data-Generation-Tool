<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>

   <link rel="stylesheet" href="styles/styles.css">
   <link rel="stylesheet" href="styles/style.css"/>
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="js/script.js"></script>
   <style> 
label
{
	display: block;
	width: 150px;
	float: center;
}</style>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li class='active'><a href='index.jsp'><span>Home</span></a></li>
   <!--  <li><a href='index.jsp'><span>Liste Spec</span></a></li>
   <li><a href='index.jsp'><span>Configuration</span></a></li>
   <li ><a href='index.jsp'><span>Génération</span></a></li>
   <li><a href='index.jsp'><span>Schedular</span></a></li>
   <li class='last'><a href='index.jsp'><span>Envoie</span></a></li>-->
  <!--   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
-->
</ul>
</div>
<br>
<br>
<br>
<center><B><FONT COLOR="white">Bienvenu dans notre outil de Test</FONT></B></center><br>
<%
//session= request.getSession();
session.setMaxInactiveInterval(50);

//if(session.isNew())
//{
%>
<br>
<center><B><FONT COLOR="white">Veuillez connecter vous pour Accéder à l'outil </FONT></B></center><br>
<center>
<br><br>
<form method="post" action="http://localhost:8080/OutilTesting/identification">
<label for="login"><FONT COLOR="white">Login:</FONT></label><input type="text" name="login"/><br />
<label for="passe"><FONT COLOR="white">Password: </FONT></label><input type="password" name="passe"/><br />
<!-- <label for="passe"><FONT COLOR="white">Password: </FONT></label><input type="password" name="passe"/><br /> -->
<%
if(request.getAttribute("etat")!=null)
out.println(request.getAttribute("etat")); %>

<br>
<input type="submit" value="connexion"/>
</form>

</center>


<%
//}

//else{
	
%>
<!--  <center>
<B>Bonjour<%= session.getAttribute("login") %></B>

<FORM METHOD=POST ACTION="http://localhost:8080/OutilTesting/Deconnexion">
<INPUT TYPE=SUBMIT VALUE=Deconnexion>
</FORM>
</center>

-->



<%//}
%>

<!--  Salon de discusion
<FORM METHOD=POST ACTION='http://localhost:8080/TP-NOTE-1/Salon.jsp'>
<INPUT TYPE=SUBMIT VALUE=Salon>
</FORM>
-->
</body>
</html>