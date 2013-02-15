<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="formsContent">
		<h2>Log in </h2>
		<p>
			See the <code>com.youcodehub.spring.controlller</code> package for the @Controller code	
		</p>
		<!-- if not specify the commandNome, exception will throw javax.servlet.jsp.JspTagException: 
		Neither BindingResult nor plain target object for bean name 'command' available as request attribute -->
		<form:form id="form" method="post" commandName="userLogin">
			<div class="header">
		  		<h2>Form</h2>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<table>
		  		<tr>
		  			<td>UserID(email)</td>
		  			<td><form:input path="userId" /></td>
		  			<td><form:errors path="userId" cssClass="error"/></td>
		  		</tr>
		  		<tr>
		  			<td>Password</td>
		  			<td><form:password path="password"/></td>
		  			<td><form:errors path="password" cssClass="error" /></td>
		  		</tr>
		  		<tr>
		  			<td colspar="2">
		  				<input type="submit" value="Login"/>
		  			</td>
		  		</tr>
		  	
		  	</table>
		  	<%-- <h3>Following user id in oracle database:</h3>
		  	<c:forEach items="${modelref.useridref}" var="product">
		  		<c:out value="${product.id}" /> 
		  	</c:forEach> --%>
		  	
		</form:form>
		
	</div>

</body>
</html>