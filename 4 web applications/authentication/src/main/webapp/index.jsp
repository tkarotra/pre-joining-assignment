<% 
	if (session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>

<meta name='viewport'
	content='width=device-width, initial-scale=1.0, user-scalable=0'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description"
	content="ISS Pre Training Assignment - Welcome Page">
<meta name="author" content="Teesha Karotra">

<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/favicon.png" />
<title>Welcome | ISS</title>

<link id="style" href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/cover.css" rel="stylesheet" />

<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) { 
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

</head>

<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand"><%= session.getAttribute("name") %></h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="#">Home</a> 
					<a class="nav-link" href="#">Features</a> 
					<a class="nav-link" href="logout">Logout</a>
				</nav>
			</div>
		</header>

		<main role="main" class="inner cover">
			<h1 class="cover-heading">Cover your page.</h1>
			<p class="lead">Cover is a one-page template for building simple
				and beautiful home pages. Download, edit the text, and add your own
				fullscreen background photo to make it your own.</p>
			<p class="lead">
				<a href="#" class="btn btn-lg btn-secondary">Learn more</a>
			</p>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					<a href="https://www.issgovernance.com/">ISS</a>, © <script>document.write(new Date().getFullYear())</script>.
				</p>
			</div>
		</footer>
	</div>


	<!-- JQUERY JS -->
	<script src="assets/js/jquery.min.js"></script>

	<!-- SHOW PASSWORD JS -->
	<script src="assets/js/show-password.min.js"></script>

	<!-- Color Theme js -->
	<script src="assets/js/themeColors.min.js"></script>

	<!-- CUSTOM JS -->
	<script src="assets/js/custom.min.js"></script>



</body>

</html>