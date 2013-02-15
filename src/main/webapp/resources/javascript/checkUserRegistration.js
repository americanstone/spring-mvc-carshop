	
var register_xhr = new XMLHttpRequest();


register_xhr.onreadystatechange = function(){
	if(register_xhr.readyState == 4){
		var response = register_xhr.responseText;
		response = response.trim(response);
		if(response == "Error"){
			alert("Username already taken. Please try another one.");
		}else{
			window.location.replace("user.jsp");
		}
	}
};


function checkEmail(){
	var emailElem = document.getElementById("email");
	var email = emailElem.value;
	var row = document.createElement("tr");
	var td = document.createElement("td");
	td.setAttribute("class", "error");
	var textNodeError = document.createTextNode("* E-mail must be of the form 'john.smith@domain.com|net|org|edu'");
	var emailFormat = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	
	if(email.search(emailFormat)==-1){
		if(emailElem.nextSibling){
			emailElem.parentNode.removeChild(emailElem.nextSibling);
		}
		td.appendChild(textNodeError);
		row.appendChild(td);
		insertAfter(emailElem, row);
	}else{
		if(emailElem.nextSibling){
			emailElem.parentNode.removeChild(emailElem.nextSibling);
		}

		
	}
	
}

function checkPassword(){
	var passwordElem = document.getElementById("passwordReg");
	var passwordValue = passwordElem.value;
	var row = document.createElement("tr");
	var td = document.createElement("td");
	td.setAttribute("class", "error");
	var textNodeError = document.createTextNode("* Password must be between 6 and 9 alphanumeric characters.");
	var passwdFormat = /^[A-Za-z]\w{6,}[A-Za-z]$/;
	
	if(passwordValue.search(passwdFormat)){
		if(passwordElem.nextSibling){
			passwordElem.parentNode.removeChild(passwordElem.nextSibling);
		}
		td.appendChild(textNodeError);
		row.appendChild(td);
		insertAfter(passwordElem, row);
		
	}else{
		if(passwordElem.nextSibling){
			passwordElem.parentNode.removeChild(passwordElem.nextSibling);
		}
		
	}
	
}

function checkConfirmPassword(){
	var confPasswordElem = document.getElementById("confirmPass");
	var passElem = document.getElementById("passwordReg");
	var confPasswordValue = confPasswordElem.value;
	var passwordValue = passElem.value;
	var row = document.createElement("tr");
	var td = document.createElement("td");
	td.setAttribute("class", "error");
	var textNodeError = document.createTextNode("* Passwords must match");
	
	if(confPasswordValue != passwordValue){
		if(confPasswordElem.nextSibling){
			confPasswordElem.parentNode.removeChild(confPasswordElem.nextSibling);
		}
		td.appendChild(textNodeError);
		row.appendChild(td);
		insertAfter(confPasswordElem, row);
	}else{
		if(confPasswordElem.nextSibling){
			confPasswordElem.parentNode.removeChild(confPasswordElem.nextSibling);
		}
	}
	
	
}
function insertAfter(referenceNode, newNode) {
    referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}


function checkRegister(){
	var email = document.getElementById("email").value;
	var passwd = document.getElementById("passwordReg").value;
	var confPass = document.getElementById("confirmPass").value;
	var fname = document.getElementById("first").value;
	var lname = document.getElementById("last").value;
	//alert("here");
	//return false;
	
	if(email.search(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/)){
		alert("E-mail not in the correct format");
		return false;
	}
	
	else if(passwd.search(/^[A-Za-z]\w{6,}[A-Za-z]$/)){
		alert("Password is not on the correct format.");
		return false;
		
	}
	else if(!fname){
		alert("Your first name field is empty!");
		return false;
	}
	else if(!lname){
		alert("Your last name field is empty!");
		return false;
	}
	else if(confPass != passwd ){
		alert("Passwords dont match!");
		return false;
	}else{
		register_xhr.open("POST","server/signup.jsp?username="+email+"&fname="+fname+"&lname="+lname+"&password="+passwd, true);
		register_xhr.send(null);
		return false;
	}
}
function trim(s) { 
    s = s.replace(/(^\s*)|(\s*$)/gi,"");
    s = s.replace(/[ ]{2,}/gi," "); 
    s = s.replace(/\n /,"\n"); return s;
}