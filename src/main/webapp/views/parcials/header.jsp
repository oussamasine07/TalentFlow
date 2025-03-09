<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="talentflow.model.User, java.util.*" %>

<%
    User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="zxx">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/assets/css/bootstrap.min.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.carousel.min.css">
        <!-- Owl Carousel Theme Default CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl.theme.default.min.css">
        <!-- Box Icon CSS-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/boxicons.min.css">
        <!-- Flaticon CSS-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/fonts/flaticon/flaticon.css">
        <!-- Meanmenu CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/meanmenu.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/nice-select.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
		<!-- Dark CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/dark.css">
		<!-- Responsive CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/responsive.css">
        <!-- Title CSS -->
        <title>Jovie - Job Board & Hiring Portal HTML Template</title>
        <!-- Favicon -->
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/img/favicon.png">
	</head>

  	<body>

		<!-- Pre-loader Start -->
		<div class="loader-content">
            <div class="d-table">
                <div class="d-table-cell">
					<div class="sk-circle">
						<div class="sk-circle1 sk-child"></div>
						<div class="sk-circle2 sk-child"></div>
						<div class="sk-circle3 sk-child"></div>
						<div class="sk-circle4 sk-child"></div>
						<div class="sk-circle5 sk-child"></div>
						<div class="sk-circle6 sk-child"></div>
						<div class="sk-circle7 sk-child"></div>
						<div class="sk-circle8 sk-child"></div>
						<div class="sk-circle9 sk-child"></div>
						<div class="sk-circle10 sk-child"></div>
						<div class="sk-circle11 sk-child"></div>
						<div class="sk-circle12 sk-child"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- Pre-loader End -->

		<!-- Navbar Area Start -->
		<div class="navbar-area">
			<!-- Menu For Mobile Device -->
			<div class="mobile-nav">
				<a href="index.html" class="logo">
					<img src="${pageContext.request.contextPath}/resources/assets/img/logo.png" alt="logo">
				</a>
			</div>

			<!-- Menu For Desktop Device -->
			<div class="main-nav">
				<div class="container">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="index.html">
							<img src="${pageContext.request.contextPath}/resources/assets/img/logo.png" alt="logo">
						</a>
						<div class="collapse navbar-collapse mean-menu" id="navbarSupportedContent">
							<ul class="navbar-nav m-auto">
								<li class="nav-item">
									<a href="${pageContext.request.contextPath}" class="nav-link active">Home</a>
								</li>
								<li class="nav-item">
									<a href="#" class="nav-link">About</a>
								</li>

								<% if ( user != null ) { %>
								    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/dashboard" class="nav-link">Dashboard</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="${pageContext.request.contextPath}/profile" class="nav-link">Profile</a>
                                    </li>
								<% } %>

                                <% if (user != null && user.getRole().equals("recruteur")) { %>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link dropdown-toggle">Recruiter</a>
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/offer/my-offers" class="nav-link">Mes Offres</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/offer/create" class="nav-link">Nouvelle Offre</a>
                                            </li>
                                        </ul>
                                    </li>
								<% } %>

								<% if (user != null && user.getRole().equals("condidat")) { %>
								    <li class="nav-item">
                                        <a href="#" class="nav-link dropdown-toggle">Candidat</a>
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a href="${pageContext.request.contextPath}/candidature/mes-candidatures" class="nav-link">Mes Candidatures</a>
                                            </li>
                                        </ul>
                                    </li>
								<% } %>

								<li class="nav-item">
									<a href="#" class="nav-link dropdown-toggle">Offres</a>
									<ul class="dropdown-menu">
										<li class="nav-item">
											<a href="${pageContext.request.contextPath}/offer" class="nav-link">List Des Offres</a>
										</li>
									</ul>
								</li>

								<li class="nav-item">
									<a href="contact.html" class="nav-link">Contact Us</a>
								</li>
							</ul>

							<div class="other-option">
							    <% if ( user != null ) { %>
							        <form action="${pageContext.request.contextPath}/auth/logout" method="POST">
							            <input type="submit" class="signin-btn" value="Logout" />
							        </form>
							    <% } else { %>
							        <a href="${pageContext.request.contextPath}/auth/register" class="signup-btn">Sign Up</a>
                                    <a href="${pageContext.request.contextPath}/auth/login" class="signin-btn">Sign In</a>
							    <% } %>

							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<!-- Navbar Area End -->
