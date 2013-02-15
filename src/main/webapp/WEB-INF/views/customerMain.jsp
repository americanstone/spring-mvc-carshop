<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="<c:url value="/resources/javascript/address.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />"/>
</head>
<frameset rows="70,*" cols="*"  >
  <frame src="<c:url value="top"/>" name="topFrame" scrolling="no" >
  
  <frameset cols="180,*" name="btFrame"  framespacing="0">

    <frame src="<c:url value="customerMenu" />" noresize name="menu" scrolling="yes">
    <frame src="<c:url value="showMyCar" />" style="olor:blue;" noresize name="main" scrolling="yes">
  </frameset>
</frameset>
</html>