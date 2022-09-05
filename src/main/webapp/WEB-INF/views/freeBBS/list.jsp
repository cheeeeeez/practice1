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
  .table {left:0; right:0; margin-left:auto; margin-right:auto; } 
  .nav {justify-content : center; left:0; right:0; margin-left:auto; margin-right:auto;}
  .button {justify-content:right;}
</style>

<div class="container">
<div style="min-height:452px;">
<table style="width:1000px" class="table">
  <thead>
   <tr>
   <th class="col-3">NO</th> 
   <th class="col-3">SUBJECT</th>
   <th class="col-3">DATE</th>
   <th class="col-3">HIT</th>
   </tr>
  </thead>
  <tbody>
  <c:forEach items="${freeBBSDB}" var="VO">  <!-- controller랑 이름 맞춰줘야 한다. -->
	 <tr>
	  <td class="col-3">${VO.num}</td>
	  <td class="col-3"><a href="./detail?num=${VO.num}">${VO.title}</a></td>	  
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
<a href="./add" type="button">글쓰기</a>
</span>
</nav>