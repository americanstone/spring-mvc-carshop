function getX(){
		return event.clientX;
}
function getY(){
	return event.clientY;
}


function popup(thisID) {
       
	   document.getElementById(thisID).style.visibility = 'visible';
   } 
   
function popoff(thisID){

	 document.getElementById(thisID).style.visibility = 'hidden';

}
   
 function popup_login(){
	//document.write(getX());
	document.getElementById("login").style.top =(getY() + 6)+"px";
	document.getElementById("login").style.left = (getX() - 150)+"px";
	popup('login');
 }
   
function popoff_login(){
	popoff('login');

}

function showRegisterPage(){
	var indexdiv = document.getElementById("index-div");
	indexdiv.innerHTML = '<div class="main"> <h1 align="center" class="fontstyle">REGISTER NOW!</h1><br><br><table class="table"><tr><td class="fontstyle">Email:</td><td> <input name="email" type="text"></td></tr> <tr><td class="fontstyle">First:</td><td><input name="first" type="text"></td></tr><tr><td class="fontstyle">Last:</td><td><input name="last" type="text"></td></tr><tr><td class="fontstyle">Password:</td><td><input name="password" type="password"></td></tr><tr><td class="fontstyle">Confirm Password:</td><td><input name="confirmPass" type="text"></td></tr><tr><td class="fontstyle"><input type="submit" value="submit"></td></tr></table></div>';

}