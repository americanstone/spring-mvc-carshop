// JavaScript Document
	function update()
	{
		document.getElementById("address1").disabled = false;
		document.getElementById("address2").disabled = false;
		document.getElementById("city").disabled = false;
		document.getElementById("country").disabled = false;
		document.getElementById("phone").disabled = false;
		
		document.getElementById("update").style.display = "none";
		document.getElementById("confirm").style.display = "block";
	}
	
	function addressChange(tag)
	{
		var queryString = "";
		if(tag)
		{
			var address_id = document.getElementById("address_id").innerHTML.replace(' ','+');
			var address1 = document.getElementById("address1").value.replace(' ','+');
			var address2 = document.getElementById("address2").value.replace(' ','+');
			var city = document.getElementById("city").value.replace(' ','+');
			var country = document.getElementById("country").value.replace(' ','+');
			var phone = document.getElementById("phone").value.replace(' ','+');
			
			queryString = "id="+address_id+"&address1="+address1+"&address2="
						+address2+"&city="+city+"&country="+country+"&phone="+phone;	
		}
		location.href='address.jsp?'+queryString;
		
		
	}