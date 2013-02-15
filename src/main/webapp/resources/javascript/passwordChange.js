var pswd_change_xhr = new XMLHttpRequest();

function displayForm(){
	var passBox = document.getElementById("changePassBox");
	passBox.style.visibility = "visible";

}

pswd_change_xhr.onreadystatechange = function(){
	if(pswd_change_xhr.readyState == 4){
	var message = pswd_change_xhr.responseText;
		if(message == 1){
			alert("password updated succesfully");
		}else{
			alert("the password you provided does not match our records.");
		}
	}
};

function hideForm(){
	var passBox = document.getElementById("changePassBox");
	passBox.style.visibility = "hidden";
}

function changePassword(){
	var curpass = document.getElementById("curPass").value;
	var newPass = document.getElementById("newPass").value;
	var confPass = document.getElementById("confNewPass").value;
	if(comparePasswds(newPass, confPass)){
		pswd_change_xhr.open("POST", "server/changePassword.jsp?curpass='"+curpass+"'&newPass='"+newPass+"'", true);
		pswd_change_xhr.setRequestHeader("Content-Type", "application/x-www-form-u-lencoded");
		pswd_change_xhr.send(null);
	}else{
		alert("your passwords did not match. Please check again.");
	}

	
	return false;
}

function comparePasswds(newPass, confPass){
	if(newPass != confPass){
		return false;
	}else{
		return true;
	}
}

function resetForm(){
	var myForm = document.getElementById("changePassForm");
	myForm.reset();
	return false;
	//myForm.reset();
}

