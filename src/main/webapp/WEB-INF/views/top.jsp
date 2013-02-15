<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	
</head>
<body bgcolor="8DCA66">
<table width="100%">
	<tr>
		<td width="15%" valign="top"><img alt="logo" width="170px" height="90px" src="<c:url value="/resources/images/Logo.jpg" />"></img>
		</td>
		<td width="70%"><h1>Welcome to Crash Garage</h1>
		</td>
		<td valign="top" width="15%">
			${validUserId}
			<a class="logout" href="<c:url value="logout"/> ">Logout</a>
			
		</td> 
	</tr>

</table>
</body>

</html>