$(function(){
	$.ajax({
		url: functionLocation,
		type: "POST",
		data: dataSource,
		async: async,
		dataType: "JSON",
		success: function(data){
			if (data.functionName == null){
				showMsg(data.mes)
				if (data.res == 'true'){
					window.location.href=window.location.href
					window.location.reload
				}
			}
			else{
				if (typeof(eval(data.functionName)) == "function"){
					eval(data.functionName + "('" + JSON.stringify(data) + "')")
				}
			}
		}
	})
}