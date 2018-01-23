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
			<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="etusivu">Etusivu</a></li>
						<li><a href="PizzalistaController?">Pizzalista</a></li>
						<li class="active"><a href="TilauslistaController?">Tilauslista</a></li>
						<li><a href="PizzanTilausController?">Pizzantilaus</a></li> 				
						
					</ul>
					<ul class="nav navbar-nav navbar-right">

					</ul>
				
					<ul class="nav navbar-nav navbar-right">
					<li><a href="ostoskori"> <img src="images/ostoskori.png" alt="Ostoskori" height="20" width="20" /> Ostoskoriin</a></li>
				
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">



			
							<c:forEach items="${tilaukset}" var="tilaus">	
							<c:choose>
		<c:when test="${(tilaus.tilausId) % 2 == 0}">
		    <div id="pizzalistavari1">
		</c:when>
		<c:otherwise>
		    <div id="pizzalistavari2">
		    </c:otherwise>
		</c:choose>
							
		<h2><strong>TilausID:</strong><c:out value=" ${tilaus.tilausId}" /></h2>
		
		
														
      	<div class="row">
		<div class="col-xs-6 col-md-6">
        
        <strong>Etunimi:</strong> <c:out value=" ${tilaus.etunimi}" /><br>
        
        <strong>Osoite:</strong> <c:out value=" ${tilaus.lahiosoite}" /><br>
        
        <strong>Postitmp:</strong> <c:out value=" ${tilaus.postitmp}"/><br>
        
        <strong>Hinta</strong> <c:out value=" ${tilaus.hinta}"/> €<br>
        
        
        </div>
        <div class="col-xs-6 col-md-6">
        <strong>Sukunimi:</strong> <c:out value=" ${tilaus.sukunimi}"/><br>
        <strong>Postinro:</strong> <c:out value=" ${tilaus.postinro}"/><br>
        <strong>Puhelin:</strong> <c:out value=" ${tilaus.puhelinnro}"/><br>
        </div>
        </div>
        <br>
       <strong>Lisätiedot:</strong> <c:out value=" ${tilaus.lisatiedot}"/><br> <br>
       
       <form action="MuutaStatusController2" method="post">
								<input type="hidden" name="id" value="<c:out value="${tilaus.tilausId}"/>">
								<input type="hidden" name="statusid" value="<c:out value="${tilaus.statusid}"/>">							
								
																	<c:choose>
										<c:when test="${(tilaus.statusid) == 1}">
										<button type="submit" class="btn btn-danger"style="width: 100%">Ei aloitettu</button>
										</c:when>
										<c:when test="${(tilaus.statusid) == 2}">
										<button type="submit" class="btn btn-warning"style="width: 100%">Matkalla</button>
										</c:when>
									<c:otherwise>
									    <button type="submit" class="btn btn-success"style="width: 100%">Toimitettu</button>
									    </c:otherwise>
									</c:choose>
								
								</form>
       
       
		</div>
		 </c:forEach>
					
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
