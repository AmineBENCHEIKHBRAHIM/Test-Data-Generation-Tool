<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>upload</title>
<link rel="stylesheet" href="styles/style2.css">
<link rel="stylesheet" href="styles/styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="js/script.js"></script>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li class='active'><a href='index.jsp'><span>Home</span></a></li>
   <li><a href='#'><span>Liste Spec</span></a></li>
   <li><a href='#'><span>Configuration</span></a></li>
   <li ><a href='#'><span>Génération</span></a></li>
   <li><a href='#'><span>Schedular</span></a></li>
   <li class='last'><a href='#'><span>Envoie</span></a></li>
   <li class='last'><a href="http://localhost:8080/OutilTesting/Deconnexion"><span>Déconnexion</span></a></li>
</ul>
</div>
<br>
<br>
<!--  <FORM METHOD=POST ACTION="http://localhost:8080/OutilTesting/Deconnexion">
<INPUT TYPE=SUBMIT VALUE=Deconnexion>
</FORM>-->
<!-- ####################################################################################################### -->
<br><br><br>	
	
<form action="UploadFile" method="post" enctype="multipart/form-data">
<center><B>	select file : </B><input type="file" name="filetoupload">
	<input type="submit" value="Upload File !"></center>
</form>
<br>
<br>
<br>
<br>
<br>
<form action="DisplayData" method="post">
	<center><input type="submit" value="Liste des spécifications !"></center>
</form>
<br>
<br>

<br>
<p></p>
</body>
</html>