<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial	-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Harton pizza</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/tyyli.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="navbar.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">
			<a href="surprise">
		<img src="images/logo.png" class="img-responsive center-block"
			alt="Responsive image" />
			</a>
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>
					<!--Navigointipalkin linkkien painikkeet ovat tässä-->
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="etusivu">Etusivu</a></li>
						<li><a href="PizzalistaController">Pizzalista</a></li>
						
					</ul>
					<!--Tämän kommentin alla ovat oikealla olevat linkit-->
					<ul class="nav navbar-nav navbar-right">
					<li> <a href="ostoskori"> <img src="images/ostoskori.png" alt="Ostoskori" height="20" width="20" /><strong> ${pizzojenmaara}</strong> Ostoskoriin</a></li>
				
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">



	
		

				
									
									
									<table class="table table-hover">
    <thead>
      <tr>
        <th>Pizzanumero</th>
        <th>Pizzan nimi</th>
        <th>Sisältö</th>
        <th>Hinta</th>
      </tr>
    </thead>
       
    <tbody>
    
    <!--Tulostetaan sivulle kaikki ostoskorissa olevat pizzat-->
    <c:forEach items="${ostoskori}" var="ostoskori">
      <tr>
        <td><c:out value=" ${ostoskori.tunnus}" /></td>
        <td><c:out value=" ${ostoskori.nimi}" /></td>
        <td><c:out value=" ${ostoskori.sisalto}" /></td>
        <td><fmt:formatNumber value="${ostoskori.hinta}" minFractionDigits="2"></fmt:formatNumber> €</td>
		<td>
		<form action="PoistaOstoskoristaController" method="post">
		<input type="hidden" name="id" value="<c:out value="${ostoskori.tunnus}"/>"> 
		<button type="submit" class="btn btn-danger">X</button>
        </form>
        </td>
      </tr>
       </c:forEach>
       <!--Ostoskori päättyy-->

    </tbody>
    
    
   
  </table>
  <hr>
  <h2>
  <strong>
    Yhteensä: 
    <fmt:formatNumber value="${yhteishinta}" minFractionDigits="2"></fmt:formatNumber> €
    
    </strong>
    </h2>
  <br>
  <br>
  <!--Form alkaa tästä. Kun tilaa nappia painaa niin tiedot lähetetään LahetaTilausController.javaan.-->
  <form action="laheta_tilaus" method="post"> 
			
Etunimi<br>	
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <input type="text" name="etunimi"maxlength="20" class="form-control" placeholder="Etunimi">
  </div>
</div>
Sukunimi<br>
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <input type="text" name="sukunimi"maxlength="30" class="form-control" placeholder="Sukunimi">
  </div>
</div>

Lähiosoite<br>
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <input type="text" name="lahiosoite"maxlength="30" class="form-control" placeholder="Lähiosoite">
  </div>
</div>

Postinumero<br>
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <input type="text" name="postinumero"maxlength="5" class="form-control" placeholder="Postinumero">
  </div>
</div>

Postitoimipaikka<br>
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <input type="text" name="postitmp"maxlength="20" class="form-control" placeholder="Postitoimipaikka">
  </div>
</div>



Puhelin<br>
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <input type="text" name="puhelin"maxlength="15" class="form-control" placeholder="Puhelin">
  </div>
</div>

Lisätiedot (max.200 merkkiä)<br>
<div class="row">
  <div class="col-xs-12 col-md-8 col-lg-6">
    <textarea rows="5" name="lisatiedot" maxlength="200" class="form-control" placeholder="Lisätiedot"></textarea>
  </div>
</div>
<br>

<c:choose>
		<c:when test="${(pizzojenmaara) > 0}">
		    
		    <button type="submit" class="btn btn-success">Tilaa!</button>
		</c:when>
		<c:otherwise>
		    <h2>Lisää ensin pizza ostoskoriin!</h2>
		    </c:otherwise>
		</c:choose>


</form>
<!--Tilaus form päättyy-->
									
									
									
									
									
										
								
								
							

						

					
				</div>
				<!-- jumbotron -->
			</div>
			<!-- /container -->


			<!-- Bootstrap core JavaScript
    ================================================== -->
			<!-- Placed at the end of the document so the pages load faster -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
			<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
