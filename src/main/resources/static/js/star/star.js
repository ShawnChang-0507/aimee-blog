$(function(){
	$("#submitStar").click(function(){
		
		$.ajax({
			type: "POST",
			url: "../star/insert",
			data: {name:$("#starName").val(),startTime:$("#starStartTime").val(),endTime:$("#starEndTime").val(),starCharacter:$("#starCharacter").val()},
			dataType: "JSON",
			success: function(){
				alert("SUCCESS")
			},
			error: function(){
				alert("ERROR")
			}
		})
	})
	
	$("#findStar").click(function(){
		if ($("#starId").val() == ""){
			alert("请输入id")
			return
		}
		$.ajax({
			type: "POST",
			url: "../star/star",
			data: {starId:$("#starId").val()},
			dataType: "JSON",
			success: function(data){
				var star = eval(data)
				$("#starId").val(star.starId)
				$("#starName").val(star.name)
				$("#starStartTime").val(star.startTime)
				$("#starEndTime").val(star.endTime)
				$("#starCharacter").val(star.starCharacter)
			}
		})
	})
})