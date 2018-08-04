$(function(){
	$(".login").click(function(){
		var ps = $("#loginLoginPassword").val()
		ps = enPs(ps)
		alert(ps)
	})
	
	function enPs(pass){
		return hex_md5(str_md5(b64_md5(pass)))
	}
})