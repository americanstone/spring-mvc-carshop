<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
  <head>
    <title>List My Cars</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/showcar.css" />" rel="stylesheet" type="text/css" />
  </head>
  
  <body class="content">
  <br/>
  <h1 align="center">All your cars</h1>
  <br/>
  <hr>
  <br/>
  <div class="showcar-outside">
  <c:if test="${not empty myCars }" >
  	<div class="showcar-div">
  		<table class="showcar-table">
  			<c:forEach var="car" items="${myCars}">
  				<tr>
  				<td colspan="2"><img src="<c:url value="${car.getImage() }" />" alt="mycar" width="300" height="189"/></td>
  				</tr>
  				<tr bgcolor="#E9E9E9">
  					<td>Make</td>
  					<td>${car.getMake()}</td>
  				</tr>
  				<tr>
  					<td>Model</td>
  					<td>${car.getModel() }</td>
  				</tr>
  				<tr bgcolor="#E9E9E9">
  					<td>Type</td>
  					<td>${car.getCartype()}</td>
  				</tr>
  				<tr>
  					<td>Plate</td>
  					<td>${car.getPlatenumber()}</td>
  				</tr>
  				<tr  bgcolor="#E9E9E9">
  					<td>VIN</td>
		    		<td>${car.getVin()}</td>
  				</tr>
  				<tr>
  					<td>Year</td>
  					<td>${car.getYear()}</td>
  				</tr>
  			</c:forEach>
  			</table>
  		</div>
  </c:if>
  
  <c:if test="${empty myCars}" >
  	<h2>You don't have car registered. Please add one!</h2>
  </c:if>

    </div>
  </body>
</html>
