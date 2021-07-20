$(document).ready(function(){
		$('#loginBtn').click(function(){
			
			const id=$('#id').val();
			const pw=$('#pw').val();
			
			
			$.post("/loginById",
					  {		
						
					    id:id,
					    pw:pw
					  },
					  function(data){
						  data=JSON.parse(data);
						  console.log(data);
						  if(data.msg){//fail
							  alert(data.msg);
						  }else{//ok data={"id":"a"}
							 
						  	  $.cookie("id",data.id,{path:'/'});
						  	  
						  	  document.getElementById("welcomeMsg").innerHTML=" <button id='logoutBtn'>로그아웃</button> ";
						  }//end else						
					    
					  }//end function
			
			);//end post			
			
		});//end click
		
	});//end ready
	
	
	
	