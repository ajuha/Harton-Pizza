<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
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
<%
	int keskeneraisetpizzat = 0;
%>
<body>

	<div class="container">
		<a href="surprise"> <img src="images/logo.png"
			class="img-responsive center-block" alt="Responsive image" />
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
						<li><a href="TilauslistaController?">Tilauslista</a></li>
						<li class="active"><a href="PizzanTilausController?">Pizzantilaus</a></li>

					</ul>
					<ul class="nav navbar-nav navbar-right">

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="ostoskori"> <img src="images/ostoskori.png"
								alt="Ostoskori" height="20" width="20" /> Ostoskoriin
						</a></li>

					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<c:forEach items="${pizzantilaukset}" var="pizzantilaukset">

			<c:choose>
				<c:when test="${(pizzantilaukset.statusid) != 3}">
					<%
						keskeneraisetpizzat = keskeneraisetpizzat + 1;
					%>
				</c:when>
			</c:choose>

		</c:forEach>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">


			<img
				src="images/<%if (keskeneraisetpizzat == 0) {
				out.print("doom1.PNG");
			} else if (keskeneraisetpizzat < 3) {
				out.print("doom2.PNG");
			} else if (keskeneraisetpizzat < 5) {
				out.print("doom3.PNG");
			} else if (keskeneraisetpizzat < 8) {
				out.print("doom4.PNG");
			} else if (keskeneraisetpizzat < 10) {
				out.print("doom5.PNG");
			} else {
				out.print("doom6.PNG");
			}%>"
				class="img-responsive center-block" alt="Responsive image" style="" />



			<div class="row">
				<div class="col-md-4">



					<div class="table-responsive"></div>
				</div>








				<table class="table table-hover">
					<thead>
						<tr>
							<th><h2>ID</h2></th>
							<th><h2>Tilaus ID</h2></th>
							<th><h2>pizza ID</h2></th>
							<th><h2>Status ID</h2></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${pizzantilaukset}" var="pizzantilaukset">
							<tr>
								<td><h2>
										<c:out value=" ${pizzantilaukset.id}" />
									</h2></td>
								<td><h2>
										<c:out value=" ${pizzantilaukset.tilausid}" />
									</h2></td>
								<td><h2>
										<c:out value=" ${pizzantilaukset.pizzaid}" />
									</h2></td>

								<td>
									<form action="MuutaStatusController" method="post">
										<input type="hidden" name="id"
											value="<c:out value="${pizzantilaukset.id}"/>"> <input
											type="hidden" name="statusid"
											value="<c:out value="${pizzantilaukset.statusid}"/>">

										<c:choose>
											<c:when test="${(pizzantilaukset.statusid) == 1}">
												<button type="submit" class="btn btn-danger"
													style="width: 100%; height: 50px">Ei aloitettu</button>
											</c:when>
											<c:when test="${(pizzantilaukset.statusid) == 2}">
												<button type="submit" class="btn btn-warning"
													style="width: 100%; height: 50px">Keskeneräinen</button>
											</c:when>
											<c:otherwise>
												<button type="submit" class="btn btn-success"
													style="width: 100%; height: 50px">Valmis</button>
											</c:otherwise>
										</c:choose>

									</form>




								</td>

							</tr>
						</c:forEach>
					</tbody>

				</table>






			</div>







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
