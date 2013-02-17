<%@ include file="/WEB-INF/views/include.jsp"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="<c:url value="myJobs"/>" target="main">My RepairJobs</a>
		</li>
		<li>All Repair Jobs
			<ul>
				<li><a href="<c:url value="newJobs"/>" target="main">New</a>
				</li>
				<li><a href="<c:url value="ongoingJobs"/>" target="main">Processing</a>
				</li>
				<li><a href="<c:url value="completedJobs"/>" target="main">History</a>
				</li>
			</ul></li>
	</ul>
</body>
</html>

