function rebuildForm() {
		error = false;
		submitType = "form";
		ids = new Array();
		names = new Array();
		values = new Array();
		str = "";
		pageWidgetId = "pagedefinedDiv";
		
	}
	rebuildForm.prototype.addParam = function(id, name, value) {
		if (!id || !name) {
			alert("程序错误","确认输入参数【id,name,value】:【" + id + "," + name+ "," + value + "】","error");
			error = true;
		}
		ids[ids.length] = id;
		names[names.length] = name;
		values[values.length] = value;
	};
	rebuildForm.prototype.writeForm = function(action,pos) {
		if (!action) {
			alert("程序错误:", "请指定处理action", "error");
			error = true;
			return;
		}
		if (!pos) {
			str = "<form action='" + action
			+ "' id='downloadCommonForm' target='_parent' method='post'>";
		} else{
			str = "<form action='" + action
			+ "' id='downloadCommonForm' target='"+pos+"' method='post'>";
		}
		
		for ( var i = 0; i < ids.length; i++) {
			str = str + "<input type='hidden' name='" + names[i] + "' id='"
					+ ids[i] + "' value='" + values[i] + "' />";
		}
		str = str + "</form>";
	};
	rebuildForm.prototype.submitForm = function() {
		if (ids.length == 0) {
			alert("程序错误:", "不允许无参数提交下载Form,请调用addParam(id,name,value)设置任意参数", "error");
			return;
		}
		if (error) {
			return;
		}
		$('#' + pageWidgetId).html(str);
		$('#downloadCommonForm').submit();
		//alert("提示:", "提交成功", "information");
	};
	i = 0;
	function convertHrefToForm(href){
		if(i >= 1){
			return;	
		}
		i = i+1;
		str = href.split("\?");
		if (str.length!=2) {
			alert("程序错误:", "无法解析路径", "error");
			return;
		}
		action = str[0];
		params = str[1].split("\&");
		form = new rebuildForm();
		for ( var i = 0; i < params.length; i++) {
			param = params[i].split("\=");
			if (param.length != 2 ) {
				alert("程序错误:", "无法解析路径", "error");
				return;
			}
			form.addParam(param[0],param[0],param[1]);
		}
		form.writeForm(action);
		form.submitForm();
		
	}
	function alert(title,msg,type){
		$('#inforMsgTitle').html(title);
		$('#inforMsgContext').html(msg);
		$('#develep-alert').modal();
		
	}
	function submitRequestLink(href){
		window.location.href=href+"?"+new Date().getTime();
	}
	function submitRequestLink(href){
		window.location.href=href+"?"+new Date().getTime();
	}
	function ajax(url,date){
		$.ajax({
				url: url,
				type: "post",
				data: date,			
				success: function(data){
					alert("信息",data);
			    }
		})
	}
	function showCheckMsg(domId,msg){
		var offset = $('#' + domId).offset();
		$('#vld-tooltip').text(msg).show().css({
	       left: offset.left + 10,
	       top: offset.top + $('#'+ domId).outerHeight() + 10
	     });
	}