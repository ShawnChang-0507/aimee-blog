$(function(){
	$("#submitStar").click(function(){
		
		$.ajax({
			type: "POST",
			url: "../star/insert",
			data: {name:$("#starName").val(),startTime:$("#starStartTime").val(),endTime:$("#starEndTime").val(),starCharacter:$("#starCharacter").val()},
			dataType: "JSON",
			SUCCESS: function(){
				alert("SUCCESS")
			},
			ERROR: function(){
				alert("ERROR")
			}
		})
	})
})