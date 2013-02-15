<%@ include file="/WEB-INF/views/include.jsp" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	<ul>
	<li>User Information
		<ul>
		<!-- url which no / means absolute path, otherwise means relative path
			in this case /car/addCar will be /spring/car/addCar
			showMyCar depends on the context user i.e user. the absolute path
			will be /user/showMyCar
		  -->
			<li><a href="<c:url value="userInfo" />" target="main">Basic Information</a></li>
			<li><a href="<c:url value="addressInfo" />" target="main">Address</a></li>
			<li><a href="<c:url value="showMyCar" />" title="forms" target="main">Car</a>
				<ul>
					<li><a href="<c:url value="car/addCar" /> " target="main">Add Car</a></li>
					<li><a href="<c:url value="showMyCar" />" target="main">List Car</a></li>
				</ul>
			</li>
		</ul>
	</li>
	<li>Repair Job
		<ul>
			<li><a href="<c:url value="/car/createRequest" />" target="main">New</a></li>
			<li><a href="<c:url value="/car/jobinprocess" />" target="main">Processing</a></li>
			<li><a href="<c:url value="/car/jobcompleted" />" target="main">History</a></li>
		</ul>
	</li>
</ul>
</body>
</html>
