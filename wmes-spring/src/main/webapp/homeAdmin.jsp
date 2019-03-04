<%@ include file="header.jsp"%>
<%
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUserDTO");
%>
<%!private String convertUserType(String userType) {
		if (userType.equals("admin"))
			return "<span class=\"role admin\">Admin</span>";
		else
			return "<span class=\"role user\">Business Owner</span>";
	}%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Admin Dashboard</title>

<!-- Fontfaces CSS-->
<link href="/css/font-face.css" rel="stylesheet" media="all">
<link href="/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="/vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="/vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">
<link href="/vendor/vector-map/jqvmap.min.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar2">
			<div class="logo">
				<a href="#"> <img src="/images/icon/wmeslogo2.png" alt="Wmes" />
				</a>
			</div>
			<div class="menu-sidebar2__content js-scrollbar1">
				<div class="account2">
					<div class="image img-cir img-120 ">

						<img src="/images/icon/avatarAdmin2.png" alt="Admin" />
					</div>
					<h4 class="name">Admin</h4>
					<a href="/User/logout">Sign out</a>
				</div>
				<nav class="navbar-sidebar2">
					<ul class="list-unstyled navbar__list">
						<li><a href="/Home/homeAdmin"> <i
								class="fas fa-chart-bar"></i>Dashboard
						</a></li>

						<li><a href="/User/userManagement"> <i
								class="fas fa-user"></i>Users
						</a></li>

					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container2">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop2">
				<div class="section__content section__content--p30">
					<div class="container-fluid">

					</div>
				</div>
			</header>

			<!-- END HEADER DESKTOP-->

			<!-- BREADCRUMB-->
			<section class="au-breadcrumb m-t-75">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="au-breadcrumb-content">
									<div class="au-breadcrumb-left">
										<span class="au-breadcrumb-span">You are here:</span>
										<ul class="list-unstyled list-inline au-breadcrumb__list">

											<li class="list-inline-item">Dashboard</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END BREADCRUMB-->

			<!-- STATISTIC-->
			<section class="statistic">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-lg-8">

								<!-- USER DATA-->
								<div class="user-data m-b-40">
									<h3 class="title-3 m-b-30">
										<i class="zmdi zmdi-account-calendar"></i>user data
									</h3>
									<div class="filters m-b-45">
										<div
											class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
											<select class="js-select2" name="property">
												<option selected="selected">All Properties</option>
												<option value="">Products</option>
												<option value="">Services</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
										<div
											class="rs-select2--dark rs-select2--sm rs-select2--border">
											<select class="js-select2 au-select-dark" name="time">
												<option selected="selected">All Time</option>
												<option value="">By Month</option>
												<option value="">By Day</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
									</div>
									<div class="table-responsive table-data">
										<table class="table">
											<thead>
												<tr>

													<td>name</td>
													<td>role</td>
													<td>type</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
											<%for (UserDTO userDTO: allUser) { %>
												<tr>
													<td>
														<div class="table-data__info">
															<h6><%=userDTO.getUserUser() %></h6>

														</div>
													</td>
													<td><%=convertUserType(userDTO.getUserType()) %></td>
													<td>
														<div class="rs-select2--trans rs-select2--sm">
															<select class="js-select2" name="property">
																<option selected="selected">Full Control</option>
																<option value="">Post</option>
																<option value="">Watch</option>
															</select>
															<div class="dropDownSelect2"></div>
														</div>
													</td>

												</tr>
												
												<% } %>
											</tbody>
										</table>
									</div>
									<div class="user-data__footer">
										<button class="au-btn au-btn-load">load more</button>
									</div>
								</div>
								<!-- END USER DATA-->
							</div>

							<div class="col-4">
                    
								<div class="row">
									<div class="col-md-6 col-lg-12">
										<div class="statistic__item">
											<h2 class="number"><%=allUser.size() %></h2>
											<span class="desc">Users</span>
											<div class="icon">
												<i class="zmdi zmdi-account-o"></i>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-lg-12"></div>
								</div>


							</div>

						</div>

					</div>
				</div>
			</section>
			<!-- END STATISTIC-->

			<section>
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-8"></div>
							<div class="col-xl-4"></div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-6"></div>
							<div class="col-xl-6"></div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="copyright">
								<p>Copyright © 2019 Wmes. All rights reserved. Template by
									Wmes Team</p>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END PAGE CONTAINER-->
		</div>

	</div>

	<!-- Jquery JS-->
	<script src="/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="/vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="/vendor/slick/slick.min.js">
		
	</script>
	<script src="/vendor/wow/wow.min.js"></script>
	<script src="/vendor/animsition/animsition.min.js"></script>
	<script
		src="/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="/vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="/vendor/circle-progress/circle-progress.min.js"></script>
	<script src="/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="/vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="/vendor/select2/select2.min.js">
		
	</script>
	<script src="/vendor/vector-map/jquery.vmap.js"></script>
	<script src="/vendor/vector-map/jquery.vmap.min.js"></script>
	<script src="/vendor/vector-map/jquery.vmap.sampledata.js"></script>
	<script src="/vendor/vector-map/jquery.vmap.world.js"></script>

	<!-- Main JS-->
	<script src="/js/main.js"></script>

</body>

</html>
<!-- end document-->