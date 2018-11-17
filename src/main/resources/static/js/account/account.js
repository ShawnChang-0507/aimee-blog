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
		checkByAjax("/login", {'loginName':name, 'loginPassword':pass}, true)
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
		checkByAjax("/register", {'loginName':name, 'loginPassword':pass, 'nickName':nick}, true)
	});
	
	$("#addGroupInput").keyup(function(event){
	  if(event.keyCode ==13){
		  var groupName = $(this).val()
		  if (isEmpty(groupName)){
			  showMsg("萌妹没看到要创建的分组(个_个)")
			  return
		  }
		  checkByAjax("/blog/addArticleGroup", {'groupName': groupName}, true)
	  }
	});
	
	$(document).on('click', ".dropdown-item", function(){
		var selectedValue = $(this).attr("value");
		if(isEmpty(selectedValue)){
			selectedValue = '选择分类'
		}
		$(".article-group").text(selectedValue)
		$(".article-group").attr('my-value', $(this).attr('my-value'))
	});
	
	$(".commite-blog").click(function(){
		var groupId = $(".article-group").attr("my-value")
		var title = $("#articleTitle").val()
		var secondTitle = $("#secondTitle").val()
		var articleContent = $(".article-content").val()
		if (isEmpty(groupId)){
			showMsg("选择文章分组")
			return
		}else if(isEmpty(title)){
			showMsg("填写标题")
			return
		}else if(isEmpty(secondTitle)){
			showMsg("填写简介")
			return
		}else if(isEmpty(articleContent)){
			showMsg("没写内容→_→")
			return
		}
		checkByAjax("/blog/writeBlog", {'groupId': groupId, 'title': title, 'secondTitle': secondTitle, 'articleContent': articleContent}, true)
	})
	
	$("#quit-login").click(function(){
		removeCookie("loginInfo")
		checkByAjax("/quitLogin", null, true)
	})
})

function enPs(pass){
	return hex_md5(str_md5(b64_md5(pass)))
}

function isEmpty(str){
	if (str == null || str == undefined || str == ""){
		return true
	}else{
		return false
	}
}

/**
 * 登录或注册
 * 
 * @param functionLocation
 * @param dataSource
 * @param async
 * @returns
 */
function checkByAjax(functionLocation, dataSource, async){
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


function showMsg(message){
	$("#aimeeSaidContent").text(message)
	$("#aimeeSaid").modal("show")
}


function updateGroupMenu(data){
	groups = JSON.parse(data).functionValue
	var menu = $(".dropdown-menu")
	menu.children().remove()
	for(var group in groups){
		var a = '<a class="dropdown-item" my-value="' + groups[group].articleGroupId + '" value="' + groups[group].name + '">' + groups[group].name + '</a>'
		menu.append(a)
	}
	var line = $('<div class="dropdown-divider"></div>')
	var appendGroup = $('<a class="dropdown-item"><input type="text" class="form-control" name="" id="addGroupInput" aria-describedby="helpId" placeholder="添加分组……"></a>')
	menu.append(line)
	menu.append(appendGroup)
}

// 删除cookie
function removeCookie(name){
	var date = new Date();
	　　date.setTime(date.getTime() - 1);
	　　var cval = name;
	　　if(cval != null)
	　　document.cookie = name + "=" + cval + ";expires=" + date.toGMTString() + ";path=/";
}

function toBlogPage(data){
	alert(JSON.parse(data).mes)
	window.location.href = "/blog"
}