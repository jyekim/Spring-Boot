//
$(function(){
	
	//updateDiv 먼저 hidden 해놓기?
	$('#updateDiv').hide();
	
	//검색 버튼 누르면 아이디 찾기 
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
	
		$.ajax({
	 		type: 'post',
	 		url: '/user/getUser',
	 		data: 'id=' + $('#searchId').val(),//서버로 보내는 데이터 
	 		//dataType:'json' 이걸 빼버리면 스프링이 알아서 인식함 datatype을 생략한다.
	 		//아이디가 있으면 UserDTO가 JSON으로 오지만 아이디가 없으면 JSON으로 오지를 못함 
	 		//그래서 dataType을 생략한다. (dataType을 생략하면 자료에 맞게 자동으로 형식이 지정됨) 
	 		
	 		success: function(data) {
				 //Optional<UserDTO> 값이 없으면 JSON으로 오고 없으면 null로 온다. 
	 			console.log(JSON.stringify(data));
	 			
	 			if(data == null){
	 				$('#updateDiv').hide(); //수정하려는 없는아이디를 다시 검색하게 될때 기존에 뜬 정보가 사라지게 하는 것 
	 				
	 				$('#resultDiv').text('수정 할 아이디가 없습니다');
	 				$('#resultDiv').css('color', 'red').css('font-weight', 'bold'); 
	 			}else{
	 				$('#updateDiv').show();
	 				
	 				$('#name').val(data.name);
	 				$('#id').val(data.id);
	 				$('#pwd').val(data.pwd);
	 			}
	 		},
	 		error: function(err) {
	 			console.log(err);
	 		}
		});//ajax
	});
});


/*
data type를 생략하면 자료에 맞게 자동으로 형식이 지정된다.
서버에서 받아오는 데이터 타입은 'text', 'html', 'xml', 'json' 형식을 지정할 수 있다
         getUser에서 id를 찾으면 제대로 JSON으로 오지만 
                    d가 없으면 JSON으로 오지를 못한다.
        그래서 dataType를 생략해야 한다. (dataType를 생략하면 자료에 맞게 자동으로 형식이 지정된다.)
*/





//취소버튼 
$('#resetBtn').click(function(){
	//강제 이벤트 발생
	$('#searchIdBtn').trigger('click'); //trigger자체가 강압적으로 발생하게 하는 효과
});


	//수정버튼 
$('#updateBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	
	
	if($('#name').val() ==''){
		$('#nameDiv').text('이름을 입력해주세요');
		$('#name').focus();
		
		
	}else if($('#pwd').val() ==''){
		$('#pwdDiv').text('비밀번호를 입력해주세요');
		$('#pwd').focus();
	
	}else{
		$.ajax({
			type: 'post',
			url:'/user/update',
			data: $('#updateForm').serialize(),
			success: function(){
				alert("회원정보를 수정하였습니다.");
				location.href='/user/list';	
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});
