$(function(){
	/**
	 * 登录
	 */
	$(".login").click(function(){
		var name = $("#loginLoginName").val()
		var pass = $("#loginLoginPassword").val()
		if ($.trim(name).length < 2 || $.trim(name).length > 19 || $.trim(pass).length < 6 || $.trim(pass).length > 18){
			showMsg("尊敬的超级无敌炫酷VIP同志，只有输入正确的用户名和密码，萌妹才能帮您办理入村登记哦！O(∩_∩)O~")
			return
		}
		pass = enPs(pass)
		checkByAjax("/login", {'loginName':name, 'loginPassword':pass}, true, null)
	});

	/**
	 * 注册信息
	 */
	$(".register").click(function(){
		var pass = $("#registerLoginPassword").val()
		var rePass = $("#registerLoginRePassword").val()
		var name = $("#registerLoginName").val()
		var nick = $("#registerNickName").val()
		if ($.trim(name).length < 2 || $.trim(name).length > 19){
			showMsg('亲！用户名字数太少啦~再补两个字呗，请别超过19个哦，村里记事簿只有16开32页，位置有限呢！(*^▽^*)')
			return
		}
		if ($.trim(pass).length < 6 || $.trim(pass).length > 18){
			showMsg("5个太少，19个太多，你猜密码多少位合适？萌妹会在密码上撒点盐，再打上马赛克~不晓得黑客能不能看清楚，反正萌妹自己已经看崩溃了(#^.^#)")
			return
		}
		if (pass != rePass){
			showMsg('哪个密码才是正确的捏？请保持一致哦 ε=(´ο｀*)))唉')
			return
		}
		pass = enPs(pass)
		checkByAjax("/register", {'loginName':name, 'loginPassword':pass, 'nickName':nick}, true, null)
	});
	
	$("#addGroupInput").keyup(function(event){
		  if(event.keyCode ==13){
			  var groupName = $(this).val()
			  checkByAjax("/blog/addArticleGroup", {'groupName': groupName}, true, 'showMsg')
		  }
		});
})

function enPs(pass){
	return hex_md5(str_md5(b64_md5(pass)))
}

/**
 * 登录或注册
 * @param functionLocation
 * @param dataSource
 * @param async
 * @returns
 */
function checkByAjax(functionLocation, dataSource, async, functionName){
	$.ajax({
		url: functionLocation,
		type: "POST",
		data: dataSource,
		async: async,
		dataType: "JSON",
		success: function(data){
			if (functionName == null){
				showMsg(data.mes)
				if (data.res == 'true'){
					window.location.href=window.location.href
					window.location.reload
				}
			}
			else{
				if (eval(functionName) == "function"){
					eval(functionName + "(" + data.reres + ")")
				}
			}
		}
	})
}


function showMsg(message){
	$("#aimeeSaidContent").text(message)
	$("#aimeeSaid").modal("show")
}