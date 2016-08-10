<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href='<%=request.getParameter("webdomain")%>'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>99金融</title>
<script src="filesource/assets/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		var opt = '<%=request.getParameter("opt")%>';
		switch (opt) {
		case '0':
			$('#index').submit();
			break;
		case '9':
			$('#login').submit();
			break;
		case '8':
		    $('#cptl').submit();
		    break;
		default:
			$('#error').submit();
			break;
		}
	});
</script>
<body>
	<form id="index" action="prdct/index" method="post">
		 <input type="hidden" name="authKey" value='<%=request.getParameter("authKey")==null?"hello world!":request.getParameter("authKey")%>'/>
	</form>
	<form id="login" action="usrbs/toLgn" method="post">
		 <input type="hidden" name="authKey" value='<%=request.getParameter("authKey")==null?"hello world!":request.getParameter("authKey")%>'/>
	</form>
	<form id="cptl" action="usrbs/toCptl" method="post">
		 <input type="hidden" name="authKey" value='<%=request.getParameter("authKey")==null?"hello world!":request.getParameter("authKey")%>'/>
	</form>
	<form id="error" action="thr/to406" method="post">
		 <input type="hidden" name="authKey" value='<%=request.getParameter("authKey")==null?"hello world!":request.getParameter("authKey")%>'/>
	</form>
</body>
</html>