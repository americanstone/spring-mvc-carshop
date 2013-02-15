	String.prototype.trim = function() {
                return this.replace(/^\s+/,"").replace(/\s+$/,"");
            }

	function getRootPath() 
	{
       	var pathName = window.location.pathname.substring(1);
       	var webName = pathName == "" ? "" : pathName.substring(0, pathName.indexOf('/'));
       	return window.location.protocol + '//' + window.location.host + '/'+ webName;
    } 
	
	function initAjax()
	{
		request_xhr = new XMLHttpRequest();
		
		request_xhr.onreadystatechange=function()
		{
			if( (request_xhr.readyState==4) && (request_xhr.status == 200))
			{
				var messages = request_xhr.responseText.split(";");
				if(messages[0].trim() == "OK")
				{
					location.href="createRequest.jsp";
				}
			}
		};
	}
	
	function requestAjax()
	{
		var c_index = document.getElementById('category').selectedIndex;
		var p_index = document.getElementById('plate').selectedIndex;
		
		var content = {
				name:			document.getElementById("name").value,
				category:		document.getElementById('category').options[c_index].value,
				plate:			document.getElementById('plate').options[p_index].value,
				description:	document.getElementById('description').value
		}
		
		var url = getRootPath() + "/server/addRequest.jsp";
		var json_string = "new="+JSON.stringify(content);

		open_and_send_request(request_xhr,url,json_string);
	}
	
	function open_and_send_request (agent, URL, queryString) 
	{
		agent.open("POST", URL, true);

        agent.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        agent.send(queryString);
    }
	
	function imgSubmit()
	{
		window.open("","win", 'height=320, width=320, top=200,left=500, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
		this.submit();
	}
	
	function cancelAdd()
	{
		location.href= getRootPath()+"/createRequest.jsp";
	}
	
	function cancelRequest(object)
	{
		var answer = confirm("Cancel this request?");
		if(answer)
		{
			var rid = object.getAttribute('rid');
			
			location.href= getRootPath()+"/server/deleteRequest.jsp?rid="+rid;
		}
	}
	
	function confirmRequest(object)
	{
		var answer = confirm("Confirm this request?");
		if(answer)
		{
			var rid = object.getAttribute('rid');
			location.href= getRootPath()+"/server/confirmRequest.jsp?rid="+rid;
		}
	}