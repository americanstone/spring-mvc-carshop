var login_xhr;
function init(){

	login_xhr = new XMLHttpRequest();
	
	login_xhr.onreadystatechange=function(){
		
		if(login_xhr.readyState == 4){
			var response = login_xhr.responseText;
			response = response.trim(response);
			if(response == "OK"){
				window.location.replace("main.jsp");
			}else {
				alert(response);
				
			} 
		}
	};

}
	


function login(){

	var user = document.getElementById("uname").value;
	var passwd = document.getElementById("passwd").value;	
	var queryString = 'uname='+user+'&passwd='+passwd;
	login_xhr.open("POST", "server/signin.jsp", true);
	login_xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	login_xhr.send(queryString);
}



function trim(s) { 
    s = s.replace(/(^\s*)|(\s*$)/gi,"");
    s = s.replace(/[ ]{2,}/gi," "); 
    s = s.replace(/\n /,"\n"); return s;
}

function clearFields(){
	document.myForm.reset();
	
}

