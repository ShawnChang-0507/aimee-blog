$(function(){
	$(".login").click(function(){
		var ps = $("#loginLoginPassword").val()
		ps = enPs(ps)
	});

	$(".register").click(function(){
		var pass = $("#registerLoginPassword").val()
		var name = $("#registerLoginName").val()
		var nick = $("#registerNickName").val()
		pass = enPs(pass)
		checkByAjax("/checkLoginName", {'loginName':name}, true)
	});

	function checkByAjax(functionLocation, dataSource, async){
		
		$.ajax({
			url: functionLocation,
			type: "POST",
			data: dataSource,
			async: async,
			dataType: "JSON",
			success: function(data){
				var reuslt = JSON.stringify(data)
				alert(result.message)
			}
		})
	}
})

function enPs(pass){
	return hex_md5(str_md5(b64_md5(pass)))
}