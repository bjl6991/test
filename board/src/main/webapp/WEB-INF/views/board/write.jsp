<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�Խù� �ۼ�</title>
</head>
<body>
	
	
	<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>
	<form method = "post">
		<label>����</label>
		<input type="text" name = "title"/><br />
		
		<label>�ۼ���</label>
		<input type="text" name="writer"/><br />
		
		<label>����</label>
		<textarea cols="50" rows="5" name="content"></textarea><br />
		
		<button type="submit">�ۼ�</button>
	</form>
</body>
</html>