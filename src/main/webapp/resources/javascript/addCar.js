
$(document).ready(function(){	

	
	$('#submitcar').click(function(){
		var vin = $('#vin').val();
		var make =$('#make').val();
		var category =$('#category').val();
		var model = $('#model').val();
		var purchasedate = $('#purchasedate').val();
		var plate = $('#plate').val();

		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function (){
			if(xhr.readyState == 4 && xhr.status == 200){
				//var result = xhr.responseText;
				//alert(result);
				
			}
		};
		xhr.open("POST","server/regCar.jsp",false);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		xhr.send("vin="+vin+"&make="+make+"&category="+category+"&model="+model+"&purchasedate="+purchasedate+"&plate="+plate);
		alert("Successful!");
		location.reload();
	});
	
	$('#myform').submit(function(){
		
		window.open("","win", 'height=320, width=320, top=200,left=500, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
		this.submit();
	});
});