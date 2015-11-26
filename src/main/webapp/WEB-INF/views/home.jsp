<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>HomePage</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/myscript.js"></script>

</head>
<body>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<form id="test">
  <input id="input" type="text" name="name">
  <button type="submit">submit</button>
</form>


<script type="text/javascript">
   $('#test').submit(function(e){
	  e.preventDefault();
	  var name = $('input').val();
	  console.log(name);
	  
	  $.ajax({
		 url:'${pageContext.request.contextPath}/test',
		 type:'POST',
		 data:{
			 name: name
		 },
		 success: function(data){
			 console.log(data);
		 }
		 
	  });
   });
</script>
</body>


</html>