<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
	<head>
		<title>List My Repair Jobs</title>
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<br/>
		<h1 align="center">My repair jobs</h1>
		<hr>
		<br/>
		<c:if test="${not empty myJobs}">
			<table align="center" width="95%">
				<tr >
					<th>Job ID</th>
					<th>Customer</th>
					<th>Plate number</th>
					<th>Problem</th>
					<th>Category</th>
					<th>Status</th>
					<th>Estimated cost</th>
					<th>Estimated days<br/>to repair</th>
					<th>Person in charge</th>
					<th>Action</th>
				</tr >
				<c:forEach var="myJob" items="${myJobs}">
					<tr align="center">
						<td>${myJob.getJobId() }</td>
						<td>${myJob.getCustomer() }</td>
						<td>${myJob.getPlateNumber() }</td>
						<td>${myJob.getProblem() }</td>
						<td>${myJob.getCategory() }</td>
						<td>${myJob.getStatus() }</td>
						<td>${myJob.getEstimatedCost() }</td>
						<td>${myJob.getEstimatedDays() }</td>
						<td>${myJob.getPersonInCharge() }</td>
						<td>${myJob.getStatus() }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</body>

</html>