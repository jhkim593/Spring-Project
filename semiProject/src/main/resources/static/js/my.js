$(document).ready(function(){
	$("#loginBtn").click(function(){
		const id=$("#id").val();
		const pw=$("#pw").val();
		
		//alert(id+":"+pw);
		$.post(
			"/loginById",
			{
				id:id,
				pw:pw
			},
			function(data){
				data=JSON.parse(data);
				if(data.id){
					$("#loginSpan").html(data.id+"님 환영합니다");
					
				}
				else{
					alert("다시 로그인해주세요");
				}
			}
		);
	});
	
});