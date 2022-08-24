<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<table style="width:1000px" class="table table-striped">
  <thead>
   <tr>
   <th class="col-3">NO</th> <!-- 너비에 맞게 제대로 잘 나오게 하는 col-3  -->
   <th class="col-3">SUBJECT</th>
   <th class="col-3">DATE</th>
   <th class="col-3">HIT</th>
   </tr>
  </thead>
  <tbody>
  <c:forEach items="${noticeDB}" var="VO">  <!-- forEach 안에는 EL문을 써줘야한다. el문은 달러 중괄호-->
	 <tr>
	  <td class="col-3">${VO.num}</td>
	  <td class="col-3">${VO.title}</td>	  
	  <td class="col-3">${VO.regDate}</td>
	  <td class="col-3">${VO.hit}</td>
	 </tr>
  </c:forEach>
   
  </tbody>
</table>
</body>

</html>