<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="writeForm" method="post" enctype="multipart/form-data" action="/person/writeForm">		
	<table border="1">
		<tr>
			<th width="70">이름</th>
			<td><input type="text" name="name" id="name">
			<div id="nameDiv"></div>
			</td>
		</tr>
		
			<tr>
			<th width="70">나이</th>
			<td><input type="text" name="age" id="age">
			<div id="ageDiv"></div>
			</td>
		</tr>
		
		 <tr>
		 	<td colspan="2">
		 		<!--업로드 버튼을 누르기 전에 카메라 아이콘을 통해서 선택한 이미지가 맞는지 확인하기 위햇 이미지를 보이게한다  -->
		 		<img id="showImg"  width="100" height="100">
		 		
		 		<img  id="camera" src="/img/camera.png" width="40" height="40" alt="카메라">
		 		<input type="file" name="img"  id="img" multiple="multiple" style="visibility:hidden;">	<!--name="img[]"로 쓰면 하나만 쓰겠다는 거   -->	 		
		 	</td>
		 </tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type= "button" value= "등록" id="writeBtn">				
				<input type= "reset" value= "취소">
			</td>
		</tr>
	</table>
	</form>
	
	
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/js/write.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	//강제 이벤트 발생 
	$('#img').trigger('click');
});

<!--업로드 버튼을 누르기 전에 카메라 아이콘을 통해서 선택한 이미지가 맞는지 확인하기 위햇 이미지를 보이게한다  -->
$('#img').change(function(){
	readURL(this);
});

function readURL(input){
	var reader = new FileReader();
	
	reader.onload = function(e){
		$('#showImg').attr('src', e.target.result); //e.target - event가 발생하는 요소를 반환해준다. 
	}
	
	reader.readAsDataURL(input.files[0]);//for문 돌리면 여러개 사진들 보여줌
}
</script>
	

</body>
</html>