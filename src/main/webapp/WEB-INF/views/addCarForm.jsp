<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
  <head>
    <title>Add your car</title>
	<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href='http://fonts.googleapis.com/css?family=Tienne' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-1.7.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/addCar.js" />"></script>
  </head>
  
  <body>
 	 <br/>
  	<h2 align="center">Register your car get good service!</h2>
  	<br/>
  	<hr>
  	<br/>
  	<form:form id="form" method="post"  modelAttribute="addCarFormBean" enctype="multipart/form-data" cssClass="cleanform">
  		<div class="">
  			<h2>Form</h2>
  			<c:if test="${not empty message }">
  				<div id="message" class="success">${message }</div>
  			</c:if>
  			<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  	</s:bind>
  		</div> 
  		
  		<fieldset>
  			<legend>Car information</legend>
  			<form:label path="vin">
  				VIN <form:errors path="vin" cssClass="error" />
  			</form:label>
  			<form:input path="vin" />
  			
  			<form:label path="platenumber">
  				PlateNumber <form:errors path="platenumber" cssClass="error" />
  			</form:label>
  			<form:input path="platenumber" />
  			
  			<form:label path="model">
  				Model <form:errors path="model" cssClass="error" />
  			</form:label>
  			<form:input path="model" />
  			
  			<form:label path="year">
  				Year <form:errors path="year" cssClass="error" />
  			</form:label>
  			<form:input path="year" />
  		
  		</fieldset>
  		
  		<fieldset class="radio">
  			<legend>Make</legend>
  			<label><form:radiobutton path="make" value="Ford" />Ford</label>
  			<label><form:radiobutton path="make" value="Acura" />Acura</label>
  			<label><form:radiobutton path="make" value="Audi" />Audi</label>
  			<label><form:radiobutton path="make" value="BMW" />BMW</label>
  			<label><form:radiobutton path="make" value="Lexus" />Lexus</label>
  			<label><form:radiobutton path="make" value="Toyota" />Toyota</label>
  			<label><form:radiobutton path="make" value="Saab" />Saab</label>
  			<label><form:radiobutton path="make" value="Honda" />Honda</label>
  		</fieldset>
  		
  		<fieldset>
  			<legend>Category</legend>
  			<form:label path="cartype">Select Car Type
  				<form:errors path="cartype" cssClass="error" />
  			</form:label>
  			<form:select path="cartype">
  				<form:option value="SUV">SUV</form:option>
  				<form:option value="sedan">Sedan</form:option>
  				<form:option value="van">Van</form:option>
  				<form:option value="pickup">Pickup</form:option>
  				<form:option value="convertible">Convertible</form:option>
  				<form:option value="wagon">Wagon</form:option>
  				<form:option value="minivan">Minivan</form:option>
  				<form:option value="minivan">Coupe</form:option>
  			</form:select>
  		</fieldset>
  		
  		<%-- <fieldset>
  			<legend>Image</legend>
  			<form:label path="imageData">Select Car image
  				<form:errors path="imageData" cssClass="error" />
  			</form:label>
  			<form:input id="file" path="imageData" type="file" name="imageData" />
  		</fieldset> --%>
			<p><button type="submit">Submit</button></p>
	</form:form>
  </body>
</html>
