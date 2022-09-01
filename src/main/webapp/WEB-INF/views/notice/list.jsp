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
<style>
  div { position:relative;}
  .container{width:1000px;}
  .table {left:0; right:0; margin-left:auto; margin-right:auto; } /* 가로 중앙 정렬 */
  .nav {justify-content : center; left:0; right:0; margin-left:auto; margin-right:auto;}
  .button {justify-content:right;}
</style>

<div class="container">
<div style="min-height:452px;">
<table style="width:1000px" class="table">
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
</div>
<nav style= "width:1000px;" aria-label="..." class="nav">
<span class="col-1"></span>
<span class="col-10" style="text-align: center;">
  <ul class="pagination" style="justify-content: center;">
  <c:if test="${pager.pre}">
    <li>
      <a class="page-link" href="./list?pn=${pager.startNum-1}">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">				
	 	<li class="page-item"><a class="page-link" href="./list?pn=${i}">${i}</a></li>			
	</c:forEach>
	
	<c:if test="${pager.next}">	
    <li>
      <a class="page-link" href="./list?pn=${pager.lastNum+1}">Next</a>
    </li>
    </c:if>
  </ul>
  <p align="right">
</p>
</span>
<span class="col-1">
<a href="notice/list/write" type="button">글쓰기</a>
</span>
</nav>

<%-- <div>
	<span class="col-2"></span>
	<span class="col-8">
	<ul>
		<c:if test="${pager.pre}">
			<li><a href="./list?pn=${pager.startNum-1}">prev</a></li>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		
			<li>
				<a href="./list?pn=${i}">${i}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pager.next}">
		<li><a href="./list?pn=${pager.lastNum+1}">next</a></li>		
	</c:if>
	</ul>
	</span>
</div> --%>
</div>
</body>

</html>