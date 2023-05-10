//목록
$(function(){
	$.ajax({
		type: 'post',
		url: '/user/getUserList',
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			/*
			$.each(data, function(index, item){
				var html = `<tr>` +
						`<td align="center">` + item.photo + `</td>` +
						`<td align="center">` + item.name + `</td>` +
						`<td align="center">` + item.age + `</td>` +
						`</tr>`;
			$('#listTable').append(html);				
		});//$.each
		*/
		
		/*for (var i = 0; i<data.length; i++) {
			var html = `<tr>
						<td align="center">
						<img src="/storage/${data[i].photo}" width="100" height="100">
						</td>
						<td align="center">${data[i].name}</td>
						<td align="center">${data[i].age}</td>
						</tr>`;
				$('#listTable').append(html);	
			
		}//for*/
		
		$.each(data, function(index, item) {
			var result = `<tr>` +
						`<td>${item.name}</td>` +
						`<td>${item.id}</td>` +
						`<td>${item.pwd}</td>` +
						`</tr>`;
						$('#userListTable').append(result);
		});
		
		},
		error: function(err){
			console.log(err);
		}
		
	});//ajax()
	
});


//검색 

$('#searchBtn').click(function(){
	if($('#keyword').val() == '')
		alert('검색어를 입력하세요')
	else
		$.ajax({
			type: 'post',
			url: '/user/search',
			//data: {'searchOption': $('#searchOption').val(),
				
			data: $('#searchForm').serialize(),
			dataType: 'json',
			success: function(data){
				console.log(JSON.stringify(data));
				
				
				$('#userListTable tr:gt(0)').remove(); //search되는 값들의 결과가 쌓이지 않고 다시 새로 나올 수 있도록 이 코드 넣는것
				$.each(data, function(index, item) {
				var result = `<tr>` +
					`<td>${item.name}</td>` +
					`<td>${item.id}</td>` +
					`<td>${item.pwd}</td>` +
					`</tr>`;
					$('#userListTable').append(result);
		});
			},
			error:function(err){
				console.log(err);
			}
		});
		
});