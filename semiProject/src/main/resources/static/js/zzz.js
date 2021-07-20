
$(document).ready(function(){
		
		
		const temp = location.href.split("?");
 	    const temp2 =temp[1].split("&");
		const bno=temp2[0].split("=")[1];
		let content=temp2[1].split("=")[1];
		let title=temp2[2].split("=")[1];
		let imageFileName=temp2[3].split("=")[1];
		$('#title').val(title);
		$('#content').val(content);
		$('#imageFileName').val(imageFileName);
			
		$('#updateBoard').click(function(){
			
			
			if ($("#title").val()==""){
			alert("제목을 입력해주세요");
			$("#title").focus();
			return false;
		  }
		  
		  else if ($("#content").val()==""){
			alert("내용을 입력해주세요");
			$("#content").focus();
			return false;
		  }
			
			$.post("/updateBoard",
					  {		
						bno:bno,
					    title:title,
					    content:content,
					    imageFileName:imageFileName
					  },
					  function(data){
						  alert(data);
						  location.href="boardList.html";
						  //end else						
					    
					  }//end function
			
			);//end post			
			
		});//end click
		
	});//end ready