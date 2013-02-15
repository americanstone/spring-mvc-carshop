<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="8DCA66">
<% 
String role =  (String)session.getAttribute("role");
if(role == null) { %>
	<script type="text/javascript">
		alert("Your session expired. Please login again!");
		<%out.print("<script type=text/javascript>window.parent.location.href='index.jsp'</script>"); %>
	</script>

<% } else {
		if(role.equals("customer")){ %>
<ul>
	<li>User Information
		<ul>
			<li><a href="user.jsp" target="main">Basic Information</a></li>
			<li><a href="address.jsp" target="main">Address</a></li>
			<li><a href="<c:url value="/showCar" />" title="forms" target="main">Car</a>
				<ul>
					<li><a href="<c:url value="/addCar" />" target="main">Add Car</a></li>
					<li><a href="<c:url value="/showCar" />" target="main">List Car</a></li>
				</ul>
			
			</li>
		</ul>
	</li>
	<li>Repair Job
		<ul>
			<li><a href="createRequest.jsp" target="main">New</a></li>
			<li><a href="jobinprocess.jsp" target="main">Processing</a></li>
			<li><a href="jobcompleted.jsp" target="main">History</a></li>
		</ul>
	</li>
</ul>
<% } else if(session.getAttribute("role").equals("employee")){ %>


		<ul>
			<li><a href="employee/myJobs.jsp" target="main">My Repair Jobs</a></li>
			<li>All Repair Jobs
				<ul>
					<li><a href="employee/newJobs.jsp" target="main">New</a></li>
					<li><a href="employee/ongoingJobs.jsp" target="main">Processing</a></li>
					<li><a href="employee/completedJobs.jsp" target="main">History</a></li>
				</ul>
			</li>
		</ul>

<%  } 
		} %>
</body>
</html>