<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

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
						<li class="active"><a href="etusivu">Etusivu</a></li>
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
			<h2>Tervetuloa Harton Pizzan kotisivuille!</h2>
			<h2>Viihtyisä ravintolamme sijaitsee Hartolan keskustassa. <br><strong>Tervetuloa ruokailemaan!</strong></h2>
			
			
			
			
			<br>
			
			<div class="row">
			<!--Määritellään siten että yhteystiedot vievät leveydeltään 4 paikkaa tilaa työpöytäversiossa (12 maksimi) -->
				<div class="col-md-4">
					
					<!--Yhteystietoboxi-->
					<div id="yhteystiedot">
						Keskustie 58 <br> 01900 Hartola <br> Puh: 044 02395834<br>
						carlos@hartonpizza.com
					</div>
					<!--Yhteystietoboxi päättyy-->
					
					

					
					
	
	<!--Tämä koodi selvittää, mikä arkipäivä tänään on. 1 = sunnuntai 2 = maanantai  3 = tiistai jne. Tällä saadaan aukioloajat toimintaan-->
	<%
	Date date = new Date();
	
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	
%>



					<!--Aukioloajat-->
					<div class="table-responsive">
						<h2>Aukioloajat</h2>
						<table class="table table-bordered">
						<!--Tässä väritetään if-lauseella päivä vihreäksi, jos tänään on kyseinen päivä-->
							<tbody>
								<tr class="<% if (dayOfWeek == 2){out.print("success");}else{out.print("active");}%>">
									<td>Maanantai</td>
									<td>SULJETTU</td>

								</tr>
								<tr class="<% if (dayOfWeek == 3){out.print("success");}else{out.print("active");}%>">
									<td>Tiistai</td>
									<td>8-20</td>

								</tr>
								<tr class="<% if (dayOfWeek == 4){out.print("success");}else{out.print("active");}%>">
									<td>Keskiviikko</td>
									<td>8-20</td>

								</tr>
								<tr class="<% if (dayOfWeek == 5){out.print("success");}else{out.print("active");}%>">
									<td>Torstai</td>
									<td>8-20</td>

								</tr>
								<tr class="<% if (dayOfWeek == 6){out.print("success");}else{out.print("active");}%>">
									<td>Perjantai</td>
									<td>8-20</td>

								</tr>
								<tr class="<% if (dayOfWeek == 7){out.print("success");}else{out.print("active");}%>">
									<td>Lauantai</td>
									<td>8-20</td>

								</tr>
								<tr class="<% if (dayOfWeek == 1){out.print("success");}else{out.print("active");}%>">
									<td>Sunnuntai</td>
									<td>8-20</td>

								</tr>




							</tbody>
						</table>
						
					</div>
				</div>
			
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1898.8083595328676!2d26.018099416164304!3d61.5811560825026!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x468fef599be92625%3A0xfc8d943cb7087e20!2sKeskustie+58%2C+19600+Hartola!5e0!3m2!1sfi!2sfi!4v1449485759303" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
			
		</div>

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
