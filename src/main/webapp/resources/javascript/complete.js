	
	function del(){
		var root = document.getElementById("root");
		var children = root.childNodes;
		var lastindex = children.length;
		var lastChild = children[lastindex-1];
		
		root.removeChild(lastChild);

		
		
	}
	
	function add(){
		
		var root = document.getElementById("root");
		var tr = document.createElement("tr");
		tr.innerHTML ='<td><input type="text"></td><td><input type="text" size="80"></td><td ><input type="text" ></td><td><input type="text"></td>';
		root.appendChild(tr);
		
	}
	
	function coll(){
		var root = document.getElementById("root");
		var rid = root.getAttribute("rid");
		var info = document.querySelectorAll("input");
		var arry = [];
		var i = 0;
		do{
			var obj ={};
			obj['item'] = info[i].value;
			obj['description'] = info[i+1].value;
			obj['unitPrice'] = info[i+2].value;
			obj['amount'] = info[i+3].value;
			arry.push(obj);
			i = i+4;
		}while(i !== info.length);
		
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function (){
			if(xhr.readyState == 4 && xhr.status == 200){
				alert("repair job is completed");
				
			}
		};
		console.log(JSON.stringify(arry));
		xhr.open("POST","../server/empCompItem.jsp",false);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");	
		xhr.send("items="+JSON.stringify(arry)+"&rid="+rid);
		
		
	}
		